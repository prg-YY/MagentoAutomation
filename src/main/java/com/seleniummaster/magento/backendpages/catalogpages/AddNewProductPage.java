package com.seleniummaster.magento.backendpages.catalogpages;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewProductPage extends TestBasePage {

    WebDriver driver;
    TestUtility utility;
    @FindBy(xpath = "//div[@class='content-header']")//2 Elements
    WebElement ManageProductsPage;

    @FindBy(xpath = "(//span[text()='Manage Categories'])[1]")//2 Elements
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

    @FindBy(xpath = "//select[@id=\"visibility\"]")//correct
    WebElement SelectVisibility;

    @FindBy(css = "button[class='scalable save'][title='Save']")//correct
    WebElement ClickSaveButton;

    @FindBy(xpath = "//input[@id=\"price\"and@type=\"text\"]")
    WebElement PriceTextBox;

    @FindBy(xpath = "//select[@id=\"tax_class_id\"]")
    WebElement SelectTaxClass;

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
    public void EnterProductName(String Name) {
        utility.waitForElementPresent(ProductNameTextBox);
        ProductNameTextBox.sendKeys(Name);
    }

    //Enter Description Method
    public void EnterDescription(String Description) {
        utility.waitForElementPresent(DescriptionTextBox);
        DescriptionTextBox.sendKeys(Description);
    }

    //Enter Short Description  Method
    public void EnterShortDescription(String ShortDescription) {
        utility.waitForElementPresent(DescriptionTextBox);
        DescriptionTextBox.sendKeys(ShortDescription);
    }

    //Enter SKU Method
    public void EnterSKU(String SKU) {
        utility.waitForElementPresent(SkuTextBox);
        DescriptionTextBox.sendKeys(SKU);
    }

    //Enter Weight Method
    public void EnterWeight(String Weight) {
        utility.waitForElementPresent(WeightTextBox);
        DescriptionTextBox.sendKeys(Weight);
    }

    //Select Status Method
    public void SelectStatus() {
        utility.waitForElementPresent(SelectStatus);
        SelectStatus.click();
    }

    //Select Visibility Method
    public void SelectVisibility() {
        utility.waitForElementPresent(SelectVisibility);
        SelectVisibility.click();
    }

    //Click on Save button Method
    public void clickOnSaveButton() {
        utility.waitForElementPresent(ClickSaveButton);
        ClickSaveButton.click();
    }

    //Enter Price Method
    public void EnterPrice(Integer Price) {
        utility.waitForElementPresent(PriceTextBox);
        PriceTextBox.sendKeys();
    }

    //Enter Tax Class Method
    public void SelectTaxClass() {
        utility.waitForElementPresent(SelectTaxClass);
        SelectTaxClass.click();
    }

    //Click on Save button Method
    public void setPressSaveButton() {
        utility.waitForElementPresent(PressSaveButton);
        PressSaveButton.click();
    }

    public boolean verifySuccess() {
        utility.waitForElementPresent(ConfirmationMessage);
        return ConfirmationMessage.isDisplayed();
    }


}
