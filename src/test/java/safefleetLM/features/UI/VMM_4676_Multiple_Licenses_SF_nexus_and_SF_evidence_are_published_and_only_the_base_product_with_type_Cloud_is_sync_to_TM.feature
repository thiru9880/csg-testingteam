##############################################
#Author : Nitin Kumar
#Test Case ID: VMM_4676
##############################################
Feature: Multiple Licenses SF nexus and SF evidence are published and only the base product with type Cloud is sync to TM

  @VMM-4676 @int @tm @Integration2
  Scenario Outline: VMM_4676 Multiple Licenses SF nexus and SF evidence are published and only the base product with type Cloud is sync to TM
    Given I login to LM application with valid credentials
    Then I create a cloud commercial Tenant "<TCID>"
    Then I create SF evidence manager License for the Tenant created "<TCID>"
    Then I create SF nexus License for the Tenant created "<TCID2>"
    Then I publish and download the License "<TCID>"
    Then I publish and download the License again
    And I verify in TM swagger, that the SF nexus published License is synced to TM, where as SF evidence manager will not be synced to TM "<TCID>"
    And I close the browser
     
    Examples: 
      | TCID      | TCID2     |
      | VMM4676_1 | VMM4676_2 |
