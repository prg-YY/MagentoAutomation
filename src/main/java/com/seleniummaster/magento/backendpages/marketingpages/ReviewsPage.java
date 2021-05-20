package com.seleniummaster.magento.backendpages.marketingpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewsPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    MarketingDashBoarPage marketingDashBoarPage;

    @FindBy(xpath = "(//td[@class=\" last\"])[1]")//valid pending reviews page and all reviews page
    WebElement editButton;
    @FindBy(xpath = "//div[@class='admin__control-support-text']")
    WebElement verifymessage;
    @FindBy(xpath = "//td[contains(text(),'AyseOsman')]")
    WebElement clickCustomer;
    @FindBy (xpath ="//select[@id='status_id']")
    WebElement dropdownList;
    @FindBy (xpath ="//option[contains(text(),'Pending')]")
    WebElement pending;
    @FindBy(xpath = "//span[contains(text(),'Save Review')]")
    WebElement saveButton;
    @FindBy(xpath = "//div[text()='You saved the review.']")
    WebElement successMessage;

    public ReviewsPage() {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

   public void clickAnyEditButton(){
        utility.waitForElementPresent(editButton);
        editButton.click();
       Log.info("Edit Button Clicked");
   }
    public boolean verifyReviews(){
        utility.waitForElementPresent(verifymessage);
        return verifymessage.isDisplayed();
    }
    public void clickCustomer()
    {
        utility.waitForElementPresent(clickCustomer);
        clickCustomer.click();
        Log.info("Customer Clicked");
    }
    public void clickDropDownList()
    {
        utility.waitForElementPresent(dropdownList);
        dropdownList.click();
        Log.info("Dropdown List Clicked");
    }
    public void clickPending()
    {
        utility.waitForElementPresent(pending);
        pending.click();
        Log.info("Pending Link Clicked");
    }
    public void clickSaveButton()
    {
        utility.waitForElementPresent(saveButton);
        saveButton.click();
        Log.info("Save button clicked");
    }
    public boolean verifySuccess(){
        utility.waitForElementPresent(successMessage);
        return successMessage.isDisplayed();
    }
    public boolean marketingManagerUpdatePendingReviews() {
        clickCustomer();
        clickDropDownList();
        clickPending();
        clickSaveButton();
        return verifySuccess();
    }
}
