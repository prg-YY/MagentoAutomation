package com.seleniummaster.magento.backendpages.catalogpages;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddSubCategoryPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    @FindBy(xpath = "//span[text()=\"Catalog\"]")
    WebElement catalogLink;
    @FindBy(xpath = "//*[span=\"Manage Categories\"]/span")
    WebElement manageCategoriesList;
    @FindBy(xpath = "//button[@id=\"add_subcategory_button\"]")
    WebElement addSubcategoryButton;
    @FindBy(id= "group_4name")
    WebElement nameTextField;
    @FindBy(id= "group_4is_active")
    WebElement isActiveYes;
    @FindBy(xpath = "//span[text()=\"Save Category\"]")
    WebElement saveCategory;
    @FindBy(xpath = "//span[text()=\"The category has been saved.\"]")
    WebElement confirmSuccessMessage;
    //combine  webdriver
    public AddSubCategoryPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }
    //method for each action
    public void clickCatelogLink(){
        utility.waitForElementPresent(catalogLink);
        catalogLink.click();
    }
    //manage categories
    public void clickOnManageCategories(){
        utility.waitForElementPresent(manageCategoriesList);
        manageCategoriesList.click();

    }
    // click on add subcategory
    protected void clickOnAddSubcategory(){
        utility.waitForElementPresent(addSubcategoryButton);
        addSubcategoryButton.click();
    }
    // fill out general information
    public void enterCategoryName(String subCategoryName){
        utility.waitForElementPresent(nameTextField);
        nameTextField.sendKeys(subCategoryName);

    }
    //is active field
   // public void isActiveYes(){
       // utility.waitForElementPresent(isActiveYes);
        //isActiveYes.isDisplayed();

   // }
    //click  on save category button
    public void clickSaveCategory(){
        utility.waitForElementPresent(saveCategory);
        saveCategory.click();
    }
    //confirm success message
    public void confirmSuccessMessage() {
        utility.waitForElementPresent(confirmSuccessMessage);
        if (confirmSuccessMessage.isDisplayed()) {
            System.out.println("test Passed, The category has been saved.");
        } else {
            System.out.println("crate subCategory test failed");
        }



    }}
