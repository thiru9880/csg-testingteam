##############################################
#Author : Nitin Kumar
#Test Case ID: VMM_3847
##############################################

Feature: Delete button should be disabled when a sales region is in use

@VMM-3847 @reg @System_Admin
  Scenario: VMM-3847 Delete button should be disabled when a sales region is in use
    Given I login to LM application with valid credentials
    Then I navigate to the Operation Tab
    Then I navigate to Sales Region Tab
  	Then I verify delete button of a record for disabled
  	Then I verify delete button of a record for enabled
    And I close the browser
