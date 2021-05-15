package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.magento.backendpages.ReportingModule.CustomersTagsAndReviewsPage;
import com.seleniummaster.magento.backendpages.ReportingModule.ReportingManagerDashboardPage;
import com.seleniummaster.magento.backendpages.ReportingModule.SalesPage;
import com.seleniummaster.magento.backendpages.ReportingModule.ShoppingCartAndProductsPage;
import com.seleniummaster.magento.utility.TestBasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomersTagsAndReviewsFefStep extends TestBasePage {
    ReportingManagerDashboardPage dashboardPage = new ReportingManagerDashboardPage(driver);
    ShoppingCartAndProductsPage cartAndProductsPage = new ShoppingCartAndProductsPage(driver);
    CustomersTagsAndReviewsPage customersTagsAndReviewsPage=new CustomersTagsAndReviewsPage(driver);


    @When("click on Reports drop down list than click on New Accounts under of Customers")
    public void clickOnReportsDropDownListThanClickOnNewAccountsUnderOfCustomers() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickCostumersLink();
        dashboardPage.clickNewAccountsLink();
    }

    @And("fill the From field and To field then click on Refresh Button\\(New Accounts Report)")
    public void fillTheFromFieldAndToFieldThenClickOnRefreshButtonNewAccountsReport() {
        cartAndProductsPage.productsOrdered();
        cartAndProductsPage.clickRefreshButton();
    }

    @Then("verify New Accounts on the right up")
    public void verifyNewAccountsOnTheRightUp() {
        customersTagsAndReviewsPage.clickNewAccountsSuccessMassage();
    }

    @When("click on Reports drop down list than click on Customers by Orders Total under of Customers")
    public void clickOnReportsDropDownListThanClickOnCustomersByOrdersTotalUnderOfCustomers() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickCostumersLink();
        dashboardPage.clickCustomersByOrdersTotalLink();
    }

    @And("fill the From field and To field then click on Refresh Button\\(Customers by Orders Total Report)")
    public void fillTheFromFieldAndToFieldThenClickOnRefreshButtonCustomersByOrdersTotalReport() {
        cartAndProductsPage.productsOrdered();
        cartAndProductsPage.clickRefreshButton();
    }

    @Then("verify Customers by Orders Total on the right up")
    public void verifyCustomersByOrdersTotalOnTheRightUp() {
        customersTagsAndReviewsPage.clickCustomersByOrdersTotalSuccessMassage();
    }

    @When("click on Reports drop down list than click on Customers by number of orders Report under of Customers")
    public void clickOnReportsDropDownListThanClickOnCustomersByNumberOfOrdersReportUnderOfCustomers() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickCostumersLink();
        dashboardPage.clickCustomersByNumberOfOrders();
    }

    @And("fill the From field and To field then click on Refresh Button\\(Customers by number of orders Report)")
    public void fillTheFromFieldAndToFieldThenClickOnRefreshButtonCustomersByNumberOfOrdersReport() {
        cartAndProductsPage.productsOrdered();
        cartAndProductsPage.clickRefreshButton();
    }

    @Then("verify Customers by number of orders Report on the right up")
    public void verifyCustomersByNumberOfOrdersReportOnTheRightUp() {
        customersTagsAndReviewsPage.clickCustomersByNumberOfOrdersSuccessMassage();
    }

    @When("click on Reports drop down list than click on Customers under of Tags")
    public void clickOnReportsDropDownListThanClickOnCustomersUnderOfTags() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickTagsLink();
        dashboardPage.clickTagsCustomersLink();
    }

    @Then("verify Customers Tags on the right up")
    public void verifyCustomersTagsOnTheRightUp() {
        customersTagsAndReviewsPage.clickCustomersTagsSuccessMassage();
    }

    @When("click on Reports drop down list than click on Products under of Tags")
    public void clickOnReportsDropDownListThanClickOnProductsUnderOfTags() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickTagsLink();
        dashboardPage.clickTagProductsLink();
    }

    @Then("verify Products Tags on the right up")
    public void verifyProductsTagsOnTheRightUp() {
        customersTagsAndReviewsPage.clickProductsTagsSuccessMassage();
    }

    @When("click on Reports drop down list than click on Popular under of Tags")
    public void clickOnReportsDropDownListThanClickOnPopularUnderOfTags() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickTagsLink();
        dashboardPage.clickTagPopularLink();
    }

    @Then("verify Popular Tags on the right up")
    public void verifyPopularTagsOnTheRightUp() {
        customersTagsAndReviewsPage.clickPopularTagsSuccessMassage();
    }

    @When("click on Reports drop down list than click on Product Reviews under of Reviews")
    public void clickOnReportsDropDownListThanClickOnProductReviewsUnderOfReviews() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickReviewsLink();
        dashboardPage.clickProductReviewsLink();
    }

    @Then("verify Product Reviews on the right up")
    public void verifyProductReviewsOnTheRightUp() {
        customersTagsAndReviewsPage.clickProductsReviewsSuccessMassage();
    }
}
