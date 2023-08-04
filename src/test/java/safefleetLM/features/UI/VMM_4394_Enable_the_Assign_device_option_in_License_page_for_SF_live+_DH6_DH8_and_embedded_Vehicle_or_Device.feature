##############################################################
# Author: Bhanu
# Test Case ID: VMM_4394
##############################################################
Feature: Enable the Assign device option in License page

  @VMM-4394 @reg @Licenses
  Scenario Outline: VMM_4394 Enable the Assign device option in License page
    Given I login to LM application with valid credentials
    Then I click on operations to navigate Tenants tab
    Then I create the Tenant with Deployment type is onsite "<TCID>"
    When I navigate to licenses page
    Then I create license for DH6 license type "<TCID>"
    And I create license for DH8 license type "<TCID2>"
    Then I verify that Assign device option is enabled for DH6 and DH8 "<TCID>"
    Then I verify that Assign device option is enabled for SF live+ "<TCID>"
    Then I verify that Assign device option is enabled for Vehicle/Device licenses "<TCID>"
    Then I verify that Assign device option is disabled for all other licenses except for SF live+,DH6,DH8 and embedded Vehicle/Device licenses "<TCID>"
    Then I delete the published license "<TCID>"
    Then I delete the published license "<TCID>"
    Then I click on operations to navigate Tenants tab
    Then I delete the Tenant "<TCID>"
    And I close the browser

    Examples: 
      | TCID       | TCID2      |
      | VMM_4394_1 | VMM_4394_2 |
