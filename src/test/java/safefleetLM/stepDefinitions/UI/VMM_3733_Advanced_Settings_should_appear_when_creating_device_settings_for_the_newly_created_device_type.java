package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3733_Advanced_Settings_should_appear_when_creating_device_settings_for_the_newly_created_device_type extends BaseTest {
		
	TestSetup testSetup;
    
	public VMM_3733_Advanced_Settings_should_appear_when_creating_device_settings_for_the_newly_created_device_type(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}

	@Then("I create a new device type {string}")
	public void i_create_a_new_device_type(String tcid) throws Exception {
		try {

			String deviceType=randomDeviceTypeStringGenerator();
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"DeviceType","Name",deviceType,"VMM3733_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"DeviceSettingPage","DeviceType",deviceType,"VMM3733_1");

			test = logInfo.get().createNode("I create a test device type");
			test.assignCategory("Device Settings");
			Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceType", tcid);  
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getDeviceTypesPage().createDeviceType1(testData);
			//reportScreenshot("PASS", "", "Create a Device Type with Requires Setting status",testSetup.driver);
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

@Then("I create new device setting with device type testdata {string} and Verify advanced settings section appears in the template")
public void i_create_new_device_setting_with_device_type_testdata_and_verify_advanced_settings_section_appears_in_the_template(String tcid) {
	try {		
		String deviceTypeSetting=randomDeviceTypeStringGenerator();
		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"DeviceSettingPage","DeviceName",deviceTypeSetting,"VMM3733_1");
		
		test = logInfo.get().createNode("I create a new device setting with the device type i created");
		Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
		reportInfo(testData.toString());
		testSetup.pageObjectManager.getDeviceSettingsPage().createDeviceSetting(testData);
		//test = logInfo.get().createNode("I Verify advanced settings section appears in the template");
		String text = testSetup.pageObjectManager.getDeviceSettingsPage().advancesetting();
		if (text.equalsIgnoreCase("Advanced Settings")) {
			reportPass("New Device Settings", "Advanced Settings", text);
			reportInfo("Advanced settings section appeared in the template");
			reportScreenshot(testSetup.driver);
			
		} else {
			reportFail("New Device Settings", "Advanced Settings", text);
			reportScreenshot(testSetup.driver);
		}
		
		//reportScreenshot("PASS", "", "Create a new Device setting with "+testData.get("DeviceType")+" Device type",testSetup.driver);
		String Alert = testSetup.pageObjectManager.getDeviceSettingsPage().createDeviceSettingSaveButton();
		reportInfo("New device setting is created");
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
@Then("I Verify that the new device settings have been created for the new device type with testdata {string}")
public void i_verify_that_the_new_device_settings_have_been_created_for_the_new_device_type(String tcid) throws Exception {
	try {
	test = logInfo.get().createNode("I Verify that the new device settings have been created for the new device type");
	testSetup.pageObjectManager.getHomePage().navigateToDeviceSettingsTab();
	Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
	testSetup.pageObjectManager.getDeviceSettingsPage().checkFilter1(testData);
	reportScreenshot(testSetup.driver);
	}
	catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}
	
	
    
}
@Then("I Verify that Edit and View buttons for the device settings working fine with testdata {string}")
public void i_verify_that_edit_and_view_buttons_for_the_device_settings_working_fine_with_testdata(String tcid) throws Exception {
	try {
	test = logInfo.get().createNode("I Verify that Edit and View buttons for the device settings working fine");
	testSetup.pageObjectManager.getHomePage().navigateToDeviceSettingsTab();
	testSetup.pageObjectManager.getDeviceSettingsPage().clickDeviceSettingviewBtn();
	reportInfo("I Verify that View buttons for the device settings working fine"); 
	reportScreenshot(testSetup.driver);
	
	
	testSetup.pageObjectManager.getDeviceSettingsPage().DeviceSettingbackBtn();
	
	Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
	testSetup.pageObjectManager.getDeviceSettingsPage().checkFilter1(testData);
	testSetup.pageObjectManager.getDeviceSettingsPage().DeviceSettingeditBtn(); 
	reportInfo("I Verify that Edit buttons for the device settings working fine");
	reportScreenshot(testSetup.driver);
	testSetup.pageObjectManager.getDeviceSettingsPage().DeviceSettingesaveBtn();
	

	}
	catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}
		
	
}

@Then("I delete device settings {string}")
public void i_delete_device_settings(String tcid) throws Exception {
	try {
	test = logInfo.get().createNode("I delete device settings");
	Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
	reportInfo(testData.toString());
	//testSetup.pageObjectManager.getHomePage().navigateToDeviceSettingsTab();
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

}
