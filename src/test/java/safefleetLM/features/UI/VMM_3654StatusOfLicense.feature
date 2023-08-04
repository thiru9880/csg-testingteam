############################
# Author : Naincy Soni
# Test Cased ID : VMM_3654
############################
Feature: Status of license

@VMM-3654 @reg @int @tm @Integration1
Scenario Outline:VMM-3654 Status should be "EXPIRED" when base product license is removed
Given I login to LM application with valid credentials
Then I create new tenant for VMM3654 with test data "<TCID>"
Then I create APP license for DES CLOUD COURIER with test data "<TCID>"
Then I create FEATURE license for DES CLOUD COURIER with test data "<TCID1>"
Then I navigate to ecosystem settings tab
Then I create unique ecosystem setting with test data "<TCID>"
Then I Publish Both License with test data "<TCID>"
Then I verify the published license Active Status in TM via swagger with expected test data "<TCID>"
Then I terminate APP license with test data "<TCID>"
Then I verify the published license Expired Status in TM via swagger with expected test data "<TCID1>"
And I close the browser
Examples:
		|TCID      |TCID1     |
		|VMM-3654_1|VMM-3654_2|
