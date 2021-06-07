package com.unitedcoder.regressiontest.testng;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.storepages.*;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
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
        StoreDashboardPage storeDashboardPage=new StoreDashboardPage(driver);
        storeDashboardPage.clickAllSalesLink();
        storeDashboardPage.clickOrdersLink();
        OrderPage orderPage=new OrderPage(driver);
        orderPage.CreateNewOrder();
        orderPage.verifySuccessfulAddedMsg();


    }
    @Test(description = "Store Manager can edit orders-AbDuKaHar")
    public void editOrder(){
        StoreDashboardPage storeDashboardPage=new StoreDashboardPage(driver);
        storeDashboardPage.clickAllSalesLink();
        storeDashboardPage.clickOrdersLink();
        OrderPage orderPage=new OrderPage(driver);
        orderPage.EditOrder();
        Assert.assertTrue(orderPage.verifySuccessfulAddedMsg());

    }
    @Test(description = "Store Manager can delete orders-Yusuf")
    public void deleteOrder(){// cancelOrder
        StoreDashboardPage storeDashboardPage=new StoreDashboardPage(driver);
        storeDashboardPage.clickAllSalesLink();
        storeDashboardPage.clickOrdersLink();
        OrderPage orderPage=new OrderPage(driver);
        orderPage.CancelOrder();
        Assert.assertTrue(orderPage.VerifySuccessfulCancelMsg());

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
        StoreDashboardPage storeDashboardPage=new StoreDashboardPage(driver);
        storeDashboardPage.clickAllCatalogLink();
        storeDashboardPage.clickManageCategoriesLink();
        ProductCategoriesPage productCategoriesPage=new ProductCategoriesPage(driver);
        productCategoriesPage.addProductCategory();
        Assert.assertTrue(productCategoriesPage.VerifySuccessfullyAddCategoryMsg());

    }
    @Test(description = "Store Manager can update product categories-AyPer")
    public void updateProductCategories(){
        StoreDashboardPage storeDashboardPage=new StoreDashboardPage(driver);
        storeDashboardPage.clickAllCatalogLink();
        storeDashboardPage.clickManageCategoriesLink();
        ProductCategoriesPage productCategoriesPage=new ProductCategoriesPage(driver);
        productCategoriesPage.UpdateProductCategory();
        Assert.assertTrue(productCategoriesPage.VerifySuccessfullyAddCategoryMsg());

    }
    @Test(description = "Store Manager can create a website-AbDuKaHar")
    public void createWebSite(){
        WebsitePage websitePage=new WebsitePage(driver);
        websitePage.createWebsite();
        Assert.assertTrue(websitePage.verifySuccess());

    }
    @Test(description = "Store Manager can edit a website-Sofia")
    public void editWebSite(){
        WebsitePage websitePage=new WebsitePage(driver);
        websitePage.editWebsite();
        Assert.assertTrue(websitePage.verifySuccess());

    }
    @Test(description = "Store Manager can create a store-Yusuf")
    public void createStore(){
        StoreDashboardPage storeDashboardPage=new StoreDashboardPage(driver);
        storeDashboardPage.clickCreateStoreLink();
        StorePage storePage=new StorePage(driver);
        storePage.createStore();
        Assert.assertTrue(storePage.verifySuccess());
    }
    @Test(description = "Store Manager can edit a store-ZuhRe")
    public void editStore(){
        StorePage storePage=new StorePage(driver);
        storePage.editStore();
        Assert.assertTrue(storePage.verifySuccess());

    }
    @Test(description = "Store Manager can create a store view-KaMer")
    public void createStoreView(){
        StoreDashboardPage storeDashboardPage=new StoreDashboardPage(driver);
        storeDashboardPage.clickCreateStoreViewLink();
        StoreViewPage storeViewPage=new StoreViewPage(driver);
        storeViewPage.createStoreView();
        Assert.assertTrue(storeViewPage.storeViewCreatedSuccessfully());


    }
    @Test(description = "Store Manager can edit a store view-AyPer")
    public void editStoreView(){
        StoreViewPage storeViewPage=new StoreViewPage(driver);
        storeViewPage.editStoreView();
        Assert.assertTrue(storeViewPage.storeViewCreatedSuccessfully());

    }
    @Test(description = "Store Manager can view all stores-Leila")
    public void viewAllStores(){
        StoreDashboardPage storeDashboardPage=new StoreDashboardPage(driver);
        storeDashboardPage.clickAllSalesLink();
        storeDashboardPage.clickOrdersLink();
        StoreViewPage storeViewPage=new StoreViewPage(driver);
        Assert.assertTrue(storeViewPage.viewOrder());


    }
    @Test(description = "Store Manager can configure a store-MeLiKe")
    public void configureStore(){

    }

    @AfterClass
    public void tearDown(){

    }
}
