package com.unitedcoder.regressiontest.cucumber.marketing;

import com.seleniummaster.magento.backendpages.marketingpages.CartPriceRulePage;
import com.seleniummaster.magento.backendpages.marketingpages.MarketingDashBoarPage;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UpdateCartPriceRuleStepDef extends TestBasePage {
    MarketingDashBoarPage dashBoarPage;
    TestUtility utility;
    @Given("marketing backend user already on the dashboard page")
    public void marketingBackendUserAlreadyOnTheDashboardPage() {
        dashBoarPage=new MarketingDashBoarPage();
    }

    @When("marketing backend user click promotion menu and click  cart price rule link")
    public void marketingBackendUserClickPromotionMenuAndClickCartPriceRuleLink() {
       dashBoarPage.clickAllPromotionsLink();
       dashBoarPage.clickShoppingCartPriceRules();
    }

    @And("marketing manager search one rule and edit and save it")
    public void marketingManagerSearchOneRuleAndEditAndSaveIt() {
        CartPriceRulePage cartPriceRulePage=new CartPriceRulePage();
        cartPriceRulePage.updateCartRulePrice();
    }

    @Then("Existing cart price rule already updated")
    public void existingCartPriceRuleAlreadyUpdated() {
        CartPriceRulePage cartPriceRulePage=new CartPriceRulePage();
        cartPriceRulePage.updatedSuccessMessageIsDisplay();
        Assert.assertTrue(cartPriceRulePage.updatedSuccessMessageIsDisplay());
    }
}
