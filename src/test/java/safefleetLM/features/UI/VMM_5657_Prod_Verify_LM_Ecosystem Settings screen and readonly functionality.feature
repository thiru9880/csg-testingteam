#Author: Savitha

Feature: Verify License Manager Ecosystem Settings screen and readonly functionality


  @prod @prod2 @VMM-5657
  Scenario Outline: VMM-5657_Verify_LM_Ecosystem Settings screen and readonly functionality
		Given I login to LM application with valid credentials
		Then I navigate to the Operation Tab
		Then I navigate to ecosystem settings tab
    Then I verify that the Ecosystem Settings screen loads successfully with all the details
    Then I click on NEW and verify new Ecosystem Settings creation screen
    Then I search PTLW, view and verify PTLW details as per filter "<TCID>"
    And I close the browser


     Examples:
     |TCID     |
     |VMM_5657_1|
