##############################################################
# Author: Bhanu
# Test Case ID: VMM_3361
##############################################################
Feature: Manage Device Settings Page

  @VMM-3361 @reg @smoke @smoke1 @Licenses
  Scenario Outline: VMM_3361 Setting up an Evidence Manager
    Given I login to LM application with valid credentials
    Then I click on operations to navigate Tenants tab
    Then I create the Tenant with Deployment type is onsite "<TCID>"
    Then I navigate to licenses page
    Then I Create App license with valid data "<TCID>"
    Then I Create a FEATURE_APP Redaction License as specified in Sales order "<TCID2>"
    Then I verify licenses i created are correct in licenses tab "<TCID>"
    Then I publish the FEATURE_APP Redaction license
    Then I click on publish for the App license
    And I click and verify checkbox so that i can download encrypted license File "<TCID>"
    Then I Verify that Download Pop up come up when you publish more than ones
    Then I delete the published App license "<TCID>"
    Then I delete the published FEATURE_APP Redaction license "<TCID>"
    Then I click on operations to navigate Tenants tab
    Then I delete the Tenant "<TCID>"
    And I close the browser

    Examples:
      | TCID       | TCID2      |
      | VMM_3361_1 | VMM_3361_2 |
