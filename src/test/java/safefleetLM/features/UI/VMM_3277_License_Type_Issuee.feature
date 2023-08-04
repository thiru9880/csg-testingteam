####################################################
#Author: Surya
#Test Case Id: VMM_3277
####################################################
Feature: License Type Issuess

  @VMM-3277 @reg @System_Admin
  Scenario Outline: VMM_3277 License Type Issues
    Given I login to LM application with valid credentials
    When I navigate to the Operation Tab
    When I navigate to Tenant tab
    Then I create new Tenant For Licenses "<TCID>"
    When I navigate to Licences Tab
    Then I Verify that Data Amount field is not mandatory field create a new Licesnse with License Type "<TCID>"
    And I Verify that Qty field is mandatory create a new Licesnse with License Type "<TCID>"
    Then I delete the License "<TCID>"
    When I navigate to Tenant tab
    Then I delete the Created Tenant "<TCID>"
    And I close the browser

    Examples: 
      |  TCID   |
      |VMM3277_1|
