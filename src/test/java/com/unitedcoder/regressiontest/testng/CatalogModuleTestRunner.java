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
    RootCategoryPage rootCategoryPage;
    SubCategoryPage subCategoryPage;
    ConnectionManager connectionManager=new ConnectionManager();
    ProductsPage productsPage;

    @BeforeClass
    public void setUp() {
        setUpBrowser();
        driver.get(prop.getProperty("BackendURL"));
        BackEndLogin backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("catalogManager"), prop.getProperty("password"));
    }
    @Test(description = "Catalog Manager can add products",priority = 1)//Leila
    public void addProduct() {
        productsPage = new ProductsPage();
        String newProductName=String.format(prop.getProperty("productName"),System.currentTimeMillis());
        productsPage.createNewProduct(newProductName);
        TestDataHolder.setNewProductName(newProductName);
        Assert.assertTrue(productsPage.AddProductSuccessfully());
    }

    @Test(description = "Catalog Manager can edit products",priority = 2)//Melika
    public void editProduct() {
        productsPage = new ProductsPage();
        productsPage.editExistingProduct(TestDataHolder.getNewProductName());
        Assert.assertTrue(productsPage.editProductSuccessfully());
    }

    @Test(description = "Catalog Manager can delete products",priority = 3)//Dilnur
    public void deleteProduct() {
        productsPage = new ProductsPage();
        productsPage.deleteExistingProduct(TestDataHolder.getNewProductName());
        Assert.assertTrue(productsPage.deleteProductSuccessfully());
    }

    @Test(description = "1-Catalog Manager can add root categories ",priority = 4)//Abdukahar
    public void addRootCategory() {
        Random ran=new Random();
        int r=ran.nextInt(100);
        String catName=String.format(prop.getProperty("newRootCategory"),r);
        TestDataHolder.setProductCategoryName(catName);
        rootCategoryPage=new RootCategoryPage();
        rootCategoryPage.addNewRootCategory(catName);
        Assert.assertTrue(rootCategoryPage.isAddRootCategoryAddedSuccessfully());
    }

    @Test(description = "2-Catalog Manager can edit root categories",priority = 5)//Yusuf
    public void editCategoriesTest() {
        rootCategoryPage=new RootCategoryPage();
        rootCategoryPage.editAnExistingCategory(TestDataHolder.getProductCategoryName());
        Assert.assertTrue(rootCategoryPage.editRootCategorySuccessfully());
    }

    @Test(description = "3-Catalog Manager can delete root categories",priority = 6)//Sofia
    public void deleteRootCategories() {
        rootCategoryPage=new RootCategoryPage();
        rootCategoryPage.deleteAnExistingRootCategory(TestDataHolder.getProductCategoryName());
        Assert.assertTrue(rootCategoryPage.deleteRootCategorySuccessfully());
    }

    @Test(description = "4-Catalog Manager can add sub categories",priority = 7)//zuhra
    public void addSubCategories() {
        subCategoryPage = new SubCategoryPage();
        Random ran=new Random();
        int r=ran.nextInt(1000);
        String subCategoryName=String.format(prop.getProperty("subCatName"),r);
        TestDataHolder.setSubCategoryName(subCategoryName);
        subCategoryPage.addNewSubCategory(subCategoryName);
        Assert.assertTrue(subCategoryPage.isAddSubCategorySuccessMassage());
    }

    @Test(description = "Catalog Manager can edit sub categories ",priority = 8)//Kembernisa
    public void editSubCategories() {
        subCategoryPage = new SubCategoryPage();
        subCategoryPage.editExistingSubCategories(TestDataHolder.getSubCategoryName());
        Assert.assertTrue(subCategoryPage.subCategoryEditedSuccessfully());
    }

    @Test(description = "Catalog Manager can delete sub categories",priority = 9)//ayper
    public void deleteSubcategory() {
        subCategoryPage = new SubCategoryPage();
        subCategoryPage.deleteSubCategory(TestDataHolder.getSubCategoryName());
        Assert.assertTrue(subCategoryPage.deleteSubCategorySuccessfully());
    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }
}