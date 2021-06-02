package com.unitedcoder.regressiontest.testng;

import com.seleniummaster.magento.database.ConnectionManager;
import com.seleniummaster.magento.database.ConnectionType;
import com.seleniummaster.magento.database.DataAccess;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;

public class ConnectionTest {
    Connection  connection;
    @BeforeClass
    public void setUp(){
        connection= ConnectionManager.connectToDataBaseServer(ConnectionType.MSSQLSERVER);

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
