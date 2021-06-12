package com.seleniummaster.magento.backendpages.customerpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//Customer Manager can assign a customer to a Customer Group in the Action on the All Customer page

public class CustomerGroupPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    CustomerDashboardPage dashboardPage;
    Select select;
    /*
    Add Customer group
    Update Customer group
    delete customer group
     */
    public CustomerGroupPage(){
        this.driver=TestBasePage.driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
        dashboardPage=new CustomerDashboardPage(driver);
    }
//Add Customer Group
    @FindBy(xpath = "(//span[text()='Add New Customer Group'])[1]")
    WebElement addCustomerGroupLink;
    @FindBy(id ="customer_group_code" )
    WebElement groupNameTextFiled;
    @FindBy(id = "tax_class_id")
    WebElement taxClassOption;
    @FindBy(xpath = "(//span[text()='Save Customer Group'])[1]")
    WebElement saveCustomerGroupButton;
    @FindBy(xpath = "//span[text()='The customer group has been saved.']")
    WebElement addEditSuccessMessage;
//Update customer Group
    @FindBy(id = "customerGroupGrid_filter_type")
    WebElement groupNameSearchBox;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;
    @FindBy(xpath = " //*[@id=\"customerGroupGrid_table\"]/tbody/tr")
    WebElement customerGroup;
//Delete customer Group
    @FindBy(xpath = "(//span[text()='Delete Customer Group'])[1]")
    WebElement deleteGroupButton;
    @FindBy(xpath = "//span[text()='The customer group has been deleted.']")
    WebElement deleteGroupSuccessMessage;

    //methods (Add customer Group)
    public void clickAddCustomerGroupLink(){
        utility.waitForElementPresent(addCustomerGroupLink);
        addCustomerGroupLink.click();
        Log.info("Add Customer Group link has been clicked");
    }
    public void enterGroupName(String groupName){
        utility.waitForElementPresent(groupNameTextFiled);
        groupNameTextFiled.sendKeys(groupName);
        Log.info("("+groupName+") has been Entered");
    }
    public void selectTaxClass(String value){
        utility.waitForElementPresent(taxClassOption);
        select=new Select(taxClassOption);
        select.selectByValue(value);
        Log.info(value+"has been selected");
    }
    public void clickSaveGroupButton(){
        utility.waitForElementPresent(saveCustomerGroupButton);
        saveCustomerGroupButton.click();
        Log.info("save Customer Group Button has been clicked");
    }
    public void createCustomerGroup(String groupName,String taxClassValue){
        dashboardPage.clickCustomersLink();
        dashboardPage.clickCustomerGroupLink();
        utility.sleep(2);
        clickAddCustomerGroupLink();
        utility.sleep(2);
        enterGroupName(groupName);
        selectTaxClass(taxClassValue);
        clickSaveGroupButton();
        utility.sleep(3);
    }
    public void addNewCustomerGroup(String groupName,String taxClassValue){
        dashboardPage.clickCustomersLink();
        dashboardPage.clickCustomerGroupLink();
        utility.sleep(2);
        clickAddCustomerGroupLink();
        utility.sleep(2);
        enterGroupName(groupName);
        selectTaxClass(taxClassValue);
        utility.sleep(2);
        clickSaveGroupButton();
        utility.sleep(3);
    }

    public boolean addCustomerGroupSuccessfully(){
        utility.waitForElementPresent(addEditSuccessMessage);
        if (addEditSuccessMessage.isDisplayed()){
            System.out.println("Test passed, Customer group added successfully");
            return true;
        }else System.out.println("Test failed");
        return false;
    }
//Methods (Update Customer Groups)
   public void enterGroupNameToSearchBox(String groupName){
        utility.waitForElementPresent(groupNameSearchBox);
        groupNameSearchBox.clear();
        groupNameSearchBox.sendKeys(groupName);
        Log.info(groupName+" has been entered");
   }
   public void clickOnSearchButton(){
        utility.waitForElementPresent(searchButton);
        searchButton.click();
        Log.info("Search button has been clicked");
   }
   public void clickOnCustomerGroup(){
        utility.waitForElementPresent(customerGroup);
        customerGroup.click();
        Log.info("Customer group has been clicked");
   }
   public void updateCustomerGroup(String groupName,String taxClassValue){
       dashboardPage.clickCustomersLink();
       dashboardPage.clickCustomerGroupLink();
       utility.sleep(2);
        enterGroupNameToSearchBox(groupName);
        clickOnSearchButton();
        utility.sleep(2);
        clickOnCustomerGroup();
        utility.sleep(1);
        selectTaxClass(taxClassValue);
        clickSaveGroupButton();
        utility.sleep(3);
   }
   public boolean updateCustomerGroupSuccessfully(){
        utility.waitForElementPresent(addEditSuccessMessage);
        if (addEditSuccessMessage.isDisplayed()){
            System.out.println("Test Passed ,Update Customer Group successfully");
            return true;
        }else System.out.println("Test Failed");
        return false;
   }

// methods ( Delete Customer Group)
    public void clickOnDeleteCustomerGroupLink(){
        utility.waitForElementPresent(deleteGroupButton);
        deleteGroupButton.click();
        Alert alert=driver.switchTo().alert();
        utility.waitForAlertPresent();
        alert.accept();
    }
    public void deleteCustomerGroup(String groupName){
        dashboardPage.clickCustomersLink();
        dashboardPage.clickCustomerGroupLink();
        utility.sleep(2);
        enterGroupNameToSearchBox(groupName);
        clickOnSearchButton();
        utility.sleep(2);
        clickOnCustomerGroup();
        utility.sleep(1);
        clickOnDeleteCustomerGroupLink();
        utility.sleep(2);
    }
    public boolean deleteCustomerGroupSuccessfully(){
        utility.waitForElementPresent(deleteGroupSuccessMessage);
        if (deleteGroupSuccessMessage.isDisplayed()){
            System.out.println("Test Passed ,Delete customer group successfully");
            return true;
        }else System.out.println("Test Failed. delete customer group test failed");
        return false;
    }
}

