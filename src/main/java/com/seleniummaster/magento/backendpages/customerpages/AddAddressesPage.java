package com.seleniummaster.magento.backendpages.customerpages;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.print.PageFormat;

public class AddAddressesPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;

    public AddAddressesPage() {
        this.driver=TestBasePage.driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }

    @FindBy(id = "customer_info_tabs_addresses")
    WebElement addressLink;
    @FindBy(xpath = "(//span[text()='Add New Address'])[1]")
    WebElement addAddressLink;
    @FindBy(name = "account[default_billing]")
    WebElement defaultAddressRadioButton;
    //xpath = "(//div[@id=\"_item1address_fieldset\"]/div/table/tbody/tr[7]/td/div/input[1])[1]"
    @FindBy(xpath = "(//div[@class=\"fieldset \"]/div/table/tbody/tr[7]/td/div/input)[5]")
    WebElement streetAddressTextBox;
    //xpath = "//div[@id=\"_item1address_fieldset\"]/div/table/tbody/tr[8]"
    @FindBy(id = "_item0city")
    WebElement cityTextBox;
    @FindBy(id = "_item0country_id")
    WebElement countrySelection;
    @FindBy(id = "_item0region_id")
    WebElement stateSelection;
    @FindBy(id = "_item0postcode")
    WebElement zipCodeTextBox;
    @FindBy(id = "_item0telephone")
    WebElement telephoneNumberTextBox;
    @FindBy(xpath = "//span[contains(text(),'The customer has been saved.')]")
    WebElement successMessage;
    @FindBy(xpath = "(//span[text()='Save Customer'])[1]")
    WebElement saveButton;
    //Add address Method
    public void clickAddressLink(){
        utility.waitForElementPresent(addressLink);
        addressLink.click();
    }
    public void clickAddAddressLink(){
        utility.waitForElementPresent(addAddressLink);
        addAddressLink.click();
    }
    public void clickDefaultAddressRadioButton(){
        utility.waitForElementPresent(defaultAddressRadioButton);
        defaultAddressRadioButton.click();
    }
    public void enterStreetAddress(String streetAddress){
        utility.waitForElementPresent(streetAddressTextBox);
       streetAddressTextBox.sendKeys(streetAddress);
    }
    public void enterCityName(String cityName){
        utility.waitForElementPresent(cityTextBox);
        cityTextBox.sendKeys(cityName);
    }
    public void selectCountry(){
        utility.waitForElementPresent(countrySelection);
        Select select=new Select(countrySelection);
        select.selectByValue("US");
    }
    public void selectState(){
        utility.waitForElementPresent(stateSelection);
        Select select=new Select(stateSelection);
        select.selectByValue("5");
    }
    public void enterZipCode(String zipCode){
        utility.waitForElementPresent(zipCodeTextBox);
        zipCodeTextBox.sendKeys(zipCode);
    }
    public void enterTelephoneNumber(String telNumber){
        utility.waitForElementPresent(telephoneNumberTextBox);
        telephoneNumberTextBox.sendKeys(telNumber);
    }
    public void clickSaveButton(){
        utility.waitForElementPresent(saveButton);
        saveButton.click();
    }
    // add address method
    public void addAddress(String streetAddress,String cityName,String zipCode,String telephoneNumber){
        clickAddressLink();
        utility.sleep(2);
        clickAddAddressLink();
        utility.sleep(2);
        clickDefaultAddressRadioButton();
        utility.sleep(2);
        enterStreetAddress(streetAddress);
        enterCityName(cityName);
        selectCountry();
        selectState();
        enterZipCode(zipCode);
        enterTelephoneNumber(telephoneNumber);
        clickSaveButton();
        utility.sleep(2);
    }

    public boolean newAddressAddedSuccessfully(){
        utility.waitForElementPresent(successMessage);
        if (successMessage.isDisplayed()){
            System.out.println("Test Passed, New Address Added Successfully");
            return true;
        }else System.out.println("Test Failed, add Address test failed");
        return false;
    }

}
