package safefleetLM.stepDefinitions.UI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

import java.io.IOException;
import java.util.Map;

public class VMM_3736_Editing_tenant_deployment_type_after_license_creation_is_messing_up_the_software_license extends BaseTest{

	TestSetup testSetup;

	public VMM_3736_Editing_tenant_deployment_type_after_license_creation_is_messing_up_the_software_license(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}

    @Then("I create a Tenant with cloud deployment type {string}")
    public void i_create_a_tenant_with_cloud_deployment_type_something(String tcid) throws Throwable
    {
    	try
		{
    		String tenantID=randomStringGenerator();
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM3736_1");
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM3736_1");
    		test = logInfo.get().createNode("I create a Tenant with cloud deployment type {string}");
			test.assignCategory("Tenants");
    		Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			//testSetup.pageObjectManager.getTenantsPage().createANewTenant(testData);
      testSetup.pageObjectManager.getTenantsPage().createNewTenantSyncToTMOFF(testData);
			testSetup.pageObjectManager.getTenantsPage().clickOnSaveButtonn();
			reportInfo("Created Tenant with required cloud deployement successfully");
			reportScreenshot(testSetup.driver);
		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
    }

    @Then("I create an APP License for the Tenant created above for any software {string}")
    public void i_create_an_app_license_for_the_tenant_created_above_for_any_software(String tcid) throws Throwable
    {
    	try
		{
			test = logInfo.get().createNode("I create an APP license for the tenant created above for any software");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			testSetup.pageObjectManager.getLicensesPage().createAppLicenseOnly(testData);
			reportInfo("I created an APP License for the Tenant created above for any software successfully");
			reportScreenshot(testSetup.driver);
		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
    }

    @Then("I search for Tenant created above and when found click on edit button {string}")
    public void i_search_for_tenant_created_above_and_when_found_click_on_edit_button(String tcid) throws Throwable
    {
    	try
		{
			test = logInfo.get().createNode("I search for Tenant created above and when found click on edit button");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			testSetup.pageObjectManager.getTenantsPage().filterTenantByID(testData);
			reportInfo("I searched for tenant created above and when found click on edit button successfully");
			reportScreenshot(testSetup.driver);
		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
    }

    @And("I verify that the system prevents editing the Tenant deployment type to Onsite as there are already Licenses created for it")
    public void i_verify_that_the_system_prevents_editing_the_tenant_deployment_type_to_onsite_as_there_are_already_licenses_created_for_it() throws Throwable
    {
    	try
		{
			test = logInfo.get().createNode("I verify that the system prevents editing the Tenant deployment type to Onsite as there are already Licenses created for it");
			boolean actual = testSetup.pageObjectManager.getTenantsPage().editableOrNotEditableDeploymentType();
			if(actual == true)
			{
				reportPass("The system prevents editing the Tenant deployment type to Onsite as there are already Licenses created for it", "true", "true");
				reportInfo("I successfully verified the system prevents editing the Tenant deployment type to Onsite as there are already licenses created for it");
				reportScreenshot(testSetup.driver);
			}
			else
			{
				reportFail("The system does not prevents editing the Tenant deployment type to Onsite as there are already Licenses created for it", "false", "false");
				reportInfo("I havent successfully verified the system prevents editing the Tenant deployment type to Onsite as there are already Licenses created for it");
				reportScreenshot(testSetup.driver);
			}
		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
    }

}
