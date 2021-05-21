package com.unitedcoder.regressiontest.cucumber.sales;

import com.seleniummaster.magento.backendpages.salespages.OrdersPage;
import com.seleniummaster.magento.backendpages.salespages.SalesDashboardPage;
import com.seleniummaster.magento.utility.TestBasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CreateOrder extends TestBasePage {
    SalesDashboardPage dashboardPage=new SalesDashboardPage(driver);
    OrdersPage ordersPage=new OrdersPage(driver);
    @When("sales manager on the create order orders page")
    public void salesManagerOnTheCreateOrderOrdersPage() {
        dashboardPage.clickOnSalesLink();
        dashboardPage.clickOrdersLink();
        ordersPage.clickOnCreateOrderLink();
    }

    @And("choose customer for order")
    public void chooseCustomerForOrder() {

        ordersPage.searchCustomerForOrder(prop.getProperty("FrondEmail1"));
    }

    @And("add products to order")
    public void addProductsToOrder() {
        ordersPage.addProductForOrder();
    }

    @And("choose payment method and shipment and click submit order button")
    public void choosePaymentMethodAndShipmentAndClickSubmitOrderButton() {

        ordersPage.clickShipmentAndSubmitButton();
    }

    @Then("verify the order successfully created")
    public void verifyTheOrderSuccessfullyCreated() {
        ordersPage.verifyOrderCreatedSuccessfully();
        Assert.assertTrue(ordersPage.verifyOrderCreatedSuccessfully());
    }
}
