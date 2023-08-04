###################################################
#Authour:Sunilkumar
#Test CaseID: VMM_3375,VMM_3374
###################################################
Feature: Ecosystem Settings

  @VMM-3375 @_3374 @reg @Operations
  Scenario Outline: VMM_3375,VMM_3374 Ecosystem Settings
    Given I login to LM application with valid credentials
    When I click on operations to navigate Tenants tab
    Then I create new tenant for VMM3375 with test data "<TCID>" 
    When I navigate to ecosystem settings tab 
    Then I create a Ecosystem setting with Test data "<TCID>"  
    Then I view metadata and verify
    Then I edit metadata with "<TCID>"and SAVE
    When I delete the Ecosystem Setting and verify with testdata "<TCID>"
    Then I click on operations to navigate Tenants tab
    Then I delete the Tenant "<TCID>"
    And I close the browser 

    Examples: 
      | TCID     |
      |VMM_3375_1|
