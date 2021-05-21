@ReportingModuleSales
Feature: Reporting Manager should be able to see  Sales :
  - Total Ordered Report
  - Taxes Report Grouped by Tax Rate
  - Total Invoiced vs Paid Report
  - Total Shipped Report
  - Total Refunded Report
  - Coupons Usage Report

  Background:
    Given user on login page
    When user enter username and password click on login button
    Then user successfully login to the system

  #SeeTotalOrderedReport
  Scenario: Reporting Manager should be able to see  Sales - Total Ordered Report
    When click on Reports drop down list than click on Orders under of Sales
    And fill the Order Date on From field and To field then click on Show Report Button
    Then verify total count of Ordered Report

  #SeeTaxesReportGroupedByTaxRate
  Scenario: Reporting Manager should be able to see  Sales - Taxes Report Grouped by Tax Rate
    When click on Reports drop down list than click on Tax under of Sales
    And fill the Tax Date on  From field and TO field then click on Show Report Button
    Then verify Order Taxes Report Grouped by Tax Tate

  #SeeTotalInvoicedVSPaidReport
  Scenario: Reporting Manager should be able to see  Sales - Total Invoiced vs Paid Report
    When click on Reports drop down list than click Invoiced under of Sales
    And fill the Invoiced Date on From field and To field then click on Show Report Button
    Then verify Total Invoiced vs.Paid Report

  #SeeTotalShippedReport
  Scenario: Reporting Manager should be able to see  Sales - Total Shipped Report
    When click on Reports drop down list than click on Shipping under of Sales
    And fill the Shipping Date on From field and To field then click on Show Report Button
    Then verify Total Shipped Report

  #SeeTotalRefundedReport
  Scenario: Reporting Manager should be able to see  Sales - Total Refunded Report
    When click on Reports drop down list than click on Refunds under of Sales
    And fill the Refunded Date From field and To field then click on Show Report Button
    Then verify Total Refunded Report

  #CouponsUsageReport
  Scenario: Reporting Manager should be able to see  Sales - Coupons Usage Report
    When click on Reports drop down list than click on Coupons under of Sales
    And fill the Coupons Date From field and To field then click on Show Report Button
    Then verify Coupons Usage Report

