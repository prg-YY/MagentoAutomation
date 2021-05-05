package com.unitedcoder.regressiontest.usermoduletestrunner;

import com.seleniummaster.magento.frontendpages.CheckOutOrderPage;
import com.seleniummaster.magento.frontendpages.FrontEndLoginPage;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PublicUserModuleTestRunner extends TestBasePage {
   static CheckOutOrderPage checkOutOrderPage;

    @BeforeClass
    public void setUp(){
        setUpBrowser();
        Log.moduleName("Check Out Order Started");
        driver.get(prop.getProperty("login_url"));
        FrontEndLoginPage loginPage=new FrontEndLoginPage(driver);
        loginPage.loginUser(prop.getProperty("username"), prop.getProperty("PasswordPrefix") );
    }

    @Test(description = "user should be able to  check out order-yusuf")
    public void checkOrder(){
        checkOutOrderPage =new CheckOutOrderPage(driver);
        checkOutOrderPage.checkoutOrderM(driver);

    }
    @Test(description = "user should be able to add address")
    public void addAddress(){

    }
    @Test
    public void editAccountInformation(){

    }
    @AfterClass
    public static void close(){

//        closeBrowser();
    }
}
