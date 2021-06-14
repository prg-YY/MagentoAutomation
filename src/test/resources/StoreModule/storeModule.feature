@StoreModule
Feature: Store Manager can
  - Add product
  - Update product
  - Create new order
  - Edit order
  - Delete order
  - Add product category
  - Update product category
  - CreateWebsite
  - EditWebsite
  - CreateStoreView
  - EditStoreView
  - ViewAllStore

  Background:
    Given user on login page
    When user enter username and password click on login button
    Then user successfully login to the system

  @AddProduct
  Scenario: Store Manager should be able to add product
    Given user already on the Manage store dashboard page
    When click on Manage Products link under Catalog dropdown list
    And user click on Add product button and fill out all product information
    Then new product should be added

  @UpdateProduct
  Scenario: Store Manager should be able to update product
    Given user already on the Manage store dashboard page
    When click on Manage Products link under Catalog dropdown list
    And user click on the product link which should be updated then update product information
    Then product should be updated

  @CreateNewOrder
  Scenario: Store Manager should be able to create new order
    Given user already on the Manage store dashboard page
    When click on Orders link under Sales dropdown list
    And click Create New Order button and click the customer where should be added new order then add product
    Then new order should be created

  @EditNewOrder
  Scenario: Store Manager should be able to edit order
    Given user already on the Manage store dashboard page
    When click on Orders link under Sales dropdown list
    And Select the order should be edited and edit order information
    Then order should be edited

  @DeleteOrder
  Scenario: Store Manager should be able to delete order
    Given user already on the Manage store dashboard page
    When click on Orders link under Sales dropdown list
    And click the order should be deleted then click cancel button
    Then order should be canceled

  @AddProductCategory
  Scenario: Store Manager should be able to add product categories
    Given user already on the Manage store dashboard page
    When click on Manage Categories link under Catalog dropdown list
    And fill out all new category information on New Root Category page and click Save Category button
    Then new product category should be added

  @UpdateProductCategory
  Scenario: Store Manager should be able to update product categories
    Given user already on the Manage store dashboard page
    When click on Manage Categories link under Catalog dropdown list
    And click the category should be updated then update category information
    Then Category should be updated


  @CreateWebsite
  Scenario: Store Manager should be able to create website
    Given user already on the Manage store dashboard page
    When click Create Website button
    And fill out all new website information on new website page
    Then website should be created


  @EditWebsite
  Scenario: Store Manager should be able to edit website
    Given user already on the Manage store dashboard page
    When click the website link should be edited and update website information then click save website button
    Then website should be edited


  @CreateStore
  Scenario: Store Manager can create a store
    Given user already on the Manage store dashboard page
    When click Create Store button
    And fill out all new store information on new store page
    Then store should be created

  @EditStore
  Scenario: Store Manager can edit a store
    Given user already on the Manage store dashboard page
    When click the store link should be edited and update store information then click save store button
    Then store should be edited

  @CreateStoreView
  Scenario: Store Manager can create a store view
    Given user already on the Manage store dashboard page
    When click Create Store view button
    And fill out all new store view information on new store view page
    Then store view should be created

  @EditStoreView
  Scenario: Store Manager can edit a store view
    Given user already on the Manage store dashboard page
    When click the store view link should be edited and update store view information then click save store view button
    Then store view should be edited

    @ViewAllStore
    Scenario: Store Manager can view all stores
      Given user already on the Manage store dashboard page
      When click on Orders link under Sales dropdown list
      Then can view All stores



















