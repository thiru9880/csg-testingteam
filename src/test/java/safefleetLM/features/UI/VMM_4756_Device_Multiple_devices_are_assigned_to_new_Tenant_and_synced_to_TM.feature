##############################################
#Author : Nitin Kumar														
#Test Case ID: VMM_4756								
##############################################

Feature: Device/Multiple devices are assigned to new Tenant and synced to TM
 
  @VMM-4756 @int @tm @Integration2
  Scenario Outline: VMM_4756 Device/Multiple devices are assigned to new Tenant and synced to TM
    Given I login to LM application with valid credentials
    Then I navigate to the Operation Tab
    Then I navigate to Tenants Tab
    Then I click on new and enter all the required details with Tenant ID "<TCID>"
    Then I assign Device or multiple Devices to the Tenant and save
    And I verify that the Tenant and Devices details are synced to TM "<TCID>"
    And I close the browser
     
    Examples: 
      |TCID     |
      |VMM4756_1|
