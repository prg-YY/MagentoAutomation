package com.seleniummaster.magento.backendpages.customerpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class CustomerPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    Select option;
    CustomerDashboardPage customerDashboardPage;

    public CustomerPage() {
        this.driver=TestBasePage.driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }

    /*Add customer
         Update customer
         Delete customer
         Export Customer
         Assign Customer to group
        */
 // Add Customer
    @FindBy(name = "account[firstname]")
    WebElement firstNameInputBox;
    @FindBy(name = "account[lastname]")
    WebElement lastNameInputBox;
    @FindBy(name = "account[email]")
    WebElement emailInputBox;
    @FindBy(name = "account[password]")
    WebElement passwordInputBox;
    @FindBy(xpath = "//button[@class=\"scalable save\"]")
    WebElement saveCustomerLink;
    @FindBy(xpath = "//div[@id=\"messages\"]/ul/li/ul/li/span")
    WebElement successMessage;
// Update Customer
    @FindBy(xpath = "//*[@id=\"customerGrid_table\"]/tbody/tr[1]/td[12]/a")
    WebElement editLink;
    @FindBy(xpath = "(//span[text()='Account Information'])[1]")
    WebElement accountInformationLink;
    @FindBy(xpath = "//input[@name='account[taxvat]']")
    WebElement TaxVatNumberTextField;
    @FindBy(id = "_accountnew_password")
    WebElement newPasswordTextField;
    @FindBy(id = "_accountcurrent_password")
    WebElement currentPasswordTextFiled;
    @FindBy(xpath = "(//span[text()='Save Customer'])[1]")
    WebElement saveCustomerButton;
    @FindBy(xpath = "//span[contains(text(),'The customer has been saved.')]")
    WebElement SuccessMessage;
//delete customer
    @FindBy(id = "customerGrid_filter_email")
    WebElement emailSearchBox;
    @FindBy(xpath = "//*[@class=\"massaction-checkbox\"][1]")
    WebElement customerCheckBox;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;
    @FindBy(id= "customerGrid_massaction-select")
    WebElement actionDropDownList;
    @FindBy(xpath = "//span[text()='Submit']")
    WebElement submitButton;
    @FindBy(xpath = "//div[@id='messages']/ul")
    WebElement deleteSuccessMessage;
//Export Customers
    @FindBy(id = "customerGrid_export")
    WebElement exportTo;
    @FindBy(id = "customerGrid_export")
    WebElement fileFormatOption;
    @FindBy(xpath = "//span[text()='Export']")
    WebElement exportButton;
//Assign Customer to Group
    @FindBy(id = "visibility")
    WebElement groupDropDownList;
    @FindBy(xpath = "//span[text()='Total of 1 record(s) were updated.']")
    WebElement assignSuccessMessage;



// Add customer method
    public void enterFirstName(){
        utility.waitForElementPresent(firstNameInputBox);
        firstNameInputBox.sendKeys(prop.getProperty("yusufFirstName"));
        Log.info("First name has entered");
    }
    public void enterLastName(){
        utility.waitForElementPresent(lastNameInputBox);
        lastNameInputBox.sendKeys(prop.getProperty("yusufLastName"));
        Log.info("Last name has entered ");
    }
    public void enterEmail(String email){
        utility.waitForElementPresent(emailInputBox);
        emailInputBox.sendKeys(email);
        Log.info("email has entered ");
    }
    public void enterPassword(){
        utility.waitForElementPresent(passwordInputBox);
        passwordInputBox.sendKeys(prop.getProperty("password"));
        Log.info("password has entered ");
    }
    public void clickOnAccountInformationLink(){
        utility.waitForElementPresent(accountInformationLink);
        accountInformationLink.click();
    }
    public void clickSaveCustomerLink(){
        utility.waitForElementPresent(saveCustomerLink);
        saveCustomerLink.click();
        Log.info("Save customer link clicked");
    }
    public boolean newCustomerAddedSuccessfully(){
        utility.waitForElementPresent(successMessage);
       if (successMessage.isDisplayed()){
           System.out.println("Test Passed ; A New Customer created Successfully");
           return true;
       }else System.out.println("Test Failed, add customer test failed");
       return false;
    }
    public void addNewCustomer(String email){
        customerDashboardPage=new CustomerDashboardPage(driver);
        customerDashboardPage.clickAddNewCustomerButton();
        utility.sleep(1);
        enterFirstName();
        utility.sleep(1);
        enterLastName();
        utility.sleep(2);
        enterEmail(email);
        utility.sleep(1);
        enterPassword();
        utility.sleep(1);
        clickSaveCustomerLink();
        utility.sleep(2);
    }


