##########################################################
# Author : Ravi Manne
# Test Cased ID : VMM_3370, VMM3372, VMM_3655 , VMM_3383
##########################################################

Feature: Export to Excel

   @VMM-3370 @VMM3372 @VMM-3655 @VMM-3383 @reg @Operations
   Scenario: VMM_3370, VMM3372, VMM_3655 , VMM_3383 Actions - Export Table to Excel
    Given I login to LM application with valid credentials

    When  I export "Tenants" excel
    Then I verify downloaded file for "Tenants"

    When  I export "Customers" excel
    Then I verify downloaded file for "Customers"

    When  I export "DeviceSettings" excel
    Then I verify downloaded file for "DeviceSettings"

    When  I export "SalesRegion" excel
    Then I verify downloaded file for "SalesRegion"

    When  I export "EcoSystemSettings" excel
    Then I verify downloaded file for "EcoSystemSettings"

    And  I close the browser


    #Given I login to LM application with valid credentials
    #Then  I export "<tabname>" excel
    #And I verify downloaded file for "<tabname>"
    #Then  I close the browser
    #
    #Examples:
#		|tabname           |
#		|EcoSystemSettings |
#		|DeviceSettings    |
#		|Tenants           |
#		|Customers         |
