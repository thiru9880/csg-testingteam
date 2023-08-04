####################################################################
#Authour:Sunilkumar
#Test CaseID: VMM_3408
####################################################################
Feature: Tenant ID value in View and Edit Software Settings is not showing up correctly in the page

 @VMM-3408 @reg @Operations
  Scenario Outline: VMM_3408 Ecosystem setting
   Given I login to LM application with valid credentials 
    When I click on operations to navigate Tenants tab 
    Then I create new Tenant for VMM3408 with test data "<TCID>" 
    When I navigate to ecosystem settings tab
    Then I create Ecosystem setting with Test data "<TCID>"
    Then I view Ecosetting with test data "<TCID>"
    Then I Verify the tenantid field and label with testdata "<TCID>" 
    Then I Click Back button
    Then I Click the edit button with test data "<TCID>" 
    Then I Verify the tenantid field and label with testdata "<TCID>"
    When I navigate to ecosystem settings tab
    Then I delete the Ecosystem Setting and verify with testdata "<TCID>" 
    When I click on operations to navigate Tenants tab 
    Then I delete the Tenant "<TCID>"
    And I close the browser 

    Examples: 
      | TCID    | 
      |VMM3408_1|
      