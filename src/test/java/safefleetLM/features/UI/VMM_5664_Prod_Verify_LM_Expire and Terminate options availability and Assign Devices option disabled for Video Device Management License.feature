#Author: Savitha

Feature: Verify_LM_Expire and Terminate options availability and Assign Devices option disabled for Video Device Management License


  @prod @prod3 @VMM-5664
  Scenario Outline: VMM-5664_Prod_Verify_LM_Expire and Terminate options availability and Assign Devices option disabled for Video Device Management License
    Given I login to LM application with valid credentials
		Then I navigate to the Operation Tab
    Then I navigate to Licences Tab
    Then I search License with multiple filter condition "<TCID>"
    Then I verify that Assign Devices option is disabled for Video Device Management License
    Then I verify that the Expire and Terminate options are available for the License
    Then I view the filtered license and verify license details is as per the filter "<TCID>"
    And I close the browser


     Examples:
     |TCID       |
     |VMM_5664_1 |
