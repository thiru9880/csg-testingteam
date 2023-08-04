#Author: Savitha

Feature: Verify License Manager Device config endpoint


  @prod @prod2 @VMM-5660
  Scenario Outline: VMM-5660_Verify_LM_Device config endpoint is accessible and its response for different Device ID
		Given I login to LM application with valid credentials
		Then I navigate to the Operation Tab
		Then I navigate to Device tab
    Then I search and save a valid Device Id having settings enabled "<TCID>"
    Then I search and save a valid Device Id having settings disabled "<TCID2>"
    Then I search and save a valid Device Id not assigned to a Tenant "<TCID3>"
    Then I hit device config endpoint and verify response for production valid Device Id having settings enabled "<TCID>"
    Then I hit device config endpoint and verify response for production valid Device Id having settings disabled "<TCID2>"
    Then I hit device config endpoint and verify response for production valid Device Id not assigned to a Tenant "<TCID3>"
    Then I hit device config endpoint and verify response for production invalid Device Id "<TCID4>"
    And I close the browser


     Examples:
     |TCID      |TCID2     |TCID3     |TCID4     |
     |VMM_5660_1|VMM_5660_2|VMM_5660_3|VMM_5660_4|
