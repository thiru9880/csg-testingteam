###################################################
#Authour:Sunilkumar
#Test CaseID: VMM_3284
###################################################
Feature: Server should be removed from Tenants and moved into Licenses


  @VMM-3284 @reg @Licenses
  Scenario Outline:  VMM_3284 Server should be removed from Tenants and moved into Licenses
    Given I login to LM application with valid credentials 
     Then I navigate to Base Product Tab
     Then I click Edit Base Product with "<TCID>"
     When I click on operations to navigate Tenants tab 
     And I create new Tenant for VMM3284 with test data "<TCID>"  
     Then I Navigate to Licenses
     Then I create new Licenses with testdata "<TCID>"    
     Then I Navigate to Tenants tab
     Then I delete the Tenant "<TCID>"  
     And I close the browser 
  
    
    

    Examples: 
      | TCID    | 
      |VMM3284_1|
    
