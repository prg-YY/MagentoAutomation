package com.seleniummaster.magento.frontendpages;

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
    @FindBy(id = "//*[@id=\"shipping-method-buttons-container\"]/button/span/span")
    WebElement continue3;
    @FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/button/span/span")
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

    }
    public void clickChekOutLink(){
        utility.waitForElementPresent(checkOutLink);
        checkOutLink.click();
    }
    public void clickOnContinue1(){
        utility.waitForElementPresent(continue1);
        continue1.click();
    }
    public void clickOnContinue2(){
        utility.waitForElementPresent(continue2);
        continue2.click();
    }
    public void clickOnContinue3(){
        utility.waitForElementPresent(continue3);
        continue3.click();
    }
    public void clickOnMoneyOrderCheckBox(){
        utility.waitForElementPresent(moneyOrderCheckBox);
        moneyOrderCheckBox.click();
    }
    public void clickOnContinue4(){
        utility.waitForElementPresent(continue4);
        continue4.click();
    }
    public void clickOnPlaceOrderButton(){
        utility.waitForElementPresent(placeOrderButton);
        placeOrderButton.click();
    }
    public boolean verifyOrderMassage(){
        utility.waitForElementPresent(orderVerifyMessage);
        return orderVerifyMessage.isDisplayed();

    }
    public void checkoutOrderM(WebDriver driver){
        clickChekOutLink();
        clickOnContinue1();
        clickOnContinue3();
        clickOnContinue4();
        clickOnMoneyOrderCheckBox();
        clickOnPlaceOrderButton();
        verifyOrderMassage();


    }
}
