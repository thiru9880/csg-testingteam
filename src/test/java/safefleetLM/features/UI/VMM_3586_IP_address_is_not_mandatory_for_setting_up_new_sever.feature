############################################################
# Author : Bhanu
# Test Case ID: VMM_3586
############################################################
Feature: IP address is not mandatory for setting up new sever

  @VMM-3586 @reg @System_Admin
  Scenario Outline: VMM_3586 IP address is not mandatory for setting up new sever
    Given I login to LM application with valid credentials
    Then I click on system admin to navigate servers
    Then I create a New server without IP adress "<TCID>"
    Then I edit the server "<TCID>"
    Then I view the Server created above and Validate the IP Address field value "<TCID>"
    Then I delete the server "<TCID>"
    And I close the browser

    Examples: 
      | TCID       |
      | VMM_3586_1 |
