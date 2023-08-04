##############################################
#Author : Nitin Kumar
#Test Case ID: VMM_3619
##############################################

Feature: NEXUS APP license must include a server

@VMM-3619 @reg @System_Admin
Scenario: VMM_3619 NEXUS APP license must include a server
Given I login to LM application with valid credentials
Then I navigate to the System Admins Tab
Then I navigate to License Types Tab
Then I make sure that APP License Type of NEXUS software has Requires Server option checked
And I close the browser
