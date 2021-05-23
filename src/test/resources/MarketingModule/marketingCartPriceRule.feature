@MarketingModule @MarketingCartPriceRule

  Feature: Marketing Manager shopping cart price rule test
    -add New Cart Price Rule
    -Update Existing Cart Price Rule
    -Search Catalog Pricing Rule By Id And Name
    -view All Reviews
    -view Newsletter Subscribers

    Background:
      Given user on login page
      When user enter username and password click on login button
      Then user successfully login to the system

      #Melike ,Abdukahar
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








