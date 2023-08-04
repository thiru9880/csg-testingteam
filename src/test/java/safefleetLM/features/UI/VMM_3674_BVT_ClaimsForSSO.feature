############################
# Author : Naincy Soni
# Test Cased ID : VMM_3674
############################
Feature: Claims for the SSO - users related to customer

@VMM-3674 @reg @smoke @smoke1 @int @sso @Integration1
Scenario Outline:VMM-3674 Claims for the SSO - users related to customer
Given I login to LM application with valid credentials
Then I create user other then customer role with test data "<TCID>"
Then I verify user claim in swagger with expected test data "<TCID>"
Then I edit user by providing customer role and choose one or more tenants with test data "<TCID>"
Then I verify user claim for customer role in swagger with expected test data "<TCID2>"
Then I edit user by providing admin role with test data "<TCID>"
Then I verify user claim for admin role in swagger with expected test data "<TCID2>"
Then I delete created user with test data "<TCID>"
Then I verify user claim for customer and admin role in swagger with expected test data "<TCID2>"
And I close the browser
Examples:
		|TCID      |TCID2     |
		|VMM-3674_1|VMM-3674_2|
