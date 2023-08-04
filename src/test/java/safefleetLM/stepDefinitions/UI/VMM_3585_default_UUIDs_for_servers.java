package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3585_default_UUIDs_for_servers extends BaseTest {
		
	TestSetup testSetup;
    
	public VMM_3585_default_UUIDs_for_servers(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}
	
	@Then("I Click On New to Create a New server {string}") 
	public void i_click_on_new_to_create_a_new_server(String tcid) {
		try {
			String serverID=randomStringGenerator();			
			System.out.println(serverID);
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"ServerPage","Name",serverID,"VMM_3585_2");
			test = logInfo.get().createNode("I Click On New to Create a New server"); 
			testSetup.pageObjectManager.getCustomerPage().clickOnNewServers();
			Map<String, String> testData = ExcelFileReader.getDataInMap("ServerPage", tcid);
	    	testSetup.pageObjectManager.getCustomerPage().createServers(testData);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getCustomerPage().clickSaveButtonn();
			reportScreenshot(testSetup.driver);
			reportInfo("I Created new server successfully");   
		}
		catch (Exception e) {
			  testStepHandle("FAIL",testSetup.driver, test, e);  
		}
	}
	
	@Then("I Verify that server was created with randomly generated default uuid")
	public void i_verify_that_server_was_created_with_randomly_generated_default_uuid() throws InterruptedException, IOException {
		try {
		test = logInfo.get().createNode("I Verify that server was created with randomly generated default uuid");
		test.assignCategory("Servers");
		testSetup.pageObjectManager.getCustomerPage().clickEyeButt();
		reportScreenshot(testSetup.driver); 
		String UUID = testSetup.pageObjectManager.getCustomerPage().VerifyUUID();
		System.out.println(UUID);
		if(UUID.equalsIgnoreCase("1a3435d6-3ba8-47f4-ba48-0be5010772b5")) 
		{
			reportPass("option type", "1a3435d6-3ba8-47f4-ba48-0be5010772b5", UUID);
		}
		else   
		{
			reportFail("option type", "1a3435d6-3ba8-47f4-ba48-0be5010772b5", UUID);
		}
		reportInfo("I Make sure that server was created with randomly generated uuid successfully"); 
		}
		catch (Exception e) {
			  testStepHandle("FAIL",testSetup.driver, test, e);  
		} 
		
		
	}
	@Then("I Verify that uuid column isnt blank for any of the servers")
	public void i_verify_that_uuid_column_isnt_blank_for_any_of_the_servers() throws InterruptedException {
		try {
		test = logInfo.get().createNode("I Verify that uuid column isnt blank for any of the servers");
		testSetup.pageObjectManager.getCustomerPage().ClickOnBack();
		reportScreenshot(testSetup.driver); 
		boolean uuidcol = testSetup.pageObjectManager.getCustomerPage().verifyUUIDName();
		
		if(uuidcol==true)
		{
			reportPass("result", "true", "true");
		}
		else {
			reportFail("result", "false" , "false");
		
		} 
		
		reportInfo("I will verify that uuid column is not blank for any of the server successfully"); 
		} 
		catch (Exception e) {
			  testStepHandle("FAIL",testSetup.driver, test, e);   
		}    
		 
		
	
	}
	@Then("I Click on view button next to any of the servers and make sure that there is an uuid")
	public void i_click_on_view_button_next_to_any_of_the_servers_and_make_sure_that_there_is_an_uuid() throws Throwable {
		try {
		test = logInfo.get().createNode("I Click on view button next to any of the servers and make sure that there is an uuid");
		
		testSetup.pageObjectManager.getCustomerPage().clickOnEyeactionbutt();
		reportScreenshot(testSetup.driver);
		testSetup.pageObjectManager.getCustomerPage().clickOnBackbut();
		testSetup.pageObjectManager.getCustomerPage().clickOnServerShowFilterbutt();
		reportInfo("I make sure that there is an uuid is there successfully");  
	}
	catch (Exception e) {
		  testStepHandle("FAIL",testSetup.driver, test, e);    
	}
	}
		
	@Then("I delete server {string}")
	public void I_delete_server(String tcid)  {
		try {
			test = logInfo.get().createNode("I delete server");
		
			Map<String, String> testData = ExcelFileReader.getDataInMap("ServerPage", tcid);
	    	testSetup.pageObjectManager.getCustomerPage().SearchServerFilter(testData);
	    	reportInfo(testData.toString()); 
	    	testSetup.pageObjectManager.getCustomerPage().clickOnFILTER();
	    	testSetup.pageObjectManager.getCustomerPage().clickOnDeletesymbol();
	    	reportScreenshot(testSetup.driver);
	    	testSetup.pageObjectManager.getCustomerPage().clickOnDeleteAction();
	    	reportScreenshot(testSetup.driver);
	
			reportInfo("I deleted server successfully");   
		}
		catch (Exception e) {
			  testStepHandle("FAIL",testSetup.driver, test, e);   
			
		}
	}
}
	
	

