package com.unitedcoder.magento.frontend;

import com.unitedcoder.magento.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrontEndLoginPage {
    WebDriver driver;
    String configFile="config.properties";
    TestUtility utility;
    @FindBy(xpath = "a[@title='My Account']")
    WebElement myAccountLink;
    @FindBy(xpath = "a[@title='Log In']")
    WebElement loginLink;
    @FindBy(xpath = "span[text()='Account'and@class='label']")
    WebElement accountDropDownList;
    @FindBy(name="login[username]")
    WebElement emailAddressField;
    @FindBy(id="pass")
    WebElement passwordField;
    @FindBy(name = "send")
    WebElement loginbutton;


    public FrontEndLoginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }
    public void  enterEmail(String EmailAddress){
        utility.waitForElementPresent(emailAddressField);
        emailAddressField.sendKeys(EmailAddress);
    }
    public void  enterPassword(String Password){
        utility.waitForElementPresent(passwordField);
        passwordField.sendKeys(Password);
    }
    public void  clickLoginButton(){
        utility.waitForElementPresent(loginbutton);
        loginbutton.click();
    }
    public void clickAccountDropdownList(){
        utility.waitForElementPresent(accountDropDownList);
        accountDropDownList.click();
    }
    public  void clickMyAccountLink(){
        utility.waitForElementPresent(myAccountLink);
        myAccountLink.click();
    }

    public void loginLink(){
        utility.waitForElementPresent(loginLink);
        loginLink.click();
    }

    public void loginUser(String EmailAddress, String password){
        enterEmail(EmailAddress);
        enterPassword(password);
        clickLoginButton();
    }
    
}

