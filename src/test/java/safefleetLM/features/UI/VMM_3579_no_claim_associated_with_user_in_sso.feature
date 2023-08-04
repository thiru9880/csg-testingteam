############################
# Author : Naincy Soni
# Test Cased ID : VMM_3579
############################
Feature: Claim Associated With User

@VMM-3579 @reg @int @sso @Integration1
Scenario Outline:VMM-3579 When you create the user, there is no claim associated with that user in sso first time
Given I login to LM application with valid credentials
Then I navigate to User Page
Then I search user with test data "<TCID>"
Then I verify User with only one role with higher ranking in swagger with expected test data "<TCID>"
And I close the browser
Examples:
		|TCID      |
		|VMM-3579_1|