//update customer Method
    public void clickEditLink() {
        utility.waitForElementPresent(editLink);
        editLink.click();
    }
    public void clickWithJSAccountLink() {
        utility.waitForElementPresent(accountInformationLink);

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", accountInformationLink);
        } catch (NoSuchElementException e) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
        }
    }

    String TaxVatNum = prop.getProperty("TaxVatNum");

    public void typeTaxVat() {
        utility.waitForElementPresent(TaxVatNumberTextField);
        TaxVatNumberTextField.clear();
        utility.sleep(1);
        TaxVatNumberTextField.sendKeys(TaxVatNum);
        utility.sleep(1);
    }
    public void enterNewPassword(String newPassword){
        utility.waitForElementPresent(newPasswordTextField);
        newPasswordTextField.sendKeys(newPassword);
    }
    public void enterCurrentPassword(String currentPassword){
        utility.waitForElementPresent(currentPasswordTextFiled);
        currentPasswordTextFiled.sendKeys(currentPassword);
    }


    public void clickSaveCustomerButton() {
        utility.waitForElementPresent(saveCustomerButton);
        saveCustomerButton.click();
    }

    public boolean customerSavedSuccessfully() {
        utility.waitForElementPresent(SuccessMessage);
        if (SuccessMessage.isDisplayed()){
            System.out.println("Test Passed, The Customer Updated Successfully");
            return true;
        }else System.out.println("Test Failed, Update customer test failed");
        return false;
    }
    public void defineCustomer(String email){
        enterEmailToSearchBox(email);
        clickOnSearchButton();
        utility.sleep(2);
        clickEditLink();
        utility.sleep(2);
    }

    public void updateCustomer(String cus_Email) {
        enterEmailToSearchBox(cus_Email);
        clickOnSearchButton();
        utility.sleep(2);
        clickEditLink();
        utility.sleep(2);
        clickWithJSAccountLink();
        typeTaxVat();
        clickSaveCustomerButton();
        utility.sleep(2);
        customerSavedSuccessfully();
    }
    public void resetCustomerPassword(String customerEmail,String newPassword,String currentPassword){
        enterEmailToSearchBox(customerEmail);
        clickOnSearchButton();
        utility.sleep(2);
        clickEditLink();
        utility.sleep(2);
       // clickOnAccountInformationLink();
        clickWithJSAccountLink();
        utility.sleep(2);
        enterNewPassword(newPassword);
        enterCurrentPassword(currentPassword);
        clickSaveCustomerLink();
        utility.sleep(2);
        customerSavedSuccessfully();
    }
    public boolean customerUpdatedSuccessfully(){
        utility.waitForElementPresent(successMessage);
        if (successMessage.isDisplayed()){
            System.out.println("Test Passed ; Customer Updated Successfully");
            return true;
        }else System.out.println("Test Failed, update customer test failed");
        return false;
    }


//Delete Customer method
    public void enterEmailToSearchBox(String email){
        utility.waitForElementPresent(emailSearchBox);
        emailSearchBox.clear();
        emailSearchBox.sendKeys(email);
        Log.info("Customer Email has been entered for searching");
    }
    public void clickOnSearchButton(){
        utility.waitForElementPresent(searchButton);
        searchButton.click();
    }
    public void clickOnCustomerCheckBox(){
        utility.waitForElementPresent(customerCheckBox);
        customerCheckBox.click();
        Log.info("Customer check box has been clicked");
    }
    public void clickSubmitButton(){
        utility.waitForElementPresent(submitButton);
        submitButton.click();
        Log.info("Submit button has been clicked");
    }

    public void deleteCustomer(String cus_Email){
        enterEmailToSearchBox(cus_Email);
        clickOnSearchButton();
        utility.sleep(3);
        clickOnCustomerCheckBox();
        utility.sleep(2);
        option=new Select(actionDropDownList);
        option.selectByValue("delete");
        clickSubmitButton();
        utility.sleep(1);
        Alert alert=driver.switchTo().alert();
        utility.waitForAlertPresent();
        alert.accept();
        System.out.println("customer has been deleted");
    }
    public boolean customerDeletedSuccessfully(){
        utility.waitForElementPresent(deleteSuccessMessage);
        if (deleteSuccessMessage.isDisplayed()){
            System.out.println("Test passed , customer deleted successfully");
            return true;
        }else System.out.println("Test failed, customer couldn't deleted ");
        return false;
    }

//Export customer list as csv file
    public void selectFileType(String type){
        utility.waitForElementPresent(fileFormatOption);
        option=new Select(fileFormatOption);
        option.selectByValue(type);
        Log.info("CSV file type has been selected");
    }
    public void clickOnExportButton(){
        utility.waitForElementPresent(exportButton);
        exportButton.click();
        Log.info("Export button has been clicked");
    }
    public void exportCustomerList(){
        clickOnExportButton();
        utility.sleep(7);
    }

    public boolean isCustomerFileExported () {

        String systemUserName= System.getProperty("user.name");
        String exportedFilePath="C:\\Users\\"+ systemUserName+"\\Downloads\\export.csv";
        File exportedFileName = new File(exportedFilePath);
        Boolean isFileExported;
        isFileExported = exportedFileName.exists();
        Boolean isExported;
        if(isFileExported)
        {
            isExported=true;
        }
        else
            isExported=false;
        return isExported;
    }

//Assign Customer to group method
    public void selectAssignAction(String actionValue ){
        utility.waitForElementPresent(actionDropDownList);
        option=new Select(actionDropDownList);
        option.selectByValue(actionValue);
       Log.info("(Assign a customer) Action is selected");
    }
    public void selectGroupForAssign(String groupValue){
        utility.waitForElementPresent(groupDropDownList);
        option=new Select(groupDropDownList);
        option.selectByValue(groupValue);
        Log.info("(Group)  is selected");
    }
    public void assignCustomerToGroup(String email,String actionValue,String groupValue){
        enterEmailToSearchBox(email);
        clickOnSearchButton();
        utility.sleep(2);
        clickOnCustomerCheckBox();
        utility.sleep(2);
        selectAssignAction(actionValue);
        utility.sleep(2);
        selectGroupForAssign(groupValue);
        utility.sleep(2);
        clickSubmitButton();
        utility.sleep(3);
    }

    public boolean customerAssignedToGroupSuccessfully(){
        utility.waitForElementPresent(assignSuccessMessage);
        if (assignSuccessMessage.isDisplayed()){
            System.out.println("Test Passed, Customer assigned to group successfully");
            return true;
        } else System.out.println("Test failed");
        return false;
    }



}
