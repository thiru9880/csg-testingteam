############################
# Author : Naincy Soni
# Test Cased ID : VMM_3746
############################
Feature: Issues with Software creation

@VMM-3746 @reg @System_Admin
Scenario Outline:VMM-3746 Issues with Software creation
Given I login to LM application with valid credentials
Then I navigate to Base Product Tab
Then I create Base App "<TCID>"
Then I verify multiple feild while editing Base Product with test data "<TCID>"
Then I navigate to Base Product Tab
Then I delete the Base App "<TCID>"
And I close the browser
Examples:
		|TCID      |
		|VMM-3746_1|