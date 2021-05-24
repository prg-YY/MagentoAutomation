//package com.unitedcoder.regressiontest.cucumber.sales;
//
//import com.seleniummaster.magento.backendpages.salespages.SalesDashboardPage;
//import com.seleniummaster.magento.backendpages.salespages.ShipmentPage;
//import com.seleniummaster.magento.utility.TestBasePage;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.Assert;
//
//public class ShipmentStepDiff extends TestBasePage {
//    SalesDashboardPage dashboardPage=new SalesDashboardPage(driver);
//    ShipmentPage shipmentPage=new ShipmentPage(driver);
//
//    @Given("sales manager on the shipment dashboard")
//    public void salesManagerOnTheShipmentDashboard() {
//        dashboardPage.clickOnSalesLink();
//        dashboardPage.clickShipmentsLink();
//    }
//
//    @When("sales manager on the define order and click it")
//    public void salesManagerOnTheDefineOrderAndClickIt() {
//     shipmentPage.searchShipment();
//    }
//
//    @And("add shipping and tracking information")
//    public void addShippingAndTrackingInformation() {
//     shipmentPage.addShipment();
//     shipmentPage.addComment();
//    }
//
//    @Then("shipping and tracking information added successfully")
//    public void shippingAndTrackingInformationAddedSuccessfully() {
//        shipmentPage.verifySuccessMessage();
//        Assert.assertTrue(shipmentPage.verifySuccessMessage());
//    }
//}
