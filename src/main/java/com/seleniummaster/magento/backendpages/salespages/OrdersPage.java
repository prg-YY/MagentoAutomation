package com.seleniummaster.magento.backendpages.salespages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrdersPage extends TestBasePage {

    TestUtility utility;
    WebDriver driver;
    SalesDashboardPage dashboardPage;
    Alert alert;
    JavascriptExecutor js;

    // Elements For Create Orders
    @FindBy(xpath = "//span[text()='Create New Order']")
    WebElement createOrderLink;
    @FindBy(id = "sales_order_create_customer_grid_filter_name")
    WebElement searchCustomerByNameTextField;
    @FindBy(id = "sales_order_create_customer_grid_filter_email")
    WebElement byEmailSearchBox;
    @FindBy(xpath = "//*[@id=\"sales_order_create_customer_grid_table\"]/tbody/tr/td[3]")
    WebElement customerRow;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"sales_order_create_customer_grid_table\"]/tbody/tr[1]")
    WebElement customerRowLink;
    @FindBy(xpath = "//*[@id='store_18']")
    WebElement team1Store;
    @FindBy(xpath = "//span[text()='Add Products']")
    WebElement addProductsLink;
    @FindBy(xpath = "//*[@id=\"sales_order_create_search_grid_table\"]/tbody/tr[1]/td[5]/input")
    WebElement productCheckBox;
    @FindBy(xpath = "//span[text()='Add Selected Product(s) to Order']")
    WebElement addProductToOrderLink;
    @FindBy(id = "p_method_cashondelivery")
    WebElement cashOnDeliveryCheckBox;
    @FindBy(xpath = "//a[@onclick=\"order.loadShippingRates();return false\"]")
    WebElement getShippingMethodLink;
    @FindBy(id = "s_method_flatrate_flatrate")
    WebElement fixedRadioButton;
    @FindBy(xpath = "//*[@class=\"order-totals-bottom\"]/p[3]/button/span/span/span")
    WebElement submitOrderButton;
    @FindBy(xpath = "//span[text()='The order has been created.']" )
    WebElement createOrderSuccessMessage;
    @FindBy(xpath = "//span[text()=\"The order has been created.\"]" )
    WebElement successMessageForUpdate;
    @FindBy(xpath = "//*[@id=\"sales_order_view_tabs_order_info_content\"]/div[1]/div[2]/div/div[1]/h4")
    WebElement orderId;


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
    public void clickOnCus_CheckBox(){
        utility.waitForElementPresent(customerRowLink);
        customerRowLink.click();
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
        utility.sleep(2);
        addProductToOrderLink.click();

        Log.info("Add Products to Order Link has been clicked");
    }
    public void clickCashOnDelivery(){
        utility.waitForElementPresent(cashOnDeliveryCheckBox);
        utility.sleep(1);
        cashOnDeliveryCheckBox.click();
        utility.sleep(2);
        Log.info("Payment method Check box has been clicked");
    }
    public void clickOnGetShippingMethodLink(){
        utility.waitForElementPresent(getShippingMethodLink);
        utility.sleep(3);
        getShippingMethodLink.click();
        Log.info("get shipping method link has been clicked");
    }
    public void checkOnFixedRadioButton(){
        utility.waitForElementPresent(fixedRadioButton);
        utility.sleep(2);
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
        utility.waitForElementPresent(createOrderSuccessMessage);
        if (createOrderSuccessMessage.isDisplayed()){
            Log.info("Test Passed ,The Order Created Successfully");
            System.out.println("Test Passed,New Order Created successfully");
            return true;
        }else Log.info("Test Failed,Cannot Create Order");
        System.out.println("Test Failed.Cannot Create New Order");
        return false;
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
        clickCashOnDelivery();
        utility.sleep(2);
        clickOnGetShippingMethodLink();
        utility.sleep(2);
        checkOnFixedRadioButton();
        utility.sleep(1);
        js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,-500)");
        clickSubmitOrderButton();
    }

    public static void main(String[] args) {
        String orderFullText="Order # 3200000031 (the order confirmation email was sent)";
        int beginIndex=orderFullText.indexOf("(");
        orderFullText=orderFullText.substring(0,beginIndex-1);
        orderFullText=orderFullText.replace("Order # ","");
        System.out.println(orderFullText);
        long orderNumber=Long.parseLong(orderFullText);
        System.out.println(orderNumber);
    }
    public void createOrder(String email){
        // String team1Email=prop.getProperty("FrondEmail");
        dashboardPage=new SalesDashboardPage(driver);
        dashboardPage.goToOrderPage();
        utility.sleep(2);
        clickOnCreateOrderLink();
        utility.sleep(3);
        searchCustomerForOrder(email);
        utility.sleep(2);
        clickOnTeam1Store();
        utility.sleep(2);
        js.executeScript("window.scrollBy(0,-500)");
        clickOnAddProductsLink();
        utility.sleep(2);
        clickOnProductChekBox();
        utility.sleep(2);
        clickOnAddProductToOrderLink();
        utility.sleep(2);
        clickCashOnDelivery();
        utility.sleep(2);
        clickOnGetShippingMethodLink();
        utility.sleep(2);
        checkOnFixedRadioButton();
        utility.sleep(1);
        js = (JavascriptExecutor)driver;
        clickSubmitOrderButton();
        utility.sleep(3);
    }

    public void createNewOrder(String email){
        js = (JavascriptExecutor)driver;
        searchCustomerForOrder(email);
        utility.sleep(2);
        clickOnTeam1Store();
        utility.sleep(2);
        js.executeScript("window.scrollBy(0,-500)");
        clickOnAddProductsLink();
        utility.sleep(2);
        clickOnProductChekBox();
        utility.sleep(2);
        clickOnAddProductToOrderLink();
        utility.sleep(2);
        js.executeScript("window.scrollBy(0,-500)");

        clickCashOnDelivery();
        utility.sleep(2);
        clickOnGetShippingMethodLink();
        utility.sleep(2);
        checkOnFixedRadioButton();
        utility.sleep(1);
        clickSubmitOrderButton();
    }
    public  String orderIdGetter(){
        utility.waitForElementPresent(orderId);
        String orderNumber=orderId.getText();
        int beginIndex=orderNumber.indexOf("(");
        orderNumber=orderNumber.substring(0,beginIndex-1);
        orderNumber=orderNumber.replace("Order # ","");
        System.out.println(orderNumber);
        // long orderNumber=Long.parseLong(orderNumber);
        System.out.println("The Order Id That getted from the Order Result : "+orderNumber);
        return orderNumber;
    }


    // Define Elements For Update Orders
    @FindBy(id = "sales_order_grid_filter_real_order_id")
    WebElement orderIdSearchBox;
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
    @FindBy(xpath = "//*[@id=\"order-items_grid\"]/table/tbody/tr/td[4]/input")
    WebElement qtyNumberBox;
    @FindBy(xpath = "//span[text()=\"Update Items and Qty's\"]")
    WebElement updateItemQuantityLink;
