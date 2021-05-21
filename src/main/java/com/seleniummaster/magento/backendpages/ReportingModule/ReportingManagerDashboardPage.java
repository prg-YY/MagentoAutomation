package com.seleniummaster.magento.backendpages.ReportingModule;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportingManagerDashboardPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;

    @FindBy(xpath = "//span[text()='Catalog']")
    WebElement catalogLink;
    @FindBy(xpath = "//span[text()='Reports']")
    WebElement ReportsLink;
    @FindBy(xpath = "//span[text()='Sales']")
    WebElement salesLink;
    @FindBy(xpath = "//span[text()='Orders']")
    WebElement ordersLink;
    @FindBy(xpath = "//span[text()='Tax']")
    WebElement taxLink;
    @FindBy(xpath = "//span[text()='Invoiced']")
    WebElement invoicedLink;
    @FindBy(xpath = "//span[text()='Shipping']")
    WebElement shippingLink;
    @FindBy(xpath = "//span[text()='Refunds']")
    WebElement refundsLink;
    @FindBy(xpath = "//span[text()='Coupons']")
    WebElement couponsLink;
    @FindBy(xpath = "//span[text()='Shopping Cart']")
    WebElement shoppingCartLink;
    @FindBy(xpath = "//span[text()='Products in carts']")
    WebElement productsInCartsLink;
    @FindBy(xpath = "//span[text()='Abandoned carts']")
    WebElement abandonedCartsLink;
    @FindBy(xpath = "(//span[text()='Products'])[1]")
    WebElement productsLink;
    @FindBy(xpath = "//span[text()='Bestsellers']")
    WebElement bestsellersLink;
    @FindBy(xpath = "//span[text()='Products Ordered']")
    WebElement productsOrderedLink;
    @FindBy(xpath = "//span[text()='Most Viewed']")
    WebElement mostViewedLink;
    @FindBy(xpath = "//span[text()='Low stock']")
    WebElement lowStockLink;
    @FindBy(xpath = "//span[text()='Downloads']")
    WebElement downloadsLink;
    @FindBy(xpath = "(//span[text()='Customers'])[1]")
    WebElement costumersLink;
    @FindBy(xpath = "//span[text()='New Accounts']")
    WebElement newAccountsLink;
    @FindBy(xpath = "//span[text()='Customers by orders total']")
    WebElement customersByOrdersTotalLink;
    @FindBy(xpath = "//span[text()='Customers by number of orders']")
    WebElement customersByNumberOfOrdersLink;
    @FindBy(xpath = "//span[text()='Tags']")
    WebElement tagsLink;
    @FindBy(xpath = "(//span[text()='Customers'])[2]")
    WebElement tagsCustomersLink;
    @FindBy(xpath = "(//span[text()='Products'])[2]")
    WebElement tagProductsLink;
    @FindBy(xpath = "//span[text()='Popular']")
    WebElement tagPopularLink;
    @FindBy(xpath = "//span[text()='Reviews']")
    WebElement reviewsLink;
    @FindBy(xpath = "//span[text()='Products Reviews']")
    WebElement productReviewsLink;
    @FindBy(xpath = "//span[text()='Show Report']")
    WebElement showReportLink;



    @FindBy(xpath = "//*[@class=\"link-logout\"]")
    WebElement logOutLink;

    public ReportingManagerDashboardPage(WebDriver driver) {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

    public void clickCatalogLink() {
        utility.waitForElementPresent(catalogLink);
        catalogLink.click();
        Log.info(" Catalog link clicked");
    }
    public void clickReportsLink() {
        utility.waitForElementPresent(ReportsLink);
        ReportsLink.click();
        utility.sleep(2);
        Log.info(" Reports Link clicked");
    }
    public void clickSalesLink() {
        utility.waitForElementPresent(salesLink);
        salesLink.click();
        Log.info(" sales Link clicked");
    }
    public void clickOrdersLink() {
        utility.waitForElementPresent(ordersLink);
        ordersLink.click();
        Log.info(" orders Link clicked");
    }
    public void clickTaxLink() {
        utility.waitForElementPresent(taxLink);
        taxLink.click();
        Log.info(" Tax Link clicked");
    }
    public void clickInvoicedLink() {
        utility.waitForElementPresent(invoicedLink);
        invoicedLink.click();
        Log.info(" Invoiced Link clicked");
    }
    public void clickShippingLink() {
        utility.waitForElementPresent(shippingLink);
        shippingLink.click();
        Log.info(" Shipping Link clicked");
    }
    public void clickRefundsLink() {
        utility.waitForElementPresent(refundsLink);
        refundsLink.click();
        Log.info(" Refunds Link clicked");
    }
    public void clickCouponsLink(){
        utility.waitForElementPresent(couponsLink);
        couponsLink.click();
        Log.info("Coupons Link Clicked");
    }
    public void clickShoppingCartLink() {
        utility.waitForElementPresent(shoppingCartLink);
        shoppingCartLink.click();
        Log.info(" ShoppingCart Link clicked");
    }
    public void clickProductsInCartsLink() {
        utility.waitForElementPresent(productsInCartsLink);
        productsInCartsLink.click();
        Log.info(" ProductsInCarts Link clicked");
    }
    public void clickAbandonedCartsLink() {
        utility.waitForElementPresent(abandonedCartsLink);
        abandonedCartsLink.click();
        Log.info(" AbandonedCarts Link clicked");
    }
    public void clickProductsLink() {
        utility.waitForElementPresent(productsLink);
        productsLink.click();
        Log.info(" Products Link clicked");
    }
    public void clickBestsellersLink() {
        utility.waitForElementPresent(bestsellersLink);
        bestsellersLink.click();
        Log.info(" Bestsellers Link clicked");
    }
    public void clickProductsOrderedLink() {
        utility.waitForElementPresent(productsOrderedLink);
        productsOrderedLink.click();
        Log.info(" ProductsOrdered Link clicked");
    }
    public void clickMostViewedLink() {
        utility.waitForElementPresent(mostViewedLink);
        mostViewedLink.click();
        Log.info(" MostViewed Link clicked");
    }
    public void clickLowStockLink() {
        utility.waitForElementPresent(lowStockLink);
        lowStockLink.click();
        Log.info(" LowStock Link clicked");
    }
    public void clickDownloadsLink() {
        utility.waitForElementPresent(downloadsLink);
        downloadsLink.click();
        Log.info(" Downloads Link clicked");
    }
    public void clickCostumersLink() {
        utility.waitForElementPresent(costumersLink);
        costumersLink.click();
        Log.info(" Costumers Link clicked");
    }
    public void clickNewAccountsLink() {
        utility.waitForElementPresent(newAccountsLink);
        newAccountsLink.click();
        Log.info(" NewAccounts Link clicked");
    }
    public void clickCustomersByOrdersTotalLink() {
        utility.waitForElementPresent(customersByOrdersTotalLink);
        customersByOrdersTotalLink.click();
        Log.info(" CustomersByOrdersTotal Link clicked");
    }
    public void clickCustomersByNumberOfOrders() {
        utility.waitForElementPresent(customersByNumberOfOrdersLink);
        customersByNumberOfOrdersLink.click();
        Log.info(" CustomersByNumberOfOrders Link clicked");
    }
    public void clickTagsLink() {
        utility.waitForElementPresent(tagsLink);
        tagsLink.click();
        Log.info(" Tags Link clicked");
    }
    public void clickTagsCustomersLink() {
        utility.waitForElementPresent(tagsCustomersLink);
        tagsCustomersLink.click();
        Log.info(" TagsCustomers Link clicked");
    }
    public void clickTagProductsLink() {
        utility.waitForElementPresent(tagProductsLink);
        tagProductsLink.click();
        Log.info(" TagProducts Link clicked");
    }
    public void clickTagPopularLink() {
        utility.waitForElementPresent(tagPopularLink);
        tagPopularLink.click();
        Log.info(" TagPopular Link clicked");
    }
    public void clickReviewsLink() {
        utility.waitForElementPresent(reviewsLink);
        reviewsLink.click();
        Log.info(" Reviews Link clicked");
    }
    public void clickProductReviewsLink() {
        utility.waitForElementPresent(productReviewsLink);
        productReviewsLink.click();
        Log.info(" ProductReviews Link clicked");
    }
    public void clickShowReportLink(){
        utility.waitForElementPresent(showReportLink);
        showReportLink.click();
        Log.info("Show Report Link Clicked");
    }
    public void clickLogOutLink() {
        utility.waitForElementPresent(logOutLink);
        logOutLink.click();
        Log.info(" LogOut Link clicked");
    }









}
