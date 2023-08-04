#Author: Savitha

Feature: Verify License Manager Tenants screen and readonly functionality


  @prod @prod1 @VMM-5654
  Scenario Outline: VMM-5654_Verify_LM_Tenants screen and readonly functionality
    Given I login to LM application with valid credentials
    Then I navigate to Tenant tab
    Then I verify that the Tenant filter attribute match with column names in tenant table
    Then I click on NEW and verify new Tenant creation screen
    Then I verify all the device types are listed in the Device Type dropdown in the Available Devices section "<TCID>"
    Then I search Tenant with multiple filter condition "<TCID>"
    Then I view Tenant and verify tenant details as per filter "<TCID>"
    And I close the browser


     Examples:
     |TCID    |
     |VMM_5654_1|
