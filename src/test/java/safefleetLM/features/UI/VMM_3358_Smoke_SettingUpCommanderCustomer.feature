############################
# Author : Naincy Soni
# Test Cased ID : VMM_3358
############################
Feature: Setting up commander customer

@VMM-3358 @reg @smoke @smoke2 @Licenses
Scenario Outline: VMM-3358 Setting up a Commander Customer
Given I login to LM application with valid credentials
Then I create new tenant for VVMM3358 with test data "<TCID>"
Then I create APP license for SF Commander with test data "<TCID>"
Then I create Vehicle license for SF Commander with test data "<TCID2>"
Then I verify License tab with test data "<TCID>"
Then I click on operations to Navigate Ecosystem Settings
Then I verify software setting is created with Tenant id if not Create software setting "<TCID>"
Then I navigate to licenses page
Then I publish the App license "<TCID>"
Then I publish Vehicle licenses "<TCID2>"
Then I delete the published App license "<TCID>"
Then I delete the published Vehicle licenses "<TCID2>"
Then I click on operations to Navigate Ecosystem Settings
Then I delete the ecosystem settings "<TCID>"
Then I click on operations to navigate Tenants tab
Then I delete the Tenant "<TCID>"
And I close the browser

Examples:
		|TCID      |TCID2     |
		|VMM-3358_1|VMM-3358_2|
