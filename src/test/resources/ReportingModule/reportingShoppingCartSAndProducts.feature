@ReportingModuleShoppingCartProducts
Feature: Reporting Manager should be able to see Shopping Cart:
  - Product in carts Report
  - Abandoned carts Report
  Reporting Manager should be able to see:
  - Products Bestsellers Report
  - Products Ordered Report
  - Products Most Viewed Report
  - Products low stock Report
  - Products Downloads Report

  Background:
    Given user on login page
    When user enter username and password click on login button
    Then user successfully login to the system

  #SeeProductInCartsReport
  Scenario: Reporting Manager should be able to see  Shopping Cart - Product in carts Report
    When click on Reports drop down list than click on Product in carts under of Shopping Cart
    Then verify Products in carts Report

  #SeeAbandonedCartsReport
  Scenario: Reporting Manager should be able to see  Shopping Cart - Abandoned carts Report
    When click on Reports drop down list than click on Abandoned carts of Shopping Cart
    Then verify Abandoned carts Report

  #SeeProductsBestsellersReport
  Scenario: Reporting Manager should be able to see - Products Bestsellers Report
    When click on Reports drop down list than click on Bestsellers under of Products
    And fill the Order Date on From field and To field then click on Show Report Button(Bestsellers)
    Then verify Products Bestsellers Report

  #SeeProductsOrderedReport
  Scenario: Reporting Manager should be able to see - Products Ordered Report
    When click on Reports drop down list than click on Products Ordered of Products
    And fill the Order Date on From field and To field then click on Show Report Button(ProductsOrder)
    Then verify Products Ordered Report

  #SeeProductsMostViewedReport
  Scenario: Reporting Manager should be able to see - Products Most Viewed Report
    When click on Reports drop down list than click on Most Viewed of Products
    And fill the Order Date on From field and To field then click on Show Report Button(Most Viewed)
    Then verify Most Viewed Report Report

  #SeeProductsLowStockReport
  Scenario: Reporting Manager should be able to see - Products low stock Report
    When click on Reports drop down list than click on Low Stock of Products
    Then verify Low stock Report

  #SeeProductsDownloadsReport
  Scenario: Reporting Manager should be able to see - Products Downloads Report
    When click on Reports drop down list than click on Downloads of Products
    And fill the Product Name on the Text box then click the search Button
    Then verify Downloads Report



