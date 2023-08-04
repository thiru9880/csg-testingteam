##############################################
#Author : Nitin Kumar														
#Test Case ID: VMM_3578											
##############################################

Feature: Limitation on Tenant ID length

@VMM-3578 @reg @Tenants
Scenario Outline: VMM_3578 Limitation on Tenant ID length
Given I login to LM application with valid credentials
Then I navigate to the Operation Tab
Then I navigate to Tenants Tab
Then I create new Tenant and enter required details including Tenant ID more than 20 characters "<TCID>"
And I verify that system will not let type more than 20 characters for Tenant ID
And I close the browser
    
Examples: 
| TCID    |
|VMM3578_1|