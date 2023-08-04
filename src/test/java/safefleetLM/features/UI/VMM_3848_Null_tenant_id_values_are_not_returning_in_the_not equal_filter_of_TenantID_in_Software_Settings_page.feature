############################################################
#Author : Rajath G M                       
#Test Case ID: VMM_3848                     
############################################################
Feature: Manage record count in ecosystem settings

  @VMM-3848   @reg @Operations
  Scenario Outline: VMM_3848 Manage Record count in Ecosystem Settings 
  Given I login to LM application with valid credentials
  Then I click on operations to navigate Tenants tab
  And I create new Tenant with test data "<TCID>"
  Then I Navigate to Ecosystem Settings
  Then I create new Ecosystem Settings with test data "<TCID>" 
  Then I click on SHOW FILTERS
  Then I Filter on TenantID with not equal to values "<TCID>"  
  Then I verify that the record count correct
  Then I delete the Ecosystem "<TCID>"
  Then I click on operations to navigate Tenants tab
  Then I delete the Tenant "<TCID>"   
  And I close the browser 
   
  Examples: 
      | TCID       |   
      | VMM_3848_1 |     