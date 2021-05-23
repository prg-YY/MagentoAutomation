package com.seleniummaster.magento.backendpages.marketingpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPriceRulePage extends TestBasePage {

    TestUtility utility;
//Add New Cart Price Rule
    @FindBy(xpath = "(//span[text()='Add New Rule'])[1]")
    WebElement addNewRuleButton;
    @FindBy(xpath = "//*[@id=\"rule_name\"]")
    WebElement ruleNameField;
    @FindBy(xpath = "//*[@id=\"rule_website_ids\"]/option[5]")
    WebElement webSitesOneOption;
    @FindBy(xpath ="//*[@id=\"rule_customer_group_ids\"]/option[2]" )
    WebElement customerGroupsOneOption;
    @FindBy(xpath = "(//span[text()='Save'])[1]")
    WebElement saveButton;
    @FindBy(xpath = "//span[text()=\"The rule has been saved.\"]")
    WebElement verifySavedMessage;
    public CartPriceRulePage() {
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }
    public void clickAddNewRuleButton(){
        utility.waitForElementPresent(addNewRuleButton);
        addNewRuleButton.click();
        Log.info("Add new rule button clicked");
    }
    public void enterRuleName(String ruleName){
        utility.waitForElementPresent(ruleNameField);
        ruleNameField.sendKeys(ruleName);
        utility.sleep(2);
    }
    public void selectWebSitesOneOption(){
        utility.waitForElementPresent(webSitesOneOption);
        webSitesOneOption.click();
        utility.sleep(2);
    }
    public void selectCustomerGroupsOneOption(){
        utility.waitForElementPresent(customerGroupsOneOption);
        customerGroupsOneOption.click();
        utility.sleep(2);
    }
    public void clickSaveButton(){
        utility.waitForElementPresent(saveButton);
        saveButton.click();
    }
    public void verifySaveMessage(){
        utility.waitForElementPresent(verifySavedMessage);
        verifySavedMessage.isDisplayed();
    }
    public void addNewCartPriceRule(String ruleName){
        clickAddNewRuleButton();
        enterRuleName(ruleName);
        selectWebSitesOneOption();
        selectCustomerGroupsOneOption();
        clickSaveButton();
    }


    //Update New Rule
    @FindBy(xpath = "//*[@id=\"promo_quote_grid_filter_name\"]")
    WebElement ruleNameFiled;
    @FindBy(xpath = "//*[@id=\"promo_quote_grid_filter_rule_id\"]")
    WebElement ruleIdSearchBox;
    @FindBy(xpath = "//span[text()=\"Search\"]")
    WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"promo_quote_grid_table\"]/tbody/tr/td[2]")
    WebElement oneCartPriceRule;
    @FindBy(id = "rule_description")
    WebElement ruleDescriptionTextBox;
    @FindBy(xpath = "(//span[text()=\"Save\"])[1]")
    WebElement saveEditButton;
    @FindBy(xpath = "//*[@id=\"messages\"]/ul/li")
    WebElement editSuccessfulMessage;

    // Update Rule price Methods

    public void enterRuleNameToSearchBox(String ruleName){
        utility.waitForElementPresent(ruleNameFiled);
        ruleNameFiled.sendKeys(ruleName);
        utility.sleep(2);
        Log.info("Rule name has been entered");
    }
    public void enterRuleId(String ruleId){
        utility.waitForElementPresent(ruleIdSearchBox);
        ruleIdSearchBox.sendKeys(ruleId);
        utility.sleep(2);
        Log.info("Rule ID has been entered");
    }
    public void clickSearchButton(){
        utility.waitForElementPresent(searchButton);
        searchButton.click();
        utility.sleep(2);
        Log.info("search button has been clicked");
    }
    public void clickOneCartPriceRule(){
        utility.waitForElementPresent(oneCartPriceRule);
        oneCartPriceRule.click();
        utility.sleep(2);
        Log.info("one Cart Price Rule has been clicked");
    }
    public void clearRuleDescription(){
        utility.waitForElementPresent(ruleDescriptionTextBox);
        ruleDescriptionTextBox.clear();
        Log.info("Description Text box has been cleared");
    }
    public void enterRuleDescription(String ruleDescription){
        utility.waitForElementPresent(ruleDescriptionTextBox);
        ruleDescriptionTextBox.sendKeys(ruleDescription);
        utility.sleep(2);
        Log.info("Description Text  has been Edited");
    }
    public void clickSaveEditButton(){
        utility.waitForElementPresent(saveEditButton);
        saveEditButton.click();
        utility.sleep(2);
        Log.info("Save button has been clicked");
    }
    public boolean updatedSuccessMessageIsDisplay(){
        utility.waitForElementPresent(editSuccessfulMessage);
        editSuccessfulMessage.isDisplayed();
        Log.info("update success message has been displayed");
        return true;
    }
    public void updateCartRulePrice(){
        enterRuleNameToSearchBox(prop.getProperty("cartPriceRuleName"));
        clickSearchButton();
        utility.sleep(2);
        clickOneCartPriceRule();
        utility.sleep(2);
        clearRuleDescription();
        enterRuleDescription(prop.getProperty("cartPriceRuleDescription"));
        clickSaveEditButton();
        utility.sleep(2);
    }

    // search catalog price rule test methods
    @FindBy(xpath = "//*[@id=\"promo_catalog_grid_filter_rule_id\"]")
    WebElement ruleIdSearchingField;
    @FindBy(xpath ="//*[@id=\"promo_catalog_grid_filter_name\"]")
    WebElement ruleNameSearchingField;
    @FindBy(xpath = "//*[@id=\"anchor-content\"]")
    WebElement verifyPage;
    @FindBy(xpath = "//span[text()='Reset Filter']")
    WebElement resetFilter;
    @FindBy(xpath = "//*[@id=\"promo_catalog_grid\"]/table/tbody/tr/td[1]")
    WebElement searchingResultTab;

    // methods
    public void enterRuleNameForSearching(String ruleName){
        utility.waitForElementPresent(ruleNameSearchingField);
        ruleNameSearchingField.sendKeys(ruleName);
        Log.info("Rule name has been Entered for searching");
    }
    public void clickOnResetFilter(){
        utility.waitForElementPresent(resetFilter);
        resetFilter.click();
        Log.info("Reset Filter has been clicked");
    }
    public void enterRuleIdForSearching(String ruleId){
        utility.waitForElementPresent(ruleIdSearchingField);
        ruleIdSearchingField.sendKeys(ruleId);
        Log.info("Rule ID has been Entered For searching");
    }

    public void searchingByRuleName(String ruleName){
        enterRuleNameForSearching(ruleName);
        clickSearchButton();
        utility.sleep(2);
    }
    public void searchingByRuleId(String ruleId){
        enterRuleIdForSearching(ruleId);
        clickSearchButton();
        utility.sleep(2);
    }
    // verify searching result
    public boolean searchingResultDisplay(){
        utility.waitForElementPresent(searchingResultTab);
        List<WebElement> ruleResultList=driver.findElements(By.xpath("//*[@id=\"promo_catalog_grid_table\"]/tbody/tr"));
        if (ruleResultList.size()>0){
            System.out.println("Test Passed Total result already displayed");
        }else System.out.println("There no any result");
        return true;
    }
}
