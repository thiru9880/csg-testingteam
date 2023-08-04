############################
# Author : Dilip k
# Test Cased ID : VMM_3389
############################
Feature: Users Tab Feature

@VMM-3389 @reg @Operations
   Scenario: VMM-3389 Device Settings: Tracking a setting
    Given I login to LM application with valid credentials
    Then I navigate to the device settings tab
    Then I create a new device setting
    Then I edit the fleetconfiguration for any of the device setting and save
    Then I click on track action button for the edited device setting
    Then I verify for the information edited an update entry should be displayed
    Then I verify if the changes made while editing is reflected in the track action page
    Then I delete the device setting created
    And I close the browser