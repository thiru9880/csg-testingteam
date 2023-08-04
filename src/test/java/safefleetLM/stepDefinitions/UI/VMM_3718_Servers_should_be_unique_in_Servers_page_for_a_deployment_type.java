package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;

public class VMM_3718_Servers_should_be_unique_in_Servers_page_for_a_deployment_type extends BaseTest {
		
	TestSetup testSetup;
    
	public VMM_3718_Servers_should_be_unique_in_Servers_page_for_a_deployment_type(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}
  
	@Then("I Navigate to Servers")
	public void i_navigate_to_servers() {
		try {
	    	test = logInfo.get().createNode("I Navigate to Servers"); 
	    	testSetup.pageObjectManager.getCustomerPage().clickOnServers();    
	    	reportInfo("I Navigate to Servers successfully");  
		}
		catch (Exception e) { 
			  testStepHandle("FAIL",testSetup.driver, test, e);
		}
	     
	}
	@Then("I Click on New to Create a New server {string}")
	public void i_click_on_new_to_create_a_new_server(String tcid) {
		try {
	    	test = logInfo.get().createNode("I Click on New to Create a New server");
	    	testSetup.pageObjectManager.getCustomerPage().clickOnNewServers();
	    	Map<String, String> testData = ExcelFileReader.getDataInMap("ServerPage", tcid);
	    	testSetup.pageObjectManager.getCustomerPage().createServers(testData);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getCustomerPage().ClickOnSave(); 
			reportScreenshot(testSetup.driver);
	    	reportInfo("I created New server successfully");  
		}
		catch (Exception e) {
			  testStepHandle("FAIL",testSetup.driver, test, e); 
		}   
	}
	    
	@Then("I Create above New server with same Name {string}")
	public void i_create_above_new_server_with_same_name(String tcid) {
			try {
			test = logInfo.get().createNode("I Create above New server with same Name"); 
			test.assignCategory("Servers");
			testSetup.pageObjectManager.getCustomerPage().clickOnNewServers(); 
			Map<String, String> testData = ExcelFileReader.getDataInMap("ServerPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getCustomerPage().createServers(testData);
			reportScreenshot(testSetup.driver);	
			}
		catch (Exception e) {  
			  testStepHandle("FAIL",testSetup.driver, test, e);       
		}  
	  
	}
	@Then("I verify that popup appears saying that server already exists {string}")
	public void i_verify_that_popup_appears_saying_that_server_already_exists(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I verify that popup appears saying that server already exists");
		Map<String, String> testData = ExcelFileReader.getDataInMap("ServerPage", tcid);
		reportInfo(testData.toString());
        testSetup.pageObjectManager.getCustomerPage().ClickOnSave();
        boolean result=testSetup.pageObjectManager.getCustomerPage().checkalertPopup();
		reportScreenshot(testSetup.driver);	
		testSetup.pageObjectManager.getCustomerPage().clickOnCancelButton();
		
		//testSetup.pageObjectManager.getCustomerPage().clickOnServerShowFilterbutt();
		
		
		if(result==true)
		{
		reportPass("Error Alert PopUp", "true", "true");    
		reportScreenshot(testSetup.driver);	 
		}
		else {
		reportFail("Error Alert PopUp Not Shown", "false", "false");
		reportScreenshot(testSetup.driver);	
		reportInfo("I'm not able to create another server with same Name successfully"); 
		} 
		}
		catch (Exception e) {  
			  testStepHandle("FAIL",testSetup.driver, test, e);  
		}
	}
	@Then("I delete a server {string}")  
	public void I_delete_a_server(String tcid)  {
		try {
			test = logInfo.get().createNode("I delete a server");
		   
			Map<String, String> testData = ExcelFileReader.getDataInMap("ServerPage", tcid);
			testSetup.pageObjectManager.getCustomerPage().clickOnServerShowFilterbutt();
	    	testSetup.pageObjectManager.getCustomerPage().FilterSearching(testData);
	    	reportInfo(testData.toString());
	    	
	    	testSetup.pageObjectManager.getCustomerPage().clickFILTER();
	    	testSetup.pageObjectManager.getCustomerPage().clickDelete();
	    	testSetup.pageObjectManager.getCustomerPage().clickDeleteAction();
	    	reportScreenshot(testSetup.driver);	
	    	
	    	
	    	 
	
			reportInfo("I deleted server successfully");    
		}
		catch (Exception e) {
			  testStepHandle("FAIL",testSetup.driver, test, e); 
		}
	}
}
