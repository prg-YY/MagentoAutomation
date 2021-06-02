package com.seleniummaster.magento.backendpages.storepages;

import com.seleniummaster.magento.utility.ApplicationConfig;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
    String ProductName=ApplicationConfig.readConfigProperties("NewProductName");

    public void typeProductName(){
        utility.waitForElementPresent(productNameTextField);
        productNameTextField.sendKeys(ProductName);
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

    public boolean VerifySuccessfulMessage(){
        utility.waitForElementPresent(VerifySuccessfullyAddedMessage);
        return VerifySuccessfullyAddedMessage.isDisplayed();

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


    // Store Manager can update products

    @FindBy(xpath = "//div[@class=\"hor-scroll\"]/table/tbody/tr[\"+i+\"]/td[12]/a")
    WebElement EditButton;
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


    public void chooseCountryOfManufacture(){
        utility.waitForElementPresent(MadeInBrazilSelection);
            Select CountryDropdown=new Select(CountryOfManufactureDropDownList);
            CountryDropdown.selectByValue("BR");
    }

    public boolean VerifySuccessfulUpdated(){
        utility.waitForElementPresent(SuccessfulSavedMessage);
        if (SuccessfulSavedMessage.isDisplayed()) {
            Log.info("The product has been saved");
            return true;
        }else
            Log.info("test failed");
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
            VerifySuccessfulUpdated();

        }
        break;

    }

    }
}
