package com.seleniummaster.magento.backendpages.catalogpages;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DeleteRootCategoriesPage extends TestBasePage {
    CatalogDashboardPage dashboardPage;
    WebDriver driver;
    String ConfigFile = "config.properties";
    TestUtility utility;
    @FindBy(css = "button[title='Reset'][type='button']")
    WebElement ResetButton;
    @FindBy(xpath = "//button[@title='Delete Category']")
    WebElement DeleteCategoryLink;
    @FindBy(xpath = "//span[text()='The category has been deleted.']")
    WebElement DeleteSuccessMessage;

    public DeleteRootCategoriesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

    public void clickDeleteRootCategoryLink() {
        utility.waitForElementPresent(DeleteCategoryLink);
        DeleteCategoryLink.click();
    }

    public boolean VerifySuccessfulMsgDisplay() {
        utility.waitForElementPresent(DeleteSuccessMessage);
        DeleteSuccessMessage.isDisplayed();
        return true;
    }

    @FindBy(xpath = "(//span[text()=\"Sofia (1)\"])[1]")
    WebElement RootCategoryName;

    public void deleteRootCategory() {
        dashboardPage = new CatalogDashboardPage(driver);
        dashboardPage.clickCatalogLink();
        dashboardPage.clickManageCategories();
        RootCategoryName.click();
        clickDeleteRootCategoryLink();
        utility.waitForAlertPresent();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        VerifySuccessfulMsgDisplay();
        //String DeleteCategoryNAME = ApplicationConfig.readConfigProperties(ConfigFile, "DeleteCategoryName");
//        List<WebElement> RootCategoriesList = driver.findElements(By.xpath("//div[@class=\"tree-holder\"]/div/ul/div/li"));
//        for (int i = 1; i <= RootCategoriesList.size(); i++) {
//            WebElement RooCategoryName = driver.findElement(By.xpath("//div[@class='x-tree-root-node']/li[" + i + "]/div/a/span"));
//            String rootName = RooCategoryName.getText();
//            if ( RooCategoryName.getText().contains(DeleteCategoryNAME)) {
//                utility.waitForElementPresent(RooCategoryName);
//                utility.sleep(3);
//                    RooCategoryName.click();
//                clickDeleteRootCategoryLink();
//                utility.waitForAlertPresent();
//                Alert alert = driver.switchTo().alert();
//                alert.accept();
//
//            }
//            break;
//
//        }
//
//        VerifySuccessfulMsgDisplay();
//    }
    }

}
