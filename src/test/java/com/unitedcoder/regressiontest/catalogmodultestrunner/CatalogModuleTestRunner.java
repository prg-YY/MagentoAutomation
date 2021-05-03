package com.unitedcoder.regressiontest.catalogmodultestrunner;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.catalogpages.DeleteRootCategoriesPage;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CatalogModuleTestRunner extends TestBasePage {
    DeleteRootCategoriesPage deleteRootCategoriesPage;
    @BeforeClass
    public void setUp() {
        setUpBrowser();
        Log.info("Add new customer started");
        driver.get(prop.getProperty("BackendURL"));
        BackEndLogin backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("customerManager"), prop.getProperty("password"));
    }
@Test
    public void addCategory(){



    }
    @Test
    public void deleteRootCategoriesTest(){
        deleteRootCategoriesPage=new DeleteRootCategoriesPage(driver);
        Assert.assertTrue(deleteRootCategoriesPage.deleteRootCategory());
    }


    @AfterClass
    public void tearDown(){

    }
}