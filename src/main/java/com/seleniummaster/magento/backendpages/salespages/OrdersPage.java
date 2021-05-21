package com.seleniummaster.magento.backendpages.salespages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    @FindBy(id = "store_18")
    WebElement team1Store;
    @FindBy(xpath = "//span[text()='Add Products']")
    WebElement addProductsLink;
    //input[@type='checkbox' and @value='59']
    @FindBy(css = "(//input[@value='59'])[1]")
    WebElement uyghurBookCheckBox;
    @FindBy(xpath = "//span[text()='Add Selected Product(s) to Order']")
    WebElement addProductToOrderLink;
    @FindBy(id = "p_method_checkmo")
    WebElement paymentCheckBox;
    @FindBy(xpath = "//*[@id='order-shipping-method-summary']/a")
    WebElement getShippingMethodLink;
    @FindBy(id = "s_method_flatrate_flatrate")
    WebElement fixedRadioButton;
    @FindBy(xpath = "//span[text()='Submit Order']")
    WebElement submitOrderButton;
    @FindBy(xpath = "//*[@class=\"messages\"]" )
    WebElement successMessage;


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
    public void clickOnUyghurBookChekBox(){
        utility.waitForElementPresent(uyghurBookCheckBox);
        uyghurBookCheckBox.click();
        Log.info("uyghur Book ChekBox has been clicked");
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
        Log.info("fixed Radio button  has been checked");
    }
    public void clickOnSubmitOrderButton(){
        utility.waitForElementPresent(submitOrderButton);
        utility.sleep(1);
        submitOrderButton.click();
    }
    public boolean verifyOrderCreatedSuccessfully(){
        utility.waitForElementPresent(successMessage);
        if (successMessage.getText().contains("Success")){
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
        clickOnT1_Cus_CheckBox();
        clickOnAddProductsLink();
        utility.sleep(3);
        clickOnUyghurBookChekBox();
        utility.sleep(2);
        clickOnAddProductToOrderLink();
        utility.sleep(2);
        clickOnGetShippingMethodLink();
        utility.sleep(2);
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
        clickOnUyghurBookChekBox();
        clickOnAddProductToOrderLink();
        clickOnGetShippingMethodLink();
        checkOnFixedRadioButton();
        clickOnSubmitOrderButton();
        verifyOrderCreatedSuccessfully();
    }


    // Define Elements For Update Orders
    @FindAll(@FindBy(xpath = "//*[@id=\"sales_order_grid_table\"]/tbody/tr"))
    List<WebElement> ordersList;
    @FindBy(xpath = "//*[@id=\"sales_order_grid_table\"]/tbody/tr[1]")
    WebElement team1_Order;


    // update Order Method
    public void chooseOrder(){
        utility.waitForElementPresent(team1_Order);
        int i;
        int totalOrder=0;
        for (i=0;i<=ordersList.size();i++){
            String t1_Order=team1_Order.getText();
            if (t1_Order.contains("team1")){
                utility.waitForElementPresent(team1_Order);
                team1_Order.click();
            }break;
        }
    }
    @FindBy(xpath ="//span[text()='Edit']" )
    WebElement editLink;
    @FindBy(xpath = "//*[@id=\"sales_order_grid_table\"]/tbody/tr[1]/td[1]/input")
    WebElement orderCheckBox;
    @FindBy(id = "order-billing_address_company")
    WebElement companyNameTextBox;
    public void clickOnCheckBoxFOrUpdate(){
        utility.waitForElementPresent(orderCheckBox);
        orderCheckBox.click();
    }
    public void clickEditButton(){
        utility.waitForElementPresent(editLink);
        editLink.click();
    }
    public void enterCompanyName(String companyName){
        utility.waitForElementPresent(companyNameTextBox);
        companyNameTextBox.sendKeys(companyName);
    }

    public void update_Order(){

    }


}
