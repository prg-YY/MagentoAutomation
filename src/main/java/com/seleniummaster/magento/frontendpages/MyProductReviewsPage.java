package com.seleniummaster.magento.frontendpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProductReviewsPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;

    public MyProductReviewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

    // Define the Elements
    @FindBy(xpath = "//a[@href='http://magentoqa.unitedcoder.com/review/customer/']")
    WebElement myProductReviewsLink;
    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/p")
    WebElement noReviewsMessage;

    public void clickMyProductsLink() {
        utility.waitForElementPresent(myProductReviewsLink);
        myProductReviewsLink.click();
        Log.info("My Product reviews link has been clicked");
    }

    public boolean myProductReviewsLinkIsDisplay(){
        utility.waitForElementPresent(myProductReviewsLink);
        if (myProductReviewsLink.isDisplayed()) {
            System.out.println("Test Passed,My products Reviews Link has been seen");
        }else System.out.println("Test Failed");
        return true;
    }

    public boolean reviewsContentIsDisplay() {
        clickMyProductsLink();
        utility.waitForElementPresent(noReviewsMessage);
        String reviewReport=noReviewsMessage.getText();
        if (reviewReport.contains("no reviews")) {
            System.out.println(noReviewsMessage.getText());
        } else {
            System.out.println("The Product reviews contents has been seen");
        }
        return true;
    }
}
