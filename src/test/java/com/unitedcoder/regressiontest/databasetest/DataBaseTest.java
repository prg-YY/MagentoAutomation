package com.unitedcoder.regressiontest.databasetest;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.catalogpages.AddNewProductPage;
import com.seleniummaster.magento.backendpages.catalogpages.AddRootCategoriesPage;
import com.seleniummaster.magento.backendpages.catalogpages.CatalogDashboardPage;
import com.seleniummaster.magento.backendpages.customerpages.CustomerDashboardPage;
import com.seleniummaster.magento.backendpages.customerpages.CustomerPage;
import com.seleniummaster.magento.backendpages.salespages.OrdersPage;
import com.seleniummaster.magento.backendpages.salespages.SalesDashboardPage;
import com.seleniummaster.magento.backendpages.salespages.TaxRulesPage;
import com.seleniummaster.magento.backendpages.storepages.ManageProductsPage;
import com.seleniummaster.magento.backendpages.storepages.StoreDashboardPage;
import com.seleniummaster.magento.backendpages.storepages.StoreViewPage;
import com.seleniummaster.magento.database.ConnectionManager;
import com.seleniummaster.magento.database.ConnectionType;
import com.seleniummaster.magento.database.DataAccess;
import com.seleniummaster.magento.database.QueryScript;
import com.seleniummaster.magento.frontendpages.CreateAccountPage;
import com.seleniummaster.magento.testdata.TestDataHolder;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.sql.rowset.CachedRowSet;
import java.sql.Connection;

