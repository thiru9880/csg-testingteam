############################
# Author : Naincy Soni
# Test Cased ID : VMM_3624
############################
Feature: VAdd tenants set for user to claims in SSO

@VMM-3624 @reg @int @sso @Integration1
Scenario Outline:VMM-3624 Add tenants set for user to claims in SSO
Given I login to LM application with valid credentials
Then I create user with customer role and tenant with test data "<TCID>"
Then I verify tenants exist for user in swagger with expected test data "<TCID>" 
Then I remove tenant from created user with test data "<TCID>"
Then I verify tenants exist for user after removing tenant in swagger with expected test data "<TCID>" 
Then I delete created user with test data "<TCID>"
And I close the browser
Examples:
		|TCID      |TCID2     |
		|VMM-3624_1|VMM-3624_2|