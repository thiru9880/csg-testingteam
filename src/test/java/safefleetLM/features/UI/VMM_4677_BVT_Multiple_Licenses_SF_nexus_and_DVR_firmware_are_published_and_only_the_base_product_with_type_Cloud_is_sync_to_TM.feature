####################################################
#Author: Surya
#Test Case Id: VMM_4677 VMM_3270
####################################################
Feature: Multiple Licenses SF nexus and DVR firmware are published and only the base product with type Cloud is sync to TM

  @VMM-4677 @VMM-3270 @VMM-4895  @int @tm @reg @smoke @smoke2 @Integration2
  Scenario Outline: VMM_4677 VMM_3270 Multiple Licenses SF nexus and DVR firmware are published and only the base product with type Cloud is sync to TM
    Given I login to LM application with valid credentials
    When I navigate to Tenant tab
    Then I create an cloud-Government tenant "<TCID>"
    Then I navigate to devices tab
    Then I create device with a device type and test data and save "<TCID>"
    When I navigate to Licences Tab
    Then I Create an DVR firmware DH6 license for the cloud-Government tenant "<TCID>"
    Then I assign device to license "<TCID>"
    When I navigate to Licences Tab
    And I Create an SF Commander license for the cloud-Government tenant "<TCID2>"
    Then I publish and download the license for DVR firmware DH6 license "<TCID>"
    And I publish the license for SF Commander license
    Then I Verify in TM Swagger, that the SF Commander published license is synced to TM, where as DVR firmware License will not be synced to TM "<TCID>"
    When I navigate to Base Product Tab
    Then I Verify Base Product SF Commander Appication Id In UI and Swagger "<TCID>"
    Then I navigate to Licences Tab
    Then I Unassign the Device In License "<TCID>"
    Then I navigate to the Operation Tab
    When I navigate to Licences Tab
    Then I delete the published license "<TCID>"
    Then I delete the published license "<TCID2>"
    Then I click on operations to navigate Tenants tab
    Then I delete the Tenant "<TCID>"
    Then I navigate to the Operation Tab
    When I navigate to devices tab
    Then I delete the Device "<TCID>"
    And I close the browser

    Examples:
      |  TCID   |  TCID2  |
      |VMM4677_1|VMM4677_2|



