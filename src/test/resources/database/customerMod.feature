@CustomerModuleTest
Feature: customer manager can
  -Add customer
  -add groups

  @AddCustomer
  Scenario: customer manager can add new customer
    Given customer manager login to the customer module page
    When customer manage on the customer dashboard pade
    And customer manager add new customer
    Then new customer created successfully and exist in data base

  @VerifyThatNewAddedCustomerGroupsInTheDatabase
  Scenario: Verify that  new added customer groups should be in the database
    When customer manager should be on the login page
    Given customer manager should be on the dashboard page
    And customer manager add new groups
    Then verify newly added groups in the database