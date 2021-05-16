package com.seleniummaster.magento.backendpages.catalogpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class EditSubCategoryPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    @FindBy(xpath = "//span[text()='Catalog']")
    WebElement catalogLink;
    @FindBy(xpath = "//span[text()='Manage Categories']")
    WebElement manageCategories;
    @FindBy(xpath = "//*[@id=\"extdd-76\"]")
    WebElement team1RootCategory;
    @FindBy(xpath = "//*[@id=\"group_4description\"]")
    WebElement descriptionTextBox;
    @FindBy(xpath = "//span[text()='Save Category']")
    WebElement saveButton;

    public EditSubCategoryPage(WebDriver driver) {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }
    public void clickCatalogLink(){
        utility.waitForElementPresent(catalogLink);
        catalogLink.click();
        Log.info("Catalog Link clicked");
    }
    public void clickManageCategories(){
        utility.waitForElementPresent(manageCategories);
        manageCategories.click();
        Log.info("manageCategories  clicked");

    }
    public void clickTeam1RootCategory(){
        utility.waitForElementPresent(team1RootCategory);
        team1RootCategory.click();
        Log.info(" team1RootCategory  clicked");
    }
    public void enterDescriptionTextBox(String KaMerDiscription){
        utility.waitForElementPresent(descriptionTextBox);
        descriptionTextBox.sendKeys(KaMerDiscription);
    }
    public void clickSaveButton(){
        utility.waitForElementPresent(saveButton);
        saveButton.click();
        Log.info("  saveButton clicked");

    }

    public boolean editSubCategories(){
        clickCatalogLink();
        clickManageCategories();
        clickTeam1RootCategory();
        enterDescriptionTextBox(prop.getProperty("ca-firstNmae"));
        clickSaveButton();
        Log.info("  saveButton clicked");
        return editSubCategories();
    }
}
