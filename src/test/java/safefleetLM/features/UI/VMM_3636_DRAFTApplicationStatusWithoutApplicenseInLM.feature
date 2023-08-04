############################
# Author : Naincy Soni
# Test Cased ID : VMM_3636
############################
Feature: Verify "DRAFT" application status without app license in LM

@VMM-3636 @reg @int @tm @Integration1
Scenario Outline:VMM-3636 "DRAFT" application status without app license in LM
Given I login to LM application with valid credentials
Then I create new tenant for VVMM3636 with test data "<TCID>"
Then I create DEVICE BW license for Nexus with test data "<TCID>"
Then I create DEVICE ICV license for Nexus with test data "<TCID2>"
Then I publish DEVICE BW license for Nexus with test data "<TCID>"
Then I verify  application status as DRAFT in TM swagger with test data "<TCID>"
Then I publish DEVICE ICV license for Nexus with test data "<TCID>"
Then I verify  application status as DRAFT in TM swagger with test data "<TCID>"
Then I delete the published Asset license "<TCID>"
Then I delete the published license "<TCID2>"
Then I click on operations to navigate Tenants tab
Then I delete the Tenant "<TCID>"
And I close the browser
Examples:
		|TCID      |TCID2     |
		|VMM-3636_1|VMM-3636_2|
