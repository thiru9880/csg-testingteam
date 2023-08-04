####################################################
#Author: Surya
#Test Case Id: VMM_4643,VMM_4645, VMM_4650
####################################################
Feature: Bulk upload a device having device setting mandatory, with device setting data of other device type and no tenant Id

  @VMM-4643 @VMM-4645 @VMM-5173 @VMM-4650 @reg @Devices @smoke @smoke2
  Scenario Outline: VMM_4643 VMM_4645 VMM_4650 Bulk upload a device having device setting mandatory, with device setting data of other device type and no tenant Id
    Given I login to LM application with valid credentials
    When I navigate to the Operation Tab
    #When I navigate to Tenant tab
    #Then I Create a Tenant For Devices "<TCID1>"
    When I navigate to devices tab
    When I Click On Bulk Upload  I Upload All The Devices In SpreadSheet
    Then I Verify All the device is created successfully
    And I Verify warning message for device setting data of other device type and no tenant Id data
    Then I Verify  whether the uploaded device is available in the devices list, with device setting data and assigned Tenant Id "<TCID1>"
    And I Verify  whether the uploaded device is available in the devices list, with no device setting data and assigned Tenant Id "<TCID2>"
    And I Verify  whether the uploaded device is available in the devices list, with device setting data of other device type and no tenant Id "<TCID3>"
  Then I navigate to lm dashboard Tab
    Then I verify that Bulk Upload Sync Jobs - SyncTM section is displayed post Bulk device upload
    Then I click on Operations to navigate Devices Tab
    Then I Delete The Device Of With Device Setting "<TCID1>"
    Then I Delete The Device Of No Device Setting "<TCID2>"
    And I close the browser

    Examples:
      | TCID1     | TCID2     | TCID3     |
      | VMM4643_1 | VMM4643_2 | VMM4643_3 |
