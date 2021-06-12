package com.seleniummaster.magento.backendpages.catalogpages;

import com.seleniummaster.magento.utility.ApplicationConfig;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends TestBasePage {
    TestUtility utility;
    WebDriver driver;
    String ConfigFile = "config.properties";
    CatalogDashboardPage catalogDashboardPage;

    public ProductsPage() {
        this.driver=TestBasePage.driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }
//Add products Elements
    @FindBy(xpath = "//div[@class='content-header']")//2 Elements
            WebElement ManageProductsPage;
    @FindBy(xpath = "(//span[text()='Add Product'])[1]")//2 Elements
    WebElement AddProductButton;
    @FindBy(css = "button[class='scalable save']")//correct
    WebElement ContinueButton;
    @FindBy(css = "input[name='product[name]']")//correct
    WebElement ProductNameTextBox;
    @FindBy(xpath = "//textarea[@id=\"description\"]")//correct
    WebElement DescriptionTextBox;
    @FindBy(xpath = "//textarea[@id=\"short_description\"]")//correct
    WebElement ShortDescriptionTextBox;
    @FindBy(css = "input[id=\"sku\"][type=\"text\"]")//correct
    WebElement SkuTextBox;
    @FindBy(css = "input[id=\"weight\"][name=\"product[weight]\"]")//correct
    WebElement WeightTextBox;
    @FindBy(xpath = "//select[@id=\"status\"]")//correct
    WebElement SelectStatus;
    @FindBy(xpath = "//select[@id=\"status\"]")
    WebElement statusDropdown;
    @FindBy(xpath = "//select[@id=\"visibility\"]")//correct
    WebElement SelectVisibility;
    @FindBy(css = "button[class='scalable save'][title='Save']")//correct
    WebElement ClickSaveButton;
    @FindBy(xpath = "//input[@id=\"price\"and@type=\"text\"]")
    WebElement PriceTextBox;
    @FindBy(xpath = "//*[@id=\"tax_class_id\"]/option[5]")
    WebElement SelectTaxClass;
    @FindBy(xpath = "//select[@id=\"tax_class_id\"]")
    WebElement taxClassDropDownList;
    @FindBy(css = "button[class='scalable save'][title='Save']")
    WebElement PressSaveButton;//not sure
    @FindBy(xpath = "//div[@id=\"messages\"]")//not sure
    WebElement ConfirmationMessage;
//Update Products Elements
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

    public void clickOnAddProduct() {
        utility.waitForElementPresent(AddProductButton);
        AddProductButton.click();
    }
    public void clickOnContinue() {
        utility.waitForElementPresent(ContinueButton);
        ContinueButton.click();
    }
    //Enter Product name Method
    String ProductName = ApplicationConfig.readConfigProperties(ConfigFile, "FirstName");
    public void EnterProductName() {
        utility.waitForElementPresent(ProductNameTextBox);
        ProductNameTextBox.sendKeys(ProductName);
    }
    public void EnterProductName1(String productName) {
        utility.waitForElementPresent(ProductNameTextBox);
        ProductNameTextBox.sendKeys(productName);
    }
    //Enter Description Method
    String ProductDescription = ApplicationConfig.readConfigProperties(ConfigFile, "Description");
    public void EnterDescription() {
        utility.waitForElementPresent(DescriptionTextBox);
        DescriptionTextBox.sendKeys(ProductDescription);
    }
    //Enter Short Description  Method
    String ProductShortDescription = ApplicationConfig.readConfigProperties(ConfigFile, "Description");

    public void EnterShortDescription() {
        utility.waitForElementPresent(ShortDescriptionTextBox);
        ShortDescriptionTextBox.sendKeys(ProductShortDescription);
    }
    //Enter SKU Method
    String SKU = ApplicationConfig.readConfigProperties(ConfigFile, "SKU");
    public void EnterSKU() {
        utility.waitForElementPresent(SkuTextBox);
        SkuTextBox.sendKeys(SKU+System.currentTimeMillis());
    }
    //Enter Weight Method
    String Weight = ApplicationConfig.readConfigProperties(ConfigFile, "Weight");
    public void EnterWeight() {
        utility.waitForElementPresent(WeightTextBox);
        WeightTextBox.sendKeys(Weight);
    }
    //Select Status Method
    public void SelectStatus() {
        utility.waitForElementPresent(SelectStatus);
        Select StatusDropdown = new Select(statusDropdown);
        StatusDropdown.selectByValue("1");
    }
    //Click on Save button Method
    public void clickOnSaveButton() {
        utility.waitForElementPresent(ClickSaveButton);
        ClickSaveButton.click();
    }
    public void EnterPrice() {
        utility.waitForElementPresent(PriceTextBox);
        PriceTextBox.sendKeys(prop.getProperty("Price"));
    }
    //Enter Tax Class Method
    public void SelectTaxClass() {
        //utility.waitForElementPresent(SelectTaxClass);
        //SelectTaxClass.click();
        utility.waitForElementPresent(SelectTaxClass);
        Select TaxDropdown = new Select(taxClassDropDownList);
        TaxDropdown.selectByValue("6");
    }
    //Click on Save button Method
    public void setPressSaveButton() {
        utility.waitForElementPresent(PressSaveButton);
        PressSaveButton.click();
    }
    public boolean AddProductSuccessfully() {
        utility.waitForElementPresent(ConfirmationMessage);
        if (ConfirmationMessage.isDisplayed())
        {
            System.out.println("Test Pass,New Product Added Successfully");
            return true;
        }
        else
            System.out.println("Test failed,cannot add new product");
        return false;
    }
    public void createNewProduct(String productName) {
        clickOnAddProduct();
        utility.sleep(1);
        clickOnContinue();
        utility.sleep(1);
        EnterProductName1(productName);
        EnterDescription();//String
        utility.sleep(1);
        EnterShortDescription();//String
        utility.sleep(1);
        EnterSKU();//String
        utility.sleep(1);
        EnterWeight();//String
        utility.sleep(1);
        SelectStatus();
        utility.sleep(1);
        //SelectVisibility();
        clickOnSaveButton();
        utility.sleep(1);
        EnterPrice();
        utility.sleep(1);
        SelectTaxClass();
        utility.sleep(1);
        setPressSaveButton();
        utility.sleep(1);
    }

// Update Product Method
public void clickPriceLink() {
    utility.waitForElementPresent(pricesLink);
    pricesLink.click();
}
    public void enterSpecialPrice() {
        utility.waitForElementPresent(specialPriceTextBoxField);
        specialPriceTextBoxField.clear();
        specialPriceTextBoxField.sendKeys(prop.getProperty("Price1"));
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
