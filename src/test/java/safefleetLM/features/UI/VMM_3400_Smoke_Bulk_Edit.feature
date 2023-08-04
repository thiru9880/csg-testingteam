##############################################
#Author : Melroy
#Test Case ID: VMM_3400
##############################################
Feature: Bulk Edit

@VMM-3400  @reg @smoke @smoke1 @Devices
  Scenario Outline: VMM_3400 Bulk Edit
    Given I login to LM application with valid credentials
    Then I navigate to the Operation Tab
    #Then I navigate to Tenant tab
    #Then I Create a New Tenant For Bulk Edit "<TCID1>"
    Then I navigate to devices tab
    Then I Create a First Devices For Bulk Edit "<TCID1>"
    Then I Create a Second Devices For Bulk Edit "<TCID2>"
    Then I Select Multiple Tenant ID "<TCID1>"
    Then I Click on Bulk Edit
    Then I Select Devices manually selected option and click Next
    Then I Select the Part check box and change the Part No. "<TCID1>"
    Then I Click Next, then Next and Ok
    Then I Verify Part No. is updated successfully with new Part No. selected "<TCID1>"
    Then I delete the First Device "<TCID1>"
    Then I delete the Second Device "<TCID2>"
    #Then I navigate to the Operation Tab
    #Then I navigate to Tenant tab
   # Then I delete the Tenant "<TCID1>"
    And I close the browser

    Examples:
      | TCID1     |  TCID2   |
      | VMM3400_1 | VMM3400_2 |
