package com.seleniummaster.magento.frontendpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.lang.model.element.Element;
import java.util.List;

public class MyDashboardPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;

    @FindBy(xpath = "(//div[@class=\"account-cart-wrapper\"]/a/span)[2]")
    WebElement accountTag;
    @FindBy(xpath = "//div[@class=\"links\"]/ul/li/a")
    WebElement myAccountLink;
    @FindBy(xpath = "//div[@class=\"block-content\"]/ul/li[3]/a")
    WebElement addressBookLink;
    //@FindBy(xpath = "//span[text()='Add New Address']/parent::button")
    @FindBy(xpath = "//span[text()='Add New Address']")
    WebElement addNewAddressLink;
    @FindBy(xpath = "//div[@class=\"block-content\"]/ul/li[2]/a")
    WebElement accountInformationLink;
    @FindBy(xpath = "//div[@class=\"block-content\"]/ul/li[4]/a")
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
    @FindBy(xpath = "//div[@class='block-content']/ul/li[11]/a")
    WebElement newsLetterSubscriptionsLink;
    @FindBy(xpath ="//div[@class='block-content']/ul/li[12]/a")
    WebElement downloadableProductsLink;
    @FindBy(xpath = "//div[@class=\"box-content\"]/p/a")
    WebElement changePasswordLink;
    @FindBy(linkText = "Checkoutlink")
    WebElement checkOutLink;
    @FindBy(linkText = "Editnewsletterlink")
    WebElement editNewsLetterLink;
    @FindBy(linkText = "Logoutlink")
    WebElement logOutLink;
    @FindBy(xpath = "//div[@class=\"welcome-msg\"]")
    WebElement welcomeMessage;
    @FindBy(xpath = "//label[@for=\"subscription\"]")
    WebElement NewsletterContent;
    @FindBy(xpath = "//span[text()=\"Continue Shopping\"]")
    WebElement ContinueShoppingButton;


    public MyDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);

    }

    public void clickAccountTag() {
        utility.waitForElementPresent(accountTag);
        accountTag.click();
    }
    public void clickMyAccountLink(){
        utility.waitForElementPresent(myAccountLink);
        utility.sleep(2);
        myAccountLink.click();
    }

    public void clickAccounInformationLink(){
        utility.waitForElementPresent(accountInformationLink);
        utility.sleep(3);
        accountInformationLink.click();
    }

    public void clickAddressBookLink() {
        utility.waitForElementPresent(addressBookLink);
        utility.sleep(3);
        addressBookLink.click();
        Log.info("Address book link clicked");
    }

    public void clickAddNewAddressLink() {
        utility.waitForElementPresent(addNewAddressLink);
        utility.sleep(3);
        addNewAddressLink.click();
        Log.info("Add new address link clicked");
    }
    public void clickChangePasswordLink(){
        utility.waitForElementPresent(changePasswordLink);
        changePasswordLink.click();
    }

    public UpdateAddressPage clickNewAddressPage() {
        clickAddressBookLink();
        clickAddNewAddressLink();
        return new UpdateAddressPage(driver);
    }
    public void clickMyOrders(){
        utility.waitForElementPresent(myOrdersLink);
        utility.sleep(3);
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
    public void clickContinueShoppingButton(){
        utility.waitForElementPresent(ContinueShoppingButton);
        ContinueShoppingButton.click();
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
        utility.sleep(3);
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
    @FindBy(xpath = "(//div[@id=\"header-nav\"]/nav/ol/li/a)[1]")
    WebElement team1Link;
    @FindBy(xpath = "(//span[text()=\"Add to Cart\"])[1]")
    WebElement selectedProductAddToCartButton;
    @FindBy(xpath = "//*[contains(text(), \"was added to your shopping cart.\")]")
    WebElement AddToCartSuccessfulMsg;

    public void clickTeam1Link(){
        utility.waitForElementPresent(team1Link);
        utility.sleep(3);
        team1Link.click();
    }
    public void clickAddToCartButton(){
        utility.waitForElementPresent(selectedProductAddToCartButton);
        utility.sleep(3);
        selectedProductAddToCartButton.click();
    }
    public boolean VerifyAddToCartSuccessful(){
        utility.waitForElementPresent(AddToCartSuccessfulMsg);
        if (AddToCartSuccessfulMsg.isDisplayed()) {
            Log.info("Test Passed ,product successfully add to cart");
            return true;
        }else
            Log.info("Test Failed");
        return false;

    }

    public void addNewProduct(){
        clickTeam1Link();
        clickAddToCartButton();
        VerifyAddToCartSuccessful();

    }
    @FindBy(xpath = "//div[@class=\"my-account\"]/table/tbody/tr")
    List<WebElement> MyOrdersList;
    public boolean viewOrders(){
        clickMyOrders();
        for (int i=1;i<=MyOrdersList.size();i++){
            if (i>=1){
                System.out.println("test past");
            }
            else
                System.out.println("test failed");
        }
        return true;
    }

    public boolean newsLetterSubscriptionsLinkIsDisplay(){
        utility.waitForElementPresent(newsLetterSubscriptionsLink);
        utility.sleep(3);
        if (newsLetterSubscriptionsLink.isDisplayed()) {
            System.out.println("Test Passed,Newsletter Subscription Link has been seen");
        }else System.out.println("Test Failed");
        return true;
    }

    public boolean NewsletterReviewsContent() {
        clickNewsLetterSubscription();
        utility.waitForElementPresent(NewsletterContent);
        utility.sleep(3);
        NewsletterContent.isDisplayed();
        return true;
    }


}
