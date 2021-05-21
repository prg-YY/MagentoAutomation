package com.seleniummaster.magento.backendpages.ReportingModule;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersTagsAndReviewsPage extends TestBasePage {

    WebDriver driver;
    TestUtility utility;
    @FindBy(id = "period_date_from")
    WebElement FromField;
    @FindBy(id = "period_date_to")
    WebElement ToField;
    @FindBy(css = "button[title='Refresh']")
    WebElement RefreshButton;
    @FindBy(xpath = "(//h3[text()='New Accounts'])[1]")
    WebElement newAccountsSuccessMassage;
    @FindBy(xpath = "(//h3[text()='Customers by Orders Total'])[1]")
    WebElement customersByOrdersTotalSuccessMassage;
    @FindBy(xpath = "(//h3[text()='Customers by number of orders'])[1]")
    WebElement customersByNumberOfOrdersSuccessMassage;
    @FindBy(xpath = "(//h3[text()='Customers Tags'])[1]")
    WebElement customersTagsSuccessMassage;
    @FindBy(xpath = "(//h3[text()='Products Tags'])[1]")
    WebElement productsTagsSuccessMassage;
    @FindBy(xpath = "(//h3[text()='Popular Tags'])[1]")
    WebElement popularTagsSuccessMassage;
    @FindBy(xpath = "(//h3[text()='Products Reviews'])[1]")
    WebElement productsReviewsSuccessMassage;

    public CustomersTagsAndReviewsPage(WebDriver driver) {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

    public void clickNewAccountsSuccessMassage(){
        utility.waitForElementPresent(newAccountsSuccessMassage);
        newAccountsSuccessMassage.isDisplayed();
    }
    public void clickCustomersByOrdersTotalSuccessMassage(){
        utility.waitForElementPresent(customersByOrdersTotalSuccessMassage);
        customersByOrdersTotalSuccessMassage.isDisplayed();
    }
    public void clickCustomersByNumberOfOrdersSuccessMassage(){
        utility.waitForElementPresent(customersByNumberOfOrdersSuccessMassage);
        customersByNumberOfOrdersSuccessMassage.isDisplayed();
    }
    public void clickCustomersTagsSuccessMassage(){
        utility.waitForElementPresent(customersTagsSuccessMassage);
        customersTagsSuccessMassage.isDisplayed();
    }
    public void clickProductsTagsSuccessMassage(){
        utility.waitForElementPresent(productsTagsSuccessMassage);
        productsTagsSuccessMassage.isDisplayed();
    }
    public void clickPopularTagsSuccessMassage(){
        utility.waitForElementPresent(popularTagsSuccessMassage);
        popularTagsSuccessMassage.isDisplayed();
    }
    public void clickProductsReviewsSuccessMassage(){
        utility.waitForElementPresent(productsReviewsSuccessMassage);
        productsReviewsSuccessMassage.isDisplayed();
    }
    public void chooseDateOfCustomersByOrdersTotalAndClickAndRefreshButton(){
        utility.sleep(1);
        FromField.sendKeys("04/1/2021");

        utility.sleep(1);
        ToField.sendKeys("05/1/2021");

        utility.sleep(1);
        RefreshButton.click();
        utility.sleep(2);
    }

}
