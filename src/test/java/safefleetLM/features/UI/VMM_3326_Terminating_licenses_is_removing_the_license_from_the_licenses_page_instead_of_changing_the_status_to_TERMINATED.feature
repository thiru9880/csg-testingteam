##########################
#Author : Rajath G M                                       
#Test Case ID: VMM_3326                                   
##########################
Feature: Manage licenses change to Terminated

  @VMM-3326   @reg @Licenses
  Scenario Outline: VMM_3326 Manage licenses change to Terminated 
   Given I login to LM application with valid credentials
   Then I Navigate to System Admin
   Then I Navigate to License Type
   Then I create License Type Sync to TM status as on "<TCID>"
   Then I click on operations and navigate Tenants tab and I create a new Tenant "<TCID>"
   Then I click on new to create license "<TCID>"
   Then I Publish the license "<TCID>"
   Then Terminate the license "<TCID>"
   Then I make sure that the license status in LM is changed from PUBLISHED to TERMINATED "<TCID>" 
   And I close the browser     
      
   Examples:    
      |TCID      |             
      |VMM_3326_1|        
                   