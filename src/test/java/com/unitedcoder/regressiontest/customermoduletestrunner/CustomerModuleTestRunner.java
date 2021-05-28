package com.unitedcoder.regressiontest.customermoduletestrunner;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.customerpages.CustomerPage;
import com.seleniummaster.magento.backendpages.customerpages.FilterCustomerPage;
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
    CustomerPage customerPage;
    FilterCustomerPage filterCustomerPage;

    @BeforeClass
    public void setUp() {
        setUpBrowser();
        driver.get(prop.getProperty("BackendURL"));
        BackEndLogin backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("customerManager"), prop.getProperty("password"));

    }

    @Test(description = "1:Customer Manager can add a new customer -Yusuf")
    public void addNewCustomer() {
        customerPage=new CustomerPage(driver);
        customerPage.addNewCustomer();
        Log.info("Add new customer started");
        Assert.assertTrue(customerPage.verifySuccessMessage());
    }

    @Test(description = "2:Customer Manager can update an existing customer - SoFiYe")
    public void upDateExistingCustomer() {
        customerPage=new CustomerPage(driver);
        customerPage.updateCustomer(prop.getProperty("cus_Email"));
        Assert.assertTrue(customerPage.displaySuccessMessage());

    }

    @Test(description = "3:Customer Manager can delete an existing customer - ZohRe")
    public void deleteExistingCustomer() {
        customerPage=new CustomerPage(driver);
       customerPage.deleteCustomer(prop.getProperty("cus_Email"));
       customerPage.customerDeletedSuccessfully();
       Assert.assertTrue(customerPage.customerDeletedSuccessfully());

    }
//Customer Manager can filter customers by various filters such as Email," +
//            " Group, Country, State, Web Site, Gender and Tax VAT Number - KeMer
    @Test(description = "Customer Manager can filter customers by name")
    public void filterCustomerByName() {
        filterCustomerPage=new FilterCustomerPage();
        filterCustomerPage.filterByName(prop.getProperty("customerName"));
        Assert.assertTrue(filterCustomerPage.filteringCompletedSuccessfully());
    }
    @Test(description = "Customer Manager can filter customers by Email")
    public void filterCustomerByEmail() {
        filterCustomerPage=new FilterCustomerPage();
        filterCustomerPage.filterByEmail(prop.getProperty("customerEmail"));
        Assert.assertTrue(filterCustomerPage.filteringCompletedSuccessfully());
    }
    @Test(description = "Customer Manager can filter customers byGroup")
    public void filterCustomerByGroup() {
        filterCustomerPage=new FilterCustomerPage();
        filterCustomerPage.filterByGroup(prop.getProperty("customerGroup"));
        Assert.assertTrue(filterCustomerPage.filteringCompletedSuccessfully());
    }
    @Test(description = "Customer Manager can filter customers by country")
    public void filterCustomerByCountry() {
        filterCustomerPage=new FilterCustomerPage();
        filterCustomerPage.filterByCountry(prop.getProperty("country"));
        Assert.assertTrue(filterCustomerPage.filteringCompletedSuccessfully());
    }
    @Test(description = "Customer Manager can filter customers by state")
    public void filterCustomerByState() {
        filterCustomerPage=new FilterCustomerPage();
        filterCustomerPage.filterByState(prop.getProperty("stateName"));
        Assert.assertTrue(filterCustomerPage.filteringCompletedSuccessfully());
    }
    @Test(description = "Customer Manager can filter customers by website")
    public void filterCustomerByWebsite() {
        filterCustomerPage=new FilterCustomerPage();
        filterCustomerPage.filterByWebsite(prop.getProperty("website"));
        Assert.assertTrue(filterCustomerPage.filteringCompletedSuccessfully());
    }


    @Test(description = "Customer Manager can export customers - AyPer")
    public void exportCustomer() {
        customerPage=new CustomerPage(driver);
        customerPage.exportCustomerList();
        Assert.assertTrue(customerPage.isCustomerFileExported());
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
//        int r = ran.nextInt(50);
//        customerGroupPage = new UpdateCustomerGroupPage(driver);
//        holder = new TestDataHolder();
//        customerGroupPage.addCustomerGroup(groupName + r);
//        holder.setCustomerGroupName(groupName + r);
//        prop.setProperty("cus_GroupName_Update", holder.getCustomerGroupName());
//        try {
//            prop.store(new FileOutputStream("C:\\Users\\Admin\\ameap_team1\\config.properties"),
//                    "holdingGroupData");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Assert.assertTrue(customerGroupPage.successMessageDisplayed());
    }

    @Test(description = "User should be able to Update Customer Group - abdusemed")
    public void updateCustomerGroup() {
//        String newGroupName = prop.getProperty("cus_GroupName_Update");
//        customerGroupPage.searchCustomerForUpdate(newGroupName);
//        int r = ran.nextInt(300);
//        customerGroupPage.updateCustomerGroup(groupName + r);
//        Assert.assertTrue(customerGroupPage.successMessageDisplayed());
    }


    @AfterClass
    public static void close() {
        closeBrowser();

    }
}

