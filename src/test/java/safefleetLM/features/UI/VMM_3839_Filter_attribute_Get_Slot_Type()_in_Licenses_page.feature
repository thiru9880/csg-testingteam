###########################################
#Author : Rajath
#TEST Case ID: VMM_3839,VMM_3623
############################################
Feature: Manage Filter attribute

  @VMM-3839  @VMM-3623  @reg @Licenses
  Scenario: VMM_3839 Filter attribute "Get Slot Type()" in Licenses page
    Given I login to LM application with valid credentials
    Then I Navigate to Operations
    Then I Navigate to Licenses
    When I Click on Show Filters
    Then I Verify that there is no "Get Slot Type()"
    And I Verify that there is License type attribute is matching
    And I close the browser

  @VMM-3623  @reg
  Scenario: VMM_3623 Change cloud courier feature name from storage to Cloud-Courier
    Given I login to LM application with valid credentials
    Then I Navigate to System Admin
    Then I Navigate to License Type
    Then I Navigate to  ADD_ON_PRODUCT  license type of DES Cloud Courier software
    Then I confirm that ADD_ON_PRODUCT name is cloud-courier
    And I close the browser
