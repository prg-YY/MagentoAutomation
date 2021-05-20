package com.seleniummaster.magento.backendpages.storepages;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateProductCategoriesPage extends TestBasePage{
    WebDriver driver;
    String ConfigFile = "config.properties";
    TestUtility utility;
    @FindBy(xpath = "//div[text()='SOJOS Retro Big Round Blue Light Computer Glasses']//ancestor::tr//a")
    WebElement productEditButton;
    @FindBy(xpath = "//div[text()='Select...']")
    WebElement categoriesSelect;
    @FindBy(xpath = "//div[@class='action-select admin__action-multiselect _active']")
    WebElement categoriesAgainSelect;
    @FindBy(xpath = "//button[@class='action-default']")
    WebElement doneButton;
    @FindBy(xpath = "//span[text()='Save']")
    WebElement saveButton;
    @FindBy(xpath = "//span[@class='admin__action-multiselect-crumb']//button")
    WebElement deletedCategories;
    @FindBy(xpath = "//div[@data-ui-id='messages-message-success']")
    WebElement successMessage;

    public UpdateProductCategoriesPage(){
        this.driver= TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility=new TestUtility(driver);
    }
    public void clickProductEditButton()
    {
        utility.waitForElementPresent(productEditButton);
        productEditButton.click();
        Log.info("Click product edit link");
    }

    public void clickCategoriesSelect()
    {
        utility.waitForElementPresent(categoriesSelect);
        categoriesSelect.click();
        Log.info("Click categories select");
    }

    public void clickChooseCategoriesSelect()
    {
        String categoryName =  "team-1 category";
        WebElement nameElement=driver.findElement(By.xpath(categoryName));
        utility.waitForElementPresent(nameElement);
        nameElement.click();
        Log.info("Click choose categories select ");
    }

    public void clickDoneButton()
    {
        utility.waitForElementPresent(doneButton);
        doneButton.click();
        Log.info("Click Done button");
    }

    public void clickSaveButton()
    {
        utility.waitForElementPresent(saveButton);
        saveButton.click();
        Log.info("Click Save button");
    }

    public boolean isDisplaySuccessMessage()
    {
        utility.waitForElementPresent(successMessage);
        return successMessage.isDisplayed();
    }


    public void clickCategoriesDeleted()
    {
        utility.waitForElementPresent(deletedCategories);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", deletedCategories);
        Log.info("deleted categories");
    }
    public boolean updateProductCategories()
    {
        clickProductEditButton();
        clickCategoriesSelect();
        clickChooseCategoriesSelect();
        clickDoneButton();
        clickSaveButton();
        return isDisplaySuccessMessage();
    }

    public boolean deleteUpdateCategories()
    {
        clickProductEditButton();
        clickCategoriesDeleted();
        clickSaveButton();
        return isDisplaySuccessMessage();
    }
}


