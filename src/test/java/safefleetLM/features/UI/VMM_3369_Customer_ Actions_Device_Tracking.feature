############################################################
#Author : Rajath G M
#Test Case ID: VMM_3369,VMM_3425
############################################################
Feature: Manage Customer Actions Device tracking

 @VMM-3369 @VMM-3425  @reg @Operations
 Scenario Outline: VMM_3369 VMM_3425 Manage Customer Actions Device tracking
    Given I login to LM application with valid credentials
    Then I Navigate to Operations 
    Then I Navigate to Customers 
    Then I create a new Customer "<TCID>"
    Then I Edit customer data "<TCID>"
    Then I Click on clipboard symbol Actions "<TCID>"
    Then I click on view options to change Audit details  
    Then I Verify that Audit details
    Then I Navigate to Customers
    Then I Click on Delete customer "<TCID>"
    Then I search for customer not currently displayed in table "<TCID2>"    
    And I close the browser 
    
     
     Examples:
     |TCID      |     |TCID2     |
     |VMM_3369_1|     |VMM_3425_1| 