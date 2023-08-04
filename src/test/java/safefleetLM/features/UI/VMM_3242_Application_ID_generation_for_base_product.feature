##############################################
#Author : Nitin Kumar
#Test Case ID: VMM_3242
##############################################

Feature: Application ID generation for base product

  @VMM-3242 @reg @System_Admin
  Scenario Outline: VMM-3242 Application ID generation for base product
    Given I login to LM application with valid credentials
    Then I navigate to the System Admins Tab
    And I verify Base Product in view has application id
    And I verify converting Base Product name to uppercase
    And I verify spaces in Base Product name with -
    And I verify Base Product name is upto 50 characters only
    #Then I navigate to the System Admins Tab
    #Then I navigate to Base Product Tab
		#Then I delete the Base App "<TCID>"
    And I close the browser

    Examples:
      | TCID      |
      | VMM3242_1 |


