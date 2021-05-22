package com.seleniummaster.magento.backendpages.catalogpages;

import com.seleniummaster.magento.utility.ApplicationConfig;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.apache.poi.hssf.record.PageBreakRecord;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DeleteRootCategoriesPage extends TestBasePage {

    WebDriver driver;
    String ConfigFile = "config.properties";
    TestUtility utility;
    @FindBy(css = "button[title='Reset'][type='button']")
    WebElement ResetButton;
    @FindBy(xpath = "//button[@title='Delete Category']")
    WebElement DeleteCategoryLink;
    //span[text()='The category has been deleted.']
    //*[contains(text(),'The category has been deleted.')]
    //div[@id="messages"]/ul/li/ul/li/span
    @FindBy(xpath = "//*[contains(text(),'The category has been deleted.')")
    WebElement DeleteSuccessMessage;

    public DeleteRootCategoriesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

    public void clickDeleteRootCategorylink() {
        utility.waitForElementPresent(DeleteCategoryLink);
        DeleteCategoryLink.click();
    }

    public boolean VerifySuccessfulMsgDisplay(){
        utility.waitForElementPresent(DeleteSuccessMessage);
        DeleteSuccessMessage.isDisplayed();
        return true;
    }

    String DeleteCategoryNAME = ApplicationConfig.readConfigProperties(ConfigFile, "DeleteCategoryName");

    public void deleteRootCategory() {

        List<WebElement> RootCategoriesList = driver.findElements(By.xpath("div[@class='x-tree-root-node']/li"));
        for (int i = 1; i <= RootCategoriesList.size(); i++) {
            WebElement RooCategoryName = driver.findElement(By.xpath("div[@class='x-tree-root-node']/li["+i+"]/div/a/span"));
            String rootName=RooCategoryName.getText();
            if (rootName.equals(DeleteCategoryNAME)) {
                utility.waitForElementPresent(RooCategoryName);
               try {
                   RooCategoryName.click();
               } catch (TimeoutException e){

               }
                clickDeleteRootCategorylink();
                utility.waitForAlertPresent();
                Alert alert = driver.switchTo().alert();
                alert.accept();

            }
            break;

        }

        VerifySuccessfulMsgDisplay();
    }


}
