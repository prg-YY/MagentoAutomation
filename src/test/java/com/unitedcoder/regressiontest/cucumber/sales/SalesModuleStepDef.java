package com.unitedcoder.regressiontest.cucumber.sales;

import com.seleniummaster.magento.backendpages.salespages.InvoicesPage;
import com.seleniummaster.magento.backendpages.salespages.OrdersPage;
import com.seleniummaster.magento.backendpages.salespages.SalesDashboardPage;
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

    @Given("sales manager on the sales module dashboard")
    public void salesManagerOnTheSalesModuleDashboard() {
        OrdersPage ordersPage=new OrdersPage(driver);
    }

    @When("sales manager go to order page and click create new order link")
    public void salesManagerGoToOrderPageAndClickCreateNewOrderLink() {
        dashboardPage.goToOrderPage();
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
        ordersPage.clickOrderCheckBox();
    }

    @And("click on cancel order action and submit it")
    public void clickOnCancelOrderActionAndSubmitIt() {
        ordersPage.selectCancel();
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
    }

    @Then("verify user sow all invoices")
    public void verifyUserSowAllInvoices() {
    }

    @When("sales manager go to invoices page")
    public void salesManagerGoToInvoicesPage() {
    }

    @And("sales manager define a invoice history")
    public void salesManagerDefineAInvoiceHistory() {
    }

    @And("sales manager add comment to invoice history")
    public void salesManagerAddCommentToInvoiceHistory() {
    }

    @Then("verify comment added successfully")
    public void verifyCommentAddedSuccessfully() {
    }

    @And("sales manager define a order and click view button")
    public void salesManagerDefineAOrderAndClickViewButton() {
    }

    @Then("refunds record displayed successfully")
    public void refundsRecordDisplayedSuccessfully() {
    }

    @When("sales manager go to shipment page")
    public void salesManagerGoToShipmentPage() {
    }

    @And("sales manager define a shipment to edit")
    public void salesManagerDefineAShipmentToEdit() {
    }

    @And("sales manager add shipping and tracking information")
    public void salesManagerAddShippingAndTrackingInformation() {
    }

    @Then("shipping and tracking information added successfully")
    public void shippingAndTrackingInformationAddedSuccessfully() {
    }

    @When("sales manager click credit memos link")
    public void salesManagerClickCreditMemosLink() {
    }

    @And("sales manager see credit memos")
    public void salesManagerSeeCreditMemos() {
    }

    @Then("credit memos records already displayed")
    public void creditMemosRecordsAlreadyDisplayed() {
    }

    @When("sales manager go to manage tax rule page")
    public void salesManagerGoToManageTaxRulePage() {
    }

    @And("sales manager click on add new rule button")
    public void salesManagerClickOnAddNewRuleButton() {
    }

    @And("sales manager fill out all required filed")
    public void salesManagerFillOutAllRequiredFiled() {
    }

    @Then("new tax rule added successfully")
    public void newTaxRuleAddedSuccessfully() {
    }

    @And("sales manager define one rule to edit")
    public void salesManagerDefineOneRuleToEdit() {
    }

    @And("sales manager edit some information")
    public void salesManagerEditSomeInformation() {
    }

    @Then("Existing tax rule updated successfully")
    public void existingTaxRuleUpdatedSuccessfully() {
    }
}
