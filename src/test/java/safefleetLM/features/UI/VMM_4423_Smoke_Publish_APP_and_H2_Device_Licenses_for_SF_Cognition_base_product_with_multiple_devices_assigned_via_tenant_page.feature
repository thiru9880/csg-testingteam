############################################################
#Authour:Sunilkumar
#Test CaseID: VMM_4423
#############################################################
Feature: VMM_4423 Publish APP and H2 Device Licenses for "SF Cognition" base product with multiple devices assigned via tenant page

  @VMM-4423 @tm @int @reg @Integration2 @smoke @smoke1
  Scenario Outline: VMM_4423 Publish APP and H2 Device Licenses for "SF Cognition" base product with multiple devices assigned via tenant page
      Given I login to LM application with valid credentials
      Then I create new Tenant for VMM4423 with test data "<TCID>"
      When I navigate to ecosystem settings tab
      Then I create a Ecosystem setting with Test data "<TCID>"
      Then I navigate to the Operation Tab
      Then I navigate to Licences Tab
      Then I create license for BASE_PRODUCT License Type with test data "<TCID>"
			Then I create new license for SFCognition with test data "<TCID2>"
      #And I Create APP and H2 Device Licenses for SF Cognition base product with I Created Tenant with testdata "<TCID>"
      Then I create new license for Genetec Integration Add-on Module with test data "<TCID3>"
      When I navigate to devices tab
      Then I Create first device with device type and test data "<TCID>"
      And I Create second device with device type and test data "<TCID2>"
      Then I click on operations to navigate Tenants tab
      Then I search tenant I created and assign multiple devices with testdata "<TCID>"
      Then I Select Device setting and assign the device with testdata "<TCID>" and Verify in Assigned Devices section
      When I navigate to Licences Tab
      And I Navigate back to Licenses page and I will publish the licenses I created with testdata "<TCID>"
      Then I Verify in Swagger that the published licenses are in sync with TM and shows up correctly in TM swagger "<TCID>"
      When I navigate to the Operation Tab
      And I navigate to devices tab
      Then I Unassign the device "<TCID>"
      And I Unassign the device "<TCID2>"
      Then I Delete the device "<TCID>"
      And I Delete the device "<TCID2>"
Then I navigate to the Operation Tab
When I navigate to Licences Tab
Then I search the licenses I created with testdata "<TCID>"
Then I delete the published App license "<TCID>"
Then I delete the published Vehicle licenses "<TCID2>"
Then I delete the published Vehicle licenses "<TCID3>"
Then I click on operations to Navigate Ecosystem Settings
Then I delete the ecosystem settings "<TCID>"
Then I click on operations to navigate Tenants tab
Then I delete the Tenant "<TCID>"
      And I close the browser

    Examples:
      | TCID     | TCID2    | TCID3			|
      |VMM_4423_1|VMM_4423_2| VMM_4423_3|
