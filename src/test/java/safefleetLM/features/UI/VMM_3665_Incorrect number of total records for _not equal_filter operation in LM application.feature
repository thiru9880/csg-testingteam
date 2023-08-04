####################################################
#Author: Surya
#Test Case Id: VMM_3665
####################################################
 Feature: Incorrect number of Total records for not equal filter operation in LM application
 
@VMM-3665  @reg @Operations
   Scenario Outline:  VMM_3665 Incorrect number of total records for not equal filter operation in LM application
   Given I login to LM application with valid credentials
   When I navigate to the Operations tab
   When I navigate to the device settings tab
   Then I Verify if the record count for not equal filter operation in UI is correct and is not more than the record count with no filters for device setting "<TCID>"
   When I navigate to Software Settings
   Then I Verify if the record count for not equal filter operation in UI is correct and is not more than the record count with no filters for software setting "<TCID>"
   And I close the browser          
   
    Examples: 
      | TCID   | 
      |VMM3665_1| 
