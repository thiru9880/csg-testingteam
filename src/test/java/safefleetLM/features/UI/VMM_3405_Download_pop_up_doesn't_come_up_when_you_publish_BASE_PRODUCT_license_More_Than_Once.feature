#############################################
#Author: Melroy
#Test Case ID: VMM_3405
#############################################
Feature: Download pop-up doesnt come up when you publish BASE_PRODUCT license more than once

  @VMM-3405  @reg @Licenses
  Scenario Outline: VMM_3405 Download pop-up doesnt come up when you publish BASE_PRODUCT license more than once
    Given I login to LM application with valid credentials
    Then I navigate to the Operation Tab
    Then I create new tenant for licenses with test data "<TCID>"
		Then I navigate to Licences Tab
    Then I click on new to create license for BASE_PRODUCT License Type with test data "<TCID>"
    Then I Verify in the license table for a BASE_PRODUCT license "<TCID>"
    Then I click the publish action menu for the license
    Then I click the download license checkbox in the Pop_up 
    Then I Verify that Download Pop up come up when you publish more than ones
    Then I delete the published App license "<TCID>"
     Then I click on operations to navigate Tenants tab
    Then I delete the Tenant "<TCID>"
    And I close the browser
 
    Examples: 
      | TCID      |
      | VMM3405_1 |