public class DataBaseTest extends TestBasePage {
    static String username=prop.getProperty("dbUserName");
    static String password=prop.getProperty("dbPassword");
    Connection  connection;
    BackEndLogin backEndLogin ;
    CustomerPage customerPage;
    @BeforeClass
    public void setUp(){
        connection= ConnectionManager.connectToDataBaseServer(username,password,ConnectionType.MYSQLServer);
        setUpBrowser();

    }
    @Test(description = "",priority = 1) //Adusamad
    public void addCustomer(){
        driver.get(prop.getProperty("BackendURL"));
        backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("customerManager"), prop.getProperty("password"));
        String customer_email=String.format(prop.getProperty("cus_Email"),System.currentTimeMillis());
        customerPage=new CustomerPage();
        customerPage.addNewCustomer(customer_email);
        TestDataHolder.setCustomerEmail(customer_email);
        Log.info("Add new customer started");
        Assert.assertTrue(customerPage.newCustomerAddedSuccessfully());
        CustomerDashboardPage dashboardPage=new CustomerDashboardPage(driver);
        dashboardPage.cLickLogoutButton();
    }
    @Test(description = "Verify that newly added customers should be in the database",priority = 2) //Abdusamad
    public void isAddedCustomerExist(){
        DataAccess access=new DataAccess();
        String queryForAddCustomer=String.format(QueryScript.getNewlyAddedCustomer(),TestDataHolder.getCustomerEmail());
        CachedRowSet cachedRowSet=access.readFromDataBase(connection, queryForAddCustomer);
        System.out.println("The Query Script was Executed for Adding Customer is"+"\n"+queryForAddCustomer);
        Assert.assertTrue(access.getRowCount(cachedRowSet));
    }
    @Test(description = "Verify that  new added customer groups should be in the database",priority = 3)//Abdukahar
    public void isAddedCustomerGroupExist(){
        DataAccess access=new DataAccess();

    }
    @Test(description = "add product test",priority = 4)
    public void addProduct(){
        AddNewProductPage productsPage=new AddNewProductPage(driver);
        driver.get(prop.getProperty("BackendURL"));
        backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("catalogManager"), prop.getProperty("password"));
        String newProductName=String.format(prop.getProperty("productName"),System.currentTimeMillis());
        productsPage.createNewProduct(newProductName);
        TestDataHolder.setNewProductName(newProductName);
        Assert.assertTrue(productsPage.verifySuccess());
        StoreDashboardPage dashboardPage=new StoreDashboardPage(driver);
        dashboardPage.clickLogOutLink();
    }
    @Test(description = "Verify that newly added product category should be in the database _Yusuf",priority = 5)
    public void isAddedProductExist(){
        DataAccess access=new DataAccess();
        String getProductQueryScript=String.format(QueryScript.getNewlyAddedProduct(),TestDataHolder.getNewProductName());
        CachedRowSet cachedRowSet=access.readFromDataBase(connection,getProductQueryScript);
        System.out.println("The Query Script was Executed for Adding Product is"+"\n"+getProductQueryScript);
        Assert.assertTrue(access.getRowCount(cachedRowSet));

    }
    @Test(description = "create new Category test",priority = 6)//Sofia
    public void addRootCategory(){
        AddRootCategoriesPage rootCategoriesPage;
        driver.get(prop.getProperty("BackendURL"));
        BackEndLogin backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("catalogManager"), prop.getProperty("password"));
        String catName=String.format(prop.getProperty("NewRootCategories"),System.currentTimeMillis());
        TestDataHolder.setProductCategoryName(catName);
        rootCategoriesPage = new AddRootCategoriesPage(driver);
        rootCategoriesPage.addNewRootCategory(catName);
        Assert.assertTrue(rootCategoriesPage.isAddRootCategorySuccessMassage());
        CatalogDashboardPage dashboardPage=new CatalogDashboardPage(driver);
        dashboardPage.clickLogOutLink();
    }
    @Test(description = "Verify that newly added product root category should be in the database",priority = 7)//Sofia
    public void isAddedProductRootCategoryExist(){
        DataAccess access=new DataAccess();
        String getRootCategoryQueryScript=String.format(QueryScript.getNewlyAddedRootCategory(),TestDataHolder.getProductCategoryName());
        CachedRowSet cachedRowSet=access.readFromDataBase(connection,getRootCategoryQueryScript);
        System.out.println("The Query Script was Executed for Adding root Category is"+"\n"+getRootCategoryQueryScript);
        Assert.assertTrue(access.getRowCount(cachedRowSet));
    }
    @Test(description = "create new user test",priority = 8)//Zuhra
    public void createNewUser(){
        driver.get(prop.getProperty("create_url"));
        String firstName= prop.getProperty("ca-firstName");
        String lastName= prop.getProperty("ca-lastName");
        String email=String.format(prop.getProperty("ca-email"),System.currentTimeMillis());
        TestDataHolder.setUserEmail(email);
        String password= prop.getProperty("ca-password");
        CreateAccountPage accountPage=new CreateAccountPage(driver);
        accountPage.userCreateAccount(firstName,lastName,email,password);
        Assert.assertTrue(accountPage.verifySuccess());
    }
    @Test(description = "Verify that newly registered users should be in the database",priority = 9)//Zuhra
    public void isRegisteredUserExist(){
        DataAccess access=new DataAccess();
        String addNewUserQueryScript=String.format(QueryScript.getNewlyRegisteredUser(),TestDataHolder.getUserEmail());
        CachedRowSet cachedRowSet=access.readFromDataBase(connection,addNewUserQueryScript);
        System.out.println("The Query script for verify new user is : "+"\n"+addNewUserQueryScript);
        Assert.assertTrue(access.getRowCount(cachedRowSet));

    }
    @Test(description = "create new order",priority = 10)//Kambernisa
    public void createOrder(){
        driver.get(prop.getProperty("BackendURL"));
      backEndLogin=new BackEndLogin(driver);
      backEndLogin.backEndLogin(prop.getProperty("salesManager"),prop.getProperty("password"));
        OrdersPage ordersPage=new OrdersPage(driver);
        ordersPage.createNewOrder(prop.getProperty("FrondEmail"));
        TestDataHolder.setOrderId(ordersPage.orderIdGetter());
       Assert.assertTrue(ordersPage.verifyOrderCreatedSuccessfully());
        SalesDashboardPage dashboardPage=new SalesDashboardPage(driver);
        dashboardPage.clickLogOutLink();
    }
    @Test(description = "Verify that newly added orders should be in the database",priority = 11)//Kembarnisa
    public void isAddedOrderExist(){
        DataAccess access=new DataAccess();
        String getOrderQueryScript=String.format(QueryScript.getNewlyOrder(),TestDataHolder.getOrderId());
        CachedRowSet cachedRowSet=access.readFromDataBase(connection,getOrderQueryScript);
        System.out.println("The Query script for verify new Order is:" +"\n"+getOrderQueryScript);
        Assert.assertTrue(access.getRowCount(cachedRowSet));

    }
    @Test(description = "Verify that newly added credit memos should be in the database",priority = 12)//Ayper
    public void isAddedCreditMemosExist(){
        DataAccess access=new DataAccess();

    }
    @Test(enabled = false,description = "Verify that newly added store should be in the database",priority = 13)//Leila
    public void isAddedStoreExist(){
        DataAccess access=new DataAccess();
//
    }
    @Test(description = " add new  product ",priority = 14) //melike
    public void addNewProduct(){
        ManageProductsPage productsPage=new ManageProductsPage(driver);
        driver.get(prop.getProperty("BackendURL"));
        backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("storeManager"), prop.getProperty("password"));
        String newProductName=String.format(prop.getProperty("newProductName"),System.currentTimeMillis());
        productsPage.addNewProduct(newProductName);
        TestDataHolder.setStockName(newProductName);
        Assert.assertTrue(productsPage.VerifySuccessfulMessage());
        StoreDashboardPage dashboardPage=new StoreDashboardPage(driver);
        dashboardPage.clickLogOutLink();
    }
    @Test(description = "Verify that newly added stock should be in the database",priority = 15)//melike
    public void isAddedStockExist(){
        DataAccess access=new DataAccess();
        String getNewProductQueryScript=String.format(QueryScript.getNewAddedProduct(),TestDataHolder.getStockName());
        CachedRowSet cachedRowSet=access.readFromDataBase(connection,getNewProductQueryScript);
        System.out.println("The Query script for verify new added product is:" +"\n"+getNewProductQueryScript);
        Assert.assertTrue(access.getRowCount(cachedRowSet));
    }
    @Test(description = "Verify that newly added sub categories should be in the database",priority = 16)//Dilnur
    public void isAddedSubCategoryExist(){
        DataAccess access=new DataAccess();

    }
    @Test(description = "Create Store view Test",priority = 17) //Abdusamad
    public void createStoreView(){
        driver.get(prop.getProperty("BackendURL"));
        backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("storeManager"), prop.getProperty("password"));
        StoreViewPage viewPage=new StoreViewPage(driver);
        String code=String.format(prop.getProperty("storeCode"),System.currentTimeMillis());
        TestDataHolder.setStoreViewCode(code);
        viewPage.createNewStoreView(prop.getProperty("StoreName"),code);
        StoreDashboardPage dashboardPage=new StoreDashboardPage(driver);
        dashboardPage.clickLogOutLink();
    }
    @Test(description = "Verify that newly added store view should be in the database",priority = 18)//Abdusamad
    public void isAddedStoreViewExist(){
        DataAccess access=new DataAccess();
        String getStoreViewQueryScript=String.format(QueryScript.getNewlyAddedStoreView(),TestDataHolder.getStoreViewCode());
        CachedRowSet cachedRowSet=access.readFromDataBase(connection,getStoreViewQueryScript);
        System.out.println("The Query script for verify new added Store view is:" +"\n"+getStoreViewQueryScript);
        Assert.assertTrue(access.getRowCount(cachedRowSet));

    }
    @Test(description = "Verify that newly added Cart Price Rule should be in the database",priority = 19)//Abdukahar
    public void isAddedCartPriceRuleExist(){
        DataAccess access=new DataAccess();

    }
    @Test(description = "add Tax Rule",priority = 20)
    public void addTaxRule(){
        TaxRulesPage taxRulesPage=new TaxRulesPage(driver);
        driver.get(prop.getProperty("BackendURL"));
        backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("salesManager"), prop.getProperty("password"));
        String ruleName=String.format(prop.getProperty("newTaxRuleName"),System.currentTimeMillis());
        taxRulesPage.createTaxRule(ruleName,prop.getProperty("vipValue"), prop.getProperty("taxableGoods"),
                prop.getProperty("taxRateValue") );
        TestDataHolder.setTaxRuleName(ruleName);
        Assert.assertTrue(taxRulesPage.successMessageIsDisplay());
        StoreDashboardPage dashboardPage=new StoreDashboardPage(driver);
        dashboardPage.clickLogOutLink();

    }
    @Test(description = "Verify the newly added tax rule should be in the database",priority = 21)//Yusupjan
    public void isAddedTaxRuleExist(){
        DataAccess access=new DataAccess();
        String getNewTaxRuleQueryScript=String.format(QueryScript.getNewlyAddedTaxRule(),TestDataHolder.getTaxRuleName());
        CachedRowSet cachedRowSet=access.readFromDataBase(connection,getNewTaxRuleQueryScript);
        System.out.println("The Query script for verify new added Tax Rule  is:" +"\n"+getNewTaxRuleQueryScript);
        Assert.assertTrue(access.getRowCount(cachedRowSet));
    }
    @Test(description = "Verify that newly added refund should be in the database")//Sofia
    public void isAddedRefundExist(){
        DataAccess access=new DataAccess();

    }
    @AfterClass
    public void tearDown(){
        closeBrowser();
        ConnectionManager.closeDataBaseConnection(connection);
    }
}
