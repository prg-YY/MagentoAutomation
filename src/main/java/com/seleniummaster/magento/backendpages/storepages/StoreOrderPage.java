package com.seleniummaster.magento.backendpages.storepages;

import com.seleniummaster.magento.backendpages.salespages.SalesDashboardPage;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class StoreOrderPage extends TestBasePage {
    WebDriver driver;
    String ConfigFile = "config.properties";
    TestUtility utility;
    SalesDashboardPage dashboardPage;
    public StoreOrderPage() {
        this.driver= TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility=new TestUtility(driver);
    }

//create Order Elements
    @FindBy(xpath = "(//span[text()=\"Create New Order\"])[1]")
    WebElement createNewOrderLink;
    @FindBy(id = "sales_order_create_customer_grid_filter_name")
    WebElement nameSearchBox;
    @FindBy(xpath = "(//span[text()=\"Search\"])[1]")
    WebElement SearchButton;
    @FindBy(xpath = "//*[@id=\"sales_order_create_customer_grid_table\"]/tbody/tr/td[2]")
    WebElement selectedCustomer;
    //*[@id="sales_order_create_customer_grid_table"]/tbody/tr/td[2]
    @FindBy(xpath = "(//input[@id=\"store_18\"])[1]")
    WebElement selectedStoreCheckBox;
    @FindBy(xpath = "//span[text()=\"Add Products\"]")
    WebElement addProductButton;
    @FindBy(xpath = "(//input[@type=\"checkbox\" and @class=\"checkbox\"])[6]")
    WebElement selectedProductCheckBox;
    @FindBy(xpath = "//span[text()=\"Add Selected Product(s) to Order\"]")
    WebElement addSelectedProductToOrderButton;
    @FindBy(xpath = "//input[@id=\"p_method_checkmo\"]")
    WebElement paymentMethodCheckBox;
    @FindBy(xpath = "//a[@onclick=\"order.loadShippingRates();return false\"]")
    WebElement getShippingMethodAndRatesLink;
    @FindBy(xpath = "//input[@onclick=\"order.setShippingMethod(this.value)\"]")
    WebElement fixedCheckBox;
    @FindBy(xpath = "(//button[@onclick=\"order.submit()\"])[1]")
    WebElement submitOrderButton;
    @FindBy(xpath ="//span[text()=\"The order has been created.\"]")
    WebElement orderSuccessfulCreatedMsg;
    //Update Order Elements
    @FindBy(id = "sales_order_grid_filter_real_order_id")
    WebElement orderIdSearchBox;
    @FindBy(xpath = "//span[text()=\"Search\"]")
    WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"sales_order_grid_table\"]/tbody/tr[1]/td[10]/a")
    WebElement orderViewLink;
    @FindBy(xpath = "sales_order_grid_filter_status")
    WebElement statusDropDown;
    @FindBy(xpath = "(//span[text()=\"Edit\"])[1]")
    WebElement editButton;
    @FindBy(xpath = "//input[@name=\"order[billing_address][company]\"]")
    WebElement companyTextField;
    @FindBy(xpath = "//*[@id=\"order-items_grid\"]/table/tbody/tr/td[4]/input")
    WebElement qtyNumberBox;
    @FindBy(xpath = "//span[text()=\"Update Items and Qty's\"]")
    WebElement updateItemQuantityLink;
//Cancel Order Elements
    @FindBy(xpath = "//*[@id=\"sales_order_grid_table\"]/tbody/tr[1]/td[1]/input")
    WebElement orderCheckBox;
    @FindBy(id = "sales_order_grid_massaction-select")
    WebElement actionDropDownList;
    @FindBy(xpath = "(//span[text()=\"Cancel\"])[2]")
    WebElement cancelButton;
    @FindBy(xpath = "//span[text()=\"Submit\"]")
    WebElement submitButton;
    @FindBy(xpath = "//span[text()='1 order(s) have been canceled.']")
    WebElement successfulCancelMsg;
    @FindBy(xpath = "//*[@id=\"sales_order_view_tabs_order_info_content\"]/div[1]/div[2]/div/div[1]/h4")
    WebElement orderId;
