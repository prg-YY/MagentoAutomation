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


    @ViewInvoices
    Scenario: Sales manager should be able to view invoices
      Given sales manager on the dashboard page
      When sales manager click on invoice link
      And  sales manager can see all invoices
      Then verify user sow all invoices

    @AddCommentsToInvoices
    Scenario: Sales manager should be able to add comments to invoice history
      Given sales manager on the invoices dashboard page
      When enter Order id and click on search button
      And  Sales manager click on view button
      And  add comments and click on save comment button
      Then verify comment added successfully

    @ViewRefunds
    Scenario: Sales Manager should be able to view refunds in the Reports
      Given sales manager on the credit memos page
      When  define the order and click view
      And  refund records should be display
      Then verify refunds record already displayed

# Sales Manager should be able to update ,add shipment history ,and tracking information;@
    #@zuhra
    @UpdateShipments
    Scenario: user should be able to update shipment
      Given sales manager on the shipment dashboard
      When  sales manager on the define order and click it
      And add shipping and tracking information
      Then shipping and tracking information added successfully

      #Sales manager can view credit memos
    @ViewCreditMemos
    Scenario: Sales manager should be able to view credit memos
      When sales manager already on the  credit memos page
      Then Sales manager can view credit memos

      #Sales Manager should be able to manage (add and update) tax rules

