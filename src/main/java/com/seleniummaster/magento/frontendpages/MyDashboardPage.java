package com.seleniummaster.magento.frontendpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.lang.model.element.Element;

public class MyDashboardPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;

    @FindBy(xpath = "//div[@class=\"account-cart-wrapper\"]/a/span")
    WebElement accountTag;

    @FindBy(linkText = "Address Book")
    WebElement addressBookLink;
    //@FindBy(xpath = "//span[text()='Add New Address']")
    @FindBy(xpath = "//span[text()='Add New Address']/parent::button")
    WebElement addNewAddressLink;
    @FindBy(linkText = "Accountinformation")
    WebElement accountInformationLink;
    @FindBy(linkText = "MyOrders")
    WebElement myOrdersLink;
    @FindBy(linkText = "BillingAgreements")
    WebElement billingAgreementLink;
    @FindBy(linkText = "RecurringProfiles")
    WebElement recurringProfilesLink;
    @FindBy(linkText = "Productreviewlink")
    WebElement productReviewLink;
    @FindBy(linkText = "MyTags")
    WebElement myTagsLink;
    @FindBy(linkText = "Mywishlist")
    WebElement myWishListLink;
    @FindBy(linkText = "MyApplication")
    WebElement myApplicationLink;
    @FindBy(linkText = "NewsLetterSubscriptions")
    WebElement newsLetterSubscriptionsLink;
    @FindBy(xpath ="//div[@class='block-content']/ul/li[12]")
    WebElement downloadableProductsLink;
    @FindBy(linkText = "Changepasswordlink")
    WebElement changePasswordLink;
    @FindBy(linkText = "Checkoutlink")
    WebElement checkOutLink;
    @FindBy(linkText = "Editnewsletterlink")
    WebElement editNewsLetterLink;
    @FindBy(linkText = "Logoutlink")
    WebElement logOutLink;
    @FindBy(xpath = "//div[@class=\"welcome-msg\"]")
    WebElement welcomeMessage;


    public MyDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);

    }

    public void clickAccountTag() {
        utility.waitForElementPresent(accountTag);
        accountTag.click();
    }

    public void clickAddressBookLink() {
        utility.waitForElementPresent(addressBookLink);
        addressBookLink.click();
        Log.info("Address book link clicked");
    }

    public void clickAddNewAddressLink() {
        addNewAddressLink.click();
        Log.info("Add new address link clicked");
    }

    public AddNewAddressPage clickNewAddressPage() {
        clickAddressBookLink();
        clickAddNewAddressLink();
        return new AddNewAddressPage(driver);
    }
    public void clickMyOrders(){
        utility.waitForElementPresent(myOrdersLink);
        myOrdersLink.click();
    }
    public void clickBillingAgreements(){
        utility.waitForElementPresent(billingAgreementLink);
        billingAgreementLink.click();
    }
    public void clickRecurringProfiles(){
        Element clickRecurringProfiles;
        utility.waitForElementPresent(recurringProfilesLink);
        recurringProfilesLink.click();
    }
    public void clickProductreviewlink(){
        utility.waitForElementPresent(productReviewLink);
        productReviewLink.click();
    }
    private void clickMyTags(){
        utility.waitForElementPresent(myTagsLink);
        myTagsLink.click();
    }

    public void clickMyWishList(){
        utility.waitForElementPresent(myWishListLink);
        myWishListLink.click();
    }
    public void clickMyApplication(){
        utility.waitForElementPresent(myApplicationLink);
        myWishListLink.click();
    }
    public void clickNewsLetterSubscription(){
        utility.waitForElementPresent(newsLetterSubscriptionsLink);
        newsLetterSubscriptionsLink.click();
    }
    public void clickDownloadableProducts(){
        utility.waitForElementPresent(downloadableProductsLink);
        downloadableProductsLink.click();
    }

    public void clickChangePassword(){
        utility.waitForElementPresent(changePasswordLink);
        changePasswordLink.click();
    }

    public void clickCheckOut(){
        utility.waitForElementPresent(checkOutLink);
        checkOutLink.click();
    }
    public void clickEditNewsLetter(){
        utility.waitForElementPresent(editNewsLetterLink);
        editNewsLetterLink.click();
    }
    public void clickLogOut(){
        utility.waitForElementPresent(logOutLink);
        logOutLink.click();
    }
    public void verifyWelcomeMessage() {
        utility.waitForElementPresent(welcomeMessage);
        welcomeMessage.isDisplayed();
    }

}
