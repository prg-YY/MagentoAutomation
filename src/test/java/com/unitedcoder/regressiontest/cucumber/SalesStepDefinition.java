package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.magento.backendpages.ReportingModule.ReportingManagerDashboardPage;
import com.seleniummaster.magento.backendpages.ReportingModule.SalesPage;
import com.seleniummaster.magento.utility.TestBasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SalesStepDefinition extends TestBasePage {
    ReportingManagerDashboardPage dashboardPage = new ReportingManagerDashboardPage(driver);
    static SalesPage salesPage;


    @When("click on Reports drop down list than click on Orders under of Sales")
    public void clickOnReportsDropDownListThanClickOnOrdersUnderOfSales() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickSalesLink();
        dashboardPage.clickOrdersLink();
    }

    @And("fill the Order Date on From field and To field then click on Show Report Button")
    public void fillTheOrderDateOnFromFieldAndToFieldThenClickOnShowReportButton() {
        salesPage = new SalesPage(driver);
        salesPage.totalOrderedReport();
        dashboardPage.clickShowReportLink();
    }

    @Then("verify total count of Ordered Report")
    public void verifyTotalCountOfOrderedReport() {
        salesPage = new SalesPage(driver);
        salesPage.verifyTotalOrderedReportSuccessMassage();
    }

    @When("click on Reports drop down list than click on Tax under of Sales")
    public void clickOnReportsDropDownListThanClickOnTaxUnderOfSales() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickSalesLink();
        dashboardPage.clickTaxLink();
    }

    @And("fill the Tax Date on  From field and TO field then click on Show Report Button")
    public void fillTheTaxDateOnFromFieldAndTOFieldThenClickOnShowReportButton() {
        salesPage = new SalesPage(driver);
        salesPage.totalOrderedReport();
        dashboardPage.clickShowReportLink();

    }

    @Then("verify Order Taxes Report Grouped by Tax Tate")
    public void verifyOrderTaxesReportGroupedByTaxTate() {
        salesPage = new SalesPage(driver);
        salesPage.verifyOrderTaxesReportGroupedByTaxRate();
    }

    @When("click on Reports drop down list than click Invoiced under of Sales")
    public void clickOnReportsDropDownListThanClickInvoicedUnderOfSales() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickSalesLink();
        dashboardPage.clickInvoicedLink();
    }

    @And("fill the Invoiced Date on From field and To field then click on Show Report Button")
    public void fillTheInvoicedDateOnFromFieldAndToFieldThenClickOnShowReportButton() {
        salesPage = new SalesPage(driver);
        salesPage.totalOrderedReport();
        dashboardPage.clickShowReportLink();
    }

    @Then("verify Total Invoiced vs.Paid Report")
    public void verifyTotalInvoicedVsPaidReport() {
        salesPage = new SalesPage(driver);
        salesPage.verifyTotalInvoicedVsPaidReport();
    }

    @When("click on Reports drop down list than click on Shipping under of Sales")
    public void clickOnReportsDropDownListThanClickOnShippingUnderOfSales() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickSalesLink();
        dashboardPage.clickShippingLink();
    }

    @And("fill the Shipping Date on From field and To field then click on Show Report Button")
    public void fillTheShippingDateOnFromFieldAndToFieldThenClickOnShowReportButton() {
        salesPage = new SalesPage(driver);
        salesPage.totalOrderedReport();
        dashboardPage.clickShowReportLink();
    }

    @Then("verify Total Shipped Report")
    public void verifyTotalShippedReport() {
        salesPage = new SalesPage(driver);
        salesPage.verifyTotalShippedReport();

    }

    @When("click on Reports drop down list than click on Refunds under of Sales")
    public void clickOnReportsDropDownListThanClickOnRefundsUnderOfSales() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickSalesLink();
        dashboardPage.clickRefundsLink();
    }

    @And("fill the Refunded Date From field and To field then click on Show Report Button")
    public void fillTheRefundedDateFromFieldAndToFieldThenClickOnShowReportButton() {
        salesPage = new SalesPage(driver);
        salesPage.totalOrderedReport();
        dashboardPage.clickShowReportLink();
    }

    @Then("verify Total Refunded Report")
    public void verifyTotalRefundedReport() {
        salesPage = new SalesPage(driver);
        salesPage.verifyTotalRefundedReport();
    }

    @When("click on Reports drop down list than click on Coupons under of Sales")
    public void clickOnReportsDropDownListThanClickOnCouponsUnderOfSales() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickSalesLink();
        dashboardPage.clickCouponsLink();
    }

    @And("fill the Coupons Date From field and To field then click on Show Report Button")
    public void fillTheCouponsDateFromFieldAndToFieldThenClickOnShowReportButton() {
        salesPage = new SalesPage(driver);
        salesPage.totalOrderedReport();
        dashboardPage.clickShowReportLink();
    }

    @Then("verify Coupons Usage Report")
    public void verifyCouponsUsageReport() {
        salesPage = new SalesPage(driver);
        salesPage.verifyCouponsUsageReport();
    }


}
