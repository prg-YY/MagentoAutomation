package com.seleniummaster.magento.frontendpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWishListPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;


    @FindBy(css = "a[title=\"My Wishlist (1 item)\"]")
    WebElement myWishList;
    @FindBy(css = "div[class=\"page-title title-buttons\"]")
    WebElement successMessage;

    public MyWishListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility=new TestUtility(driver);

    }
    public void clickMyWishList(){
        utility.waitForElementPresent(myWishList);
        myWishList.click();
        Log.info("My Wish List Clicked");
    }
    public boolean verifyMyWishList(){
        utility.waitForElementPresent(successMessage);
        Log.info("My Wish List Displayed");
        return successMessage.isDisplayed();
    }
}
