package com.unitedcoder.regressiontest.usermoduletestrunner;

import com.seleniummaster.magento.backendpages.customerpages.CustomerDashboardPage;
import com.seleniummaster.magento.frontendpages.CheckOutOrderPage;
import com.seleniummaster.magento.frontendpages.FrontEndLoginPage;
import com.seleniummaster.magento.frontendpages.MyWishListPage;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PublicUserModuleTestRunner extends TestBasePage {
    CheckOutOrderPage checkOutOrderPage;

    @BeforeClass
    public void setUp(){
        setUpBrowser();
        Log.moduleName("FrontEnd");
        driver.get(prop.getProperty("login_url"));
        FrontEndLoginPage loginPage=new FrontEndLoginPage(driver);
        loginPage.loginUser(prop.getProperty("FrondEmail"), prop.getProperty("FrontPassword") );
    }

    @Test(description = "user should be able to  check out order-yusuf")
    public void checkOrder(){
        checkOutOrderPage =new CheckOutOrderPage(driver);
        checkOutOrderPage.checkoutOrderM();

    }
    @Test(description = "user should be able to add address")
    public void addAddress(){

    }
    @Test
    public void editAccountInformation(){

    }
    @Test(description="User should be able to view My Wish List- Kamer" )
    public  void viewMyWishList(){
      MyWishListPage myWishlistPage=new MyWishListPage(driver);
        CheckOutOrderPage checkOutOrderPage=new CheckOutOrderPage(driver);
        checkOutOrderPage.clickAccountTag();
        myWishlistPage.clickMyWishList();
        Assert.assertTrue(myWishlistPage.verifyMyWishList());

    }
    @AfterClass
    public static void close(){

//        closeBrowser();
    }
}
