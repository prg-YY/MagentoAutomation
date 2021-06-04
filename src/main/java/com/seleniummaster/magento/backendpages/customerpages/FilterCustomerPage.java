package com.seleniummaster.magento.backendpages.customerpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FilterCustomerPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    Select option;

    //Customer Manager can filter customers by various filters such as Email," +
    //   " Group, Country, State, Web Site, Gender and Tax VAT Number - KeMer

    public FilterCustomerPage() {
        this.driver=TestBasePage.driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }

    @FindBy(id = "customerGrid_filter_name")
    WebElement nameSearchBox;
    @FindBy(id = "customerGrid_filter_email")
    WebElement emailSearchBox;
    @FindBy(id = "customerGrid_filter_group")
    WebElement groupDripDownList;
    @FindBy(id = "customerGrid_filter_billing_country_id")
    WebElement countryDropDownList;
    @FindBy(id = "customerGrid_filter_billing_region")
    WebElement stateSearchBox;
    @FindBy(id = "customerGrid_filter_website_id")
    WebElement webSiteDropDownList;
    @FindBy(xpath = "//span[text()='Reset Filter']")
    WebElement resetFilterButton;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;
//    @FindAll(@FindBy(xpath = "//*[@id=\"customerGrid_table\"]/tbody/tr"))
//    WebElement customersRow;
//    @FindBy(xpath = "//*[@id=\"customerGrid_table\"]/tbody/tr")
//    WebElement customerRows;


    //methods for action
    public void  clickResetFilterButton(){
        utility.waitForElementPresent(resetFilterButton);
        resetFilterButton.click();
    }
    public void enterCustomerNameToNameSearchBox(String customerName){
        utility.waitForElementPresent(nameSearchBox);
        nameSearchBox.clear();
        nameSearchBox.sendKeys(customerName);
        Log.info("Customer name has been entered");
    }
    public void enterEmailToEmailSearchBox(String email){
        utility.waitForElementPresent(emailSearchBox);
        emailSearchBox.sendKeys(email);
        Log.info("Customer Email has been Entered");
    }
    public void enterCityNameToStateSearchBox(String cityName){
        utility.waitForElementPresent(stateSearchBox);
        stateSearchBox.sendKeys(cityName);
        Log.info("City Name has been entered");
    }
    public void selectCountry(String countryName){
        utility.waitForElementPresent(countryDropDownList);
        option=new Select(countryDropDownList);
        option.selectByValue(countryName);
        Log.info("Country name ("+countryName+")has been selected");
    }
    public void selectGroup(String groupName){
        utility.waitForElementPresent(groupDripDownList);
        option=new Select(groupDripDownList);
        option.selectByValue(groupName);
        Log.info("Group name ("+groupName+")has been selected");

    }
    public void selectWebsite(String website){
        utility.waitForElementPresent(webSiteDropDownList);
        option=new Select(webSiteDropDownList);
        option.selectByValue(website);
        Log.info("The website ("+website+")has been selected");
    }
    public void clickOnSearchButton(){
        utility.waitForElementPresent(searchButton);
        searchButton.click();
        Log.info("Search button has been clicked");
    }
    // Filter By name method
    public void filterByName(String customerName){
        clickResetFilterButton();
        utility.sleep(1);
        enterCustomerNameToNameSearchBox(customerName);
        utility.sleep(2);
        clickOnSearchButton();
        utility.sleep(3);
    }
    //Filter By email method
    public void filterByEmail(String customerEmail){
        clickResetFilterButton();
        utility.sleep(1);
        enterEmailToEmailSearchBox(customerEmail);
        clickOnSearchButton();
        utility.sleep(3);
    }
    //Filter bu group method
    public void filterByGroup(String cus_groupName){
        clickResetFilterButton();
        utility.sleep(1);
        selectGroup(cus_groupName);
        clickOnSearchButton();
        utility.sleep(3);
    }
    //Filter by county method
    public void filterByCountry(String countryName){
        clickResetFilterButton();
        utility.sleep(1);
        selectCountry(countryName);
        clickOnSearchButton();
        utility.sleep(3);
    }
    //Filter bu state method
    public void filterByState(String stateName){
        clickResetFilterButton();
        utility.sleep(1);
        enterCityNameToStateSearchBox(stateName);
        clickOnSearchButton();
        utility.sleep(3);
    }
    //Filter by website method
    public void filterByWebsite(String website){
        clickResetFilterButton();
        utility.sleep(1);
        selectWebsite(website);
        utility.sleep(1);
        clickOnSearchButton();
        utility.sleep(3);
    }
    public boolean filteringCompletedSuccessfully(){
        List<WebElement> customersList=driver.findElements(By.xpath("//*[@id=\"customerGrid_table\"]/tbody/tr"));
        if (customersList.size()>=1){
            System.out.println("Test Passed,Filter customer test passed");
            return true;
        }else System.out.println("Test Failed");
        return false;
    }





}
