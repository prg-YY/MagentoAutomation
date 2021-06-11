package com.seleniummaster.magento.backendpages.storepages;

import com.seleniummaster.magento.utility.ApplicationConfig;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ManageProductsPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    StoreDashboardPage dashboardPage;
    @FindBy(xpath = "(//span[text()='Add Product'])[1]")
    WebElement addProductButton;
    @FindBy(xpath = "//button[@title=\"Continue\"]")
    WebElement continueButton;
    @FindBy(xpath = "//input[@id=\"name\"]")
    WebElement productNameTextField;
    @FindBy(xpath = "//textarea[@id=\"description\"]")
    WebElement descriptionTextField;
    @FindBy(xpath = "//textarea[@id=\"short_description\"]")
    WebElement shortDescriptionTextField;
    @FindBy(xpath = "//input[@id=\"sku\"]")
    WebElement SKUTextField;
    @FindBy(xpath = "//input[@id=\"weight\"]")
    WebElement weightTextField;
    @FindBy(xpath = "//option[text()=\"Enabled\"]")
    WebElement statusDropdownEnableOption;
    @FindBy(xpath = "//select[@id=\"status\"]")
    WebElement statusDropdown;
    @FindBy(xpath = "//input[@id=\"price\"]")
    WebElement priceTextField;
    @FindBy(xpath = "//select[@id=\"tax_class_id\"]")
    WebElement taxClassDropDownList;
    @FindBy(xpath = "//*[@id='tax_class_id']/option[5]\n")
    WebElement taxClassGeneralOption;
    @FindBy(xpath = "//button[@title=\"Save and Continue Edit\"]")
    WebElement saveAndContinueButton;
    @FindBy(xpath = "//button[@title=\"Save\"]")
    WebElement saveButton;
    @FindBy(xpath = "//div[@id=\"messages\"]")
    WebElement VerifySuccessfullyAddedMessage;
//update products
    @FindBy(id = "productGrid_product_filter_name")
    WebElement productNameSearchBox;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;
    @FindBy(xpath = "//div[@class=\"hor-scroll\"]/table/tbody/tr[\"+i+\"]/td[12]/a")
    WebElement editButton;
    @FindBy(xpath="//div[@class=\"hor-scroll\"]/table/tbody/tr")
    List<WebElement> ProductNameList;
    @FindBy(xpath = "//div[@class=\"hor-scroll\"]/table/tbody/tr[\"+i+\"]/td[3]")
    WebElement FondedProductName;
    @FindBy(xpath = "//select[@id=\"country_of_manufacture\"]")
    WebElement CountryOfManufactureDropDownList;
    @FindBy(xpath = "//select[@id=\"country_of_manufacture\"]/option[35]" )
    WebElement MadeInBrazilSelection;
    @FindBy(xpath = "//span[text()='The product has been saved.']")
    WebElement SuccessfulSavedMessage;
