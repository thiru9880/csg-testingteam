###################################################
#Authour:Sunilkumar
#Test CaseID: VMM_3393,VMM_3378
###################################################
Feature: Ecosystem Settings Tenant ID narrow picklist


  @VMM-3393 @VMM-3378 @reg @Operations
  Scenario Outline: VMM_3393,VMM_3378 Ecosystem Settings Tenant ID narrow picklist
    Given I login to LM application with valid credentials
    #When I click on operations to navigate Tenants tab
    Then I create new tenant for VMM3393 with test data "<TCID>"
    Then I navigate to Ecosystem Setting
    Then I Click on NEW to create new ecosystem settings with Test data "<TCID>"
    When I Verify that Tenant ID value, the picklist should be narrowed down with Test data "<TCID>"
    Then I navigate to Ecosystem Setting
    When I Verify that Tenant ID filter works fine with all the equality operations with Test data "<TCID>"
    Then I Click the clipboard symbol with Test data "<TCID>"
    When I Verify the Entity Audits page loads showing Changes for SettingsInstance with Test data "<TCID>"
    Then I click on operations to navigate Tenants tab
    Then I delete the Tenant "<TCID>"
    And I close the browser

  Examples:
      | TCID    |
      |VMM3393_1|
