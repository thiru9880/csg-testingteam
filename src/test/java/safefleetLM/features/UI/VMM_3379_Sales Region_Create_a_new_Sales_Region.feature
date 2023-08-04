##################################################
#Author: Melroy
#Test Case ID: VMM_3379,VMM_3380,VMM_3381
##################################################
Feature: Manage Sales Region

@VMM-3379  @reg @Tenants
  Scenario Outline: VMM_3379,VMM_3380,VMM_3381 Manage sales Region 
    Given I login to LM application with valid credentials
    Then I click on Operations Tab to navigate Sales Regions Tab
    Then I click the NEW button
    Then I fill all required fields with test data and Click on Save "<TCID>"
    Then I verify a new entry has been added to the Sales Regions Table "<TCID>"
    Then I click on view to get Sales Region metadata "<TCID>" 
    Then I verify information "<TCID>" and click the back button
    Then I edit Sales Region metadata with test data "<TCID>" and click on SAVE
    Then I verify the change to data in the Sales Region table"<TCID>"
    Then I track sales Region "<TCID>"
    Then I click DELETE "<TCID>"
    Then I close the browser
   
    Examples:  
      | TCID      |
      | VMM3379_1 |
