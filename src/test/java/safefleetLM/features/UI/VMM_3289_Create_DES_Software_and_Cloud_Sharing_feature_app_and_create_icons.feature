#################################################
#Author: Melroy																
#Test Case ID: VMM_3289													
#################################################
Feature: Create DES software and Cloud Sharing feature app and create icons

@VMM-3289  @reg @System_Admin
  Scenario Outline: VMM_3289 Create DES software and Cloud Sharing feature app and create icons 
    Given I login to LM application with valid credentials
    Then I navigate to Base Product Tab 
    Then I Verify that DES Cloud Courier software exists "<TCID>"
    Then I navigate to license Type Tab
    Then I Verify that there are two License Types exist for DES Cloud Courier software and both have DES icons "<TCID>"
    And I close the browser 
     
    
    Examples:  
      | TCID      |
      | VMM3289_1 |
         