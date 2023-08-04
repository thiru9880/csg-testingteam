############################
# Author : Naincy Soni
# Test Cased ID : VMM_3953
############################
Feature: Create and publish license for SF clearLane base product

@VMM-3953 @reg @smoke @smoke2 @int @tm @Integration2
Scenario Outline: VMM-3953	Lane Enforcement base product name and icon changes are missing
Given I login to LM application with valid credentials
Then I navigate to Base Product Tab
Then I verfy Base Product details for the "SF ClearLane	" in test data "<TCID>"
Then I navigate to license Type Tab
Then I verify license types: BASE_PRODUCT details for SF ClearLane with expected test data "<TCID>"
Then I verify license types: DEVICE details for SF ClearLane with expected test data "<TCID1>"
Then I navigate to Device Type Tab
Then I verify details for ISAM3 device type with expected test data "<TCID>"
Then I create new tenant for VMM3953 with test data "<TCID>"
Then I navigate to Licences Tab
Then I create new license for BASE_PRODUCT License Type with test data "<TCID>"
Then I create new license for SFClearLane with test data "<TCID1>"
Then I navigate to ecosystem settings tab
Then I create unique ecosystem setting with test data "<TCID>"
Then I publish SF ClearLane licenses in LM with test data "<TCID>"
Then I verify the published licenses details for SF ClearLane in TM via swagger with expected test data "<TCID>"
Then I delete the published App license "<TCID>"
Then I delete the published Vehicle licenses "<TCID>"
Then I click on operations to Navigate Ecosystem Settings
Then I delete the ecosystem settings "<TCID>"
Then I click on operations to navigate Tenants tab
Then I delete the Tenant "<TCID>"
And I close the browser
Examples:
		|TCID      |TCID1|
		|VMM-3953|VMM-3953_2|
