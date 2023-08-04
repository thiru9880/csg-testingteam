################################################
#Author: Melroy																
#Test Case ID: VMM_3283														
################################################
Feature: Move server into software

@VMM-3283  @reg @System_Admin	
  Scenario Outline: VMM_3283 Move server into software 
    Given I login to LM application with valid credentials
    Then I navigate to Base Product Tab 
    Then I Select one Base Product and Click Edit to verify servers Selected "<TCID>"  
    Then I Navigate to Operations 
		Then I navigate to Licences Tab
    Then I click the NEW button 
    Then I fill the necessary fields click on Server text Box and Verify servers are available in the servers dropdown "<TCID>" 
    And I close the browser 
 
Examples:
	| TCID			|
	| VMM_3283  |	
