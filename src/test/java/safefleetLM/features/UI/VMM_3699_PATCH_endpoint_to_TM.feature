##############################################################
#Author: Bhanu
#Test Case ID: VMM_3699
##############################################################
Feature: PATCH endpoint to TM

  @VMM-3699 @reg @int @tm @Integration2
  Scenario Outline: VMM_3699 PATCH endpoint to TM
    Given I login to LM application with valid credentials
    Then I click on operations to navigate Tenants tab
    And I create a tenant with admin email "<TCID>"
    When I navigate to licenses page
    Then I create license for the above created tenant "<TCID>"
    Then I verify licenses i created are correct in licenses tab "<TCID>"
    Then I publish the license "<TCID>"
    Then I Verify the tenant created above via TM swagger and validate the tenant details "<TCID>"
    When I click on operations to navigate Tenants tab
    Then I edit the tenant Admin Email "<TCID>"
    And I verify the changes made in LM for the tenant in TM swagger "<TCID>"
    When I navigate to licenses page
    Then I delete the published license "<TCID>"
    When I click on operations to navigate Tenants tab
    Then I delete the Tenant "<TCID>"
    And I close the browser

    Examples: 
      | TCID       |
      | VMM_3699_1 |
