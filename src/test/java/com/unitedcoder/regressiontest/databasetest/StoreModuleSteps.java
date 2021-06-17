package com.unitedcoder.regressiontest.databasetest;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.storepages.ManageProductsPage;
import com.seleniummaster.magento.backendpages.storepages.StoreDashboardPage;
import com.seleniummaster.magento.backendpages.storepages.StorePage;
import com.seleniummaster.magento.database.ConnectionManager;
import com.seleniummaster.magento.database.ConnectionType;
import com.seleniummaster.magento.database.DataAccess;
import com.seleniummaster.magento.database.QueryScript;
import com.seleniummaster.magento.testdata.TestDataHolder;
import com.seleniummaster.magento.utility.TestBasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import javax.sql.rowset.CachedRowSet;
import java.sql.Connection;

public class StoreModuleSteps extends TestBasePage {
    static String username = prop.getProperty("dbUserName");
    static String password = prop.getProperty("dbPassword");
    Connection connection;
    StoreDashboardPage storeDashboardPage;
    ManageProductsPage productsPage;
    StoreDashboardPage dashboardpage;
    StorePage storepage;

    @Given("store manager should be on the login page")
    public void storeManagerShouldBeOnTheLoginPage() {
        driver.get(prop.getProperty("BackendURL"));
        BackEndLogin backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("storeManager"), prop.getProperty("password"));
        connection = ConnectionManager.connectToDataBaseServer(username, password, ConnectionType.MYSQLServer);
    }
    @When("store manager on the dashboard page")
    public void storeManagerOnTheDashboardPage() {
        storeDashboardPage.clickAllCatalogLink();
    }
    @And("store manager add new stock")
    public void storeManagerAddNewStock() {
        String newProductName=String.format(prop.getProperty("newProductName"),System.currentTimeMillis());
        productsPage.addNewProduct(newProductName);
        TestDataHolder.setStockName(newProductName);
        Assert.assertTrue(productsPage.addNewProductSuccessfully());
    }
    @Then("Verify that newly added stock should be in the database")
    public void verifyThatNewlyAddedStockShouldBeInTheDatabase() {
        DataAccess access=new DataAccess();
        String getNewProductQueryScript=String.format(QueryScript.getNewAddedProduct(),TestDataHolder.getStockName());
        CachedRowSet cachedRowSet=access.readFromDataBase(connection,getNewProductQueryScript);
        System.out.println("The Query script for verify new added product is:" +"\n"+getNewProductQueryScript);
        Assert.assertTrue(access.getRowCount(cachedRowSet));
    }

    @Given("User already on the Manage Store Dashboard Page")
    public void userAlreadyOnTheManageStoreDashboardPage() {
        BackEndLogin backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("storeManager"), prop.getProperty("password"));
        connection = ConnectionManager.connectToDataBaseServer(username, password, ConnectionType.MYSQLServer);
        dashboardpage=new StoreDashboardPage(driver);
    }
    @When("Click on Create Store Button")
    public void clickOnCreateStoreButton() {
        storepage=new StorePage(driver);
    }
    @And("Fill Out All New Store Information on New Store Page")
    public void fillOutAllNewStoreInformationOnNewStorePage() {
        StorePage viewPage = new StorePage(driver);
        String storeName = String.format(prop.getProperty("StoreName"), System.currentTimeMillis());
        TestDataHolder.setStoreName(storeName);
        viewPage.createNewStore(storeName);
        StoreDashboardPage dashboardPage = new StoreDashboardPage(driver);
        dashboardPage.clickLogOutLink();
    }
    @Then("New Store Created Successfully and Exist in Database")
    public void newStoreCreatedSuccessfullyAndExistInDatabase() {
        dashboardpage=new StoreDashboardPage(driver);
        DataAccess access = new DataAccess();
        String getStoreQueryScript = String.format(QueryScript.getNewlyAddedStore(), TestDataHolder.getStoreName());
        CachedRowSet cachedRowSet = access.readFromDataBase(connection, getStoreQueryScript);
        System.out.println("The Query script for verify new added Store is:" + "\n" + getStoreQueryScript);
        Assert.assertTrue(access.getRowCount(cachedRowSet));
    }
}
