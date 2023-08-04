###################################################
#Authour:Sunilkumar
#Test CaseID: VMM_3582
###################################################
Feature: Removing all the tenants on user

  @VMM-3582 @reg @Tenants 
  Scenario Outline: VMM_3582 Removing all the tenants on user
    Given I login to LM application with valid credentials
    When I click on operations to navigate Tenants tab
    Then I create new tenant for VMM3582 with test data "<TCID2>"    
    When I navigate to User tab
    Then I create a new user with test data "<TCID>" 
    Then I Edit any user with customer role with Test data "<TCID>" 
    Then I Select the tenants from the drop list with Test data "<TCID>" and save 
    Then I Edit the same user and remove all the tenants with Test data "<TCID>" 
    When I Verify that there is no error message on user Save
    Then I delete user in test data "<TCID>"
    When I click on operations to navigate Tenants tab
    Then I delete the Tenant "<TCID>"
    And I close the browser  

    Examples: 
      |TCID     |TCID2    |
      |VMM3582_1|VMM3582_1|
