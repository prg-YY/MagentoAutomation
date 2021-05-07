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
    //span[text()="Add Product"]
    //button[@title='Add Product']
    @FindBy(xpath = "div[@class=\"content-header\"]/table/tbody/tr/td[2]/button/span")
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

    public void clickContinueButton(){
        utility.waitForElementPresent(continueButton);
        continueButton.click();
    }

    public void clickaddProductButton(){
        utility.waitForElementPresent(addProductButton);
        try{
            addProductButton.click();
        } catch (TimeoutException e){
            e.printStackTrace();
        }
    }
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].click();", addProductButton);

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
        SKUTextField.sendKeys(SKU);
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
        clickContinueButton();
        clickaddProductButton();
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


//    public void selectOption(){
//        utility.waitForElementPresent(statusDropDownList);
//
//        Select viewDroplist = new Select(driver.s);
//
//        viewDroplist.selectByValue("200");
//
//    }