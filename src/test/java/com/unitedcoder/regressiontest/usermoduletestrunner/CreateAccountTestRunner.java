package com.unitedcoder.regressiontest.usermoduletestrunner;

import com.seleniummaster.magento.frontendpages.CreateAccountPage;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateAccountTestRunner extends TestBasePage {
   static CreateAccountPage accountPage;
   String firstName= prop.getProperty("ca-firstNmae");
    String lastName= prop.getProperty("ca-lastName");
    String email= prop.getProperty("ca-email");
    String password= prop.getProperty("ca-password");

    @BeforeClass
    public void setUp(){
        setUpBrowser();
        Log.moduleName("Create Account Test has been started");
        driver.get(prop.getProperty("create_url"));

    }

    @Test(description = "user should be able to Create Account-Abdusamad")
    public void createAccount(){
         accountPage=new CreateAccountPage(driver);
        accountPage.userCreateAccount(firstName,lastName,email,password);
        Assert.assertTrue(accountPage.verifySuccess());

    }

    @AfterClass
    public static void close(){

        closeBrowser();
    }
}
