package com.unitedcoder.regressiontest.cucumber.StoreModuleSteps;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.storepages.*;
import com.seleniummaster.magento.utility.TestBasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StoreSteps extends TestBasePage {
    BackEndLogin backEndLogin=new BackEndLogin(driver);
    StoreDashboardPage storeDashboardPage=new StoreDashboardPage(driver);
    ManageProductsPage manageProductsPage=new ManageProductsPage(driver);
    OrderPage orderPage=new OrderPage(driver);
    ProductCategoriesPage productCategoriesPage=new ProductCategoriesPage(driver);
    WebsitePage websitePage=new WebsitePage(driver);
    StorePage storePage=new StorePage(driver);
    StoreViewPage storeViewPage=new StoreViewPage(driver);

    @Given("user already on the Manage store dashboard page")
    public void userAlreadyOnTheMangeStoreDashboardPage() {
        storeDashboardPage=new StoreDashboardPage(driver);

    }

    @When("click on Manage Products link under Catalog dropdown list")
    public void clickOnManageProductsLinkUnderCatalogDropdownList() {
        storeDashboardPage.clickAllCatalogLink();
        storeDashboardPage.clickManageProductsLink();

    }

    @And("user click on Add product button and fill out all product information")
    public void userClickOnAddProductButtonAndFillOutAllProductInformation() {
        manageProductsPage.AddProduct();

    }

    @Then("new product should be added")
    public void newProductShouldBeAdded() {
        Assert.assertTrue(manageProductsPage.VerifySuccessfulMessage());

    }

    @And("user click on the product link which should be updated then update product information")
    public void userClickOnTheProductLinkWhichShouldBeUpdatedThenUpdateProductInformation() {
        manageProductsPage.updateProduct();

    }

    @Then("product should be updated")
    public void productShouldBeUpdated() {
        Assert.assertTrue(manageProductsPage.VerifySuccessfulUpdated());
    }

    @When("click on Orders link under Sales dropdown list")
    public void clickOnOrdersLinkUnderSalesDropdownList() {
        storeDashboardPage.clickAllSalesLink();
        storeDashboardPage.clickOrdersLink();

    }

    @And("click Create New Order button and click the customer where should be added new order then add product")
    public void clickCreateNewOrderButtonAndClickTheCustomerWhereShouldBeAddedNewOrderThenAddProduct() {
        orderPage.CreateNewOrder();
    }

    @Then("new order should be created")
    public void newOrderShouldBeCreated() {

        Assert.assertTrue(orderPage.verifySuccessfulAddedMsg());
    }

    @And("Select the order should be edited and edit order information")
    public void selectTheOrderShouldBeEditedAndEditOrderInformation() {
        orderPage.EditOrder();

    }

    @Then("order should be edited")
    public void orderShouldBeEdited() {

        Assert.assertTrue(orderPage.verifySuccessfulAddedMsg());
    }

    @And("click the order should be deleted then click cancel button")
    public void clickTheOrderShouldBeDeletedThenClickCancelButton() {
        orderPage.CancelOrder();

    }

    @Then("order should be canceled")
    public void orderShouldBeCanceled() {

        Assert.assertTrue(orderPage.VerifySuccessfulCancelMsg());
    }

    @When("click on Manage Categories link under Catalog dropdown list")
    public void clickOnManageCategoriesLinkUnderCatalogDropdownList() {
        storeDashboardPage.clickAllCatalogLink();
        storeDashboardPage.clickManageCategoriesLink();
    }

    @And("fill out all new category information on New Root Category page and click Save Category button")
    public void fillOutAllNewCategoryInformationOnNewRootCategoryPageAndClickSaveCategoryButton() {
        productCategoriesPage.addProductCategory();
    }

    @Then("new product category should be added")
    public void newProductCategoryShouldBeAdded() {
        Assert.assertTrue(productCategoriesPage.VerifySuccessfullyAddCategoryMsg());
    }

    @And("click the category should be updated then update category information")
    public void clickTheCategoryShouldBeUpdatedThenUpdateCategoryInformation() {
        productCategoriesPage.UpdateProductCategory();
    }

    @Then("Category should be updated")
    public void categoryShouldBeUpdated() {
        Assert.assertTrue(productCategoriesPage.VerifySuccessfullyAddCategoryMsg());
    }


    @When("click Create Website button")
    public void clickCreateWebsiteButton() {
        StoreDashboardPage storeDashboardPage=new StoreDashboardPage(driver);
        storeDashboardPage.clickCreateWebsiteLink();
    }

    @And("fill out all new website information on new website page")
    public void fillOutAllNewWebsiteInformationOnNewWebsitePage() {
        WebsitePage websitePage=new WebsitePage(driver);
        websitePage.createWebsite();
    }

    @Then("website should be created")
    public void websiteShouldBeCreated() {
        Assert.assertTrue(websitePage.verifySuccess());
    }

    @When("click the website link should be edited and update website information then click save website button")
    public void clickTheWebsiteLinkShouldBeEditedAndUpdateWebsiteInformationThenClickSaveWebsiteButton() {
        websitePage.editWebsite();

    }

    @Then("website should be edited")
    public void websiteShouldBeEdited() {
        Assert.assertTrue(websitePage.verifySuccess());
    }

    @When("click Create Store button")
    public void clickCreateStoreButton() {
        storeDashboardPage.clickCreateStoreLink();
    }

    @And("fill out all new store information on new store page")
    public void fillOutAllNewStoreInformationOnNewStorePage() {
        storePage.createStore();

    }

    @Then("store should be created")
    public void storeShouldBeCreated() {
        Assert.assertTrue(storePage.verifySuccess());
    }

    @When("click the store link should be edited and update store information then click save store button")
    public void clickTheStoreLinkShouldBeEditedAndUpdateStoreInformationThenClickSaveStoreButton() {
        storePage.editStore();

    }

    @Then("store should be edited")
    public void storeShouldBeEdited() {
        Assert.assertTrue(storePage.verifySuccess());

    }

    @When("click Create Store view button")
    public void clickCreateStoreViewButton() {
        storeDashboardPage.clickCreateStoreViewLink();
    }

    @And("fill out all new store view information on new store view page")
    public void fillOutAllNewStoreViewInformationOnNewStoreViewPage() {
        storeViewPage.createStoreView();
    }

    @Then("store view should be created")
    public void storeViewShouldBeCreated() {
        Assert.assertTrue(storeViewPage.storeViewCreatedSuccessfully());
    }

    @When("click the store view link should be edited and update store view information then click save store view button")
    public void clickTheStoreViewLinkShouldBeEditedAndUpdateStoreViewInformationThenClickSaveStoreViewButton() {
        storeViewPage.editStoreView();
    }

    @Then("store view should be edited")
    public void storeViewShouldBeEdited() {
        Assert.assertTrue(storeViewPage.storeViewCreatedSuccessfully());
    }

    @Then("can view All stores")
    public void canViewAllStores() {
        Assert.assertTrue(storeViewPage.viewOrder());
    }
}
