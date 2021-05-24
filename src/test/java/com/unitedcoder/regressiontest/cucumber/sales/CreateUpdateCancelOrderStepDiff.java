//package com.unitedcoder.regressiontest.cucumber.sales;
//
//import com.seleniummaster.magento.backendpages.salespages.OrdersPage;
//import com.seleniummaster.magento.backendpages.salespages.SalesDashboardPage;
//import com.seleniummaster.magento.utility.TestBasePage;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.Assert;
//
//public class CreateUpdateCancelOrderStepDiff extends TestBasePage {
//    SalesDashboardPage dashboardPage=new SalesDashboardPage(driver);
//    OrdersPage ordersPage=new OrdersPage(driver);
//    @When("sales manager on the create order orders page")
//    public void salesManagerOnTheCreateOrderOrdersPage() {
//        dashboardPage.clickOnSalesLink();
//        dashboardPage.clickOrdersLink();
//        ordersPage.clickOnCreateOrderLink();
//    }
//
//    @And("choose customer for order")
//    public void chooseCustomerForOrder() {
//
//        ordersPage.searchCustomerForOrder(prop.getProperty("FrondEmail1"));
//    }
//
//    @And("add products to order")
//    public void addProductsToOrder() {
//        ordersPage.addProductForOrder();
//    }
//
//    @And("choose payment method and shipment and click submit order button")
//    public void choosePaymentMethodAndShipmentAndClickSubmitOrderButton() {
//
//        ordersPage.clickShipmentAndSubmitButton();
//    }
//
//    @Then("verify the order successfully created")
//    public void verifyTheOrderSuccessfullyCreated() {
//        ordersPage.verifyOrderCreatedSuccessfully();
//        Assert.assertTrue(ordersPage.verifyOrderCreatedSuccessfully());
//    }
//
//    @When("user should be orders page")
//    public void userShouldBeOrdersPage() {
//        dashboardPage.clickOnSalesLink();
//        dashboardPage.clickOrdersLink();
//    }
//
//    @And("user choose order for update and click on edit button")
//    public void userChooseOrderForUpdateAndClickOnEditButton() {
//        ordersPage.clickOnOrderViewForUpdate();
//        ordersPage.clickEditButton();
//    }
//
//    @And("Add some order information")
//    public void addSomeOrderInformation() {
//        ordersPage.enterCompanyName(prop.getProperty("companyName"));
//       ordersPage.clickEditSubmitButton();
//
//    }
//
//    @Then("verify the order successfully updated")
//    public void verifyTheOrderSuccessfullyUpdated() {
//        ordersPage.isOrderUpdatedSuccessfully();
//        Assert.assertTrue(ordersPage.isOrderUpdatedSuccessfully());
//    }
//
//    @When("sales manager already on the Order page")
//    public void salesManagerAlreadyOnTheOrderPage() {
//        dashboardPage.clickOnSalesLink();
//        dashboardPage.clickOrdersLink();
//    }
//
//    @And("choose order to cancel")
//    public void chooseOrderToCancel() {
//        ordersPage.clickOrderCheckBox();
//    }
//
//    @And("click on cancel order action and submit it")
//    public void clickOnCancelOrderActionAndSubmitIt() {
//        ordersPage.selectCancel();
//        ordersPage.clickOnCancelSubmitButton();
//    }
//
//    @Then("verify the order successfully cancelled")
//    public void verifyTheOrderSuccessfullyCancelled() {
//        ordersPage.isCancelSuccessMessageDisplayed();
//        Assert.assertTrue(ordersPage.isCancelSuccessMessageDisplayed());
//    }
//}
