package com.unitedcoder.regressiontest.usermoduletestrunner;

import com.seleniummaster.magento.frontendpages.AccountInformationPage;
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
        loginPage.loginUser(prop.getProperty("FrondEmail"), prop.getProperty("EmailPassword") );
    }

    @Test(description = "user should be able to  check out order-yusuf")
    public void checkOrder(){
        checkOutOrderPage =new CheckOutOrderPage(driver);
        checkOutOrderPage.clickAccountTag();
        checkOutOrderPage.clickChekOutLink();
        checkOutOrderPage.clickOnContinue1();
        checkOutOrderPage.clickOnContinue2();
        checkOutOrderPage.clickOnContinue3();
        checkOutOrderPage.clickOnMoneyOrderCheckBox();
        checkOutOrderPage.clickOnContinue4();
        checkOutOrderPage.clickOnPlaceOrderButton();
        Assert.assertTrue(checkOutOrderPage.verifyOrderMassage());

    }
    @Test(description = "user should be able to add address")
    public void addAddress(){

    }
    @Test(description = "user should be able to edit account information-leila")
    public void editAccountInformation(){
        AccountInformationPage informationPage=new AccountInformationPage(driver);
        informationPage.clickOnAccountInfo();
        informationPage.ClearFirstName();
        informationPage.EnterFirstName(prop.getProperty("FirstName"));
        informationPage.EnterCurrentPassword(prop.getProperty("EnterCurrentPassword"));
        informationPage.clickSaveButton();
        Assert.assertTrue(informationPage.verifySuccess());

    }
    @AfterClass
    public static void close(){

//        closeBrowser();
    }
}
