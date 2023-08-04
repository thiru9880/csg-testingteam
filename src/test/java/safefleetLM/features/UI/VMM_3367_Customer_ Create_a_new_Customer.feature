############################################################
#Author : Rajath G M
#Test Case ID: VMM_3367,VMM_3368
############################################################
Feature: Manage Customer Creation

  @VMM-3367 @VMM-3368 @reg @Operations
  Scenario Outline: VMM_3367,VMM_3368  Manage Customer Creation
    Given I login to LM application with valid credentials
    Then I Navigate to Operations 
    Then I Navigate to Customers
    Then I Creat a New Customer "<TCID>"
    When I Click on view customer data "<TCID>"
    Then I Edit customer data "<TCID>"
    Then I Click on Delete "<TCID>"    
    And I close the browser   
    
    Examples:
      |TCID     |  
      |VMM3367_1|    
      
 