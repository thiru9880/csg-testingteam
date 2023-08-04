##############################################
#Author : Nitin Kumar
#Test Case ID: VMM_3737
##############################################
Feature: Implement a checkbox in devices for Customer Provided

  @VMM-3737 @reg @Devices
  Scenario Outline: VMM-3737 Implement a checkbox in devices for Customer Provided
    Given I login to LM application with valid credentials
    Then I navigate to the Operation Tab
    Then I navigate to Tenants Tab
    Then I create Tenant "<TCID>"
    Then I navigate to Device tab
    Then I create Device with customer provided on "<TCID>"
    Then I create Device with customer provided off "<TCID2>"
    Then I verify customer provided on for one Device "<TCID>"
    Then I verify customer provided off for another Device "<TCID2>"
    Then I Bulk upload Device with customer provided on and off
    Then I verify customer provided on for one Device again "<TCID3>"
    Then I verify customer provided off for another Device again "<TCID4>"
    Then I unassign Tenant from the Device "<TCID>"
    Then I unassign Tenant from the Device "<TCID2>"
    Then I unassign Tenant from the Device "<TCID3>"
    Then I unassign Tenant from the Device "<TCID4>"
    Then I delete the created Device "<TCID>"
    Then I delete the created Device "<TCID2>"
    Then I delete the created Device "<TCID3>"
    Then I delete the created Device "<TCID4>"
    Then I navigate to the Operation Tab
    Then I navigate to Tenants Tab
    Then I delete the Tenant "<TCID>"
    And I close the browser
    Examples: 
      | TCID      | TCID2     | TCID3     | TCID4     |
      | VMM3737_1 | VMM3737_2 | VMM3737_3 | VMM3737_4 |
