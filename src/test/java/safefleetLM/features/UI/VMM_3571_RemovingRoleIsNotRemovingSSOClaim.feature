############################
# Author : Naincy Soni
# Test Cased ID : VMM_3571
############################
Feature: Removing role is not removing the SSO claim

@VMM-3571 @reg @int @sso @Integration1
Scenario Outline:VMM-3571 removing role is not removing the SSO claim
Given I login to LM application with valid credentials
Then I create user with customer role with test data "<TCID>"
Then I verify customer role for user in swagger with expected test data "<TCID>" 
Then I edit role for created user with test data "<TCID2>"
Then I verify new role updated for user in swagger with expected test data "<TCID2>" 
Then I delete created user with test data "<TCID>"
And I close the browser
Examples:
		|TCID      |TCID2     |
		|VMM-3571_1|VMM-3571_2|