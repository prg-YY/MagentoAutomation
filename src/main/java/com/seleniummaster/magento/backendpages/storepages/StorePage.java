package com.seleniummaster.magento.backendpages.storepages;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StorePage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;

    @FindBy(xpath = "(//span[text()='Create Store'])[1]")
    WebElement CreateStoreButton;

    @FindBy(xpath = "(//span[text()='Create Website'])[1]")
    WebElement CreateWebsiteButton;

    @FindBy(xpath = "(//span[text()='Create Store View'])[1]")
    WebElement CreateStoreviewButton;

    @FindBy(css = "#website_name")
    WebElement NameTextBox;

    @FindBy(css = "#website_code")
    WebElement CodeTextBox;

    @FindBy(css = "#website_sort_order")
    WebElement SortOrderTextBox;

    @FindBy(css = "(//span[text()='Save Website'])[1]")
    WebElement SaveButton;

}
