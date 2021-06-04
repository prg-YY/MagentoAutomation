package com.unitedcoder.regressiontest.testng;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.customerpages.CustomerGroupPage;
import com.seleniummaster.magento.backendpages.customerpages.CustomerPage;
import com.seleniummaster.magento.backendpages.customerpages.FilterCustomerPage;
import com.seleniummaster.magento.testdata.TestDataHolder;
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

    @Test(description = "1:Customer Manager can add a new customer -Yusuf",priority = 1)
    public void addNewCustomer() {
        String customer_email=String.format(prop.getProperty("cus_Email"),System.currentTimeMillis());
        customerPage=new CustomerPage();
        customerPage.addNewCustomer(customer_email);
        TestDataHolder.setCustomerEmail(customer_email);
        Log.info("Add new customer started");
        Assert.assertTrue(customerPage.newCustomerAddedSuccessfully());
    }

    @Test(description = "2:Customer Manager can update an existing customer - SoFiYe",priority = 2)
    public void upDateExistingCustomer() {
        customerPage=new CustomerPage();
        customerPage.updateCustomer(TestDataHolder.getCustomerEmail());
        Assert.assertTrue(customerPage.customerUpdatedSuccessfully());

    }

    @Test(description = "3:Customer Manager can delete an existing customer - ZohRe",priority = 3)
    public void deleteExistingCustomer() {
        customerPage=new CustomerPage();
       customerPage.deleteCustomer(TestDataHolder.getCustomerEmail());
       Assert.assertTrue(customerPage.customerDeletedSuccessfully());

    }

    @Test(description = "Customer Manager can filter customers by name",priority = 4)
    public void filterCustomerByName() {
        filterCustomerPage=new FilterCustomerPage();
        filterCustomerPage.filterByName(prop.getProperty("customerName"));
        Assert.assertTrue(filterCustomerPage.filteringCompletedSuccessfully());
    }
    @Test(description = "Customer Manager can filter customers by Email",priority = 5)
    public void filterCustomerByEmail() {
        filterCustomerPage=new FilterCustomerPage();
        filterCustomerPage.filterByEmail(prop.getProperty("customerEmail"));
        Assert.assertTrue(filterCustomerPage.filteringCompletedSuccessfully());
    }
    @Test(description = "Customer Manager can filter customers byGroup",priority = 6)
    public void filterCustomerByGroup() {
        filterCustomerPage=new FilterCustomerPage();
        filterCustomerPage.filterByGroup(prop.getProperty("customerGroup"));
        Assert.assertTrue(filterCustomerPage.filteringCompletedSuccessfully());
    }
    @Test(description = "Customer Manager can filter customers by country",priority = 7)
    public void filterCustomerByCountry() {
        filterCustomerPage=new FilterCustomerPage();
        filterCustomerPage.filterByCountry(prop.getProperty("country"));
        Assert.assertTrue(filterCustomerPage.filteringCompletedSuccessfully());
    }
    @Test(description = "Customer Manager can filter customers by state",priority = 8)
    public void filterCustomerByState() {
        filterCustomerPage=new FilterCustomerPage();
        filterCustomerPage.filterByState(prop.getProperty("stateName"));
        Assert.assertTrue(filterCustomerPage.filteringCompletedSuccessfully());
    }
    @Test(description = "Customer Manager can filter customers by website",priority = 9)
    public void filterCustomerByWebsite() {
        filterCustomerPage=new FilterCustomerPage();
        filterCustomerPage.filterByWebsite(prop.getProperty("website"));
        Assert.assertTrue(filterCustomerPage.filteringCompletedSuccessfully());
    }


    @Test(enabled = false,description = "Customer Manager can export customers - AyPer",priority = 10)
    public void exportCustomer() {
        customerPage=new CustomerPage();
        customerPage.exportCustomerList();
        Assert.assertTrue(customerPage.isCustomerFileExported());
    }

    @Test(description = "6:Customer Manager can reset customer's password - LeiLa",priority = 11)
    public void resetCustomersPassword() {



    }

    @Test(description = "Customer Manager can add a new address for a customer - MeliKe ",priority = 12)
    public void addNewAddress() {


    }

    @Test(enabled = false,description = "8:Customer Manager can assign a customer to a Customer Group" +
            " in the Actions on the All Customer page -  DilNur ",priority = 13)
    public void assignCustomer() {
        String email=prop.getProperty("FrondEmail1");
        String valueOfAssign=prop.getProperty("valueOfAssign");
        String valueOfGroup=prop.getProperty("valueOfGroup");
        customerPage=new CustomerPage();
        customerPage.assignCustomerToGroup(email,valueOfAssign,valueOfGroup);
        Assert.assertTrue(customerPage.customerAssignedToGroupSuccessfully());
    }

    @Test(description = "Customer Manager can add customer groups - Abdusemed ",priority = 14)
    public void addCustomerGroup() {
        String groupName=String.format(prop.getProperty("groupName"),System.currentTimeMillis());
        String general=prop.getProperty("valueOfGeneral");
        customerGroupPage=new CustomerGroupPage();
        customerGroupPage.createCustomerGroup(groupName,general);
        TestDataHolder.setCustomerGroupName(groupName);
        Assert.assertTrue(customerGroupPage.addCustomerGroupSuccessfully());
    }
    @Test(description = "Customer Manager should be able to Update Customer Group - abdusemed",priority =15 )
    //dependsOnMethods = {"addCustomerGroup"}
    public void updateCustomerGroup() {
        String groupName=TestDataHolder.getCustomerGroupName();
        String general=prop.getProperty("valueOfVIP");
        customerGroupPage=new CustomerGroupPage();
        customerGroupPage.updateCustomerGroup(groupName,general);
        Assert.assertTrue(customerGroupPage.updateCustomerGroupSuccessfully());
    }
    @Test(description = "Customer Manager should be able to delete Customer Group - abdusemed",priority = 16)
    //dependsOnMethods = {"updateCustomerGroup"}
    public void deleteCustomerGroup() {
        String groupName=TestDataHolder.getCustomerGroupName();
        customerGroupPage=new CustomerGroupPage();
        customerGroupPage.deleteCustomerGroup(groupName);
        Assert.assertTrue(customerGroupPage.deleteCustomerGroupSuccessfully());
    }
    @AfterClass
    public static void close() {
        closeBrowser();
    }
}

