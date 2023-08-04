##############################################################
# Author: Bhanu
# Test Case ID: VMM_3371,VMM_3591,VMM_3373,VMM_3399,VMM_3663
##############################################################
Feature: Manage Tenant

  @VMM-3371 @VMM-3591 @VMM-3373 @VMM-3399 @VMM-3663 @reg @Tenants
  Scenario Outline: VMM_3371,VMM_3591,VMM_3373,VMM_3399,VMM_3663 Manage Tenant
    Given I login to LM application with valid credentials
    When I click on System Admin to navigate Tenant types tab
    Then I verify the Commercial vehicle "<TCID>"
    Then I click on operations to navigate Tenants tab
    Then I click on CREATE A NEW TENANT and verify Commercial Vehicle in Tenant Type picklist "<TCID>"
    And I create new Tenant with test data "<TCID>"
    Then I verify the Tenant Information in Tenant metadata "<TCID>"
    Then I Verify Tenant ID should be converted to lower case "<TCID>"
    Then I edit Tenant metadata and verify in Tenant table "<TCID>"
    Then I delete the edited Tenant "<TCID>"
    Then I click on SHOW FILTERS to verify Customer id filter
    And I close the browser

    Examples: 
      | TCID       |
      | VMM_3371_1 |
