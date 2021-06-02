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
    static String username=prop.getProperty("dbUserName");
    static String password=prop.getProperty("dbPassword");
    Connection  connection;
    @BeforeClass
    public void setUp(){
        connection= ConnectionManager.connectToDataBaseServer(username,password,ConnectionType.MYSQLServer);
    }
    @Test
    public void isAddedCustomerExist(){
        DataAccess access=new DataAccess();

    }

    @Test
    public void isAddedProductExist(){
        DataAccess access=new DataAccess();
        boolean isProductIDFound=access.getProductID(299,connection);
        Assert.assertTrue(isProductIDFound);
    }

    @AfterClass
    public void tearDown(){
        ConnectionManager.closeDataBaseConnection(connection);

    }
}
