package com.unitedcoder.regressiontest.salesmoduletestrunner;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.salespages.CreditMemosPage;
import com.seleniummaster.magento.backendpages.salespages.OrdersPage;
import com.seleniummaster.magento.backendpages.salespages.SalesDashboardPage;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SalesModuleTestRunner extends TestBasePage {
    static SalesDashboardPage dashboardPage=new SalesDashboardPage(driver);
    @BeforeClass
    public void setUp() {
        setUpBrowser();
        Log.info("Sales Manager Model Has been Started");
        driver.get(prop.getProperty("BackendURL"));
        BackEndLogin backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("salesManager"), prop.getProperty("password"));
    }
    @Test(description = "Sales Manager should be able to create orders ")
    public void createOrder(){
       dashboardPage.clickOnSalesLink();
       dashboardPage.clickOrdersLink();
        OrdersPage ordersPage=new OrdersPage(driver);
        ordersPage.clickOnCreateOrderLink();
        ordersPage.enterEmailToEmailSearchBox("dont-delete@team1.com");
        ordersPage.clickOnSearchButton();


    }
    @Test(description = "Sales Manager should be able to Update an existing orders")
    public void updateOrder(){


    }
    @Test(description = " Sales Manager should be able to cancel orders")
    public void cancelOrder(){


    }
    @Test(description = "Sales Manager should be able to manage(view and update)" +
            "shopping cart for customers(You need to open a " +
            "customer and manage shopping cart)-ABduSeMed")
    public void manageViewUpdateSM(){

    }
    @Test(description = "Sales Manager should be able to view invoices and add comments to invoice history-Sofia")
    public void viewInvoicesCommentsHistory(){

    }
    @Test(description = "Sales Manager should be able to view refunds in the Reports-Leila")
    public void viewRefundsReports(){

    }
    @Test(description = "Sales Manager should be able to view coupons in the Reports- MeLiKe")
    public void viewCoupons(){

    }
    @Test(description = "Sales Manager should be able to update " +
            "(add shipment history and tracking information) shipments- ZuHRE")
    public void updateShipments(){

    }
    @Test(description = "Sales Manager should be able to manage (add and update) tax rules (see Tax link under Store)-AyPer")
    public void taxRuleTaxLink(){

    }
    @Test(description = "Sales Manager should be able to view and add  credit memos-DilNur")
    public void viewAndAddCreditMemos(){

    }
    @Test(description = "Sales Manager should be able to view creditmemos by filters " +
            "and change columns to display and export)-AbDuKaHar")
    public void viewCreditMemos(){
        SalesDashboardPage salesDashboardPage=new SalesDashboardPage(driver);
        salesDashboardPage.clickOnSalesLink();
        salesDashboardPage.clickCreditMemosLink();
        CreditMemosPage creditMemosPage=new CreditMemosPage(driver);
        Assert.assertTrue(creditMemosPage.viewCreditMemos());


    }


    @AfterClass
    public void tearDown(){

    }
}
