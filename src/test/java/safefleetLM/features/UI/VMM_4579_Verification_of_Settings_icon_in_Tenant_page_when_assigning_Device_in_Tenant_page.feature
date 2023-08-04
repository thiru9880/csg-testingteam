#####################################
#Author : Rajath G M
#Test Case ID: VMM_4579
#####################################
Feature: Manage Settings icon in Tenant page

  @VMM-4579    @reg @Tenants
  Scenario Outline: VMM_4579 Manage Settings icon in Tenant page when assigning Device in Tenant page
    Given I login to LM application with valid credentials
    Then I click on operations to navigate Tenants tab
    Then I create a new tenant for with test data "<TCID>"
    Then I navigate to devices tab
    Then I Create device with device type and test data "<TCID>"
    Then I navigate to Tenants Tab
    Then By using showfilter i get tenant ID "<TCID>"
    Then I select device type created by devices and I will assign the devices "<TCID>"
    Then I Assign the devices to the tenant i created "<TCID>"
    Then I verify that setting icon for Assign devices is Enabled
    Then I Unassign the devices and click On save "<TCID>"
    Then I Select the Device status while Unassigning the Device from Tenant with testdata "<TCID>" and save
    Then I create a new tenant with test data "<TCID2>"
    Then I navigate to devices tab
    Then I Create Device with a device type and test data "<TCID2>"
    Then I navigate to Tenants Tab
    Then By using showfilter i get tenant ID "<TCID2>"
    Then I select device type created by devices and I will assign the devices "<TCID2>"
    Then I verify that setting icon for Assign devices is Disabled
    Then I Unassign the devices and click On save "<TCID2>"
    Then I Select the Device status while Unassigning the Device from Tenant with testdata "<TCID2>" and save
    Then I delete the Tenant "<TCID>"
    Then I delete the Tenant "<TCID2>"
    Then I navigate to the Operation Tab
    Then I navigate to devices tab
    Then I Delete the device "<TCID>"
    Then I Delete the device "<TCID2>"
    And I close the browser

    Examples:
      | TCID       |  | TCID2      |
      | VMM_4579_1 |  | VMM_4579_2 |
