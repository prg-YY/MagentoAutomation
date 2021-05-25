package com.seleniummaster.magento.backendpages.marketingpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAndUpDateCPriceRuleP extends TestBasePage {
    CatalogPriceRulePage catalogPriceRulePage=new CatalogPriceRulePage();
    WebDriver driver;
    TestUtility utility;

    // DilNur code -- add new catalog price rule


    @FindBy(xpath = "(//span[text()='Add New Rule'])[1]")
    WebElement addNewRuleButton;
    @FindBy(xpath = "//input[@name='name'][@type='text']")
    WebElement ruleNameTextBox;
    @FindBy(css = "input[name='rule_id'][type='text']")
    WebElement ruleIdTextBox1;
    @FindBy(xpath = "//*[@id=\"promo_catalog_grid_table\"]/tbody/tr/td[2]")
    WebElement dilNurRule;
    @FindBy(xpath = "(//span[text()='Actions'])[1]")
    WebElement actionsLink;
    @FindBy(xpath = "//option[text()='Team1']")
    WebElement webSite;
    @FindBy(xpath = "//option[text()='General']")
    WebElement customerGroups;
    @FindBy(xpath = "//input[@name='discount_amount']")
    WebElement DiscountAmountTextBox;
    @FindBy(xpath = "//*[@id='rule_description']")
    WebElement DescriptionTextBox;
    @FindBy(xpath = "(//span[text()='Save'])[1]")
    WebElement SaveButton;
    @FindBy(css = "[title='Save and Apply']")
    WebElement SaveAndApplyButton;
    @FindBy(css = "[class='success-msg']")
    WebElement NewRuleSuccessfullySaved;
    @FindBy(xpath = "//span[text()='The rules have been applied.']")
    WebElement appliedSuccessMassage;

    public AddAndUpDateCPriceRuleP() {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }



    public void clickAddNewRuleButton(){
        utility.waitForElementPresent(addNewRuleButton);
        addNewRuleButton.click();
        utility.sleep(1);
        Log.info("Add new rule button clicked");
    }
    public void enterRuleName(){
        utility.waitForElementPresent(ruleNameTextBox);
        ruleNameTextBox.sendKeys(prop.getProperty("NewRuleName"));
        Log.info("New rule name entered");
    }
    public void clickActionsLink(){
        utility.sleep(1);
        actionsLink.click();
        Log.info("Action Clicked");
    }
    public void clickWebSite(){
        utility.sleep(1);
        webSite.click();
        Log.info("WebSite Clicked");
    }
    public void clickCustomerGroups(){
        utility.sleep(1);
        customerGroups.click();
        Log.info("Customer Groups Clicked");
    }
    public void enterDiscountAmount(){
        utility.sleep(1);
        DiscountAmountTextBox.sendKeys(prop.getProperty("Weight"));
        Log.info("Discount Amount Entered");
    }
    public void clickDilNurRule(){
        utility.sleep(1);
        dilNurRule.click();
    }
    public void enterDescription(){
        utility.sleep(1);
        DescriptionTextBox.sendKeys(prop.getProperty("Weight"));
        Log.info("Description Entered");
    }
    public void clickRuleIdTextBox(){
        utility.waitForElementPresent(ruleIdTextBox1);
        ruleIdTextBox1.sendKeys(prop.getProperty("Weight"));
        Log.info(" rule ID entered");
    }
    public void clickSaveButton1(){
        utility.sleep(1);
        SaveButton.click();
        Log.info("Save Button Clicked");

    }
    public void clickSaveAndApplyButton(){
        utility.sleep(1);
        SaveAndApplyButton.click();
        Log.info("Save And Apply Button Clicked");
    }
    public void verifyNewRuleSuccessfullySaved(){
        utility.sleep(1);
        NewRuleSuccessfullySaved.isDisplayed();
    }
    public void verifyAppliedSuccessMassage(){
        utility.sleep(1);
        appliedSuccessMassage.isDisplayed();
    }


    public void addNewCatalogPriceRule(){
     clickAddNewRuleButton();
     enterRuleName();
     catalogPriceRulePage.selectActive();
     clickWebSite();
     clickCustomerGroups();
     clickActionsLink();
     enterDiscountAmount();
     clickSaveButton1();
    }

    public void upDateExistingRule(){
     clickRuleIdTextBox();
     catalogPriceRulePage.clickSearchButton();
     clickDilNurRule();
     DescriptionTextBox.clear();
     enterDescription();
     clickSaveAndApplyButton();

    }


}
