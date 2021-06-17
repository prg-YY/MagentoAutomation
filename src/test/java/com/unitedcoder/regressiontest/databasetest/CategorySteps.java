package com.unitedcoder.regressiontest.databasetest;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.backendpages.BackEndLogin;
import com.seleniummaster.magento.backendpages.catalogpages.CatalogDashboardPage;
import com.seleniummaster.magento.backendpages.catalogpages.RootCategoryPage;
import com.seleniummaster.magento.database.DataAccess;
import com.seleniummaster.magento.database.QueryScript;
import com.seleniummaster.magento.testdata.TestDataHolder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import javax.sql.rowset.CachedRowSet;
import java.sql.Connection;

public class CategorySteps extends TestBasePage {
    RootCategoryPage rootCategoryPage;
    Connection connection;
    @Given("Catalog Manager log in to Catalog Module page")
    public void catalogManagerLogInToCatalogModulePage() {
        rootCategoryPage=new RootCategoryPage();
        driver.get(prop.getProperty("BackendURL"));
        BackEndLogin backEndLogin = new BackEndLogin(driver);
        backEndLogin.backEndLogin(prop.getProperty("catalogManager"), prop.getProperty("password"));
    }
    @When("new Root category should be added")
    public void newRootCategoryShouldBeAdded() {
        String catName=String.format(prop.getProperty("newRootCategory"),System.currentTimeMillis());
        TestDataHolder.setProductCategoryName(catName);
        rootCategoryPage.addNewRootCategory(catName);
        Assert.assertTrue(rootCategoryPage.isAddRootCategoryAddedSuccessfully());
        CatalogDashboardPage dashboardPage=new CatalogDashboardPage(driver);
        dashboardPage.clickLogOutLink();
    }
    @Then("new root category create successfully and exist in the database")
    public void newRootCategoryCreateSuccessfullyAndExistInTheDatabase() {
        DataAccess access=new DataAccess();
        String getRootCategoryQueryScript=String.format(QueryScript.getNewlyAddedRootCategory(),TestDataHolder.getProductCategoryName());
        CachedRowSet cachedRowSet=access.readFromDataBase(connection,getRootCategoryQueryScript);
        System.out.println("The Query Script was Executed for Adding root Category is"+"\n"+getRootCategoryQueryScript);
        Assert.assertTrue(access.getRowCount(cachedRowSet));
    }
}
