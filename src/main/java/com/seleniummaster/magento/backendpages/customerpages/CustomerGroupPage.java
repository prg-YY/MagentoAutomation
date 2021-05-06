package com.seleniummaster.magento.backendpages.customerpages;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
//Customer Manager can assign a customer to a Customer Group in the Action on the All Customer page

public class CustomerGroupPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;

    @FindBy(xpath = "//input[@type=\"text\"and@id=\"customerGrid_filter_name\"]")
    WebElement EnterCustomerNameTextBox;

    //Click on Search Button
    @FindBy(xpath = "//button[@title='Search']")
    WebElement SearchButton;

    @FindBy(css = ".massaction-checkbox")
    WebElement Checkbox;

    @FindBy(id = "customerGrid_massaction-select")
    WebElement ActionsDropdownList;

    @FindBy(css = "#visibility")
    WebElement GroupDropdownList;

    @FindBy(xpath = "//button[@title='Submit']")
    WebElement ActionsSubmitButton;

    public CustomerGroupPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }

    //Enter CustomerName Method
    public void EnterCustomerName(String Name){
        utility.waitForElementPresent(EnterCustomerNameTextBox);
        EnterCustomerNameTextBox.sendKeys(Name);
    }

    //ActionSearchButton
    public void ClickSearchButton(){
        utility.waitForElementPresent(SearchButton);
        SearchButton.click();
    }

    //Click on checkbox
    public void ClickCheckboxForSearchedCustomer(){
        utility.waitForElementPresent(Checkbox);
        Checkbox.click();
    }

    //Select From "Actions" DropdownList
    public void SelectFromActionsDropdownList(String option){
        Select select=new Select(ActionsDropdownList);
        utility.waitForElementPresent(ActionsDropdownList);
        select.selectByVisibleText(option);
    }

    //Select From "Group" Dropdown List
    public void SelectFromGroupDropDownList(String option){
        Select select= new Select(GroupDropdownList);
        utility.waitForElementPresent(GroupDropdownList);
        select.selectByVisibleText(option);

    }





}
