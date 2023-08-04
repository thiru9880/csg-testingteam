############################
# Author : Savitha
############################
Feature: Expire option for licenses

@VMM-5419 @reg @int @tm @Integration1
Scenario Outline:VMM-5419 Verify Expire option and its functionality for license
  Given I login to LM application with valid credentials
  Then I click on operations to navigate Tenants tab
  Then I create new Tenant "<TCID>"
  Then I create APP license for DES CLOUD COURIER with test data "<TCID>"
  Then I search and expand the License with Tenant Id "<TCID>"
  Then I verify EXPIRE option is not enabled for Draft license
  Then I publish the license "<TCID>"
  Then I verify EXPIRE option is enabled for Published license
  Then I verify the published license Active Status in TM via swagger with expected test data "<TCID>"
  Then I expire APP license with test data
  Then I verify the published license Expired Status in TM via swagger with expected test data "<TCID2>"
  Then I return the license and delete the licenses "<TCID>"
  Then I click on operations to navigate Tenants tab
  Then I delete the Tenant "<TCID>"
  And I close the browser


  Examples:
  | TCID       | TCID2      |
  | VMM_5419_1 | VMM_5419_2 |
