package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.TestSetup;

//@SuppressWarnings("unused")
public class VMM_3573_MDT_LTE_device_cant_view extends BaseTest {
	TestSetup testSetup;
    
	public VMM_3573_MDT_LTE_device_cant_view(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}

	@Then("I Navigate to Devices")      
	public void i_navigate_to_devices() {
		try { 
		test = logInfo.get().createNode("I Navigate to Devices");
		testSetup.pageObjectManager.getHomePage().navigateToDevicesTab(); 
    	reportInfo("I Navigate to Devices page successfully");  
		}  
		 catch (Exception e) {
			  testStepHandle("FAIL",testSetup.driver, test, e); 
		} 
	   
	}	  
	@Then("I click on Device Type to filter MDT LTE devices") 
	public void i_click_on_device_type_to_filter_mdt_lte_devices() { 
		try {
		test = logInfo.get().createNode("I click on Device Type to filter MDT LTE devices");
		test.assignCategory("Devices");
		testSetup.pageObjectManager.getCustomerPage().clickOnDeviceType();
		testSetup.pageObjectManager.getCustomerPage().clickOnMTDLTE();
		reportScreenshot(testSetup.driver);
	
		//Select drpDeviceType = new Select(driver.findElement(By.id("devicetype")));
		//drpDeviceType.selectByVisibleText("MDT LTE");
		
	    reportInfo("I click on devicetype of MDT LTE successfully"); 
		}
		 catch (Exception e) { 
			  testStepHandle("FAIL",testSetup.driver, test, e); 
		}
	    
	} 
	@Then("I click on view option")
	public void i_click_on_view_option() {
		try {
		test = logInfo.get().createNode("I click on view option");
		testSetup.pageObjectManager.getCustomerPage().clickOneye(); 
	    reportInfo("I click on view option successfully");
		} 
		 catch (Exception e) {
			  testStepHandle("FAIL",testSetup.driver, test, e);
		}
	     
	}
	@Then("I Verify that MDT LTE device can be viewed without any issues")
	public void i_verify_that_mdt_lte_device_can_be_viewed_without_any_issues() {
		try {
			test = logInfo.get().createNode("I Verify that MDT LTE device can be viewed without any issues");
			testSetup.pageObjectManager.getCustomerPage().gettext();
			
			
			String VerifyViewDevice =testSetup.pageObjectManager.getCustomerPage().VerifyViewDevice();
				if(VerifyViewDevice.equalsIgnoreCase("View Device"))
		    	{
		    		reportPass("Successfully navigate to view device page with MDT_LTE device type", "View Device", VerifyViewDevice);
		    	}
		    	else {
		    		reportFail("Not Successfully navigate to view device page", "View Device", VerifyViewDevice);
		    	}
				reportScreenshot(testSetup.driver);
				reportInfo("I verify that MDT LTE device can view successfully");
			
		}  
		 catch (Exception e) {  
			  testStepHandle("FAIL",testSetup.driver, test, e);
		}
	
}
}