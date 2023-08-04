##############################################################
# Author: Bhanu
# Test Case ID: VMM_4338
##############################################################
Feature: Manage Tenant

  @VMM-4338 @int @tm @reg @Integration2
  Scenario Outline: VMM_4338 Verify that the status is Active for Expired SF Commander
    Given I login to LM application with valid credentials
    Then I click on operations to navigate Tenants tab
    Then I create a tenant with admin email "<TCID>"
    When I navigate to licenses page
    Then I create a SF commander license with crossed expiration date "<TCID>"
    Then I click on operations to Navigate Ecosystem Settings
    And I create Ecosystem setting for created tenant "<TCID>"
    When I navigate to licenses page
    Then I verify licenses i created are correct in licenses tab "<TCID>"
    Then I publish the license "<TCID>"
    And I verify that the license status is Active "<TCID>"
    Then I verify in swagger that the above expired license has status as Active in TM "<TCID>"
    Then I verify in DB under license table that license status should be ACTIVE "<TCID>"
    And I verify in DB that No renewal status available for license even if it is expired "<TCID>"
    Then I delete the published license "<TCID>"
    Then I click on operations to Navigate Ecosystem Settings
    Then I delete the ecosystem settings "<TCID>"
    Then I click on operations to navigate Tenants tab
    Then I delete the Tenant "<TCID>"
    And I close the browser

    Examples: 
      | TCID       |
      | VMM_4338_1 |
