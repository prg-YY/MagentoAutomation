package com.seleniummaster.magento.backendpages.salespages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShipmentPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    Alert alert;
    @FindBy(xpath = "//span[text()=\"Sales\"]")
    WebElement salesLink;
    //element for shipments
    @FindBy(xpath = "//span[text()=\"Shipments\"]")
    WebElement shipments;
    //  display shipment dashboard page
    @FindBy(className = "icon-head head-sales-shipment")
    WebElement shipmentsPage;
    //select check box from customer dropdown list
    @FindBy(name = "shipment_ids")
    WebElement customerListCheckBox;
    //customer view from drop down list(number3)
    @FindBy(xpath = "//td[@class=\" last\"]")//customer "name team one"
    WebElement viewFromCustomerList;
    //magento admin panel page on display
    @FindBy(xpath = " @FindBy(xpath = \"\")\n")
    WebElement adminPanelPage;
    //custom value list
    @FindBy(xpath = "//select[@class=\"select\"]")
    WebElement customValue;
    //select DHL
    @FindBy(xpath = "//option[@value=\"dhl\"]")
    WebElement selectDHL;
    // enter tracking information number
    @FindBy(name = "\"number\"")
    WebElement trackingNumber;
    // click on add button
    @FindBy(xpath = "//button[@id=\"id_3b895e69b31b252de96bbd3089b0b930\"]")
    WebElement clickAddButton;
    // click on send tracking information button
    @FindBy(linkText = "//button[@id=\"id_5d4ba92cbf410a54015662664f619f6d\"]")
    WebElement sendTrackingInformation;
    // alert
    //Verify update shipments successful
    @FindBy(xpath = "//li[@class=\"success-msg\"]")
    WebElement verifySuccessMessage;


    //combine webdriver
    public ShipmentPage(WebDriver driver) {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(driver, this);
         utility= new TestUtility(driver);
    }
    // method sales link
    public void clickOnSalesLink(){
      utility.waitForElementPresent(salesLink);
      salesLink.click();
        Log.info("sales link has been clicked");
    }
    //method shipments
    public void clickOnshipments(){
        utility.waitForElementPresent(shipments);
        shipments.click();
        Log.info("shipments has been clicked");
    }
    //method for shipment dash board page
    public void displayShipmentPage(){
        utility.waitForElementPresent(shipmentsPage);
        shipmentsPage.isDisplayed();
        Log.info("shipment page is displayed");

    }
    //method for customerListCheckBox
    public void clickOnCustomerListCheckBox(){
        utility.waitForElementPresent(customerListCheckBox);
        customerListCheckBox.click();
        Log.info("customerListCheckBox has been clicked");

    }
    //  method for viewFromCustomerList
    public void clickOnviewFromCustomerList(){
        utility.waitForElementPresent(viewFromCustomerList);
        viewFromCustomerList.click();
        Log.info("viewFromCustomerList has been clicked");
    }
    // method for magento admin panel page on display
    public void veiwAdminPanelPage(){
        utility.waitForElementPresent(adminPanelPage);
        adminPanelPage.isDisplayed();
        Log.info("magento admin panel page on displayed");
    }
    //custom value list
    public void clickCustomValueList(){
        utility.waitForElementPresent(customValue);
        customValue.click();
        Log.info(" clicked custom value list ");
    }
    // method for select DHL
    public void selectDHL(){
        utility.waitForElementPresent(selectDHL);
        selectDHL.isSelected();
        Log.info("selectDHL has been selected");

    }
    // method for trackingNumber
    public void fieldldTrackingNumberTextBox(String number){
        utility.waitForElementPresent(trackingNumber);
        trackingNumber.sendKeys(number);
        Log.info("trackingNumber has been fields");

    }
    // click on add button
    public void clickAddButton(){
        utility.waitForElementPresent(clickAddButton);
        clickAddButton.click();
        Log.info(" add button has been clicked");

    }
    // click on send tracking information button
    public void clickSandInformationTracking(){
        utility.waitForElementPresent(sendTrackingInformation);
        sendTrackingInformation.click();
        Log.info("clicked on send tracking information button");
    }

    //alert accept method
    public void clickAlret(){
        try {
            WebDriverWait wait=new WebDriverWait(driver,2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert=driver.switchTo().alert();
            alert.accept();
        }catch (Exception e){

        }
    }

    // //Verify update shipments successful
    public void verifySuccessMessage(){
        utility.waitForElementPresent(verifySuccessMessage);
        verifySuccessMessage.isDisplayed();
        Log.info("Verified update shipments successful message ");
    }
    @FindBy (name = "carrier")
    WebElement selectOption;

    public void selectShipment(){
        utility.waitForElementPresent(selectOption);
        Select option=new Select(selectOption);
        option.selectByValue("dhl");
    }





}


