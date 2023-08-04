#Author: Savitha

Feature: Verify License Manager Licenses screen filter functionality and Assign Devices option enabled for AVL GPS Tracking Asset License


  @prod @prod3 @VMM-5663
  Scenario Outline: VMM-5663_Prod_Verify_LM_Licenses screen filter functionality and Assign Devices option enabled for AVL GPS Tracking Asset License
    Given I login to LM application with valid credentials
		Then I navigate to the Operation Tab
    Then I navigate to Licences Tab
    Then I verify that the Licenses screen loads successfully with all the details
    Then I search License with multiple filter condition "<TCID>"
    Then I verify that Assign Devices option is enabled for AVL GPS Tracking License
    Then I view the filtered license and verify license details is as per the filter "<TCID>"
    And I close the browser


     Examples:
     |TCID       |
     |VMM_5663_1 |
