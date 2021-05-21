@MarketingModule
  Feature: Marketing Manager can filter Cart Pricing Rule by Id and Rule(Yusufqan)

    Background:
      Given user on login page
      When user enter username and password click on login button
      Then user successfully login to the system

      #ManagerCanFilterCartPricingByRuleByRuleNameAndId
    Scenario: Marketing Manager can filter Cart Pricing Rule by Id and Rule Name
      When click on Promotions drop down list than click on Shopping Cart Price Rules
      And fill the ID field and Rule Name field then click on Search Button
      Then verify Shopping Cart Price Rules on the right up

