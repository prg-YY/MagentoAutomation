package com.seleniummaster.magento.frontendpages;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    @FindBy(xpath = "//*[@id=\"header-account\"]/div/ul/li[1]/a")
    WebElement myAccountLink;
    @FindBy(css = "div[class=\"page-title\"]")
    WebElement successMessage;
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility=new TestUtility(driver);
    }
    public void clickMyAccountLink(){
        utility.waitForElementPresent(myAccountLink);
        myAccountLink.click();
        Log.info("My Wish List Clicked");
    }
    public boolean verifyMyAccountLink(){
        utility.waitForElementPresent(successMessage);
        Log.info("My Account Link Displayed");
        return successMessage.isDisplayed();
    }

}
