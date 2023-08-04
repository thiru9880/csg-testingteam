##############################################################
# Author: Bhanu
# Test Case ID: VMM_3274,VMM_3395
##############################################################
Feature: Manage Deployment type in Tenant and Manage User account

  @VMM-3274 @VMM-3395 @reg @Tenants
  Scenario Outline: VMM_3274,VMM_3395 Manage Deployment type in Tenant and Manage User account
    Given I login to LM application with valid credentials
    Then I click on operations to navigate Tenants tab
    Then I click on CREATE A NEW TENANT
    And I check Deployment Type field has cloud deployment types "<TCID>"
    Then I click on System admin to navigate Users
    Then I Click on NEW to verify if the operations admin can create new users "<TCID2>"
    Then I verify ROLE_OPERATIONS_ADMIN user able to view and edit "<TCID2>"
    Then I delete the user "<TCID2>"
    And I close the browser

    Examples: 
      | TCID2      | TCID       |
      | VMM_3395_1 | VMM_3274_1 |
