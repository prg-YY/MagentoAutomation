package com.seleniummaster.magento.frontendpages;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountInformationPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    String ConfigFile = "config.properties";
    @FindBy(id = "firstname")
    WebElement firstNameField;
    @FindBy(id = "lastname")
    WebElement lastNameField;
    @FindBy(xpath="//input[@name=\"current_password\" and @id=\"current_password\"]")
    WebElement currentPasswordField;
    @FindBy(xpath = "//span[text()='Save']")
    WebElement SaveButton;
    @FindBy(xpath = "//span[text()='The account information has been saved.']")
    WebElement successfulSaveMessage;
    @FindBy(id = "password")
    WebElement newPasswordField;
    @FindBy(id = "confirmation")
    WebElement confirmNewPasswordField;
    @FindBy(xpath = "//*[text()='Save']")
    WebElement saveButtonLink;
    @FindBy(id = "change_password")
    WebElement CheckBox;
    public AccountInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }
    public void clickCheckBox() {
        utility.waitForElementPresent(CheckBox);
        utility.sleep(3);
        CheckBox.click();
    }
    public void enterCurrentPassword(String password) {
        utility.waitForElementPresent(currentPasswordField);
        currentPasswordField.sendKeys(password);
    }
    public void enterNewPassword(String newPassword) {
        utility.waitForElementPresent(newPasswordField);
        newPasswordField.sendKeys(newPassword);
    }
    public void enterConfirmNewPasswordField(String newPassword) {
        utility.waitForElementPresent(confirmNewPasswordField);
        confirmNewPasswordField.sendKeys(newPassword);
    }
    public void clickSaveButton() {
        utility.waitForElementPresent(SaveButton);
        SaveButton.click();
    }
    public boolean verifySuccessfulMessage() {
        utility.waitForElementPresent(successfulSaveMessage);
        return successfulSaveMessage.isDisplayed();
    }
    public void changePassword() {
        enterCurrentPassword(prop.getProperty("EnterCurrentPassword"));
        enterNewPassword(prop.getProperty("EnterCurrentPassword"));
        enterConfirmNewPasswordField(prop.getProperty("EnterCurrentPassword"));
        clickSaveButton();
        verifySuccessfulMessage();
    }}

