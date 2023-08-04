###################################################
#Authour:Sunilkumar
#Test CaseID: VMM_3846
###################################################
Feature: Filter issues in the Licenses page
 

  @VMM-3846 @reg @Licenses
  Scenario Outline: VMM_3846 Filter issues in the Licenses page
    Given I login to LM application with valid credentials 
     When I Navigate to Operations 
     When I Navigate to Licenses
     Then I Verify that the Deployment Type filter CLOUD_COMMERCIAL working correctly with testdata "<TCID>"
     And I Verify that the Deployment Type filter ONSITE working correctly with testdata "<TCID2>"
     And I Verify that the License Type filter with Base Product working correctly with testdata "<TCID3>"
     And I Verify that the License Type filter with ASSET working correctly with testdata "<TCID4>"
     And I close the browser  
      
    
    
    
    
    Examples: 
      | TCID    |TCID2      |TCID3     |TCID4     |
      |VMM_3846_1|VMM_3846_2|VMM_3846_3|VMM_3846_4|
    