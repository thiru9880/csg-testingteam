############################
# Author : Naincy Soni
# Test Cased ID : VMM_3411
############################
Feature: Tracking Expiry Dates

@VMM-3411 @reg @Licenses
Scenario Outline: VMM-3411 Tracking Expiry Dates:
Given I login to LM application with valid credentials
Then I create new tenant for VMM3411 with test data "<TCID>"
Then I create licenses for SF Vehicle inspection base product with test data "<TCID>"
Then I create licenses for MobileDeviceManager  base product with test data "<TCID2>"
Then I create licenses for School Bus Hub  base product with test data "<TCID3>"
Then I verify expiration date for all licenses have been added to Licenses table with test data "<TCID>"
Then I delete the License "<TCID>"
Then I delete the License "<TCID>"
Then I delete the License "<TCID>"
When I navigate to Tenant tab
Then I delete the Created Tenant "<TCID>"
And I close the browser

Examples:
		|TCID      |TCID2     |TCID3     |TCID4     |
		|VMM-3411_1|VMM-3411_2|VMM-3411_3|VMM-3412_4|
