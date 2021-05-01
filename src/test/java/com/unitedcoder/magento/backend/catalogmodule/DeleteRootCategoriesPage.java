package com.unitedcoder.magento.backend.catalogmodule;

import com.unitedcoder.magento.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteRootCategoriesPage {
    WebDriver driver;
    String ConfigFile="config.properties";
    TestUtility utility;
    @FindBy(css = "#extdd-62")
    WebElement TeamOneTestCategoryLink;
    @FindBy(css = "button[title='Reset'][type='button']")
    WebElement ResetButton;
    @FindBy(css = "button[title='Delete Category']")
    WebElement DeleteCategoryLink;
    @FindBy(linkText = "The category has been deleted.")
    WebElement DeleteSuccessMessage;

    public DeleteRootCategoriesPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }
    public  void clickTeamOneTestCategoryLink(){
        utility.waitForElementPresent(TeamOneTestCategoryLink);
        TeamOneTestCategoryLink.click();
    }
    public void clickResetButton() {
        utility.waitForElementPresent(ResetButton);
        ResetButton.click();
    }
    public boolean deleteCategory(){
        utility.waitForElementPresent(DeleteCategoryLink);
        DeleteCategoryLink.click();
        utility.waitForAlertPresent();
        Alert alert=driver.switchTo().alert();
        alert.accept();
        return DeleteSuccessMessage.isDisplayed();
    }



}
