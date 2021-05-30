package com.unitedcoder.regressiontest.testng;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.customerpages.CustomerGroupPage;
import com.seleniummaster.magento.backendpages.customerpages.CustomerPage;
import com.seleniummaster.magento.backendpages.customerpages.FilterCustomerPage;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CustomerModuleTestRunner extends TestBasePage {
    CustomerPage customerPage;
    FilterCustomerPage filterCustomerPage;
    CustomerGroupPage customerGroupPage;

    @BeforeClass
    public void setUp() {
        setUpBrowser();
        driver.get(prop.getProperty("BackendURL"));
        BackEndLogin backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("customerManager"), prop.getProperty("password"));

    }

    @Test(description = "1:Customer Manager can add a new customer -Yusuf")
    public void addNewCustomer() {
        customerPage=new CustomerPage();
        customerPage.addNewCustomer();
        Log.info("Add new customer started");
        Assert.assertTrue(customerPage.verifySuccessMessage());
    }

    @Test(description = "2:Customer Manager can update an existing customer - SoFiYe")
    public void upDateExistingCustomer() {
        customerPage=new CustomerPage();
        customerPage.updateCustomer(prop.getProperty("cus_Email"));
        Assert.assertTrue(customerPage.displaySuccessMessage());

    }

    @Test(description = "3:Customer Manager can delete an existing customer - ZohRe")
    public void deleteExistingCustomer() {
        customerPage=new CustomerPage();
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
        customerPage=new CustomerPage();
        customerPage.exportCustomerList();
        Assert.assertTrue(customerPage.isCustomerFileExported());
    }

    @Test(description = "6:Customer Manager can reset customer's password - LeiLa")
    public void resetCustomersPassword() {



    }

    @Test(description = "Customer Manager can add a new address for a customer - MeliKe ")
    public void addNewAddress() {


    }

    @Test(description = "8:Customer Manager can assign a customer to a Customer Group" +
            " in the Actions on the All Customer page -  DilNur ")
    public void assignCustomer() {
        String email=prop.getProperty("FrondEmail1");
        String valueOfAssign=prop.getProperty("valueOfAssign");
        String valueOfGroup=prop.getProperty("valueOfGroup");
        customerPage=new CustomerPage();
        customerPage.assignCustomerToGroup(email,valueOfAssign,valueOfGroup);
        Assert.assertTrue(customerPage.customerAssignedToGroupSuccessfully());
    }

    @Test(description = "Customer Manager can add customer groups - Abdusemed ")
    public void addCustomerGroup() {
        String groupName=prop.getProperty("groupName");
        String general=prop.getProperty("valueOfGeneral");
        customerGroupPage=new CustomerGroupPage();
        customerGroupPage.createCustomerGroup(groupName,general);
        Assert.assertTrue(customerGroupPage.addCustomerGroupSuccessfully());
    }
    @Test(description = "Customer Manager should be able to Update Customer Group - abdusemed")
    //dependsOnMethods = {"addCustomerGroup"}
    public void updateCustomerGroup() {
        String groupName=prop.getProperty("groupName");
        String general=prop.getProperty("valueOfVIP");
        customerGroupPage=new CustomerGroupPage();
        customerGroupPage.updateCustomerGroup(groupName,general);
        Assert.assertTrue(customerGroupPage.updateCustomerGroupSuccessfully());
    }
    @Test(description = "Customer Manager should be able to delete Customer Group - abdusemed")
    //dependsOnMethods = {"updateCustomerGroup"}
    public void deleteCustomerGroup() {
        String groupName=prop.getProperty("groupName");
        customerGroupPage=new CustomerGroupPage();
        customerGroupPage.deleteCustomerGroup(groupName);
        Assert.assertTrue(customerGroupPage.deleteCustomerGroupSuccessfully());
    }
    @AfterClass
    public static void close() {
        closeBrowser();
    }
}

