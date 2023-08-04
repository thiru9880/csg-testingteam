################################
#Author: Melroy					
#Test Case ID: VMM_3849  
################################
Feature: Create New Software DVR Frimware

@VMM-3849  @reg @System_Admin
  Scenario Outline: VMM_3849 Create New Software DVR Frimware
    Given I login to LM application with valid credentials
    Then I navigate to Base Product Tab 
    Then I verify the base product DVR Firmware exist "<TCID>"
    Then I verify the Base Product details with test data "<TCID>"
    Then I navigate to license Type Tab
    Then I verify the License Type: DEVICE  License Sub Type: DH6 exist "<TCID>"
    Then I verify the License Type details with test data of DH6 "<TCID>"
    Then I verify the License Type: DEVICE  License Sub Type: DH8 exist "<TCID>"
    Then I verify the License Type details with test data of DH8 "<TCID>"
    Then I navigate to Device Type Tab
    Then I verify the Device Type with Name DH6 exist "<TCID>"
    Then I verify the Device Type details with test data of DH6 "<TCID>"
    Then I verify the Device Type with Name DH8 exist "<TCID>"
    Then I verify the Device Type details with test data of DH8 "<TCID>"
    Then I close the browser
  
    Examples: 
			| TCID      |
      | VMM3849_1 |