
Feature: Sales manager can view credit memos

Background:
Given user on login page
When user enter username and password click on login button
Then user successfully login to the system

@ViewCreditMemos
  Scenario: Sales manager should be able to view credit memos
  When sales manager already on the  credit memos page
  Then Sales manager can view credit memos

