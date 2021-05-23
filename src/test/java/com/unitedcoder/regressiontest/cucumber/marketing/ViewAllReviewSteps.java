package com.unitedcoder.regressiontest.cucumber.marketing;

import com.seleniummaster.magento.backendpages.marketingpages.MarketingDashBoarPage;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewAllReviewSteps extends TestBasePage {
    @Given("marketing manager should be on the dashboard page")
    public void marketingManagerShouldBeOnTheDashboardPage() {
    }
    @When("marketing manager click catalog menu and select review and rating and select customer reviews")
    public void marketingManagerClickCatalogMenuAndSelectReviewAndRatingAndSelectCustomerReviews() {
        MarketingDashBoarPage marketingDashBoarPage=new MarketingDashBoarPage();
        marketingDashBoarPage.clickAllCatalogLink();
        marketingDashBoarPage.clickPendingReviewsLink();
        marketingDashBoarPage.clickCustomerReviewsLink();
    }
    @Then("marketing manager click the all review link")
    public void marketingManagerClickTheAllReviewLink() {
        MarketingDashBoarPage marketingDashBoarPage=new MarketingDashBoarPage();
        marketingDashBoarPage.clickAllReviewsLink();
    }
    @And("verify view page")
    public void verifyViewPage() {
        TestUtility utility=new TestUtility(driver);
        utility.takeScreenShot("ViewAllReview.png",driver);
    }
}
