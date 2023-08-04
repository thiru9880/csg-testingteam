##############################################################
# Author: Bhanu
# Test Case ID: VMM_3572
##############################################################
Feature: Manage Tenant ID

  @VMM-3572 @int @tm @reg @Integration1
  Scenario Outline: VMM_3572 After saving a new tenant the TenantID doesnt visualize correctly in the Tenants dashboard
    Given I login to LM application with valid credentials
    When I click on operations to navigate customer page
    Then I verify that system will not let to type more than 50 characters while create customer and create customer with Customer length 50 characters "<TCID>"
    When I click on operations to navigate Tenants tab
    Then I verify that system will not let to type more than 20 characters for tenant ID and create Tenant with length 20 characters "<TCID>"
    Then I navigate to licenses page
    Then I Create App license with valid data "<TCID>"
    Then I create a FEATURE_APP DES Cloud Courier licenses "<TCID2>"
    Then I click on operations to Navigate Ecosystem Settings
    And I create Ecosystem setting for created tenant "<TCID>"
    Then I navigate to Licences Tab
    Then I publish the App license "<TCID>"
    Then I publish the FEATURE_APP Redaction license
    Then I verify in Tenant Manager via Swagger UI to make sure licenses and tenant from LM make it to TM "<TCID>"
    Then I delete the published App license "<TCID>"
    Then I delete the published license "<TCID>"
    Then I click on operations to Navigate Ecosystem Settings
    Then I delete the ecosystem settings "<TCID>"
    Then I click on operations to navigate Tenants tab
    Then I delete the Tenant "<TCID>"
    Then I click on operations to navigate customer page
    And I delete the customer "<TCID>"
    And I close the browser

    Examples: 
      | TCID       | TCID2      |
      | VMM_3572_1 | VMM_3572_2 |
