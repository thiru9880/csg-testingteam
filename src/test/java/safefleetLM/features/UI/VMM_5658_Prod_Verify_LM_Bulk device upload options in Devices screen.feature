#Author: Savitha

Feature: Verify License Manager Bulk Upload readonly functionality


  @prod @prod2 @VMM-5658
  Scenario Outline: VMM-5658_Verify_LM_Bulk device upload options in Devices screen
    Given I login to LM application with valid credentials
    Then I navigate to the Operation Tab
    Then I navigate to Device tab
    Then I verify that Download Spreadsheet & Upload Spreadsheet options are displayed under Bulk Upload
    Then I click on Download Spreadsheet option and verify that Bulk Device Upload template is getting downloaded
    And I close the browser


    Examples:
      |  |  |  |  |
      |  |  |  |  |
