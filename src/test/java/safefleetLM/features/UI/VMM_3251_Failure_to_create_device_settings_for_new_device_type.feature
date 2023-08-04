###################################################
#Authour:Sunilkumar
#Test CaseID: VMM_3251
###################################################
Feature: Failure to create device settings for new device type

  @VMM-3251  @reg @Operations 
  Scenario Outline:  VMM_3251 Failure to create device settings for new device type
    Given I login to LM application with valid credentials
    When I click on system admin to navigate Device Type Tab   
    Then I create a new test device type "<TCID>"
    When I navigate to the device settings tab
    Then I create a new device setting with the device type i created "<TCID2>"    
    Then I delete device setting "<TCID2>" 
    Then I click on system admin to navigate Device Type Tab  
    Then I delete the test device type "<TCID>"
    And I close the browser 

    Examples: 
      | TCID      | TCID2     |
      | VMM3251_1 | VMM3251_2 |
