package com.seleniummaster.magento.backendpages.customerpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage extends TestBasePage {

    WebDriver driver;
    TestUtility utility;

    @FindBy(xpath = "//button[@title=\"Add New Customer\"]")
    WebElement addNewCustomerBox;
    @FindBy(name = "account[firstname]")
    WebElement firstNameInputBox;
    @FindBy(name = "account[lastname]")
    WebElement lastNameInputBox;
    @FindBy(name = "account[email]")
    WebElement emailInputBox;
    @FindBy(name = "account[password]")
    WebElement passwordInputBox;
    @FindBy(xpath = "//button[@class=\"scalable save\"]")
    WebElement saveCustomerLink;
    @FindBy(xpath = "//div[@id=\"messages\"]/ul/li/ul/li/span")
    WebElement successMessage;


    public CustomerPage(WebDriver driver) {
        this.driver=TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility=new TestUtility(driver);
    }

    public void clickOnAddCustomerLink(){
        utility.waitForElementPresent(addNewCustomerBox);
        addNewCustomerBox.click();
        Log.info("Add new customer link clicked");
    }
    public void enterFirstName(String firstName){
        utility.waitForElementPresent(firstNameInputBox);
        firstNameInputBox.sendKeys(firstName);
        Log.info("First name has been sent as " + firstName);
    }
    public void enterLastName(String lastName){
        utility.waitForElementPresent(lastNameInputBox);
        lastNameInputBox.sendKeys(lastName);
        Log.info("Last name has been sent as " + lastName);
    }
    public void enterEmail(String email){
        utility.waitForElementPresent(emailInputBox);
        emailInputBox.sendKeys(email);
        Log.info("email has been sent as " + email);
    }
    public void enterPassword(String password){
        utility.waitForElementPresent(passwordInputBox);
        passwordInputBox.sendKeys(password);
        Log.info("password has been sent as " + password);
    }
    public void clickSaveCustomerLink(){
        utility.waitForElementPresent(saveCustomerLink);
        saveCustomerLink.click();
        Log.info("Save customer link clicked");
    }
    public boolean verifySuccessMessage(){
        utility.waitForElementPresent(successMessage);
        return successMessage.isDisplayed();
    }
public boolean addNewCustomer(String firstname, String lastname, String emailAddress, String password){
        clickOnAddCustomerLink();
        enterFirstName(firstname);
        enterLastName(lastname);
        enterEmail(System.currentTimeMillis()+emailAddress);
        enterPassword(password);
        clickSaveCustomerLink();
   return verifySuccessMessage();

}

}