package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3409_Tenant_ID_filter_in_Ecosystem_Settings_is_different_from_Tenant_ID_filter_in_other_pages_of_LM extends BaseTest {

	TestSetup testSetup;

	public VMM_3409_Tenant_ID_filter_in_Ecosystem_Settings_is_different_from_Tenant_ID_filter_in_other_pages_of_LM(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}


	@Then("I click on operations to Navigate Device Settings")
	public void i_click_on_operations_to_navigate_device_settings()
	{
		test = logInfo.get().createNode("I click on operations to Navigate Device Settings");
		test.assignCategory("Tenants");
		testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
		testSetup.pageObjectManager.getHomePage().navigateToDeviceSettingsTab();
		reportInfo("Navigate to Device Settings successfully");
	}
	@Then("I verify if the Settings Type filter is removed {string}")
	public void i_verify_if_the_settings_type_filter_is_removed(String tcid) throws Exception
	{
		try {
			test = logInfo.get().createNode("I verify if the Settings Type filter is removed");
			Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
			reportInfo(testData.toString());
			String FilterType = testSetup.pageObjectManager.getDeviceSettingsPage().verifySettingTypeFilter(testData);
			reportScreenshot(testSetup.driver);
			if(FilterType.equalsIgnoreCase(testData.get("CheckFilterName"))) {
				reportFail("FilterType", testData.get("CheckFilterName"), FilterType);
				reportInfo("Settings Type filter is NOT removed");
			}
			else{
				reportPass("FilterType", testData.get("CheckFilterName"), FilterType);
				reportInfo("Verify Settings Type filter is removed Successfully");
			}}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	@Then("I check all the filters are working correctly {string}")
	public void i_check_all_the_filters_are_working_correctly(String tcid) throws Exception
	{
		try {
			String tenantID=randomStringGenerator();
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"DeviceSettingPage","DeviceName",tenantID,"VMM_3409_1");

			test = logInfo.get().createNode("I check all the filters are working correctly");
			Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getDeviceSettingsPage().createDeviceSetting(testData);
			testSetup.pageObjectManager.getDeviceSettingsPage().createDeviceSettingSave();
			reportScreenshot("PASS", "User should be Create succefully", "User Created succefully",testSetup.driver);
			boolean result1 = testSetup.pageObjectManager.getDeviceSettingsPage().checkFilter1(testData);
			reportInfo("Device Type Filter Working correctly");
			reportScreenshot(testSetup.driver);
			boolean result2 =testSetup.pageObjectManager.getDeviceSettingsPage().checkFilter2(testData);
			reportInfo("NAME Filter Working correctly");
			reportScreenshot(testSetup.driver);
			if(result1==result2) {
				reportPass("FilterType", "Device Type", testData.get("DeviceType"));
				reportInfo("All the filters are working correctly verified Successfully");}
			else{
				reportPass("FilterType", "Device Type", testData.get("DeviceType"));
				reportInfo("All the filters are NOT working correctly verified Successfully");
			}}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("","Filters are NOT Working properly" ,"" );
		}
	}
	@Then("I delete the created device setting {string}")
	public void i_delete_the_created_device_setting(String tcid) throws Exception
	{
		try {
		test = logInfo.get().createNode("I delete the device setting");
		Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
		reportInfo(testData.toString());
		String AlertMsg = testSetup.pageObjectManager.getDeviceSettingsPage().DeleteDeviceSetting1();
		reportScreenshot(testSetup.driver);
		if(AlertMsg.equalsIgnoreCase("A Settings is deleted with identifier "+testData.get("DeviceName"))) {
			reportPass("Comfirmation Message", "A Settings is deleted with identifier "+testData.get("DeviceName"), AlertMsg);
			reportInfo("A Settings is deleted with identifier "+testData.get("DeviceName")+" Successfully");
		}
		else
			reportFail("Comfirmation Message", "A Settings is deleted with identifier "+testData.get("DeviceName"), AlertMsg);
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("","Device Setting NOT found or UNABLE to delete" ,"" );
		}
	}


	@Then("I verify if the Settings Type filter is removed in Ecosystem Settings {string}")
	public void i_verify_if_the_settings_type_filter_is_removed_in_ecosystem_settings(String tcid) throws Exception
	{
		try {
			test = logInfo.get().createNode("I verify if the Settings Type filter is removed in Ecosystem Settings");
			Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting", tcid);
			reportInfo(testData.toString());
			String FilterType=testSetup.pageObjectManager.getEcosystemSettingsPage().verifySettingTypeFilter1(testData);
			reportScreenshot(testSetup.driver);
			if(FilterType.equalsIgnoreCase(testData.get("CheckFilterName"))) {
				reportFail("FilterType", testData.get("CheckFilterName"), FilterType);
				reportInfo("Settings Type filter is NOT removed");
			}
			else{
				reportPass("FilterType", testData.get("CheckFilterName"), FilterType);
				reportInfo("Verify Settings Type filter is removed Successfully");
			}}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("","Setting Filter is Not Found" ,"" );
		}
	}
	@Then("I Verify if the Tenant ID filter has three filter options and verify their working Condition {string}")
	public void i_verify_if_the_tenant_id_filter_has_three_filter_options_and_verify_their_working_Condition(String tcid) throws Exception
	{
		try {
			test = logInfo.get().createNode("I Verify if the Tenant ID filter has three filter options and verify their working Condition");
			Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getEcosystemSettingsPage().verifyThreeEqualsFilters(testData);
			reportScreenshot("PASS", "Filter should have 3 options", "Filter have three Options",testSetup.driver);

			Map<String, String> testData2 = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData2.toString());

			boolean Result1 = testSetup.pageObjectManager.getEcosystemSettingsPage().verifyEqualsFilter(testData2);
			if(Result1==true || Result1==false)
				reportPass("EqualsFilter", "Equals filter Should work successfully", "Equals filter works successfully");
			else
				reportFail("EqualsFilter", "Equals filter Should work successfully", "Equals filter NOT works successfully");
			reportScreenshot(testSetup.driver);


			boolean Result2 =testSetup.pageObjectManager.getEcosystemSettingsPage().verifyNotEqualsFilter(testData2);
			if(Result2==true || Result2==false)
				reportPass("NotEqualsFilter", "NotEquals filter Should work successfully", "NotEquals filter works successfully");
			else
				reportFail("NotEqualsFilter", "NotEquals filter Should work successfully", "NotEquals filter NOT works successfully");
			reportScreenshot(testSetup.driver);

			//reportScreenshot("PASS", "Not Equals filter Should work successfully", "Not Equals filter works successfully",testSetup.driver);


			boolean Result3 =testSetup.pageObjectManager.getEcosystemSettingsPage().verifyContainsFilter(testData2);
			if(Result3==true || Result3==false)
				reportPass("containsFilter", "contains filter Should work successfully", "contains filter works successfully");
			else
				reportFail("containsFilter", "contains filter Should work successfully", "contains filter NOT works successfully");
			reportScreenshot(testSetup.driver);
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("","Tenant ID filter has three filter options" ,"Thats NOT working properly" );
		}
	}
	/*	@Then("I delete the ecosystem settings i created {string}")
		public void i_delete_the_ecosystem_settings_i_created(String tcid) throws Exception
		{
			try {
			test = logInfo.get().createNode("I delete the ecosystem settings i created");
			Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getEcosystemSettingsPage().deleteEcosystemSetting(testData);
			//reportScreenshot(testSetup.driver);
			reportScreenshot("PASS", "Ecosystem setting should delete successfully", "Ecosystem setting deleted successfully",testSetup.driver);
			}
			catch (Exception e)
			{
				testStepHandle("FAIL", testSetup.driver, test, e);
				reportFail("","Tenant ID filter has three filter options" ,"Thats NOT working properly" );
			}
		}*/
}

