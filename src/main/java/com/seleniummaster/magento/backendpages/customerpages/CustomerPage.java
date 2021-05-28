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
    CustomerDashboardPage customerDashboardPage;

// For Add Customer
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
    WebElement selectAction;
    @FindBy(xpath = "//span[text()='Submit']")
    WebElement submitButton;
    @FindBy(xpath = "//div[@id='messages']/ul")
    WebElement deleteSuccessMessage;
//Export Customers



    public CustomerPage(WebDriver driver) {
        this.driver=TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility=new TestUtility(driver);
    }

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
    public void enterEmail(){
        utility.waitForElementPresent(emailInputBox);
        emailInputBox.sendKeys(prop.getProperty("cus_Email"));
        Log.info("email has entered ");
    }
    public void enterPassword(){
        utility.waitForElementPresent(passwordInputBox);
        passwordInputBox.sendKeys(prop.getProperty("password"));
        Log.info("password has entered ");
    }
    public void clickSaveCustomerLink(){
        utility.waitForElementPresent(saveCustomerLink);
        saveCustomerLink.click();
        Log.info("Save customer link clicked");
    }
    public boolean verifySuccessMessage(){
        utility.waitForElementPresent(successMessage);
        return successMessage.isDisplayed();
    }
    public void addNewCustomer(){
        customerDashboardPage=new CustomerDashboardPage(driver);
        customerDashboardPage.clickAddNewCustomerButton();
        utility.sleep(1);
        enterFirstName();
        utility.sleep(1);
        enterLastName();
        utility.sleep(2);
        enterEmail();
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

    public void clickSaveCustomerButton() {
        utility.waitForElementPresent(saveCustomerButton);
        utility.sleep(2);
        saveCustomerButton.click();
    }

    public boolean displaySuccessMessage() {
        utility.waitForElementPresent(SuccessMessage);
        return SuccessMessage.isDisplayed();

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
        displaySuccessMessage();
    }


//Delete Customer method
    public void enterEmailToSearchBox(String email){
        utility.waitForElementPresent(emailSearchBox);
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
        utility.sleep(2);
        clickOnCustomerCheckBox();
        utility.sleep(1);
        Select option=new Select(driver.findElement(By.id("customerGrid_massaction-select")));
        option.selectByValue("delete");
        clickSubmitButton();
        Alert alert=driver.switchTo().alert();
        utility.waitForAlertPresent();
        alert.accept();
        System.out.println("customer has been deleted");
    }
    public boolean customerDeletedSuccessfully(){
        utility.waitForElementPresent(deleteSuccessMessage);
        if (deleteSuccessMessage.isDisplayed()){
            System.out.println("Test passed , customer has been deleted");
        }else System.out.println("Test failed ");
        return true;
    }

    //Export customer list as csv file

    @FindBy(id = "customerGrid_export")
    WebElement exportTo;
    @FindBy(id = "customerGrid_export")
    WebElement fileFormatOption;
    @FindBy(xpath = "//span[text()='Export']")
    WebElement exportButton;

    public void selectFileType(String type){
        utility.waitForElementPresent(fileFormatOption);
        Select option=new Select(fileFormatOption);
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

}
