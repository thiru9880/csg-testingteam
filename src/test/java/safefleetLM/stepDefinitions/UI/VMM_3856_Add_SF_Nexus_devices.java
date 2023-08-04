package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;

public class VMM_3856_Add_SF_Nexus_devices extends BaseTest {

	TestSetup testSetup;
	public VMM_3856_Add_SF_Nexus_devices(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	@Then("I navigate to Device Types tab")
	public void i_navigate_to_device_types_tab() {
		test = logInfo.get().createNode("I navigate to Device Types tab");
		testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
		testSetup.pageObjectManager.getHomePage().navigateToDeviceTypeTab();
		reportInfo("User navigated to DeviceTypes Page");
	}

	@Then("I verify device details for the {string} in test data {string}")
	public void i_verify_device_details_for_the_in_test_data(String string, String string2) {
	//	test = logInfo.get().createNode("I verify the device details for the " + string + "in test data" + string);
		try {
			test = logInfo.get().createNode("I verify the device details for the " + string + " in test data " + string);
			test.assignCategory("Devices");
			Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceType", string2);
		//	System.out.println(testData.get("H1.Import_Device_ID"));
			Map<String, String> deviceDetails ;
			reportInfo("Test Data "+testData);
			deviceDetails = testSetup.pageObjectManager.getDeviceTypesPage().DeviceTypeConfigValidation(testData, string);
			
			if(string.equals("H1")) {
				
				validateField("DeviceIDLabel", testData.get("DeviceIDLabel"), deviceDetails.get("deviceIDLabel"));
				
				//validateField("RequiresDeviceID", testData.get("RequiresDeviceID"), deviceDetails.get("requiresDeviceID"));
				
				validateField("RequiresDeviceSetting", testData.get("RequiresDeviceSetting"), deviceDetails.get("requiresDeviceSetting"));
			
				}
				
				else if (string.equals("X2")) {
					validateField("DeviceIDLabel", testData.get("DeviceIDLabel"), deviceDetails.get("deviceIDLabel"));
					
					//validateField("RequiresDeviceID", testData.get("RequiresDeviceID"), deviceDetails.get("requiresDeviceID"));
					
					validateField("RequiresDeviceSetting", testData.get("RequiresDeviceSetting"), deviceDetails.get("requiresDeviceSetting"));
					
				}
				
				else if (string.equals("Edge")) {
					validateField("DeviceIDLabel", testData.get("DeviceIDLabel"), deviceDetails.get("deviceIDLabel"));
					
					//validateField("RequiresDeviceID", testData.get("RequiresDeviceID"), deviceDetails.get("requiresDeviceID"));
					
					validateField("RequiresDeviceSetting", testData.get("RequiresDeviceSetting"), deviceDetails.get("requiresDeviceSetting"));
					
				}
				else  {
					validateField("DeviceIDLabel", testData.get("DeviceIDLabel"), deviceDetails.get("deviceIDLabel"));
					
					//validateField("RequiresDeviceID", testData.get("RequiresDeviceID"), deviceDetails.get("requiresDeviceID"));
					
					validateField("RequiresDeviceSetting", testData.get("RequiresDeviceSetting"), deviceDetails.get("requiresDeviceSetting"));
					
				}
			reportInfo("DeviceType "+string+" validated successfully" );
			reportScreenshot("PASS", "DeviceTypes should be validated", "DeviceTypes are validated succefully",testSetup.driver);
		
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}
		
	}

	@Then("I navigate to Devices tab")
	public void i_navigate_to_devices_tab() {
		test = logInfo.get().createNode("I navigate to Devices tab");
		testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();;
		testSetup.pageObjectManager.getHomePage().navigateToDevicesTab();
		reportInfo("User navigated to Devices Page");
	}



	@Then("I verify if device details in the {string} is same as specified for the {string}")
	public void i_verify_if_device_details_in_the_is_same_as_specified_for_the(String string, String string2) throws Exception {
		try {
			test = logInfo.get().createNode("I verify if device details for " +string2+" is same as specified in "+string);

			Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceType", string);
			Boolean deviceTypeftr =testSetup.pageObjectManager.getDevicePage().checkDeviceTypeFld(string2);
			testSetup.pageObjectManager.getDevicePage().checkDeviceSettings(string2);

			reportScreenshot(testSetup.driver);
			Boolean deviceSettingsftr =testSetup.pageObjectManager.getDevicePage().checkDeviceSettingsPopup(string2);
			reportScreenshot(testSetup.driver);
			validateField("Device Type Field present", testData.get("RequiresDeviceID"), String.valueOf(deviceTypeftr));
			validateField("Device Settings Feature enabled", testData.get("RequiresDeviceSetting"), String.valueOf(deviceSettingsftr));
			
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}
	}

}
