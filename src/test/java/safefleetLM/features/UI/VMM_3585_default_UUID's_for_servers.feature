############################################################
#Author : Rajath G M
#Test Case ID: VMM_3585
############################################################
Feature: Manage default UUIDs for servers

 @VMM-3585  @reg @System_Admin
 Scenario Outline: VMM_3585 Manage default UUIDs servers 
    Given I login to LM application with valid credentials
    Then I Navigate to System Admin 
    Then I Navigate to Servers
    Then I Click On New to Create a New server "<TCID>"
    Then I Verify that server was created with randomly generated default uuid 
    Then I Verify that uuid column isnt blank for any of the servers
    Then I Click on view button next to any of the servers and make sure that there is an uuid
    Then I delete server "<TCID>"
    And I close the browser    
      
    Examples:      
    |TCID     |         
    |VMM3585_2|              