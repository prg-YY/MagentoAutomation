package com.unitedcoder.regressiontest.databasetest;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.customerpages.CustomerDashboardPage;
import com.seleniummaster.magento.backendpages.customerpages.CustomerPage;
import com.seleniummaster.magento.database.ConnectionManager;
import com.seleniummaster.magento.database.ConnectionType;
import com.seleniummaster.magento.database.DataAccess;
import com.seleniummaster.magento.database.QueryScript;
import com.seleniummaster.magento.testdata.TestDataHolder;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import javax.sql.rowset.CachedRowSet;
import java.sql.Connection;

public class CreateCustomerStepsDeff extends TestBasePage {
    static String username = prop.getProperty("dbUserName");
    static String password = prop.getProperty("dbPassword");

    Connection connection;
    CustomerDashboardPage dashboardPage;
    CustomerPage customerPage;

    @Given("customer manager login to the customer module page")
    public void customerManagerLoginToTheCustomerModulePage() {
        BackEndLogin backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("customerManager"), prop.getProperty("password"));
        connection = ConnectionManager.connectToDataBaseServer(username, password, ConnectionType.MYSQLServer);
    }

    @When("customer manage on the customer dashboard pade")
    public void customerManageOnTheCustomerDashboardPade() {
       dashboardPage=new CustomerDashboardPage(driver);
    }

    @And("customer manager add new customer")
    public void customerManagerAddNewCustomer() {
        customerPage=new CustomerPage();
        String customer_email=String.format(prop.getProperty("cus_Email"),System.currentTimeMillis());
        customerPage=new CustomerPage();
        customerPage.addNewCustomer(customer_email);
        TestDataHolder.setCustomerEmail(customer_email);
        Log.info("Add new customer started");
    }

    @Then("new customer created successfully and exist in data base")
    public void newCustomerCreatedSuccessfullyAndExistInDataBase() {
       customerPage=new CustomerPage();
        Assert.assertTrue(customerPage.newCustomerAddedSuccessfully());
        DataAccess access=new DataAccess();
        String queryForAddCustomer=String.format(QueryScript.getNewlyAddedCustomer(),TestDataHolder.getCustomerEmail());
        CachedRowSet cachedRowSet=access.readFromDataBase(connection, queryForAddCustomer);
        System.out.println("The Query Script was Executed for Adding Customer is"+"\n"+queryForAddCustomer);
        Assert.assertTrue(access.getRowCount(cachedRowSet));
    }
}
