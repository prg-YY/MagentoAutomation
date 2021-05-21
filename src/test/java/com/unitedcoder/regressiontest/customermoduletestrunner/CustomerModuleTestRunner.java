package com.unitedcoder.regressiontest.customermoduletestrunner;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.customerpages.AddCustomerPage;
import com.seleniummaster.magento.backendpages.customerpages.CustomerUpdatePage;
import com.seleniummaster.magento.backendpages.customerpages.DeleteAnExistingCustomerPage;
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
    String groupName = prop.getProperty("cus_GroupName");
    AddCustomerPage addCustomerPage;

    @BeforeClass
    public void setUp() {
        setUpBrowser();
        Log.info("Add new customer started");
        driver.get(prop.getProperty("BackendURL"));
        BackEndLogin backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("customerManager"), prop.getProperty("password"));

    }

    @Test(description = "1:Customer Manager can add a new customer -Yusuf")
    public void addNewCustomer() {
        addCustomerPage=new AddCustomerPage(driver);
        addCustomerPage.addNewCustomer();


    }

    @Test(description = "2:Customer Manager can update an existing customer - SoFiYe")
    public void upDateExistingCustomer() {
        CustomerUpdatePage updatePage=new CustomerUpdatePage(driver);
        updatePage.updateCustomerInformation();
        Assert.assertTrue(updatePage.displaySuccessMessage());

    }

    @Test(description = "3:Customer Manager can delete an existing customer - ZohRe")
    public void deleteExistingCustomer() {
        DeleteAnExistingCustomerPage deleteCustomerPage = new DeleteAnExistingCustomerPage(driver);
        deleteCustomerPage.deleteCustomer("batushbilal@gmail.com");

    }

    @Test(description = "4:Customer Manager can filter customers by various filters such as Email," +
            " Group, Country, State, Web Site, Gender and Tax VAT Number - KeMer ")
    public void filterCustomer() {


    }

    @Test(description = "5:Customer Manager can export customers - AyPer")
    public void exportCustomer() {

    }

    @Test(description = "6:Customer Manager can reset customer's password - LeiLa")
    public void resetCustomersPassword() {

    }

    @Test(description = "7:Customer Manager can add a new address for a customer - MeliKe ")
    public void addNewAddress() {

    }

    @Test(description = "8:Customer Manager can assign a customer to a Customer Group" +
            " in the Actions on the All Customer page -  DilNur ")
    public void assignCustomer() {

    }

    TestDataHolder holder;
    Random ran = new Random();

    @Test(description = "9:Customer Manager can add and update customer groups - Abdusemed ")
    public void addGroups() {
        int r = ran.nextInt(50);
        customerGroupPage = new UpdateCustomerGroupPage(driver);
        holder = new TestDataHolder();
        customerGroupPage.addCustomerGroup(groupName + r);
        holder.setCustomerGroupName(groupName + r);
        prop.setProperty("cus_GroupName_Update", holder.getCustomerGroupName());
        try {
            prop.store(new FileOutputStream("C:\\Users\\Admin\\ameap_team1\\config.properties"),
                    "holdingGroupData");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(customerGroupPage.successMessageDisplayed());
    }

    @Test(description = "User should be able to Update Customer Group - abdusemed")
    public void updateCustomerGroup() {
        String newGroupName = prop.getProperty("cus_GroupName_Update");
        customerGroupPage.searchCustomerForUpdate(newGroupName);
        int r = ran.nextInt(300);
        customerGroupPage.updateCustomerGroup(groupName + r);
        Assert.assertTrue(customerGroupPage.successMessageDisplayed());
    }


    @AfterClass
    public static void close() {

    }
}

