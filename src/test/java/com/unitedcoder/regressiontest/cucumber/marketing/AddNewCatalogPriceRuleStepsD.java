package com.unitedcoder.regressiontest.cucumber.marketing;

import com.seleniummaster.magento.backendpages.marketingpages.CatalogPriceRulePage;
import com.seleniummaster.magento.backendpages.marketingpages.MarketingDashBoarPage;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AddNewCatalogPriceRuleStepsD extends TestBasePage {
    CatalogPriceRulePage catalogPriceRulePage;
    MarketingDashBoarPage dashBoarPage;
    TestUtility utility;
    @Given("user already on the dashboard page")
    public void userAlreadyOnTheDashboardPage() {


    }
    //Add New Catalog Price Rule
    @When("user click on the Promotions dropdown list then select on the Catalog Price Rules link")
    public void userClickOnThePromotionsDropdownListThenSelectOnTheCatalogPriceRulesLink() {
        dashBoarPage=new MarketingDashBoarPage();
        dashBoarPage.clickAllPromotionsLink();
        dashBoarPage.clickCatalogPriceRules();
        utility.sleep(1);
    }
    @And("user click on the Add New Rule link to fill out all New Rule information")
    public void userClickOnTheAddNewRuleLinkToFillOutAllNewRuleInformation() {
        catalogPriceRulePage.addNewCatalogPriceRule();
    }
    @Then("New Catalog Price should be added")
    public void newCatalogPriceShouldBeAdded() {
        Assert.assertTrue(catalogPriceRulePage.verifySuccessMessage());
    }
    //update existing Catalog price Rule

    @When("user click on the Promotions dropdown list then select on the Catalog Price Rules link and select an existing Rule Name")
    public void userClickOnThePromotionsDropdownListThenSelectOnTheCatalogPriceRulesLinkAndSelectAnExistingRuleName() {
        dashBoarPage.clickAllPromotionsLink();
        dashBoarPage.clickCatalogPriceRules();
        utility.sleep(2);
    }
    @And("user click on Actions link to update Price information then click on Save and Apply button")
    public void userClickOnActionsLinkToUpdatePriceInformationThenClickOnSaveAndApplyButton() {
        catalogPriceRulePage.enterRuleId("45");
        catalogPriceRulePage.clickSearchButton();
        utility.sleep(2);
        catalogPriceRulePage.clickOnMyRule();
        utility.sleep(2);
        catalogPriceRulePage.enterDescription();
        catalogPriceRulePage.clickUpdateSaveButton();
        utility.sleep(2);
    }
    @Then("existing Catalog Price Rule should be updated successfully")
    public void existingCatalogPriceRuleShouldBeUpdatedSuccessfully() {
        Assert.assertTrue(catalogPriceRulePage.verifySuccessMessage());
    }
    //Add new newsletter Template
    @When("user click on the Newsletter Template link from NewsLetter dropdown list")
    public void userClickOnTheNewsletterTemplateLinkFromNewsLetterDropdownList() {
        dashBoarPage.clickAllNewsLetterLink();
        dashBoarPage.clickNewsLetterTemplates();
    }
    @And("user click on the Add New Template link to fill out the Template Information form")
    public void userClickOnTheAddNewTemplateLinkToFillOutTheTemplateInformationForm() {
        catalogPriceRulePage.clickAddNewTemplate();
        catalogPriceRulePage.enterTemplateName();
        catalogPriceRulePage.enterTemplateSubject();
        catalogPriceRulePage.clickOnSaveTemplateButton();
    }
    @Then("new Newsletter Template added successfully")
    public void newNewsletterTemplateAddedSuccessfully() {
        Assert.assertTrue(catalogPriceRulePage.verifySuccessMessage());
    }
}
