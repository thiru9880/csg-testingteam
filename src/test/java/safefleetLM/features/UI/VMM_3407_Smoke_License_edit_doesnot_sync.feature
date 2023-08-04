############################
# Author : Dilip k
# Test Cased ID : VMM_3407
############################
Feature: Users Tab Feature

@VMM-3407 @reg @smoke @smoke1 @int @tm @Integration1
   Scenario Outline: VMM-3407 License edit does not sync after republishing
    Given I login to LM application with valid credentials
    Then I create new tenant for VMM3407 "<TCID>"
    Then I create a new license with syncWithTenantManager on
    Then I publish the license
    Then I verify on Tenant Manager that the published license is displayed
    Then I edit the license and republish again
    Then I verify if the changes made are displayed in Tenant Manager
    When I navigate to the Operation Tab
    When I navigate to Licences Tab
    Then I search the licenses I created with testdata "<TCID>"
    Then I delete the published App license "<TCID>"
    Then I click on operations to Navigate Ecosystem Settings
    Then I delete the ecosystem settings "<TCID>"
    Then I click on operations to navigate Tenants tab
    Then I delete the Tenant "<TCID>"
    And I close the browser

  Examples:
    | TCID     |
    |VMM_3407_1|
