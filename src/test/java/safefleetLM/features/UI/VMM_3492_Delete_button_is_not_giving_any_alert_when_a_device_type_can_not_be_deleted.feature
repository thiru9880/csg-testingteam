############################################################
#Author : Rajath G M                                       #
#Test Case ID: VMM_3492                                    #
############################################################
Feature: Manage delete button not giving alert when device type is deleted

  @VMM-3492 @reg @Devices
   Scenario Outline: VMM_3492 delete button not giving alert when device type is deleted 
    Given I login to LM application with valid credentials
    Then I click on system admin to navigate Device Type Tab
    Then I create a New device type "<TCID>"  
    Then I navigate to the Operation Tab
    Then I navigate to the device settings tab
    Then I click on new and I create Device setting "<TCID>"
    Then I click on system admin to navigate Device Type Tab
    Then I try to delete the device type and I verify device type which is tied to a device setting alert popup displayed "<TCID>"
    Then I navigate to the Operation Tab
    Then I navigate to the device settings tab 
    Then I delete the device setting "<TCID>"  
    Then I click on system admin to navigate Device Type Tab
    And I delete the test device type "<TCID>" 
    And I close the browser  
          
    Examples:      
    |TCID     |           
    |VMM3492_1|                   