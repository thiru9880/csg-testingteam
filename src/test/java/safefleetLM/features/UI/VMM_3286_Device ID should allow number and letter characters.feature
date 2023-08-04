####################################################
#Author: Surya 
#Test Case Id: VMM_3286
####################################################
 Feature: Device ID should allow Number and letter characters 
 
@VMM-3286 @reg @Devices
   Scenario Outline:  VMM_3286 Device ID should allow number and letter characters
   Given I login to LM application with valid credentials
   When I navigate to the Operation Tab
   When I navigate to devices tab 
   Then I Create a device with device type and  test data "<TCID>"
   Then I using show filter to get device details "<TCID>"
   And I verify device id  field accepts letters, numbers Not More than 32 "<TCID>"  
   Then I delete the device "<TCID>"
   And I close the browser          
   
    Examples:   
    |TCID     | 
    |VMM3286_1|