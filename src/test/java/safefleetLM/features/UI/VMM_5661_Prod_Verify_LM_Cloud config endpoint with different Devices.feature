#Author: Savitha

Feature: Verify License Manager Cloud config endpoint


  @prod @prod3 @VMM-5661 @VMM-5620 @Devices
  Scenario Outline: VMM-5661_Verify_LM_Cloud config endpoint is accessible and its response for different Device ID
		Given I login to LM application with valid credentials
		Then I navigate to the Operation Tab
		Then I navigate to Device tab
    Then I search and save a valid Device Id having settings enabled "<TCID>"
    Then I search and save a valid Device Id having settings disabled "<TCID2>"
    Then I search and save a valid Device Id not assigned to a Tenant "<TCID3>"
    Then I hit cloud config endpoint and verify response for production valid Device Id having settings enabled "<TCID>"
    Then I hit cloud config endpoint and verify response for production valid Device Id having settings disabled "<TCID2>"
    Then I hit cloud config endpoint and verify response for production valid Device Id not assigned to a Tenant "<TCID3>"
    Then I hit cloud config endpoint and verify response for production invalid Device Id "<TCID4>"
    And I close the browser


     Examples:
     |TCID      |TCID2     |TCID3     |TCID4     |
     |VMM_5661_1|VMM_5661_2|VMM_5661_3|VMM_5661_4|
