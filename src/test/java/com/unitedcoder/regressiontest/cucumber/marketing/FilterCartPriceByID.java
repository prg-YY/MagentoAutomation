package com.unitedcoder.regressiontest.cucumber.marketing;

import com.seleniummaster.magento.backendpages.marketingpages.CatalogPriceRulePage;
import com.seleniummaster.magento.backendpages.marketingpages.MarketingDashBoarPage;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterCartPriceByID extends TestBasePage {
    MarketingDashBoarPage dashBoarPage=new MarketingDashBoarPage();
    TestUtility utility=new TestUtility(driver);
    CatalogPriceRulePage priceRulePage=new CatalogPriceRulePage();
    @When("click on Promotions drop down list than click on Shopping Cart Price Rules")
    public void clickOnPromotionsDropDownListThanClickOnShoppingCartPriceRules() {
        dashBoarPage.clickAllPromotionsLink();
        utility.sleep(1);
        dashBoarPage.clickShoppingCartPriceRules();
        utility.sleep(1);

    }

    @And("fill the ID field and Rule Name field then click on Search Button")
    public void fillTheIDFieldAndRuleNameFieldThenClickOnSearchButton() {
        priceRulePage.clickRuleNameTextBox();
        utility.sleep(1);
        priceRulePage.clickRuleIdTextBox();
        priceRulePage.clickSearchButton();
        utility.sleep(1);
    }

    @Then("verify Shopping Cart Price Rules on the right up")
    public void verifyShoppingCartPriceRulesOnTheRightUp() {
        dashBoarPage.ShoppingCartPriceRulesVerify();
        utility.takeScreenShot("Shopping_Cart_Price_Rules",driver);
    }
}
