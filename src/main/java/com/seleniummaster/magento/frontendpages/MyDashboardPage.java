package com.seleniummaster.magento.frontendpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyDashboardPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;

    @FindBy(xpath = "//div[@class=\"account-cart-wrapper\"]/a/span")
    WebElement accountTag;

    @FindBy(linkText = "Address Book")
    WebElement addressBookLink;
    //@FindBy(xpath = "//span[text()='Add New Address']")
    @FindBy(xpath = "//span[text()='Add New Address']/parent::button")
    WebElement addNewAddressLink;

    public MyDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);

    }

    public void clickAccountTag() {
        utility.waitForElementPresent(accountTag);
        accountTag.click();
    }

    public void clickAddressBookLink() {
        utility.waitForElementPresent(addressBookLink);
        addressBookLink.click();
        Log.info("Address book link clicked");
    }

    public void clickAddNewAddressLink() {
        addNewAddressLink.click();
        Log.info("Add new address link clicked");
    }

    public AddNewAddressPage clickNewAddressPage() {
        clickAddressBookLink();
        clickAddNewAddressLink();
        return new AddNewAddressPage(driver);
    }
}
