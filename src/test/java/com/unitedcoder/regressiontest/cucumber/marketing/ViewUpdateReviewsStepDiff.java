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
    TestUtility utility=new TestUtility(driver);
    MarketingDashBoarPage dashBoarPage=new MarketingDashBoarPage();
    ReviewsPage reviewsPage=new ReviewsPage();
    @Given("Marketing Manager Already On Dashboard Pages")
    public void marketingManagerAlreadyOnDashboardPages() {
        dashBoarPage=new MarketingDashBoarPage();
    }

    @When("Marketing Manager click On pending reviews link")
    public void marketingManagerClickOnPendingReviewsLink() {
        dashBoarPage.goToPendingReviewsPage();
    }

    @And("Marketing manager review pending reviews")
    public void marketingManagerReviewPendingReviews() {

        reviewsPage.pendingReviewsAlreadyDisplay();
        utility.takeScreenShot("pendingReviews.png",driver);
    }

    @Then("all pending reviews already displayed on the UI")
    public void allPendingReviewsAlreadyDisplayedOnTheUI() {
        reviewsPage.isTotalReviewsLinkDisplayed();
        Assert.assertTrue(reviewsPage.isTotalReviewsLinkDisplayed());

    }

    @And("Marketing Manager search review for update")
    public void marketingManagerSearchReviewForUpdate() {
        reviewsPage.searchByIdForEdit(prop.getProperty("reviewId"));

    }

    @And("Marketing manager Edit review information and click save button")
    public void marketingManagerEditReviewInformationAndClickSaveButton() {
        reviewsPage.addReviewForEdit(prop.getProperty("reviewText"));
    }

    @Then("Pending Reviews updated successfully")
    public void pendingReviewsUpdatedSuccessfully() {
        reviewsPage.isPendingReviewUpdate();
        Assert.assertTrue(reviewsPage.isTotalReviewsLinkDisplayed());
    }

    @When("Marketing Manager click On all reviews link")
    public void marketingManagerClickOnAllReviewsLink() {
        dashBoarPage.goToAllReviewsPage();
    }

    @And("Marketing manager review All reviews")
    public void marketingManagerReviewAllReviews() {
        reviewsPage.viewAllReviews();
        utility.takeScreenShot("allReviews.png",driver);
    }

    @Then("all reviews already displayed on the UI")
    public void allReviewsAlreadyDisplayedOnTheUI() {
        reviewsPage.isTotalReviewsLinkDisplayed();
        Assert.assertTrue(reviewsPage.isTotalReviewsLinkDisplayed());
    }

    @And("Marketing manager Edit All review information and click save button")
    public void marketingManagerEditAllReviewInformationAndClickSaveButton() {
        reviewsPage.defineOneReviewForEdit(prop.getProperty("allReviewId"));
        reviewsPage.addReviewAndClickSaveButton(prop.getProperty("reviewTextForUpdate"));

    }

    @Then("All Reviews updated successfully")
    public void allReviewsUpdatedSuccessfully() {
        reviewsPage.isAllReviewUpdated();
        Assert.assertTrue(reviewsPage.isAllReviewUpdated());
    }
}
