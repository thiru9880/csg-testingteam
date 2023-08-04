package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3389_Device_Settings_Tracking_a_setting extends BaseTest{
	
	
	TestSetup testSetup;
	Map<String,String> deviceConfigurationDetails = new HashMap<String,String>();
	Map<String,String> deviceConfigurationDetailsFromTrackSettings = new HashMap<String,String>();
	int currentVersion= 0;
    
	public VMM_3389_Device_Settings_Tracking_a_setting(TestSetup testSetup) throws IOException {
		
		this.testSetup=testSetup;
		
	}
	
	
	@Then("I navigate to the device settings tab")
	public void i_navigate_to_the_device_settings_tab() throws IOException {
   try {
	test = logInfo.get().createNode("I navigate to the device settings tab");
	
	 
	
	String MsgSentTimer = randomIntGenerator();
	
	String AcknowledgeRequestMessageTimer= randomIntGenerator();
	
	UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"DeviceSettingPage","MessageSendTimer",MsgSentTimer,"VMM-3389");
	
	UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"DeviceSettingPage","AcknowledgeRequestMessageTimer",AcknowledgeRequestMessageTimer,"VMM-3389");
	
	UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"DeviceSettingPage","DeviceName",AcknowledgeRequestMessageTimer,"VMM-3389");

	
	testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
	
	testSetup.pageObjectManager.getHomePage().navigateToDeviceSettingsTab();
	
	testSetup.pageObjectManager.getLicensesPage().waitForAngularRequestsToFinish();
	
	reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}
	}
	
	@Then("I create a new device setting")
	public void i_create_a_new_device_setting() throws Exception {
    try {
	Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", "VMM-3389");
	
	test = logInfo.get().createNode("I create a new device setting with name "+ testData.get("DeviceName"));
	
	testSetup.pageObjectManager.getDeviceSettingsPage().createDeviceSetting(testData);
	
	reportScreenshot(testSetup.driver);
	
	testSetup.pageObjectManager.getDeviceSettingsPage().createDeviceSettingSave();
	
	testSetup.pageObjectManager.getDeviceSettingsPage().scrollToNewDeviceSetting(testData.get("DeviceName"));
			
	reportInfo("DeviceSetting "+testData.get("DeviceName")+" created successfully");
	
	reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}				
	}


	@Then("I edit the fleetconfiguration for any of the device setting and save")
	public void i_edit_the_name_and_fleetconfiguration_for_any_of_the_device_setting_and_save() throws Exception {
    try {
	test = logInfo.get().createNode("I edit the name and fleetconfiguration for any of the device setting and save");
	test.assignCategory("Device Settings");
	Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", "VMM-3389");
	
	try {
	currentVersion = testSetup.pageObjectManager.getDeviceSettingsPage().getCurrentVersion(testData);
	}catch(Exception e) {
		currentVersion = 0;
	}
	
	testSetup.pageObjectManager.getHomePage().navigateToDeviceSettingsTab();
	
	testSetup.pageObjectManager.getDeviceSettingsPage().filterDeviceSettings(testData);
	testSetup.pageObjectManager.getDeviceSettingsPage().clickEditDeviceSetting();
	
	reportScreenshot(testSetup.driver);
	
	deviceConfigurationDetails =testSetup.pageObjectManager.getDeviceSettingsPage().editDeviceSetting(testData);
	
	reportInfo("Message Send Timer and Acknowledge request Message Timer changed to "+ testData.get("MessageSendTimer") + " and " + testData.get("AcknowledgeRequestMessageTimer") + " respectively");
	
	reportScreenshot(testSetup.driver);
	
	testSetup.pageObjectManager.getDeviceSettingsPage().saveDeviceSetting();
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}				
	}

	@Then("I click on track action button for the edited device setting")
	public void i_click_on_track_action_button_for_the_edited_device_setting() throws Exception {
    try {
	test = logInfo.get().createNode("I click on track action button for the edited device setting");
	
	Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", "VMM-3389");
	testSetup.pageObjectManager.getDeviceSettingsPage().FilterDeviceSettings(testData);
	testSetup.pageObjectManager.getDeviceSettingsPage().clickTrackDeviceSetting(testData);
	
	reportInfo("Action item created successfully");
	
	reportScreenshot(testSetup.driver);
	
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}
	}

	@Then("I verify for the information edited an update entry should be displayed")
	public void i_verify_information_such_as_should_be_displayed() throws Exception {
    try {
	test = logInfo.get().createNode("I verify for the information edited an update entry should be displayed");
	
	Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", "VMM-3389");
	
	deviceConfigurationDetailsFromTrackSettings=testSetup.pageObjectManager.getDeviceSettingsPage().trackDeviceSetting(testData);
	
	reportInfo("Action item entry");
	
	reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}
	}

	@Then("I verify if the changes made while editing is reflected in the track action page")
	public void i_verify_if_the_changes_made_while_editing_is_reflected_in_the_track_action_page() throws Exception {
    try {
	test = logInfo.get().createNode("I verify if the changes made while editing is reflected in the track action page");
	
	Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", "VMM-3389");
	//testSetup.pageObjectManager.getDeviceSettingsPage().filterDeviceSettings(testData);
	//testSetup.pageObjectManager.getDeviceSettingsPage().FilterDeviceSettings(testData);
	//testSetup.pageObjectManager.getDeviceSettingsPage().clickTrackDeviceSetting(testData);
	
	validateField("Action", "UPDATE", deviceConfigurationDetailsFromTrackSettings.get("Action"));
	
	validateField("Name", testData.get("DeviceName"), deviceConfigurationDetailsFromTrackSettings.get("Name"));
	
	validateField("Version", String.valueOf(currentVersion+2), deviceConfigurationDetailsFromTrackSettings.get("Version"));
	
	JsonPath js = new JsonPath(deviceConfigurationDetailsFromTrackSettings.get("Template"));
	
	validateField("Fleet Server Host", deviceConfigurationDetails.get("FleetServerHost"),js.getString("[0].fields[0].data"));
	
	validateField("Fleet Server Port", deviceConfigurationDetails.get("FleetServerPort"),js.getString("[0].fields[1].data"));
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}
	}
	
	@Then("I delete the device setting created")
	public void i_delete_the_device_setting_created() throws Exception {
    try {
	test = logInfo.get().createNode("I verify if the device setting is deleted");
	
	testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
  
	testSetup.pageObjectManager.getHomePage().navigateToDeviceSettingsTab();
	
	Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", "VMM-3389");
	testSetup.pageObjectManager.getHomePage().navigateToDeviceSettingsTab();
	
	testSetup.pageObjectManager.getDeviceSettingsPage().filterDeviceSettings(testData);
	
	testSetup.pageObjectManager.getDeviceSettingsPage().deleteDeviceSetting(testData.get("DeviceName"));
	
	testSetup.pageObjectManager.getDeviceSettingsPage().scrollToNewDeviceSetting("f2");
	
	reportInfo(testData.get("DeviceName")+ " deviceSetting deleted successfully");
	
	reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}		
	}

}
