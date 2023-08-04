############################
# Author : Naincy Soni
# Test Cased ID : VMM_3870
############################
Feature: Create and publish license for SF Cognition base product

@VMM-3870 @VMM-4916 @reg @int @tm @Integration2
Scenario Outline: VMM-3870	Offer SF Cognition as a Base Product License instead ARGUS
Given I login to LM application with valid credentials
Then I navigate to Base Product Tab
Then I verify SF Cognition details in Base Product Tab with expected test data "<TCID>"
Then I verify Application ID in TM Swagger with expected test data "<TCID>"
Then I navigate to license Type Tab
Then I verify license types: BASE_PRODUCT details for SF Congnition with expected test data "<TCID>"
Then I verify license types: DEVICE details for SF Congnition with expected test data "<TCID2>"
Then I create new tenant for VMM3870 with test data "<TCID>"
Then I navigate to Licences Tab
Then I create license for BASE_PRODUCT License Type with test data "<TCID>"
Then I create new license for SFCognition with test data "<TCID2>"
Then I create new license for Genetec Integration Add-on Module with test data "<TCID3>"
Then I navigate to ecosystem settings tab
Then I create unique ecosystem setting with test data "<TCID>"
Then I publish SF Cognition license in LM with test data "<TCID>"
Then I verify published license details for SF Cognition in TM via swagger with expected test data "<TCID>"
Then I delete the published App license "<TCID>"
Then I delete the published Vehicle licenses "<TCID>"
Then I delete the published Vehicle licenses "<TCID>"
Then I click on operations to Navigate Ecosystem Settings
Then I delete the ecosystem settings "<TCID>"
Then I click on operations to navigate Tenants tab
Then I delete the Tenant "<TCID>"
And I close the browser
Examples:
		|TCID      |TCID2		| TCID3		 |
		|VMM-3870|VMM-3870_2|VMM-3870_3|

