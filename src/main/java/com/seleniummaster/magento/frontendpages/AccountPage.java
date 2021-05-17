package com.seleniummaster.magento.frontendpages;
import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends TestBasePage {
    WebDriver driver;
    TestUtility utility;
    @FindBy(xpath = "//strong[contains(text(),'Account Information')]")
    WebElement accountInformationText;
    @FindBy(xpath = "//a[contains(text(),'My Downloadable Products')]")
    WebElement downloadableProductLink;
    @FindBy(xpath = "//span[text()='You have not purchased any downloadable products yet.']")
    WebElement javaBook;
    @FindBy(xpath = "//a[contains(text(),'My Product Reviews')]")
    WebElement productReviewLink;
    @FindBy(xpath = "//main[@id='maincontent']/div[2]/div/div[3]/span")
    WebElement pageContent;
    @FindBy(linkText = "My Wish List")
    WebElement mywishlist;
    @FindBy(xpath = "//span[contains(text(),'My Wish List')]")
    WebElement verificationLink;
    @FindBy(linkText = "Newsletter Subscriptions")
    WebElement newsletterLink;
    @FindBy(xpath = "//a[contains(text(),'Stored Payment Methods')]")
    WebElement storedPaymentLink;
    @FindBy(xpath = "//span[contains(text(),'Stored Payment Methods')]")
    WebElement verifyStoredPaymentPage;
    @FindBy(xpath = "//a[contains(text(),'Account Information')]")
    WebElement accountInformationLink;
    @FindBy(xpath = "//div[text()='You saved the account information.']")
    WebElement savedAccountInformationText;
    @FindBy(xpath = "//a[contains(text(),'Change Password')]")
    WebElement changePasswordLink;
    @FindBy(xpath = "//*contains9text(),'you saved")
    WebElement confirmMessege;
    @FindBy(xpath = "//a[text()='My Account']")
    WebElement myAccountLink;
    @FindBy(linkText = "Address Book")
    WebElement addressBookLink;
    //@FindBy(xpath = "//span[text()='Add New Address']")
    @FindBy(xpath = "//span[text()='Add New Address']/parent::button")
    WebElement addNewAddressLink;
    @FindBy(xpath = "//a[text()='My Orders']")
    WebElement myOrdersTab;
    @FindBy(xpath = "//span[@class='base']")
    WebElement myOrderTitle;
    @FindBy(xpath = "//span[text()='Delete']")
    WebElement deleteAddressButton;
    @FindBy(xpath = "//span[text()='OK']")
    WebElement acceptButton;
    @FindBy(xpath = "//div[text()='You deleted the address.']")
    WebElement deleteSuccessMsg;
    public AccountPage() {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver); //combine driver with page factory
        PageFactory.initElements(driver, this);
    }

    public boolean verifyAccountInformationText() {
        utility.waitForElementPresent(accountInformationText);
        return accountInformationText.isDisplayed();
    }

    public boolean verifyDeleteSuccess()
    {
        utility.waitForElementPresent(deleteSuccessMsg);
        return deleteSuccessMsg.isDisplayed();
    }

    public void clickDownloadableProductLink() {
        utility.waitForElementPresent(downloadableProductLink);
        downloadableProductLink.click();
        Log.info("Downloadable product link clicked");
    }

    public boolean verifyDownloadableProduct() {
        utility.waitForElementPresent(javaBook);
        return javaBook.isDisplayed();
    }

    public void clickProductReviewLink() {
        utility.waitForElementPresent(productReviewLink);
        productReviewLink.click();
        Log.info("Product review link clicked");
    }

    public boolean verifyProductReviewPage() {
        utility.waitForElementPresent(pageContent);
        return pageContent.isDisplayed();
    }

    public void clickMyWishList() {
        utility.waitForElementPresent(mywishlist);
        mywishlist.click();
        Log.info("My wish list link clicked");
    }

    public boolean verifySuccess() {
        utility.waitForElementPresent(verificationLink);
        return verificationLink.isDisplayed();
    }

    public boolean MyWishList() {
        clickMyWishList();
        return verifySuccess();
    }

    public void clickstoredPaymentLink() {
        utility.waitForElementPresent(storedPaymentLink);
        storedPaymentLink.click();
        Log.info("Stored payment link clicked");
    }

    public boolean verifyStoredPayment() {
        utility.waitForElementPresent(verifyStoredPaymentPage);
        String verifySeePage = verifyStoredPaymentPage.getText();
        return verifyStoredPaymentPage.isDisplayed();
    }
    public void clickAddressBookLink()
    {
        utility.waitForElementPresent(addressBookLink);
        addressBookLink.click();
        Log.info("Address book link clicked");
    }
    public void clickAddNewAddressLink()
    {
        addNewAddressLink.click();
        Log.info("Add new address link clicked");
    }

    public AddNewAddressPage clickNewAddressPage()
    {
        clickAddressBookLink();
        clickAddNewAddressLink();
        return new AddNewAddressPage(driver);
    }
}


