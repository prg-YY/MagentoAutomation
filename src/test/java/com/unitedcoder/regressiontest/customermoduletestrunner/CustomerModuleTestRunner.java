package com.unitedcoder.regressiontest.customermoduletestrunner;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.customerpages.AddCustomerPage;
import com.seleniummaster.magento.backendpages.customerpages.UpdateCustomerGroupPage;
import com.seleniummaster.magento.testdata.TestDataHolder;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class CustomerModuleTestRunner extends TestBasePage {
    static UpdateCustomerGroupPage customerGroupPage;
    String groupName=prop.getProperty("cus_GroupName");

    @BeforeClass
    public void setUp() {
        setUpBrowser();
        Log.info("Add new customer started");
        driver.get(prop.getProperty("BackendURL"));
        BackEndLogin backEndLogin=new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("customerManager"), prop.getProperty("password") );

    }

    @Test
    public void addCustomer(){
        AddCustomerPage addCustomerPage=new AddCustomerPage(driver);
        addCustomerPage.addNewCustomer();
        Assert.assertTrue(addCustomerPage.verifySuccessMessage());

    }

    TestDataHolder holder;
    Random ran=new Random();
    @Test(description = "User Should be able to add new customer Group")
    public void addCustomerGroup(){
        int r=ran.nextInt(50);
        customerGroupPage=new UpdateCustomerGroupPage(driver);
        holder=new TestDataHolder();
        customerGroupPage.addCustomerGroup(groupName+r);
        holder.setCustomerGroupName(groupName+r);
        prop.setProperty("cus_GroupName_Update",holder.getCustomerGroupName());
        try {
            prop.store(new FileOutputStream("C:\\Users\\Admin\\ameap_team1\\config.properties"),
                    "holdingGroupData");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(customerGroupPage.successMessageDisplayed());
    }
    @Test(description = "User should be able to Update Customer Group")
    public void updateCustomerGroup(){
        String newGroupName= prop.getProperty("cus_GroupName_Update");
        customerGroupPage.searchCustomerForUpdate(newGroupName);
        int r= ran.nextInt(300);
        customerGroupPage.updateCustomerGroup(groupName+r);
        Assert.assertTrue(customerGroupPage.successMessageDisplayed());
    }

    @AfterClass
    public static void close(){
        closeBrowser();
    }
}