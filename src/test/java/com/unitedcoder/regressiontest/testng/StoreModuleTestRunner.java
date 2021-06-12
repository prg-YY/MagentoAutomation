package com.unitedcoder.regressiontest.testng;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.salespages.SalesDashboardPage;
import com.seleniummaster.magento.backendpages.salespages.SalesOrderPage;
import com.seleniummaster.magento.backendpages.storepages.*;
import com.seleniummaster.magento.testdata.TestDataHolder;
import com.seleniummaster.magento.utility.TestBasePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class StoreModuleTestRunner extends TestBasePage {
    StoreDashboardPage dashboardPage;
    ManageProductsPage productsPage;
    SalesOrderPage orderPage;


    @BeforeClass
    public void setUp() {
        setUpBrowser();
        driver.get(prop.getProperty("BackendURL"));
        BackEndLogin backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("storeManager"), prop.getProperty("password"));
    }
//    @Test(description = "Store Manager can create a new order",priority = 1)//Abdusamad
//    public void createNewOrder(){
//        orderPage=new SalesOrderPage();
//        dashboardPage=new StoreDashboardPage(driver);
//        orderPage.createNewOrder(prop.getProperty("CustomerName"));
//        TestDataHolder.setOrderId(orderPage.orderIdGetter());
//        Assert.assertTrue(orderPage.creteOrderSuccessfully());
//    }
//    @Test(description = "Store Manager can edit orders",priority = 2)//Abdukahar
//    public void editOrder(){
//        orderPage=new SalesOrderPage();
//        orderPage.updateOrder(TestDataHolder.getOrderId());
//        Assert.assertTrue(orderPage.updateOrderSuccessfully());
//    }
//    @Test(description = "Store Manager can delete orders",priority = 3)//yusuf
//    public void deleteOrder(){// cancelOrder
//        orderPage=new SalesOrderPage();
//        orderPage.cancelOrder(TestDataHolder.getOrderId());
//        Assert.assertTrue(orderPage.cancelOrderSuccessfully());
//    }
//    @Test(description = "Store Manager can add products-Sofia",priority = 4)//sofia
//    public void addProduct(){
//        productsPage=new ManageProductsPage();
//        Random ran=new Random();
//        int r=ran.nextInt(100);
//        String productName=String.format(prop.getProperty("NewProductName"),r);
//        TestDataHolder.setNewProductName(productName);
//        productsPage.addNewProduct(productName);
//        Assert.assertTrue(productsPage.addNewProductSuccessfully());
//    }
//    @Test(description = "Store Manager can update products",priority = 5)//Zuhra
//    public void updateProduct(){
//        productsPage=new ManageProductsPage();
//       productsPage.updateExistingProduct(TestDataHolder.getNewProductName());
//        Assert.assertTrue(productsPage.updateProductSuccessfully());
//    }
//    @Test(description = "Store manager can Delete  Product",priority = 6)
//    public void deleteProduct(){
//        productsPage=new ManageProductsPage();
//        productsPage.deleteExistingProduct(TestDataHolder.getNewProductName());
//        Assert.assertTrue(productsPage.deleteProductSuccessfully());
//    }
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

//    @Test(description = "Store Manager can create a website-AbDuKaHar")
//    public void createWebSite(){
//        WebsitePage websitePage=new WebsitePage(driver);
//        websitePage.createWebsite();
//        Assert.assertTrue(websitePage.verifySuccess());
//
//    }
//    @Test(description = "Store Manager can edit a website-Sofia")
//    public void editWebSite(){
//        WebsitePage websitePage=new WebsitePage(driver);
//        websitePage.editWebsite();
//        Assert.assertTrue(websitePage.verifySuccess());
//
//    }
//    @Test(description = "Store Manager can create a store-Yusuf")
//    public void createStore(){
//        StoreDashboardPage storeDashboardPage=new StoreDashboardPage(driver);
//        storeDashboardPage.clickCreateStoreLink();
//        StorePage storePage=new StorePage(driver);
//        storePage.createStore();
//        Assert.assertTrue(storePage.verifySuccess());
//    }
//    @Test(description = "Store Manager can edit a store-ZuhRe")
//    public void editStore(){
//        StorePage storePage=new StorePage(driver);
//        storePage.editStore();
//        Assert.assertTrue(storePage.verifySuccess());
//
//    }
//    @Test(description = "Store Manager can create a store view-KaMer")
//    public void createStoreView(){
//        StoreDashboardPage storeDashboardPage=new StoreDashboardPage(driver);
//        storeDashboardPage.clickCreateStoreViewLink();
//        StoreViewPage storeViewPage=new StoreViewPage(driver);
//        storeViewPage.createStoreView();
//        Assert.assertTrue(storeViewPage.storeViewCreatedSuccessfully());
//
//
//    }
//    @Test(description = "Store Manager can edit a store view-AyPer")
//    public void editStoreView(){
//        StoreViewPage storeViewPage=new StoreViewPage(driver);
//        storeViewPage.editStoreView();
//        Assert.assertTrue(storeViewPage.storeViewCreatedSuccessfully());
//
//    }
//    @Test(description = "Store Manager can view all stores-Leila")
//    public void viewAllStores(){
//        StoreDashboardPage storeDashboardPage=new StoreDashboardPage(driver);
//        storeDashboardPage.clickAllSalesLink();
//        storeDashboardPage.clickOrdersLink();
//        StoreViewPage storeViewPage=new StoreViewPage(driver);
//        Assert.assertTrue(storeViewPage.viewOrder());
//
//
//    }
//    @Test(description = "Store Manager can configure a store-MeLiKe")
//    public void configureStore(){
//
//    }
//
    @AfterClass
    public void tearDown(){

    }
}
