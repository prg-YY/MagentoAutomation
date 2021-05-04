package com.seleniummaster.magento.backendpages.customerpages;
//Customer Manager can assign a customer to a Customer Group in the Actions on the All Customer page


import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewCustomerGroupPage {
    WebDriver driver;
    TestUtility utility;

    //@FindBys(
            //@FindBy(xpath = "//*[@id=\"customerGrid_table\"]/tbody/tr")
    //)
    //List<WebElement> customersList;

    //@FindBy(name = "limit")
    //WebElement viewLimit;

    @FindBy(xpath = "//input[@type=\"text\"and@id=\"customerGrid_filter_name\"]")
    WebElement FirstNameTextBox;

    @FindBy(id = "customerGrid_massaction-select")
    WebElement actionsDropdownList;

    @FindBy(id = "visibility")
    WebElement groupDropdownList;

    @FindBy(xpath = "//button[@title='Submit']")
    WebElement actionsSubmitButton;
    @FindBy(xpath = "//span[text()='Total of 1 record(s) were updated.']")
    WebElement assignSuccessfulMessage;
    //for delete customer
    @FindBy(xpath ="//input[@name='email']")
    WebElement emailSearchField;
    @FindBy(xpath = "//span[text()='Search']")
    WebElement searchButton;
    @FindBy(xpath = "//input[@type='checkbox']")  ////input[@type='checkbox']
    WebElement checkBox;
    @FindBy(xpath = "//span[text()='Total of 1 record(s) were deleted.']")
    WebElement deleteCustomerSuccessMessage;

    public ManageCustomersPage() {
        PageFactory.initElements(driver, this);
    }
    public void selectParticularCustomer(String emailAddress) {
        utility.waitForElementClickable(viewLimit);
        Select viewLimitDrp = new Select(viewLimit);
        viewLimitDrp.selectByValue("200");
        utility.sleep(3);
        System.out.println(customersList.size());
        if (customersList.size() > 0) {
            for (int i = 1; i <= customersList.size(); i++) {
                WebElement email = driver.findElement(By.xpath("//*[@id='customerGrid_table']/tbody/tr[" + i + "]/td[4]"));
                if (email.getText().equals(emailAddress)) {
                    WebElement checkbox = driver.findElement(By.xpath("//*[@id='customerGrid_table']/tbody/tr[" + i + "]/td[1]/input"));
                    checkbox.click();
                }
            }
        }

    }

    public void assignToGroup(String groupName) {
        utility.waitForElementClickable(actionsDropdownList);
        Select actionDrp = new Select(actionsDropdownList);
        actionDrp.selectByVisibleText("Assign a Customer Group");
        utility.waitForElementClickable(groupDropdownList);
        Select groupDrp = new Select(groupDropdownList);
        groupDrp.selectByVisibleText(groupName);
        utility.waitForElementClickable(actionsSubmitButton);
        actionsSubmitButton.click();
    }

    public boolean verifyAssignToGroup() {
        utility.waitForElementPresent(assignSuccessfulMessage);
        return assignSuccessfulMessage.isDisplayed();
    }
    public void searchCustomerByEmail(String email){
        utility.waitForElementPresent(emailSearchField);
        emailSearchField.sendKeys(email);
        utility.waitForElementPresent(searchButton);
        searchButton.click();
    }
    public void clickCheckBoxForSearchedCustomer(){
        utility.waitForElementPresent(checkBox);
        checkBox.click();
    }
    public void selectFromActionsDropdownList(String option){
        Select select=new Select(actionsDropdownList);
        utility.waitForElementPresent(actionsDropdownList);
        select.selectByVisibleText(option);
    }
    public boolean verifySuccessDeleteMessage(){
        utility.waitForElementPresent(deleteCustomerSuccessMessage);
        return deleteCustomerSuccessMessage.isDisplayed();
    }
    public void deleteCustomer(){
        searchCustomerByEmail("tag1@gmail.com");
        utility.sleep(2);
        clickCheckBoxForSearchedCustomer();
        selectFromActionsDropdownList("Delete");
        actionsSubmitButton.click();
        utility.alertAccept();
    }
}