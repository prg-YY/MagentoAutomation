package com.unitedcoder.regressiontest.cucumber.marketing;

import com.seleniummaster.magento.backendpages.marketingpages.CartPriceRulePage;
import com.seleniummaster.magento.backendpages.marketingpages.CatalogPriceRulePage;
import com.seleniummaster.magento.backendpages.marketingpages.MarketingDashBoarPage;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchCatalogPriceRuleIDAndNameStep extends TestBasePage {
    TestUtility utility=new TestUtility(driver);
    MarketingDashBoarPage  dashBoarPage=new MarketingDashBoarPage();
    CartPriceRulePage cartRulePage=new CartPriceRulePage();
    @Given("marketing user already on the pending reviews page")
    public void marketingUserAlreadyOnThePendingReviewsPage() {
       dashBoarPage=new MarketingDashBoarPage();
    }
    @When("marketing user click the menu of promotion the link of catalog price rule")
    public void marketingUserClickTheMenuOfPromotionTheLinkOfCatalogPriceRule() {
        dashBoarPage.clickAllPromotionsLink();
        dashBoarPage.clickCatalogPriceRules();
    }
    @Then("marketing user enter id and rule name in the relative field")
    public void marketingUserEnterIdAndRuleNameInTheRelativeField() {
        cartRulePage.searchingByRuleId(prop.getProperty("cartRuleId"));
        cartRulePage.clickOnResetFilter();
        cartRulePage.searchingByRuleName(prop.getProperty("cartRuleName"));
    }
    @And("verify search catalog price rule is ture")
    public void verifySearchCatalogPriceRuleIsTure() {
        cartRulePage.searchingResultDisplay();
        Assert.assertTrue(cartRulePage.searchingResultDisplay());
    }

}
