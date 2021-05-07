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
    @FindBy(xpath = "//ul[@id=\"nav\"]")
    WebElement catalog;
    @FindBy(xpath = "//*[span=\"Manage Categories\"]/span")
    WebElement manageCategoriesList;
    @FindBy(xpath = "//button[@id=\"add_subcategory_button\"]")
    WebElement addSubcategoryButton;
    @FindBy(xpath = "//td[@class=\"value\"]/input[@id=\"group_4name\"]")
    WebElement nameTextField;
    @FindBy(xpath = "//select[@id=\"group_4is_active\"]")
    WebElement isActiveYes;
    @FindBy(xpath = "//button[@id=\"id_adae205d01645f61da069bb5109f3a9a\"]")
    WebElement saveCategory;
    @FindBy(xpath = "//ul[@class=\"messages\"]")
    WebElement confirmSuccessMessage;
    //combine  webdriver
    public AddSubCategoryPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }
    //method for each action
    public void catelogList(){
        utility.waitForElementPresent(catalog);
        catalog.isDisplayed();
    }
    //manage categories
    public void manageCategories(){
        utility.waitForElementPresent(manageCategoriesList);
        manageCategoriesList.click();

    }
    // click on add subcategory
    protected void addSubcategoryButton(){
        utility.waitForElementPresent(addSubcategoryButton);
        addSubcategoryButton.click();
    }
    // fill out general information
    public void nameTextField(){
        utility.waitForElementPresent(nameTextField);
        nameTextField.getText();

    }
    //is active field
    public void isActiveYes(){
        utility.waitForElementPresent(isActiveYes);
        isActiveYes.isDisplayed();

    }
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
