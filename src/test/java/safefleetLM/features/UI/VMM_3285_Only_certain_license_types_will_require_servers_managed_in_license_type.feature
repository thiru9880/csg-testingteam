
###################################################
#Authour:Sunilkumar
#Test CaseID: VMM_3285
###################################################
Feature: Only certain license types will require servers- managed in license type

  @VMM-3285  @reg @System_Admin
  Scenario Outline: VMM_3285 Only certain license types will require servers- managed in license type
    Given I login to LM application with valid credentials
    When I navigate to system admin
    And I navigate to license Type Tab
    Then I verify Server data is mandatory for only certain license types
    When I click on operations to navigate Tenants tab
    Then I create new tenant for VMM3285 with test data "<TCID>"
		When I navigate to Licences Tab
    Then I Verify that when creating licenses with test data "<TCID2>",Server data is mandatory for only certain license types
    Then I click on operations to navigate Tenants tab
    Then I delete the Tenant "<TCID>"
    And I close the browser

    Examples:
      | TCID    | TCID2   |
      |VMM3285_1|VMM3285_1|
