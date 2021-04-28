package magento.publicusermodule;

import magento.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.text.Utilities;

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
        utility.waitForElementPresent(firstNameField);
        firstNameField.sendKeys(firstName);
    }

    //Enter Last name Method
    public void enterLastName(String lastName) {
        utility.waitForElementPresent(lastNameField);
        lastNameField.sendKeys(lastName);
    }

    //Enter Email Method
    public void enterEmailAddress(String email) {
        utility.waitForElementPresent(emailAddress);
        emailAddress.sendKeys(email);
    }

    public void enterPassword(String password) {
        utility.waitForElementPresent(passwordField);
        passwordField.sendKeys(password);
    }

    public void enterConfirmationPassword(String password) {
        utility.waitForElementPresent(confirmPasswordField);
        confirmPasswordField.sendKeys(password);
    }

    public void clickRegister() {
        utility.waitForElementPresent(registerButton);
        registerButton.click();
    }
}