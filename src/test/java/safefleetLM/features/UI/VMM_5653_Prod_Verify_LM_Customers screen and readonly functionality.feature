#Author: Savitha

Feature: Verify License Manager Customers screen and readonly functionality


  @prod @prod1 @VMM-5653
  Scenario Outline: VMM-5653_Verify_LM_Customers screen and readonly functionality
    Given I login to LM application with valid credentials
    Then I Navigate to Customers
    Then I click on NEW and verify new Customer creation screen and cancel
    Then I search Customer, view and verify customer details "<TCID>"
    And I close the browser


     Examples:
     |TCID    |
     |VMM_5653_1|
