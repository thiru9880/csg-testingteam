############################
# Author: Bhanu
# Test Case ID: VMM_3409
############################
Feature: Manage Filters in Device Settings page and Ecosystem Settings page

  @VMM-3409 @reg @Tenants
  Scenario Outline: VMM_3409 Manage Filters
    Given I login to LM application with valid credentials
    Then I click on operations to Navigate Device Settings
    Then I verify if the Settings Type filter is removed "<TCID>"
    And I check all the filters are working correctly "<TCID>"
    Then I delete the created device setting "<TCID>"
    Then I click on operations to navigate Tenants tab
    And I create new Tenant with test data "<TCID>"
    Then I click on operations to Navigate Ecosystem Settings
    Then I verify if the Settings Type filter is removed in Ecosystem Settings "<TCID>"
    And I create Ecosystem setting for created tenant "<TCID>"
    Then I Verify if the Tenant ID filter has three filter options and verify their working Condition "<TCID>"
    Then I delete the ecosystem settings "<TCID>"
    Then I click on operations to navigate Tenants tab
    Then I delete the Tenant "<TCID>"
    And I close the browser

    Examples: 
      | TCID       |
      | VMM_3409_1 |
