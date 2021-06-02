package com.unitedcoder.regressiontest.testng;

import com.seleniummaster.magento.database.ConnectionManager;
import com.seleniummaster.magento.database.ConnectionType;
import com.seleniummaster.magento.database.DataAccess;
import com.seleniummaster.magento.utility.TestBasePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;

public class ConnectionTest extends TestBasePage {
    static String username = prop.getProperty("dbUserName");
    static String password = prop.getProperty("dbPassword");
    static String productId = prop.getProperty("productId");
    static String taxRuleId = prop.getProperty("taxRuleId");
    DataAccess access;
    Connection connection;

    @BeforeClass
    public void setUp() {
        connection = ConnectionManager.connectToDataBaseServer(username, password, ConnectionType.MYSQLServer);
    }

    @Test
    public void isAddedCustomerExist() {
        access = new DataAccess();

    }

    @Test(description = "Verify that newly added product category should be in the database -Yusuf")
    public void isAddedProductExist() {
        access = new DataAccess();
        boolean isProductIDFound = access.getProductID(productId, connection);
        Assert.assertTrue(isProductIDFound);
    }

    @Test(description = "Verify the newly added tax rule should be in the database-Yusuf")
    public void isAddedTaxRule() {
        access = new DataAccess();
        boolean isTaxRuleFound = access.getTaxRule(taxRuleId, connection);
        Assert.assertTrue(isTaxRuleFound);

    }

    @AfterClass
    public void tearDown() {
        ConnectionManager.closeDataBaseConnection(connection);

    }
}
