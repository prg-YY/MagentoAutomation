package com.seleniummaster.magento.frontendpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOrderPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    @FindBy(xpath = "//div[@class=\"account-cart-wrapper\"]/a/span")
    WebElement accountTag;
    @FindBy(linkText = "Checkout")
    WebElement checkOutLink;
    @FindBy(xpath = "//div[@class=\"buttons-set\"]/button/span/span")
    WebElement continue1;
    @FindBy(xpath = "//div[@id=\"shipping-buttons-container\"]/button")
    WebElement continue2;
    @FindBy(linkText = "//*[@id=\"shipping-method-buttons-container\"]/button/span/span")
    WebElement continue3;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/ol/li[3]/div[2]/form/div[3]/button")
    WebElement moneyOrderCheckBox;
    @FindBy(xpath = "//div[@id=\"payment-buttons-container\"]/button/span/span")
    WebElement continue4;
    @FindBy(id = "//div[@id=\"review-buttons-container\"]/button/span/span")
    WebElement placeOrderButton;
    @FindBy(xpath = "//div[@class=\"page-title\"]/h1")
    WebElement orderVerifyMessage;


    //page factory
    public CheckOutOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility=new TestUtility(driver);

    }


    //Method for each action
    public void clickAccountTag(){
        utility.waitForElementPresent(accountTag);
        accountTag.click();
        Log.info("Account Tag clicked");

    }
    public void clickChekOutLink(){
        utility.waitForElementPresent(checkOutLink);
        checkOutLink.click();
        Log.info("Check Out Link clicked");
    }
    public void clickOnContinue1(){
        utility.waitForElementPresent(continue1);
        continue1.click();
        Log.info("Continue1 clicked");
    }
    public void clickOnContinue2(){
        utility.waitForElementPresent(continue2);
        continue2.click();
        Log.info("Continue2 clicked");
    }
    public void clickOnContinue3(){
        utility.waitForElementPresent(continue3);
        continue3.click();
        Log.info("Continue3 clicked");
    }
    public void clickOnMoneyOrderCheckBox(){
        utility.waitForElementPresent(moneyOrderCheckBox);
        moneyOrderCheckBox.click();
        Log.info("Money Order Check Box clicked");
    }
    public void clickOnContinue4(){
        utility.waitForElementPresent(continue4);
        continue4.click();
        Log.info("Continue4 clicked");
    }
    public void clickOnPlaceOrderButton(){
        utility.waitForElementPresent(placeOrderButton);
        placeOrderButton.click();
        Log.info("Place order button clicked");
    }
    public boolean verifyOrderMassage(){
        utility.waitForElementPresent(orderVerifyMessage);
        return orderVerifyMessage.isDisplayed();

    }
    public void checkoutOrderM(WebDriver driver){
        clickAccountTag();
        clickChekOutLink();
        clickOnContinue1();
        clickOnContinue3();
        clickOnContinue4();
        clickOnMoneyOrderCheckBox();
        clickOnPlaceOrderButton();
        verifyOrderMassage();


    }
}
