@SalesModule @InvoicesTest
Feature: Sales manager can create edit and update order
  -View Invoices
  -Add Comment To Invoices History
  -View Refunds

  Background:
    Given user on login page
    When user enter username and password click on login button
    Then user successfully login to the system

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


