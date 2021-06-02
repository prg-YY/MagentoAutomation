package com.unitedcoder.regressiontest.databasetest;

import com.seleniummaster.magento.database.ConnectionManager;
import com.seleniummaster.magento.database.ConnectionType;
import com.seleniummaster.magento.database.DataAccess;
import com.seleniummaster.magento.database.QueryScript;
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
    @BeforeClass
    public void setUp(){
        connection= ConnectionManager.connectToDataBaseServer(username,password,ConnectionType.MYSQLServer);
    }
    @Test(description = "Verify that newly added customers should be in the database")//abdusamad
    public void isAddedCustomerExist(){
        DataAccess access=new DataAccess();
        CachedRowSet cachedRowSet=access.readFromDataBase(connection, QueryScript.getNewlyAddedCustomer());
        Assert.assertTrue(access.getRowCount(cachedRowSet));
    }
    @Test(description = "Verify that  new added customer groups should be in the database")//Abdukahar
    public void isAddedCustomerGroupExist(){
        DataAccess access=new DataAccess();

    }

    @Test
    public void isAddedProductExist(){
        DataAccess access=new DataAccess();

    }
    @Test(description = "Verify that newly added product root category should be in the database")//Sofia
    public void isAddedProductRootCategoryExist(){
        DataAccess access=new DataAccess();

    }
    @Test(description = "Verify that newly registered users should be in the database")//Zuhra
    public void isRegisteredUserExist(){
        DataAccess access=new DataAccess();

    }
    @Test(description = "Verify that newly added orders should be in the database")//Kembarnisa
    public void isAddedOrderExist(){
        DataAccess access=new DataAccess();

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

    @Test(description = "Verify that newly added stock should be in the database")//melike
    public void isAddedStockExist(){
        DataAccess access=new DataAccess();

    }
    @Test(description = "Verify that newly added sub categories should be in the database")//Dilnur
    public void isAddedSubCategoryExist(){
        DataAccess access=new DataAccess();

    }
    @Test(description = "Verify that newly added store view should be in the database")//Abdusamad
    public void isAddedStoreViewExist(){
        DataAccess access=new DataAccess();

    }
    @Test(description = "Verify that newly added Cart Price Rule should be in the database")//Abdukahar
    public void isAddedCartPriceRuleExist(){
        DataAccess access=new DataAccess();

    }
    @Test(description = "Verify the newly added tax rule should be in the database")//Yusupjan
    public void isAddedTaxRuleExist(){
        DataAccess access=new DataAccess();

    }
    @Test(description = "Verify that newly added refund should be in the database")//Yusupjan
    public void isAddedRefundExist(){
        DataAccess access=new DataAccess();

    }

    @AfterClass
    public void tearDown(){
        ConnectionManager.closeDataBaseConnection(connection);
    }
}
