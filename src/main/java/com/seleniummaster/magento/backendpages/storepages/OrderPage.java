package com.seleniummaster.magento.backendpages.storepages;

import com.google.protobuf.ExperimentalApi;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderPage extends TestBasePage{

    WebDriver driver;
    String ConfigFile = "config.properties";
    TestUtility utility;
    @FindBy (xpath = "(//span[text()=\"Create New Order\"])[1]")
    WebElement CreateNewOrderButton;
    @FindBy(xpath = "(//input[@id=\"sales_order_create_customer_grid_filter_name\"])[1]")
    WebElement NameTextField;
    @FindBy(xpath = "(//span[text()=\"Search\"])[1]")
    WebElement SearchButton;
    ////div[@class="hor-scroll"]/table/tbody/tr/td
    @FindBy(xpath = "//*[@id=\"sales_order_create_customer_grid_table\"]/tbody/tr/td[2]")
    WebElement selectedCustomer;
    //*[@id="sales_order_create_customer_grid_table"]/tbody/tr/td[2]
    @FindBy(xpath = "(//input[@id=\"store_18\"])[1]")
    WebElement selectedStoreCheckBox;
    @FindBy(xpath = "//span[text()=\"Add Products\"]")
    WebElement AddProductButton;
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
    WebElement OrderSuccessfulCreatedMsg;
//Update Order Elements
    @FindBy(id = "sales_order_grid_filter_real_order_id")
    WebElement orderIdSearchBox;
    @FindBy(xpath = "//span[text()=\"Search\"]")
    WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"sales_order_grid_table\"]/tbody/tr[1]/td[10]/a")
    WebElement orderViewLink;
    @FindBy(xpath = "sales_order_grid_filter_status")
    WebElement statusDropDown;
    @FindBy(xpath = "//*[@id=\"sales_order_grid_table\"]/tbody/tr[1]/td[10]/a")
    WebElement SelectDropdownList;
    @FindBy(xpath = "//select[@name=\"status\"]")
    WebElement statusDropDownList;
    @FindBy(xpath = "(//a[text()=\"View\"])[1]")
    WebElement FirstViewLink;
    @FindBy(xpath = "(//span[text()=\"Edit\"])[1]")
    WebElement editButton;
    @FindBy(xpath = "//input[@name=\"order[billing_address][company]\"]")
    WebElement companyTextField;
