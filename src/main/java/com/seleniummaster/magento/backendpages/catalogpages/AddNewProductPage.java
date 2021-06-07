package com.seleniummaster.magento.backendpages.catalogpages;

import com.seleniummaster.magento.utility.ApplicationConfig;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewProductPage extends TestBasePage {

    WebDriver driver;
    TestUtility utility;
    String ConfigFile = "config.properties";

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

    //create a constructor to initialize the page // page factory


    public AddNewProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

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

        //utility.waitForElementPresent(SelectStatus);
        //SelectStatus.click();
    }

    //Select Visibility Method
//    public void SelectVisibility() {
//        utility.waitForElementPresent(SelectVisibility);
//        SelectVisibility.click();
//    }

    //Click on Save button Method
    public void clickOnSaveButton() {
        utility.waitForElementPresent(ClickSaveButton);
        ClickSaveButton.click();
    }

    //Enter Price Method
//    String Price=ApplicationConfig.readConfigProperties(ConfigFile,"Price1");
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

    public boolean verifySuccess() {
        utility.waitForElementPresent(ConfirmationMessage);
       if (ConfirmationMessage.isDisplayed())
       {
           System.out.printf("Add Product Test Pass");
           return true;
       }
       else
           System.out.printf("Test failed");
       return false;
    }
    public void createNewProduct(String productName){
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

    public void AddProduct() {
        clickOnAddProduct();
        utility.sleep(1);
        clickOnContinue();
        utility.sleep(1);
        EnterProductName();//String
        utility.sleep(1);
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


//String ProductName = ApplicationConfig.readConfigProperties(ConfigFile, "NewProductName");
//    String ProductDescription = ApplicationConfig.readConfigProperties(ConfigFile, "NewProductDescription");
//    String ProductShortDescription = ApplicationConfig.readConfigProperties(ConfigFile, "NewProductShortDescription");
//    String SKU = ApplicationConfig.readConfigProperties(ConfigFile, "SKU");
//    String Weight = ApplicationConfig.readConfigProperties(ConfigFile, "Weight");
//    String Price=ApplicationConfig.readConfigProperties(ConfigFile,"Price");

    }

}
