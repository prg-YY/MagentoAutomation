package com.seleniummaster.magento.backendpages.customerpages;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UpdateCustomerGroupPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    @FindBy(xpath = "//*[@id=\"nav\"]/li/a/span")
    WebElement customerLink;
    @FindBy(xpath = "//*[@id=\"nav\"]/li/ul/li[2]/a/span")
    WebElement customerGroupLink;
    @FindBy(xpath = "//span[text()='Add New Customer Group']")
    WebElement addCustomerGroupLink;
    @FindBy(id = "customer_group_code")
    WebElement cus_GroupNameField;
    @FindBy(id = "tax_class_id")
    WebElement taxClassSelection;
    @FindBy(xpath = "//span[text()='Save Customer Group']")
    WebElement saveCustomerGroup;
    @FindBy(xpath = "//*[@id=\"messages\"]/ul/li")
    WebElement successMessage;
    // for Update Customer

    @FindBy( xpath= "//*[@class=\"field-100\"]/input")
    WebElement cus_SearchBox;
    @FindBy( xpath= "//span[text()='Search']")
    WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"customerGroupGrid_table\"]/tbody/tr")
    WebElement customerGroupRow;
    ////div[@class="hor-scroll"]/table/tbody/tr


    //combine driver


    public UpdateCustomerGroupPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }

    //method for each action
    public void clickOnCustomersLink(){
        utility.waitForElementPresent(customerLink);
        customerLink.click();
    }
    public void clickOnCustomerGroupLink(){
        utility.waitForElementPresent(customerGroupLink);
        customerGroupLink.click();
    }
    public void clickOnAddCustomerGroup(){
        utility.waitForElementPresent(addCustomerGroupLink);
        addCustomerGroupLink.click();
    }
    public void enterCustomerGroupName(String groupName){
        utility.waitForElementPresent(cus_GroupNameField);
        cus_GroupNameField.sendKeys(groupName);
    }
    public void taxClassSelection(){
        utility.waitForElementPresent(taxClassSelection);
        Select selectGeneral=new Select(taxClassSelection);
        selectGeneral.selectByVisibleText(TaxClassType.General.name());
    }
    public void clickOnSaveButton(){
        utility.waitForElementPresent(saveCustomerGroup);
        saveCustomerGroup.click();
    }
    public boolean successMessageDisplayed(){
        utility.waitForElementPresent(successMessage);
        return successMessage.isDisplayed();
    }
    //method for update customer actions     ************
    public void enterGroupNameToSearchBox(String groupName){
        utility.waitForElementPresent(cus_SearchBox);
        cus_SearchBox.sendKeys(groupName);
    }
    public void clickOnSearchButton(){
        utility.waitForElementPresent(searchButton);
        searchButton.click();
    }
    public void clickOnCustomerGroupRow(){
        utility.waitForElementPresent(customerGroupRow);
        customerGroupRow.click();
    }
    // method for Adding Customer Group
    public void addCustomerGroup(String groupName){
        clickOnCustomersLink();
        clickOnCustomerGroupLink();
        clickOnAddCustomerGroup();
        enterCustomerGroupName(groupName);
        taxClassSelection();
        clickOnSaveButton();
        successMessageDisplayed();
    }
// update customer method
    public void searchCustomerForUpdate(String cus_GroupName){
        clickOnCustomersLink();
        utility.sleep(5);
        clickOnCustomerGroupLink();
        utility.sleep(5);
        cus_SearchBox.click();
        utility.sleep(5);
        enterGroupNameToSearchBox(cus_GroupName);
        utility.sleep(5);
        clickOnSearchButton();
        utility.sleep(5);
        clickOnCustomerGroupRow();
        utility.sleep(5);
    }
    public void updateCustomerGroup(String customerGroupName){
        cus_GroupNameField.clear();
        enterCustomerGroupName(customerGroupName);
        clickOnSaveButton();
        successMessageDisplayed();
    }





}

