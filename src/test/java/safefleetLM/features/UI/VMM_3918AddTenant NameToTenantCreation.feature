############################
# Author : Naincy Soni
# Test Cased ID : VMM_3918
############################
Feature: Add tenant name to tenant creation page

@VMM-3918 @reg @int @tm @Integration2
Scenario Outline:VMM-3918 Add Tenant Name Field to Tenant Creation page	
Given I login to LM application with valid credentials
Then I verify tenant name feild in tenant creation tab
Then I create new tenant for VMM3918 with test data "<TCID>"
Then I verify created tenant in tenant page with test data "<TCID>"
Then I create APP license with test data "<TCID>"
Then I navigate to ecosystem settings tab
Then I create unique ecosystem setting with test data "<TCID>"
Then I Publish License with test data "<TCID>"
Then I verify the published licenses details in TM via swagger with expected test data "<TCID>" 
And I close the browser
Examples:
		|TCID      |
		|VMM-3918_1|