// update Order Method
    public void enterOrderIdToSearchBox(String orderId) {
    utility.waitForElementPresent(orderIdSearchBox);
    orderIdSearchBox.clear();
    orderIdSearchBox.sendKeys(orderId);
    }

    public void selectPendingOrder(String value){
        utility.waitForElementPresent(pendingDropDownList);
        Select select=new Select(pendingDropDownList);
        select.selectByValue(value);
        clickOnSearchButton();
        utility.sleep(2);
    }
    public void clickOnOrderViewLink(){
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
    public void enterQuantityNumber(String quantityNumber){
        utility.waitForElementPresent(qtyNumberBox);
        qtyNumberBox.clear();
        qtyNumberBox.sendKeys(quantityNumber);
    }public void clickOnUpdateItemQuantityLink(){
        utility.waitForElementPresent(updateItemQuantityLink);
        updateItemQuantityLink.click();
    }
    public void clickEditSubmitButton(){
        clickOnGetShippingMethodLink();
        utility.sleep(2);
        checkOnFixedRadioButton();
        utility.sleep(1);
        js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
        clickSubmitOrderButton();
        Log.info("Submit Order button has been clicked");

    }
    public boolean isOrderUpdatedSuccessfully(){
        utility.waitForElementPresent(successMessageForUpdate);
        if (successMessageForUpdate.isDisplayed()){
            System.out.println("Test Passed , The Order Updated Successfully");
            return true;
        }else System.out.println("Update Order Test Failed");
        return false;
    }
    public void updateOrder(String orderId){
        dashboardPage=new SalesDashboardPage(driver);
        dashboardPage.goToOrderPage();
        utility.sleep(2);
        enterOrderIdToSearchBox(orderId);
        clickOnSearchButton();
        utility.sleep(2);
        clickOnOrderViewLink();
        clickEditButton();
        Alert alert=driver.switchTo().alert();
        utility.waitForAlertPresent();
        alert.accept();
        enterQuantityNumber("2");
        clickOnUpdateItemQuantityLink();
        utility.sleep(2);
        clickCashOnDelivery();
        utility.sleep(2);
        clickOnGetShippingMethodLink();
        utility.sleep(2);
        checkOnFixedRadioButton();
        utility.sleep(1);
        js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,-500)");
        clickSubmitOrderButton();
    }
    public void updateExistingOrder(String orderId){
        enterOrderIdToSearchBox(orderId);
        clickOnSearchButton();
        utility.sleep(2);
        clickOnOrderViewLink();
        clickEditButton();
        enterQuantityNumber("2");
        clickOnUpdateItemQuantityLink();
        utility.sleep(2);
        clickCashOnDelivery();
        utility.sleep(2);
        clickOnGetShippingMethodLink();
        utility.sleep(2);
        checkOnFixedRadioButton();
        utility.sleep(2);
        js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,-500)");
        clickSubmitOrderButton();
        utility.sleep(3);
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
    public boolean cancelOrderSuccessfully(){
        utility.waitForElementPresent(cancelSuccessMessage);
       if (cancelSuccessMessage.isDisplayed()){
           Log.info("1 Order successfully canceled");
           System.out.println("Test Passed,Order Canceled successfully");
           return true;
       }else System.out.println("Test failed. cancel order test failed ");

        return false;
    }
    public void cancelOrder(String orderId){
        enterOrderIdToSearchBox(orderId);
        clickOnSearchButton();
        utility.sleep(2);
        clickOrderCheckBox();
        selectCancel("cancel_order");
        clickOnCancelSubmitButton();
        utility.sleep(2);
    }
    public void deleteOrder(String orderId){
        dashboardPage=new SalesDashboardPage(driver);
        dashboardPage.goToOrderPage();
        utility.sleep(2);
        enterOrderIdToSearchBox(orderId);
        clickOnSearchButton();
        utility.sleep(2);
        clickOrderCheckBox();
        selectCancel("cancel_order");
        clickOnCancelSubmitButton();
        utility.sleep(2);
    }




}
