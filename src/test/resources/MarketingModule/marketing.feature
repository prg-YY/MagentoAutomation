@ViewAllReviews
Scenario:marketing manager should be view all reviews
Given marketing manager
@MarketingModule
  Feature: Marketing manager should be able to...
    -Filter Cart Pricing
    -view pending Reviews
    -update pending Reviews
    -view All Reviews
    -update All Reviews
    -add New Cart Price Rule
    -Update Existing Cart Price Rule
    -Search Catalog Pricing Rule By Id And Name
    -view All Reviews
    -view Newsletter Subscribers

    Background:
      Given user on login page
      When user enter username and password click on login button
      Then user successfully login to the system

    @FilterCartPricing
    Scenario: Marketing Manager can filter Cart Pricing Rule by Id and Rule Name
      When click on Promotions drop down list than click on Shopping Cart Price Rules
      And fill the ID field and Rule Name field then click on Search Button
      Then verify Shopping Cart Price Rules on the right up

    @ViewPendingReviews
    Scenario: Marketing Manager can view pending Reviews
      Given Marketing Manager Already On Dashboard Pages
      When Marketing Manager click On pending reviews link
      And Marketing manager review pending reviews
      Then all pending reviews already displayed on the UI

    @UpdatePendingReview
    Scenario: Marketing Manager can Update pending Reviews
      When Marketing Manager click On pending reviews link
      And Marketing Manager search review for update
      And Marketing manager Edit review information and click save button
      Then Pending Reviews updated successfully
    @ViewAllReviews
    Scenario: Marketing Manager can view All Reviews
      Given Marketing Manager Already On Dashboard Pages
      When Marketing Manager click On all reviews link
      And Marketing manager review All reviews
      Then all reviews already displayed on the UI

    @UpdateAllReview
    Scenario: Marketing Manager can Update All Reviews
      Given Marketing Manager Already On Dashboard Pages
      When Marketing Manager click On all reviews link
      And Marketing manager Edit All review information and click save button
      Then All Reviews updated successfully

    @AddNewCatalogPriceRule
    Scenario: Marketing Manager should be able to add new Catalog Price Rule
      Given user already on the dashboard page
      When user click on the Promotions dropdown list then select on the Catalog Price Rules link
      And user click on the Add New Rule link to fill out all New Rule information
      Then New Catalog Price should be added
    @UpdateExistingCatalogPriceRule
    Scenario: Marketing Manager should be able to update existing Catalog Price Rule
      Given user already on the dashboard page
      When user click on the Promotions dropdown list then select on the Catalog Price Rules link and select an existing Rule Name
      And user click on Actions link to update Price information then click on Save and Apply button
      Then existing Catalog Price Rule should be updated successfully
    @addNewNewsLetterTemplate
    Scenario: Marketing Manager should be able to add new Newsletter Template
      Given user already on the dashboard page
      When user click on the Newsletter Template link from NewsLetter dropdown list
      And user click on the Add New Template link to fill out the Template Information form
      Then new Newsletter Template added successfully

    @addNewCartPriceRule
    Scenario: User should be able to add new rule
      Given User already on the dashboard page
      When User Click promotion menu and click the cart price rule link
      And user click on add new rule button to fill out cart price rule  information
      Then cart price rule  should be added
    @UpdateExistingCartPriceRule
    Scenario: marketing backend user should be able to edit existing cart price rule
      Given marketing backend user already on the dashboard page
      When marketing backend user click promotion menu and click  cart price rule link
      And marketing manager search one rule and edit and save it
      Then Existing cart price rule already updated
    @SearchCatalogPricingRuleByIdAndName
    Scenario: marketing backend user should be search catalog pricing rule by id and name
      Given marketing user already on the pending reviews page
      When marketing user click the menu of promotion the link of catalog price rule
      Then marketing user enter id and rule name in the relative field
      And verify search catalog price rule is ture
    @viewAllReviews
    Scenario: marketing manager should be view all reviews
      Given marketing manager should be on the dashboard page
      When marketing manager click catalog menu and select review and rating and select customer reviews
      Then marketing manager click the all review link
      And verify view page
    @viewNewsletterSubscribers
    Scenario: marketing manager should be view newsletter Subscribers
      Given marketing manager should be on the home page
      When marketing manager click newsletter menu and click the newsletter subscribers link
      Then verify newsletter subscribers






