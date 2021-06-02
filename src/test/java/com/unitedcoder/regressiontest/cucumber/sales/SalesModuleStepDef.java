package com.unitedcoder.regressiontest.cucumber.sales;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.salespages.*;
import com.seleniummaster.magento.utility.TestBasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SalesModuleStepDef extends TestBasePage {
    SalesDashboardPage dashboardPage=new SalesDashboardPage(driver);
    OrdersPage ordersPage=new OrdersPage(driver);
    InvoicesPage invoicesPage=new InvoicesPage(driver);
    ShipmentPage shipmentPage=new ShipmentPage(driver);
    CreditMemosPage creditMemosPage=new CreditMemosPage(driver);
    TaxRulesPage rulesPage=new TaxRulesPage(driver);

    @Given("sales manager on the sales module dashboard")
    public void salesManagerOnTheSalesModuleDashboard() {
        dashboardPage=new SalesDashboardPage(driver);
    }

    @When("sales manager go to order page and click create new order link")
    public void salesManagerGoToOrderPageAndClickCreateNewOrderLink() {
        dashboardPage.goToOrderPage();
        ordersPage.clickOnCreateOrderLink();
    }

    @And("sales manager choose customer for order")
    public void salesManagerChooseCustomerForOrder() {
        ordersPage.searchCustomerForOrder(prop.getProperty("FrondEmail1"));
    }

    @And("sales manager add products to order")
    public void salesManagerAddProductsToOrder() {
        ordersPage.addProductForOrder();
    }

    @And("choose payment method and shipment and click submit order button")
    public void choosePaymentMethodAndShipmentAndClickSubmitOrderButton() {
        ordersPage.clickShipmentAndSubmitButton();
    }

    @Then("The New Order Created Successfully")
    public void theNewOrderCreatedSuccessfully() {
        ordersPage.verifyOrderCreatedSuccessfully();
        Assert.assertTrue(ordersPage.verifyOrderCreatedSuccessfully());
    }

    @When("sales manager go to order page")
    public void salesManagerGoToOrderPage() {
        dashboardPage.goToOrderPage();
    }

    @And("user choose  order for update and click on edit button")
    public void userChooseOrderForUpdateAndClickOnEditButton() {
        ordersPage.selectPendingOrder(prop.getProperty("pending"));
        ordersPage.clickOnOrderViewForUpdate();
        ordersPage.clickEditButton();
    }

    @And("Add some information for update")
    public void addSomeInformationForUpdate() {
        ordersPage.enterCompanyName(prop.getProperty("companyName"));
        ordersPage.clickEditSubmitButton();
    }

    @Then("Existing order updated successfully")
    public void existingOrderUpdatedSuccessfully() {
        ordersPage.isOrderUpdatedSuccessfully();
        Assert.assertTrue(ordersPage.isOrderUpdatedSuccessfully());
    }

    @And("sales manager choose one order to cancel")
    public void salesManagerChooseOneOrderToCancel() {
        ordersPage.selectPendingOrder("pending");
        ordersPage.clickOrderCheckBox();
    }

    @And("click on cancel order action and submit it")
    public void clickOnCancelOrderActionAndSubmitIt() {
        ordersPage.selectCancel(prop.getProperty("cancelOrder"));
        ordersPage.clickOnCancelSubmitButton();
    }

    @Then("The order canceled successfully")
    public void theOrderCanceledSuccessfully() {
        ordersPage.isCancelSuccessMessageDisplayed();
        Assert.assertTrue(ordersPage.isCancelSuccessMessageDisplayed());
    }

    @When("sales manager click on invoice link")
    public void salesManagerClickOnInvoiceLink() {
        dashboardPage.goToInvoicesPage();
    }

    @And("sales manager can see all invoices")
    public void salesManagerCanSeeAllInvoices() {
        invoicesPage.viewAllInvoice();
    }

    @Then("verify user sow all invoices")
    public void verifyUserSowAllInvoices() {
        invoicesPage.totalInvoicesRecordDisplay();
        Assert.assertTrue(invoicesPage.totalInvoicesRecordDisplay());
    }

    @When("sales manager go to invoices page")
    public void salesManagerGoToInvoicesPage() {
        dashboardPage.goToInvoicesPage();
    }

    @And("sales manager define a invoice history")
    public void salesManagerDefineAInvoiceHistory() {
       invoicesPage.defineInvoiceHistory(prop.getProperty("invoicesId"));
    }

    @And("sales manager add comment to invoice history")
    public void salesManagerAddCommentToInvoiceHistory() {
        invoicesPage.addCommentToInvoice(prop.getProperty("invoiceComment"));
    }

    @Then("verify comment added successfully")
    public void verifyCommentAddedSuccessfully() {
        invoicesPage.isCommentDisplay();
        Assert.assertTrue(invoicesPage.isCommentDisplay());
    }

    @When("sales manager go to credit memos page")
    public void salesManagerGoToCreditMemosPage() {
        dashboardPage.goToCreditMemosPage();
    }

    @And("sales manager define a order and click view button")
    public void salesManagerDefineAOrderAndClickViewButton() {
        invoicesPage.defineCreditMemos(prop.getProperty("creditMemosId"));
        invoicesPage.isRefundsDisplay();
    }

    @Then("refunds record displayed successfully")
    public void refundsRecordDisplayedSuccessfully() {
        invoicesPage.isRefundsDisplay();
        Assert.assertTrue(invoicesPage.isRefundsDisplay());
    }

    @When("sales manager go to shipment page")
    public void salesManagerGoToShipmentPage() {
        dashboardPage.goToShipmentPage();
    }

    @And("sales manager define a shipment to edit")
    public void salesManagerDefineAShipmentToEdit() {
        shipmentPage.searchShipment(prop.getProperty("shipmentId"));
    }

    @And("sales manager add shipping and tracking information")
    public void salesManagerAddShippingAndTrackingInformation() {
        shipmentPage.addShipment();
        shipmentPage.addComment(prop.getProperty("commentText"));
    }

    @Then("shipping and tracking information added successfully")
    public void shippingAndTrackingInformationAddedSuccessfully() {
        shipmentPage.shipmentUpdatedSuccessfully();
        Assert.assertTrue(shipmentPage.shipmentUpdatedSuccessfully());
    }

    @When("sales manager click credit memos link")
    public void salesManagerClickCreditMemosLink() {
        dashboardPage.goToCreditMemosPage();
    }

    @And("sales manager see credit memos")
    public void salesManagerSeeCreditMemos() {
        creditMemosPage.viewCreditMemos();
    }

    @Then("credit memos records already displayed")
    public void creditMemosRecordsAlreadyDisplayed() {
        creditMemosPage.viewCreditMemos();
        Assert.assertTrue(creditMemosPage.viewCreditMemos());
    }

    @When("sales manager go to manage tax rule page")
    public void salesManagerGoToManageTaxRulePage() {
        dashboardPage.goToManageTaxRulesPage();
    }

    @And("sales manager click on add new rule button")
    public void salesManagerClickOnAddNewRuleButton() {
        rulesPage.clickAddNewTaxRuleButton();
    }

    @And("sales manager fill out all required filed")
    public void salesManagerFillOutAllRequiredFiled() {
        String taxRuleName=prop.getProperty("taxRuleName");
        String customerTaxClass=prop.getProperty("vipValue");
        String productTaxClass=prop.getProperty("taxableGoods");
        String taxRate=prop.getProperty("taxRateValue");
        rulesPage.createTaxRule(taxRuleName,customerTaxClass,productTaxClass,taxRate);
    }

    @Then("new tax rule added successfully")
    public void newTaxRuleAddedSuccessfully() {
        rulesPage.successMessageIsDisplay();
        Assert.assertTrue(rulesPage.successMessageIsDisplay());
    }

    @And("sales manager define one rule to edit")
    public void salesManagerDefineOneRuleToEdit() {
        rulesPage.defineTaxRule(prop.getProperty("taxRuleName"));
    }

    @And("sales manager edit some information")
    public void salesManagerEditSomeInformation() {
      rulesPage.editTaxRule(prop.getProperty("goldCustomer"));
    }

    @Then("Existing tax rule updated successfully")
    public void existingTaxRuleUpdatedSuccessfully() {
        Assert.assertTrue(rulesPage.successMessageIsDisplay());
    }

    @And("sales manager define one tax rule for delete")
    public void salesManagerDefineOneTaxRuleForDelete() {
        rulesPage.defineTaxRule(prop.getProperty("taxRuleName"));
    }

    @And("sales manager click on delete button")
    public void salesManagerClickOnDeleteButton() {
        rulesPage.deleteTaxRule();
    }

    @Then("tax rule deleted successfully")
    public void taxRuleDeletedSuccessfully() {
        Assert.assertTrue(rulesPage.deleteSuccessfulMessageIsDisplayed());
    }
}
