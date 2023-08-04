###################################
#Author : Rajath G M
#Test Case ID: VMM_4578 ,VMM_4770
###################################
Feature: Manage Settings icon in Device page

  @VMM-4578 @VMM-4770  @reg @int  @tm @Integration2
  Scenario Outline: VMM_4578, VMM_4770 Manage Settings icon in Device page when assigning Tenant in Device page &Verify that device is assigned data to a tenant, is synced back to TM
    Given I login to LM application with valid credentials
    Then I click on operations to navigate Tenants tab
    Then I creat New tenant with test data "<TCID>"
    Then I navigate to devices tab
    Then I Create a device with device type and test data "<TCID>"
    Then I using show filter to get device details and i verify the setting icon "<TCID>"
    Then I verify that Settings for the device created by using tenant ID "<TCID>"
    Then I verify assigned devices are showed in swagger UI are not "<TCID>"
    Then I Verify that the device is listed in Devices dashboard page along with Tenant Id details "<TCID>"
    Then I Click on Unassign and user should be able to unassign the devices "<TCID>"
    Then I Select the Device status with testdata "<TCID>" and save
    Then I verify unassigned devices are showed in swagger UI are not "<TCID>"
    Then I navigate to Tenants Tab
    Then I delete the Tenant "<TCID>"
    Then I navigate to the Operation Tab
    Then I navigate to devices tab
    Then I Delete the device "<TCID>"
    And I close the browser

    Examples:
    |TCID      |
    |VMM_4578_1|
