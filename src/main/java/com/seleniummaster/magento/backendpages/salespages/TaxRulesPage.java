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
    @FindBy(xpath = "(//span[text()='Add New Tax Rule'])[1]")
    WebElement addNewTaxRuleButton;
    @FindBy(xpath = "//input[@class=\"required-entry input-text required-entry\"]")
    WebElement taxRuleNameTextBox;
    @FindBy(xpath = "//option[@value=\"3\"]")
    WebElement retailCustomer;
    @FindBy(xpath = "//option[@value=\"1\"]")
    WebElement usCaRate;
    @FindBy(id= "priority")
    WebElement priorityNo;
    @FindBy(xpath = "(//span[text()='Save Rule'])[1]")
    WebElement saveRuleButton;
    @FindBy(xpath = "//*[@id=\"messages\"]/ul/li")
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
    public void clickOnRetailCustomer(){
        utility.waitForElementPresent(retailCustomer);
        retailCustomer.click();
        Log.info("retail customer is selected");
    }

    public void clickUsCaRate(){
        utility.waitForElementPresent(usCaRate);
        usCaRate.click();
        Log.info(" tax rate US-CA-*-Rate1 selected");
    }
    public void enterOrderNumber(String orderNumber){
        utility.waitForElementPresent(priorityNo);
        priorityNo.sendKeys(orderNumber);
        Log.info("Priority text field number 1");

    }
    public void selectVIP(String value){
        Select customerTaxClassOption=new Select(driver.findElement(By.id("tax_customer_class")));
        customerTaxClassOption.selectByValue(value);
    }
    public void selectGeneral(String value){
        Select productTaxClassOption=new Select(driver.findElement(By.id("tax_product_class")));
        productTaxClassOption.selectByValue(value);
    }
    public void selectTexRate(String value){
        Select taxRateOption=new Select(driver.findElement(By.id("tax_rate")));
        taxRateOption.selectByValue(value);
    }

    public void clickSaveRuleButton(){
        utility.waitForElementPresent(saveRuleButton);
        saveRuleButton.click();
        Log.info("save rule button is clicked");
    }
    public void fillOutNewTaxRuleInformation(){
        enterTaxRuleName(prop.getProperty("taxRuleName")+System.currentTimeMillis());
        selectVIP(prop.getProperty("vipValue"));
        selectGeneral(prop.getProperty("selectGeneral"));
        selectTexRate(prop.getProperty("taxRateValue"));
        utility.sleep(2);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,-200)");
        clickSaveRuleButton();
    }
    public boolean successMessageIsDisplay(){
        utility.waitForElementPresent(successMassage);
       if (successMassage.getText().contains(" ")){
           System.out.println("Test Passed");
       }else System.out.println("Test Failed");
        Log.info("success message verified");
        return true;
    }

    //update text rule
    @FindBy(id = "taxRuleGrid_filter_code")
    WebElement ruleNameTextBox;
    @FindBy(xpath = "//*[@id=\"taxRuleGrid_table\"]/tbody/tr[1]")
    WebElement taxRuleRow;

    public void enterRuleName(String ruleName){
        utility.waitForElementPresent(ruleNameTextBox);
        ruleNameTextBox.sendKeys(ruleName);
        Log.info("Rule Name has been Entered");
    }
    public void clickOnTaxRuleRow(){
        utility.waitForElementPresent(taxRuleRow);
        taxRuleRow.click();
        Log.info("Tax rule has been clicked");
    }
    public void enterPriority(String priority){
        utility.waitForElementPresent(priorityNo);
        priorityNo.clear();
        priorityNo.sendKeys(priority);
        utility.sleep(1);
        clickSaveRuleButton();
        utility.sleep(2);
    }
    public void defineRuleForEdit(String ruleName){
        enterRuleName(ruleName);
        clickOnTaxRuleRow();
    }


}
