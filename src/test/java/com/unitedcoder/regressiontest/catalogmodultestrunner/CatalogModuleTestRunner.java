package com.unitedcoder.regressiontest.catalogmodultestrunner;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.catalogpages.ManageProductsDashboardPage;
import com.seleniummaster.magento.frontendpages.AccountInformationPage;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CatalogModuleTestRunner extends TestBasePage {
    @BeforeClass
    public void setUp() {
        setUpBrowser();
        Log.info("Add new customer started");
        driver.get(prop.getProperty("BackendURL"));
        BackEndLogin backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("customerManager"), prop.getProperty("password"));
    }
@Test(description = "Catalog Manager can add products-Leila")
    public void addCategory(){
    ManageProductsDashboardPage manageproductspage=new ManageProductsDashboardPage(driver);
    ManageProductsDashboardPage.ClickOnAddProduct();
        ProductInformationPage.ClearFirstName();
        Assert.assertTrue(informationPage.verifySuccess());

    }



    }

    @AfterClass
    public void tearDown(){

    }
}