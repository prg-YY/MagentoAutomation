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

public class SalesDashboardPage extends TestBasePage {

    TestUtility utility;
    WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='Sales']")
    WebElement salesLink;
    @FindBy(xpath = "//span[text()='Orders']")
    WebElement ordersLink;
    @FindBy(xpath = "//span[text()='Invoices']")
    WebElement invoicesLink;
    @FindBy(xpath = "//span[text()='Shipments']")
    WebElement shipmentsLink;
    @FindBy(xpath = "//span[text()='Credit Memos']")
    WebElement creditMemosLink;
    @FindBy(xpath = "//span[text()='Tax']")
    WebElement taxLink;
    @FindBy(xpath = "//span[text()='Manage Tax Rules']")
    WebElement manageTexRulesLink;
    @FindBy(css = "select[name='store_switcher'][id='store_switcher' ]")
    WebElement chooseStoreViewDropDownList;
    @FindBy(xpath = "//*[@class=\"link-logout\"]")
    WebElement logOutLink;
    @FindBy(xpath = "//span[text()='Dashboard']")
    WebElement dashboard;

    public SalesDashboardPage(WebDriver driver) {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

    public void clickOnSalesLink() {
        utility.waitForElementPresent(salesLink);
        salesLink.click();
        utility.sleep(1);
        Log.info("All Sales Link clicked ");
    }

    public void clickOrdersLink() {
        utility.waitForElementPresent(ordersLink);
        ordersLink.click();
        Log.info("Orders link clicked");
    }
    public void goToOrderPage(){
        clickOnSalesLink();
        clickOrdersLink();
        utility.sleep(1);
    }

    public void clickInvoicesLink() {
        utility.waitForElementPresent(invoicesLink);
        invoicesLink.click();
        utility.sleep(1);
        Log.info("Invoices Link clicked");
    }
    public void goToInvoicesPage(){
        clickOnSalesLink();
        clickInvoicesLink();
        utility.sleep(1);
    }

    public void clickShipmentsLink() {
        utility.waitForElementPresent(shipmentsLink);
        shipmentsLink.click();
        Log.info("shipments Link clicked");
    }
    public void goToShipmentPage(){
        clickOnSalesLink();
        clickShipmentsLink();
        utility.sleep(1);
    }

    public void clickCreditMemosLink() {
        utility.waitForElementPresent(creditMemosLink);
        creditMemosLink.click();
        Log.info("Credit Memos Link clicked");
    }
    public void goToCreditMemosPage(){
        clickOnSalesLink();
        clickCreditMemosLink();
        utility.sleep(1);
    }

    public void clickTaxLink() {
        utility.waitForElementPresent(taxLink);
        taxLink.click();
        Log.info("Tax Link clicked");
    }

    public void clickManageTexRulesLink() {
        utility.waitForElementPresent(manageTexRulesLink);
        manageTexRulesLink.click();
        Log.info("Manage Tex Rules Link clicked");
    }

    public void goToManageTaxRulesPage(){
        clickOnSalesLink();
        clickTaxLink();
        clickManageTexRulesLink();
        utility.sleep(1);
    }

    public void clickChooseStoreViewDropDownList() {
        utility.waitForElementPresent(chooseStoreViewDropDownList);
        chooseStoreViewDropDownList.click();
        Log.info("Choose Store View Drop Down List clicked");
    }

    public void clickLogOutLink() {
        utility.waitForElementPresent(logOutLink);
        logOutLink.click();
        Log.info("Log Out Link clicked");
    }
    public void backToDashboard(){
        utility.waitForElementPresent(dashboard);
        dashboard.click();
        Log.info("dashboard link has been  clicked");
        utility.sleep(2);
    }
}