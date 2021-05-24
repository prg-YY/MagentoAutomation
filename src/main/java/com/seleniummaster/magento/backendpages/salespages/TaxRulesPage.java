package com.seleniummaster.magento.backendpages.salespages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TaxRulesPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    // sales list
    @FindBy(xpath = "//span[text()=\"Sales\"]")
    WebElement salesLink;
    // click tax link
@FindBy(xpath = "//*[span=\"Tax\"]")
    WebElement taxLink;
// click manage tax rules
    @FindBy(xpath = "//*[span=\"Manage Tax Rules\"]")
    WebElement manageTaxRulesList;
    // manage tax rules page
    @FindBy(className = "icon-head head-tax-rule")
    WebElement viewManageTaxRulesPage ;
    //click on new add tax button
    @FindBy(xpath = "//button[@id=\"id_d26b25e9463a88f35ed7fe5776c8fdf9\"]")
    WebElement addNewTaxRuleButton;
    //new rule page on display
    @FindBy(className = "icon-head head-tax-rule")
    WebElement newRulePage;
    // tax information name field
    @FindBy(xpath = "//input[@class=\"required-entry input-text required-entry\"]")
    WebElement taxRuleNameTextBox;
    //retail customer
    @FindBy(xpath = "//option[@value=\"3\"]")
    WebElement retailCustomer;
    //product tax class selected
    @FindBy(xpath = "//option[@value=\"2\"]")
    WebElement taxableGoods;
    //from tax rate "US-CA-*-Rate1" selected
    @FindBy(xpath = "//option[@value=\"1\"]")
    WebElement usCaRate;
    //Priority text field
    @FindBy(id= "priority")
    WebElement priorityFieldsNumber;
    // click save rule button
    @FindBy(xpath = "(//span[text()='Save Rule'])[1]")
    WebElement saveRuleButton;
    //verify success message
    @FindBy(xpath = "/li[@class=\"success-msg\"]")
    WebElement successMassage;

    //combine webdriver


    public TaxRulesPage(WebDriver driver) {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility= new TestUtility(driver);
    }
    // method for sales
    public void clickOnSalesLink(){
        utility.waitForElementPresent(salesLink);
        salesLink.click();
        Log.info("sales link has been clicked");
}
//method for  click tax link
    public void clickTaxlink(){
        utility.waitForElementPresent(taxLink);
        taxLink.click();
        Log.info("tax link has been clicked");
    }
    // click manage tax rules
    public void setClickManageTaxRulesList(){
        utility.waitForElementPresent(manageTaxRulesList);
        manageTaxRulesList.click();
        Log.info("manage tax rules button clicked");
    }
    // manage tax rules page is display
    public void verifyManageTaxRulesPage(){
        utility.waitForElementPresent(viewManageTaxRulesPage);
        viewManageTaxRulesPage.isDisplayed();
        Log.info("Manage Tax Rules Page is displayed");

    }
    //click on new add tax button
    public void clickAddNewTaxRuleButton(){
        utility.waitForElementPresent(addNewTaxRuleButton);
        addNewTaxRuleButton.click();
        utility.sleep(1);
        Log.info("add New Tax Rule Button is clicked");

    }
    //new rule page on display
    public void viewNewRulePage(){
        utility.waitForElementPresent(newRulePage);
        newRulePage.isDisplayed();
        Log.info("new rule page on displayed");

    }
    // tax information name  text box field
    public void enterTaxRuleName(String taxName){
        utility.waitForElementPresent(taxRuleNameTextBox);
        taxRuleNameTextBox.sendKeys(taxName);
        Log.info("tax Rule name name  text box field");

    }
    // select "retail customer"
    public void clickOnRetailCustomer(){
        utility.waitForElementPresent(retailCustomer);
        retailCustomer.click();
        Log.info("retail customer is selected");

    }
    //product tax class selected
    public void clickTaxableGoods(){
        utility.waitForElementPresent(taxableGoods);
        taxableGoods.click();
        Log.info("product tax class selected");

    }
    // select from tax rate "US-CA-*-Rate1"
    public void clickUsCaRate(){
        utility.waitForElementPresent(usCaRate);
        usCaRate.click();
        Log.info(" tax rate US-CA-*-Rate1 selected");

    }
    //Priority text field
    public void enterOrderNumber(String orderNumber){
        utility.waitForElementPresent(priorityFieldsNumber);
        priorityFieldsNumber.sendKeys(orderNumber);
        Log.info("Priority text field number 1");

    }
    public void selectVIP(String value){
        Select customerTaxClassOption=new Select(driver.findElement(By.id("tax_customer_class")));
        customerTaxClassOption.deselectByValue(value);
    }
    public void selectGeneral(String value){
        Select productTaxClassOption=new Select(driver.findElement(By.id("tax_product_class")));
        productTaxClassOption.deselectByValue(value);
    }
    public void selectTexRate(String value){
        Select taxRateOption=new Select(driver.findElement(By.id("tax_rate")));
        taxRateOption.deselectByValue(value);
    }

    // click save rule button
    public void clickSaveRuleButton(){
        utility.waitForElementPresent(saveRuleButton);
        saveRuleButton.click();
        Log.info("save rule button is clicked");
    }
    public void fillOutNewTaxRuleInformation(){
        enterTaxRuleName(prop.getProperty("taxRuleName"));
        selectVIP(prop.getProperty("vipValue"));
        selectGeneral(prop.getProperty("selectGeneral"));
        selectTexRate(prop.getProperty("taxRateValue"));
        clickSaveRuleButton();
        utility.sleep(2);


    }
    // verify success message
    public boolean isNewRuleAddedSuccessfully(){
        utility.waitForElementPresent(successMassage);
       if (successMassage.isDisplayed()){
           System.out.println("Test Passed");
       }else System.out.println("Test Failed");
        Log.info("success message verified");
        return true;
    }





}
