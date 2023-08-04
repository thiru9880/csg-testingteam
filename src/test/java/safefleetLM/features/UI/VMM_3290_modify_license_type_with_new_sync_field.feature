##############################################
#Author : Nitin Kumar														
#Test Case ID: VMM_3290											
##############################################

Feature: modify license type with new sync field

@VMM-3290 @reg @System_Admin
Scenario Outline: VMM_3290 modify license type with new sync field
Given I login to LM application with valid credentials
Then I navigate to the System Admins Tab
Then I navigate to License Types Tab
Then I verify there is "<TCID>" coloumn exist 
And I make sure that there is a checkbox next to each of the License Type for types under that coloumn
And I close the browser
     
Examples: 
|TCID     |
|VMM3290_1|