package com.unitedcoder.regressiontest.databasetest;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.catalogpages.AddNewProductPage;
import com.seleniummaster.magento.database.ConnectionManager;
import com.seleniummaster.magento.database.ConnectionType;
import com.seleniummaster.magento.database.DataAccess;
import com.seleniummaster.magento.database.QueryScript;
import com.seleniummaster.magento.testdata.TestDataHolder;
import com.seleniummaster.magento.utility.TestBasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import javax.sql.rowset.CachedRowSet;
import java.sql.Connection;

public class yusufSteps extends TestBasePage {
    static String username = prop.getProperty("dbUserName");
    static String password = prop.getProperty("dbPassword");
    BackEndLogin backEndLogin;
    Connection connection;

    @Given("user login to catalog module")
    public void userLoginToCatalogModule() {
        backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("catalogManager"), prop.getProperty("password"));
        connection = ConnectionManager.connectToDataBaseServer(username, password, ConnectionType.MYSQLServer);
    }

    @And("preparation for new product creation")
    public void preparationForNewProductCreation() {
        AddNewProductPage productsPage = new AddNewProductPage(driver);
        String newProductName = String.format(prop.getProperty("productName"), System.currentTimeMillis());
        productsPage.createNewProduct(newProductName);
        TestDataHolder.setNewProductName(newProductName);
        Assert.assertTrue(productsPage.AddProductSuccessfully());
    }

    @Then("verify New product created and should be in the database")
    public void verifyNewProductCreatedAndShouldBeInTheDatabase() {
        DataAccess access = new DataAccess();
        String getProductQueryScript = String.format(QueryScript.getNewlyAddedProduct(), TestDataHolder.getNewProductName());
        CachedRowSet cachedRowSet = access.readFromDataBase(connection, getProductQueryScript);
        System.out.println("The Query Script was Executed for Adding Product is" + "\n" + getProductQueryScript);
        Assert.assertTrue(access.getRowCount(cachedRowSet));
        ConnectionManager.closeDataBaseConnection(connection);
    }
}
