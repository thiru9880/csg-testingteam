####################################################
#Author: Surya
#Test Case Id: VMM_3878
####################################################
 Feature: Order all drop-down list options from A to Z 
 
@VMM-3878  @reg @Operations
   Scenario Outline: VMM_3878 Order all drop-down list options from A to Z 
   Given I login to LM application with valid credentials
   When I navigate to the Operation Tab
   When I navigate to Tenant tab
   Then I Verify if all the drop down values in the application are ordered In Tenants Page
   When I Navigate to Licenses 
   Then I Verify if all the drop down values in the application are ordered In License Page "<TCID>"
   When I navigate to devices tab 
   Then I Verify if all the drop down values in the application are ordered In Devices Page "<TCID>"
   And I close the browser           
   
     Examples: 
      | TCID   | 
      |VMM3878_1| 
