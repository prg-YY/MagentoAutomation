package com.seleniummaster.magento.backendpages.catalogpages;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewProductPage {
    public class CustomerManagerResetPasswordPage extends TestBasePage {
        WebDriver driver;
        TestUtility utility;

        @FindBy(css = "button[class='scalable add']")//2 Elements
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
        WebElement StatusSelectBox;

        @FindBy(xpath = "//select[@id=\"visibility\"]")//correct
        WebElement VisibilitySelectBox;

        @FindBy(css = "button[class='scalable save'][title='Save']")//correct
        WebElement ClickSaveButton;

        @FindBy(xpath = "//div[@id=\"messages\"]")//not sure
        WebElement ConfirmationMessage;


    }
}
