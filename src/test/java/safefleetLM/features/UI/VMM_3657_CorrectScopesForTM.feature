############################
# Author : Naincy Soni
# Test Cased ID : VMM_3657
############################
Feature: Correct scope for TM

@VMM-3657 @reg @int @tm @Integration1
Scenario Outline: VMM-3657 Correct scopes for TM service calls token creation
Given I login to LM application with valid credentials
Then I create new tenant for VVMM3657 with test data "<TCID>"
Then I create APP license with test data "<TCID>"
Then I navigate to ecosystem settings tab
Then I create unique ecosystem setting with test data "<TCID2>"
Then I Publish License with test data "<TCID>"
Then I verify the published licenses details in TM via swagger with expected test data "<TCID>" 
And I close the browser
Examples:
		|TCID      |TCID2     |
		|VMM-3657_1|VMM-3657_2|