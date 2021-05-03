package com.seleniummaster.magento.backendpages.customerpages;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UpdateCustomerGroupPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    @FindBy(xpath = "//*[@id=\"nav\"]/li/ul/li[2]/a/span")
    WebElement customerGroupLink;
    @FindBy(xpath = "//button[@id=\"id_b9ba7e3d7b5f91d9347642f07c7a0de4\"]/span")
    WebElement addCustomerGroupLink;
    @FindBy(id = "customer_group_code")
    WebElement cus_GroupNameField;
    @FindBy(id = "tax_class_id")
    WebElement taxClassSelection;
    @FindBy(xpath = "//*[@id=\"id_bdbbe1648a0ed3b91db8acc3ee91fe3f\"]/span/span/span")
    WebElement saveCustomerGroup;
    @FindBy(xpath = "//*[@id=\"messages\"]/ul/li")
    WebElement successMessage;


    //combine driver


    public UpdateCustomerGroupPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }

    //method for each action
    public void clickOnCustomerGroupLink(){
        utility.waitForElementPresent(customerGroupLink);
        customerGroupLink.click();
    }
    public void clickOnAddCustomerGroup(){
        utility.waitForElementPresent(addCustomerGroupLink);
        addCustomerGroupLink.click();
    }
    public void enterCustomerName(String groupName){
        utility.waitForElementPresent(cus_GroupNameField);
        cus_GroupNameField.sendKeys(groupName);
    }
    public void taxClassSelection(){
        utility.waitForElementPresent(taxClassSelection);
        Select selectGeneral=new Select(taxClassSelection);
        selectGeneral.selectByVisibleText(TaxClassType.General.name());
    }
    public void clickOnSaveButton(){
        utility.waitForElementPresent(saveCustomerGroup);
        saveCustomerGroup.click();
    }
    public boolean successMessageDisplayed(){
        utility.waitForElementPresent(successMessage);
        return successMessage.isDisplayed();
    }
    // method for Adding Customer Group
    public void addCustomerGroup(String groupName){
        clickOnCustomerGroupLink();
        clickOnAddCustomerGroup();
        enterCustomerName(groupName);
        taxClassSelection();
        clickOnSaveButton();
        successMessageDisplayed();
    }





}

