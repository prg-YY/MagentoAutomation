package com.seleniummaster.magento.backendpages.catalogpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteRootCategoriesPage extends TestBasePage {

    WebDriver driver;
    TestUtility utility;
    CatalogDashboardPage catalogDashboardPage;

    @FindBy(xpath = "//a[text()='Collapse All']")
    WebElement collapseLink;
    @FindBy(xpath = "(//span[contains(text(),'TEAM1_CATEGORY (3)')])[1]")//element not exist
    WebElement rootCategory;
    @FindBy(xpath = "//button[@title='Delete Category']")
    WebElement DeleteCategoryLink;
    @FindBy(xpath = "//span[text()='The category has been deleted.']")
    WebElement DeleteSuccessMessage;


    public DeleteRootCategoriesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

    public void clickCollapseLink() {
        utility.waitForElementPresent(collapseLink);
        collapseLink.click();
        Log.info("CollapseLink Clicked");
    }

    public void clickRootCategory() {
        utility.waitForElementPresent(rootCategory);
        rootCategory.click();
        Log.info("RootCategory Clicked");
    }

    public void clickDeleteButton() {
        utility.waitForElementPresent(DeleteCategoryLink);
        DeleteCategoryLink.click();
        Log.info("delete button clicked");
    }

    public boolean verifySuccessfulMsgDisplay() {
        utility.waitForElementPresent(DeleteSuccessMessage);
        Log.info("root category deleted");
        return DeleteSuccessMessage.isDisplayed();

    }


    public void deleteRootCategory() {
        catalogDashboardPage = new CatalogDashboardPage(driver);
        catalogDashboardPage.clickCatalogLink();
        catalogDashboardPage.clickManageCategories();
        clickCollapseLink();
        clickRootCategory();
        clickDeleteButton();
        Alert alert = driver.switchTo().alert();
        alert.accept();


    }

}

