package com.seleniummaster.magento.frontendpages;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class AccountInformationPage extends TestBasePage {

        //A user should be able to edit and view account information

        WebDriver driver;//open browser&close browser
        TestUtility utility;//explicit wait visible elements/sleep/screen shot/waitForAlertPresent

        @FindBy(id = "firstname")
        WebElement FirstNameTextBox;

        @FindBy(id = "lastname")
        WebElement LastNameTextBox;

        @FindBy(css = "#email")
        WebElement EmailAddressTextBox;

        @FindBy(id = "current_password")
        WebElement CurrentPasswordTextBox;

        @FindBy(name = "change_password")
        WebElement ChangePasswordCheckBox;

        @FindBy(id = "password")
        WebElement NewPasswordTextBox;

        @FindBy(id = "confirmation")
        WebElement ConfirmNewPasswordTextBox;

        @FindBy(css = ".success-msg")
        WebElement SuccessMessage;

    public AccountInformationPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);

    }

    //Enter First Name Method
        void EnterFirstName(String FirstName) {
           utility.waitForElementPresent(FirstNameTextBox);
            FirstNameTextBox.sendKeys(FirstName);
        }

        //Enter Last Name method


        void EnterLastName(String LastName) {
            utility.waitForElementPresent(LastNameTextBox);
            LastNameTextBox.sendKeys(LastName);
        }

        //Enter Email Method
        public void EnterEmailAddress(String Email) {
            utility.waitForElementPresent(EmailAddressTextBox);
            EmailAddressTextBox.sendKeys(Email);
        }

        //CurrentPasswordTextBox;
        public void EnterCurrentPassword(String CurrentPassword) {
            utility.waitForElementPresent(CurrentPasswordTextBox);
            CurrentPasswordTextBox.sendKeys(CurrentPassword);
        }

        //ChangePasswordCheckBox;
        public void ClickChangePasswordBox() {
            utility.waitForElementPresent(ChangePasswordCheckBox);
            ChangePasswordCheckBox.click();
        }

        //NewPasswordTextBox;
        public void EnterNewPassword(String NewPassword) {
            utility.waitForElementPresent(NewPasswordTextBox);
            NewPasswordTextBox.sendKeys(NewPassword);
        }

        //ConfirmNewPasswordTextBox;
        public void EnterConfirmNewPassword(String NewPassword) {
            utility.waitForElementPresent(ConfirmNewPasswordTextBox);
            ConfirmNewPasswordTextBox.sendKeys(NewPassword);
        }

        //SuccessMessage;
        public boolean verifySuccess() {
            utility.waitForElementPresent(SuccessMessage);
            return SuccessMessage.isDisplayed();
        }

        //combine all methods from current page
        public boolean UserEditAccountInformation(String FirstName, String LastName, String Email, String Password) {
            Random r = new Random(1000);
            EnterFirstName(FirstName + r);
            EnterLastName(LastName + r);
            EnterEmailAddress(Email);
            EnterCurrentPassword(Password);
            ClickChangePasswordBox();
            EnterNewPassword(Password);
            EnterConfirmNewPassword(Password);
            return verifySuccess();
        }
    }






