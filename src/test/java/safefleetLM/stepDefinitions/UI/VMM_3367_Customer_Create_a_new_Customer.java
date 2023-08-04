package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3367_Customer_Create_a_new_Customer extends BaseTest {
		
	TestSetup testSetup;
	//private String newCustomerName;
	public VMM_3367_Customer_Create_a_new_Customer(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	

//	  @Then("I Navigate to Operations")
//    public void i_navigate_to_operations() {
//    	test = logInfo.get().createNode("I Navigate to Operations");
//    	testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
//    	reportInfo("I Navigate to operation page successfully");
//    	
//    }
   
	@Then("I Navigate to Customers")
	public void i_navigate_to_customers() {
		test = logInfo.get().createNode("I Navigate to Customers");
		testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
		testSetup.pageObjectManager.getHomePage().navigateToCustomerTab();
    	reportInfo("navigate to customer page successfully");
	    
	}
	
	@Then("I Creat a New Customer {string}") 
	public void i_creat_a_new_customer_vmm3367(String tcid) throws Exception {
		try {
		
		test = logInfo.get().createNode("I Creat a New Customer");
		test.assignCategory("Others");
		
		testSetup.pageObjectManager.getCustomerPage().clicknewbutton();
		
		String tenantID=randomStringGenerator();  
		 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"CustomerPage","Name",tenantID,"VMM3367_1"); 
		 
		 Map<String, String> testData = ExcelFileReader.getDataInMap("CustomerPage", tcid);
	     reportInfo(testData.toString()); 
		 testSetup.pageObjectManager.getCustomerPage().createNewCustomer(testData);
		 testSetup.pageObjectManager.getCustomerPage().ClickOnSave();
		 Thread.sleep(2000);
		 reportScreenshot(testSetup.driver);
		 
		
		/*testSetup.pageObjectManager.getCustomerPage().createNewCustomer(testData);
		testSetup.pageObjectManager.getCustomerPage().ClickOnSave();
		Thread.sleep(2000);
		reportScreenshot(testSetup.driver); */
		
    	reportInfo("I created new customer successfully");   
  
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
		
	}

	
	@When("I Click on view customer data {string}")
	public void i_click_on_view_customer_data(String tcid) {
		try {
		test = logInfo.get().createNode("I Click on view customer data");
		Map<String, String> testData = ExcelFileReader.getDataInMap("CustomerPage", tcid);
		testSetup.pageObjectManager.getCustomerPage().Clickoncustxtfield(testData.get("Name"));
		testSetup.pageObjectManager.getCustomerPage().Clickonview();
		reportScreenshot(testSetup.driver);
		reportInfo("navigate to view customer data successfully"); 
		testSetup.pageObjectManager.getCustomerPage().ClickOnBack();
		}
    	catch(Exception e) {
    		testStepHandle("FAIL", testSetup.driver, test, e);
    	}

	}
	
	
	@Then("I Edit customer data {string}")
	public void i_edit_customer_data_vmm3367(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I Edit customer data");
		Map<String, String> testData = ExcelFileReader.getDataInMap("CustomerPage", tcid);
		testSetup.pageObjectManager.getCustomerPage().Clickoncustxtfield(testData.get("Name"));
		testSetup.pageObjectManager.getCustomerPage().editCustomer(testData.get("edit_Name"));
		reportScreenshot(testSetup.driver);
		reportInfo("edited customer successfully");
    	reportInfo(testData.toString());
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	 
	
	@Then("I Click on Delete {string}") 
	public void i_click_on_delete(String tcid) {
		try {
		test = logInfo.get().createNode("I Click on Delete"); 
		
		
		Map<String, String> testData = ExcelFileReader.getDataInMap("CustomerPage", tcid);
		 
		String AlertMsg = testSetup.pageObjectManager.getCustomerPage().DeleteCreatedCustomer(testData);
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
		
		
		/*testSetup.pageObjectManager.getCustomerPage().DeleteCustomer(testData.get("edit_Name"));
		reportScreenshot(testSetup.driver);
		reportInfo("deleted successfully");   */
		}
	
		}
	}  

    	
   

