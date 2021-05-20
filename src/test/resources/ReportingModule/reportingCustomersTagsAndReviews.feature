@ReportingModule #(Customers)(Tags)(Reviews)
Feature: Reporting Manager should be able to see Customers:
  - New Accounts Report
  - Customers by Orders Total Report
  - Customers by number of orders Report
  Reporting Manager should be able to see Tags:
  - Customers Report
  - Products Report
  - Popular Report
  Reporting Manager should be able to see Reviews:
  - Product Reviews Report

  Background:
    Given user on login page
    When user enter username and password click on login button
    Then user successfully login to the system

  #SeeCustomersNewAccountsReports
  Scenario: Reporting Manager should be able to see Customers - New Accounts Report
    When click on Reports drop down list than click on New Accounts under of Customers
    And fill the From field and To field then click on Refresh Button(New Accounts Report)
    Then verify New Accounts on the right up

  #SeeCustomersByOrdersTotalReport
  Scenario: Reporting Manager should be able to see Customers - Customers by Orders Total Report
    When click on Reports drop down list than click on Customers by Orders Total under of Customers
    And fill the From field and To field then click on Refresh Button(Customers by Orders Total Report)
    Then verify Customers by Orders Total on the right up

  #SeeCustomersByNumberOfOrdersReport
  Scenario: Reporting Manager should be able to see Customers - Customers by number of orders Report
    When click on Reports drop down list than click on Customers by number of orders Report under of Customers
    And fill the From field and To field then click on Refresh Button(Customers by number of orders Report)
    Then verify Customers by number of orders Report on the right up

  #SeeTagsCustomersReport
  Scenario:  Reporting Manager should be able to see Tags - Customers Report
    When click on Reports drop down list than click on Customers under of Tags
    Then verify Customers Tags on the right up

  #SeeTagsProductsReport
  Scenario: Reporting Manager should be able to see Tags - Products Report
    When click on Reports drop down list than click on Products under of Tags
    Then verify Products Tags on the right up

  #SeeTagsPopularReport
  Scenario: Reporting Manager should be able to see Tags - Popular Report
    When click on Reports drop down list than click on Popular under of Tags
    Then verify Popular Tags on the right up

  #SeeProductReviewsReport
  Scenario: Reporting Manager should be able to see Reviews - Product Reviews Report
    When click on Reports drop down list than click on Product Reviews under of Reviews
    Then verify Product Reviews on the right up

