############################
# Author : Dilip k
# Test Cased ID : VMM_3272
############################
Feature: Users Tab Feature


@VMM-3272 @reg @smoke @smoke1 @int @tm @Integration1
   Scenario Outline: VMM-3272 Terminate and Returned license
    Given I login to LM application with valid credentials
    Then I create new tenant for VMM3272 "<TCID>"
    #Then I create multiple licences for the tenant created with Sync to TM ON
    #Then  publish all of the licenses created
    #Then I verify on TM Swagger that the published license is adding up and showing in TM
  Then I create all three different licences for the tenant created using licensetype 'APP FEATURE_APP'
  Then I verify on publishing the vehicle and add-on license created, warning pop up message is shown
  Then I verify on TM Swagger that the vehicle & add-on published license is not active
  Then I create app licence in draft status for the tenant created
  Then I verify on publishing the app license, warning pop up message is not shown
  Then I verify on TM swagger that app published license is in active state
    Then I terminate the licenses and verify if the count is decreasing in TM
    Then I return the license and delete the licenses "<TCID>"
    Then I verify on TM swagger that the returned license is also removed from the licenses count in TM
    When I navigate to the Operation Tab
    When I navigate to Licences Tab
    Then I return the vehicle license and delete the licenses "<TCID>"
    Then I return the license and delete the licenses "<TCID>"
    Then I click on operations to Navigate Ecosystem Settings
    Then I delete the ecosystem settings "<TCID>"
    Then I click on operations to navigate Tenants tab
    Then I delete the Tenant "<TCID>"
    And I close the browser

  Examples:
    | TCID     | TCID2      | TCID3      |
    |VMM_3272_1| VMM_3272_2 | VMM_3272_3 |
