package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.magento.backendpages.ReportingModule.CustomersTagsAndReviewsPage;
import com.seleniummaster.magento.backendpages.ReportingModule.ReportingManagerDashboardPage;
import com.seleniummaster.magento.backendpages.ReportingModule.SalesPage;
import com.seleniummaster.magento.backendpages.ReportingModule.ShoppingCartAndProductsPage;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;

public class ShoppingCartAndProductsStepD extends TestBasePage {
    ReportingManagerDashboardPage dashboardPage = new ReportingManagerDashboardPage(driver);
    ShoppingCartAndProductsPage cartAndProductsPage = new ShoppingCartAndProductsPage(driver);
    CustomersTagsAndReviewsPage customersTagsAndReviewsPage=new CustomersTagsAndReviewsPage(driver);
    SalesPage salesPage = new SalesPage(driver);
    TestUtility utility=new TestUtility(driver);


    @When("click on Reports drop down list than click on Product in carts under of Shopping Cart")
    public void clickOnReportsDropDownListThanClickOnProductInCartsUnderOfShoppingCart() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickShoppingCartLink();
        dashboardPage.clickProductsInCartsLink();
    }

    @Then("verify Products in carts Report")
    public void verifyProductsInCartsReport() {
        cartAndProductsPage.clickProductsInCartsSuccessfulMassage();
        utility.sleep(1);
        utility.takeScreenShot("Products_In_Carts_Report",driver);


    }

    @When("click on Reports drop down list than click on Abandoned carts of Shopping Cart")
    public void clickOnReportsDropDownListThanClickOnAbandonedCartsOfShoppingCart() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickShoppingCartLink();
        dashboardPage.clickAbandonedCartsLink();
    }

    @Then("verify Abandoned carts Report")
    public void verifyAbandonedCartsReport() {
        cartAndProductsPage.clickAbandonedCartsSuccessfulMassage();
        utility.sleep(1);
        utility.takeScreenShot("Abandoned_Carts_Report",driver);
    }

    @When("click on Reports drop down list than click on Bestsellers under of Products")
    public void clickOnReportsDropDownListThanClickOnBestsellersUnderOfProducts() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickProductsLink();
        dashboardPage.clickBestsellersLink();
    }

    @And("fill the Order Date on From field and To field then click on Show Report Button\\(Bestsellers)")
    public void fillTheOrderDateOnFromFieldAndToFieldThenClickOnShowReportButtonBestsellers() {
        salesPage.totalOrderedReport();
        dashboardPage.clickShowReportLink();
        utility.sleep(1);
    }

    @Then("verify Products Bestsellers Report")
    public void verifyProductsBestsellersReport() {
        cartAndProductsPage.clickProductsBestsellersReportSuccessfulMassage();
        utility.takeScreenShot("Products_Bestsellers_Reports",driver);
    }

    @When("click on Reports drop down list than click on Products Ordered of Products")
    public void clickOnReportsDropDownListThanClickOnProductsOrderedOfProducts() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickProductsLink();
        dashboardPage.clickProductsOrderedLink();
    }

    @And("fill the Order Date on From field and To field then click on Show Report Button\\(ProductsOrder)")
    public void fillTheOrderDateOnFromFieldAndToFieldThenClickOnShowReportButtonProductsOrder() {
        customersTagsAndReviewsPage.chooseDateOfCustomersByOrdersTotalAndClickAndRefreshButton();
        utility.sleep(2);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,4000)");
    }


    @Then("verify Products Ordered Report")
    public void verifyProductsOrderedReport() {
        cartAndProductsPage.clickProductsOrderedSuccessfulMassage();
        utility.sleep(2);
        utility.takeScreenShot("Products_Ordered_Report",driver);
    }

    @When("click on Reports drop down list than click on Most Viewed of Products")
    public void clickOnReportsDropDownListThanClickOnMostViewedOfProducts() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickProductsLink();
        dashboardPage.clickMostViewedLink();
    }

    @And("fill the Order Date on From field and To field then click on Show Report Button\\(Most Viewed)")
    public void fillTheOrderDateOnFromFieldAndToFieldThenClickOnShowReportButtonMostViewed() {
        utility.sleep(1);
        salesPage.totalOrderedReport();
        dashboardPage.clickShowReportLink();

    }

    @Then("verify Most Viewed Report Report")
    public void verifyMostViewedReportReport() {
        cartAndProductsPage.clickMostViewedSuccessfulMassage();
        utility.takeScreenShot("Most_Viewed_Report",driver);
    }

    @When("click on Reports drop down list than click on Low Stock of Products")
    public void clickOnReportsDropDownListThanClickOnLowStockOfProducts() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickProductsLink();
        utility.sleep(1);
        dashboardPage.clickLowStockLink();
    }

    @Then("verify Low stock Report")
    public void verifyLowStockReport() {
        cartAndProductsPage.clickLowStockSuccessfulMassage();
        utility.takeScreenShot("Low_Stock_Report",driver);
    }

    @When("click on Reports drop down list than click on Downloads of Products")
    public void clickOnReportsDropDownListThanClickOnDownloadsOfProducts() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickProductsLink();
        utility.sleep(1);
        dashboardPage.clickDownloadsLink();
    }

    @And("fill the Product Name on the Text box then click the search Button")
    public void fillTheProductNameOnTheTextBoxThenClickTheSearchButton() {
        cartAndProductsPage.clickProductNameTextBoxDownloads();
        utility.sleep(1);
        cartAndProductsPage.clickSearchButtonDownloads();
        utility.sleep(1);
    }

    @Then("verify Downloads Report")
    public void verifyDownloadsReport() {
        cartAndProductsPage.clickDownloadsSuccessMassage();
        utility.takeScreenShot("Donloads_Report",driver);
    }


}
