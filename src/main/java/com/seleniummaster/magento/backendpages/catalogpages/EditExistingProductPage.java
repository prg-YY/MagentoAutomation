package com.seleniummaster.magento.backendpages.catalogpages;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditExistingProductPage extends TestBasePage {

    WebDriver driver;
    TestUtility utility;
    CatalogDashboardPage catalogDashboardPage;

    //select the existing product and click
    @FindBy(xpath = "//*[@id=\"productGrid_table\"]/tbody/tr[1]/td[3]")
    WebElement selectProduct;
    //click the prices link
    @FindBy(xpath = "//span[text()='Prices']")
    WebElement pricesLink;
    //enter number in the special price Field
    @FindBy(css = "#special_price")
    WebElement specialPriceTextBoxField;
    //click the save button
    @FindBy(xpath = "//*[@title=\"Save\"]")
    WebElement saveButton;
    //verify the edit saved message
    @FindBy(xpath = "//span[text()='The product has been saved.']")
    WebElement editSuccessMessage;
// Edit product Elements
    @FindBy(id = "productGrid_product_filter_name")
    WebElement productNameSearchBox;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"productGrid_table\"]/tbody/tr[1]/td[12]/a")
    WebElement productEditButton;
//delete product
    @FindBy(xpath = "//*[@id=\"productGrid_table\"]/tbody/tr[1]/td/input")
    WebElement productCheckBox;
    @FindBy(id = "productGrid_massaction-select")
    WebElement actionDropDownList;
    @FindBy(xpath = "//span[text()='Submit']")
    WebElement submitButton;
    @FindBy(xpath = "//span[text()='Total of 1 record(s) have been deleted.']")
    WebElement deleteSuccessMessage;

    public EditExistingProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

    public void clickSelectProduct() {
        utility.waitForElementPresent(selectProduct);
        selectProduct.click();
    }

    //click the prices link
    public void clickPriceLink() {
        utility.waitForElementPresent(pricesLink);
        pricesLink.click();
    }

    //enter price in the special price field
    public void enterSpecialPrice() {
        utility.waitForElementPresent(specialPriceTextBoxField);
        specialPriceTextBoxField.clear();
        specialPriceTextBoxField.sendKeys(prop.getProperty("Price1"));

        //click the save button
    }

    public void clickSaveButton() {
        utility.waitForElementPresent(saveButton);
        saveButton.click();

    }
    public void enterProductNameToSearchBox(String productName){
        utility.waitForElementPresent(productNameSearchBox);
        productNameSearchBox.clear();
        productNameSearchBox.sendKeys(productName);
    }
    public void clickSearchButton(){
        utility.waitForElementPresent(searchButton);
        searchButton.click();
    }
    public void clickOnEditButton(){
        utility.waitForElementPresent(productEditButton);
        productEditButton.click();
    }
    public void clickOnProductCheckBox(){
        utility.waitForElementPresent(productCheckBox);
        productCheckBox.click();
    }
    public void selectDeleteFromAction(){
        utility.waitForElementPresent(actionDropDownList);
        Select select=new Select(actionDropDownList);
        select.selectByValue("delete");
    }
    public void clickOnSubmitButton(){
        utility.waitForElementPresent(submitButton);
        submitButton.click();
        utility.sleep(2);
        Alert alert=driver.switchTo().alert();
        utility.waitForAlertPresent();
        alert.accept();
    }

    public boolean deleteProductSuccessfully(){
        utility.waitForElementPresent(deleteSuccessMessage);
        if (deleteSuccessMessage.isDisplayed()){
            System.out.println("Test Passed , Product deleted successfully");
            return true;
        }else System.out.println("Test Failed. cannot delete product");
        return false;
    }


    public boolean editProductSuccessfully() {
        utility.waitForElementPresent(editSuccessMessage);
        if (editSuccessMessage.isDisplayed()){
            System.out.println("Test Passed, Edit Product Successfully");
            return true;
        }else System.out.println("Test Failed, cannot edit product");
        return false;
    }

    public void defineProductForEdit(String productName){
        enterProductNameToSearchBox(productName);
        clickSearchButton();
        utility.sleep(3);
        clickOnEditButton();
    }
    public void defineProductForDelete(String productName){
        enterProductNameToSearchBox(productName);
        clickSearchButton();
        utility.sleep(2);
        clickOnProductCheckBox();
    }

    public void editExistingProduct(String productName) {
        catalogDashboardPage = new CatalogDashboardPage(driver);
        catalogDashboardPage.clickCatalogLink();
        catalogDashboardPage.clickManageProduct();
        utility.sleep(2);
        defineProductForEdit(productName);
        utility.sleep(1);
        clickPriceLink();
        utility.sleep(1);
        enterSpecialPrice();
        utility.sleep(1);
        clickSaveButton();
        utility.sleep(1);
    }

    public void deleteExistingProduct(String productName) {
        catalogDashboardPage = new CatalogDashboardPage(driver);
        catalogDashboardPage.clickCatalogLink();
        catalogDashboardPage.clickManageProduct();
        utility.sleep(2);
        defineProductForDelete(productName);
        utility.sleep(1);
        selectDeleteFromAction();
        utility.sleep(2);
        clickOnSubmitButton();
        utility.sleep(2);
    }


}



