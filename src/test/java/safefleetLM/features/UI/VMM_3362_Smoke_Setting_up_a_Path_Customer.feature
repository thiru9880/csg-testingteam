##############################################################
# Author: Bhanu
# Test Case ID: VMM_3362
##############################################################
Feature: Setting up a Path Customer

  @VMM-3362 @reg @smoke @smoke2 @Licenses
  Scenario Outline: VMM_3362 Setting up a Path Customer
    Given I login to LM application with valid credentials
  #  Then I click on operations to navigate customer page
   # Then I Check that the Customer has been created if not i create the Customer "<TCID>"
    Then I click on operations to navigate Tenants tab
    Then I create the Tenant with Deployment type is CLOUD COMMERCIAL "<TCID>"
    Then I navigate to licenses page
    Then I Create App license with valid data "<TCID>"
    Then I Create Vehicle License for x number of vehicles specified in sales order "<TCID2>"
    Then I verify licenses i created are correct in licenses tab "<TCID>"
    Then I click on operations to Navigate Ecosystem Settings
    Then I verify software setting is created with Tenant id if not Create software setting "<TCID>"
    Then I navigate to licenses page
    Then I publish the App license "<TCID>"
    Then I publish Vehicle licenses "<TCID>"
    Then I delete the published App license "<TCID>"
    Then I delete the published Vehicle licenses "<TCID>"
    Then I click on operations to Navigate Ecosystem Settings
    Then I delete the ecosystem settings "<TCID>"
    Then I click on operations to navigate Tenants tab
    Then I delete the Tenant "<TCID>"
#    Then I click on operations to navigate customer page
#    And I delete the customer "<TCID>"
    And I close the browser

    Examples:
      | TCID       | TCID2      |
      | VMM_3362_1 | VMM_3362_2 |
