package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.magento.backendpages.ReportingModule.ReportingManagerDashboardPage;
import com.seleniummaster.magento.backendpages.ReportingModule.SalesPage;
import com.seleniummaster.magento.backendpages.ReportingModule.ShoppingCartAndProductsPage;
import com.seleniummaster.magento.utility.TestBasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingCartAndProductsStepD extends TestBasePage {
    ReportingManagerDashboardPage dashboardPage = new ReportingManagerDashboardPage(driver);
    ShoppingCartAndProductsPage cartAndProductsPage = new ShoppingCartAndProductsPage(driver);
    SalesPage salesPage = new SalesPage(driver);


    @When("click on Reports drop down list than click on Product in carts under of Shopping Cart")
    public void clickOnReportsDropDownListThanClickOnProductInCartsUnderOfShoppingCart() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickShoppingCartLink();
        dashboardPage.clickProductsInCartsLink();
    }

    @Then("verify Products in carts Report")
    public void verifyProductsInCartsReport() {
        cartAndProductsPage.clickProductsInCartsSuccessfulMassage();

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
    }

    @Then("verify Products Bestsellers Report")
    public void verifyProductsBestsellersReport() {
        cartAndProductsPage.clickProductsBestsellersReportSuccessfulMassage();
    }

    @When("click on Reports drop down list than click on Products Ordered of Products")
    public void clickOnReportsDropDownListThanClickOnProductsOrderedOfProducts() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickProductsLink();
        dashboardPage.clickProductsOrderedLink();
    }

    @And("fill the Order Date on From field and To field then click on Show Report Button\\(ProductsOrder)")
    public void fillTheOrderDateOnFromFieldAndToFieldThenClickOnShowReportButtonProductsOrder() {
        cartAndProductsPage.productsOrdered();
    }


    @Then("verify Products Ordered Report")
    public void verifyProductsOrderedReport() {
        cartAndProductsPage.clickProductsOrderedSuccessfulMassage();
    }

    @When("click on Reports drop down list than click on Most Viewed of Products")
    public void clickOnReportsDropDownListThanClickOnMostViewedOfProducts() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickProductsLink();
        dashboardPage.clickMostViewedLink();
    }

    @And("fill the Order Date on From field and To field then click on Show Report Button\\(Most Viewed)")
    public void fillTheOrderDateOnFromFieldAndToFieldThenClickOnShowReportButtonMostViewed() {
        salesPage.totalOrderedReport();
    }

    @Then("verify Most Viewed Report Report")
    public void verifyMostViewedReportReport() {
        cartAndProductsPage.clickMostViewedSuccessfulMassage();
    }

    @When("click on Reports drop down list than click on Low Stock of Products")
    public void clickOnReportsDropDownListThanClickOnLowStockOfProducts() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickProductsLink();
        dashboardPage.clickLowStockLink();
    }

    @Then("verify Low stock Report")
    public void verifyLowStockReport() {
        cartAndProductsPage.clickLowStockSuccessfulMassage();
    }

    @When("click on Reports drop down list than click on Downloads of Products")
    public void clickOnReportsDropDownListThanClickOnDownloadsOfProducts() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickProductsLink();
        dashboardPage.clickDownloadsLink();
    }

    @And("fill the Product Name on the Text box then click the search Button")
    public void fillTheProductNameOnTheTextBoxThenClickTheSearchButton() {
        cartAndProductsPage.clickProductNameTextBoxDownloads();
        cartAndProductsPage.clickSearchButtonDownloads();
    }

    @Then("verify Downloads Report")
    public void verifyDownloadsReport() {
        cartAndProductsPage.clickDownloadsSuccessMassage();
    }


}
