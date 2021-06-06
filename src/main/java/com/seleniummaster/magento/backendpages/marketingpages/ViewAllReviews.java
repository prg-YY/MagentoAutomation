package com.seleniummaster.magento.backendpages.marketingpages;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ViewAllReviews extends TestBasePage {
    TestUtility utility;

    @FindBy(xpath = "//*[text()=\"Catalog\"]")
    WebElement catalogMenu;

    @FindBy(xpath = "//span[text()=\"Reviews and Ratings\"]")
    WebElement reviewsAndRatingsLink;

    @FindBy(xpath = "//span[text()=\"Customer Reviews\"]")
   WebElement customerReviewsLink;

    @FindBy(xpath = "//span[text()=\"All Reviews\"]")
    WebElement allReviewsLink;

    @FindBy(xpath = "//*[@id=\"page:main-container\"]/div[3]")
    WebElement reviewsTable;

    @FindAll(@FindBy(xpath = "//*[@id=\"reviwGrid_table\"]/tbody"))
    List<WebElement> reviewsTableList;

    public ViewAllReviews() {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);

    }

public void clickCatalogMenu(){
        utility.waitForElementPresent(catalogMenu);
        catalogMenu.click();
        utility.sleep(2);
}

public void clickReviewsAndRatingsLink(){
        utility.waitForElementPresent(reviewsAndRatingsLink);
        reviewsAndRatingsLink.click();
        utility.sleep(2);
}

public void clickCustomerReviewsLink(){
        utility.waitForElementPresent(customerReviewsLink);
        customerReviewsLink.click();
        utility.sleep(2);
}

public void clickAllReviewsLink(){
        utility.waitForElementPresent(allReviewsLink);
        allReviewsLink.click();
        utility.sleep(2);
}

public boolean verifyReviewsList(){
        utility.waitForElementPresent(reviewsTable);
        if (reviewsTableList.size()>1){
            System.out.println("reviewed");
        }
        return true;
}



}
