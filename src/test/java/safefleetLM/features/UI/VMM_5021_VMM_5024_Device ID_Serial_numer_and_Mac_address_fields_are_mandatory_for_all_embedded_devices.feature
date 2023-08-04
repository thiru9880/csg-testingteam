####################################################
#Author: Savitha
#Test Case Id: VMM_5021 and VMM_5024
####################################################
Feature: Device ID Serial number and Mac address field mandatory based on Device types

  @VMM-5021 @VMM-5024 @reg @Devices
  Scenario Outline: VMM_5021, VMM_5024 Device ID Serial number and Mac address field mandatory based on Device types
    Given I login to LM application with valid credentials
    When I navigate to the Operation Tab
    When I navigate to devices tab
    Then I verify Device Id Serial number and Mac Address field mandatory and create a embedded device "<TCID>"
    Then I update the device type and verify Device ID and Mac Address field is mandatory "<TCID>"
    Then I delete the device "<TCID>"
    And I close the browser

    Examples: 
      | TCID      |
      | VMM5021_1 |
