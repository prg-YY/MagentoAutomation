@CustomerModuleTest
  Feature: customer manager can add new customer
    -Add customer
    @AddCustomer
    Scenario: customer manager can add new customer
      Given customer manager login to the customer module page
      When customer manage on the customer dashboard pade
      And customer manager add new customer
      Then new customer created successfully and exist in data base