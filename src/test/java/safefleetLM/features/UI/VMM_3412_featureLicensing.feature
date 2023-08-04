############################
# Author : Naincy Soni
# Test Cased ID : VMM_3412
############################
Feature: feature licensing

@VMM-3412 @reg @Licenses
Scenario Outline: VMM-3412 vMaxLive+: APP and Feature Licensing
Given I login to LM application with valid credentials
Then I create new tenant for VMM3412 with test data "<TCID>"
Then I create licenses for SF Live base product for the license types:BASE_PRODUCT with test data "<TCID>"
Then I create licenses for SF Live base product for the license types:STUDENT_TRACKING with test data "<TCID2>"
Then I create licenses for SF Live base product for the license types:ZONAR_INTEGRATION with test data "<TCID3>"
Then I create licenses for SF Live base product for the license types:TRANSFINDER with test data "<TCID4>"
Then I Verify that the vMax APP and the features licensed have been added to Licenses table with test data "<TCID>"
Then I delete the License "<TCID>"
Then I delete the License "<TCID>"
Then I delete the License "<TCID>"
Then I delete the License "<TCID>"
Then I click on operations to navigate Tenants tab
Then I delete the Tenant "<TCID>"
And I close the browser

Examples:
		|TCID      |TCID2     |TCID3     |TCID4     |
		|VMM-3412_1|VMM-3412_2|VMM-3412_3|VMM-3412_4|
