@AddProduct&AddTaxRule
Feature: 1-Verify that newly added product category should be in the database
  2-Verify the newly added tax rule should be in the database


  @NewlyAddedProductInTheDatabase
  Scenario: Verify that newly added product category should be in the database
    Given user login to catalog module
    And preparation for new product creation
    Then verify New product created and should be in the database