//Create Order Methods
    public void clickCreateNewOrderButton(){
        utility.waitForElementPresent(createNewOrderLink);
        createNewOrderLink.click();
    }
    public void EnterCustomerName(String CustomerName){
        utility.waitForElementPresent(nameSearchBox);
        nameSearchBox.sendKeys(CustomerName);
    }
    public void clickSearchButton(){
        utility.waitForElementPresent(SearchButton);
        utility.sleep(2);
        SearchButton.click();
    }
    public void clickSelectedCustomer(){
        utility.waitForElementPresent(selectedCustomer);
      utility.sleep(2);
        selectedCustomer.click();
    }
    public void clickSelectedStore(){
        utility.waitForElementPresent(selectedStoreCheckBox);
        try {
            selectedStoreCheckBox.click();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
    public void clickAddProductButton(){
        utility.waitForElementPresent(addProductButton);
        try {
            utility.sleep(3);
            addProductButton.click();
        } catch (ElementClickInterceptedException e) {
            e.printStackTrace();
        }
    }
    public void clickSelectedProductCheckBox(){
        utility.waitForElementPresent(selectedProductCheckBox);
        selectedProductCheckBox.click();
    }
    public void clickAddSelectedProductToOrderButton(){
        utility.waitForElementPresent(addSelectedProductToOrderButton);
        addSelectedProductToOrderButton.click();
    }
    public void clickPaymentMethod(){
        utility.waitForElementPresent(paymentMethodCheckBox);
        paymentMethodCheckBox.click();
    }
    public void clickGetShippingMethodAndRateLink(){
        utility.waitForElementPresent(getShippingMethodAndRatesLink);
        getShippingMethodAndRatesLink.click();
    }
    public void clickFixCheckBox(){
        utility.waitForElementPresent(fixedCheckBox);
        fixedCheckBox.click();
    }
    public void clickSubmitOrderButton(){
        utility.waitForElementPresent(submitOrderButton);
        try {
            submitOrderButton.click();
        } catch (ElementClickInterceptedException e) {
            e.printStackTrace();
        }
    }
    public boolean creteOrderSuccessfully(){
        utility.waitForElementPresent(orderSuccessfulCreatedMsg);
        if (orderSuccessfulCreatedMsg.isDisplayed()) {
            Log.info("The order has been created");
            System.out.println("New Order Created Successfully");
            return true;
        }else
            Log.info("test failed");
        System.out.println("Test Failed,Cannot Create New Order");
        return false;
    }
    public void createOrder(){
        clickCreateNewOrderButton();
        EnterCustomerName(prop.getProperty("CustomerName"));
        clickSearchButton();
        clickSelectedCustomer();
        clickSelectedStore();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)");
        clickAddProductButton();
        clickSelectedProductCheckBox();
        clickAddSelectedProductToOrderButton();
        clickPaymentMethod();
        clickGetShippingMethodAndRateLink();
        clickFixCheckBox();
        clickSubmitOrderButton();
    }
    public void createNewOrder(String customerName){
        dashboardPage=new SalesDashboardPage(driver);
        dashboardPage.goToOrderPage();
        clickCreateNewOrderButton();
        EnterCustomerName(customerName);
        clickSearchButton();
        utility.sleep(2);
        clickSelectedCustomer();
        clickSelectedStore();
        utility.sleep(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)");
        clickAddProductButton();
        utility.sleep(2);
        clickSelectedProductCheckBox();
        clickAddSelectedProductToOrderButton();
        utility.sleep(2);
        clickPaymentMethod();
        utility.sleep(1);
        clickGetShippingMethodAndRateLink();
        utility.sleep(2);
        clickFixCheckBox();
        clickSubmitOrderButton();
        utility.sleep(2);
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
    //Update Order Methods
    public void enterOrderIdToSearchBox(String orderId){
        utility.waitForElementPresent(orderIdSearchBox);
        orderIdSearchBox.clear();
        orderIdSearchBox.sendKeys(orderId);
    }
    public void clickOnSearchButton(){
        utility.waitForElementPresent(searchButton);
        searchButton.click();
    }
    public void clickOnOrderViewLink(){
        utility.waitForElementPresent(orderViewLink);
        orderViewLink.click();
    }
    public void clickOnEditButton(){
        utility.waitForElementPresent(editButton);
        editButton.click();
    }
    public void enterQuantityNumber(String quantityNumber){
        utility.waitForElementPresent(qtyNumberBox);
        qtyNumberBox.clear();
        qtyNumberBox.sendKeys(quantityNumber);
    }public void clickOnUpdateItemQuantityLink(){
        utility.waitForElementPresent(updateItemQuantityLink);
        updateItemQuantityLink.click();
    }
    public void enterCompanyName(String companyName){
        utility.waitForElementPresent(companyTextField);
        companyTextField.sendKeys(companyName);
    }
    public void defineOrderToUpdate(String orderNumber){
        enterOrderIdToSearchBox(orderNumber);
        clickOnSearchButton();
        utility.sleep(2);
        clickOnOrderViewLink();
        utility.sleep(2);
    }
    public boolean updateOrderSuccessfully(){
        utility.waitForElementPresent(orderSuccessfulCreatedMsg);
        if (orderSuccessfulCreatedMsg.isDisplayed()) {
            Log.info("The order has been created");
            System.out.println("New Order Created Successfully");
            return true;
        }else
            Log.info("test failed");
        System.out.println("Test Failed,Cannot Create New Order");
        return false;
    }
    public void updateOrder(String orderNumber){
        dashboardPage=new SalesDashboardPage(driver);
        dashboardPage.goToOrderPage();
        defineOrderToUpdate(orderNumber);
        clickOnEditButton();
        Alert alert=driver.switchTo().alert();
        utility.waitForAlertPresent();
        alert.accept();
        utility.sleep(2);
        enterQuantityNumber("2");
        clickOnUpdateItemQuantityLink();
        utility.sleep(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)");
        clickPaymentMethod();
        utility.sleep(2);
        clickGetShippingMethodAndRateLink();
        utility.sleep(2);
        clickFixCheckBox();
        utility.sleep(2);
        clickSubmitOrderButton();
        utility.sleep(2);

    }
    //Cancel Order Methods
    public void clickOnOrderCheckBox(){
        utility.waitForElementPresent(orderCheckBox);
        orderCheckBox.click();
    }
    public void selectCancelFromAction(){
        utility.waitForElementPresent(actionDropDownList);
        Select option=new Select(actionDropDownList);
        option.selectByValue("cancel_order");
    }
    public void clickOnSubmitButton(){
        utility.waitForElementPresent(submitButton);
        submitButton.click();
    }
    public void defineOrderToCancel(String orderNumber){
        enterOrderIdToSearchBox(orderNumber);
        clickOnSearchButton();
        utility.sleep(2);
        clickOnOrderCheckBox();
        utility.sleep(1);
    }
    public boolean cancelOrderSuccessfully(){
        utility.waitForElementPresent(successfulCancelMsg);
        if (successfulCancelMsg.isDisplayed()) {
            Log.info("The order has been canceled");
            System.out.println("Order Canceled Successfully");
            return true;
        }else
            Log.info("test failed");
        System.out.println("Test Failed,Cannot cancel Order");
        return false;
    }
    public void cancelOrder(String orderId){
        dashboardPage=new SalesDashboardPage(driver);
        dashboardPage.goToOrderPage();
        defineOrderToCancel(orderId);
        selectCancelFromAction();
        clickOnSubmitButton();
        utility.sleep(2);
    }
}
