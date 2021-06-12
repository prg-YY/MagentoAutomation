package com.seleniummaster.magento.backendpages.salespages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TaxRulesPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    Select select;
    SalesDashboardPage dashboardPage;
    @FindBy(xpath = "(//span[text()='Add New Tax Rule'])[1]")
    WebElement addNewTaxRuleButton;
    @FindBy(xpath = "//input[@class=\"required-entry input-text required-entry\"]")
    WebElement taxRuleNameTextBox;
    @FindBy(id = "tax_customer_class")
    WebElement customerTaxClass;
    @FindBy(id = "tax_product_class")
    WebElement productTaxClass;
    @FindBy(id = "tax_rate")
    WebElement taxRateSelection;
    @FindBy(id= "priority")
    WebElement priorityNo;
    @FindBy(xpath = "(//span[text()='Save Rule'])[1]")
    WebElement saveRuleButton;
    @FindBy(xpath = "//span[text()='The tax rule has been saved.']")
    WebElement successMassage;

    public TaxRulesPage(WebDriver driver) {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility= new TestUtility(driver);
    }
    public void clickAddNewTaxRuleButton(){
        utility.waitForElementPresent(addNewTaxRuleButton);
        addNewTaxRuleButton.click();
        Log.info("add New Tax Rule Button is clicked");
    }
    public void enterTaxRuleName(String taxName){
        utility.waitForElementPresent(taxRuleNameTextBox);
        taxRuleNameTextBox.sendKeys(taxName);
        Log.info("tax Rule name name  text box field");
    }

    public void enterOrderNumber(String orderNumber){
        utility.waitForElementPresent(priorityNo);
        priorityNo.sendKeys(orderNumber);
        Log.info("Priority text field number 1");

    }
    public void selectCustomerTaxClass(String value){
        utility.waitForElementPresent(customerTaxClass);
        select=new Select(customerTaxClass);
        select.selectByValue(value);
    }
    public void selectProductTaxClass(String value){
        utility.waitForElementPresent(productTaxClass);
        select=new Select(productTaxClass);
        select.selectByValue(value);
    }
    public void selectTexRate(String value){
        utility.waitForElementPresent(taxRateSelection);
        select=new Select(taxRateSelection);
        select.selectByValue(value);
    }

    public void clickSaveRuleButton(){
        utility.waitForElementPresent(saveRuleButton);
        saveRuleButton.click();
        Log.info("save rule button is clicked");
    }
 //create Tax rule
    public void createTaxRule(String ruleName,String customerTaxValue,String productTaxValue,String taxRateValue){
        dashboardPage=new SalesDashboardPage(driver);
        dashboardPage.goToManageTaxRulesPage();
        clickAddNewTaxRuleButton();
        enterTaxRuleName(ruleName);
        selectCustomerTaxClass(customerTaxValue);
        selectProductTaxClass(productTaxValue);
        selectTexRate(taxRateValue);
        utility.sleep(2);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,-200)");
        clickSaveRuleButton();
        utility.sleep(2);
    }


    public boolean successMessageIsDisplay(){
        utility.waitForElementPresent(successMassage);
       if (successMassage.isDisplayed()){
           System.out.println("Test Passed New Rule Added");
           return true;
       }else
        return false;
    }

    //update text rule
    @FindBy(id = "taxRuleGrid_filter_code")
    WebElement ruleNameSearchBox;
    @FindBy(xpath = "//*[@id=\"taxRuleGrid_table\"]/tbody/tr[1]")
    WebElement taxRuleRow;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;




    public void enterRuleNameToSearchBox(String ruleName){
        utility.waitForElementPresent(ruleNameSearchBox);
        ruleNameSearchBox.sendKeys(ruleName);
        Log.info("Rule Name has been Entered");
    }
    public void defineTaxRule(String ruleName){
        enterRuleNameToSearchBox(ruleName);
        utility.waitForElementPresent(searchButton);
        searchButton.click();
        utility.sleep(2);
        utility.waitForElementPresent(taxRuleRow);
        taxRuleRow.click();
        utility.sleep(2);
    }
    public void editTaxRule(String customerTax){
        selectCustomerTaxClass(customerTax);
        clickSaveRuleButton();
        utility.sleep(2);
    }

//delete tax rule
    @FindBy(xpath = "(//span[text()='Delete Rule'])[1]")
    WebElement deleteRuleButton;
    @FindBy(xpath = "//span[text()='The tax rule has been deleted.']")
    WebElement deleteSuccessMessage;

    public void deleteTaxRule(){
        utility.waitForElementPresent(deleteRuleButton);
        deleteRuleButton.click();
        Alert alert=driver.switchTo().alert();
        utility.waitForAlertPresent();
        alert.accept();
    }
    public void deleteAnExistingTaxRule(String ruleName){
        dashboardPage=new SalesDashboardPage(driver);
        dashboardPage.goToManageTaxRulesPage();
        defineTaxRule(ruleName);
        deleteTaxRule();
    }
    public boolean deleteSuccessfulMessageIsDisplayed(){
        utility.waitForElementPresent(deleteSuccessMessage);
        if (deleteSuccessMessage.isDisplayed()){
            System.out.println("Test Passed Tax rule deleted successfully");
            Log.info("Test Passed Tax rule deleted successfully");
            return true;
        }else
            System.out.println("Test Failed. Deleting Tax rule Test Failed");
            Log.info("delete tax rule test failed");
            return false;
    }



}
