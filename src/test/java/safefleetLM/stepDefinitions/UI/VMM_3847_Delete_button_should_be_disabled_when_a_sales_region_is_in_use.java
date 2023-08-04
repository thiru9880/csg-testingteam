package safefleetLM.stepDefinitions.UI;

import java.io.IOException;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.TestSetup;

public class VMM_3847_Delete_button_should_be_disabled_when_a_sales_region_is_in_use  extends BaseTest{

	TestSetup testSetup;
    
	public VMM_3847_Delete_button_should_be_disabled_when_a_sales_region_is_in_use(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	
	@Then("I verify delete button of a record for disabled")
	public void i_verify_delete_button_of_a_record_for_disabled() throws Exception {
		
		try 
		{    
			test = logInfo.get().createNode("I verify delete button of a record for disabled");
	    	boolean actual = testSetup.pageObjectManager.getSalesRegionPage().deleteVerifyStepForDisabled();
	    	if(actual == false)
	    	{
	    		reportPass("I verify delete button of a record for disabled", "true", "true");
	    		reportInfo("Verified delete button disabled successfully");
	    		reportScreenshot(testSetup.driver);
	    	}
	    	else
	    	{
	    		reportFail("I couldnt verify delete button of a record for disabled", "false", "false");
	    		reportInfo("Couldnt verify delete button disabled successfully");
	    		reportScreenshot(testSetup.driver);
	    	}
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}	
		
	}
	
	@Then("I verify delete button of a record for enabled")
	public void i_verify_delete_button_of_a_record_for_enabled() throws Exception {
		
		try 
		{    
			test = logInfo.get().createNode("I verify delete button of a record for enabled");
	    	boolean actual = testSetup.pageObjectManager.getSalesRegionPage().deleteVerifyStepForEnabled();
	    	if(actual == true)
	    	{
	    		reportPass("I verify delete button of a record for enabled", "true", "true");
	    		reportInfo("Verified delete button enabled successfully");
	    		reportScreenshot(testSetup.driver);
	    	}
	    	else
	    	{
	    		reportFail("I couldnt verify delete button of a record for enabled", "false", "false");
	    		reportInfo("Couldnt verify delete button enabled successfully");
	    		reportScreenshot(testSetup.driver);
	    	}
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}	
		
	}
	
}
