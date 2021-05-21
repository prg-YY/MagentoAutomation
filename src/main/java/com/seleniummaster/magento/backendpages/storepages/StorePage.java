package com.seleniummaster.magento.backendpages.storepages;

import com.seleniummaster.magento.utility.ApplicationConfig;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class StorePage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    String ConfigFile = "config.properties";
    @FindBy(xpath = "(//span[text()='System'])[1]")
    WebElement SystemButton;
    @FindBy(xpath = "(//span[text()='Create Store'])[1]")
    WebElement CreateStoreButton;
    @FindBy(xpath = "//select[@id=\"group_website_id\"]")
    WebElement WebsiteSelect;
    @FindBy(xpath = "//input[@type=\"text\"and@id=\"group_name\"]")
    WebElement NameTextBox;
    @FindBy(xpath = "//select[@id=\"group_root_category_id\"]")
    WebElement RootCategorySelect;
    @FindBy(xpath = "(//span[text()=\"Save Store\"])[1]")
    WebElement SaveStoreButton;
    @FindBy(xpath = "//span[text()=\"The store has been saved.\"]")
    WebElement ConfirmationMessage;
    //Store Manager can create a store
    public StorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }
    public void clickOnCreateStoreButton() {
        utility.waitForElementPresent(CreateStoreButton);
        CreateStoreButton.click();
    }
    public void selectWebsite() {
        utility.waitForElementPresent(WebsiteSelect);
        Select WebsiteDropDownList=new Select(WebsiteSelect);
        WebsiteDropDownList.selectByValue("47");
    }
    public void enterName(String Name) {
        utility.waitForElementPresent(NameTextBox);
        NameTextBox.sendKeys(Name);
    }
    public void selectRootCategory() {
        utility.waitForElementPresent(RootCategorySelect);
        Select RootCategoryDropDownList= new Select(RootCategorySelect);
        RootCategoryDropDownList.selectByValue("27");
    }
    public void clickOnSaveStore(){
        utility.waitForElementPresent(SaveStoreButton);
        SaveStoreButton.click();
    }
    public boolean verifySuccess(){
        utility.waitForElementPresent(ConfirmationMessage);
        return ConfirmationMessage.isDisplayed();
    }
    public void createStore(){
        selectWebsite();
        enterName(prop.getProperty("StoreName"));
        selectRootCategory();
        clickOnSaveStore();
        verifySuccess();
    }
//Store Manager can edit a store
    @FindBy(xpath = "//*[@id=\"page:main-container\"]/div[3]/div/table/tbody/tr[1]/td[2]/a")
    WebElement StoreName;

    public void editStore(){
        StoreName.click();
        selectWebsite();
        clickOnSaveStore();
        verifySuccess();

    }


}
