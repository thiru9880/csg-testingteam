############################
# Author : Naincy Soni
# Test Cased ID : VMM_3877
############################
Feature: Verify name and icon for Base Product

@VMM-3877 @reg @System_Admin
Scenario Outline:  VMM-3877 Change Icons and names for Base Products
Given I login to LM application with valid credentials
Then I navigate to Base Product Tab
Then I verify name and icon for SF Base Product with expected test data "<TCID>" 
And I close the browser
Examples:
		|TCID      |
		|VMM-3877_1|