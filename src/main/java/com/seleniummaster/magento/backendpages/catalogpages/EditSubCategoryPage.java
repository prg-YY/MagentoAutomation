package com.seleniummaster.magento.backendpages.catalogpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.By;
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

    public void enterDescriptionTextBox(String description) {
        utility.waitForElementPresent(descriptionTextBox);
        descriptionTextBox.clear();
        descriptionTextBox.sendKeys(description);
        Log.info("Description is entered");
    }

    public void clickSaveButton() {
        utility.waitForElementPresent(saveButton);
        saveButton.click();
        Log.info("Save Button Clicked");
    }

    public boolean subCategoryEditedSuccessfully() {
        utility.waitForElementPresent(editSubCategorySuccessMassage);
        if (editSubCategorySuccessMassage.isDisplayed()){
            System.out.println("Test Passed.Sub Category Edited Successfully");
            return true;
        }else System.out.println("Test Failed, cannot edit sub category");
        return false;
    }

    public void editSubCategories() {
        catalogDashboardPage = new CatalogDashboardPage(driver);
        catalogDashboardPage.clickCatalogLink();
        utility.sleep(1);
        catalogDashboardPage.clickManageCategories();
        utility.sleep(1);
        clickTeam1RootCategory();
        utility.sleep(1);
        enterDescriptionTextBox(prop.getProperty("editSubDescription"));
        utility.sleep(1);
        clickSaveButton();
        utility.sleep(1);
    }
    public void editExistingSubCategories(String subCategoryName) {
        catalogDashboardPage = new CatalogDashboardPage(driver);
        catalogDashboardPage.clickCatalogLink();
        utility.sleep(1);
        catalogDashboardPage.clickManageCategories();
        utility.sleep(2);
        WebElement rootCategoryLink=driver.findElement(By.xpath("//span[text()='"+subCategoryName+" (0)']"));
        utility.waitForElementPresent(rootCategoryLink);
        rootCategoryLink.click();
        utility.sleep(1);
        enterDescriptionTextBox(prop.getProperty("editSubDescription"));
        utility.sleep(1);
        clickSaveButton();
        utility.sleep(2);
    }
}
