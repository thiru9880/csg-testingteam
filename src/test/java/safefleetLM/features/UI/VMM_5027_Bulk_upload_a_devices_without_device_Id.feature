####################################################
#Author: Savitha
#Test Case Id: VMM_5027
####################################################
Feature: Bulk upload of devices without Device Id

  @VMM-5027 @reg @Devices
  Scenario Outline: VMM_5027 Bulk upload of devices without Device Id
    Given I login to LM application with valid credentials
    When I navigate to the Operation Tab
    When I navigate to devices tab
    When I upload devices from spreadsheet via Bulk Upload operation "<TCID1>"
    Then I verify error message for devices uploaded without device Id "<TCID1>"
    When I navigate to the Operation Tab
    When I navigate to devices tab
    Then I verify the uploaded device is not available in the devices list "<TCID1>"
    And I verify the uploaded device is not available in the devices list "<TCID2>"
    And I close the browser

    Examples: 
      | TCID1     | TCID2     |
      | VMM5027_1 | VMM5027_2 |
