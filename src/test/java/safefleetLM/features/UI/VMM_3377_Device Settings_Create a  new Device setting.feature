####################################################
#Author: Surya
#Test Case Id: VMM_3377,VMM_3387,VMM_3384,VMM_3386
####################################################
Feature: Manage Device Setting

  @VMM-3377 @VMM-3387 @VMM-3384 @VMM-3386 @reg @Operations
  Scenario Outline: VMM_3377,VMM_3387,VMM_3384,VMM_3386 Manage Device Setting
    Given I login to LM application with valid credentials
    When I navigate to the Operations tab
    When I navigate to the device settings tab
    Then I create a device setting with device type and testdata "<TCID>"
    And I view a device setting "<TCID>"
    And I edit a device setting "<TCID>"
    Then I using show filter to get the device setting details for after edit "<TCID>"
    Then I delete a device setting "<TCID>"
    And I close the browser

    Examples: 
      | TCID      |
      | VMM3377_1 |
