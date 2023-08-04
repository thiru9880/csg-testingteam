package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3410_Device_Settings_Page_not_populating_with_correct_device_types extends BaseTest {

	TestSetup testSetup;

	List<String> DeviceTypeList;

	public VMM_3410_Device_Settings_Page_not_populating_with_correct_device_types(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}
	@Then("I Click on NEW and verify device types which has Requires Setting status {string}")
	public void i_click_on_new_and_verify_device_types_which_has_requires_setting_status(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I Click on NEW and verify device types which has Requires Setting status");
			test.assignCategory("Device Settings");
			Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
			reportInfo(testData.toString());
			DeviceTypeList = testSetup.pageObjectManager.getDeviceSettingsPage().deviceTypesWhichHaveSettingStatus(testData);
			if(DeviceTypeList!=null) {
				reportPass("DeviceTypes", "Verify DeviceTypes DropDown List in Create Device Settings page", "Verify DeviceTypes DropDown List in Create Device Settings page succefully");
				reportScreenshot("PASS", "", "Verify device types which has Requires Setting status successfully",testSetup.driver);
			}
			else
				reportFail("DeviceTypes", "Verify DeviceTypes DropDown List in Create Device Settings page", "Verify DeviceTypes DropDown List in Create Device Settings page is NOT succefull");
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I verify Device Types page should show up in the drop down list of the device types in New Device Settings page {string}")
	public void i_verify_device_types_page_should_show_up_in_the_drop_down_list_of_the_device_types_in_new_device_settings_page(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I verify the drop down list of the device types in New Device Settings page should show up in Device Types pages");
			Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceType", tcid);
			reportInfo(testData.toString());
			String Result = testSetup.pageObjectManager.getDeviceTypesPage().verifySettingStatusDeviceTypes(DeviceTypeList);
			reportScreenshot(testSetup.driver);
			if(Result.equalsIgnoreCase("PASS"))
				reportPass("DeviceType","DeviceTypes page should show dropdown list of device types in New Device Settings page", "DeviceTypes page shows dropdown list of device types in New Device Settings page succefully");
			else
				reportFail("DeviceType","DeviceTypes page should show dropdown list of device types in New Device Settings page", "NOT ALL Device types in Device setting dropdown list Having Requires Setting status in Device Types Page");
			testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	@Then("I select device type and make sure that Device settings template is loaded with Fleet Server port and host pointing to the below based on the environment {string}")
	public void i_select_device_type_and_make_sure_that_device_settings_template_is_loaded_with_fleet_server_port_as(String tcid) throws Exception {
		try{
			test = logInfo.get().createNode("I select device type and make sure that Device settings template is loaded with Fleet Server port");
			Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
			reportInfo(testData.toString());
			String FleetServerport = testSetup.pageObjectManager.getDeviceSettingsPage().verifyFleetServerPort(testData);
			reportScreenshot(testSetup.driver);
			String Eport="30825";
			if(FleetServerport.equalsIgnoreCase(Eport))
				reportPass("Fleet server port", "Device settings template Should loaded with Fleet Server port as 30825", "Device settings template loaded with Fleet Server port as "+FleetServerport+" succefully");
			else
				reportFail("Fleet server port", "Device settings template Should loaded with Fleet Server port as 30825", "Device settings template loaded with Fleet Server port as "+FleetServerport+"");
			reportInfo("fleet server host pointing to the below based on the environment successfully");
			//testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	/*@Then("I verify fleet server host pointing to the below based on the environment")
	public void i_verify_fleet_server_host_pointing_to_the_below_based_on_the_environment() {
		test = logInfo.get().createNode("I verify fleet server host pointing to the below based on the environment");
		testSetup.pageObjectManager.getDeviceSettingsPage().verifyFleetServerHostPoint();
		reportInfo("Navigate to Tenant type successfully");
	}*/
	@Then("I create a new test device type {string}")
	public void i_create_a_new_test_device_type(String tcid) throws Exception {
		try {

			String DeviceType=randomStringGenerator();

			System.out.println(DeviceType);
			if(tcid.equals("VMM_3410_1"))
			{
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"DeviceType","Name",DeviceType+"DT","VMM_3410_1");
			
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"DeviceSettingPage","DeviceType",DeviceType+"DT","VMM_3410_1");
			}
			test = logInfo.get().createNode("I create a new test device type");
			Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceType", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getDeviceTypesPage().createDeviceType(testData);
			reportScreenshot("PASS", "", "Create a Device Type with Requires Setting status",testSetup.driver);
			String Result = testSetup.pageObjectManager.getDeviceTypesPage().saveDeviceType();
			reportScreenshot(testSetup.driver);
			if(Result.equalsIgnoreCase("A new Device Type is created with identifier "+testData.get("Name")))
				reportPass("Alert Message ", "A new Device Type is created with identifier "+testData.get("Name"), Result);
			else
				reportFail("Alert Message ", "A new Device Type is created with identifier "+testData.get("Name"), Result);
			reportInfo("Create a new test device type "+testData.get("Name")+" successfully");}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I make sure that the settings template is loaded with Fleet Server port for created device type {string}")
	public void i_make_sure_that_the_settings_template_is_loaded_with_fleet_server_port(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I make sure that the settings template is loaded with Fleet Server port");
			Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
			reportInfo(testData.toString());
			String FleetServerport=testSetup.pageObjectManager.getDeviceSettingsPage().verifyFleetServerPortForCreatedDeviceType(testData);
			reportScreenshot(testSetup.driver);
			String Eport="30825";
			if(FleetServerport.equalsIgnoreCase(Eport))
				reportPass("Fleet server port","Fleet Server port should be 30825 for created device type "+testData.get("DeviceType"),"Fleet server port shows "+FleetServerport+" for created Device type "+testData.get("DeviceType")+" succefully");
			else
				reportFail("Fleet server port","Fleet Server port should be 30825 for created device type "+testData.get("DeviceType"),"Fleet server port NOT shows "+FleetServerport+" for created Device type "+testData.get("DeviceType"));
			reportInfo("fleet server host pointing to the below based on the environment successfully");
			testSetup.pageObjectManager.getHomePage().navigateToDeviceSettingsTab();}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I create a new device setting with the device type i created {string}")
	public void i_create_a_new_device_setting_with_the_device_type_i_created(String tcid) throws Exception {
		try {
			String DeviceSetting=randomStringGenerator();

		//	System.out.println(DeviceSetting);
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"DeviceSettingPage","DeviceName",DeviceSetting+"S","VMM_3410_1");
			
			test = logInfo.get().createNode("I create a new device setting with the device type i created");
			Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getDeviceSettingsPage().createDeviceSetting(testData);
			reportScreenshot("PASS", "", "Create a new Device setting with "+testData.get("DeviceType")+" Device type",testSetup.driver);
			String Alert = testSetup.pageObjectManager.getDeviceSettingsPage().createDeviceSettingSaveButton();
			reportScreenshot(testSetup.driver);
			if(Alert.equalsIgnoreCase("A new Settings is created with identifier "+testData.get("DeviceName")))
				reportPass("Alert Message ", "A new Settings is created with identifier "+testData.get("DeviceName"), Alert);
			else
				reportFail("Alert Message ", "A new Settings is created with identifier "+testData.get("DeviceName"), Alert);
			reportInfo("create a new device setting "+testData.get("DeviceName")+" with the device type "+testData.get("DeviceType")+" successfully");
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	@Then("I delete the device setting {string}")
	public void i_delete_the_device_setting(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I delete the device setting");
			Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
			reportInfo(testData.toString());
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
	@Then("I delete the test device type {string}")
	public void i_delete_the_test_device_type(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I delete the test device type");
			Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceType", tcid);
			reportInfo(testData.toString());
			String alert =testSetup.pageObjectManager.getDeviceTypesPage().deleteDeviceType(testData);
			reportScreenshot(testSetup.driver);
			if(alert.equalsIgnoreCase("A Device Type is deleted with identifier "+testData.get("Name")))
				reportPass("Alert messaeg", "A Device Type is deleted with identifier "+testData.get("Name"), alert);
			else
				reportFail("Alert messaeg", "A Device Type is deleted with identifier "+testData.get("Name"), alert);}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
}
