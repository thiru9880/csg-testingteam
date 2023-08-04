############################
# Author : Dilip k
# Test Cased ID : VMM_3655
############################
Feature: DeviceSettings Export feature

@VMM-3655 @reg @Operations
   Scenario: VMM-3655 cosystem/Device Settings: Actions - Export to Excel
    Given I login to LM application with valid credentials
    Then I navigate to ecosystem settings under operations tab
    Then I click on the arrow next to Ecosystem settings
    Then I verify if the downloaded excel has the ecosystem settings headers
    Then I navigate to device settings under operations tab
    Then I click on the arrow next to device settings
    Then I verify if the downloaded excel has the device settings headers
    And I close the browser