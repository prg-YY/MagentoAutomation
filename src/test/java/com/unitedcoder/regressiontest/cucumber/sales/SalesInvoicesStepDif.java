//package com.unitedcoder.regressiontest.cucumber.sales;
//
//
//import com.seleniummaster.magento.backendpages.salespages.InvoicesPage;
//import com.seleniummaster.magento.backendpages.salespages.SalesDashboardPage;
//import com.seleniummaster.magento.utility.TestBasePage;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.Assert;
//
//public class SalesInvoicesStepDif extends TestBasePage {
//
//    SalesDashboardPage dashboardPage;
//    InvoicesPage invoicesPage=new InvoicesPage(driver);
//
//    @Given("sales manager on the dashboard page")
//    public void salesManagerOnTheDashboardPage() {
//        dashboardPage=new SalesDashboardPage(driver);
//    }
//
//    @When("sales manager click on invoice link")
//    public void salesManagerClickOnInvoiceLink() {
//        dashboardPage.clickOnSalesLink();
//        dashboardPage.clickInvoicesLink();
//    }
//
//    @And("sales manager can see all invoices")
//    public void salesManagerCanSeeAllInvoices() {
//        invoicesPage.viewAllInvoice();
//    }
//
//    @Then("verify user sow all invoices")
//    public void verifyUserSowAllInvoices() {
//        invoicesPage.totalInvoicesRecordDisplay();
//    }
//
//    @Given("sales manager on the invoices dashboard page")
//    public void salesManagerOnTheInvoicesDashboardPage() {
//        dashboardPage.clickOnSalesLink();
//        dashboardPage.clickInvoicesLink();
//    }
//
//    @When("enter Order id and click on search button")
//    public void enterOrderIdAndClickOnSearchButton() {
//        invoicesPage.enterOrderId("400000016");
//        invoicesPage.clickOnSearchButton();
//    }
//
//    @And("Sales manager click on view button")
//    public void salesManagerClickOnViewButton() {
//        invoicesPage.clickViewButton();
//    }
//
//    @And("add comments and click on save comment button")
//    public void addCommentsAndClickOnSaveCommentButton() {
//        invoicesPage.enterComment("team1 comment");
//        invoicesPage.clickNotifyToEmailCheckBox();
//        invoicesPage.clickOnSubmitCommentButton();
//    }
//
//    @Then("verify comment added successfully")
//    public void verifyCommentAddedSuccessfully() {
//        invoicesPage.isCommentDisplay();
//        Assert.assertTrue(invoicesPage.isCommentDisplay());
//    }
//
//    @Given("sales manager on the credit memos page")
//    public void salesManagerOnTheCreditMemosPage() {
//        dashboardPage.clickOnSalesLink();
//        dashboardPage.clickCreditMemosLink();
//    }
//
//    @When("define the order and click view")
//    public void defineTheOrderAndClickView() {
//        invoicesPage.enterOrderId("100000049");
//        invoicesPage.clickOnSearchButton();
//        invoicesPage.clickOnCreditMemosViewLink();
//    }
//
//    @And("refund records should be display")
//    public void refundRecordsShouldBeDisplay() {
//        invoicesPage.totalRefundRecordIsDisplayed();
//
//    }
//
//    @Then("verify refunds record already displayed")
//    public void verifyRefundsRecordAlreadyDisplayed() {
//        invoicesPage.isTotalRefundsDisplayed();
//        Assert.assertTrue(invoicesPage.isTotalRefundsDisplayed());
//    }
//}
