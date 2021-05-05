package com.seleniummaster.magento.backendpages.storepages;

import com.seleniummaster.magento.utility.ApplicationConfig;
import com.seleniummaster.magento.utility.TestUtility;
import io.cucumber.java.bs.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.security.cert.X509Certificate;
import java.util.List;

public class AddNewProductPage {
    WebDriver driver;
    String ConfigFile = "config.properties";
    TestUtility utility;
    @FindBy(xpath = "button[@title=\"Add Product\"]")
    WebElement addProductButton;
    @FindBy(xpath = "button[@title=\"Continue\"]")
    WebElement continueButton;
    @FindBy(xpath = "input[@id=\"name\"]")
    WebElement productNameTextField;
    @FindBy(xpath = "textarea[@id=\"description\"]")
    WebElement descriptionTextField;
    @FindBy(xpath = "textarea[@id=\"short_description\"]")
    WebElement shortDescriptionTextField;
    @FindBy(xpath = "input[@id=\"sku\"]")
    WebElement SKUTextField;
    @FindBy(xpath = "input[@id=\"weight\"]")
    WebElement weightTextField;
    @FindBy(xpath = "select[@id=\"status\"]/option")
    List<WebElement> statusDropDownListOptions;
    @FindBy(xpath = "input[@id=\"price\"]")
    WebElement priceTextField;
    @FindBy(xpath = "select[@id=\"tax_class_id\"]")
    WebElement taxClassDropDownList;
    @FindBy(xpath = "button[@title=\"Save and Continue Edit\"]")
    WebElement saveAndContinueButton;
    @FindBy(xpath = "button[@title=\"Save\"]")
    WebElement saveButton;
    @FindBy(xpath = "div[@id=\"messages\"]")
    WebElement VerifySuccessfullyAddedMessage;

    public AddNewProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

//    public void selectOption(){
//        utility.waitForElementPresent(statusDropDownList);
//
//        Select viewDroplist = new Select(driver.s);
//
//        viewDroplist.selectByValue("200");
//
//    }

    String ProductName = ApplicationConfig.readConfigProperties(ConfigFile, "NewProductName");
    String ProductDescription = ApplicationConfig.readConfigProperties(ConfigFile, "NewProductDescription");
    String ProductShortDescription = ApplicationConfig.readConfigProperties(ConfigFile, "NewProductShortDescription");
    String SKU = ApplicationConfig.readConfigProperties(ConfigFile, "SKU");
    String Weight = ApplicationConfig.readConfigProperties(ConfigFile, "Weight");

    public void AddProduct() {
        utility.waitForElementPresent(addProductButton);
        addProductButton.click();
        utility.waitForElementPresent(continueButton);
        continueButton.click();
        utility.waitForElementPresent(productNameTextField);
        productNameTextField.sendKeys(ProductName);
        utility.waitForElementPresent(descriptionTextField);
        descriptionTextField.sendKeys(ProductDescription);
        utility.waitForElementPresent(shortDescriptionTextField);
        shortDescriptionTextField.sendKeys(ProductShortDescription);
        utility.waitForElementPresent(SKUTextField);
        SKUTextField.sendKeys(SKU);
        utility.waitForElementPresent(weightTextField);
        weightTextField.sendKeys(Weight);
//        utility.waitForElementPresent(statusDropDownList);

    }

}

