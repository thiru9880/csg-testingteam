#Author: Savitha

Feature: Verify License Manager Dashboard Screen


  @prod @prod1 @VMM-5652
  Scenario Outline: VMM-5652_LM dashboard screen verification
    Given I login to LM application with valid credentials
    Then I verify that the Customer, Tenanats, Devices, Licenses panels displayed with number of count
    Then I verify that the Licenses & Device usage sections are displayed with Data & Pie chart respectively
    Then I verify that Tenant Manager section is displayed with the status icon
    Then I verify that Daily Sync Jobs - SyncTM section is displayed with the tool tip
    And I close the browser


