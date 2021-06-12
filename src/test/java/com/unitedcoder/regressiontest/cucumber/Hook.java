package com.unitedcoder.regressiontest.cucumber;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.storepages.StoreDashboardPage;
import com.seleniummaster.magento.database.ConnectionManager;
import com.seleniummaster.magento.database.ConnectionType;
import com.seleniummaster.magento.utility.TestBasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.sql.Connection;

public class Hook extends TestBasePage {
//    static String username=prop.getProperty("dbUserName");
//    static String password=prop.getProperty("dbPassword");
    Connection connection;

    @Before
    public void setUp() {
        initialization(prop.getProperty("BackendURL"));
//        connection= ConnectionManager.connectToDataBaseServer(username,password, ConnectionType.MYSQLServer);
    }

    @After(order = 1)
    public void logOut() {
      StoreDashboardPage storeDashboardPage = new StoreDashboardPage(driver);
      storeDashboardPage.clickLogOutLink();
    }

    @After(order = 0,value = "@DeleteExistingTaxRule")
    public void tearDown() {
        driver.close();
        driver = null;

//        ConnectionManager.closeDataBaseConnection(connection);

    }
}
