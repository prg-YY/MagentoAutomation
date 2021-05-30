package com.unitedcoder.regressiontest.testng;

import com.seleniummaster.magento.frontendpages.*;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import org.openqa.selenium.JavascriptExecutor;
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

    @Test(description = "user should be able to add products to shopping cart")
    public void AddNewProduct() {
        MyDashboardPage myDashboardPage = new MyDashboardPage(driver);
        myDashboardPage.addNewProduct();
        Assert.assertTrue(myDashboardPage.VerifyAddToCartSuccessful());

    }

    @Test(description = "user should be able to  check out order-yusuf")
    public void checkOrder() {
        checkOutOrderPage = new CheckOutOrderPage(driver);
        checkOutOrderPage.checkoutOrderM();

    }

    @Test(description = "user should be able to view his/her orders")
    public void ViewOrders() {
        MyDashboardPage myDashboardPage = new MyDashboardPage(driver);
        Assert.assertTrue(myDashboardPage.viewOrders());
    }

    @Test(description = "user should be able to view my downloadable products-zuhra")
    public void ViewDownloadableProducts() {
        MyDownloadableProductsPage downloadableProductsPage = new
                MyDownloadableProductsPage(driver);
        downloadableProductsPage.clickOnMyDownloadableProductsLink();
        downloadableProductsPage.viewMyDownloadableProducts();
    }

    @Test(description = "User should be able to view My Wish List- Kamer")
    public void viewMyWishList() {
        MyWishListPage myWishlistPage = new MyWishListPage(driver);
        CheckOutOrderPage checkOutOrderPage = new CheckOutOrderPage(driver);
        checkOutOrderPage.clickAccountTag();
        myWishlistPage.clickMyWishList();
        Assert.assertTrue(myWishlistPage.verifyMyWishList());

    }

    @Test(description = "User should be able to update and view address-Ayper")
    public void updateAddress() {
        MyDashboardPage dashBoardPage = new MyDashboardPage(driver);
        dashBoardPage.clickAddressBookLink();
        AddNewAddressPage addNewAddressPage = new AddNewAddressPage(driver);
        dashBoardPage.clickAddNewAddressLink();
        addNewAddressPage.addNewAddress();
        Assert.assertTrue(addNewAddressPage.verifySuccess());
    }

    @Test(description = "User should be able to edit account information-Leila")
    public void editAccountInformation() {
        MyDashboardPage myDashboardPage = new MyDashboardPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
        myDashboardPage.clickChangePasswordLink();
        AccountInformationPage accountInformationPage = new AccountInformationPage(driver);
        accountInformationPage.changePassword();
        Assert.assertTrue(accountInformationPage.verifySuccessfulMessage());
    }

    @Test(description = "A user should be able to change password@Melike")
    public void ChangePassword() {
        MyDashboardPage myDashboardPage = new MyDashboardPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
        myDashboardPage.clickChangePasswordLink();
        AccountInformationPage accountInformationPage = new AccountInformationPage(driver);
        accountInformationPage.changePassword();
        Assert.assertTrue(accountInformationPage.verifySuccessfulMessage());

    }

    @Test(description = "A user should see \"Stored Payment Method\" link")

    public void seeStoredPaymentMethodLink() {
        //BUG!
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

    @Test(description = "A user should see \"News Letter Subscriptions Link\" @Abdulkahhar")
    public void SeeNewsLetterSubscriptionLink() {
        MyDashboardPage myDashboardPage = new MyDashboardPage(driver);
        Assert.assertTrue(myDashboardPage.newsLetterSubscriptionsLinkIsDisplay());
    }

    @Test(description = "User should be able to see News Letter Subscriptions content")
    public void seeNewsletterSubscriptionContent() {
        MyDashboardPage myDashboardPage = new MyDashboardPage(driver);
        Assert.assertTrue(myDashboardPage.NewsletterReviewsContent());


    }

    @AfterClass
    public static void close() {

        closeBrowser();
    }
}
