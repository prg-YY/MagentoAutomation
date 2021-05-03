package com.seleniummaster.magento.frontendpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrontEndLoginPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;

    @FindBy(name="login[username]")
    WebElement emailAddressField;
    @FindBy(id="pass")
    WebElement passwordField;
    @FindBy(name = "send")
    WebElement loginButton;


    public FrontEndLoginPage(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);

    }
    public void  enterEmail(String EmailAddress){
        utility.waitForElementPresent(emailAddressField);
        emailAddressField.sendKeys(EmailAddress);
        Log.info("Email has been sent as " + EmailAddress);
    }
    public void  enterPassword(String Password){
        utility.waitForElementPresent(passwordField);
        passwordField.sendKeys(Password);
        Log.info("Password has been sent as " + Password);
    }
    public void clickLoginButton(){
        utility.waitForElementPresent(loginButton);
        loginButton.click();
        Log.info("Login Button clicked " + loginButton);
    }
    public void loginUser(String EmailAddress, String password){
        enterEmail(EmailAddress);
        enterPassword(password);
        clickLoginButton();

    }
}
