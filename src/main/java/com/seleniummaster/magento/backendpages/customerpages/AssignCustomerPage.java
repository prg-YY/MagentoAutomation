package com.seleniummaster.magento.backendpages.customerpages;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Customer Manager can assign a customer to a Customer Group in the Action on the All Customer page
public class AssignCustomerPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;

    @FindBy(xpath = "//input[@type='checkbox'and@value='83']")
    WebElement customerCheckBox;
    @FindBy(xpath = "//select[@class='required-entry select absolute-advice local-validation']")
    WebElement assignCustomerGroup;

    @FindBy(xpath = "//span[@class='outer-span'and@id='customerGrid_massaction-form-additional']")
    WebElement groupList;

    @FindBy(xpath = "//button[@id='id_9238536289893cf2303e62fa4c9ba589']")
    WebElement submitButton;

    @FindBy(xpath = "//li[@class='success-msg']")
    WebElement successMessage;

    public AssignCustomerPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }
    //write method for each action
    public void clickCheckBoxForSelectedCustomer(){
        utility.waitForElementPresent(customerCheckBox);
        customerCheckBox.click();

    }
    public void SelectAssignACustomerGroup(){
        utility.waitForElementPresent(assignCustomerGroup);
        assignCustomerGroup.isSelected();
    }
    public void SelectGroup(){
        utility.waitForElementPresent(groupList);
        groupList.click();
    }
    public void ClickOnSubmitButton(){
        utility.waitForElementPresent(submitButton);
        submitButton.click();
    }
    public boolean VerifySuccessMassage(){
        utility.waitForElementPresent(successMessage);
        return successMessage.isDisplayed();
    }

    public boolean assignCustomerToCustomerGroup(){
        clickCheckBoxForSelectedCustomer();
        SelectAssignACustomerGroup();
        SelectGroup();
        ClickOnSubmitButton();
        VerifySuccessMassage();
        return true;

    }
}

