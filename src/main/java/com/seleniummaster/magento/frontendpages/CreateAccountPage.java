package com.seleniummaster.magento.frontendpages;

import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class CreateAccountPage {
    WebDriver driver;
    TestUtility utility;
    @FindBy(id = "firstname")
    WebElement firstNameField;
    @FindBy(id = "lastname")
    WebElement lastNameField;
    @FindBy(css = "#email_address")
    WebElement emailAddress;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "confirmation")
    WebElement confirmPasswordField;
    @FindBy(xpath = "//*[@class=\"button\"]/span/span")
    WebElement registerButton;
    @FindBy(xpath = "//*[@class=\"success-msg\"]")
    WebElement successMessage;

    //page factory
    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

    //Enter First name Method
    public void enterFirstName(String firstName) {
        utility.waitForAlertPresent(firstNameField);
        firstNameField.sendKeys(firstName);
    }

    //Enter Last name Method
    public void enterLastName(String lastName) {
        utility.waitForAlertPresent(lastNameField);
        lastNameField.sendKeys(lastName);
    }

    //Enter Email Method
    public void enterEmailAddress(String email) {
        utility.waitForAlertPresent(emailAddress);
        emailAddress.sendKeys(email);
    }

    public void enterPassword(String password) {
        utility.waitForAlertPresent(passwordField);
        passwordField.sendKeys(password);
    }

    public void enterConfirmationPassword(String password) {
        utility.waitForAlertPresent(confirmPasswordField);
        confirmPasswordField.sendKeys(password);
    }

    public void clickRegister() {
        utility.waitForAlertPresent(registerButton);
        registerButton.click();
    }
    public boolean verifySuccess(){
        utility.waitForAlertPresent(successMessage);
        return successMessage.isDisplayed();
    }
    //combine all methods from current page
    public boolean userCreateAccount(String firstName, String lastName, String email, String password){
        Random r=new Random(1000);
        enterFirstName(firstName+r);
        enterLastName(lastName+r);
        enterEmailAddress(email);
        enterPassword(password);
        enterConfirmationPassword(password);
        clickRegister();
        return verifySuccess();
    }
}
