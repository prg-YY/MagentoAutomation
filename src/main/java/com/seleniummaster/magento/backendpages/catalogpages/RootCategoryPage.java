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
import org.openqa.selenium.support.ui.Select;

public class RootCategoryPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    CatalogDashboardPage catalogDashboardPage;

    public RootCategoryPage() {
        this.driver=TestBasePage.driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }
// Add Root Category Elements
    @FindBy(css = "input[id='group_4name'][name='general[name]']")
    WebElement nameTextBox;
    @FindBy(css = "select[id='group_4is_active'] option[value='1']")
    WebElement isActiveDropDown;
    @FindBy(css = "textarea[id = 'group_4description']")
    WebElement descriptionTextField;
    @FindBy(xpath = "//span[normalize-space()='Save Category']")
    WebElement newRootCategorySaveButton;
    @FindBy(xpath = "//span[text()='The category has been saved.']")
    WebElement addRootCategorySuccessMassage;
//Update Root Category Elements
    @FindBy(xpath = "//*[@id=\"ext-gen21\"]")
    WebElement TEAM1_categoryLink;
    @FindBy(xpath = "//*[@id=\"group_4description\"]")
    WebElement descriptionTextBox;
    @FindBy(xpath = "//*[@title='Save Category']")
    WebElement saveButton;
    @FindBy(xpath = "//*[@id=\"messages\"]/ul/li/ul/li/span")
    WebElement successMessage;
//Delete Root Category Elements
    @FindBy(css = "button[title='Reset'][type='button']")
    WebElement ResetButton;
    @FindBy(xpath = "//button[@title='Delete Category']")
    WebElement DeleteCategoryLink;
    @FindBy(xpath = "//span[text()='The category has been deleted.']")
    WebElement DeleteSuccessMessage;
// Add Root Category Methods
public void fillNameTextBox(String catName) {
    utility.waitForElementPresent(nameTextBox);
    nameTextBox.sendKeys(catName);
    Log.info("Name Text Box filled");
}

    public void selectIsActiveDropDown() {
        utility.waitForElementPresent(isActiveDropDown);
        isActiveDropDown.click();
        Log.info("Yes is Selected");
    }

    public void fillDescriptionTextField(String description) {
        utility.waitForElementPresent(descriptionTextField);
        descriptionTextField.sendKeys(description);
        Log.info("Description Text Field Filled");
    }

    public void clickNewRootCategorySaveButton() {
        utility.waitForElementPresent(newRootCategorySaveButton);
        newRootCategorySaveButton.click();
        Log.info("New RootCategory Save Button Clicked");
    }

    public boolean isAddRootCategoryAddedSuccessfully() {
        utility.waitForElementPresent(addRootCategorySuccessMassage);
        if (addRootCategorySuccessMassage.isDisplayed()){
            System.out.println("Test Passed,The root category Created Successfully");
            return true;
        }else System.out.println("Test Failed,cannot create new root category");
        return false;
    }

    public void addNewRootCategory(String catName) {
        catalogDashboardPage = new CatalogDashboardPage(driver);
        utility.sleep(1);
        catalogDashboardPage.clickCatalogLink();
        utility.sleep(1);
        catalogDashboardPage.clickManageCategories();
        utility.sleep(1);
        fillNameTextBox(catName);
        utility.sleep(1);
        selectIsActiveDropDown();
        utility.sleep(1);
        fillDescriptionTextField(prop.getProperty("rootDescription"));
        utility.sleep(1);
        clickNewRootCategorySaveButton();
        utility.sleep(1);
    }
//Update Root Category Methods
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

//Delete Root Category Methods
public void clickDeleteRootCategoryLink() {
    utility.waitForElementPresent(DeleteCategoryLink);
    DeleteCategoryLink.click();
}

    public boolean deleteRootCategorySuccessfully() {
        utility.waitForElementPresent(DeleteSuccessMessage);
        if (DeleteSuccessMessage.isDisplayed()){
            System.out.println("Test Passed , The root Category Deleted successfully");
            return true;
        }else System.out.println("Test Failed, delete root category test failed");
        return false;
    }



    @FindBy(xpath = "(//span[text()=\"Sofia (1)\"])[1]")
    WebElement RootCategoryName;

    public void deleteRootCategory() {
        catalogDashboardPage = new CatalogDashboardPage(driver);
        catalogDashboardPage .clickCatalogLink();
        catalogDashboardPage .clickManageCategories();
        RootCategoryName.click();
        clickDeleteRootCategoryLink();
        utility.waitForAlertPresent();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        deleteRootCategorySuccessfully();
    }
    //delete root category --2021-6-11-abdusamad
    public void deleteAnExistingRootCategory(String rootCategoryName) {
        catalogDashboardPage  = new CatalogDashboardPage(driver);
        catalogDashboardPage .clickCatalogLink();
        catalogDashboardPage .clickManageCategories();
        WebElement rootCategoryLink=driver.findElement(By.xpath("//span[text()='"+rootCategoryName+" (0)']"));
        utility.waitForElementPresent(rootCategoryLink);
        rootCategoryLink.click();
        utility.sleep(1);
        clickDeleteRootCategoryLink();
        utility.waitForAlertPresent();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        deleteRootCategorySuccessfully();
    }
}
