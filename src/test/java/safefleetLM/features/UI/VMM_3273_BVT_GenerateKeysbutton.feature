###########################
# Author : Naincy Soni
# Test Cased ID : VMM_3273, VMM_3385
############################
Feature: Generating Key Button

@VMM-3273 @VMM-3385 @reg @Licenses @smoke @smoke2
Scenario Outline: VMM-3273 ,VMM_3385 Generate Keys button
Given I login to LM application with valid credentials
Then I create new tenant for VMM3273 with test data "<TCID>"
Then I verify Cloud checkbox is selected for DES Cloud Courier in Base Product page with test data "<TCID>"
Then I verify SynctoTM checkbox is on for the license types:BASE_PRODUCT for DES Cloud Courier with test data "<TCID>"
Then I verify SynctoTM checkbox is on for the license types:ADD_ON_PRODUCT for DES Cloud Courier with test data "<TCID2>"
Then I verify SHARING--CONTROLLER--API option is selected for the Resources dropdown for the license types:ADD_ON_PRODUCT for DES Cloud Courier with test data "<TCID2>"
Then I create new license for license types: BASE_PRODUCT for DES Cloud Courier with test data "<TCID>"
Then I create new license for license types:ADD_ON_PRODUCT for DES Cloud Courier with test data "<TCID2>"
Then I publish all license in LM with test data "<TCID>"
Then I verify Generate key option for both license in license table with test data "<TCID>"
Then I click the blue Action dropdown menu again and click on generate keys option
Then I verify Tenant Manager Page able to see your newly created TENANT ID in the table
 And I verify creates an api client with the name scheme "<TCID>"
 And I switch to parent tab
 Then I delete the published App license "<TCID>"
Then I delete the published Vehicle licenses "<TCID2>"
Then I click on operations to navigate Tenants tab
Then I delete the Tenant "<TCID>"
 And I quit the browser
Examples:
		|TCID      |TCID2     |
		|VMM-3273_1|VMM-3273_2|
