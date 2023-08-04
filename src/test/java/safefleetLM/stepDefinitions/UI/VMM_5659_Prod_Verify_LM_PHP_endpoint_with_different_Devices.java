package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_5659_Prod_Verify_LM_PHP_endpoint_with_different_Devices extends BaseTest {

	TestSetup testSetup;

	String env = getProperty("Environment");

	public VMM_5659_Prod_Verify_LM_PHP_endpoint_with_different_Devices(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}

	@Then("I search and save a valid Device Id having settings enabled {string}")
	public void i_search_and_save_a_valid_device_id_having_settings_enabled(String tcid) {
		try {
			test = logInfo.get().createNode("I search and save a valid Device Id having settings enabled");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			testSetup.pageObjectManager.getDevicePage().clickOnShowFilter();
			testSetup.pageObjectManager.getDevicePage().searchDevicesWithTwoCondition(testData);
			reportScreenshot(testSetup.driver);
			String deviceId = testSetup.pageObjectManager.getDevicePage().getDeviceId();
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"ProductionData","DeviceID",deviceId,"VMM_5659_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"ProductionData","DeviceID",deviceId,"VMM_5660_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"ProductionData","DeviceID",deviceId,"VMM_5661_1");
			testSetup.pageObjectManager.getDevicePage().clickOnClearr();
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I search and save a valid Device Id having settings disabled {string}")
	public void i_search_and_save_a_valid_device_id_having_settings_disabled(String tcid) {
		try {
			test = logInfo.get().createNode("I search and save a valid Device Id having settings disabled");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			testSetup.pageObjectManager.getDevicePage().searchDevicesWithTwoCondition(testData);
			reportScreenshot(testSetup.driver);
			String deviceId = testSetup.pageObjectManager.getDevicePage().getDeviceId();
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"ProductionData","DeviceID",deviceId,"VMM_5659_2");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"ProductionData","DeviceID",deviceId,"VMM_5660_2");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"ProductionData","DeviceID",deviceId,"VMM_5661_2");
			testSetup.pageObjectManager.getDevicePage().clickOnClearr();
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}


	@Then("I hit PHP endpoint and verify response for production valid Device Id having settings enabled {string}")
	public void i_hit_php_endpoint_production_valid_device_id_having_settings_enabled(String tcid) {

		try {
			test = logInfo.get().createNode("I hit PHP endpoint and verify response for production valid Device Id having settings enabled");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			reportInfo(testData.toString());
			String actResponse = testSetup.pageObjectManager.getDevicePage().hitPHPEndpoint(testData,env);
			reportScreenshot(testSetup.driver);

			if(env.equals("TEST"))
			{
			if(	actResponse.contains("hostip=api.test-cluster.test.k8s.seon.com") &&
					actResponse.contains("hostport=") &&
					actResponse.contains("msgtimer=") &&
					actResponse.contains("postimer=") &&
					actResponse.contains("ackmsgto=") &&
					actResponse.contains("cfgsrvport="))
			{
				reportPass("Verified PHP endpoint response details for production valid Device Id having settings enabled", "hostip=api.test-cluster.test.k8s.seon.com", actResponse);

			}
			else {
				reportFail("Verified PHP endpoint response details for production valid Device Id having settings enabled", "hostip=api.test-cluster.test.k8s.seon.com", actResponse);
			}
			}
			else if(env.equals("STG"))
			{
			if(	actResponse.contains("hostip=api.stg-cluster.stg.k8s.seon.com") &&
					actResponse.contains("hostport=") &&
					actResponse.contains("msgtimer=") &&
					actResponse.contains("postimer=") &&
					actResponse.contains("ackmsgto=") &&
					actResponse.contains("cfgsrvport="))
			{
				reportPass("Verified PHP endpoint response details for production valid Device Id having settings enabled", "hostip=api.stg-cluster.stg.k8s.seon.com", actResponse);

			}
			else {
				reportFail("Verified PHP endpoint response details for production valid Device Id having settings enabled", "hostip=api.stg-cluster.stg.k8s.seon.com", actResponse);
			}
			}

			else if(env.equals("PROD"))
			{
			if(	actResponse.contains("hostip=devices.seon.com") &&
					actResponse.contains("hostport=") &&
					actResponse.contains("msgtimer=") &&
					actResponse.contains("postimer=") &&
					actResponse.contains("ackmsgto=") &&
					actResponse.contains("cfgsrvport="))
			{
				reportPass("Verified PHP endpoint response details for production valid Device Id having settings enabled", "hostip=api.cluster.k8s.seon.com", actResponse);

			}
			else {
				reportFail("Verified PHP endpoint response details for production valid Device Id having settings enabled", "hostip=api.cluster.k8s.seon.com", actResponse);
			}
			}


		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I hit PHP endpoint and verify response for production valid Device Id having settings disabled {string}")
	public void i_hit_php_endpoint_production_valid_device_id_having_settings_disabled(String tcid) {

		try {
			test = logInfo.get().createNode("I hit PHP endpoint and verify response for production valid Device Id having settings disabled");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			reportInfo(testData.toString());
			String actResponse = testSetup.pageObjectManager.getDevicePage().hitPHPEndpoint(testData,env);
			reportScreenshot(testSetup.driver);

			if(env.equals("TEST"))
			{
			if(	actResponse.contains("cfgserverip=00.00.00.000") &&
					actResponse.contains("cfgservername=test-license-manager.safefleetcloud.us") &&
					actResponse.contains("hostip=000.000.000.000") &&
					actResponse.contains("hostport=0") &&
					actResponse.contains("msgtimer=0") &&
					actResponse.contains("posttimer=0") &&
					actResponse.contains("odotimer=0"))
			{
				reportPass("Verified PHP endpoint response details for production valid Device Id having settings disabled ", "cfgservername=test-license-manager.safefleetcloud.us", actResponse);

			}
			else {
				reportFail("Verified PHP endpoint response details for production valid Device Id having settings disabled ", "cfgservername=test-license-manager.safefleetcloud.us", actResponse);
			}
			}
			else if(env.equals("STG"))
			{
			if(	actResponse.contains("cfgserverip=00.00.00.000") &&
					actResponse.contains("cfgservername=stg-license-manager.safefleetcloud.us") &&
					actResponse.contains("hostip=000.000.000.000") &&
					actResponse.contains("hostport=0") &&
					actResponse.contains("msgtimer=0") &&
					actResponse.contains("posttimer=0") &&
					actResponse.contains("odotimer=0"))
			{
				reportPass("Verified PHP endpoint response details for production valid Device Id having settings disabled ", "cfgservername=stg-license-manager.safefleetcloud.us", actResponse);

			}
			else {
				reportFail("Verified PHP endpoint response details for production valid Device Id having settings disabled ", "cfgservername=stg-license-manager.safefleetcloud.us", actResponse);
			}
			}
			else if(env.equals("PROD"))
			{
			if(	actResponse.contains("cfgserverip=00.00.00.000") &&
					actResponse.contains("cfgservername=prod-license-manager.safefleetcloud.us") &&
					actResponse.contains("hostip=000.000.000.000") &&
					actResponse.contains("hostport=0") &&
					actResponse.contains("msgtimer=0") &&
					actResponse.contains("posttimer=0") &&
					actResponse.contains("odotimer=0"))
			{
				reportPass("Verified PHP endpoint response details for production valid Device Id having settings disabled ", "cfgservername=license-manager.safefleetcloud.us", actResponse);

			}
			else {
				reportFail("Verified PHP endpoint response details for production valid Device Id having settings disabled ", "cfgservername=license-manager.safefleetcloud.us", actResponse);
			}
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I hit PHP endpoint and verify response for production invalid & Staging valid Device Id having settings enabled {string}")
	public void i_hit_php_endpoint_production_invalid_and_staging_valid_device_id_having_settings_enabled(String tcid) {

		try {
			test = logInfo.get().createNode("I hit PHP endpoint and verify response for production invalid & Staging valid Device Id having settings enabled");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			reportInfo(testData.toString());
			String actResponse = testSetup.pageObjectManager.getDevicePage().hitPHPEndpoint(testData,env);
			reportScreenshot(testSetup.driver);

			if(env.equals("TEST"))
			{
				if(	actResponse.contains("cfgserverip=00.00.00.000") &&
						actResponse.contains("cfgservername=dev-license-manager.safefleetcloud.com") &&
						actResponse.contains("hostip=000.000.000.000") &&
						actResponse.contains("hostport=0") &&
						actResponse.contains("msgtimer=0") &&
						actResponse.contains("posttimer=0") &&
						actResponse.contains("odotimer=0"))
			{
				reportPass("Verified PHP endpoint response details for production invalid & Staging valid Device Id having settings enabled ", "dev-license-manager.safefleetcloud.com", actResponse);

			}
			else {
				reportFail("Verified PHP endpoint response details for production invalid & Staging valid Device Id having settings enabled ", "dev-license-manager.safefleetcloud.com", actResponse);
			}
			}
			else if(env.equals("STG"))
			{
				if(	actResponse.contains("cfgserverip=00.00.00.000") &&
						actResponse.contains("cfgservername=vmaxlive.net") &&
						actResponse.contains("hostip=000.000.000.000") &&
						actResponse.contains("hostport=0") &&
						actResponse.contains("msgtimer=0") &&
						actResponse.contains("posttimer=0") &&
						actResponse.contains("odotimer=0"))
				{
					reportPass("Verified PHP endpoint response details for production invalid & Staging valid Device Id having settings enabled ", "vmaxlive.net", actResponse);

				}
				else {
					reportFail("Verified PHP endpoint response details for production invalid & Staging valid Device Id having settings enabled ", "vmaxlive.net", actResponse);
				}
				}
			else if(env.equals("PROD"))
			{
				if(	actResponse.contains("cfgserverip=00.00.00.000") &&
						actResponse.contains("cfgservername=stg-license-manager.safefleetcloud.com") &&
						actResponse.contains("hostip=000.000.000.000") &&
						actResponse.contains("hostport=0") &&
						actResponse.contains("msgtimer=0") &&
						actResponse.contains("posttimer=0") &&
						actResponse.contains("odotimer=0"))
				{
					reportPass("Verified PHP endpoint response details for production invalid & Staging valid Device Id having settings enabled ", "stg-license-manager.safefleetcloud.com", actResponse);

				}
				else {
					reportFail("Verified PHP endpoint response details for production invalid & Staging valid Device Id having settings enabled ", "stg-license-manager.safefleetcloud.com", actResponse);
				}
				}
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I hit PHP endpoint and verify response for production invalid & Staging invalid Device Id {string}")
	public void i_hit_php_endpoint_production_invalid_and_staging_invalid_device_id(String tcid) {

		try {
			test = logInfo.get().createNode("I hit PHP endpoint and verify response for production invalid & Staging invalid Device Id");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			reportInfo(testData.toString());
			String actResponse = testSetup.pageObjectManager.getDevicePage().hitPHPEndpoint(testData,env);
			reportScreenshot(testSetup.driver);

			if(env.equals("TEST"))
			{
			if(	actResponse.contains("cfgserverip=00.00.00.000") &&
					actResponse.contains("cfgservername=dev-license-manager.safefleetcloud.com") &&
					actResponse.contains("hostip=000.000.000.000") &&
					actResponse.contains("hostport=0") &&
					actResponse.contains("msgtimer=0") &&
					actResponse.contains("posttimer=0") &&
					actResponse.contains("odotimer=0"))
			{
				reportPass("Verified PHP endpoint response details for production invalid & Staging invalid Device Id", "dev-license-manager.safefleetcloud.com", actResponse);

			}
			else {
				reportFail("Verified PHP endpoint response details for production invalid & Staging invalid Device Id", "dev-license-manager.safefleetcloud.com", actResponse);

			}
			}
			else if(env.equals("STG"))
			{
				if(	actResponse.contains("cfgserverip=00.00.00.000") &&
						actResponse.contains("cfgservername=vmaxlive.net") &&
						actResponse.contains("hostip=000.000.000.000") &&
						actResponse.contains("hostport=0") &&
						actResponse.contains("msgtimer=0") &&
						actResponse.contains("posttimer=0") &&
						actResponse.contains("odotimer=0"))
				{
					reportPass("Verified PHP endpoint response details for production invalid & Staging invalid Device Id", "cfgservername=vmaxlive.net", actResponse);

				}
				else {
					reportFail("Verified PHP endpoint response details for production invalid & Staging invalid Device Id", "cfgservername=vmaxlive.net", actResponse);

				}
				}
			else if(env.equals("PROD"))
			{
				if(	actResponse.contains("cfgserverip=00.00.00.000") &&
						actResponse.contains("cfgservername=stg-license-manager.safefleetcloud.com") &&
						actResponse.contains("hostip=000.000.000.000") &&
						actResponse.contains("hostport=0") &&
						actResponse.contains("msgtimer=0") &&
						actResponse.contains("posttimer=0") &&
						actResponse.contains("odotimer=0"))
				{
					reportPass("Verified PHP endpoint response details for production invalid & Staging invalid Device Id", "stg-license-manager.safefleetcloud.com", actResponse);

				}
				else {
					reportFail("Verified PHP endpoint response details for production invalid & Staging invalid Device Id", "stg-license-manager.safefleetcloud.com", actResponse);

				}
				}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	}
