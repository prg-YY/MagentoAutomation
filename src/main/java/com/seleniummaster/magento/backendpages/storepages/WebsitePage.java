package com.seleniummaster.magento.backendpages.storepages;

import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebsitePage {
    WebDriver driver;
    TestUtility utility;

    @FindBy(xpath = "(//span[text()='System'])[1]")
    WebElement SystemButton;

    @FindBy(xpath = "(//span[text()='Create Website'])[1]")
    WebElement CreateWebsiteButton;

    @FindBy(css = "#website_name")
    WebElement NameTextBox;

    @FindBy(css = "#website_code")
    WebElement CodeTextBox;

    @FindBy(css = "#website_sort_order")
    WebElement SortOrderTextBox;

    @FindBy(css = "(//span[text()='Save Website'])[1]")
    WebElement SaveWebsiteButton;


}