//Cancel Order Elements
    @FindBy(xpath = "//*[@id=\"sales_order_grid_table\"]/tbody/tr[1]/td[1]/input")
    WebElement orderCheckBox;
    @FindBy(id = "sales_order_grid_massaction-select")
    WebElement actionDropDownList;
    @FindBy(xpath = "(//span[text()=\"Cancel\"])[2]")
    WebElement cancelButton;
    @FindBy(xpath = "//span[text()=\"Submit\"]")
    WebElement submitButton;
    @FindBy(xpath = "//span[text()=\"The order has been cancelled.\"]")
    WebElement successfulCancelMsg;
    @FindBy(xpath = "//*[@id=\"sales_order_view_tabs_order_info_content\"]/div[1]/div[2]/div/div[1]/h4")
    WebElement orderId;
    public OrderPage(WebDriver driver){
        this.driver= TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility=new TestUtility(driver);
    }
    //Store Manager can create a new order
    public void clickCreateNewOrderButton(){
        utility.waitForElementPresent(CreateNewOrderButton);
        CreateNewOrderButton.click();
    }
    public void EnterCustomerName(String CustomerName){
        utility.waitForElementPresent(NameTextField);
        NameTextField.sendKeys(CustomerName);
    }
    public void clickSearchButton(){
        utility.waitForElementPresent(SearchButton);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SearchButton.click();
    }
    public void clickSelectedCustomer(){
        utility.waitForElementPresent(selectedCustomer);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        utility.waitForElementPresent(AddProductButton);
        try {
        utility.sleep(3);
            AddProductButton.click();
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
    public boolean verifySuccessfulAddedMsg(){
        utility.waitForElementPresent(OrderSuccessfulCreatedMsg);
        if (OrderSuccessfulCreatedMsg.isDisplayed()) {
            Log.info("The order has been created");
            System.out.println("New Order Created Successfully");
            return true;
        }else
            Log.info("test failed");
        System.out.println("Test Failed,Cannot Create New Order");
        return false;
    }
    public void CreateNewOrder(){
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
        verifySuccessfulAddedMsg();
    }
    @FindBy(xpath = "(//span[text()=\"Invoice\"])[1]")
    WebElement invoiceButton;
    @FindBy(xpath = "//span[text()=\"Submit Invoice\"]")
    WebElement submitInvoiceButton;
    @FindBy(xpath = "(//span[text()=\"Credit Memo\"])[1]")
    WebElement creditMemoButton;
    @FindBy(xpath = "//span[text()=\"Refund Offline\"]")
    WebElement refundOfflineButton;
    @FindBy(xpath = "//span[text()=\"The credit memo has been created.\"]")
    WebElement refundSuccessfullyMsg;
    @FindBy(xpath = "(//span[text()=\"Credit Memos\"])[2]")
    WebElement creditMemosLink;
    @FindBy(xpath = "//table[@id=\"order_invoices_table\"]/tbody/tr/td[1]")
    WebElement creditMemosNo;

    public void clickInvoiceButton(){
        utility.waitForElementPresent(invoiceButton);
        invoiceButton.click();
    }
    public void clickSubmitInvoiceButton(){
        utility.waitForElementPresent(submitInvoiceButton);
        submitInvoiceButton.click();
    }
    public void clickCreditMemoButton(){
        utility.waitForElementPresent(creditMemoButton);
        creditMemoButton.click();
    }
    public void clickRefundOfflineButton(){
        utility.waitForElementPresent(refundOfflineButton);
        refundOfflineButton.click();
    }
    public boolean VerifySuccessfullyRefundMsg(){
        utility.waitForElementPresent(refundSuccessfullyMsg);
        return(refundSuccessfullyMsg.isDisplayed());
    }
    public void clickCreditMemoLink(){
        utility.waitForElementPresent(creditMemosLink);
        creditMemosLink.click();
    }
    public String CreditMemosNoGetText(){
        utility.waitForElementPresent(creditMemosNo);
        String MemoNo=creditMemosNo.getText();
        System.out.println(MemoNo);
        return MemoNo;
    }
    public void createRefund(){
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
        js.executeScript("window.scrollBy(0,500)");
        clickSubmitOrderButton();
        verifySuccessfulAddedMsg();
        clickInvoiceButton();
        utility.sleep(2);
        clickSubmitInvoiceButton();
        utility.sleep(2);
        clickCreditMemoButton();
        utility.sleep(2);
        clickRefundOfflineButton();
        utility.sleep(2);
        VerifySuccessfullyRefundMsg();
        clickCreditMemoLink();
    }
    //Store Manager can edit orders
    public void selectStore(){
        utility.waitForElementPresent(SelectDropdownList);
        Select storeDropdown=new Select(SelectDropdownList);
        storeDropdown.selectByValue("18");
    }
    public void selectStatusDropDownList(){
        utility.waitForElementPresent(statusDropDownList);
        Select statusDropDown=new Select(statusDropDownList);
        statusDropDown.selectByValue("pending");
    }
    public void clickViewLink(){
        utility.waitForElementPresent(FirstViewLink);
        FirstViewLink.click();
    }
    public void clickEditButton(){
        utility.waitForElementPresent(editButton);
        editButton.click();
    }
    public void EnterCompanyTextField(String CompanyName){
        utility.waitForElementPresent(companyTextField);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        companyTextField.clear();
        companyTextField.sendKeys(CompanyName);
    }
    public void EditOrder(){
        selectStore();
        selectStatusDropDownList();
        clickSearchButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickViewLink();
        clickEditButton();
        utility.waitForAlertPresent();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        EnterCompanyTextField(prop.getProperty("CompanyName"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickGetShippingMethodAndRateLink();
        clickFixCheckBox();
        clickSubmitOrderButton();
        verifySuccessfulAddedMsg();
    }



    //Store Manager can delete orders
    public void clickCancelButton(){
        utility.waitForElementPresent(cancelButton);
        cancelButton.click();
    }
    public boolean VerifySuccessfulCancelMsg(){
        utility.waitForElementPresent(successfulCancelMsg);
        if (successfulCancelMsg.isDisplayed()) {
            Log.info("The order has been cancelled.");
            return true;
        }else
            Log.info("test failed");
        return false;
    }
    public void CancelOrder(){
        selectStore();
        selectStatusDropDownList();
        clickSearchButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickViewLink();
        clickCancelButton();
        utility.waitForAlertPresent();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        VerifySuccessfulCancelMsg();
    }
}
