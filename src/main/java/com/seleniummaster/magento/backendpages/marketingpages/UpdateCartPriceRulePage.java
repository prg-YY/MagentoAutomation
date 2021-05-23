//package com.seleniummaster.magento.backendpages.marketingpages;
//
//import com.seleniummaster.magento.utility.Log;
//import com.seleniummaster.magento.utility.TestBasePage;
//import com.seleniummaster.magento.utility.TestUtility;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class UpdateCartPriceRulePage extends TestBasePage {
//
//    TestUtility utility;
//    @FindBy(xpath = "//*[@id=\"promo_quote_grid_filter_name\"]")
//    WebElement ruleNameFiled;
//    @FindBy(xpath = "//*[@id=\"promo_quote_grid_filter_name\"]")
//    WebElement ruleIdSearchBox;
//    @FindBy(xpath = "//span[text()=\"Search\"]")
//    WebElement searchButton;
//    @FindBy(xpath = "//*[@id=\"promo_quote_grid_table\"]/tbody/tr/td[2]")
//    WebElement oneCartPriceRule;
//    @FindBy(xpath = "//*[@id=\"rule_sort_order\"]")
//    WebElement priorityField;
//    @FindBy(xpath = "(//span[text()=\"Save\"])[1]")
//    WebElement saveEditButton;
//    @FindBy(xpath = "//span[text()=\"The rule has been saved.\"]")
//    WebElement editSuccessfulMessage;
//    public void UpdateExistingCartPriceRule(){
//        PageFactory.initElements(driver,this);
//        utility=new TestUtility(driver);
//    }
//
//    public void enterRuleName(){
//        utility.waitForElementPresent(ruleNameFiled);
//        ruleNameFiled.sendKeys("malike-rule");
//        utility.sleep(2);
//        Log.info("Rule name has been entered");
//    }
//    public void enterRuleId(String ruleId){
//        utility.waitForElementPresent(ruleNameFiled);
//        ruleNameFiled.sendKeys(ruleId);
//        utility.sleep(2);
//        Log.info("Rule ID has been entered");
//    }
//    public void clickSearchButton(){
//        utility.waitForElementPresent(searchButton);
//        searchButton.click();
//        utility.sleep(2);
//    }
//    public void clickOneCartPriceRule(){
//        utility.waitForElementPresent(oneCartPriceRule);
//        oneCartPriceRule.click();
//        utility.sleep(2);
//    }
//    public void enterPriority(){
//        utility.waitForElementPresent(priorityField);
//        priorityField.sendKeys("1");
//        utility.sleep(2);
//    }
//    public void clickSaveEditButton(){
//        utility.waitForElementPresent(saveEditButton);
//        saveEditButton.click();
//        utility.sleep(2);
//    }
//    public void verifyEditSuccessfulMessage(){
//        utility.waitForElementPresent(editSuccessfulMessage);
//        editSuccessfulMessage.isDisplayed();
//    }
//
//}
