package com.seleniummaster.magento.backendpages.salespages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OrdersPage extends TestBasePage {

    TestUtility utility;
    WebDriver driver;
    // Elements For Create Orders
    @FindBy(xpath = "//span[text()='Create New Order']")
    WebElement createOrderLink;
    @FindBy(id = "sales_order_create_customer_grid_filter_name")
    WebElement searchCustomerByNameTextField;
    @FindBy(id = "sales_order_create_customer_grid_filter_email")
    WebElement byEmailSearchBox;
    //customer List
    @FindAll(@FindBy(xpath  = "//*[@class=\"hor-scroll\"]/table/tbody/tr"))
    List<WebElement > customerListRow;
    @FindBy(xpath = "//*[@id=\"sales_order_create_customer_grid_table\"]/tbody/tr/td[3]")
    WebElement customerRow;

    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"sales_order_create_customer_grid_table\"]/tbody/tr")
    WebElement team1CheckBox;
    @FindBy(xpath = "//*[@id='store_18']")
    WebElement team1Store;
    @FindBy(xpath = "//span[text()='Add Products']")
    WebElement addProductsLink;
    @FindBy(xpath = "//*[@id=\"sales_order_create_search_grid_table\"]/tbody/tr[1]/td[5]/input")
    WebElement productCheckBox;
    @FindBy(xpath = "//span[text()='Add Selected Product(s) to Order']")
    WebElement addProductToOrderLink;
    @FindBy(id = "p_method_checkmo")
    WebElement paymentCheckBox;
    @FindBy(xpath = "//a[contains(text(),'Get shipping methods and rates')]")
    WebElement getShippingMethodLink;
    @FindBy(id = "s_method_flatrate_flatrate")
    WebElement fixedRadioButton;
    @FindBy(xpath = "//*[@class=\"order-totals-bottom\"]/p[3]/button/span/span/span")
    WebElement submitOrderButton;
    @FindBy(xpath = "//*[@class=\"messages\"]" )
    WebElement successMessageForCreate;
    @FindBy(xpath = "//*[@class=\"success-msg\"]" )
    WebElement successMessageForUpdate;


    // method for create order actions
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
        Log.info(email+" Email already Entered in to the Searching by email text box");
    }
    public void clickOnSearchButton(){
        utility.waitForElementPresent(searchButton);
        searchButton.click();
        Log.info("The search button has been clicked");
    }
    public void clickOnTeam1Store(){
        utility.waitForElementPresent(team1Store);
        team1Store.click();
        Log.info("team1 store check box has been clicked");
    }
    public void clickOnCustomerRow(){
        utility.waitForElementPresent(customerRow);
        customerRow.click();
        Log.info("The Team1 Customer has been clicked");
    }
    public void clickOnT1_Cus_CheckBox(){
        utility.waitForElementPresent(team1CheckBox);
        team1CheckBox.click();
        Log.info("team1 customer check box has been clicked");
    }
    public void clickOnAddProductsLink(){
        utility.waitForElementPresent(addProductsLink);
        addProductsLink.click();
        Log.info("Add product Link For Order has been clicked");
    }
    public void clickOnProductChekBox(){
        utility.waitForElementPresent(productCheckBox);
        productCheckBox.click();
        Log.info("Product ChekBox has been clicked");
    }
    public void clickOnAddProductToOrderLink(){
        utility.waitForElementPresent(addProductToOrderLink);
        addProductToOrderLink.click();
        Log.info("Add Products to Order Link has been clicked");
    }
    public void checkPaymentMethod(){
        utility.waitForElementPresent(paymentCheckBox);
        paymentCheckBox.click();
        Log.info("Payment method Check box has been clicked");
    }
    public void clickOnGetShippingMethodLink(){
        utility.waitForElementPresent(getShippingMethodLink);
        getShippingMethodLink.click();
        Log.info("get shipping method link has been clicked");
    }
    public void checkOnFixedRadioButton(){
        utility.waitForElementPresent(fixedRadioButton);
        fixedRadioButton.click();
        utility.sleep(2);
        Log.info("fixed Radio button  has been checked");
    }
    public void clickSubmitOrderButton(){
        utility.waitForElementPresent(submitOrderButton);
        utility.sleep(3);
        submitOrderButton.click();
        Log.info("Submit order button has been clicked");
    }
    public boolean verifyOrderCreatedSuccessfully(){
        utility.waitForElementPresent(successMessageForCreate);
        if (successMessageForCreate.getText().contains("Success")){
            Log.info("Test Passed ,The Order Created Successfully");
        }else Log.info("Test Failed,Cannot Create Order");
        return true;
    }
    //Search Customer method For Order
    public void searchCustomerForOrder(String email){
        enterEmailToEmailSearchBox(email);
        clickOnSearchButton();
        utility.sleep(2);
        clickOnCustomerRow();
    }
    public void addProductForOrder(){
        clickOnTeam1Store();
        utility.sleep(2);
        clickOnAddProductsLink();
        utility.sleep(2);
        clickOnProductChekBox();
        utility.sleep(2);
        clickOnAddProductToOrderLink();
        utility.sleep(2);
    }
    public void clickShipmentAndSubmitButton(){
        checkPaymentMethod();
        utility.sleep(2);
        clickOnGetShippingMethodLink();
        utility.sleep(2);
        checkOnFixedRadioButton();
        utility.sleep(1);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,-500)");
        clickSubmitOrderButton();
    }

    public void createNewOrder(){
        String team1Email=prop.getProperty("FrondEmail");
        SalesDashboardPage dashboardPage=new SalesDashboardPage(driver);
        dashboardPage.clickOnSalesLink();
        dashboardPage.clickOrdersLink();
        clickOnCreateOrderLink();
        searchCustomerForOrder(team1Email);
        utility.sleep(2);
        clickOnCustomerRow();
        clickOnTeam1Store();
        clickOnAddProductsLink();
        clickOnT1_Cus_CheckBox();
        clickOnAddProductsLink();
        clickOnProductChekBox();
        clickOnAddProductToOrderLink();
        clickOnGetShippingMethodLink();
        checkOnFixedRadioButton();
        clickSubmitOrderButton();
        verifyOrderCreatedSuccessfully();
    }


    // Define Elements For Update Orders
    @FindAll(@FindBy(xpath = "//*[@id=\"sales_order_grid_table\"]/tbody/tr"))
    List<WebElement> ordersList;
    @FindBy(id = "sales_order_grid_filter_status")
    WebElement pendingDropDownList;
    @FindBy(xpath = "//*[@id=\"sales_order_grid_table\"]/tbody/tr[1]")
    WebElement OrderRow;
    @FindBy(xpath ="//span[text()='Edit']" )
    WebElement editLink;
    @FindBy(xpath = "//*[@id=\"sales_order_grid_table\"]/tbody/tr[1]/td[10]/a")
    WebElement orderViewLink;
    @FindBy(id = "order-billing_address_company")
    WebElement companyNameTextBox;
