##############################################################
# Author: Bhanu
# Test Case ID: VMM_3275,VMM_3403
##############################################################
Feature: Call the appropriate API for government cloud creation

  @VMM-3275 @VMM-3403 @reg @Licenses
  Scenario Outline: VMM_3275 Call the appropriate API for government cloud creation
    Given I login to LM application with valid credentials
    Then I click on operations to navigate Tenants tab
    Then I create the Tenant with Deployment type is CLOUD GOVERNMENT "<TCID>"
    Then I navigate to licenses page
    Then I create license for the above created tenant "<TCID>"
    Then I verify licenses i created are correct in licenses tab "<TCID>"
    Then I publish the license "<TCID>"
    Then I click on Generate Keys and make sure that it navigates to TM government site "<TCID>"
    And I verify creates an api client with the name scheme "<TCID>"
    And I quite the browser

    Examples:
      | TCID       |
      | VMM_3275_1 |

  @VMM-3403 @VMM-3275 @reg @Licenses
  Scenario Outline: VMM_3403 Rework creation of API
    Given I login to LM application with valid credentials
    Then I navigate to Base Product Tab
    Then I check the license type configuration for that license and see that resources are assigned "<TCID>"
    Then I navigate to licenses page
    Then I delete the published license "<TCID>"
    Then I click on operations to navigate Tenants tab
    Then I delete the Tenant "<TCID>"
    And I close the browser

    Examples:
      | TCID       |
      | VMM_3275_1 |
