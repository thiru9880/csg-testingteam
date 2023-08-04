##############################################################
# Author: Savitha
# Test Case ID: VMM_4755
##############################################################
Feature: Sync all the devices created via bulk operation except for SF Live+ devices

  @VMM-4755 @reg @Interation2 @smoke @smoke1
  Scenario Outline: VMM_4755_Sync all the devices created via bulk operation except for SF Live+ devices
    Given I login to LM application with valid credentials
    Then I click on operations to navigate Tenants tab
    Then I create a cloud-commercial tenant "<TCID>"
    Then I navigate to the Operation Tab
    When I navigate to devices tab
    When I upload devices from spreadsheet via Bulk upload operation "<TCID>"
    Then I verify all the devices are created successfully
    When I navigate to Licences Tab
    Then I create Base App licence for the tenant created "<TCID>"
    Then I create Asset licence for the tenant created "<TCID2>"
   Then I create Base App licence for the tenant created "<TCID3>"
    Then I create Asset licence for the tenant created "<TCID4>"
    Then I verify that Assign Device option is enabled for AVL GPS Tracking Asset license "<TCID2>"
    Then I verify that Assign Device option is not enabled for Lane Enforcement Asset license "<TCID4>"
    When I navigate to licenses page
    Then I assign a device without device settings to license "<TCID>"
    Then I assign a device with device settings to license "<TCID2>"
    Then I click on operations to Navigate Ecosystem Settings
    Then I verify software setting is created with Tenant id if not Create software setting "<TCID>"
    	Then I navigate to the Operation Tab
      Then I navigate to Licences Tab
    Then I publish the first licenses "<TCID>"
    Then I publish the filtered licenses "<TCID2>"
    Then I publish the first licenses "<TCID3>"
    Then I publish the filtered licenses "<TCID4>"
    Then I verify in TM Swagger, that the devices created via bulk operation except for AVL GPS Tracking devices will be synced to TM "<TCID>"
    Then I navigate to the Operation Tab
      Then I navigate to Licences Tab
    	Then I Unassign the Device from Asset License in License "<TCID2>"
    	Then I navigate to the Operation Tab
      When I navigate to devices tab
      Then I Unassign the device "<TCID3>"
      And I Unassign the device "<TCID4>"
      Then I navigate to the Operation Tab
    	When I navigate to Licences Tab
     Then I delete the published license "<TCID>"
    Then I delete the published license "<TCID2>"
    Then I delete the published license "<TCID3>"
    Then I delete the published license "<TCID4>"
    Then I click on operations to Navigate Ecosystem Settings
    Then I delete the ecosystem settings "<TCID>"
    Then I click on operations to navigate Tenants tab
    Then I delete the Tenant "<TCID>"
    Then I navigate to the Operation Tab
    When I navigate to devices tab
    Then I delete the Device "<TCID>"
    Then I delete the Device "<TCID2>"
    Then I delete the Device "<TCID3>"
    Then I delete the Device "<TCID4>"
    And I close the browser

    Examples:
      | TCID       | TCID2      | TCID3      | TCID4      |
      | VMM4755_1 | VMM4755_2 | VMM4755_3 | VMM4755_4 |
