#####################################
#Author : Rajath G M
#Test Case ID: VMM_3592
#####################################
Feature: Manage Remove predefined filters on all pages

  @VMM-3592   @reg @Operations
  Scenario Outline: VMM_3592 Remove predefined filters on all pages
    Given I login to LM application with valid credentials
    Then I click on operations to navigate Tenants tab
    Then I create a new tenant for with test datas "<TCID>"
    Then I Verify that there is no pre-defined filter on the Tenants page "<TCID>"
    Then I click on new to create license "<TCID>"
    Then I Verify that there is no pre-defined filter on the Licenses page "<TCID>"
    Then I navigate to devices tab
    Then I create device with device type and test data "<TCID>"
    Then I Verify that there is no pre-defined filter on the Devices page "<TCID>"
    Then I navigate to the Operation Tab
    Then I navigate to the device settings tab
    Then I click on new and I create Device setting "<TCID>"
    Then I Verify that there is no pre-defined filter on the Device Settings page "<TCID>"
    Then I navigate to the Operation Tab
    Then I Navigate to Ecosystem Settings
    And I create Ecosystem setting for created tenant "<TCID>"
    Then I Verify that there is no pre-defined filter on the Ecosystem setting page "<TCID>"
    Then I navigate to Licences Tab
    Then I delete the licenses "<TCID>" 
    Then I navigate to the Operation Tab 
    Then I navigate to devices tab
    Then I Delete the device "<TCID>"
    Then I navigate to the device settings tab
    Then I Delete a device settings "<TCID>" 
    Then I navigate to the Operation Tab 
    Then I Navigate to Ecosystem Settings  
    Then I delete the ecosystem settings "<TCID>"  
    Then I navigate to the Operation Tab
    Then I navigate to Tenants Tab
    Then I delete the Tenant "<TCID>"
    And I close the browser  
  
    Examples: 
      |TCID      |  
      |VMM_3592_1| 
