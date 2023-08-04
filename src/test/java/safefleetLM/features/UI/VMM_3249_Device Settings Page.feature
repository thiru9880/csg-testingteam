####################################################
#Author: Surya
#Test Case Id: VMM_3249 VMM_3255
####################################################
 Feature: Device Settings Page

@VMM-3249 @VMM-3255 @VMM-5540 @reg @Operations
   Scenario Outline: VMM_3249,VMM_3255 Device Settings Page
   Given I login to LM application with valid credentials
   When I navigate to the Operation Tab
  # When I navigate to Tenant tab
  # Then I create new Tenant with test Data "<TCID>"
   Then Pre-condition: I create a Device "<TCID>"
   When I navigate to Licences Tab
   Then Pre-condition: I create a License and assign devices "<TCID>"
   When I navigate to the Operation Tab
   When I navigate to devices tab
   Then I Verify it navigates to the settings page it is rendered correctly "<TCID>"
   And  I Verify if all the buttons in View Device Settings page are working "<TCID>"
   When I navigate to Licences Tab
   Then I Unassign the Device In License "<TCID>"
   When I navigate to the Operation Tab
   When I navigate to Licences Tab
   Then I delete the license "<TCID>"
   When I navigate to the Operation Tab
   When I navigate to devices tab
   Then I delete the Device "<TCID>"
   #Then I click on operations to navigate Tenants tab
   #Then I delete the Tenant "<TCID>"
   And  I close the browser

     Examples:
      | TCID   |
      |VMM3249_1|
