package com.unitedcoder.regressiontest.cucumber.marketing;

import com.seleniummaster.magento.backendpages.marketingpages.MarketingDashBoarPage;
import com.seleniummaster.magento.backendpages.marketingpages.ReviewsPage;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ViewUpdateReviewsStepDiff extends TestBasePage {
    TestUtility utility;
    MarketingDashBoarPage dashBoarPage;
    ReviewsPage reviewsPage=new ReviewsPage();
    @Given("Marketing Manager Already On Dashboard Pages")
    public void marketingManagerAlreadyOnDashboardPages() {
        dashBoarPage=new MarketingDashBoarPage();
    }

    @When("Marketing Manager click On pending reviews link")
    public void marketingManagerClickOnPendingReviewsLink() {
        dashBoarPage.clickAllCatalogLink();
        dashBoarPage.clickReviewsAndRatingsLink();
        dashBoarPage.clickCustomerReviewsLink();
        dashBoarPage.clickPendingReviewsLink();
    }

    @And("Marketing manager review pending reviews")
    public void marketingManagerReviewPendingReviews() {
        reviewsPage.viewPendingReviews();
    }

    @Then("all pending reviews already displayed on the UI")
    public void allPendingReviewsAlreadyDisplayedOnTheUI() {
        reviewsPage.isTotalReviewsLinkDisplayed();
        Assert.assertTrue(reviewsPage.isTotalReviewsLinkDisplayed());

    }

    @And("Marketing Manager search review for update")
    public void marketingManagerSearchReviewForUpdate() {
    }

    @And("Marketing manager Edit review information and click save button")
    public void marketingManagerEditReviewInformationAndClickSaveButton() {
    }

    @Then("Pending Reviews updated successfully")
    public void pendingReviewsUpdatedSuccessfully() {
    }

    @When("Marketing Manager click On all reviews link")
    public void marketingManagerClickOnAllReviewsLink() {
    }

    @And("Marketing manager review All reviews")
    public void marketingManagerReviewAllReviews() {
    }

    @Then("all reviews already displayed on the UI")
    public void allReviewsAlreadyDisplayedOnTheUI() {
    }

    @And("Marketing manager Edit All review information and click save button")
    public void marketingManagerEditAllReviewInformationAndClickSaveButton() {
    }

    @Then("All Reviews updated successfully")
    public void allReviewsUpdatedSuccessfully() {
    }
}
