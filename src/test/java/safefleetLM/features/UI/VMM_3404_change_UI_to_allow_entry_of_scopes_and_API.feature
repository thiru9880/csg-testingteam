##############################################
#Author : Nitin Kumar
#Test Case ID: VMM_3404
##############################################
Feature: Change UI to allow entry of scopes and API

  @VMM-3404 @reg @System_Admin
  Scenario Outline: VMM-3404 change UI to allow entry of scopes and API
    Given I login to LM application with valid credentials
    Then I use existing License Type "<TCID>" for slot type validation
    Then I use existing License Type "<TCID>" for slot type scope validation
    Then I use existing License Type "<TCID>" for scope validation
    Then I unassign resources for License Type for validation "<TCID>"
    And I close the browser

    Examples: 
      | TCID      |
      | VMM3404_1 |
