package com.seleniummaster.magento.backendpages.catalogpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogDashboardPage extends TestBasePage {

    WebDriver driver;
    TestUtility utility;


    @FindBy(xpath = "//span[text()='Catalog']")
    WebElement catalogLink;
    @FindBy(xpath = "//span[text()='Manage Products']")
    WebElement manageProduct;
    @FindBy(xpath = "//span[text()='Manage Categories']")
    WebElement manageCategories;
    @FindBy(css = "button[title='Add Product'][type='button']")
    WebElement addProductLink;
    @FindBy(css = "button[title='Reset Filter'][type='button']")
    WebElement resetFilterLink;
    @FindBy(css = "button[title='Search'][type='button']")
    WebElement searchLink;
    @FindBy(css = "button[title='Submit'][type='button']")
    WebElement submitLink;
    @FindBy(css = "input[name='product'][type='checkbox']")
    WebElement checkBoxProduct;
    @FindBy(css = "select[name='store_switcher'][id='store_switcher']")
    WebElement chooseStoreViewDropDownList;
    @FindBy(xpath = "//*[@class=\"link-logout\"]")
    WebElement logOutLink;

    public CatalogDashboardPage(WebDriver driver) {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

    public void clickCatalogLink() {
        utility.waitForElementPresent(catalogLink);
        catalogLink.click();
        Log.info("Catalog link clicked");
    }
    public void clickManageProduct() {
        utility.waitForElementPresent(manageProduct);
        manageProduct.click();
        Log.info("ManageProduct link clicked");
    }

    public void clickManageCategories() {
        utility.waitForElementPresent(manageCategories);
        manageCategories.click();
        Log.info("ManageCategories link clicked");
    }

    public void clickAddProductLink() {
        utility.waitForElementPresent(addProductLink);
        addProductLink.click();
        Log.info("AddProduct link clicked");
    }

    public void clickResetFilterLink() {
        utility.waitForElementPresent(resetFilterLink);
        resetFilterLink.click();
        Log.info("ResetFilter link clicked");
    }

    public void clickSearchLink() {
        utility.waitForElementPresent(searchLink);
        searchLink.click();
        Log.info("Search link clicked");
    }

    public void clickSubmitLink() {
        utility.waitForElementPresent(submitLink);
        submitLink.click();
        Log.info("Submit link clicked");

    }

    public void clickCheckBoxProduct() {
        utility.waitForElementPresent(checkBoxProduct);
        checkBoxProduct.click();
        Log.info("CheckBoxProduct link clicked");
    }

    public void clickChooseStoreViewDropDownList() {
        utility.waitForElementPresent(chooseStoreViewDropDownList);
        chooseStoreViewDropDownList.click();
        Log.info("Choose Store View DropDown List  clicked");
    }

    public void clickLogOutLink() {
        utility.waitForElementPresent(logOutLink);
        logOutLink.click();
        Log.info("logOut Link clicked");
    }

}
