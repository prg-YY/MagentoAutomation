@SalesModule
  Feature: Sales manager can create edit and update order

    Background:
      Given user on login page
      When user enter username and password click on login button
      Then user successfully login to the system

      @CreateOrder
      Scenario: Sales manager should be able to create an order
        When sales manager on the create order orders page
        And  choose customer for order
        And  add products to order
        And  choose payment method and shipment and click submit order button
        Then verify the order successfully created

        @UpdateOrder
        Scenario: Sales manager should be able to Update an existing order
          When user should be orders page
          And user choose order for update and click on edit button
          And Add some order information
          Then verify the order successfully updated

        @CancelOrder
        Scenario:Sales manager should be able to cancel order
          When sales manager already on the Order page
          And choose order to cancel
          And click on cancel order action and submit it
          Then verify the order successfully cancelled

