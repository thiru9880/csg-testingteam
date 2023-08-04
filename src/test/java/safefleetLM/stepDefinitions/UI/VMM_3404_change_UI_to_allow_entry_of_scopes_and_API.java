package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.DBConnection;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;

public class VMM_3404_change_UI_to_allow_entry_of_scopes_and_API extends BaseTest{

	TestSetup testSetup;
	Object idType;
	
	public VMM_3404_change_UI_to_allow_entry_of_scopes_and_API(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	
	@Then("I use existing License Type {string} for slot type validation")
    public void i_use_exisiting_license_type_something_for_slot_type_validation(String tcid) throws Throwable 
	{
		try
		{
			test = logInfo.get().createNode("I use exisiting License Type for slot type validation");
			test.assignCategory("License Types");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicenseTypePage", tcid);
			reportInfo(testData.toString());
			List<Map<String, ?>> res = DBConnection.getData("SELECT * FROM test_license_manager.slot_type where slot_type='"+testData.get("LicenseType")+"' and sync_tenant_manager="+testData.get("syncTenantManager")+" and software_id="+testData.get("softwareID")+";");
			System.out.println("SELECT * FROM test_license_manager.slot_type where slot_type='"+testData.get("LicenseType")+"' and sync_tenant_manager="+testData.get("syncTenantManager")+" and software_id="+testData.get("softwareID")+";");
			Object slotType = res.get(0).get("SLOT_TYPE");
			idType = res.get(0).get("ID");
			String slotTypeName = slotType.toString();
			System.out.println(slotTypeName+"=="+testData.get("LicenseType"));
			if(slotTypeName.equals(testData.get("LicenseType")))
			{
				reportPass("License Type used for slot type validation successfully", "true", "true");
				reportInfo("License Type used for slot type validation successfully");
				reportScreenshot(testSetup.driver);
			}
			else
			{
				reportFail("License Type not used for slot type validation successfully", "false", "false");
				reportInfo("License Type not used for slot type validation successfully");
				reportScreenshot(testSetup.driver);
			}
		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
    }
	
	@Then("I use existing License Type {string} for slot type scope validation")
	public void i_use_existing_License_Type_something_for_slot_type_scope_validation(String tcid)
	{
		try
		{
			test = logInfo.get().createNode("I use existing License Type for slot type scope validation");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicenseTypePage", tcid);
			reportInfo(testData.toString());
			String idTypeName = idType.toString();
			List<Map<String, ?>> res = DBConnection.getData("SELECT * FROM test_license_manager.slot_type_scope where slot_type_id='"+idTypeName+"';");
			Object slotType = res.get(0).get("SLOT_TYPE_ID");
			String slotTypeName = slotType.toString();
			System.out.println(slotTypeName+"=="+idTypeName);
			if(slotTypeName.equals(idTypeName))
			{
				reportPass("License Type used for slot type scope validation successfully", "true", "true");
				reportInfo("License Type used for slot type scope validation successfully");
				reportScreenshot(testSetup.driver);
			}
			else
			{
				reportFail("License Type not used for slot type scope validation successfully", "false", "false");
				reportInfo("License Type not used for slot type scope validation successfully");
				reportScreenshot(testSetup.driver);
			}
		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I use existing License Type {string} for scope validation")
	public void i_use_existing_license_type_something_for_scope_validation(String tcid)
	{
		try
		{
			test = logInfo.get().createNode("I use existing License Type for scope validation");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicenseTypePage", tcid);
			reportInfo(testData.toString());
			List<Map<String, ?>> res = DBConnection.getData("SELECT * FROM test_license_manager.scope where resource_name='"+testData.get("resourceName")+"';");
			Object slotType = res.get(0).get("RESOURCE_NAME");
			String slotTypeName = slotType.toString();
			System.out.println(slotTypeName+"=="+testData.get("resourceName"));
			if(slotTypeName.equals(testData.get("resourceName")))
			{
				reportPass("License Type used for scope validation successfully", "true", "true");
				reportInfo("License Type used for scope validation successfully");
				reportScreenshot(testSetup.driver);
			}
			else
			{
				reportFail("License Type not used for scope validation successfully", "false", "false");
				reportInfo("License Type not used for scope validation successfully");
				reportScreenshot(testSetup.driver);
			}
		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	
	@Then("I unassign resources for License Type for validation {string}")
	public void i_delete_license_type_for_validation_something(String tcid)
	{
		try
		{
			test = logInfo.get().createNode("I unassign resources for License Type for validation");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicenseTypePage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
			testSetup.pageObjectManager.getHomePage().navigateToLicenseTypesTab();
			testSetup.pageObjectManager.getLicenseTypePage().searchAndUnassignResourcesToLicenseType(testData);
			String idTypeName = idType.toString();
			List<Map<String, ?>> result = DBConnection.getData("SELECT * FROM test_license_manager.slot_type_scope where slot_type_id='"+idTypeName+"';");
			if(result.size() == 0)
			{
				reportPass("License Type deleted and validated successfully", "true", "true");
				reportInfo("License Type deleted and validated successfully");
				reportScreenshot(testSetup.driver);
			}
			else
			{
				reportFail("License Type not deleted and validated successfully", "false", "false");
				reportInfo("License Type not deleted and validated successfully");
				reportScreenshot(testSetup.driver);
			}
			testSetup.pageObjectManager.getLicenseTypePage().searchAndAssignResourcesAgainToLicenseType(testData);
		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	
}
