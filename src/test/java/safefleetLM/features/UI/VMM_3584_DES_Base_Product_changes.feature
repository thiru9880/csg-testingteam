############################
# Author : Naincy Soni
# Test Cased ID : VMM_3584
############################
Feature: Base product feature

@VMM-3584 @reg @int @tm @Integration1
Scenario Outline: VMM-3584 DES Base Product changes
Given I login to LM application with valid credentials
Then I navigate to Base Product Tab
Then I verify SF Cloud Courier For DES base product exists under Name column with test data "<TCID>"
Then I create new tenant with test data "<TCID>"
Then I create licenses for "SF Cloud Courier For DES" base product for the license types: BASE_PRODUCT with test data "<TCID>"
Then I create licenses for "SF Cloud Courier For DES" base product for the license types: ADD_ON_PRODUCT with test data "<TCID2>"
Then I navigate to ecosystem settings tab
Then I create unique ecosystem setting with test data "<TCID>"
Then I publish both licenses created above with test data "<TCID>"
Then I verify the application ID in TM Swagger UI with test data "<TCID>"
Then I delete the published App license "<TCID>"
Then I delete the published Vehicle licenses "<TCID>"
Then I click on operations to Navigate Ecosystem Settings
Then I delete the ecosystem settings "<TCID>"
Then I click on operations to navigate Tenants tab
Then I delete the Tenant "<TCID>"
And I close the browser

Examples:
		|TCID      |TCID2|
		|VMM-3584_1|VMM-3584_2|




