package com.unitedcoder.regressiontest.testng;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.customerpages.*;
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
    @Test(description = "1:Customer Manager can add a new customer ",priority = 1,groups = {"AddCustomer"})//-Yusuf
    public void addNewCustomer() {
        String customer_email=String.format(prop.getProperty("cus_Email"),System.currentTimeMillis());
        customerPage=new CustomerPage();
        customerPage.addNewCustomer(customer_email);
        TestDataHolder.setCustomerEmail(customer_email);
        Log.info("Add new customer started");
        Assert.assertTrue(customerPage.newCustomerAddedSuccessfully());
    }
    @Test(description = "2:Customer Manager can update an existing customer",priority = 2,dependsOnGroups = {"AddCustomer"}) //sofia
    public void upDateExistingCustomer() {
        customerPage=new CustomerPage();
        customerPage.updateCustomer(TestDataHolder.getCustomerEmail());
        Assert.assertTrue(customerPage.customerUpdatedSuccessfully());
    }
    @Test(enabled = false,description = "Customer Manager can reset customer's password - LeiLa",priority = 3)
    public void resetCustomersPassword() {
       // String customerEmail=TestDataHolder.getCustomerEmail();
        String newPassword=prop.getProperty("newPassword");
        String currentPassword=prop.getProperty("currentPassword");
        customerPage=new CustomerPage();
        customerPage.resetCustomerPassword("t1@gmail.com",newPassword,currentPassword);
        Assert.assertTrue(customerPage.customerUpdatedSuccessfully());
    }
    @Test(enabled = false,description = "Customer Manager can add a new address for a customer - MeliKe ",priority = 4)
    public void addNewAddress() {
        String streetAddress=prop.getProperty("streetAddress");
        String cityName=prop.getProperty("cityName");
        String zipcode=prop.getProperty("zipCode");
        String telNumber=prop.getProperty("telePhoneNumber");
        AddAddressesPage addressesPage=new AddAddressesPage();
        customerPage=new CustomerPage();
        customerPage.defineCustomer(TestDataHolder.getCustomerEmail());
        addressesPage.addAddress(streetAddress,cityName,zipcode,telNumber);
        Assert.assertTrue(addressesPage.newAddressAddedSuccessfully());
    }
    @Test(description = "3:Customer Manager can delete an existing customer",priority = 5,dependsOnGroups = {"AddCustomer"}) //zuhra
    public void deleteExistingCustomer() {
        customerPage=new CustomerPage();
       customerPage.deleteCustomer(TestDataHolder.getCustomerEmail());
       Assert.assertTrue(customerPage.customerDeletedSuccessfully());
    }
    @Test(description = "Customer Manager can filter customers by name",priority = 6)
    public void filterCustomerByName() {
        filterCustomerPage=new FilterCustomerPage();
        filterCustomerPage.filterByName(prop.getProperty("customerName"));
        Assert.assertTrue(filterCustomerPage.filteringCompletedSuccessfully());
    }
    @Test(description = "Customer Manager can filter customers by Email",priority = 7)
    public void filterCustomerByEmail() {
        filterCustomerPage=new FilterCustomerPage();
        filterCustomerPage.filterByEmail(prop.getProperty("customerEmail"));
        Assert.assertTrue(filterCustomerPage.filteringCompletedSuccessfully());
    }
    @Test(description = "Customer Manager can filter customers byGroup",priority = 8)
    public void filterCustomerByGroup() {
        filterCustomerPage=new FilterCustomerPage();
        filterCustomerPage.filterByGroup(prop.getProperty("customerGroup"));
        Assert.assertTrue(filterCustomerPage.filteringCompletedSuccessfully());
    }
    @Test(description = "Customer Manager can filter customers by country",priority = 9)
    public void filterCustomerByCountry() {
        filterCustomerPage=new FilterCustomerPage();
        filterCustomerPage.filterByCountry(prop.getProperty("country"));
        Assert.assertTrue(filterCustomerPage.filteringCompletedSuccessfully());
    }
    @Test(description = "Customer Manager can filter customers by state",priority = 10)
    public void filterCustomerByState() {
        filterCustomerPage=new FilterCustomerPage();
        filterCustomerPage.filterByState(prop.getProperty("stateName"));
        Assert.assertTrue(filterCustomerPage.filteringCompletedSuccessfully());
    }
    @Test(description = "Customer Manager can filter customers by website",priority = 11)
    public void filterCustomerByWebsite() {
        filterCustomerPage=new FilterCustomerPage();
        filterCustomerPage.filterByWebsite(prop.getProperty("website"));
        Assert.assertTrue(filterCustomerPage.filteringCompletedSuccessfully());
    }
    @Test(enabled = false,description = "Customer Manager can export customers - AyPer",priority = 12)
    public void exportCustomer() {
        customerPage=new CustomerPage();
        customerPage.exportCustomerList();
        Assert.assertTrue(customerPage.isCustomerFileExported());
    }
    @Test(description = "8:Customer Manager can assign a customer to a Customer Group" +
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