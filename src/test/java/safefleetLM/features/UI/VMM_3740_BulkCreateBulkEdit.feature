############################
# Author : Naincy Soni
# Test Cased ID : VMM_3740
############################
Feature: Bulk create and bulk edit

@VMM-3740 @reg @Devices
Scenario Outline:VMM-3740 Bulk create and bulk edit issues seen after implementing "Customer Provided" column
Given I login to LM application with valid credentials
Then I click on bulk upload button, select upload spreadsheet and click on upload button
Then I verify that the Device is created successfully with success message
Then I verify Customer Provided column and Device status column is displayed in UI with test data "<TCID>"
Then I click on finalize button 
Then I select device for bulk edit with test data "<TCID>"
Then I click on bulk edit
Then i click on device manually selsected
Then i edit device type with test data "<TCID>"
Then I verify that the Device is created successfully with success message
Then I click on finalize button
Then I verify device type is updated
Then I delete all Device "<TCID>"
And I close the browser
Examples:
		|TCID      |TCID2     |
		|VMM-3740_1|VMM-3740_2|