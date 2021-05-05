package com.seleniummaster.magento.backendpages.customerpages;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerManagerResetPasswordPage {
    WebDriver driver;
    TestUtility utility;
    String customer = "dont-delete";
    @FindBy(xpath = "//div[@id=\"container\"]//table/tbody/tr[2]/td[@class='data-grid-actions-cell']/a")
    WebElement editLink;
    @FindBy(xpath = "//span[text()='Reset Password']")
    WebElement resetPassword;
    @FindBy(xpath = "//div[@data-ui-id='messages-message-success']")
    WebElement confirmationMessage;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    //create a constructor to initialize the page // page factory
    public CustomerManagerResetPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //combine driver with page factory
        utility = new TestUtility(driver); //combine driver with page factory
    }
    public void clickEditLink(){
        utility.waitForElementPresent(editLink);
        JavascriptExecutor executor=(JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",editLink);
        Log.info("Edit link is clicked");
    }
    public void clickEditButton()
    {
        //String customer = String.format("//div[text()='%s']/ancestor::tr//a", TestDataHolder.getCustomerEmail());
        WebElement element = driver.findElement(By.xpath(customer));
        utility.waitForElementPresent(element);
        js.executeScript("arguments[0].click();",element);
        Log.info("Edit button clicked");
    }
    public void clickResetPassword()
    {
        CustomerPage customerPage = new CustomerPage(driver);
        utility.waitForElementPresent(resetPassword);
        resetPassword.click();
        js.executeScript("arguments[0].click();",resetPassword);
        Log.info("Reset password button clicked");
    }
    public boolean isConfirmationDisplayed() {
        utility.waitForElementPresent(confirmationMessage);
        return confirmationMessage.isDisplayed();
    }
    public boolean resetPassword()
    {
        CustomerPage customerPage = new CustomerPage(driver);
        clickEditButton();
        clickEditLink();
        clickResetPassword();
        return isConfirmationDisplayed();
    }

}
