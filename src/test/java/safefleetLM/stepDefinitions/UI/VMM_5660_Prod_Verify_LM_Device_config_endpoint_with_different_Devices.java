package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_5660_Prod_Verify_LM_Device_config_endpoint_with_different_Devices extends BaseTest {

	TestSetup testSetup;
	ArrayList<String> expListOfDeviceTypes;
	String env = getProperty("Environment");

	public VMM_5660_Prod_Verify_LM_Device_config_endpoint_with_different_Devices(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}

	@Then("I search and save a valid Device Id not assigned to a Tenant {string}")
	public void i_search_and_save_a_valid_device_id_not_assigned_to_a_tenant(String tcid) {
		try {
			test = logInfo.get().createNode("I search and save a valid Device Id not assigned to a Tenant");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			testSetup.pageObjectManager.getDevicePage().searchDevicesWithTwoCondition(testData);
			reportScreenshot(testSetup.driver);
			String deviceId = testSetup.pageObjectManager.getDevicePage().getDeviceId();
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"ProductionData","DeviceID",deviceId,"VMM_5660_3");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"ProductionData","DeviceID",deviceId,"VMM_5661_3");
			testSetup.pageObjectManager.getDevicePage().clickOnClearr();
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I hit device config endpoint and verify response for production valid Device Id having settings enabled {string}")
	public void i_hit_device_config_endpoint_production_valid_device_id_having_settings_enabled(String tcid) {

		try {
			test = logInfo.get().createNode("I hit device config endpoint and verify response for production valid Device Id having settings enabled");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			reportInfo(testData.toString());
			String actResponse = testSetup.pageObjectManager.getDevicePage().hitDeviceConfigEndpoint(testData,env);
			reportScreenshot(testSetup.driver);

			if(	actResponse.contains("{\"info\":\"Device certificate not found\"}") ||
					actResponse.contains("{\"data\":\""))
			{
				reportPass("Verified device config endpoint response details for production valid Device Id having settings enabled", "{\"info\":\"Device certificate not found\"}", actResponse);

			}
			else {
				reportFail("Verified device config endpoint response details for production valid Device Id having settings enabled", "{\"info\":\"Device certificate not found\"}", actResponse);
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I hit device config endpoint and verify response for production valid Device Id having settings disabled {string}")
	public void i_hit_device_config_endpoint_production_valid_device_id_having_settings_disabled(String tcid) {

		try {
			test = logInfo.get().createNode("I hit device config endpoint and verify response for production valid Device Id having settings disabled");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			reportInfo(testData.toString());
			String actResponse = testSetup.pageObjectManager.getDevicePage().hitDeviceConfigEndpoint(testData,env);
			reportScreenshot(testSetup.driver);

			if(	actResponse.contains("{\"info\":\"Device certificate not found\"}") ||
					actResponse.contains("{\"data\":\""))
			{
				reportPass("Verified device config endpoint response details for production valid Device Id having settings disabled", "{\"info\":\"Device certificate not found\"}", actResponse);

			}
			else {
				reportFail("Verified device config endpoint response details for production valid Device Id having settings disabled", "{\"info\":\"Device certificate not found\"}", actResponse);
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I hit device config endpoint and verify response for production valid Device Id not assigned to a Tenant {string}")
	public void i_hit_device_config_endpoint_production_valid_device_id_not_assigned_to_a_tenant(String tcid) {

		try {
			test = logInfo.get().createNode("I hit device config endpoint and verify response for production valid Device Id not assigned to a Tenant");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			reportInfo(testData.toString());
			String actResponse = testSetup.pageObjectManager.getDevicePage().hitDeviceConfigEndpoint(testData,env);
			reportScreenshot(testSetup.driver);

			if(	actResponse.contains("{\"info\":\"Device with deviceId:"+testData.get("DeviceID")+" not assigned to a tenant\"}"))
      {
				reportPass("Verified device config endpoint response details for production valid Device Id not assigned to a Tenant", "{\"info\":\"Device with deviceId:"+testData.get("DeviceID")+" not assigned to a tenant\"}", actResponse);

			}
			else {
				reportFail("Verified device config endpoint response details for production valid Device Id not assigned to a Tenant", "{\"info\":\"Device with deviceId:"+testData.get("DeviceID")+" not assigned to a tenant\"}", actResponse);
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I hit device config endpoint and verify response for production invalid Device Id {string}")
	public void i_hit_device_config_endpoint_production_invalid_device_id(String tcid) {
		String fallbackEnv = null;
		try {
			test = logInfo.get().createNode("I hit device config endpoint and verify response for production invalid Device Id");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			reportInfo(testData.toString());
			String actResponse = testSetup.pageObjectManager.getDevicePage().hitDeviceConfigEndpoint(testData,env);
			String navigatedUrl = testSetup.pageObjectManager.getDevicePage().getTheCurrentUrl();
			reportScreenshot(testSetup.driver);

			if(env.equals("PROD"))
				fallbackEnv = "stg";
			if(env.equals("STG"))
				fallbackEnv = "test";
			if(env.equals("TEST"))
				fallbackEnv = "dev";


			if(	navigatedUrl.contains("https://"+fallbackEnv+".safefleetcloud.com/deviceConfig/"+testData.get("DeviceID")) ||
					actResponse.contains("{\"info\":\"status 404:fallbackConfigEndpoint url NOT available\"}"))
			{
				reportPass("Verified device config endpoint response details for production invalid Device Id", "https://"+fallbackEnv+".safefleetcloud.com/deviceConfig/"+testData.get("DeviceID"), navigatedUrl);
				reportPass("Verified device config endpoint response details for production invalid Device Id", "Pass", actResponse);

			}
			else {
				reportFail("Verified device config endpoint response details for production invalid Device Id", "https://"+fallbackEnv+".safefleetcloud.com/deviceConfig/"+testData.get("DeviceID"), navigatedUrl);
				reportFail("Verified device config endpoint response details for production invalid Device Id", "Fail", actResponse);

			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	}
