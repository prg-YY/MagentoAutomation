package com.seleniummaster.magento.frontendpages;


import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyDownloadableProductsPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    @FindBy(xpath = "//div[@class=\"block-content\"]/ul/li[12]/a")
    WebElement myDownloadableProductsLink;

    //combine Driver
    public MyDownloadableProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

    // method for click
    public void clickOnMyDownloadableProductsLink() {
        utility.waitForElementPresent(myDownloadableProductsLink);
        utility.sleep(3);
        myDownloadableProductsLink.click();
    }

    //method for view myDownloadable products page
    public boolean viewMyDownloadableProducts() {
        clickOnMyDownloadableProductsLink();
        List<WebElement> downloadableProductsList = driver
                .findElements(By.xpath("//div[@class=\"my-account\"]/table/tbody/tr"));
        for (int i = 1; i <= downloadableProductsList.size(); i++) {
            if (i > 0) {
                System.out.println(" Test past .my Downloadable Products already exist");

                Log.info("Test Passed");
            } else {
                System.out.println(" there is no existing products");

                Log.info("Test Failed");
            }
        }
        return true;
    }
}








