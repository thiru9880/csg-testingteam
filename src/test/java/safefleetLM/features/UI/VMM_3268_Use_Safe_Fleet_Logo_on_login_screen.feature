###################################################
#Authour:Sunilkumar
#Test CaseID: VMM_3268,VMM_3609
###################################################
Feature: Use Safe Fleet Logo on login screen


  @VMM-3268 @VMM-3609 @reg @System_Admin
  Scenario: VMM_3268,VMM_3609 Use Safe Fleet Logo on login screen
    Given I login to LM application with valid credentials
    Then I Verify if the License Management logo is there in the license manager
    Then I Click on the logout
    When I verify that it takes  back to the login page
    And I close the browser


