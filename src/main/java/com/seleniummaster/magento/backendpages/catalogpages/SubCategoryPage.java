package com.seleniummaster.magento.backendpages.catalogpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubCategoryPage extends TestBasePage {

    WebDriver driver;
    TestUtility utility;
    CatalogDashboardPage catalogDashboardPage;
    public SubCategoryPage() {
        this.driver= TestBasePage.driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }

// Add Sub Category Elements
    @FindBy(xpath = "//button[@id='add_subcategory_button']")
    WebElement addSubcategoryButton;
    @FindBy(id = "group_4name")
    WebElement nameTextField;
    @FindBy(xpath = "//span[text()='Save Category']")
    WebElement saveCategory;
    @FindBy(xpath = "//span[text()='The category has been saved.']")
    WebElement addSubCategorySuccessMassage;
//Update Sub Category Elements
    @FindBy(xpath = "//*[@id='extdd-76']")
    WebElement team1RootCategory;
    @FindBy(xpath = "//*[@id='group_4description']")
    WebElement descriptionTextBox;
    @FindBy(xpath = "//span[text()='The category has been saved.']")
    WebElement editSubCategorySuccessMassage;
    @FindBy(xpath = "//span[text()='Save Category']")
    WebElement saveButton;
//Delete Sub Category Elements
    @FindBy(xpath = "//span[contains(text(),'team1-test-sub-category (1)')]")
    WebElement subCategories;
    @FindBy(xpath = "//button[@title='Delete Category']")
    WebElement deleteButton;
    @FindBy(xpath = "//span[text()='The category has been deleted.']")
    WebElement confirmationMessage;
// Add Sub Category Methods
    protected void clickOnAddSubcategory() {
        utility.waitForElementPresent(addSubcategoryButton);
        addSubcategoryButton.click();
        Log.info("Add Subcategory Link Clicked");
    }
    public void enterCategoryName() {
        utility.waitForElementPresent(nameTextField);
        nameTextField.sendKeys(prop.getProperty("Status"));
        Log.info("Name Text Box filled");
    }
    public void enterSubCategoryName(String name) {
        utility.waitForElementPresent(nameTextField);
        nameTextField.sendKeys(name);
        Log.info("Name Text Box filled");
    }

    public void clickSaveCategory() {
        utility.waitForElementPresent(saveCategory);
        saveCategory.click();
        Log.info("New Sub Category Save Button Clicked");
    }
    public boolean isAddSubCategorySuccessMassage() {
        utility.waitForElementPresent(addSubCategorySuccessMassage);
        if (addSubCategorySuccessMassage.isDisplayed()){
            System.out.println("Test Passed, The Sub category created successfully");
            return true;
        }else System.out.println("Test Failed. cannot Create sub category");
        return false;
    }
    public void addSubCategory() {
        catalogDashboardPage = new CatalogDashboardPage(driver);
        catalogDashboardPage.clickCatalogLink();
        catalogDashboardPage.clickManageCategories();
        clickOnAddSubcategory();
        utility.sleep(2);
        enterCategoryName();
        utility.sleep(2);
        clickSaveCategory();
        utility.sleep(2);
    }
    public void addNewSubCategory(String subCategoryName) {
        catalogDashboardPage = new CatalogDashboardPage(driver);
        catalogDashboardPage.clickCatalogLink();
        catalogDashboardPage.clickManageCategories();
        clickOnAddSubcategory();
        utility.sleep(2);
        enterSubCategoryName(subCategoryName);
        utility.sleep(1);
        clickSaveCategory();
        utility.sleep(2);
    }

//Update Sub Category Methods

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

//Delete Sub Category Methods
public void clickSubcategories() {
    utility.waitForElementPresent(subCategories);
    subCategories.click();
    Log.info("Sub categories link clicked");
}

    public void clickDeleteButton() {
        utility.waitForElementPresent(deleteButton);
        deleteButton.click();
        Log.info("Delete button clicked");
    }


    public boolean deleteSubCategorySuccessfully() {
        utility.waitForElementPresent(confirmationMessage);
        Log.info("Confirm message found");
        if (confirmationMessage.isDisplayed()){
            System.out.println("Test Passed,Sub category deleted successfully");
            return true;
        }else System.out.println("Test Failed, cannot delete sub category");
        return false;
    }

    public void deleteSub() {
        catalogDashboardPage = new CatalogDashboardPage(driver);
        catalogDashboardPage.clickCatalogLink();
        utility.sleep(1);
        catalogDashboardPage.clickManageCategories();
        utility.sleep(2);
        clickSubcategories();
        utility.sleep(1);
        clickDeleteButton();
        utility.sleep(2);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        utility.sleep(1);
    }
    public void deleteSubCategory(String subCategoryName) {
        catalogDashboardPage = new CatalogDashboardPage(driver);
        catalogDashboardPage.clickCatalogLink();
        utility.sleep(1);
        catalogDashboardPage.clickManageCategories();
        utility.sleep(2);
        WebElement rootCategoryLink=driver.findElement(By.xpath("//span[text()='"+subCategoryName+" (0)']"));
        utility.waitForElementPresent(rootCategoryLink);
        rootCategoryLink.click();
        utility.sleep(1);
        clickDeleteButton();
        utility.sleep(2);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        utility.sleep(1);
    }

}
