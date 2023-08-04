############################
# Author : Naincy Soni
# Test Cased ID : VMM_3406
############################
Feature: Feature Apps are being combined into One license type

@VMM-3406 @reg @Licenses
Scenario Outline: VMM-3406 Feature Apps are being combined into One license type
Given I login to LM application with valid credentials
Then I navigate to Tenant tab
Then I create new tenant for VMM3406 with test data "<TCID1>"
Then I navigate to Licences Tab
Then I create APP license for SF Live+ with test data "<TCID1>"
Then I create FEATURE APP Zonar integration license for SF Live+ with test data "<TCID2>"
Then I create FEATURE APP Transfinder integration license for SF Live+ with test data "<TCID3>"
Then I create FEATURE APP Student Tracking license for SF Live+ with test data "<TCID4>"
Then I create FEATURE APP DVR Health license for SF Live+ with test data "<TCID5>"
Then I verify grouping of FEATURE APP in license table with test data "<TCID1>"
#Then I delete all the license created "<TCID1>"
Then I delete the License "<TCID1>"
Then I delete the License "<TCID1>"
Then I delete the License "<TCID1>"
Then I delete the License "<TCID1>"
Then I delete the License "<TCID1>"
Then I click on operations to navigate Tenants tab
Then I delete the Tenant "<TCID1>"
And I close the browser
Examples:
		|TCID1     |TCID2     |TCID3     |TCID4     |TCID5     |
		|VMM-3406_1|VMM-3406_2|VMM-3406_3|VMM-3406_4|VMM-3406_5|
