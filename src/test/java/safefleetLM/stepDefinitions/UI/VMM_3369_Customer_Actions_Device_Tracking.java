package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3369_Customer_Actions_Device_Tracking extends BaseTest {
		
	TestSetup testSetup;
    
	public VMM_3369_Customer_Actions_Device_Tracking(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	} 
	@Then("I create a new Customer {string}") 
	public void i_create_a_new_Customer(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I Create a new Customer");
		
		 testSetup.pageObjectManager.getCustomerPage().clicknewbutton();
 		
	   	 String tenantID=randomStringGenerator();  
		 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"CustomerPage","Name",tenantID,"VMM_3369_1"); 
		 
		 Map<String, String> testData = ExcelFileReader.getDataInMap("CustomerPage", tcid);
		   	reportInfo(testData.toString()); 
		   	testSetup.pageObjectManager.getCustomerPage().createNewCustomer(testData);
		   	
		 testSetup.pageObjectManager.getCustomerPage().ClickOnSave();
		 reportScreenshot(testSetup.driver);
		 
		
		}  
		catch(Exception e) { 
    		testStepHandle("FAIL", testSetup.driver, test, e);     
		} 
	} 
	

	@Then("I Click on clipboard symbol Actions {string}")
	public void i_click_on_clipboard_symbol_actions(String tcid) { 
		try { 
		test = logInfo.get().createNode("I Click on clipboard symbol Actions"); 
		test.assignCategory("Others");
		
		Map<String, String> testData = ExcelFileReader.getDataInMap("CustomerPage", tcid);
		testSetup.pageObjectManager.getCustomerPage().Clickoncustxtfield(testData.get("edit_Name"));
		
		
		testSetup.pageObjectManager.getCustomerPage().clickOnDeviceTrackingButton();
		//reportScreenshot(testSetup.driver);
		reportInfo("I click on clipboard symbol succesfully");
		}  
		catch(Exception e) { 
    		testStepHandle("FAIL", testSetup.driver, test, e);     
		} 
		
	}  
	@Then("I click on view options to change Audit details") 
	public void i_click_on_view_options_to_change_audit_details() { 
		try {
		test = logInfo.get().createNode("I click on view options to change Audit details"); 
		reportScreenshot(testSetup.driver);  
		testSetup.pageObjectManager.getCustomerPage().clickOnEyeSymbolBtn();
		reportInfo("I click on view option succesfully"); 
		}
		catch(Exception e) {
    		testStepHandle("FAIL", testSetup.driver, test, e);    
		} 
    
	}  
	@Then("I Verify that Audit details")
	public void i_verify_that_audit_details() throws Exception {
		try {
		test = logInfo.get().createNode("I Verify that Audit details");
		
		//testSetup.pageObjectManager.customer.UPDATE();
		String verify=testSetup.pageObjectManager.getCustomerPage().VerifyAuditDetails();
		reportScreenshot(testSetup.driver); 
		if(verify.equalsIgnoreCase("Audit Details"))    
		{
			reportPass("verify audit details", "Audit Details", verify);
			reportInfo("I verify the audit details succesfully");
		}
		else {
			reportFail("not verify audit details", "Audit Details", verify);
			reportInfo("I verify the audit details not succesfully");
		}
		
		testSetup.pageObjectManager.getCustomerPage().clickOnDoneSymbolBtn();
	}   
		catch(Exception e) {
    		testStepHandle("FAIL", testSetup.driver, test, e);
		}
		
	}
	@Then("I Click on Delete customer {string}") 
	public void i_click_on_delete(String tcid) {
		try {
		test = logInfo.get().createNode("I Click on Delete customer"); 
		Map<String, String> testData = ExcelFileReader.getDataInMap("CustomerPage", tcid);
		 
		String AlertMsg = testSetup.pageObjectManager.getCustomerPage().deleteCustomer(testData);
		reportScreenshot(testSetup.driver);
		if(AlertMsg.contains("A Customer is deleted with identifier"))
		{ 
			reportPass("Customer", "A Customer is deleted with identifier", AlertMsg);
			reportInfo("Customer deleted successfully");
		}
		else
			reportFail("Customer", "A Customer is deleted with identifier", AlertMsg);
		//reportInfo("customer is deleted successfully");   
		}
		catch(Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
		}  

	}  

	
	     
	
	
 
	@Then("I search for customer not currently displayed in table {string}")
	public void i_search_for_customer_not_currently_displayed_in_table(String tcid) { 
		try {
			test = logInfo.get().createNode("I search for customer not currently displayed in table");
			Map<String, String> testData = ExcelFileReader.getDataInMap("CustomerPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getCustomerPage().customerAdd(testData);
			reportScreenshot(testSetup.driver);  
			
			reportInfo("I search a customer successfully"); 
		}
		catch (Exception e) {
    		testStepHandle("FAIL", testSetup.driver, test, e);   
		} 	
	} 
} 

