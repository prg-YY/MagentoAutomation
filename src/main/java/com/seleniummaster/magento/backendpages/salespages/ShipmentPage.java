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
    @FindBy(name = "order_increment_id")
    WebElement searchBox;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"sales_shipment_grid_table\"]/tbody/tr/td[1]/input")//customer "name team one"
    WebElement shipmentCheckBox;

    @FindBy(xpath = "//*[@id=\"sales_shipment_grid_table\"]/tbody/tr/td[8]/a")
    WebElement viewLink;
    //custom value list
    @FindBy(name = "carrier")
    WebElement customValue;
    //select DHL
    @FindBy(xpath = "//option[@value=\"dhl\"]")
    WebElement selectDHL;
    // enter tracking information number
    @FindBy(id = "tracking_number")
    WebElement trackingNumber;
    // commit text feild
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
    public void enterShipmentIdToSearchBox(){
        utility.waitForElementPresent(searchBox);
        searchBox.sendKeys("200000017");
        Log.info("shipment page is displayed");

    }
    //method for customerListCheckBox
    public void clickOnShipmentCheckBox(){
        utility.waitForElementPresent(shipmentCheckBox);
        shipmentCheckBox.click();
        Log.info("customerListCheckBox has been clicked");

    }
    //  method for viewLink
    public void clickOnViewLink(){
        utility.waitForElementPresent(viewLink);
        viewLink.click();
        Log.info("viewFromCustomerList has been clicked");
    }
    // search button
    public void clickOnSearchButton(){
        utility.waitForElementPresent(searchButton);
        searchButton.click();
        Log.info("search button hase been clicked");

    }
    //define shipment
    public void searchShipment(){
        enterShipmentIdToSearchBox();
        clickOnSearchButton();
        utility.sleep(2);
        clickOnShipmentCheckBox();
        clickOnViewLink();
        utility.sleep(2);

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
        utility.sleep(2);
        Log.info(" add button has been clicked");

    }
    // click on send tracking information button
    public void clickSendInformationButton(){
        utility.waitForElementPresent(sendTrackingInformation);
        sendTrackingInformation.click();

        Log.info("clicked on send tracking information button");
    }

    //alert accept method
    public void alretAccept(){
        try {
            WebDriverWait wait=new WebDriverWait(driver,2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert=driver.switchTo().alert();
            alert.accept();
        }catch (Exception e){

        }

    }

    // //Verify update shipments successful
    public boolean verifySuccessMessage(){
        utility.waitForElementPresent(verifySuccessMessage);
        verifySuccessMessage.isDisplayed();
        Log.info("Verified update shipments successful message ");
        return true;
    }
    @FindBy (name = "carrier")
    WebElement selectOption;

    public void selectShipment(){
        utility.waitForElementPresent(selectOption);
        Select option=new Select(selectOption);
        option.selectByValue("dhl");

    }
    //add tracking history
    public void enterCommentToTextBox(){
        utility.waitForElementPresent(commentTextBox);
        commentTextBox.sendKeys("good service");
        Log.info("comment has been entered");

    }
    //click on subment button
    public void clickCommentSubmitButton(){
        utility.waitForElementPresent(commentSubmitButton);
        commentSubmitButton.click();
        Log.info("comment submit button has been clicked");

    }
    public void addShipment(){
        selectDHL();
        enterTrackingNumber("3");
        clickAddButton();
        utility.sleep(2);

    }
    public void addComment(){
        enterCommentToTextBox();
        clickCommentSubmitButton();
        utility.sleep(2);
        clickSendInformationButton();
        utility.sleep(2);
        alretAccept();
    }





}


