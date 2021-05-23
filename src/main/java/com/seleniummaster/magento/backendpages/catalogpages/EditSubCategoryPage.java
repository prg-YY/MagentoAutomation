package com.seleniummaster.magento.backendpages.catalogpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditSubCategoryPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    CatalogDashboardPage catalogDashboardPage;

    @FindBy(xpath = "//*[@id='extdd-76']")
    WebElement team1RootCategory;
    @FindBy(xpath = "//*[@id='group_4description']")
    WebElement descriptionTextBox;
    @FindBy(xpath = "//span[text()='The category has been saved.']")
    WebElement editSubCategorySuccessMassage;
    @FindBy(xpath = "//span[text()='Save Category']")
    WebElement saveButton;

    public EditSubCategoryPage(WebDriver driver) {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);

    }

    public void clickTeam1RootCategory() {
        utility.waitForElementPresent(team1RootCategory);
        team1RootCategory.click();
        Log.info(" team1RootCategory  clicked");
    }

    public void enterDescriptionTextBox() {
        utility.waitForElementPresent(descriptionTextBox);
        descriptionTextBox.clear();
        descriptionTextBox.sendKeys(prop.getProperty("ca-firstNmae"));
        Log.info("Description is entered");
    }

    public void clickSaveButton() {
        utility.waitForElementPresent(saveButton);
        saveButton.click();
        Log.info("Save Button Clicked");
    }

    public boolean isEditSubCategorySuccessMassage() {
        utility.waitForElementPresent(editSubCategorySuccessMassage);
        return editSubCategorySuccessMassage.isDisplayed();

    }

    public void editSubCategories() {
        catalogDashboardPage = new CatalogDashboardPage(driver);
        catalogDashboardPage.clickCatalogLink();
        utility.sleep(1);
        catalogDashboardPage.clickManageCategories();
        utility.sleep(1);
        clickTeam1RootCategory();
        utility.sleep(1);
        enterDescriptionTextBox();
        utility.sleep(1);
        clickSaveButton();
        utility.sleep(1);


    }
}
