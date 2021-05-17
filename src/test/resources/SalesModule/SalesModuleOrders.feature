@SalesModule
  Feature: Sales manager can create edit and update order

    Background:
      Given user on login page
      When user enter username and password click on login button
      Then user successfully login to the system

      @CreateOrder
      Scenario: Sales manager should be able to create an order
        When click on create order
        And  Add products to order and choose payment method and shipment and click submit order button
        Then verify the order successfully created
