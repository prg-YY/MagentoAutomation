package com.seleniummaster.magento.backendpages.catalogpages;

import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProductPage extends TestBasePage {

    WebDriver driver;
    TestUtility utility;
    CatalogDashboardPage catalogDashboardPage;



    @FindBy(xpath = "//*[@id=\"productGrid_table\"]/tbody/tr[1]/td[3]")
    WebElement selectTheProduct;

    @FindBy(xpath = "//*[@title=\"Delete\"]")
    WebElement deleteButton;
    @FindBy(xpath = "//button[@id=\"id_b5fd6da2ca02225d90668e59e195c22b\"]")
    WebElement clickSubmitButton;
    @FindBy(xpath = "//div[@id='messages']/ul")
    WebElement DeleteSuccessMessage;

    public DeleteProductPage(WebDriver driver) {
        this.driver=TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility=new TestUtility(driver);
    }


    public void selectTheProduct(){
        utility.waitForElementPresent(selectTheProduct);
        selectTheProduct.click();
    }

    public void clickDeleteButton(){
        utility.waitForElementPresent(deleteButton);
        deleteButton.click();
    }


    public boolean verifySuccessMessage(){
        utility.waitForElementPresent(DeleteSuccessMessage);
        return DeleteSuccessMessage.isDisplayed();
    }
    public void deleteProduct(){
        catalogDashboardPage = new CatalogDashboardPage(driver);
        catalogDashboardPage.clickCatalogLink();
        catalogDashboardPage.clickManageProduct();
        selectTheProduct();
        clickDeleteButton();
        Alert alert=driver.switchTo().alert();
        alert.accept();


    }
}
