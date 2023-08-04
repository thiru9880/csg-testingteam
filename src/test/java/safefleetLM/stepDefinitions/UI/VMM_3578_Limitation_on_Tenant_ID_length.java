package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;

public class VMM_3578_Limitation_on_Tenant_ID_length extends BaseTest{

	TestSetup testSetup; 
    
	public VMM_3578_Limitation_on_Tenant_ID_length(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}

	@Then("I create new Tenant and enter required details including Tenant ID more than 20 characters {string}")
	public void i_create_new_tenant_and_enter_required_details_including_tenant_id_more_than_20_characters_something(String tcid) throws Throwable
	{
		try
		{
			test = logInfo.get().createNode("I create new Tenant and enter required details including Tenant ID more than 20 characters");
			test.assignCategory("Tenants");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			testSetup.pageObjectManager.getTenantsPage().createANewTenant(testData);
			reportInfo("Tenant created successfully with required fields");  
			reportScreenshot(testSetup.driver);
		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@And("I verify that system will not let type more than 20 characters for Tenant ID")
	public void i_verify_that_system_will_not_let_type_more_than_20_characters_for_tenant_id() throws Throwable 
	{
		try
		{
			test = logInfo.get().createNode("I verify that system will not let type more than 20 characters for tenant id");
			boolean actual = testSetup.pageObjectManager.getTenantsPage().verifyFilledTenantId();
			if(actual == true)
			{
				reportPass("Tenant id length", "true", "true");
				reportInfo("Tenant id length verified successfully");
				reportScreenshot(testSetup.driver);
			}
			else
			{
				reportFail("Tenant id length not verified", "false", "false");
				reportInfo("Tenant id length not verified successfully");
				reportScreenshot(testSetup.driver);
			}
		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	
}
