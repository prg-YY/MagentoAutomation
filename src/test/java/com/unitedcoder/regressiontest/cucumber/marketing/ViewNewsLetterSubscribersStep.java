package com.unitedcoder.regressiontest.cucumber.marketing;

import com.seleniummaster.magento.utility.TestBasePage;

import com.seleniummaster.magento.backendpages.marketingpages.MarketingDashBoarPage;
import com.seleniummaster.magento.utility.TestUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewNewsLetterSubscribersStep extends TestBasePage {
    @Given("marketing manager should be on the home page")
    public void marketingManagerShouldBeOnTheHomePage() {
    }
    @When("marketing manager click newsletter menu and click the newsletter subscribers link")
    public void marketingManagerClickNewsletterMenuAndClickTheNewsletterSubscribersLink() {
        MarketingDashBoarPage marketingDashBoarPage=new MarketingDashBoarPage();
        marketingDashBoarPage.clickAllNewsLetterLink();
        marketingDashBoarPage.clickNewsletterSubscribersLink();
    }
    @Then("verify newsletter subscribers")
    public void verifyNewsletterSubscribers() {
        TestUtility testUtility=new TestUtility(driver);
        testUtility.takeScreenShot("viewNewsletterSubscribers.png",driver);
    }
}