// update Order Method
    public void selectPendingOrder(String value){
        utility.waitForElementPresent(pendingDropDownList);
        Select select=new Select(pendingDropDownList);
        select.selectByValue(value);
        clickOnSearchButton();
        utility.sleep(2);
    }
    public void clickOnOrderViewForUpdate(){
        utility.waitForElementPresent(orderViewLink);
        orderViewLink.click();
        utility.sleep(2);
        Log.info("Order view link has been clicked");
    }
    public void clickEditButton(){
        utility.waitForElementPresent(editLink);
        editLink.click();
        Alert alert=driver.switchTo().alert();
        utility.waitForAlertPresent();
        alert.accept();
        Log.info("Edit button has been Clicked");
    }
    public void enterCompanyName(String companyName){
        utility.waitForElementPresent(companyNameTextBox);
        companyNameTextBox.sendKeys(companyName);
        utility.sleep(1);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
        Log.info("Order Description has been added");
    }
    public void clickEditSubmitButton(){
        clickOnGetShippingMethodLink();
        utility.sleep(2);
        checkOnFixedRadioButton();
        utility.sleep(1);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
        clickSubmitOrderButton();
        Log.info("Submit Order button has been clicked");

    }
    public boolean isOrderUpdatedSuccessfully(){
        utility.waitForElementPresent(successMessageForUpdate);
        if (successMessageForUpdate.isDisplayed()){
            System.out.println("Test Passed , The Order Updated Successfully");
            return true;
        }else System.out.println("Test Failed");
        return false;
    }

    //cancel order elements
    @FindBy(xpath = "//*[@id=\"sales_order_grid_table\"]/tbody/tr[1]/td[1]/input")
    WebElement orderCheckBox;
    @FindBy(id = "sales_order_grid_massaction-select")
    WebElement cancelOption;
    @FindBy(xpath = "//span[text()='Submit']")
    WebElement submitButton;
    @FindBy(xpath = " //*[@class='success-msg']")
    WebElement cancelSuccessMessage;


    // select cancel option method
    public void clickOrderCheckBox(){
        utility.waitForElementPresent(orderCheckBox);
        orderCheckBox.click();
        Log.info("Order check box has been clicked");
    }
    public void selectCancel(String value){
        utility.waitForElementPresent(cancelOption);
        Select option=new Select(cancelOption);
        option.selectByValue(value);
    }
    public void clickOnCancelSubmitButton(){
        utility.sleep(2);
        utility.waitForElementPresent(submitButton);
        utility.sleep(2);
        submitButton.click();
        Log.info("Cancel submit button has been clicked");
    }
    public boolean isCancelSuccessMessageDisplayed(){
        utility.waitForElementPresent(cancelSuccessMessage);
        cancelSuccessMessage.isDisplayed();
        Log.info("1 Order successfully canceled");
        return cancelSuccessMessage.isDisplayed();
    }


}
