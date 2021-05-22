package com.unitedcoder.regressiontest.cucumber.reporting;

import com.seleniummaster.magento.backendpages.ReportingModule.ReportingManagerDashboardPage;
import com.seleniummaster.magento.backendpages.ReportingModule.SalesPage;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;

public class SalesStepDefinition extends TestBasePage {
    ReportingManagerDashboardPage dashboardPage = new ReportingManagerDashboardPage(driver);
    SalesPage salesPage=new SalesPage(driver);
    TestUtility utility=new TestUtility(driver);


    @When("click on Reports drop down list than click on Orders under of Sales")
    public void clickOnReportsDropDownListThanClickOnOrdersUnderOfSales() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickSalesLink();
        dashboardPage.clickOrdersLink();
    }

    @And("fill the Order Date on From field and To field then click on Show Report Button")
    public void fillTheOrderDateOnFromFieldAndToFieldThenClickOnShowReportButton() {
        salesPage.totalOrderedReport();
        dashboardPage.clickShowReportLink();
        utility.sleep(2);
    }

    @Then("verify total count of Ordered Report")
    public void verifyTotalCountOfOrderedReport() {
        salesPage.verifyTotalOrderedReportSuccessMassage();
        utility.takeScreenShot("OrderReport.png",driver);
    }

    @When("click on Reports drop down list than click on Tax under of Sales")
    public void clickOnReportsDropDownListThanClickOnTaxUnderOfSales() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickSalesLink();
        dashboardPage.clickTaxLink();
    }

    @And("fill the Tax Date on  From field and TO field then click on Show Report Button")
    public void fillTheTaxDateOnFromFieldAndTOFieldThenClickOnShowReportButton() {
        salesPage.totalOrderedReport();
        dashboardPage.clickShowReportLink();
        utility.sleep(2);

    }

    @Then("verify Order Taxes Report Grouped by Tax Tate")
    public void verifyOrderTaxesReportGroupedByTaxTate() {
        salesPage.verifyOrderTaxesReportGroupedByTaxRate();
        utility.takeScreenShot("OrderTaxesReport.png",driver);
    }

    @When("click on Reports drop down list than click Invoiced under of Sales")
    public void clickOnReportsDropDownListThanClickInvoicedUnderOfSales() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickSalesLink();
        dashboardPage.clickInvoicedLink();
    }

    @And("fill the Invoiced Date on From field and To field then click on Show Report Button")
    public void fillTheInvoicedDateOnFromFieldAndToFieldThenClickOnShowReportButton() {
        salesPage.totalOrderedReport();
        dashboardPage.clickShowReportLink();
        utility.sleep(2);
    }

    @Then("verify Total Invoiced vs.Paid Report")
    public void verifyTotalInvoicedVsPaidReport() {
        salesPage.verifyTotalInvoicedVsPaidReport();
        utility.takeScreenShot("TotalInvoiced.png",driver);
    }

    @When("click on Reports drop down list than click on Shipping under of Sales")
    public void clickOnReportsDropDownListThanClickOnShippingUnderOfSales() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickSalesLink();
        dashboardPage.clickShippingLink();
        utility.sleep(2);
    }

    @And("fill the Shipping Date on From field and To field then click on Show Report Button")
    public void fillTheShippingDateOnFromFieldAndToFieldThenClickOnShowReportButton() {
        salesPage.totalOrderedReport();
        dashboardPage.clickShowReportLink();
    }

    @Then("verify Total Shipped Report")
    public void verifyTotalShippedReport() {
        salesPage.verifyTotalShippedReport();
        utility.takeScreenShot("TotalShippedReport.png",driver);

    }

    @When("click on Reports drop down list than click on Refunds under of Sales")
    public void clickOnReportsDropDownListThanClickOnRefundsUnderOfSales() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickSalesLink();
        dashboardPage.clickRefundsLink();
    }

    @And("fill the Refunded Date From field and To field then click on Show Report Button")
    public void fillTheRefundedDateFromFieldAndToFieldThenClickOnShowReportButton() {
        salesPage.totalOrderedReport();
        dashboardPage.clickShowReportLink();
        utility.sleep(2);
    }

    @Then("verify Total Refunded Report")
    public void verifyTotalRefundedReport() {
        salesPage.verifyTotalRefundedReport();
        utility.takeScreenShot("TotalRefundedReport.png",driver);
    }

    @When("click on Reports drop down list than click on Coupons under of Sales")
    public void clickOnReportsDropDownListThanClickOnCouponsUnderOfSales() {
        dashboardPage.clickReportsLink();
        dashboardPage.clickSalesLink();
        dashboardPage.clickCouponsLink();
    }

    @And("fill the Coupons Date From field and To field then click on Show Report Button")
    public void fillTheCouponsDateFromFieldAndToFieldThenClickOnShowReportButton() {
        salesPage.totalOrderedReport();
        dashboardPage.clickShowReportLink();
        utility.sleep(2);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1000)");
    }

    @Then("verify Coupons Usage Report")
    public void verifyCouponsUsageReport() {
        salesPage.verifyCouponsUsageReport();
        utility.takeScreenShot("CouponsUsageReport.png",driver);
    }


}
