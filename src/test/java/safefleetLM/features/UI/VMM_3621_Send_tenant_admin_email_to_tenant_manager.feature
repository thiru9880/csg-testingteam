##############################################################
# Author: Bhanu
# Test Case ID: VMM_3621
##############################################################
Feature: Send tenant admin email to tenant manager

  @VMM-3621 @reg @int @tm @Integration1
  Scenario Outline: VMM_3621 Send tenant admin email to tenant manager
    Given I login to LM application with valid credentials
 #   Then I click on operations to navigate customer page
 #   Then I Check that the Customer has been created if not i create the Customer "<TCID>"
    Then I click on operations to navigate Tenants tab
    Then I create a tenant with admin email "<TCID>"
    Then I navigate to licenses page
    Then I create license for the above created tenant "<TCID>"
    Then I verify licenses i created are correct in licenses tab "<TCID>"
    Then I publish the license "<TCID>"
    Then I verify in Tenant Manager via Swagger UI to make sure tenant Admin Email make it to TM "<TCID>"
    Then I delete the published license "<TCID>"
    Then I click on operations to navigate Tenants tab
    Then I delete the Tenant "<TCID>"
#    Then I click on operations to navigate customer page
#    And I delete the customer "<TCID>"
    And I close the browser

    Examples: 
      | TCID       |
      | VMM_3621_1 |
