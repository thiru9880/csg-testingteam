##############################################
#Author : Nitin Kumar														
#Test Case ID: VMM_3625									
##############################################

Feature: Nexus license type

  @VMM-3625 @reg @System_Admin
  Scenario Outline: VMM_3625 Nexus license type
    Given I login to LM application with valid credentials
    Then I navigate to the System Admins Tab
    Then I navigate to License Types Tab
    Then I verify that these License Types are available for the NEXUS software APP FEATURE_APP DEVICE--BW DEVICE--ICV "<TCID>"
    And I close the browser
       
    Examples: 
      | TCID      |
      | VMM3625_1 |
