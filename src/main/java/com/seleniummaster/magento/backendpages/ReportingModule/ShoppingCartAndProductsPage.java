package com.seleniummaster.magento.backendpages.ReportingModule;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartAndProductsPage extends TestBasePage {

    WebDriver driver;
    TestUtility utility;

   @FindBy(xpath = "(//h3[text()='Products in carts'])[1]")
    WebElement productsInCartsSuccessfulMassage;
   @FindBy(xpath = "(//h3[text()='Abandoned carts'])[1]")
    WebElement abandonedCartsSuccessfulMassage;
   @FindBy(css = "input[name='customer_name'][id='gridAbandoned_filter_customer_name']")
    WebElement customerNameTextBox;
   @FindBy(xpath = "(//h3[text()='Products Bestsellers Report'])[1]")
    WebElement productsBestsellersReportSuccessfulMassage;
   @FindBy(css = "input[name='report_from'][type='text']")
    WebElement fromBoxOrdered;
   @FindBy(css = "input[name='report_to'][type='text']")
    WebElement toBoxOrdered;
   @FindBy(xpath = "//span[text()='Refresh']")
    WebElement refreshButton;
    @FindBy(xpath = "(//h3[text()='Products Ordered'])[1]")
    WebElement productsOrderedSuccessfulMassage;
    @FindBy(xpath = "(//h3[text()='Most Viewed'])[1]")
    WebElement mostViewedSuccessfulMassage;
    @FindBy(xpath = "(//h3[text()='Low stock'])[1]")
    WebElement lowStockSuccessfulMassage;
    @FindBy(css = "input[name='name'][id='downloadsGrid_filter_name']")
    WebElement productNameTextBoxDownloads;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButtonDownloads;
    @FindBy(xpath = "(//h3[text()='Downloads'])[1]")
    WebElement downloadsSuccessMassage;

    public ShoppingCartAndProductsPage(WebDriver driver) {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

    public void clickProductsInCartsSuccessfulMassage(){
        utility.waitForElementPresent(productsInCartsSuccessfulMassage);
        productsInCartsSuccessfulMassage.isDisplayed();
    }
    public void clickAbandonedCartsSuccessfulMassage(){
        utility.waitForElementPresent(abandonedCartsSuccessfulMassage);
        abandonedCartsSuccessfulMassage.isDisplayed();
    }
    public void clickCustomerNameTextBox(){
        utility.waitForElementPresent(customerNameTextBox);
        customerNameTextBox.sendKeys(prop.getProperty("yusufLastName"));
        Log.info("Customer Name entered");
    }
    public void clickProductsBestsellersReportSuccessfulMassage(){
        utility.waitForElementPresent(productsBestsellersReportSuccessfulMassage);
        productsBestsellersReportSuccessfulMassage.isDisplayed();
    }
    public void clickFromBoxOrdered(){
        utility.waitForElementPresent(fromBoxOrdered);
        fromBoxOrdered.sendKeys(prop.getProperty("fromDate"));
        Log.info("From Date entered");
    }
    public void clickToBoxOrdered(){
        utility.waitForElementPresent(toBoxOrdered);
        fromBoxOrdered.sendKeys(prop.getProperty("toDate"));
        Log.info("To Date entered");
    }
    public void clickRefreshButton(){
        utility.waitForElementPresent(refreshButton);
        refreshButton.click();
    }
    public void clickProductsOrderedSuccessfulMassage(){
        utility.waitForElementPresent(productsOrderedSuccessfulMassage);
        productsOrderedSuccessfulMassage.isDisplayed();
    }
    public void clickMostViewedSuccessfulMassage(){
        utility.waitForElementPresent(mostViewedSuccessfulMassage);
        mostViewedSuccessfulMassage.isDisplayed();
    }
    public void clickLowStockSuccessfulMassage(){
        utility.waitForElementPresent(lowStockSuccessfulMassage);
        lowStockSuccessfulMassage.isDisplayed();
    }
    public void clickProductNameTextBoxDownloads(){
        utility.waitForElementPresent(productNameTextBoxDownloads);
        productNameTextBoxDownloads.sendKeys(prop.getProperty("productName"));
    }
    public void clickSearchButtonDownloads(){
        utility.waitForElementPresent(searchButtonDownloads);
        searchButtonDownloads.click();
    }
    public void clickDownloadsSuccessMassage(){
        utility.waitForElementPresent(downloadsSuccessMassage);
        downloadsSuccessMassage.isDisplayed();
    }

    public void productsOrdered(){
        clickFromBoxOrdered();
        clickToBoxOrdered();
    }





















}
