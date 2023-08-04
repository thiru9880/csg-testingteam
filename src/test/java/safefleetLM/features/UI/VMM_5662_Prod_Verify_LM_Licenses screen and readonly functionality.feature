#Author: Savitha

Feature: Verify License Manager Licenses screen and readonly functionality


  @prod @prod3 @VMM-5662
  Scenario Outline: VMM-5662_Verify_LM_Licenses screen and readonly functionality
    Given I login to LM application with valid credentials
		Then I navigate to the Operation Tab
    Then I navigate to Licences Tab
    Then I click on NEW license button
    Then I select Tenant ID and Base App as Embedded Entity and verify that License type dropdown displays the corresponding licenses "<TCID>"
    Then I select License Type as DH8 and verify the corresponding mandatory fields "<TCID>"
    Then I change the Base App as Evidence Management and verify that License type dropdown displays the corresponding licenses "<TCID2>"
    Then I select License Type as Base App and Verify that Server field is not mandatory "<TCID2>"
    Then I change the Base App as Cloud Starter and verify that License type dropdown displays the corresponding licenses "<TCID3>"
    Then I select License Type as Asset for Cloud Starter and Verify that Qty ,Part & Charge type fields are mandatory "<TCID3>"
    Then I change the Base App as AVL GPS Tracking and and verify that License type dropdown displays the corresponding licenses "<TCID4>"
    Then I select Add-on Module - Device Health and Verify that only part, Inaugural date & Charge type fileds are mandatory "<TCID4>"
    And I close the browser


     Examples:
     |TCID       |TCID2      |TCID3      |TCID4      |
     |VMM_5662_1 |VMM_5662_2 |VMM_5662_3 |VMM_5662_4 |
