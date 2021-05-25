package com.unitedcoder.regressiontest.cucumber.marketing;

import com.seleniummaster.magento.backendpages.marketingpages.NewsLetterPage;
import com.seleniummaster.magento.utility.TestBasePage;

import com.seleniummaster.magento.backendpages.marketingpages.MarketingDashBoarPage;
import com.seleniummaster.magento.utility.TestUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ViewNewsLetterSubscribersStep extends TestBasePage {
    MarketingDashBoarPage dashBoarPage=new MarketingDashBoarPage();
    NewsLetterPage newsLetterPage=new NewsLetterPage();
    @Given("marketing manager should be on the home page")
    public void marketingManagerShouldBeOnTheHomePage() {
        dashBoarPage=new MarketingDashBoarPage();
    }
    @When("marketing manager click newsletter menu and click the newsletter subscribers link")
    public void marketingManagerClickNewsletterMenuAndClickTheNewsletterSubscribersLink() {
        dashBoarPage.goToNewsLetterSubscribersPage();
        newsLetterPage.newsletterSubscribersListIsDisplay();
    }
    @Then("verify newsletter subscribers")
    public void verifyNewsletterSubscribers() {
        newsLetterPage.isNewsLetterSubscriberRecordDisplay();
        Assert.assertTrue(newsLetterPage.isNewsLetterSubscriberRecordDisplay());

    }
}
