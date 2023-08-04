package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;

public class VMM_3251_Failure_to_create_device_settings_for_new_device_type extends BaseTest {
		
	TestSetup testSetup;
    
	public VMM_3251_Failure_to_create_device_settings_for_new_device_type(TestSetup testSetup) throws IOException{ 
		this.testSetup=testSetup;
	}

	@Then("I create a new device type with Requires Settings status on with Test data {string}")
	public void i_create_a_new_device_type_with_requires_settings_status_on_with_test_data(String tcid) throws Exception {
		try {
		 test = logInfo.get().createNode("I create a new device type with Requires Settings status on with Test data"+tcid);
		    Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceType",tcid);
		    reportInfo("Test Data "+testData);
		    testSetup.pageObjectManager.getDeviceTypesPage().createNewDeviceType(testData); 
		}
		catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e); 
		}
	}
	
	@Then("I delete device setting {string}")
	public void i_delete_device_setting(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I delete the device setting");
		
		Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
		reportInfo(testData.toString());
		testSetup.pageObjectManager.getHomePage().navigateToDeviceSettingsTab();
		testSetup.pageObjectManager.getDeviceSettingsPage().checkFilter1(testData);
		String alert = testSetup.pageObjectManager.getDeviceSettingsPage().DeleteDeviceSetting1();
		reportScreenshot(testSetup.driver);
		if(alert.equalsIgnoreCase("A Settings is deleted with identifier "+testData.get("DeviceName")))
		    reportPass("Alert messaeg", "A Settings is deleted with identifier "+testData.get("DeviceName"), alert);
		else
			reportFail("Alert messaeg", "A Settings is deleted with identifier "+testData.get("DeviceName"), alert); 
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I create and verify Device type on the Device settings with Test data {string}")
	public void i_verify_device_type_on_the_device_settings_with_Test_data(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I verify Device type on the Device settings with Test data"+tcid);
		test.assignCategory("Device Settings");
	    Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage",tcid);
	    reportInfo("Test Data "+testData);
	
	    testSetup.pageObjectManager.getDeviceSettingsPage().createDeviceSetting(testData);
	    reportScreenshot(testSetup.driver);
	    testSetup.pageObjectManager.getDeviceSettingsPage().createDeviceSettingSave(); 
		
		}
		catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	    
	}


	

}
