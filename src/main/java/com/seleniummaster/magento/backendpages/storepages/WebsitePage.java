package com.seleniummaster.magento.backendpages.storepages;

import com.seleniummaster.magento.utility.ApplicationConfig;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebsitePage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    String ConfigFile = "config.properties";

    @FindBy(xpath = "(//span[text()='System'])[1]")
    WebElement SystemButton;

    @FindBy(xpath = "(//span[text()='Create Website'])[1]")
    WebElement CreateWebsiteButton;

    @FindBy(css = "#website_name")
    WebElement NameTextBox;

    @FindBy(css = "#website_code")
    WebElement CodeTextBox;

    @FindBy(css = "#website_sort_order")
    WebElement SortOrderTextBox;

    @FindBy(xpath = "(//span[text()='Save Website'])[1]")
    WebElement SaveWebsiteButton;
    @FindBy(xpath = "//span[text()=\"The website has been saved.\"]")
    WebElement ConfirmationMessage;

    public WebsitePage(WebDriver driver) {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

    public void clickCreateWebsiteButton() {
        utility.waitForElementPresent(CreateWebsiteButton);
        CreateWebsiteButton.click();
    }

    public void enterNameTextBox(String WebName) {
        utility.waitForElementPresent(NameTextBox);
        NameTextBox.sendKeys(WebName);
    }

    public void enterCode(String Code) {
        utility.waitForElementPresent(CodeTextBox);
        CodeTextBox.sendKeys(Code + System.currentTimeMillis());
    }

    public void clickSaveButton() {
        utility.waitForElementPresent(SaveWebsiteButton);
        SaveWebsiteButton.click();
    }

    public boolean verifySuccess() {
        utility.waitForElementPresent(ConfirmationMessage);
        return ConfirmationMessage.isDisplayed();
    }

    public void createWebsite() {
        enterNameTextBox(prop.getProperty("NewWebName"));
        enterCode(prop.getProperty("WebCode"));
        clickSaveButton();
        verifySuccess();

    }
// edit website
    @FindBy(xpath = "//table[@class=\"data\"]/tbody/tr/td")
    List<WebElement> NameList;
    @FindBy(xpath = "//*[@id=\"page:main-container\"]/div[3]/div/table/tbody/tr[1]/td[1]/a")
    WebElement WebsiteName;
    public boolean editWebsite() {
        WebsiteName.click();
        CodeTextBox.clear();
        CodeTextBox.sendKeys(prop.getProperty("WebCode")+System.currentTimeMillis());
        clickSaveButton();
        return verifySuccess();
        }



    }

