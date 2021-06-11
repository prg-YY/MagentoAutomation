package com.seleniummaster.magento.backendpages.catalogpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    public boolean editRootCategorySuccessfully() {
        utility.waitForElementPresent(successMessage);
        if (successMessage.isDisplayed()){
            System.out.println("Test Passed, Root Category Edited Successfully");
            return true;
        }else System.out.println("Test Failed, Edit root Category test Failed");
        return false;
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
        editRootCategorySuccessfully();
    }

    //Edit Root Category -Abdusamad-2021-6-11
    @FindBy(id = "group_4is_active")
    WebElement isActiveSelection;

    public void selectActive(){
        utility.waitForElementPresent(isActiveSelection);
        Select select=new Select(isActiveSelection);
        select.selectByValue("1");
    }


    public void editAnExistingCategory(String rootCategoryName) {
        catalogDashboardPage = new CatalogDashboardPage(driver);
        catalogDashboardPage.clickCatalogLink();
        catalogDashboardPage.clickManageCategories();
        WebElement rootCategoryLink=driver.findElement(By.xpath("//span[text()='"+rootCategoryName+" (0)']"));
        utility.waitForElementPresent(rootCategoryLink);
        rootCategoryLink.click();
        utility.sleep(3);
        clearDescriptionTextBox();
        utility.sleep(2);
        selectActive();
       fillDescriptionTextBox(prop.getProperty("editRootDescription"));
        utility.sleep(2);
        clickSaveButton();
        editRootCategorySuccessfully();
    }
    ////span[text()='Team1 (1)']
}
