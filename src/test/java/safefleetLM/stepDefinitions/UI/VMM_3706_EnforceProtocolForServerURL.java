package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3706_EnforceProtocolForServerURL extends BaseTest {

	TestSetup testSetup;
	public VMM_3706_EnforceProtocolForServerURL(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}

	@Then("I navigate to device settings page")
	public void i_navigate_to_device_settings_page() {
		   try {
				test = logInfo.get().createNode("I navigated to device settings page");
				testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
				testSetup.pageObjectManager. getHomePage().navigateToDeviceSettingsTab();
				reportInfo("User navigated to device settings Tab successfully");
				
					}
					catch(AssertionError | Exception e) {
						testStepHandle("FAIL",testSetup.driver,test,e);			
					}
	}

	@Then("I create device settings with test data {string}")
	public void i_create_device_settings_with_test_data(String tcid) {
		 try {				
				String deviceName = randomStringGenerator();			
				UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"DeviceSettingPage","DeviceName",deviceName,"VMM-3706_1");
				 Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
				test = logInfo.get().createNode("I create device settings with test data ");
				test.assignCategory("Servers");
				testSetup.pageObjectManager.getDeviceSettingsPage().createDeviceSetting(testData);
		
				reportScreenshot(testSetup.driver);

					}
					catch(AssertionError | Exception e) {
						testStepHandle("FAIL",testSetup.driver,test,e);			
					}
	}

	@Then("I verify Fleet Server IP and Fleet Server Port values in Fleet Server Configuration with test data {string}")
	public void i_verify_fleet_server_ip_and_fleet_server_port_values_in_fleet_server_configuration_with_test_data(String tcid) {
		 try {				
				test = logInfo.get().createNode("I verify Fleet Server IP and Fleet Server Port values in Fleet Server Configuration");
				 Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
				String FleetServerIP=testSetup.pageObjectManager.getDeviceSettingsPage().verifyFleetServerIP();
				validateField("Device Type Text", testData.get("FleetServerIP"),FleetServerIP);
				String FleetServerPort=testSetup.pageObjectManager.getDeviceSettingsPage().verifyFleetServerPort();
				validateField("Device Type setting", testData.get("FleetServerPort"),FleetServerPort);
				
					}
					catch(AssertionError | Exception e) {
						testStepHandle("FAIL",testSetup.driver,test,e);			
					}
	}
	
}
