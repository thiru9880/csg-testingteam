##############################################
#Author : Nitin Kumar
#Test Case ID: VMM_3736
##############################################

Feature: Editing tenant deployment type after license creation is messing up the software license

@VMM-3736 @reg @Tenants
Scenario Outline: VMM_3736 Editing tenant deployment type after license creation is messing up the software license
Given I login to LM application with valid credentials
Then I navigate to the Operation Tab
Then I navigate to Tenants Tab
Then I create a Tenant with cloud deployment type "<TCID>"
Then I navigate to Licences Tab
Then I create an APP License for the Tenant created above for any software "<TCID>"
Then I navigate to Tenants Tab
Then I search for Tenant created above and when found click on edit button "<TCID>"
And I verify that the system prevents editing the Tenant deployment type to Onsite as there are already Licenses created for it
Then I navigate to licenses page
Then I delete the published license "<TCID>"
Then I click on operations to navigate Tenants tab
Then I delete the Tenant "<TCID>"
And I close the browser

Examples:
|TCID     |
|VMM3736_1|
