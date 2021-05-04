package com.seleniummaster.magento.backendpages.customerpages;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerGroupPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;

    @FindBy(xpath = "//input[@type=\"text\"and@id=\"customerGrid_filter_name\"]")
    WebElement EnterCustomerName;

    @FindBy(xpath = "//button[@title='Search']")
    WebElement ActionSearchButton;

    @FindBy(css = ".massaction-checkbox")
    WebElement ClickonCheckbox;

    @FindBy(id = "customerGrid_massaction-select")
    WebElement ActionsDropdownList;

    @FindBy(css = "#visibility")
    WebElement GroupDropdownList;

    @FindBy(xpath = "//button[@title='Submit']")
    WebElement ActionsSubmitButton;

    //Customer Manager can add and update customer groups.



}
