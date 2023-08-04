##########################################
# Author : Ravi Manne
# Test Cased ID : VMM_3705 VMM_3322 VMM_3602
##########################################

Feature: Users Creation in LM

   @VMM-3705 @VMM-3322 @reg @System_Admin
   Scenario Outline: VMM_3705	VMM_3322 VMM_3602 Email received upon user creation in LM has HTML formatted content
    Given I login to LM application with valid credentials
    When I navigate to User tab
    And I create new user with test data "<TCID>"
    Then I verify user details for the user in test data "<TCID>" 
    And I veirfy created user details in DB 
    Then I delete the user in test data "<TCID>"
    And I veirfy deleted user details in DB 
    And I close the browser
   
   	Examples:
		|TCID    |
		|VMM-3705|
		|VMM-3322| 