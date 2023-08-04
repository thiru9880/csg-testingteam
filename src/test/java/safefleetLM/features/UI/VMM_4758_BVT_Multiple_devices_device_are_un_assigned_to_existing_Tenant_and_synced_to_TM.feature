#####################################
#Author : Rajath G M
#Test Case ID: VMM_4758
#####################################
Feature: Manage multiple devices to tenant and sync to TM

  @VMM-4758  @reg @smoke @smoke2 @int @tm @Integration2
  Scenario Outline: VMM_4758 Multiple devices are un-assigned to tenant and synced to TM
    Given I login to LM application with valid credentials
    Then I click on operations to navigate Tenants tab
    Then I create a New tenant with test data "<TCID>"
    Then I Search for a tenant and verify the details "<TCID>"
    Then I navigate to devices tab
    Then I create device with a device type and test data "<TCID>"

    Then I navigate to Tenants Tab
    Then By using showfilter i get tenant ID "<TCID>"
    Then I select device type created by devices and I will assign the devices "<TCID>"
    Then I Assign the devices to the tenant i created "<TCID>"
    Then I verify that setting icon for Assign devices is Enabled
    Then I click on Save button on the Tenant page
    Then I verify that the assigned devices are showed in swagger UI are not "<TCID>"
    Then By using showfilter i get tenant ID "<TCID>"
    Then I Unassign the devices and click On save "<TCID>"
    Then I Select the Device status while Unassigning the Device from Tenant with testdata "<TCID>" and save
    Then I verify that the unassigend devices are showed in swagger UI are not "<TCID>"

		Then I navigate to devices tab
    Then I Create Device with a device type and test data "<TCID2>"
    Then I navigate to Tenants Tab
    Then By using showfilter i get tenant ID "<TCID>"
    Then I select device type created by devices and I will assign the devices "<TCID2>"
    Then I verify that setting icon for Assign devices is Disabled
    Then I click on Save button on the Tenant page
    Then I verify that assigned devices are showed in swagger UI are not "<TCID2>"
    Then By using showfilter i get tenant ID "<TCID>"
    Then I Unassign the devices and click On save "<TCID2>"
    Then I Select the Device status while Unassigning the Device from Tenant with testdata "<TCID2>" and save
    Then I verify that unssigned devices are showed in swagger UI are not "<TCID2>"
    Then I navigate to devices tab
    Then I Delete the device "<TCID>"
    Then I Delete the device "<TCID2>"
    Then I navigate to the Operation Tab
    Then I navigate to Tenants Tab
    Then I delete the Tenant "<TCID>"
    And I close the browser

    Examples:
      |TCID      |   |TCID2     |
      |VMM_4758_1|   |VMM_4758_2|
