##############################################################
# Author: Bhanu
# Test Case ID: VMM_4501,
##############################################################
Feature: Manage Tenant

  @VMM-4501 @VMM-5468 @reg @smoke @smoke2 @int @tm @Integration2
  Scenario Outline: VMM_4501 VMM_5468 Publish 'SF Cloud Starter' base product license and verify the sync in TM
    Given I login to LM application with valid credentials
    Then I click on operations to navigate Tenants tab
    Then I create a tenant with admin email "<TCID>"
    Then I navigate to licenses page
    Then I create a App license for the Base product SF Cloud Starter "<TCID>"
    Then I create a CleverIVN Asset license for the Base product SF Cloud Starter "<TCID2>"
    Then I click on operations to Navigate Ecosystem Settings
    And I create Ecosystem setting for created tenant "<TCID>"
    Then I navigate to Licences Tab
    Then I verify licenses i created are correct in licenses tab "<TCID>"
    Then I publish the license "<TCID>"
    Then I search and publish the License "<TCID2>"
    Then I verify in Swagger that published licenses sync with TM and shows up correctly in TM swagger "<TCID>"
    Then I search and expand the License with Tenant Id "<TCID>"
    Then I delete the published App license "<TCID>"
    Then I search and expand the License with Tenant Id "<TCID2>"
    Then I delete the published Add-on module Asset license "<TCID2>"
    Then I click on operations to Navigate Ecosystem Settings
    Then I delete the ecosystem settings "<TCID>"
    Then I click on operations to navigate Tenants tab
    Then I delete the Tenant "<TCID>"
    And I close the browser

    Examples:
      | TCID       | TCID2      |
      | VMM_4501_1 | VMM_4501_2 |
