package com.seleniummaster.magento.backendpages.storepages;

import com.seleniummaster.magento.utility.ApplicationConfig;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManageProductsPage extends TestBasePage {
    WebDriver driver;
    String ConfigFile = "config.properties";
    TestUtility utility;
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

   //Store Manager can add products (@Sofia)

    public ManageProductsPage(WebDriver driver) {
        this.driver = driver;
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

    public void typeProductName(){
        utility.waitForElementPresent(productNameTextField);
        productNameTextField.sendKeys(ProductName);
    }

    public void typeDescription(){
        utility.waitForElementPresent(descriptionTextField);
        descriptionTextField.sendKeys(ProductDescription);
    }
    public void typeShortDescription(){
        utility.waitForElementPresent(shortDescriptionTextField);
        shortDescriptionTextField.sendKeys(ProductShortDescription);

    }
    public void typeSKU(){
        utility.waitForElementPresent(SKUTextField);
        SKUTextField.sendKeys(SKU+System.currentTimeMillis());
    }

    public void typeWeight(){
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

    public void typePrice(){
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

    public boolean VerifySuccessfulMessage(){
        utility.waitForElementPresent(VerifySuccessfullyAddedMessage);
        return VerifySuccessfullyAddedMessage.isDisplayed();

    }


    String ProductName = ApplicationConfig.readConfigProperties(ConfigFile, "NewProductName");
    String ProductDescription = ApplicationConfig.readConfigProperties(ConfigFile, "NewProductDescription");
    String ProductShortDescription = ApplicationConfig.readConfigProperties(ConfigFile, "NewProductShortDescription");
    String SKU = ApplicationConfig.readConfigProperties(ConfigFile, "SKU");
    String Weight = ApplicationConfig.readConfigProperties(ConfigFile, "Weight");
    String Price=ApplicationConfig.readConfigProperties(ConfigFile,"Price");

    public void AddProduct() {
        clickAddProductButton();
        clickContinueButton();
        typeProductName();
        typeDescription();
        typeShortDescription();
        typeSKU();
        typeWeight();
        chooseStatusEnableOption();
        clickSaveAndContinueButton();
        typePrice();
        chooseTaxClassGeneralOption();
        clickSaveButton();
        VerifySuccessfullyAddedMessage.isDisplayed();
    }


    // Store Manager can update products (@Zuhra)

}
