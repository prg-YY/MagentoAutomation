package com.seleniummaster.magento.backendpages.storepages;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductCategoriesPage extends TestBasePage{
    WebDriver driver;
    String ConfigFile = "config.properties";
    TestUtility utility;
    @FindBy(xpath = "//input[@name=\"general[name]\"]")
    WebElement nameTextField;
    @FindBy(xpath = "//select[@id=\"group_4is_active\"]")
    WebElement isActiveDropDownList;
    @FindBy(xpath = "//select[@id=\"group_4include_in_menu\"]")
    WebElement includeNavigationDropDownList;
    @FindBy(xpath = "//span[text()=\"Category Products\"]")
    WebElement categoryProductsLink;
    @FindBy(xpath = "(//input[@type=\"checkbox\"])[5]")
    WebElement selectedProductCheckBox;
    @FindBy(xpath = "//span[text()=\"Save Category\"]")
    WebElement saveCategoryButton;
    @FindBy(xpath = "//span[text()=\"The category has been saved.\"]")
    WebElement successfullySavedMsg;

    public ProductCategoriesPage(WebDriver driver){
        this.driver= TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility=new TestUtility(driver);
    }
    //Store Manager can add product categories
    public void EnterNameTextField(String Name){
        utility.waitForElementPresent(nameTextField);
        nameTextField.sendKeys(Name);
    }
    public void SelectActiveStatus(){
        utility.waitForElementPresent(isActiveDropDownList);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Select SelectDropDown=new Select(isActiveDropDownList);
        SelectDropDown.selectByValue("1");
    }
    public void SelectIncludeNavigation(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        utility.waitForElementPresent(includeNavigationDropDownList);
        Select SelectDropDown2=new Select(includeNavigationDropDownList);
        SelectDropDown2.selectByValue("1");
    }
    public void clickCategoryProductsLink(){
        utility.waitForElementPresent(categoryProductsLink);
        categoryProductsLink.click();
    }
    public void clickProductCheckBox(){
        utility.waitForElementPresent(selectedProductCheckBox);
        selectedProductCheckBox.click();
    }
    public void clickSaveButton(){
        utility.waitForElementPresent(saveCategoryButton);
        saveCategoryButton.click();
    }
    public boolean VerifySuccessfullyAddCategoryMsg(){
        utility.waitForElementPresent(successfullySavedMsg);
        return successfullySavedMsg.isDisplayed();
    }

    public void addProductCategory(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        EnterNameTextField(prop.getProperty("RootCategoryName"));
        SelectActiveStatus();
//        SelectIncludeNavigation();
        clickCategoryProductsLink();
        clickProductCheckBox();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickSaveButton();
        VerifySuccessfullyAddCategoryMsg();

    }

    //Store Manager can update product categories

    @FindBy(xpath = "//span[text()=\"Team1 (6)\"]")
    WebElement Team1CategoryLink;
    @FindBy(xpath = "//textarea[@id=\"group_4description\"]")
    WebElement descriptionTextArea;

    public void clickExistCategoryLink(){
        utility.waitForElementPresent(Team1CategoryLink);
        utility.sleep(3);
        Team1CategoryLink.click();
    }
    public void EnterDescription(String Description){
        utility.waitForElementPresent(descriptionTextArea);
        descriptionTextArea.clear();
        descriptionTextArea.sendKeys(Description);
    }

    public void UpdateProductCategory(){
        clickExistCategoryLink();
        EnterDescription(prop.getProperty("DescriptionTextField"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickSaveButton();

        VerifySuccessfullyAddCategoryMsg();

    }
}
