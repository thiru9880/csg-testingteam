############################
# Author : Naincy Soni
# Test Cased ID : VMM_3706
############################
Feature: Removing role is not removing the SSO claim

@VMM-3706 @reg @System_Admin
Scenario Outline:VMM-3706 Enforce protocol for the server URL
Given I login to LM application with valid credentials
Then I navigate to device settings page
Then I create device settings with test data "<TCID>" 
Then I verify Fleet Server IP and Fleet Server Port values in Fleet Server Configuration with test data "<TCID>"
And I close the browser
Examples:
		|TCID      |TCID2     |
		|VMM-3706_1|VMM-3706_2|