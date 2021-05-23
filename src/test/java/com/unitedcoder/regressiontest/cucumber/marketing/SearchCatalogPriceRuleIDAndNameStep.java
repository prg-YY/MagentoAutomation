package com.unitedcoder.regressiontest.cucumber.marketing;

import com.seleniummaster.magento.backendpages.marketingpages.CatalogPriceRulePage;
import com.seleniummaster.magento.backendpages.marketingpages.MarketingDashBoarPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchCatalogPriceRuleIDAndNameStep  {
    @Given("marketing user already on the pending reviews page")
    public void marketingUserAlreadyOnThePendingReviewsPage() {
    }
    @When("marketing user click the menu of promotion the link of catalog price rule")
    public void marketingUserClickTheMenuOfPromotionTheLinkOfCatalogPriceRule() {
        MarketingDashBoarPage dashBoarPage=new MarketingDashBoarPage();
        dashBoarPage.clickAllPromotionsLink();
        dashBoarPage.clickCatalogPriceRules();
    }
    @Then("marketing user enter id and rule name in the relative field")
    public void marketingUserEnterIdAndRuleNameInTheRelativeField() {
        CatalogPriceRulePage catalogPriceRulePage=new CatalogPriceRulePage();
        catalogPriceRulePage.clickRuleIdTextBox();
        catalogPriceRulePage.clickSearchButton();

        catalogPriceRulePage.enterRuleName("");

    }
    @And("verify search catalog price rule is ture")
    public void verifySearchCatalogPriceRuleIsTure() {
    }

}
