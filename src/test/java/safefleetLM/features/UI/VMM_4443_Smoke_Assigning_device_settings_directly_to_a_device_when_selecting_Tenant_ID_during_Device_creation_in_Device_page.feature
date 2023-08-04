############################################################
#Authour:Sunilkumar
#Test CaseID: VMM_4443 VMM_4446
#############################################################
Feature: VMM_4443,VMM_4446 Assigning device settings directly to a device when selecting Tenant ID during Device creation in Device page

     @VMM-4443 @VMM-4446 @reg @Devices @smoke @smoke2
     Scenario Outline: VMM_4443,VMM_4446 Assigning device settings directly to a device when selecting Tenant ID during Device creation in Device page
     Given I login to LM application with valid credentials
    # When I click on operations to navigate Tenants tab
    # Then I create new Tenant for VMM4443 with test data "<TCID>"
       When I navigate to the Operation Tab
     When I navigate to devices tab
     Then I Click on New button and i fill required field with testdata "<TCID>"
     Then I Verify that dialog should appear to assign Device Settings
     And I Select the Setting with testdata "<TCID>" and save
     Then I Verify that user will be able to save the new Device with the device settings and verify the settings Icon "<TCID>"
     And I Vertify that new device status with device settings data in Device table in DBS with testdata "<TCID>" after Assigning the Device Settings
     Then I Edit the Device and Verify that all the selected values are displayed
     Then I Verify that Unassign button is enabled & displayed and Tenant ID dropdown values are grayed out
     Then I Click on Unassign and user should be able to unassign the device
     Then I Select the Device status with testdata "<TCID>" and save
     Then I Verify that user will be able to unassign the device by selecting the device status and verify the settings Icon "<TCID>"
     And I Vertify that new device status with device settings data in Device table in DBS with testdata "<TCID>" after UnAssigning the Device Settings
     Then I delete the device
    # When I click on operations to navigate Tenants tab
     #Then I delete the Tenant "<TCID>"
     And I close the browser

     Examples:
      | TCID     |
      |VMM_4443_1|




