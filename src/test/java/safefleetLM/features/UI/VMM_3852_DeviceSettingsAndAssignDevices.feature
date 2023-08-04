############################
# Author : Naincy Soni
# Test Cased ID : VMM_3852
############################
Feature: Device Settings and assign devices

@VMM-3852 @reg @Devices
Scenario Outline:VMM-3852 Device Settings and assign devices "the settings button does not work"
Given I login to LM application with valid credentials
#Then I navigate to Device Type Tab to select device
Then I navigate to the Operation Tab
Then I navigate to Tenant tab
Then I create new tenant for VMM3852 with test data "<TCID>"
Then Pre-condition: I create a Device "<TCID>"
Then I create license with VEHICLE license type with test data "<TCID>"
Then I verify setting button is disabled with test data "<TCID>"
Then I navigate to the Operation Tab
Then I navigate to Device tab
Then I delete the Device "<TCID>"
Then I delete the created license "<TCID>"
Then I click on operations to navigate Tenants tab
Then I delete the Tenant "<TCID>"
And I close the browser
Examples:
		|TCID      |
		|VMM-3852_1|
