############################
# Author : Naincy Soni
# Test Cased ID : VMM_4330
############################
Feature: New device available in device page and license page

@VMM-4330 @VMM-5527 @VMM-5532 @reg @Licenses
Scenario Outline:VMM-4330 New devices TH8, NH16K, NH16, TH12 available in Device Type and License Type for DVR Firmware
Given I login to LM application with valid credentials
Then I navigate to the System Admins Tab
Then I navigate to Device Type Tab
Then I verify Devices TH8, TH12, NH16, DH4v2 with test data "<TCID>""<TCID1>""<TCID2>""<TCID3>"
Then I Verify Table Name device_type in DB with test data "<TCID>"
Then I navigate to license Type Tab
Then I verify Licenses Sub Type TH8, TH12, NH16, DH4v2 in License Type Page with test data "<TCID>""<TCID1>""<TCID2>""<TCID3>"
Then I Verify Table Name license_type in DB with test data "<TCID>"
Then I navigate to the Operation Tab
Then I navigate to Tenants Tab
Then I create new tenant for VMM4330 with test data "<TCID>"
Then I navigate to Licences Tab
#Then I create DH6 for DVR Firmware Base Product with test data "<TCID>"
#Then I Publish License with test data "<TCID>"
Then I create TH8 for DVR Firmware Base Product with test data "<TCID1>"
Then I Publish License with test data "<TCID1>"
Then I delete the published license "<TCID1>"
Then I create TH12 for DVR Firmware Base Product with test data "<TCID2>"
Then I Publish License with test data "<TCID2>"
Then I delete the published license "<TCID2>"
Then I create NH16 for DVR Firmware Base Product with test data "<TCID3>"
Then I Publish License with test data "<TCID3>"
Then I delete the published license "<TCID3>"
Then I create DH4v2 for DVR Firmware Base Product with test data "<TCID4>"
Then I Publish License with test data "<TCID4>"
Then I delete the published license "<TCID4>"
#Then I delete the published license "<TCID1>"
#Then I delete the published license "<TCID2>"
#Then I delete the published license "<TCID3>"
#Then I delete the published license "<TCID4>"
Then I click on operations to navigate Tenants tab
Then I delete the Tenant "<TCID>"
And I close the browser

Examples:
  | TCID       | TCID1      | TCID2      | TCID3      | TCID4      |  |
  | VMM-4330_1 | VMM-4330_2 | VMM-4330_3 | VMM-4330_4 | VMM-4330_5 |  |
