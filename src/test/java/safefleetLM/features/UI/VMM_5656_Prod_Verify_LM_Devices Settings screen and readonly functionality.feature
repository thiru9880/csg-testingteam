#Author: Savitha

Feature: Verify License Manager Devices Settings screen and readonly functionality


  @prod @prod1 @VMM-5656
  Scenario Outline: VMM-5656_Verify_LM_Devices Settings screen and readonly functionality
		Given I login to LM application with valid credentials
    When I navigate to Device Settings tab
    Then I verify that the Devices Settings screen loads successfully with all the details
    Then I click on NEW and verify new Device Settings creation screen
    Then I search Device Type, view and verify Device Type details as per filter "<TCID>"
    And I close the browser


     Examples:
     |TCID     |
     |VMM_5656_1|
