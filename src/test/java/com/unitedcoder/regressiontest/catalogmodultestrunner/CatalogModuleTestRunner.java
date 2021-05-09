package com.unitedcoder.regressiontest.catalogmodultestrunner;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.catalogpages.CatalogDashboardPage;
import com.seleniummaster.magento.backendpages.catalogpages.DeleteProductPage;
import com.seleniummaster.magento.backendpages.catalogpages.DeleteRootCategoriesPage;
import com.seleniummaster.magento.backendpages.catalogpages.EditCategoriesPage;
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
        backEndLogin.backEndLogin(prop.getProperty("catalogManager"), prop.getProperty("password"));
    }
@Test
    public void addCategory(){

    }
    @Test(description = "edit root categories-yusuf")
    public void editCategoriesTest(){
        EditCategoriesPage categoriesPage=new EditCategoriesPage();
        categoriesPage.editCategoriesPage1();
        Assert.assertTrue(categoriesPage.displaySuccessMessage());
    }

    @Test
    public void deleteRootCategoriesTest(){
        DeleteRootCategoriesPage deleteRootCategoriesPage=new DeleteRootCategoriesPage(driver);
        CatalogDashboardPage catalogDashboardPage=new CatalogDashboardPage(driver);
        catalogDashboardPage.clickCatalogLink();
        catalogDashboardPage.clickManageCategories();
        deleteRootCategoriesPage.deleteRootCategory();
        Assert.assertTrue(deleteRootCategoriesPage.VerifySuccessfulMsgDisplay());
    }


    @AfterClass
    public void tearDown(){

    }
}