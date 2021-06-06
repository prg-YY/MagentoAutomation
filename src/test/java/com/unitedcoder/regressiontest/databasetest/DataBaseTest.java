package com.unitedcoder.regressiontest.databasetest;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.catalogpages.AddRootCategoriesPage;
import com.seleniummaster.magento.backendpages.customerpages.CustomerGroupPage;
import com.seleniummaster.magento.backendpages.customerpages.CustomerPage;
import com.seleniummaster.magento.backendpages.marketingpages.CartPriceRulePage;
import com.seleniummaster.magento.backendpages.salespages.OrdersPage;
import com.seleniummaster.magento.backendpages.storepages.ManageProductsPage;
import com.seleniummaster.magento.backendpages.storepages.StoreDashboardPage;
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
    @Test(enabled = false,description = "",priority = 1)
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
        //driver.close();
        System.out.println("Driver is closed");
    }

    @Test(enabled = false,description = "Verify that newly added customers should be in the database",priority = 2)
    public void isAddedCustomerExist(){
        DataAccess access=new DataAccess();
        String queryForAddCustomer=String.format(QueryScript.getNewlyAddedCustomer(),TestDataHolder.getCustomerEmail());
        CachedRowSet cachedRowSet=access.readFromDataBase(connection, queryForAddCustomer);
        System.out.println("The Query Script was Executed for Adding Customer is"+"\n"+queryForAddCustomer);
        Assert.assertTrue(access.getRowCount(cachedRowSet));
    }

    @Test(description = "Verify that  new added customer groups should be in the database",priority = 12)//Abdukahar
    public void isAddedCustomerGroupExist(){

    }

    @Test
    public void isAddedProductExist(){
        DataAccess access=new DataAccess();

    }
    @Test(enabled = false,description = "create new Category test",priority = 5)
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

    }
    @Test(enabled = false,description = "Verify that newly added product root category should be in the database",priority = 6)//Sofia
    public void isAddedProductRootCategoryExist(){
        DataAccess access=new DataAccess();
        String getRootCategoryQueryScript=String.format(QueryScript.getNewlyAddedRootCategory(),TestDataHolder.getProductCategoryName());
        CachedRowSet cachedRowSet=access.readFromDataBase(connection,getRootCategoryQueryScript);
        System.out.println("The Query Script was Executed for Adding root Category is"+"\n"+getRootCategoryQueryScript);
        Assert.assertTrue(access.getRowCount(cachedRowSet));


    }
    @Test(enabled = false,description = "create new user test",priority = 3)
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
    @Test(enabled = false,description = "Verify that newly registered users should be in the database",priority = 4)//Zuhra
    public void isRegisteredUserExist(){
        DataAccess access=new DataAccess();
        String addNewUserQueryScript=String.format(QueryScript.getNewlyRegisteredUser(),TestDataHolder.getUserEmail());
        CachedRowSet cachedRowSet=access.readFromDataBase(connection,addNewUserQueryScript);
        System.out.println("The Query script for verify new user is : "+"\n"+addNewUserQueryScript);
        Assert.assertTrue(access.getRowCount(cachedRowSet));

    }
    @Test(enabled = false,description = "create new order")//Kambernisa
    public void createOrder(){
        driver.get(prop.getProperty("login_url"));
      backEndLogin=new BackEndLogin(driver);
      backEndLogin.backEndLogin(prop.getProperty("salesManager"),prop.getProperty("password"));
        OrdersPage ordersPage=new OrdersPage(driver);
        ordersPage.createNewOrder();
       Assert.assertTrue(ordersPage.verifyOrderCreatedSuccessfully());
    }
    @Test(enabled = false,description = "Verify that newly added orders should be in the database")//Kembarnisa
    public void isAddedOrderExist(){
        DataAccess access=new DataAccess();
        CachedRowSet cachedRowSet=access.readFromDataBase(connection,QueryScript.getNewlyOrder());
        System.out.println("The Query script for verify new Order is:" +"\n"+QueryScript.getNewlyOrder());
        Assert.assertTrue(access.getRowCount(cachedRowSet));

    }
    @Test(description = "Verify that newly added credit memos should be in the database")//Ayper
    public void isAddedCreditMemosExist(){
        DataAccess access=new DataAccess();

    }
    @Test(description = "Verify that newly added store should be in the database")//Leila
    public void isAddedStoreExist(){
        DataAccess access=new DataAccess();
//
    }

    @Test(enabled = false,description = " add new  product ",priority = 9) //melike
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

    @Test(enabled = false,description = "Verify that newly added stock should be in the database",priority = 10)//melike
    public void isAddedStockExist(){
        DataAccess access=new DataAccess();
        String getNewProductQueryScript=String.format(QueryScript.getNewAddedProduct(),TestDataHolder.getStockName());
        CachedRowSet cachedRowSet=access.readFromDataBase(connection,getNewProductQueryScript);
        System.out.println("The Query script for verify new added product is:" +"\n"+getNewProductQueryScript);
        Assert.assertTrue(access.getRowCount(cachedRowSet));
    }
    @Test(description = "Verify that newly added sub categories should be in the database")//Dilnur
    public void isAddedSubCategoryExist(){
        DataAccess access=new DataAccess();

    }
    @Test(description = "Verify that newly added store view should be in the database")//Abdusamad
    public void isAddedStoreViewExist(){
        DataAccess access=new DataAccess();

    }
    @Test(description = "add new cart price rule ")//abdukkahhar
    public  void addNewCartPriceRule(){

    }
    @Test(description = "Verify that newly added Cart Price Rule should be in the database")//Abdukahar
    public void isAddedCartPriceRuleExist(){
        DataAccess access=new DataAccess();

    }
    @Test(description = "Verify the newly added tax rule should be in the database")//Yusupjan
    public void isAddedTaxRuleExist(){
        DataAccess access=new DataAccess();

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
