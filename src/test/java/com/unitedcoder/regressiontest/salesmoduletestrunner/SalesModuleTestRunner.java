package com.unitedcoder.regressiontest.salesmoduletestrunner;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SalesModuleTestRunner extends TestBasePage {

    @BeforeClass
    public void setUp() {
        setUpBrowser();
        Log.info("Add new customer started");
        driver.get(prop.getProperty("BackendURL"));
        BackEndLogin backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("salesmanager"), prop.getProperty("password"));
    }
    @Test(description = "Sales Manager should be able to manage(create, update and cancel)orders - Yusuf")
    public void manageCreateUpdateCancelOrder(){

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

    }


    @AfterClass
    public void tearDown(){

    }
}
