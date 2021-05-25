package com.seleniummaster.magento.frontendpages;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class AddNewAddressPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
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

    //create a constructor to initialize the page // page factory
    public AddNewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver); //combine driver with page factory
    }

    //define actions // method for each section
    //Enter First name Method
    public void enterFirstname(String firstName)
    {
        utility.waitForElementPresent(addFirstname);
        addFirstname.sendKeys(firstName);
        Log.info("First name has been sent as " + firstName);
    }
    //Enter Last name Method
    public void enterLastname(String lastName)
    {
        utility.waitForElementPresent(addLastname);
        addLastname.sendKeys(lastName);
        Log.info("Last name has been sent as " + lastName);
    }
    // Enter phone number method
    public void enterPhoneNumber(String phoneNumber) {
        utility.waitForElementPresent(addPhoneNumber);
        addPhoneNumber.sendKeys(phoneNumber);
        Log.info("Phone number has been sent as " + phoneNumber);
    }
    // Enter Address method
    public void enterAddress(String address)
    {
        utility.waitForElementPresent(addAddress);
        addAddress.sendKeys(address);
        Log.info("Address has been sent as " + address);
    }
    // Enter Country method
    public void selectCountry()
    {
        utility.waitForElementPresent(selectCountry);
       Select countryDropdownList= new Select(selectCountry);
       countryDropdownList.selectByValue("US");

    }
    // Enter state method
    public void selectState()
    {
        utility.waitForElementPresent(selectState);
        Select StateDropdownList=new Select(selectState);
        StateDropdownList.selectByValue("18");
    }
    // Enter city method
    public void enterCity(String city)
    {
        utility.waitForElementPresent(addCity);
        addCity.sendKeys(city);
        Log.info("City has been sent as " + city);
    }
    // Enter zip code method
    public void enterZip(String zip)
    {
        utility.waitForElementPresent(addZip);
        addZip.sendKeys(zip);
        Log.info("Zip has been sent as " + zip);
    }
    // Enter click address method
    public void clickSaveAddress()
    {
        utility.waitForElementPresent(saveAddressLink);
        saveAddressLink.click();
        Log.info("Save address link clicked");
    }
    public boolean verifySuccess(){
        utility.waitForElementPresent(confirmationMessage);
        utility.sleep(3);
        return confirmationMessage.isDisplayed();
    }
    // combine all methods from the current page
    public boolean addNewAddress()
    {
        Random r=new Random(1000);


        enterPhoneNumber(prop.getProperty("PhoneNum"));
        enterAddress(prop.getProperty("StreetAddress"));
        selectCountry();
        selectState();
        enterCity(prop.getProperty("City"));
        enterZip(prop.getProperty("Zip"));
        clickSaveAddress();
        return verifySuccess();
    }
}
