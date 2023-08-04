#Author: Savitha

Feature: Verify License Manager Devices screen and readonly functionality


  @prod @prod1 @VMM-5655
  Scenario Outline: VMM-5655_Verify_LM_Devices screen and readonly functionality
    Given I login to LM application with valid credentials
    Then I navigate to the Operation Tab
    Then I navigate to Device tab
    Then I verify that the Devices screen loads successfully with all the details
    Then I click on NEW Device button
    Then I select Device Type as DH6 and verify that the Device ID, Mac Address & Serial Number fields are mandatory "<TCID>"
    Then I select Device Type as DigiRouter and verify that the Device ID & Mac Address fields are mandatory "<TCID2>"
    Then I select Device Type as H1 and verify that the Device ID field is mandatory "<TCID3>"
    Then I search Devices with Device Status as Assigned & Device Type having Settings enabled "<TCID>"
    Then I verify Settings Icon is enabled
    Then I search Devices with Device Status as Not Assigned & Device Type having Settings enabled "<TCID2>"
    Then I verify Settings Icon is disabled
    Then I search Devices with Device Status as Assigned & Device Type having Settings disabled "<TCID3>"
    Then I verify Settings Icon is disabled
    #Then I view Device and verify Device details as per filter "<TCID3>"
    And I close the browser


     Examples:
     |TCID     |TCID2     |TCID3     |
     |VMM_5655_1|VMM_5655_2 |VMM_5655_3 |
