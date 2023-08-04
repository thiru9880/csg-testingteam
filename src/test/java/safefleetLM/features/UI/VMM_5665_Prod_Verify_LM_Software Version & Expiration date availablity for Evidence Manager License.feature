#Author: Savitha

Feature: Verify_LM_Software Version & Expiration date availablity for Evidence Manager License


  @prod @prod2 @VMM-5665
  Scenario Outline: VMM-5665_Prod_Verify_LM_Software Version & Expiration date availablity for Evidence Manager License

    Given I login to LM application with valid credentials
    Then I store the Base App list to compare and verify later
		Then I navigate to the Operation Tab
    Then I navigate to Licences Tab
    Then I select filter as Base App and verify that all the Base Apps are getting listed for Base App dropdown "<TCID>"
    Then I search License with multiple filter condition "<TCID>"
    Then I expand license and click on Action button
    Then I view the filtered license and verify license details is as per the filter "<TCID>"
    And I close the browser


     Examples:
     |TCID       |
     |VMM_5665_1 |
