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

        @FindBy(xpath = "button[class='scalable add']")//2 Elements
        WebElement AddProductButton;

        @FindBy(css = "button[class='scalable save']")//correct
        WebElement ContinueButton;

        @FindBy(css = "input[name='product[name]']")
        WebElement FirstNameTextBox;

    }
