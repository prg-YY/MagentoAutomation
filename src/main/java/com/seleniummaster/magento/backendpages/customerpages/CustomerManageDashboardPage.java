package com.seleniummaster.magento.backendpages.customerpages;

import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerManageDashboardPage {
    WebDriver driver;
    String ConfigFile = "config.properties";
    TestUtility utility;
    @FindBy(xpath = "a[@class='link-logout']")
    WebElement LogoutButton;
    @FindBy(xpath = "span[text()='Manage Customers']")
    WebElement  ManageCustomerLink;
    @FindBy(xpath = "span[text()='Customer Groups']")
    WebElement CustomerGroupLink;
    @FindBy(xpath = "button[@title='Add New Customer']")
    WebElement AddNewCustomerButton;
    @FindBy(css = "input[type=\"text\"][id=\"customerGrid_filter_name\"]")
    WebElement NameTextBox;
    @FindBy(css = "button[title='Submit'][type='button']")
    WebElement searchLink;

    public CustomerManageDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }
    public void cLickLogoutButton(){
        utility.waitForElementPresent(LogoutButton);
        LogoutButton.click();
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


}
