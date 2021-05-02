package com.seleniummaster.magento.backendpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BackEndLogin extends TestBasePage {
    WebDriver driver;
    TestUtility utility;

    @FindBy(name = "login[username]")
    WebElement userNameField;
    @FindBy(name = "login[password]")
    WebElement passwordField;
    @FindBy(xpath = "//*[@class=\"form-button\"]")
    WebElement loginButton;

    public BackEndLogin(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);

    }

    public void  enterUserName(String userName){
        utility.waitForElementPresent(userNameField);
        userNameField.sendKeys(userName);
        Log.info("User Name has been sent as " + userName);
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
    public void backEndLogin(String userName, String password){
        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();

    }


}
