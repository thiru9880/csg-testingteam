###################################################
#Authour:Sunilkumar
#Test CaseID: VMM_4464,VMM_4466 
###################################################
Feature: VMM_4464,VMM_4466 Verify that the device setting pop up is displayed when assign a device setting mandatory device, to the Tenant while Tenant creation

  @VMM-4464 @VMM-4466 @reg @Tenants
  Scenario Outline: VMM_4464,VMM_4466 Verify that the device setting pop up is displayed when assign a device setting mandatory device, to the Tenant while Tenant creation
    Given I login to LM application with valid credentials
     When I navigate to the Operation Tab
     And I navigate to devices tab
     Then I Create device with device type with test data "<TCID>" 
     Then I Click New button Add required data to create a tenant with testdata "<TCID>" 
     Then In Available Devices section select the device type which has device setting mandatory with testdata "<TCID>"
     Then I Select any available device and click on Assign button with testdata "<TCID>"
     When I Verify that dialog should appear to assign Device Settings
     Then I Select Device setting and assign the device with testdata "<TCID>" and Verify in Assigned Devices section
     When I verify that the tenant is listed in tenants dashboard page along with number of devices assigned details with testdata "<TCID>"
     Then I navigate to devices tab
     When I Search for the Device Id I created with testdata "<TCID>" and Verify the Device status and Data status of the device after Assign
     Then I navigate to Tenant tab
     Then I Search an existing tenant and click on edit Icon with testdata "<TCID>"
     Then In Assigned Devices section select the device and click on UNASSIGN button and Verify that the device unassign pop up window is displayed
     Then I Select Not Assigned option from dropdown and click on Un-Assign button with testdata "<TCID>"
     When I verify that the tenant is listed in tenants dashboard page and no devices assigned to it with testdata "<TCID>"
     Then I navigate to devices tab
     Then I Search for the Device Id I created with testdata "<TCID>" and Verify the Device status and Data status of the device after Unassign
     Then I delete the Device with testdata "<TCID>"
     When I navigate to Tenant tab
     Then I delete the Tenant "<TCID>" 
     And I close the browser 

    Examples: 
      | TCID     |
      |VMM_4464_1|
      