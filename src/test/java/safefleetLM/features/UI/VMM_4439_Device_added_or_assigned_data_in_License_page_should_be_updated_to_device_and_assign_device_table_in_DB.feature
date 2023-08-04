##############################################################
# Author: Bhanu
# Test Case ID: VMM_4439
##############################################################
Feature: Device added/assigned data in License page should be updated in DB

  @VMM-4439 @reg @Licenses
  Scenario Outline: VMM_4439 Device added or assigned data in License page should be updated to device and assign_device table in DB
    Given I login to LM application with valid credentials
    When I click on system admin to navigate Device Type Tab
    Then I verify and store the device types to verify in assign devices table
    When I navigate to licenses page
    Then I add or assign the new devices in License page under Actions "<TCID>"
    Then I verify that a list of available devices are retrieved from device table "<TCID>"
    Then I verify that new devices assigned data in License page should be updated to device and assign_device table in DB "<TCID>"
    Then I verify that license_id column should be removed from the fleet_device_assign table "<TCID>"
    And I close the browser

    Examples: 
      | TCID       |
      | VMM_4439_1 |
