package com.seleniummaster.magento.frontendpages;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrontEndLoginPage extends TestBasePage {
    //    WebDriver driver;
//    String configFile="config.properties";
//    TestUtility utility;
    @FindBy(name="login[username]")
    WebElement emailAddressField;
    @FindBy(id="pass")
    WebElement passwordField;
    @FindBy(name = "send")
    WebElement loginButton;
//    @FindBy(xpath = "a[@class='label']")
//    WebElement accountDropDownList;
//    @FindBy(xpath = "a[@title=\"My Account\"]")
//    WebElement myAccountLink;
//    @FindBy(xpath = "a[@title=\"My Wishlist\"]")
//    WebElement myWishListLink;
//    @FindBy(xpath = "a[@title=\"My Cart\"]")
//    WebElement myCartLink;
//    @FindBy(xpath = "a[@title=\"Checkout\"]")
//    WebElement checkOutLink;
//    @FindBy(xpath = "//a[@title=\"Register\"]")
//    WebElement registerLink;
//    @FindBy(xpath = "//a[@title=\"Log In\"]")
//    WebElement loginLink;

    public FrontEndLoginPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void  enterEmail(String EmailAddress){
        TestUtility.waitForElementPresent(emailAddressField);
        emailAddressField.sendKeys(EmailAddress);
    }
    public void  enterPassword(String Password){
        TestUtility.waitForElementPresent(passwordField);
        passwordField.sendKeys(Password);
    }
    public void clickLoginbutton(){
        TestUtility.waitForElementPresent(loginButton);
        loginButton.click();
    }
    public void loginUser(String EmailAddress, String password){
        enterEmail(EmailAddress);
        enterPassword(password);
        clickLoginbutton();
    }
}
