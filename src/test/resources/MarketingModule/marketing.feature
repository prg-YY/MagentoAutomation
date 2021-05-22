@MarketingModule

  Feature: Marketing Manager can filter Cart Pricing Rule by Id and Rule
    Feature: Marketing Manager can view and update pending and all Reviews(Ayper)
    -view pending Reviews
    -update pending Reviews
    -view All Reviews
    -update All Reviews

    Background:
      Given user on login page
      When user enter username and password click on login button
      Then user successfully login to the system

      #ManagerCanFilterCartPricingByRuleByRuleNameAndId
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