// delete products Elements
    @FindBy(xpath = "//*[@id=\"productGrid_table\"]/tbody/tr[1]/td[1]/input")
    WebElement productCheckbox;
    @FindBy(id = "productGrid_massaction-select")
    WebElement actionSelection;
    @FindBy(xpath = "//span[text()='Submit']")
    WebElement submitButton;
    @FindBy(xpath = "//span[text()='Total of 1 record(s) have been deleted.']")
    WebElement deleteSuccessfulMessage;

   //Store Manager can add products (@Sofia)

    public ManageProductsPage() {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }
    public void clickAddProductButton(){
        utility.waitForElementPresent(addProductButton);
        addProductButton.click();
    }
    public void clickContinueButton(){
        utility.waitForElementPresent(continueButton);
        continueButton.click();
    }
    String ProductName=ApplicationConfig.readConfigProperties("NewProductName");
    public void typeProductName(){
        utility.waitForElementPresent(productNameTextField);
        productNameTextField.sendKeys(ProductName);
    }
    public void enterNewProductName(String name){
        utility.waitForElementPresent(productNameTextField);
        productNameTextField.sendKeys(name);
    }
    public void typeDescription(String ProductDescription){
        utility.waitForElementPresent(descriptionTextField);
        descriptionTextField.sendKeys(ProductDescription);
    }
    public void typeShortDescription(String ProductShortDescription){
        utility.waitForElementPresent(shortDescriptionTextField);
        shortDescriptionTextField.sendKeys(ProductShortDescription);
    }
    public void typeSKU(String SKU){
        utility.waitForElementPresent(SKUTextField);
        SKUTextField.sendKeys(SKU+System.currentTimeMillis());
    }
    public void typeWeight(String Weight){
        utility.waitForElementPresent(weightTextField);
        weightTextField.sendKeys(Weight);
    }
    public void chooseStatusEnableOption() {
        utility.waitForElementPresent(statusDropdownEnableOption);
        Select StatusDropdown=new Select(statusDropdown);
        StatusDropdown.selectByValue("1");
    }
    public void clickSaveAndContinueButton(){
        utility.waitForElementPresent(saveAndContinueButton);
        saveAndContinueButton.click();
    }
    public void typePrice(String Price){
        utility.waitForElementPresent(priceTextField);
        priceTextField.sendKeys(Price);
    }
    public void chooseTaxClassGeneralOption() {
        utility.waitForElementPresent(taxClassGeneralOption);
        Select StatusDropdown=new Select(taxClassDropDownList);
        StatusDropdown.selectByValue("6");
    }

    public void clickSaveButton(){
        utility.waitForElementPresent(saveButton);
        saveButton.click();
    }

    public boolean addNewProductSuccessfully(){
        utility.waitForElementPresent(VerifySuccessfullyAddedMessage);
        if (VerifySuccessfullyAddedMessage.isDisplayed()) {
            System.out.println("Test Passed, New Product Added Successfully");
            return true;
        }else System.out.println("Test Failed,Cannot add new product");
        return false;
    }

    public void AddProduct() {
        clickAddProductButton();
        clickContinueButton();
        typeProductName();
        typeDescription(prop.getProperty("NewProductDescription"));
        typeShortDescription(prop.getProperty("NewProductShortDescription"));
        typeSKU(prop.getProperty("SKU"));
        typeWeight(prop.getProperty("Weight"));
        chooseStatusEnableOption();
        clickSaveAndContinueButton();
        typePrice(prop.getProperty("Price"));
        chooseTaxClassGeneralOption();
        clickSaveButton();
        VerifySuccessfullyAddedMessage.isDisplayed();
    }
    public void addNewProduct(String name) {
        dashboardPage=new StoreDashboardPage(driver);
        dashboardPage.goToCreateProductsPage();
        clickContinueButton();
       enterNewProductName(name);
        typeDescription(prop.getProperty("NewProductDescription"));
        typeShortDescription(prop.getProperty("NewProductShortDescription"));
        typeSKU(prop.getProperty("SKU"));
        typeWeight(prop.getProperty("Weight"));
        chooseStatusEnableOption();
        clickSaveAndContinueButton();
        typePrice(prop.getProperty("Price"));
        chooseTaxClassGeneralOption();
        clickSaveButton();
    }

    // Edit Product Method
    public void enterNameToSearchBox(String productName){
        utility.waitForElementPresent(productNameSearchBox);
        productNameSearchBox.clear();
        productNameSearchBox.sendKeys(productName);
    }
    public void clickOnSearchButton(){
        utility.waitForElementPresent(searchButton);
        searchButton.click();
    }
    public void clickOnEditButton(){
        utility.waitForElementPresent(editButton);
        editButton.click();
    }
    public void chooseCountryOfManufacture(){
        utility.waitForElementPresent(MadeInBrazilSelection);
            Select CountryDropdown=new Select(CountryOfManufactureDropDownList);
            CountryDropdown.selectByValue("BR");
    }

    public void defineProductToUpdate(String productName){
        enterNameToSearchBox(productName);
        utility.sleep(1);
        clickOnSearchButton();
        utility.sleep(2);
        clickOnEditButton();
        utility.sleep(2);
    }

    public boolean updateProductSuccessfully(){
        utility.waitForElementPresent(SuccessfulSavedMessage);
        if (SuccessfulSavedMessage.isDisplayed()) {
            Log.info("The product has been saved");
            System.out.println("Test Passed,Update Product successfully");
            return true;
        }else
            Log.info("test failed");
        System.out.println("Test Failed,Update product Test Failed");
        return false;
    }

    public void updateProduct(){
    for(int i=1; i<=ProductNameList.size();i++){
        String productName=FondedProductName.getText();
        if(productName.equals(ProductName)){
            try {
                utility.waitForElementPresent(FondedProductName);
                FondedProductName.click();
            }
            catch (TimeoutException e) {
            }
            chooseCountryOfManufacture();
            clickSaveButton();
            updateProductSuccessfully();
        }
        break;
    }
    }
    //update existing product
    public void updateExistingProduct(String productName){
        dashboardPage=new StoreDashboardPage(driver);
        dashboardPage.goToManageProductsPage();
        defineProductToUpdate(productName);
        chooseCountryOfManufacture();
        clickSaveButton();
        utility.sleep(2);
    }
    //delete product

    public void clickOnProductCheckBox(){
        utility.waitForElementPresent(productCheckbox);
        productCheckbox.click();
    }
    public void selectDeleteFromAction(String value){
        utility.waitForElementPresent(actionSelection);
        Select select=new Select(actionSelection);
        select.selectByValue(value);
    }
    public void clickOnSubmitButton(){
        utility.waitForElementPresent(submitButton);
        submitButton.click();
    }
    public void defineProductToDelete(String productName){
        enterNameToSearchBox(productName);
        utility.sleep(1);
        clickOnSearchButton();
        utility.sleep(2);
        clickOnProductCheckBox();
        utility.sleep(2);
    }
    public boolean deleteProductSuccessfully(){
        utility.waitForElementPresent(deleteSuccessfulMessage);
        if (deleteSuccessfulMessage.isDisplayed()){
            System.out.println("Test Passed, Product deleted successfully");
            return true;
        }else System.out.println("Test Failed, cannot delete product");
        return false;
    }

    public void deleteExistingProduct(String productName){
        dashboardPage=new StoreDashboardPage(driver);
        dashboardPage.goToManageProductsPage();
        utility.sleep(2);
        defineProductToDelete(productName);
        selectDeleteFromAction("delete");
        utility.sleep(2);
        clickOnSubmitButton();
        utility.sleep(2);
        Alert alert=driver.switchTo().alert();
        utility.waitForAlertPresent();
        alert.accept();
        utility.sleep(2);
    }

}
