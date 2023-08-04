############################################################
#Author : Rajath G M
#Test Case ID: VMM_3573
############################################################
Feature: Managae MDT LTE device can be viewed

 @VMM-3573  @reg @Devices
  Scenario: VMM_3573 MDT LTE device view
  Given I login to LM application with valid credentials
  Then I Navigate to Operations
  Then I Navigate to Devices
  Then I click on Device Type to filter MDT LTE devices
  Then I click on view option
  Then I Verify that MDT LTE device can be viewed without any issues
  And I close the browser
