##############################################
#Author : Nitin Kumar
#Test Case ID: VMM_3919
##############################################
Feature: Offer Device License type for SF Cognition Base Product

  @VMM-3919 @VMM-5324 @VMM-5493 @reg @Licenses
  Scenario Outline: VMM-3919 VMM-5324 VMM-5493 Offer Device License type with Provider details for SF Cognition Base Product
    Given I login to LM application with valid credentials
  	Then I navigate to the System Admins Tab
  	Then I navigate to License Types Tab
  	Then I use existing SF cognition Device License Type "<TCID>"
    Then I navigate to the Operation Tab
    Then I navigate to Tenants Tab
    Then I create new Tenant "<TCID>"
    Then I navigate to ecosystem settings tab
    And I create Ecosystem setting for created tenant "<TCID>"
    Then I navigate to Licences Tab
    Then I create a Asset-H2 License with provider details for SF Cognition "<TCID2>"
    Then I verify Provider details and update it "<TCID2>" "<TCID3>"
    Then I create a License of Base Product SF Cognition "<TCID>"
    Then I published the App license "<TCID>"
    Then I search and publish the License "<TCID2>"
    Then I verify updated Provider details "<TCID2>" "<TCID3>"
    Then I verify in Swagger that Asset licenses sync with TM along with License key "<TCID>"
    Then I delete the published App license "<TCID>"
    Then I search and expand the License with Tenant Id "<TCID2>"
    Then I delete the published Add-on module Asset license "<TCID2>"
    Then I click on operations to Navigate Ecosystem Settings
    Then I delete the ecosystem settings "<TCID>"
    Then I click on operations to navigate Tenants tab
    Then I delete the Tenant "<TCID>"
    And I close the browser

    Examples:
      | TCID      | TCID2     | TCID3     |
      | VMM3919_1 | VMM3919_2 | VMM3919_2 |
