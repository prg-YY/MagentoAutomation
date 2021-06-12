package com.unitedcoder.regressiontest.databasetest;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.catalogpages.ProductsPage;
import com.seleniummaster.magento.backendpages.salespages.TaxRulesPage;
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
        ProductsPage productsPage = new ProductsPage();
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

    @Given("user login to sales module")
    public void userLoginToSalesModule() {
        backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("salesManager"), prop.getProperty("password"));
        connection = ConnectionManager.connectToDataBaseServer(username, password, ConnectionType.MYSQLServer);
    }

    @And("preparation for new tax rule creation")
    public void preparationForNewTaxRuleCreation() {
        TaxRulesPage taxRulesPage=new TaxRulesPage(driver);
        String ruleName=String.format(prop.getProperty("newTaxRuleName"),System.currentTimeMillis());
        taxRulesPage.createTaxRule(ruleName,prop.getProperty("vipValue"), prop.getProperty("taxableGoods"),
                prop.getProperty("taxRateValue") );
        TestDataHolder.setTaxRuleName(ruleName);
        Assert.assertTrue(taxRulesPage.successMessageIsDisplay());
    }

    @Then("verify New tax rule  created and should be in the database")
    public void verifyNewTaxRuleCreatedAndShouldBeInTheDatabase() {
        DataAccess access=new DataAccess();
        String getNewTaxRuleQueryScript=String.format(QueryScript.getNewlyAddedTaxRule(),TestDataHolder.getTaxRuleName());
        CachedRowSet cachedRowSet=access.readFromDataBase(connection,getNewTaxRuleQueryScript);
        System.out.println("The Query script for verify new added Tax Rule  is:" +"\n"+getNewTaxRuleQueryScript);
        Assert.assertTrue(access.getRowCount(cachedRowSet));
    }
}
