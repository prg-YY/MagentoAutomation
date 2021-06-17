@StoreModuleDatabaseTest
  Feature: store manager can add a new stock
    -add new stock
    -Add new Stoer

    @VerifyNewlyAddedStockInTheDatabase
    Scenario: Verify that newly added stock should be in the database
      Given  store manager should be on the login page
      When  store manager on the dashboard page
      And  store manager add new stock
      Then  Verify that newly added stock should be in the database

    @AddNewStore
    Scenario: Store Manager Can Create a Store
      Given User already on the Manage Store Dashboard Page
      When Click on Create Store Button
      And Fill Out All New Store Information on New Store Page
      Then New Store Created Successfully and Exist in Database