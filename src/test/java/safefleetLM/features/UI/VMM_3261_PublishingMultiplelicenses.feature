############################
# Author : Naincy Soni
# Test Cased ID : VMM_3261
############################
Feature: Create and publish license for SF Cognition base product

@VMM-3261 @reg @int @tm @Integration1
Scenario Outline: VMM-3261 Publishing licenses in LM is showing licenses incorrectly in TM when multiple licenses of different license types published
Given I login to LM application with valid credentials
Then I navigate to Tenant tab
Then I create new tenant for VMM3261 with test data "<TCID2>"
Then I create new license for license types: BASE_PRODUCT with test data "<TCID>"
Then I create new license for license types: DEVICE  with test data "<TCID2>"
Then I navigate to ecosystem settings tab
Then I create unique ecosystem setting with test data "<TCID>"
Then I publish all license in LM with test data "<TCID>"
Then I verify published license details in TM via swagger with expected test data "<TCID>"
Then I delete the published App license "<TCID>"
Then I delete the published Vehicle licenses "<TCID>"
Then I click on operations to Navigate Ecosystem Settings
Then I delete the ecosystem settings "<TCID>"
Then I click on operations to navigate Tenants tab
Then I delete the Tenant "<TCID2>"
And I close the browser
Examples:
		|TCID      |TCID2|
		|VMM-3261_1|VMM-3261_2|

