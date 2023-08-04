####################################################################
#Authour:Sunilkumar
#Test CaseID: VMM_3733
####################################################################
Feature: Advanced Settings should appear when creating device settings for the newly created device type
 

  @VMM-3733 @reg @Operations
  Scenario Outline: VMM_3733 device settings 
   Given I login to LM application with valid credentials
     When I click on system admin to navigate Device Type Tab 
     And I create a new device type "<TCID>"
     When I navigate to the device settings tab
     Then I create new device setting with device type testdata "<TCID>" and Verify advanced settings section appears in the template
     Then I Verify that the new device settings have been created for the new device type with testdata "<TCID>"
     Then I Verify that Edit and View buttons for the device settings working fine with testdata "<TCID>" 
     Then I delete device settings "<TCID>"
     Then I click on system admin to navigate Device Type Tab  
     Then I delete the test device type "<TCID>" 
     And I close the browser


    Examples: 
      |TCID     |
      |VMM3733_1|
