##############################################################
# Author: Bhanu
# Test Case ID: VMM_3410
##############################################################
Feature: Manage Device Settings Page

  @VMM-3410 @reg @Operations
  Scenario Outline: VMM_3410 Manage Device Settings Page
    Given I login to LM application with valid credentials
    Then I navigate to the device settings tab
    Then I Click on NEW and verify device types which has Requires Setting status "<TCID>"
    Then I click on system admin to navigate Device Type Tab
    And I verify Device Types page should show up in the drop down list of the device types in New Device Settings page "<TCID>"
    Then I navigate to the device settings tab
    Then I select device type and make sure that Device settings template is loaded with Fleet Server port and host pointing to the below based on the environment "<TCID>"
    Then I click on system admin to navigate Device Type Tab
    And I create a new test device type "<TCID>"
    Then I navigate to the device settings tab
    And I make sure that the settings template is loaded with Fleet Server port for created device type "<TCID>"
    And I create a new device setting with the device type i created "<TCID>"
    Then I delete the device setting "<TCID>"
    Then I click on system admin to navigate Device Type Tab
    And I delete the test device type "<TCID>"
    And I close the browser

    Examples: 
      | TCID       |
      | VMM_3410_1 |
