package com.seleniummaster.magento.backendpages.salespages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage extends TestBasePage {

    //Sales Manager should be able to manage  (create, update and cancel)  orders
    //Sales Manager should be able to manage (view and update) shopping cart for customers.
    // (You need to open a customer and manage shopping cart)
    //Sales Manager should be able to manage (create, update and delete) orders with in store pickup
    TestUtility utility;
    WebDriver driver;
    @FindBy(xpath = "//span[text()='Create New Order']")
    WebElement createOrderLink;
    @FindBy(id = "sales_order_create_customer_grid_filter_name")
    WebElement searchCustomerByNameTextField;
    @FindBy(id = "sales_order_create_customer_grid_filter_email")
    WebElement byEmailSearchBox;
    //    @FindBy(xpath = "//*[@class=\"hor-scroll\"]/table/tbody/tr")
//    WebElement customerListRow;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"sales_order_create_customer_grid_table\"]/tbody/tr")
    WebElement team1Link;

    //
    public OrdersPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }

    //Methods
    public void clickOnCreateOrderLink(){
        utility.waitForElementPresent(createOrderLink);
        createOrderLink.click();
        Log.info("Create New Order link has been clicked");
    }
    public void enterEmailToEmailSearchBox(String email){
        utility.waitForElementPresent(byEmailSearchBox);
        byEmailSearchBox.sendKeys(email);
        Log.info(email+" Email already Entered in to the Searcheng by email text box");
    }
    public void clickOnSearchButton(){
        utility.waitForElementPresent(searchButton);
        searchButton.click();
        Log.info("The search button has been clicked");
    }

}
