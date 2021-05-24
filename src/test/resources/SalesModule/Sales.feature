@SalesModule
  Feature: Sales manager can create edit and update order
    -Create Order
    -Update Order
    -Cancel Order
    -Update Shipments
    -ViewInvoices
    -AddCommentsToInvoices
    -ViewRefunds
    -UpdateShipments
    -Add Tax price rule
    -Update Existing tax price rule

    Background:
      Given user on login page
      When user enter username and password click on login button
      Then user successfully login to the system

      @CreateOrder
      Scenario: Sales manager should be able to create an order
        Given sales manager on the sales module dashboard
        When sales manager go to order page and click create new order link
        And   sales manager choose customer for order
        And  sales manager add products to order
        And  choose payment method and shipment and click submit order button
        Then The New Order Created Successfully

      @UpdateOrder
      Scenario: Sales manager should be able to Update an existing order
        Given sales manager on the sales module dashboard
        When sales manager go to order page
        And user choose  order for update and click on edit button
        And Add some information for update
        Then Existing order updated successfully

      @CancelOrder
        Scenario:Sales manager should be able to cancel order
        Given sales manager on the sales module dashboard
          When sales manager go to order page
          And sales manager choose one order to cancel
          And click on cancel order action and submit it
          Then The order canceled successfully


    @ViewInvoices
    Scenario: Sales manager should be able to view invoices
      Given sales manager on the sales module dashboard
      When sales manager click on invoice link
      And  sales manager can see all invoices
      Then verify user sow all invoices

    @AddCommentsToInvoices
    Scenario: Sales manager should be able to add comments to invoice history
      Given sales manager on the sales module dashboard
      When sales manager go to invoices page
      And sales manager define a invoice history
      And sales manager add comment to invoice history
      Then verify comment added successfully

    @ViewRefunds
    Scenario: Sales Manager should be able to view refunds in the Reports
      Given sales manager on the sales module dashboard
      When  sales manager go to order page
      And sales manager define a order and click view button
     Then refunds record displayed successfully

# Sales Manager should be able to update ,add shipment history ,and tracking information;@
    #@zuhra
    @UpdateShipments
    Scenario: user should be able to update shipment
      Given sales manager on the sales module dashboard
      When  sales manager go to shipment page
      And  sales manager define a shipment to edit
      And sales manager add shipping and tracking information
      Then shipping and tracking information added successfully

      #Sales manager can view credit memos
    @ViewCreditMemos
    Scenario: Sales manager should be able to view credit memos
      Given sales manager on the sales module dashboard
      When sales manager click credit memos link
      And sales manager see credit memos
      Then credit memos records already displayed

      #Sales Manager should be able to manage (add and update) tax rules
  @AddNewTaxRule
  Scenario: Sales Manager should be able to add new tax rule
    Given sales manager on the sales module dashboard
    When sales manager go to manage tax rule page
    And sales manager click on add new rule button
    And sales manager fill out all required filed
    Then new tax rule added successfully

  @updateExistingTaxRule
  Scenario: Sales Manager should be able to update an existing tax rule
    Given sales manager on the sales module dashboard
    When sales manager go to manage tax rule page
    And sales manager define one rule to edit
    And sales manager edit some information
    Then Existing tax rule updated successfully



