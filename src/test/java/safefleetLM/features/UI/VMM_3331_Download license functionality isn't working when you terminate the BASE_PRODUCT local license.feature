####################################################
#Author: Surya
#Test Case Id: VMM_3331
####################################################
Feature: Download license functionality isnt working when you terminate the BASE_PRODUCT local license

  @VMM-3331 @reg @Licenses
  Scenario Outline: VMM_3331 Download license functionality isnt working when you terminate the BASE_PRODUCT local license
    Given I login to LM application with valid credentials
    When I navigate to the Operation Tab
    When I navigate to Tenant tab
    Then I create new Tenant with Onsite Type "<TCID>"
    And I Create a BaseProduct Onsite License "<TCID>"
    Then I Publish The License "<TCID>"
    And I Teriminate The License and Select Download License CheckBox
    Then I Verify if The License File Is Downloaded "<TCID>"
    Then I return the license and delete the licenses "<TCID>"
    Then I click on operations to navigate Tenants tab
    Then I delete the Tenant "<TCID>"
    And I close the browser

    Examples:
      | TCID      |
      | VMM3331_1 |
