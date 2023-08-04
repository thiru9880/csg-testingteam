##############################################
#Author : Nitin Kumar
#Test Case ID: VMM_4347
##############################################
Feature: Verify the license file generated for new version of Evidence manager with Idp and Market segment values

  @VMM-4347 @VMM-5413 @reg @smoke @smoke2 @Licenses
  Scenario Outline: VMM-4347 VMM-5413 Verify the license file generated for new version of Evidence manager with Idp and Market segment values
    Given I login to LM application with valid credentials
    Then I create an onsite Tenant "<TCID>"
    Then I click on Operations to navigate Licenses Tab
    Then I create app License for evidence manager with valid identity provider "<TCID>"
      Then I create Chain Of Custody Add-on module License for evidence manager "<TCID2>"
      Then I publish Chain Of Custody License "<TCID2>"
      Then I publish App license and download the License file
    Then I delete the published license "<TCID>"
    Then I delete the published license "<TCID2>"
    Then I click on operations to navigate Tenants tab
    Then I delete the Tenant "<TCID>"
    And I close the browser

    Examples:
      | TCID      | TCID2     |
      | VMM4347_1 | VMM4347_2 |
