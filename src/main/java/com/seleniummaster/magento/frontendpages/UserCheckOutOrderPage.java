package com.seleniummaster.magento.frontendpages;

import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserCheckOutOrderPage {
    WebDriver driver;
    TestUtility utility;

    @FindBy(linkText = "Checkout")
    WebElement checkOutLink;
    @FindBy(xpath = "//div[@class=\"buttons-set\"]/button/span/span")
    WebElement continue1;
    @FindBy(id = "//div[@id=\"shipping-method-buttons-container\"]/button/span/span")
    WebElement continue3;
    @FindBy(xpath = "//*[@id=\"dt_method_checkmo\"]/label")
    WebElement moneyOrderCheckBox;
    @FindBy(xpath = "//div[@id=\"payment-buttons-container\"]/button/span/span")
    WebElement continue4;
    @FindBy(id = "//div[@id=\"review-buttons-container\"]/button/span/span")
    WebElement placeOrderButton;
    @FindBy(xpath = "//div[@class=\"page-title\"]/h1")
    WebElement orderVerifyMessage;


    //page factory
    public UserCheckOutOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }


    //Method for each action

    public void clickChekOutLink(){
        utility.waitForAlertPresent(checkOutLink);
        checkOutLink.click();
    }
    public void clickOnContinue1(){
        utility.waitForAlertPresent(continue1);
        continue1.click();
    }
    public void clickOnContinue3(){
        utility.waitForAlertPresent(continue3);
        continue3.click();
    }
    public void clickOnMoneyOrderCheckBox(){
        utility.waitForAlertPresent(moneyOrderCheckBox);
        moneyOrderCheckBox.click();
    }
    public void clickOnContinue4(){
        utility.waitForAlertPresent(continue4);
        continue4.click();
    }
    public void clickOnPlaceOrderButton(){
        utility.waitForAlertPresent(placeOrderButton);
        placeOrderButton.click();
    }
    public boolean verifyOrderMassage(){
        utility.waitForAlertPresent(orderVerifyMessage);
        return orderVerifyMessage.isDisplayed();

    }

}
