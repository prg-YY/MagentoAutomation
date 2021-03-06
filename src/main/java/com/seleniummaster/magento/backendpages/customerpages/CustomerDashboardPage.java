package com.seleniummaster.magento.backendpages.customerpages;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerDashboardPage extends com.seleniummaster.magento.utility.TestBasePage {
    WebDriver driver;

    TestUtility utility;
    @FindBy(xpath = "//span[text()='Customers']")
    WebElement customersLink;
    @FindBy(xpath = "//a[@class='link-logout']")
    WebElement LogoutButton;
    @FindBy(xpath = "//span[text()='Manage Customers']")
    WebElement  ManageCustomerLink;
    @FindBy(xpath = "//span[text()='Customer Groups']")
    WebElement CustomerGroupLink;
    @FindBy(xpath = "(//span[text()='Add New Customer'])[1]")
    WebElement AddNewCustomerButton;
    @FindBy(xpath = "//button[@title='Add New Customer']")
    WebElement NameTextBox;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchLink;
    @FindBy(xpath = " //div[@class='header-top']/a")
    WebElement magentoLog;

    public CustomerDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }
    public void cLickLogoutButton(){
        utility.waitForElementPresent(LogoutButton);
        LogoutButton.click();
    }
    public void clickCustomersLink(){
        utility.waitForElementPresent(customersLink);
        customersLink.click();
    }

    public void clickManageCustomerLink(){
        utility.waitForElementPresent(ManageCustomerLink);
        ManageCustomerLink.click();
    }

    public void clickCustomerGroupLink(){
        utility.waitForElementPresent(CustomerGroupLink);
        CustomerGroupLink.click();
    }
    public void clickAddNewCustomerButton(){
        utility.waitForElementPresent(AddNewCustomerButton);
        AddNewCustomerButton.click();
    }
    public void enterName(String CustomerName){
        utility.waitForElementPresent(NameTextBox);
        NameTextBox.sendKeys(CustomerName);

    }
    public void clickSearchLink(){
        utility.waitForElementPresent(searchLink);
        searchLink.click();
    }
    public void goToDashboardPage(){
        utility.waitForElementPresent(magentoLog);
        magentoLog.click();
        utility.sleep(2);
    }
}
