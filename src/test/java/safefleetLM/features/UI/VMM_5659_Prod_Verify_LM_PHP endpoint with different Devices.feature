#Author: Savitha

Feature: Verify License Manager Device PHP endpoint


  @prod @prod2 @VMM-5659
  Scenario Outline: VMM-5659_Verify_LM_Device PHP endpoint is accessible and its response for different Device ID
		Given I login to LM application with valid credentials
		Then I navigate to the Operation Tab
		Then I navigate to Device tab
    Then I search and save a valid Device Id having settings enabled "<TCID>"
    Then I search and save a valid Device Id having settings disabled "<TCID2>"
    Then I hit PHP endpoint and verify response for production valid Device Id having settings enabled "<TCID>"
    Then I hit PHP endpoint and verify response for production valid Device Id having settings disabled "<TCID2>"
    Then I hit PHP endpoint and verify response for production invalid & Staging valid Device Id having settings enabled "<TCID3>"
    Then I hit PHP endpoint and verify response for production invalid & Staging invalid Device Id "<TCID4>"
    And I close the browser


     Examples:
     |TCID      |TCID2     |TCID3     |TCID4     |
     |VMM_5659_1|VMM_5659_2|VMM_5659_3|VMM_5659_4|
