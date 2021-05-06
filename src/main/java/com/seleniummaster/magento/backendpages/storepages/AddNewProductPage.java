package com.seleniummaster.magento.backendpages.storepages;

import com.seleniummaster.magento.utility.ApplicationConfig;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddNewProductPage extends TestBasePage {
    WebDriver driver;
    String ConfigFile = "config.properties";
    TestUtility utility;
    @FindBy(xpath = "button[@title='Add Product']")
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
//    @FindBy(xpath = "select[@id=\"status\"]/option")
//    List<WebElement> statusDropDownListOptions;
    @FindBy(xpath = "//option[text()=\"Enabled\"]")
    WebElement statusDropdownEnableOption;
    @FindBy(xpath = "//select[@id=\"status\"]")
    WebElement statusDropdown;
    @FindBy(xpath = "input[@id=\"price\"]")
    WebElement priceTextField;
    @FindBy(xpath = "select[@id=\"tax_class_id\"]")
    WebElement taxClassDropDownList;
//    @FindBy(xpath = "select[@id=\"tax_class_id\"]")
//    List<WebElement> taxClassDropDownList;
    @FindBy(xpath = "option[@value=\"6\"]")
    WebElement taxClassGeneralOption;
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

    public void chooseStatusEnableOption() {
        utility.waitForElementPresent(statusDropdownEnableOption);
        Select StatusDropdown=new Select(statusDropdown);
        StatusDropdown.selectByValue("1");
    }

    public void chooseTaxClassGeneralOption() {
        utility.waitForElementPresent(taxClassGeneralOption);
        Select StatusDropdown=new Select(taxClassDropDownList);
        StatusDropdown.selectByValue("6");
    }

    public boolean VerifySuccessfulMessage(){

        utility.waitForElementPresent(VerifySuccessfullyAddedMessage);
       return VerifySuccessfullyAddedMessage.isDisplayed();

    }





//        WebElement findRName = optionSelect.get(7);
//        WebUtility.waitForElementClickable(findRName);
//        findRName.click();
//        Log.info("Option clicked");


//    public void chooseTaxClassOption(){
//     Select TaxClassDropdown=new Select()
//        WebElement statusType=statusDropDownListOptions.get(2);
//        utility.waitForElementPresent(statusType);
//        statusType.click();

//    Select selectDropDown=new Select(dropDown);
//            selectDropDown.selectByValue("used");
//            selectDropDown.selectByVisibleText(DropDownContent.Refurbished.name());

//    WebElement dropDown=driver.findElement(By.id("condition"));
//        utility.waitForElementPresent(dropDown);
//    Select selectDropDown=new Select(dropDown);
//        selectDropDown.selectByValue("used");
    String ProductName = ApplicationConfig.readConfigProperties(ConfigFile, "NewProductName");
    String ProductDescription = ApplicationConfig.readConfigProperties(ConfigFile, "NewProductDescription");
    String ProductShortDescription = ApplicationConfig.readConfigProperties(ConfigFile, "NewProductShortDescription");
    String SKU = ApplicationConfig.readConfigProperties(ConfigFile, "SKU");
    String Weight = ApplicationConfig.readConfigProperties(ConfigFile, "Weight");
    String Price=ApplicationConfig.readConfigProperties(ConfigFile,"Price");

    public void AddProduct() {

        utility.waitForElementPresent(addProductButton);
        try{
            addProductButton.click();
        } catch (TimeoutException e){
            e.printStackTrace();
        }
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].click();", addProductButton);

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
        chooseStatusEnableOption();
        utility.waitForElementPresent(saveAndContinueButton);
        saveAndContinueButton.click();
        utility.waitForElementPresent(priceTextField);
        priceTextField.sendKeys(Price);
//        utility.waitForElementPresent(taxClassDropDownList);
//        taxClassDropDownList.
        utility.waitForElementPresent(saveAndContinueButton);
        saveAndContinueButton.click();
        utility.waitForElementPresent(saveButton);
        saveButton.click();
        VerifySuccessfullyAddedMessage.isDisplayed();

    }

}

