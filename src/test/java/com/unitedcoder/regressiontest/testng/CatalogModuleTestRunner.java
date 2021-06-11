package com.unitedcoder.regressiontest.testng;

import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.catalogpages.*;
import com.seleniummaster.magento.database.ConnectionManager;
import com.seleniummaster.magento.testdata.TestDataHolder;
import com.seleniummaster.magento.utility.TestBasePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class CatalogModuleTestRunner extends TestBasePage {
    AddRootCategoriesPage rootCategoriesPage;
    ConnectionManager connectionManager=new ConnectionManager();

    @BeforeClass
    public void setUp() {
        setUpBrowser();
        driver.get(prop.getProperty("BackendURL"));
        BackEndLogin backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("catalogManager"), prop.getProperty("password"));
    }
    @Test(description = "Catalog Manager can add products",priority = 1)//Leila
    public void addProduct() {
        AddNewProductPage productPage = new AddNewProductPage(driver);
        String newProductName=String.format(prop.getProperty("productName"),System.currentTimeMillis());
        productPage.createNewProduct(newProductName);
        TestDataHolder.setNewProductName(newProductName);
        Assert.assertTrue(productPage.AddProductSuccessfully());
    }

    @Test(description = "Catalog Manager can edit products",priority = 2)//Melika
    public void editProduct() {
        EditExistingProductPage productPage = new EditExistingProductPage(driver);
        productPage.editExistingProduct(TestDataHolder.getNewProductName());
        Assert.assertTrue(productPage.editProductSuccessfully());
    }

    @Test(description = "Catalog Manager can delete products",priority = 3)//Dilnur
    public void deleteProduct() {
        EditExistingProductPage productPage = new EditExistingProductPage(driver);
        productPage.deleteExistingProduct(TestDataHolder.getNewProductName());
        Assert.assertTrue(productPage.deleteProductSuccessfully());
    }

    @Test(description = "1-Catalog Manager can add root categories ",priority = 4)//Abdukahar
    public void addRootCategory() {
        Random ran=new Random();
        int r=ran.nextInt(100);
        String catName=String.format(prop.getProperty("newRootCategory"),r);
        TestDataHolder.setProductCategoryName(catName);
        rootCategoriesPage = new AddRootCategoriesPage(driver);
        rootCategoriesPage.addNewRootCategory(catName);
        Assert.assertTrue(rootCategoriesPage.isAddRootCategoryAddedSuccessfully());
    }

    @Test(description = "2-Catalog Manager can edit root categories",priority = 5)//Yusuf
    public void editCategoriesTest() {
        EditCategoriesPage categoriesPage = new EditCategoriesPage();
        categoriesPage.editAnExistingCategory(TestDataHolder.getProductCategoryName());
        Assert.assertTrue(categoriesPage.editRootCategorySuccessfully());
    }

    @Test(description = "3-Catalog Manager can delete root categories",priority = 6)//Sofia
    public void deleteRootCategories() {
        DeleteRootCategoriesPage deleteRootCategoriesPage = new DeleteRootCategoriesPage(driver);
        deleteRootCategoriesPage.deleteAnExistingRootCategory(TestDataHolder.getProductCategoryName());
        Assert.assertTrue(deleteRootCategoriesPage.deleteRootCategorySuccessfully());
    }

    @Test(description = "4-Catalog Manager can add sub categories",priority = 7)//zuhra
    public void addSubCategories() {
        AddSubCategoryPage subCategoryPage = new AddSubCategoryPage(driver);
        Random ran=new Random();
        int r=ran.nextInt(1000);
        String subCategoryName=String.format(prop.getProperty("subCatName"),r);
        TestDataHolder.setSubCategoryName(subCategoryName);
        subCategoryPage.addNewSubCategory(subCategoryName);
        Assert.assertTrue(subCategoryPage.isAddSubCategorySuccessMassage());
    }

    @Test(description = "Catalog Manager can edit sub categories ",priority = 8)//Kembernisa
    public void editSubCategories() {
        EditSubCategoryPage editSubCategoryPage = new EditSubCategoryPage(driver);
        editSubCategoryPage.editExistingSubCategories(TestDataHolder.getSubCategoryName());
        Assert.assertTrue(editSubCategoryPage.subCategoryEditedSuccessfully());
    }

    @Test(description = "Catalog Manager can delete sub categories",priority = 9)//ayper
    public void deleteSubcategory() {
        DeleteSubCategoryPage deleteSubCategoryPage = new DeleteSubCategoryPage(driver);
        deleteSubCategoryPage.deleteSubCategory(TestDataHolder.getSubCategoryName());
        Assert.assertTrue(deleteSubCategoryPage.deleteSubCategorySuccessfully());
    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }
}