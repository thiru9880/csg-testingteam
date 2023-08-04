#######################################
#Author : Rajath G M
#Test Case ID: VMM_3656
#######################################
Feature: Manage filter in tanant page

  @VMM-3656  @reg @Tenants
  Scenario: VMM_3656 Filter in Tenants page contains invalid filter attributes
     Given I login to LM application with valid credentials
     Then I navigate to the Operation Tab
     Then I navigate to Tenants Tab
     Then I click on show filter and Expand the filter parameter drop down
     Then I verify that the Tenant filter attribute match with column names in tenant table
     And I close the browser
