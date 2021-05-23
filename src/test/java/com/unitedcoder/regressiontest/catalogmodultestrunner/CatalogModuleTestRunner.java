package com.unitedcoder.regressiontest.catalogmodultestrunner;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.catalogpages.*;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CatalogModuleTestRunner extends TestBasePage {
    AddRootCategoriesPage rootCategoriesPage;
    TestUtility utility=new TestUtility(driver);


    @BeforeClass
    public void setUp() {
        setUpBrowser();
        Log.info("Add new customer started");
        driver.get(prop.getProperty("BackendURL"));
        BackEndLogin backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("catalogManager"), prop.getProperty("password"));
    }
@Test(description = "1-Catalog Manager can add root categories -AbdulKahHar")
    public void addRootCategory(){
        rootCategoriesPage=new AddRootCategoriesPage(driver);
        rootCategoriesPage.addNewRootCategory();
        Assert.assertTrue(rootCategoriesPage.isAddRootCategorySuccessMassage());

    }
    @Test(description = "2-Catalog Manager can edit root categories -yusuf")
    public void editCategoriesTest(){
        EditCategoriesPage categoriesPage=new EditCategoriesPage();
        categoriesPage.editCategoriesPage();
        Assert.assertTrue(categoriesPage.displaySuccessMessage());
    }
    @Test(description = "3-Catalog Manager can delete root categories -SoFiYa")
    public void deleteRootCategories(){
        DeleteRootCategoriesPage deleteRootCategoriesPage=new DeleteRootCategoriesPage(driver);
        deleteRootCategoriesPage.deleteRootCategory();
        Assert.assertTrue(deleteRootCategoriesPage.VerifySuccessfulMsgDisplay());


    }
    @Test(description = "4-Catalog Manager can add sub categories-ZuHre ")
    public void addSubCategories(){
        AddSubCategoryPage subCategoryPage=new AddSubCategoryPage(driver);
        subCategoryPage.addSubCategory();
        Assert.assertTrue(subCategoryPage.isAddSubCategorySuccessMassage());
    }
    @Test(description = "5-Catalog Manager can edit sub categories-KaMer ")
    public void editSubCategories(){
        EditSubCategoryPage editSubCategoryPage=new EditSubCategoryPage(driver);
        editSubCategoryPage.editSubCategories();
        Assert.assertTrue(editSubCategoryPage.isEditSubCategorySuccessMassage());


    }
    @Test(description = "6-Catalog Manager can delete sub categories-AyPer")
    public void deleteSubcategory(){
      DeleteSubCategoryPage deleteSubCategoryPage=new DeleteSubCategoryPage(driver);
      deleteSubCategoryPage.deleteSub();
      Assert.assertTrue(deleteSubCategoryPage.isConfirmationDisplayed());

    }
    @Test(description = "7-Catalog Manager can add products-LeiLa")
    public void addProduct(){
        AddNewProductPage productPage=new AddNewProductPage(driver);
        productPage.AddProduct();
        Assert.assertTrue(productPage.verifySuccess());

    }
    @Test(description = "8-Catalog Manager can edit products - MeLiKe")
    public void editProduct(){
        EditExistingProductPage productPage=new EditExistingProductPage(driver);
        productPage.editExistingProduct();
        Assert.assertTrue(productPage.verifySuccessfulMessage());

    }
    @Test(description = "9-Catalog Manager can delete products -DilNur")
    public void deleteProduct(){
        DeleteProductPage deleteProductPage=new DeleteProductPage(driver);
        deleteProductPage.deleteProduct();
        Assert.assertTrue(deleteProductPage.verifySuccessMessage());


    }
    @AfterClass
    public void tearDown(){
    closeBrowser();
    }
}