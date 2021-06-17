@AddRootCat
Feature: Verify that newly added product root category should be in the database

  @AddRootCategory
  Scenario: Catalog Manager should be able to add root category
    Given Catalog Manager log in to Catalog Module page
    When new Root category should be added
    Then new root category create successfully and exist in the database