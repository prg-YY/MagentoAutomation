package com.seleniummaster.magento.backendpages.storepages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreDashboardPage extends TestBasePage {

    WebDriver driver;
    TestUtility utility;
    @FindBy(xpath = "//img[@alt='Magento Logo']")
    WebElement homePage;

    @FindBy(xpath = "//span[text()='Sales']")
    WebElement allSalesLink;
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
    @FindBy(xpath = "//span[text()='Catalog']")
    WebElement allCatalogLink;
    @FindBy(xpath = "//span[text()='Manage Products']")
    WebElement manageProductsLink;
    @FindBy(xpath = "//span[text()='Manage Categories']")
    WebElement manageCategoriesLink;
    @FindBy(xpath = "//span[text()='System']")
    WebElement allSystemLink;
    @FindBy(xpath = "//span[text()='Manage Stores']")
    WebElement manageStoresLink;
    @FindBy(xpath = "(//span[text()='Create Website'])[1]")
    WebElement createWebsiteLink;
    @FindBy(xpath = "(//span[text()='Create Store'])[1]")
    WebElement createStoreLink;
    @FindBy(xpath = "(//span[text()='Create Store View'])[1]")
    WebElement createStoreViewLink;
    @FindBy(xpath = "//*[@class=\"link-logout\"]")
    WebElement logOutLink;
    @FindBy(xpath = "(//span[text()=\"Add Product\"])[1]")
    WebElement addProductLink;

    public StoreDashboardPage(WebDriver driver) {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(this.driver, this);
        utility = new TestUtility(this.driver);
    }

    public void clickHomePage(){
        utility.waitForElementPresent(homePage);
        homePage.click();
        Log.info("home page has been clicked");
    }
    public void clickAllSalesLink() {
        utility.waitForElementPresent(allSalesLink);
        allSalesLink.click();
        Log.info("All Sales Link clicked ");
    }

    public void clickOrdersLink() {
        utility.waitForElementPresent(ordersLink);
        ordersLink.click();
        Log.info("Orders link clicked");
    }

    public void clickInvoicesLink() {
        utility.waitForElementPresent(invoicesLink);
        invoicesLink.click();
        Log.info("Invoices Link clicked");
    }

    public void clickShipmentsLink() {
        utility.waitForElementPresent(shipmentsLink);
        shipmentsLink.click();
        Log.info("shipments Link clicked");
    }

    public void clickCreditMemosLink() {
        utility.waitForElementPresent(creditMemosLink);
        creditMemosLink.click();
        Log.info("Credit Memos Link clicked");
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

    public void clickAllCatalogLink() {
        utility.waitForElementPresent(allCatalogLink);
        allCatalogLink.click();
        Log.info("all Catalog Link clicked");
    }

    public void clickManageProductsLink() {
        utility.waitForElementPresent(manageProductsLink);
        manageProductsLink.click();
        Log.info("Manage Products Link clicked");
    }

    public void goToCreateProductsPage(){
        clickAllCatalogLink();
        clickManageProductsLink();
        utility.sleep(2);
        utility.waitForElementPresent(addProductLink);
        addProductLink.click();
        utility.sleep(2);

    }


    public void clickManageCategoriesLink() {
        utility.waitForElementPresent(manageCategoriesLink);
        manageCategoriesLink.click();
        Log.info("Manage Categories Link clicked");
    }

    public void clickAllSystemLink() {
        utility.waitForElementPresent(allSystemLink);
        allSystemLink.click();
        Log.info("All System Link clicked");
    }

    public void clickManageStoresLink() {
        utility.waitForElementPresent(manageStoresLink);
        manageStoresLink.click();
        Log.info("Manage Stores Link clicked");
    }

    public void clickCreateWebsiteLink() {
        utility.waitForElementPresent(createWebsiteLink);
        createWebsiteLink.click();
        Log.info("Create Website Link clicked");
    }

    public void clickCreateStoreLink() {
        utility.waitForElementPresent(createStoreLink);
        createStoreLink.click();
        Log.info("Create Store Link clicked");
    }

    public void clickCreateStoreViewLink() {
        utility.waitForElementPresent(createStoreViewLink);
        createStoreViewLink.click();
        Log.info("Create Store View Link clicked");
    }

    public void clickLogOutLink() {
        utility.waitForElementPresent(logOutLink);
        logOutLink.click();
        Log.info("Log Out Link clicked");
    }
    public void goToCreateStoreViewPage(){
        clickAllSystemLink();
        clickManageStoresLink();
        utility.sleep(2);
        clickCreateStoreViewLink();
        utility.sleep(2);

    }
}
