package com.seleniummaster.magento.backendpages.catalogpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteSubCategoryPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    CatalogDashboardPage catalogDashboardPage;


    @FindBy(xpath = "//span[contains(text(),'team1-test-sub-category (1)')]")
    WebElement subCategories;
    @FindBy(xpath = "//button[@title='Delete Category']")
    WebElement deleteButton;
    @FindBy(xpath = "//span[text()='The category has been deleted.']")
    WebElement confirmationMessage;

    //create a constructor to initialize the page// page factory
    public DeleteSubCategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver); //combine driver with page factory
    }

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


    public boolean isConfirmationDisplayed() {
        utility.waitForElementPresent(confirmationMessage);
        Log.info("Confirm message found");
        return confirmationMessage.isDisplayed();
    }

    public void deleteSub() {
        catalogDashboardPage = new CatalogDashboardPage(driver);
        catalogDashboardPage.clickCatalogLink();
        utility.sleep(1);
        catalogDashboardPage.clickManageCategories();
        utility.sleep(1);
        clickSubcategories();
        utility.sleep(1);
        clickDeleteButton();
        utility.sleep(1);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        utility.sleep(1);
    }
}
