package com.seleniummaster.magento.frontendpages;
//A user should be able to edit and view account information

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class AccountInformationPage extends TestBasePage {

    WebDriver driver;//open browser&close browser
    TestUtility utility;//explicit wait visible elements/sleep/screen shot/waitForAlertPresen

    @FindBy(xpath = "//*[@class=\"block block-account\"]/div[2]/ul/li[2]/a")
    WebElement accountInformationLink;

    @FindBy(id = "firstname")
    WebElement FirstNameTextBox;

    @FindBy(id = "firstname")
    WebElement ClearFirstName2;


    @FindBy(id = "firstname")
    WebElement FirstNameBox;


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
    @FindBy(xpath = "//div[@class=\"buttons-set\"]/button/span/span")
    WebElement saveButton;

    @FindBy(css = ".success-msg")
    WebElement SuccessMessage;

    public AccountInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);

    }

    //Enter First Name Method
    public void clickOnAccountInfo() {
        utility.waitForElementPresent(accountInformationLink);
        accountInformationLink.click();
    }
    public void ClearFirstName(){
        utility.waitForElementPresent(ClearFirstName2);
       ClearFirstName2.clear();
    }

    public void EnterFirstName(String FirstName) {
        utility.waitForElementPresent(FirstNameTextBox);
        FirstNameTextBox.sendKeys(FirstName);
    }

    //Enter Last Name method


    public void EnterLastName(String LastName) {
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

    public void clickSaveButton() {
        utility.waitForElementPresent(saveButton);
        saveButton.click();
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






