package com.unitedcoder.regressiontest.cucumber.marketing;

import com.seleniummaster.magento.backendpages.marketingpages.AddAndUpDateCPriceRuleP;
import com.seleniummaster.magento.backendpages.marketingpages.AddNewsLetterTemplate;
import com.seleniummaster.magento.backendpages.marketingpages.MarketingDashBoarPage;
import com.seleniummaster.magento.utility.TestBasePage;
import com.seleniummaster.magento.utility.TestUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddNewCatalogPriceRuleStepsD extends TestBasePage {
    MarketingDashBoarPage dashBoarPage=new MarketingDashBoarPage();
    AddAndUpDateCPriceRuleP priceRuleP=new AddAndUpDateCPriceRuleP();
    AddNewsLetterTemplate newsLetterTemplate=new AddNewsLetterTemplate();
    TestUtility utility=new TestUtility(driver);
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
        priceRuleP.addNewCatalogPriceRule();


    }
    @Then("New Catalog Price should be added")
    public void newCatalogPriceShouldBeAdded() {
        priceRuleP.verifyNewRuleSuccessfullySaved();
    }
    //update existing Catalog price Rule

    @When("user click on the Promotions dropdown list then select on the Catalog Price Rules link and select an existing Rule Name")
    public void userClickOnThePromotionsDropdownListThenSelectOnTheCatalogPriceRulesLinkAndSelectAnExistingRuleName() {
        dashBoarPage=new MarketingDashBoarPage();
        dashBoarPage.clickAllPromotionsLink();
        dashBoarPage.clickCatalogPriceRules();
        utility.sleep(1);

    }
    @And("user click on Actions link to update Price information then click on Save and Apply button")
    public void userClickOnActionsLinkToUpdatePriceInformationThenClickOnSaveAndApplyButton() {
        priceRuleP.upDateExistingRule();

    }
    @Then("existing Catalog Price Rule should be updated successfully")
    public void existingCatalogPriceRuleShouldBeUpdatedSuccessfully() {
        priceRuleP.verifyAppliedSuccessMassage();

    }
    //Add new newsletter Template
    @When("user click on the Newsletter Template link from NewsLetter dropdown list")
    public void userClickOnTheNewsletterTemplateLinkFromNewsLetterDropdownList() {
        dashBoarPage.clickAllNewsLetterLink();
        dashBoarPage.clickNewsLetterTemplates();
    }
    @And("user click on the Add New Template link to fill out the Template Information form")
    public void userClickOnTheAddNewTemplateLinkToFillOutTheTemplateInformationForm() {
        newsLetterTemplate.clickAddNewTemplate();
        newsLetterTemplate.enterTemplateName();
        newsLetterTemplate.enterTemplateSubject();
        newsLetterTemplate.clickOnSaveTemplateButton();
    }
    @Then("new Newsletter Template added successfully")
    public void newNewsletterTemplateAddedSuccessfully() {
     newsLetterTemplate.verifyAddTemplateSuccessfully();
    }
}
