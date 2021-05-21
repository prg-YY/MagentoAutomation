package com.unitedcoder.regressiontest.usermoduletestrunner;

import com.seleniummaster.magento.frontendpages.*;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PublicUserModuleTestRunner extends TestBasePage {
    static CheckOutOrderPage checkOutOrderPage;

    @BeforeClass
    public void setUp() {
        setUpBrowser();
        Log.moduleName("Check Out Order Started");
        driver.get(prop.getProperty("login_url"));
        FrontEndLoginPage loginPage = new FrontEndLoginPage(driver);
        loginPage.loginUser(prop.getProperty("FrondEmail"), prop.getProperty("FrontPassword"));
    }

    @Test(description = "user should be able to  check out order-yusuf")
    public void checkOrder() {
        checkOutOrderPage = new CheckOutOrderPage(driver);
        checkOutOrderPage.checkoutOrderM();

    }

    @Test(description = "user should be able to add address")
    public void addAddress() {

    }

    @Test
    public void editAccountInformation() {

    }

    @Test(description = "User should be able to update and view address-Ayper")
    public void updateAddress() {
        MyDashboardPage dashBoardPage = new MyDashboardPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        dashBoardPage.clickAccountTag();
        Assert.assertTrue(myAccountPage.verifyMyAccountLink());
        AddNewAddressPage newAddressPage = dashBoardPage.clickNewAddressPage();
        newAddressPage.addNewAddress(prop.getProperty("firstNamePrefix"), prop.getProperty("lastNamePrefix"), prop.getProperty("phoneNumberPrefix"),
                prop.getProperty("addressPrefix"), prop.getProperty("CountryPrefix"), prop.getProperty("StatePrefix"), prop.getProperty("CityPrefix"), prop.getProperty("ZipPrefix"));
        Assert.assertTrue(newAddressPage.verifySuccess());
    }

    @Test(description = "User should be able to view My Wish List- Kamer")
    public void viewMyWishList() {
        MyWishListPage myWishlistPage = new MyWishListPage(driver);
        CheckOutOrderPage checkOutOrderPage = new CheckOutOrderPage(driver);
        checkOutOrderPage.clickAccountTag();
        myWishlistPage.clickMyWishList();
        Assert.assertTrue(myWishlistPage.verifyMyWishList());

    }

    @Test(description = "User should be able to see product reviews link")
    public void seeProductReviewsLink() {
        MyProductReviewsPage productReviewsPage = new MyProductReviewsPage(driver);
        productReviewsPage.myProductReviewsLinkIsDisplay();
        Assert.assertTrue(productReviewsPage.myProductReviewsLinkIsDisplay());
    }

    @Test(description = "User should be able to see product reviews content")
    public void seeProductReviewsContent() {
        MyProductReviewsPage productReviewsPage = new MyProductReviewsPage(driver);
        productReviewsPage.reviewsContentIsDisplay();
        Assert.assertTrue(productReviewsPage.reviewsContentIsDisplay());
    }

    @Test(description = "user should be able to view my downloadable products-zuhra")
    public void ViewDownloadableProducts() {
        MyDownloadableProductsPage downloadableProductsPage = new
                MyDownloadableProductsPage(driver);
        downloadableProductsPage.clickOnMyDownloadableProductsLink();
        downloadableProductsPage.viewMyDownloadableProducts();
    }

    @AfterClass
    public static void close() {

        closeBrowser();
    }
}
