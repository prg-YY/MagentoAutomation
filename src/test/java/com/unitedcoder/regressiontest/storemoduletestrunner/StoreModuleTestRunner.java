package com.unitedcoder.regressiontest.storemoduletestrunner;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.storepages.AddNewProductPage;
import com.seleniummaster.magento.backendpages.storepages.StoreDashboardPage;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StoreModuleTestRunner extends TestBasePage {
    AddNewProductPage addNewProductPage;
    StoreDashboardPage storeDashboardPage;
    @BeforeClass
    public void setUp() {
        setUpBrowser();
        Log.info("Add new customer started");
        driver.get(prop.getProperty("BackendURL"));
        BackEndLogin backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("storeManager"), prop.getProperty("password"));
    }
    @Test
    public void addCategory(){



    }

    @Test
    public void addProduct(){
        storeDashboardPage=new StoreDashboardPage(driver);
        storeDashboardPage.clickAllCatalogLink();
        storeDashboardPage.clickManageProductsLink();
        addNewProductPage=new AddNewProductPage(driver);
        addNewProductPage.AddProduct();
        Assert.assertTrue(addNewProductPage.VerifySuccessfulMessage());
    }


    @AfterClass
    public void tearDown(){

    }
}
