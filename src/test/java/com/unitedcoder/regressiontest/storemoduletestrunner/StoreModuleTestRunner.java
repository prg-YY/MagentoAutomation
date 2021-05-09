package com.unitedcoder.regressiontest.storemoduletestrunner;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.storepages.ManageProductsPage;
import com.seleniummaster.magento.backendpages.storepages.StoreDashboardPage;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import org.apache.poi.ss.formula.functions.T;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StoreModuleTestRunner extends TestBasePage {

    @BeforeClass
    public void setUp() {
        setUpBrowser();
        Log.info("Add new customer started");
        driver.get(prop.getProperty("BackendURL"));
        BackEndLogin backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("storeManager"), prop.getProperty("password"));
    }
    @Test(description = "Store Manager can create a new order-AbDuSaMed")
    public void createNewOrder(){

    }
    @Test(description = "Store Manager can edit orders-AbDuKaHar")
    public void editOrder(){

    }
    @Test(description = "Store Manager can delete orders-Yusuf")
    public void deleteOrder(){

    }
    @Test(description = "Store Manager can add products-Sofia")
    public void addProduct(){
        ManageProductsPage manageProductsPage=new ManageProductsPage(driver);
        StoreDashboardPage storeDashboardPage=new StoreDashboardPage(driver);
        storeDashboardPage.clickAllCatalogLink();
        storeDashboardPage.clickManageProductsLink();
        manageProductsPage.AddProduct();
        Assert.assertTrue(manageProductsPage.VerifySuccessfulMessage());

    }
    @Test(description = "Store Manager can update products-ZuHra")
    public void updateProduct(){
        ManageProductsPage manageProductsPage=new ManageProductsPage(driver);
        StoreDashboardPage storeDashboardPage=new StoreDashboardPage(driver);
        storeDashboardPage.clickAllCatalogLink();
        storeDashboardPage.clickManageProductsLink();
        manageProductsPage.updateProduct();
        Assert.assertTrue(manageProductsPage.VerifySuccessfulUpdated());

    }
    @Test(description = "Store Manager can add product categories-KaMer")
    public void addProductCategories(){

    }
    @Test(description = "Store Manager can update product categories-AyPer")
    public void updateProductCategories(){

    }
    @Test(description = "Store Manager can create a website-AbDuKaHar")
    public void createWebSite(){

    }
    @Test(description = "Store Manager can edit a website-Sofia")
    public void editWebSite(){

    }
    @Test(description = "Store Manager can create a store-Yusuf")
    public void createStore(){

    }
    @Test(description = "Store Manager can edit a store-ZuhRe")
    public void editStore(){

    }
    @Test(description = "Store Manager can create a store view-KaMer")
    public void createStoreView(){

    }
    @Test(description = "Store Manager can edit a store view-AyPer")
    public void editStoreView(){

    }
    @Test(description = "Store Manager can view all stores-Leila")
    public void viewAllStores(){

    }
    @Test(description = "Store Manager can configure a store-MeLiKe")
    public void configureStore(){

    }

    @AfterClass
    public void tearDown(){

    }
}
