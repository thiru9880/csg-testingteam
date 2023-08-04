############################
# Author : Dilip k
# Test Cased ID : VMM_3853
############################
Feature: Users Tab Feature

@VMM-3853 @reg @int @tm @Integration2
   Scenario Outline: VMM_3853_Allow publishing the license of the types  FEATURE_APP, DEVICE or VEHICLE only when the APP license has already been published
    Given I login to LM application with valid credentials
    Then I create a tenant for the customer created "<TCID>"
    Then I create multiple licences for the tenant created using licensetype 'APP FEATURE_APP'
    Then I verify on publishing the vehicle license created, pop up message is shown
    Then I verify on TM Swagger that the published license is not active
    Then I create app licences for the tenant created
    Then I verify on publishing the app license created, pop up message is not shown
    Then I verify on TM swagger that the published license is in active state
    Then I delete the published App license "<TCID>"
    Then I delete the published Vehicle licenses "<TCID2>"
    Then I delete the published Vehicle licenses "<TCID3>"
    Then I click on operations to Navigate Ecosystem Settings
    Then I delete the ecosystem settings "<TCID>"
    Then I click on operations to navigate Tenants tab
    Then I delete the Tenant "<TCID>"
    And I close the browser

  Examples:
    | TCID       | TCID2      | TCID3      |
    | VMM_3853_1 | VMM_3853_2 | VMM_3853_3 |
