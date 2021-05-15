package com.seleniummaster.magento.backendpages.catalogpages;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditExistingProductPage extends TestBasePage {

    WebDriver driver;
    TestUtility utility;
    //click the catalog category
    @FindBy(xpath = "//*[@id=\"nav\"]/li/a/span")
    WebElement catalogCategory;
    //select the manageProduct option

    @FindBy(xpath = "//*[@id=\"nav\"]/li/ul/li[1]")
    WebElement manageProduct;

    //select the existing product and click
    @FindBy(xpath = "//*[@id=\"productGrid_table\"]/tbody/tr[1]/td[3]")
    WebElement selectProduct;

    //click the prices link
    @FindBy(css = "#product_info_tabs_group_8")
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


    public EditExistingProductPage(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }
    //select the product and click
    public void clickTheProduct(){
        utility.waitForElementPresent(selectProduct);
        selectProduct.click();
    }
    //click the prices link
    public void clickPriceLink(){
        utility.waitForElementPresent(pricesLink);
        pricesLink.click();
    }
    //enter price in the special price field
    public void enterSpecialPrice(){
        utility.waitForElementPresent(specialPriceTextBoxField);
        specialPriceTextBoxField.sendKeys(prop.getProperty("specialPrice"));

        //click the save button
    }
    public void clickSaveButton(){
        utility.waitForElementPresent(saveButton);
        saveButton.click();

    }
    public boolean verifySuccessfulMessage(){
        utility.waitForElementPresent(editSuccessMessage);
        return editSuccessMessage.isDisplayed();
    }
    public boolean editExistingProduct(){
        clickTheProduct();
        clickPriceLink();
        enterSpecialPrice();
        clickSaveButton();
        return verifySuccessfulMessage();
    }

}



