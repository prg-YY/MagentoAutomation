package com.seleniummaster.magento.backendpages.salespages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShipmentPage  {
    WebDriver driver;
    TestUtility utility;

    @FindBy(xpath = "//*[@id=\"sales_shipment_grid_filter_increment_id\"]")
    WebElement searchBox;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"sales_shipment_grid_table\"]/tbody/tr/td[1]/input")//customer "name team one"
    WebElement shipmentCheckBox;
    @FindBy(xpath = "//*[@id=\"sales_shipment_grid_table\"]/tbody/tr/td[8]/a")
    WebElement viewLink;
    @FindBy(name = "carrier")
    WebElement customValue;
    @FindBy(id = "tracking_number")
    WebElement trackingNumber;
    @FindBy(name= "comment[comment]")
    WebElement commentTextBox;
    @FindBy(xpath = "//span[text()='Submit Comment']")
    WebElement commentSubmitButton;
    @FindBy(xpath = "//span[text()='Add']")
    WebElement clickAddButton;
    // click on send tracking information button
    @FindBy(linkText = "(//span[text()='Send Tracking Information'])[1]")
    WebElement sendTrackingInformation;
    //Verify update shipments successful
    @FindBy(xpath = "//li[@class=\"success-msg\"]")
    WebElement verifySuccessMessage;


    public ShipmentPage(WebDriver driver) {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(driver, this);
         utility= new TestUtility(driver);
    }

    public void enterShipmentIdToSearchBox( String id){
        utility.waitForElementPresent(searchBox);
        searchBox.sendKeys(id);
        Log.info("shipment Id has been entered for searching");

    }
    //method
    public void clickOnShipmentCheckBox(){
        utility.waitForElementPresent(shipmentCheckBox);
        shipmentCheckBox.click();
        Log.info("shipment CheckBox has been clicked");

    }
    //  method for viewLink
    public void clickOnViewLink(){
        utility.waitForElementPresent(viewLink);
        viewLink.click();
        Log.info("view link has been clicked");
    }
    // search button
    public void clickOnSearchButton(){
        utility.waitForElementPresent(searchButton);
        searchButton.click();
        Log.info("search button hase been clicked");

    }
    //define shipment
    public void searchShipment(String shipmentId){
        enterShipmentIdToSearchBox(shipmentId);
        clickOnSearchButton();
        utility.sleep(1);
        clickOnShipmentCheckBox();
        clickOnViewLink();
        utility.sleep(1);

    }

    // method for select DHL
    public void selectDHL(){
        utility.waitForElementPresent(customValue);
        Select option=new Select(customValue);
        option.selectByValue("dhl");
        Log.info("selectDHL has been selected");

    }
    // method for trackingNumber
    public void enterTrackingNumber(String number){
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
    public void clickSendInformationButton(){
        utility.waitForElementPresent(sendTrackingInformation);
        sendTrackingInformation.click();

        Log.info("send tracking information button has been clicked");
    }


    // //Verify update shipments successful
    public boolean shipmentUpdatedSuccessfully(){
        utility.waitForElementPresent(verifySuccessMessage);
        verifySuccessMessage.isDisplayed();
        Log.info("Successful message has been displayed ");
        return true;
    }

    //add tracking history
    public void enterCommentToTextBox(String commentText){
        utility.waitForElementPresent(commentTextBox);
        commentTextBox.sendKeys(commentText);
        Log.info("comment has been entered");

    }
    //click on submit button
    public void clickCommentSubmitButton(){
        utility.waitForElementPresent(commentSubmitButton);
        commentSubmitButton.click();
        Log.info("comment submit button has been clicked");

    }
    public void addShipment(){
        selectDHL();
        enterTrackingNumber("2");
        clickAddButton();
        utility.sleep(1);

    }
    public void addComment(String commentText){
        enterCommentToTextBox(commentText);
        clickCommentSubmitButton();
        utility.sleep(1);
        clickSendInformationButton();
       Alert alert=driver.switchTo().alert();
        utility.waitForAlertPresent();
       alert.accept();

    }





}


