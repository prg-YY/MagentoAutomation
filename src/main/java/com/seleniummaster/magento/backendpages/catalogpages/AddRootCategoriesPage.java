package com.seleniummaster.magento.backendpages.catalogpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRootCategoriesPage extends TestBasePage {

    WebDriver driver;
    TestUtility utility;
    CatalogDashboardPage catalogDashboardPage;

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

    public AddRootCategoriesPage(WebDriver driver) {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }


    public void fillNameTextBox(){
        utility.waitForElementPresent(nameTextBox);
        nameTextBox.sendKeys(prop.getProperty("NewRootCategories"));
        Log.info("Name Text Box filled");
    }
    public void selectIsActiveDropDown(){
        utility.waitForElementPresent(isActiveDropDown);
        isActiveDropDown.click();
        Log.info("Yes is Selected");
    }
    public void fillDescriptionTextField(){
        utility.waitForElementPresent(descriptionTextField);
        descriptionTextField.sendKeys(prop.getProperty("NewRootCategories"));
        Log.info("Description Text Field Filled");
    }
    public void clickNewRootCategorySaveButton(){
        utility.waitForElementPresent(newRootCategorySaveButton);
        newRootCategorySaveButton.click();
        Log.info("New RootCategory Save Button Clicked");
    }
    public boolean isAddRootCategorySuccessMassage(){
        utility.waitForElementPresent(addRootCategorySuccessMassage);
        return addRootCategorySuccessMassage.isDisplayed();
    }
    public void addNewRootCategory(){
        catalogDashboardPage=new CatalogDashboardPage(driver);
        catalogDashboardPage.clickCatalogLink();
        catalogDashboardPage.clickManageCategories();
        fillNameTextBox();
        selectIsActiveDropDown();
        fillDescriptionTextField();
        clickNewRootCategorySaveButton();

    }
}
