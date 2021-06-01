package com.seleniummaster.magento.frontendpages;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class UpdateAddressPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    @FindBy(linkText = "Change Billing Address")
    WebElement ChangeBillingAddressLink;
    @FindBy(xpath = "//input[@id='firstname']")
    WebElement addFirstname;
    @FindBy(xpath = "//input[@id='lastname']")
    WebElement addLastname;
    @FindBy(xpath = "//input[@id='telephone']")
    WebElement addPhoneNumber;
    @FindBy(xpath = "//input[@id='street_1']")
    WebElement addAddress;
    @FindBy(xpath = "//*[@id='country']")
    WebElement selectCountry;
    @FindBy(xpath = "//*[@id='region_id']")
    WebElement selectState;
    @FindBy(xpath = "//*[@id='city']")
    WebElement addCity;
    @FindBy(xpath = "//*[@id='zip']")
    WebElement addZip;
    @FindBy(xpath = "//span[text()=\"Save Address\"]")
    WebElement saveAddressLink;
    @FindBy(xpath = "//span[text()=\"The address has been saved.\"]")
    WebElement confirmationMessage;


    public UpdateAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }
    public void clickChangeBillingAdressLink(){
        utility.waitForElementPresent(ChangeBillingAddressLink);
        utility.sleep(3);
        ChangeBillingAddressLink.click();
    }


    public void selectCountry()
    {
        utility.waitForElementPresent(selectCountry);
       Select countryDropdownList= new Select(selectCountry);
       countryDropdownList.selectByValue("US");

    }

    public void selectState()
    {
        utility.waitForElementPresent(selectState);
        Select StateDropdownList=new Select(selectState);
        StateDropdownList.selectByValue("18");
    }

    public void enterCity(String city)
    {
        utility.waitForElementPresent(addCity);
        addCity.clear();
        addCity.sendKeys(city);
        Log.info("City has been sent as " + city);
    }

    public void enterZip(String zip)
    {
        utility.waitForElementPresent(addZip);
        addZip.clear();
        addZip.sendKeys(zip);
        Log.info("Zip has been sent as " + zip);
    }

    public void clickSaveAddress()
    {
        utility.waitForElementPresent(saveAddressLink);
        saveAddressLink.click();
        Log.info("Save address link clicked");
    }
    public boolean verifySuccess(){
        utility.waitForElementPresent(confirmationMessage);
        utility.sleep(3);
        if (confirmationMessage.isDisplayed()) {
            Log.info("Test Passed ,The address has been saved.");
            return true;
        }else
            Log.info("Test Failed");
        return false;
    }

    public boolean UpdateAddress()
    {

        clickChangeBillingAdressLink();
        selectCountry();
        selectState();
        enterCity(prop.getProperty("City"));
        enterZip(prop.getProperty("Zip"));
        clickSaveAddress();
        return verifySuccess();
    }
}
