############################
# Author : Dilip k
# Test Cased ID : VMM_3856
############################
Feature: Users Tab Feature

@VMM-3856 @reg @Devices
 Scenario: VMM-3856	Add SF Nexus devices H1, Edge, and X2 to the default device type list.
    Given I login to LM application with valid credentials
    Then I navigate to Device Types tab
    Then I verify device details for the "H1" in test data "VMM_3856_1" 
    Then I verify device details for the "X2" in test data "VMM_3856_2" 
    Then I verify device details for the "Edge" in test data "VMM_3856_3" 
    Then I verify device details for the "test1" in test data "VMM_3856_4"    
    Then I navigate to Devices tab
    Then I verify if device details in the "VMM_3856_1" is same as specified for the "H1"
    Then I verify if device details in the "VMM_3856_2" is same as specified for the "X2"
    Then I verify if device details in the "VMM_3856_3" is same as specified for the "Edge"
    Then I verify if device details in the "VMM_3856_4" is same as specified for the "test1"
  And I close the browser