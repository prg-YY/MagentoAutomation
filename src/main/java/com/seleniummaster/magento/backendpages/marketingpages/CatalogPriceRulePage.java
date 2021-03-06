package com.seleniummaster.magento.backendpages.marketingpages;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CatalogPriceRulePage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;


    @FindBy(xpath = "//input[@name='name'][@type=\"text\"]")
    WebElement ruleNameTextBox;
    @FindBy(css = "input[name='rule_id'][type='text']")
    WebElement ruleIdTextBox;
    @FindBy(xpath = "(//span[text()='Apply Rules'])[1]")
    WebElement applyRulesButton;
    @FindBy(xpath = "//span[text()='Reset Filter']")
    WebElement resetFilterButton;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;
    @FindBy(xpath = "//input[@name='from_date[from]']")
    WebElement fromDateTextBox;
    @FindBy(xpath = "//input[@name='from_date[to]']")
    WebElement toDateTextBox;
    @FindBy(xpath = "//select[@name='is_active']")
    WebElement statusDropDownList;
    @FindBy(xpath = "//select[@name='is_active']/option[2]")
    WebElement active;
    @FindBy(xpath = "//select[@name='is_active']/option[3]")
    WebElement inActive;
    @FindBy(xpath = "//select[@name='rule_website']")
    WebElement webSite;
    @FindBy(css = "option[value='14']")
    WebElement websitesSelectOptions;
    @FindBy(xpath = "//*[@id=\"rule_customer_group_ids\"]/option[11]")
    WebElement CustomerGroup;
    @FindBy(css = "(//span[text()='Save'])[1]")
    WebElement saveButton;
    @FindBy(xpath = "//span[text()='The rule has been saved.']")
    WebElement successMessage;


    public CatalogPriceRulePage() {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

    public void clickRuleNameTextBox(){
        utility.waitForElementPresent(ruleNameTextBox);
        ruleNameTextBox.sendKeys("duttar");
        Log.info("New rule name entered");
    }
    public void clickRuleIdTextBox(){
        utility.waitForElementPresent(ruleIdTextBox);
        ruleIdTextBox.sendKeys("1");
        Log.info("New rule ID entered");
    }
    public void clickApplyRulesButton(){
        utility.waitForElementPresent(applyRulesButton);
        applyRulesButton.click();
        Log.info("Apply Rules button clicked");
    }
    public void clickResetFilterButton(){
        utility.waitForElementPresent(resetFilterButton);
        resetFilterButton.click();
        Log.info("Reset Filter button clicked");
    }
    public void clickSearchButton(){
        utility.waitForElementPresent(searchButton);
        searchButton.click();
        Log.info("Search  button clicked");
    }
//    public void clickOnMyRule(){
//        utility.waitForElementPresent(myRule);
//        myRule.click();
//        Log.info("My Rule Has Been Clicked");
//    }
    public void clickFromDateTextBox(String fromDate){
        utility.waitForElementPresent(fromDateTextBox);
        fromDateTextBox.sendKeys(fromDate);
        Log.info("From Date Entered");
    }
    public void clickToDateTextBox(String toDate){
        utility.waitForElementPresent(toDateTextBox);
        toDateTextBox.sendKeys(toDate);
        Log.info("From Date Entered");
    }
    public void clickStatusDropDownList(){
        utility.waitForElementPresent(statusDropDownList);
        statusDropDownList.click();
        Log.info("Status list clicked");
    }
    public void selectActive(){
        utility.waitForElementPresent(active);
        active.click();
        Log.info("Active Selected");
    }
    public void selectInActive(){
        utility.waitForElementPresent(inActive);
        inActive.click();
        Log.info("inActive Selected");
    }
    public void clickWebSite(){
        utility.waitForElementPresent(webSite);
        webSite.click();
        Log.info("WebSite Button clicked");
    }

    public void selectWebsites(){
        utility.waitForElementPresent(websitesSelectOptions);
        websitesSelectOptions.isSelected();
        Log.info("Websites name is selected");
    }
    public void selectCustomerGroup(){
        utility.waitForElementPresent(CustomerGroup);
        CustomerGroup.isSelected();
        Log.info("Customer Group has been selected");
    }
    public void clickSaveButton(){
        utility.waitForElementPresent(saveButton);
        saveButton.click();
        Log.info("Save Button clicked");
    }
    public boolean verifySuccessMessage(){
        utility.waitForElementPresent(successMessage);
        Log.info("Success message is display");
        return successMessage.isDisplayed();
    }





}