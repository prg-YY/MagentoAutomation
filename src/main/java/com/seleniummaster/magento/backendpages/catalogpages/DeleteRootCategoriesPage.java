package com.seleniummaster.magento.backendpages.catalogpages;
import com.seleniummaster.magento.utility.ApplicationConfig;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DeleteRootCategoriesPage {

    WebDriver driver;
    String ConfigFile="config.properties";
    TestUtility utility;
    @FindBy(css = "button[title='Reset'][type='button']")
    WebElement ResetButton;
    @FindBy(css = "button[title='Delete Category']")
    WebElement DeleteCategoryLink;
    //span[text()='The category has been deleted.']
    //*[contains(text(),'The category has been deleted.')]
    //div[@id="messages"]/ul/li/ul/li/span
    @FindBy(xpath ="div[@id=\"messages\"]/ul/li/ul/li/span")
    WebElement DeleteSuccessMessage;
//Team-1-forDeleteCategory
    public DeleteRootCategoriesPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }

    public void clickResetButton() {
        utility.waitForElementPresent(ResetButton);
        ResetButton.click();
    }

    String DeleteCategoryNAME = ApplicationConfig.readConfigProperties(ConfigFile, "DeleteCategoryName");
    public boolean deleteRootCategory(){

        List<WebElement> RootCategoriesList=driver.findElements(By.xpath("div[@class='x-tree-root-node']/li"));
        for(int i=1; i<=RootCategoriesList.size() ;i++){
            WebElement RooCategoryName=driver.findElement(By.xpath("div[@class='x-tree-root-node']/li['+i+']/div/a/span"));
            if(RooCategoryName.getText().equals(DeleteCategoryNAME)){
                utility.waitForElementPresent(RooCategoryName);
                RooCategoryName.click();
                utility.waitForElementPresent(DeleteCategoryLink);
                DeleteCategoryLink.click();
                utility.waitForElementPresent(DeleteCategoryLink);
                DeleteCategoryLink.click();
                utility.waitForAlertPresent();
                Alert alert=driver.switchTo().alert();
                alert.accept();

            }

        }

        return DeleteSuccessMessage.isDisplayed();
    }



}
