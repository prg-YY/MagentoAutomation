Feature: Sales Manager should be able to update ,add shipment history ,and tracking information;
  -total salesLink;
  -total shipments link list
  -total shipments Page is display
  -total customerListCheckBox;
  -total viewFromCustomerList;
  -total magento admin panel page on displayed;
  -total  click customValue;
  -total selectDHL;
  -total  enter tracking information number;
  -total clickAddButton;
  -total  click sendTrackingInformation;
  -total Verify update shipments successful



  Background:
    Given user on login page
    When user enter username and password click on login button
    Then user successfully login to the system

@UpdateShipments
  Scenario: user should be able to update shipment
    Given sales manager on the shipment dashboard
    When  sales manager on the define order and click it
    And add shipping and tracking information
    Then shipping and tracking information added successfully










