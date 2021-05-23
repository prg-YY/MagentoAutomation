package com.unitedcoder.regressiontest.cucumber.marketing;

import com.seleniummaster.magento.backendpages.marketingpages.CartPriceRulePage;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.backendpages.marketingpages.MarketingDashBoarPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddCartPriceRuleSteps  extends TestBasePage {
    MarketingDashBoarPage dashBoarPage;
    @Given("User already on the dashboard page")
    public void userAlreadyOnTheDashboardPage() {

        dashBoarPage=new MarketingDashBoarPage();
    }
    @When("User Click promotion menu and click the cart price rule link")
    public void userClickPromotionMenuAndClickTheCartPriceRuleLink() {
        dashBoarPage.clickAllPromotionsLink();
        dashBoarPage.clickShoppingCartPriceRules();
    }
    @And("user click on add new rule button to fill out cart price rule  information")
    public void userClickOnAddNewRuleButtonToFillOutCartPriceRuleInformation() {
        CartPriceRulePage cartPriceRulePage=new CartPriceRulePage();
        cartPriceRulePage.addNewCartPriceRule(prop.getProperty("cartPriceRuleName"));
    }
    @Then("cart price rule  should be added")
    public void cartPriceRuleShouldBeAdded() {
        CartPriceRulePage cartPriceRulePage=new CartPriceRulePage();
        cartPriceRulePage.verifySaveMessage();
    }
}
