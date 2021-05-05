package com.unitedcoder.regressiontest.customermoduletestrunner;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.customerpages.CustomerPage;
import com.seleniummaster.magento.backendpages.customerpages.CustomerUpdatePage;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CustomerModuleTestRunner extends TestBasePage {
   CustomerUpdatePage customerUpdatePage;
    @BeforeClass
    public void setUp() {
        setUpBrowser();
        Log.info("Add new customer started");
        driver.get(prop.getProperty("BackendURL"));
        BackEndLogin backEndLogin=new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("customerManager"), prop.getProperty("password") );
        
    }

    @Test(description = "manager should be able to add new customer")
    public void addCustomer(){
        CustomerPage customerPage=new CustomerPage();
        customerPage.addNewCustomer(prop.getProperty("FirstName"),
                prop.getProperty("LastName"), prop.getProperty("newEmail"),
                prop.getProperty("password"));
        Assert.assertTrue(customerPage.verifySuccessMessage());

    }
    @Test
    public void UpdateCustomer(){
        customerUpdatePage=new CustomerUpdatePage(driver);
        Assert.assertTrue(customerUpdatePage.updateCustomerInformation());
    }

}