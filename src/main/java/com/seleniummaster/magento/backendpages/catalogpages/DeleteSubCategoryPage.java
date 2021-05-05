package com.seleniummaster.magento.backendpages.catalogpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteSubCategoryPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    @FindBy(linkText = "Categories")
    WebElement categoriesLink;
    @FindBy(xpath = "//span[contains(text(),'Team1-test-sub-category')]")
    WebElement subCategories;
    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    WebElement deleteButton;
    @FindBy(xpath = "//button[contains(.,'OK')]")
    WebElement okButton;
    @FindBy(xpath = "//div[text()='You saved the category.']")
    WebElement confirmationMessage;

    //create a constructor to initialize the page// page factory
    public DeleteSubCategoryPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver); //combine driver with page factory
    }
    //define actions // method for each section
    public void clickCategoriesLink()
    {
        utility.waitForElementPresent(categoriesLink);
        categoriesLink.click();
        Log.info("Categories link clicked");
    }
    public void clickSubcategories()
    {
        utility.waitForElementPresent(subCategories);
        subCategories.click();
        Log.info("Sub categories link clicked");
    }
    public void clickDeleteButton()
    {
        utility.waitForElementPresent(deleteButton);
        deleteButton.click();
        Log.info("Delete button clicked");
    }
    public void clickOk()
    {
        utility.waitForElementPresent(okButton);
        okButton.click();
        Log.info("Ok button clicked");
    }
    public boolean isConfirmationDisplayed() {
        utility.waitForElementPresent(confirmationMessage);
        Log.info("Confirm message found");
        return confirmationMessage.isDisplayed();
    }
    public boolean deleteSub()
    {
        clickCategoriesLink();
        clickSubcategories();
        clickDeleteButton();
        clickOk();
        return isConfirmationDisplayed();
    }
}
