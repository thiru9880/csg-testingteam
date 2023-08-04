#############################
#Author : Rajath G M
#Test Case ID: VMM_3704
#############################
Feature: Manage Expiry date for an expired license on renewal

   @VMM-3704 @smoke @smoke1 @reg @Licenses
   Scenario Outline: VMM_3704 Expiry date for an expired license on renewal
   Given I login to LM application with valid credentials
	  Then I navigate to the Operation Tab
		Then I navigate to Licences Tab
   Then I click on Licenses showfilter to get the expired licenses "<TCID>"
   Then I do not change license expiration date on the Renew license page and I Verify that the license expiry date on the license page is same as the expiry date on renew page "<TCID>"
   And I close the browser

  Examples:
     |TCID      |
     |VMM_3704_1|
