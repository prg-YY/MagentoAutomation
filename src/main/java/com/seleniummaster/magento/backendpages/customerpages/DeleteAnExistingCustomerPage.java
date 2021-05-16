package com.seleniummaster.magento.backendpages.customerpages;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DeleteAnExistingCustomerPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    // elements for add customer
   @FindBy(xpath= "//span[text()='Add New Customer']")
    WebElement addNewCustomersLink;
   //click on cutomer link
    @FindBy(name = "account[firstname]")
    WebElement firstNameTextField;
    @FindBy(name = "account[lastname]")
    WebElement lastNamefield;
    @FindBy(name ="account[email]")
    WebElement emailAddressField;
    @FindBy(name = "account[password]")
    WebElement passwordTextFeild;
    @FindBy(xpath = "//span[text()='Save Customer']")
    WebElement saveCustomerButton;
    @FindBy(xpath = "//*[@class=\"success-msg\"]")
    WebElement successMessage;
    //element for delete customer
    @FindBy(xpath = "//*[@class=\"massaction-checkbox\"]")
    WebElement customerCheckBox;
    @FindBy(id= "customerGrid_massaction-select")
    WebElement selectAction;
   // @FindBy(xpath = "//id[@class/='delete'']")
    //WebElement selectDelete;
    @FindBy(xpath = "//button[@title=\"Submit\"]")
    WebElement submitButton;
    @FindBy(xpath = "//div[@id='messages']/ul")
    WebElement deleteSuccessMessage;

    // combine webdriver


    public DeleteAnExistingCustomerPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }
   // method for each action
    public void clickOnAddCustomerLink(){
        utility.waitForElementPresent(addNewCustomersLink);
        addNewCustomersLink.click();
    }
    // method for enter first name
    public void enterFirstName(String firstName){
        utility.waitForElementPresent(firstNameTextField);
        firstNameTextField.sendKeys(firstName);
    }
    // method for enter last name
    public void enterLastName(String lastName){
        utility.waitForElementPresent(lastNamefield);
        lastNamefield.sendKeys(lastName);
    }
    // method for email address
    public void enterEmailAddress(String emailAddress){
        utility.waitForElementPresent(emailAddressField);
        emailAddressField.sendKeys(emailAddress);
    }
    // method for password
    public void enterPassword(String  password){
        utility.waitForElementPresent(passwordTextFeild);
        passwordTextFeild.sendKeys(password);
    }
    //method for save button
    public void clickOnSaveButton(){
        utility.waitForElementPresent(saveCustomerButton);
        saveCustomerButton.click();
    }
    //method for verify
    public void successMessageIsDisplyed(){
        utility.waitForElementPresent(successMessage);
        if (successMessage.isDisplayed()){
            System.out.println("test Passed,the customer created successfully");
        }else {
            System.out.println("crate customer test failed");
        }
    }
    //method for add customers
    public boolean addCustomer(String firstName,String lastName,String email,String password){
        clickOnAddCustomerLink();
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmailAddress(email);
        enterPassword(password);
        clickOnSaveButton();
        successMessageIsDisplyed();
        return true;

    }
    // method for delete customer
    public void clicOncheckBox(){
        utility.waitForElementPresent(customerCheckBox);
        customerCheckBox.click();
    }

    // method on click submit button
    public void clickOnSubmitButton (){
        utility.waitForElementPresent(submitButton);
        submitButton.click();
    }
    //method for ok button

    //method for customer Delet Successful
    public void successMessageIsDisplayed(){
        utility.waitForElementPresent(deleteSuccessMessage);
        deleteSuccessMessage.isDisplayed();
    }
    //delete customer method
    public void deleteCustomer(String customerEmail){
        List<WebElement> customerList=driver
                .findElements(By.xpath("//div[@class=\"hor-scroll\"]/table/tbody/tr"));
        String customersEmail=driver.
                findElement(By.xpath("//div[@class=\"hor-scroll\"]/table/tbody/tr")).getText();
        for (int i=1;i<customerList.size();i++){
            if (customersEmail.contains(customerEmail)){
                clicOncheckBox();
                break;
            }
            Select select=new Select(selectAction);
            select.selectByValue("delete");
            clickOnSubmitButton();
            Alert alert=driver.switchTo().alert();
            alert.accept();
            String successfulDelete=successMessage.getText();
            if (successfulDelete.contains("Total of 1 record(s) were deleted.")){
                System.out.println("test past");
            }
            //successMessageIsDisplayed();


        }

    }

}




