package com.seleniummaster.magento.backendpages.catalogpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddSubCategoryPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    CatalogDashboardPage catalogDashboardPage;

    @FindBy(xpath = "//button[@id='add_subcategory_button']")
    WebElement addSubcategoryButton;
    @FindBy(id = "group_4name")
    WebElement nameTextField;
    @FindBy(xpath = "//span[text()='Save Category']")
    WebElement saveCategory;
    @FindBy(xpath = "//span[text()='The category has been saved.']")
    WebElement addSubCategorySuccessMassage;

    public AddSubCategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }


    protected void clickOnAddSubcategory() {
        utility.waitForElementPresent(addSubcategoryButton);
        addSubcategoryButton.click();
        Log.info("Add Subcategory Link Clicked");
    }

    public void enterCategoryName() {
        utility.waitForElementPresent(nameTextField);
        nameTextField.sendKeys(prop.getProperty("NewRootCategories"));
        Log.info("Name Text Box filled");
    }



    public void clickSaveCategory() {
        utility.waitForElementPresent(saveCategory);
        saveCategory.click();
        Log.info("New Sub Category Save Button Clicked");
    }
    public boolean isAddSubCategorySuccessMassage(){
        utility.waitForElementPresent(addSubCategorySuccessMassage);
        return addSubCategorySuccessMassage.isDisplayed();

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
}