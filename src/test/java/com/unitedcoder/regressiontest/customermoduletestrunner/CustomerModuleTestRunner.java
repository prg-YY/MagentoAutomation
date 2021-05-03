package com.unitedcoder.regressiontest.customermoduletestrunner;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.customerpages.CustomerPage;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CustomerModuleTestRunner extends TestBasePage {

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
        CustomerPage customerPage=new CustomerPage(driver);
        customerPage.clickOnAddCustomerLink();
        customerPage.enterFirstName(prop.getProperty("yusufFirstName"));
        customerPage.enterLastName(prop.getProperty("yusufLastName"));
        customerPage.enterEmail(prop.getProperty("yusufEmail"));
        customerPage.enterPassword(prop.getProperty("yusufPassword"));
        customerPage.clickSaveCustomerLink();
        Assert.assertTrue(customerPage.verifySuccessMessage());




    }
}