package com.seleniummaster.magento.backendpages.customerpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    ManageCustomerDashboardPage customerDashboardPage;


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


    public AddCustomerPage(WebDriver driver) {
        this.driver=TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility=new TestUtility(driver);
    }


    public void enterFirstName(){
        utility.waitForElementPresent(firstNameInputBox);
        firstNameInputBox.sendKeys(prop.getProperty("yusufFirstName"));
        Log.info("First name has entered");
    }
    public void enterLastName(){
        utility.waitForElementPresent(lastNameInputBox);
        lastNameInputBox.sendKeys(prop.getProperty("yusufLastName"));
        Log.info("Last name has entered ");
    }
    public void enterEmail(){
        utility.waitForElementPresent(emailInputBox);
        emailInputBox.sendKeys(prop.getProperty("ca-email"));
        Log.info("email has entered ");
    }
    public void enterPassword(){
        utility.waitForElementPresent(passwordInputBox);
        passwordInputBox.sendKeys(prop.getProperty("password"));
        Log.info("password has entered ");
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
    public void addNewCustomer(){
        customerDashboardPage=new ManageCustomerDashboardPage(driver);
        customerDashboardPage.clickAddNewCustomerButton();
        utility.sleep(1);
        enterFirstName();
        utility.sleep(1);
        enterLastName();
        utility.sleep(2);
        enterEmail();
        utility.sleep(1);
        enterPassword();
        utility.sleep(1);
        clickSaveCustomerLink();
        utility.sleep(2);
    }
}
