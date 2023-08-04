###################################################
#Author: Surya
#Test Case Id: VMM_3265
####################################################
 Feature: Enable SSO for TM application and for LM to TM integration
 
@VMM-3265  @reg @Licenses
   Scenario Outline: VMM_3265 Enable SSO for TM application and for LM to TM integration for  CLOUD__COMMERCIAL deployment type
   Given I login to LM application with valid credentials
   When I navigate to the Operations tab
   When I navigate to Tenant tab
   Then I Create tenants for CLOUD__COMMERCIAL deployment types "<TCID>"
   When I Navigate to Licenses
   Then I Create License for CLOUD__COMMERCIAL deployment type tenant "<TCID>" 
   And I Click on Generate Keys actions menu item after CLOUD__COMMERCIAL deployment type tenant "<TCID>"
   Then I Click on LogOut For CLOUD__COMMERCIAL deployment type tenant 
   And I close the browser 
     
     Examples:
        | TCID   |
        |VMM3265_1|
   
@VMM-3265  @reg
Scenario Outline: VMM_3265 Enable SSO for TM application and for LM to TM integration for CLOUD__GOVERNMENT deployment types
   Given I login to LM application with valid credentials
   When I navigate to the Operations tab
   When I navigate to Tenant tab
   Then I Create tenants for CLOUD__GOVERNMENT deployment types "<TCID2>"
   When I Navigate to Licenses
   Then I Create License for CLOUD__GOVERNMENT deployment type tenant "<TCID2>"
   And I Click on Generate Keys actions menu item after CLOUD__GOVERNMENT deployment type tenant "<TCID2>"
   Then I Click on LogOut For CLOUD__GOVERNMENT deployment type tenant
   And I close the browser  
    Examples: 
      | TCID2  | 
      |VMM3265_2|
      

   
  
 
