package com.seleniummaster.magento.backendpages.catalogpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCategoriesPage extends TestBasePage {

    WebDriver driver;
    TestUtility utility;
    CatalogDashboardPage catalogDashboardPage;

    @FindBy(xpath = "//*[@id=\"ext-gen21\"]")
    WebElement TEAM1_categoryLink;
    @FindBy(xpath = "//*[@id=\"group_4description\"]")
    WebElement descriptionTextBox;

    @FindBy(xpath = "//*[@title='Save Category']")
    WebElement saveButton;
    @FindBy(xpath = "//*[@id=\"messages\"]/ul/li/ul/li/span")
    WebElement successMessage;

    public EditCategoriesPage() {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }


    public void clickTeam1CategoryLink() {
        utility.waitForElementPresent(TEAM1_categoryLink);
        TEAM1_categoryLink.click();
        Log.info("TEAM1_category Link clicked");
    }

    public void clearDescriptionTextBox() {
        utility.waitForElementPresent(descriptionTextBox);
        descriptionTextBox.clear();
    }

    public void fillDescriptionTextBox(String categoryMetaTitlePrefix) {
        utility.waitForElementPresent(descriptionTextBox);
        descriptionTextBox.sendKeys(categoryMetaTitlePrefix);
        Log.info("Description Title Box Filled");
    }

    public void clickSaveButton() {
        utility.waitForElementPresent(saveButton);
        saveButton.click();
        Log.info("Save Button Has Clicked");
    }

    public boolean displaySuccessMessage() {
        utility.waitForElementPresent(successMessage);
        return successMessage.isDisplayed();
    }

    public void editCategoriesPage() {
        catalogDashboardPage = new CatalogDashboardPage(driver);
        catalogDashboardPage.clickCatalogLink();
        catalogDashboardPage.clickManageCategories();
        clickTeam1CategoryLink();
        utility.sleep(1);
        clearDescriptionTextBox();
        utility.sleep(2);
        fillDescriptionTextBox(prop.getProperty("ca-firstNmae"));
        utility.sleep(2);
        clickSaveButton();
        displaySuccessMessage();
    }
}
