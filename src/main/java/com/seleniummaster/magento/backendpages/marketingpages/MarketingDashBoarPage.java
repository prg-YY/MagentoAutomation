package com.seleniummaster.magento.backendpages.marketingpages;

import com.seleniummaster.magento.utility.Log;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketingDashBoarPage extends TestBasePage {

    WebDriver driver;
    TestUtility utility;

    @FindBy(xpath = "//span[text()='Catalog']")
    WebElement allCatalogLink;
    @FindBy(xpath = "//span[text()='Reviews and Ratings']")
    WebElement reviewsAndRatingsLink;
    @FindBy(xpath = "//span[text()='Customer Reviews']")
    WebElement customerReviewsLink;
    @FindBy(xpath = "//span[text()='Pending Reviews']")
    WebElement pendingReviewsLink;
    @FindBy(xpath = "//span[text()='All Reviews']")
    WebElement allReviewsLink;
    @FindBy(xpath = "//span[text()='Manage Ratings']")
    WebElement manageRatingsLink;
    @FindBy(xpath = "//span[text()='Promotions']")
    WebElement allPromotionsLink;
    @FindBy(xpath = "//span[text()='Catalog Price Rules']")
    WebElement catalogPriceRules;
    @FindBy(xpath = "//span[text()='Shopping Cart Price Rules']")
    WebElement shoppingCartPriceRules;
    @FindBy(xpath = "//span[text()='Newsletter']")
    WebElement allNewsLetterLink;
    @FindBy(xpath = "//span[text()='Newsletter Templates']")
    WebElement newsLetterTemplates;
    @FindBy(xpath ="//span[text()='Newsletter Queue']")
    WebElement newsLetterQueue;
    @FindBy(xpath = "//span[text()='Newsletter Subscribers']")
    WebElement newsletterSubscribersLink;
    @FindBy(xpath = "//span[text()='Newsletter Problem Reports']")
    WebElement newsletterProblemReports;
    @FindBy(css = "input[name='reviews'][type='checkbox']")
    WebElement checkBox;
    @FindBy(css = "button[title='Reset Filter'][type='button']")
    WebElement resetFilterLink;
    @FindBy(css = "button[title='Search'][type='button']")
    WebElement searchLink;
    @FindBy(css = "button[title='Submit'][type='button']")
    WebElement submitLink;
    @FindBy(xpath = "//*[@id=\"promo_quote_grid_table\"]/tbody/tr/td[2]")
    WebElement cartPriceRules;
    @FindBy(xpath = "//*[@class=\"link-logout\"]")
    WebElement logOutLink;


    public MarketingDashBoarPage( ) {
        this.driver = TestBasePage.driver;
        PageFactory.initElements(driver, this);
        utility = new TestUtility(driver);
    }

    public void clickAllCatalogLink() {
        utility.waitForElementPresent(allCatalogLink);
        allCatalogLink.click();
        Log.info("All Catalog link clicked");
    }
    public void clickReviewsAndRatingsLink(){
        utility.waitForElementPresent(reviewsAndRatingsLink);
        reviewsAndRatingsLink.click();
        Log.info("Reviews And Ratings Link clicked");
    }
    public void clickCustomerReviewsLink(){
        utility.waitForElementPresent(customerReviewsLink);
        customerReviewsLink.click();
        Log.info("Customer Reviews Link clicked");
    }
    public void clickPendingReviewsLink(){
        utility.waitForElementPresent(pendingReviewsLink);
        pendingReviewsLink.click();
        Log.info("Pending Reviews Link Clicked");
    }
    public void clickAllReviewsLink(){
        utility.waitForElementPresent(allReviewsLink);
        allReviewsLink.click();
        Log.info("All Reviews Link Clicked");
    }
    public void clickManageRatingsLink(){
        utility.waitForElementPresent(manageRatingsLink);
        manageRatingsLink.click();
        Log.info("Manage Ratings Link Clicked");
    }
    public void clickAllPromotionsLink(){
        utility.waitForElementPresent(allPromotionsLink);
        allPromotionsLink.click();
        Log.info("All Promotions Link Clicked");
    }
    public void clickCatalogPriceRules(){
        utility.waitForElementPresent(catalogPriceRules);
        catalogPriceRules.click();
        Log.info("Catalog Price Rules Clicked");
    }
    public void clickShoppingCartPriceRules(){
        utility.waitForElementPresent(shoppingCartPriceRules);
        shoppingCartPriceRules.click();
        utility.sleep(2);
        Log.info("ShoppingCart Price Rules Clicked");
    }
    public void clickAllNewsLetterLink(){
        utility.waitForElementPresent(allNewsLetterLink);
        allNewsLetterLink.click();
        Log.info("All News Letter Link Clicked");
    }
    public void clickNewsLetterTemplates(){
        utility.waitForElementPresent(newsLetterTemplates);
        newsLetterTemplates.click();
        Log.info("News Letter Templates Clicked");
    }
    public void clickNewsLetterQueue(){
        utility.waitForElementPresent(newsLetterQueue);
        newsLetterQueue.click();
        Log.info("News Letter Queue Clicked");
    }
    public void clickNewsletterSubscribersLink(){
        utility.waitForElementPresent(newsletterSubscribersLink);
        newsletterSubscribersLink.click();
        Log.info("News Letter Subscribers Link Clicked");
    }
    public void clickNewsletterProblemReports(){
        utility.waitForElementPresent(newsletterProblemReports);
        newsletterProblemReports.click();
        Log.info("News Letter Problem Reports Clicked");
    }
    public void clickCheckBox(){
        utility.waitForElementPresent(checkBox);
        checkBox.click();
        Log.info("Check Box Clicked");
    }
    public void clickResetFilterLink(){
        utility.waitForElementPresent(resetFilterLink);
        resetFilterLink.click();
        Log.info("Reset Filter Link Clicked");
    }
    public void clickSearchLink(){
        utility.waitForElementPresent(searchLink);
        searchLink.click();
        Log.info("Search Link Clicked");
    }
    public void clickSubmitLink(){
        utility.waitForElementPresent(submitLink);
        submitLink.click();
        Log.info("Submit Link Clicked");
    }
    public void clickLogOutLink(){
        utility.waitForElementPresent(logOutLink);
        logOutLink.click();
        Log.info("Log Out Link Clicked");
    }
    public void ShoppingCartPriceRulesVerify(){
        utility.sleep(2);
        cartPriceRules.isDisplayed();

      }

      public void goToPendingReviewsPage(){
        clickAllCatalogLink();
        clickReviewsAndRatingsLink();
        clickCustomerReviewsLink();
        clickPendingReviewsLink();
        utility.sleep(1);
      }
      public void goToAllReviewsPage(){
          clickAllCatalogLink();
          clickReviewsAndRatingsLink();
          clickCustomerReviewsLink();
          clickAllReviewsLink();
          utility.sleep(1);
      }
      public void goToNewsLetterSubscribersPage(){
        clickAllNewsLetterLink();
        clickNewsletterSubscribersLink();
        utility.sleep(1);
      }


}
