############################################################
#Author : Rajath G M
#Test Case ID: VMM_3718
############################################################
Feature: Manage servers deployment type
 
 @VMM-3718  @reg @System_Admin
 Scenario Outline: VMM_3718 Manage servers page deployment type
  Given I login to LM application with valid credentials 
  Then I Navigate to System Admin
  Then I Navigate to Servers 
  Then I Click on New to Create a New server "<TCID>" 
  Then I Create above New server with same Name "<TCID>"   
  Then I verify that popup appears saying that server already exists "<TCID>"  
  Then I delete a server "<TCID>"
  And I close the browser     
      
   Examples:      
    |TCID     |        
    |VMM3718_2|         