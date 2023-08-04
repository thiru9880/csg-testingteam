#Author: Savitha

Feature: License Manager App Login and Logout


  @prod @prod1 @VMM-5651 @VMM-5352 @reg @Operations
  Scenario: VMM-5651 VMM-5352 LM authentication, user name & version details verification
    Given I login to LM application with valid credentials
    Then I Verify if the License Management logo is there in the license manager
    Then I verify the user name and LM app version
    And I close the browser


