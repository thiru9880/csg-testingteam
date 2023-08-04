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
import safefleetLM.testcomponents.PageObjectManager;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3377_Create_a_new_Device_setting extends BaseTest {
		
	TestSetup testSetup; 
	
    
	public VMM_3377_Create_a_new_Device_setting(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	
	@Then("I navigate to the Operations tab")
	public void i_navigate_to_the_operations_tab() {
		try {
		test = logInfo.get().createNode("I navigate to the Operations tab");
        testSetup.pageObjectManager.getHomePage().navigateToOperationsTab(); 
		reportInfo("I navigate to the Operations tab succesfully");
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	
	
	@Then("I create a device setting with device type and testdata {string}")
	public void i_create_a_device_setting_with_device_type_and_testdata(String tcid) throws Exception {
		try {
		String DeviceName=randomStringGenerator();
		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"DeviceSettingPage","DeviceName",DeviceName,"VMM3377_1");
		test = logInfo.get().createNode("I create a device setting with device type and testdata");
		test.assignCategory("Device Settings");
		Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
		reportInfo(testData.toString());
	    testSetup.pageObjectManager.getDeviceSettingsPage().createDeviceSetting(testData);
	    reportInfo("I Create a Device setting with testdata");
		reportScreenshot(testSetup.driver);
		String Createdsts = testSetup.pageObjectManager.getDeviceSettingsPage().DeviceSettingSaveConformation();
		reportScreenshot(testSetup.driver);
		if(Createdsts.contains("Settings is created")) {
			reportPass("I Verify Device Setting Is Created", Createdsts, Createdsts);
			reportInfo("Device Setting Created Successfully");
		}
		else {
			reportFail("Device Setting Created Successfully", Createdsts, Createdsts);
			reportInfo("Device Setting Not Created Successfully");
			reportScreenshot(testSetup.driver);	
		}
		

		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I view a device setting {string}")
	public void i_view_a_device_setting(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I view a device setting");
		Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
		reportInfo(testData.toString());
	    testSetup.pageObjectManager.getDeviceSettingsPage().SearchDeviceSetting(testData);
		testSetup.pageObjectManager.getDeviceSettingsPage().viewSetting();
		reportInfo("After Clicking View The page lists the Name, Device Type, Notes, and Fleet configuration information");
		reportScreenshot(testSetup.driver);
		
		reportInfo("Im Using search field filter to verify Fleet Server ip and field server port Should be shown filtered");
		
		String verifyIPstatus = testSetup.pageObjectManager.getDeviceSettingsPage().verifyFleetServerIPInViewDevice();
		reportScreenshot(testSetup.driver);
		if(verifyIPstatus.equalsIgnoreCase("Fleet Server IP")) {
			reportPass("I Verify Fleet Server IP ", verifyIPstatus, verifyIPstatus);
			reportInfo("Fleet Server IP filtered Successfully");
		}
		else {
			reportFail("I Verify Fleet Server IP", verifyIPstatus, verifyIPstatus);
			reportInfo("Fleet Server IP Not filtered Successfully");
			reportScreenshot(testSetup.driver);	
		}
		
		String verifyPortstatus = testSetup.pageObjectManager.getDeviceSettingsPage().verifyFleetServerPortInViewDevice();
		if(verifyPortstatus.equalsIgnoreCase("Fleet Server Port")) {
			reportPass("I Verify Fleet Server Port", verifyPortstatus, verifyPortstatus);
			reportInfo("Fleet Server Port filtered Successfully");
		}
		else {
			reportFail("not verifyed successfully", verifyPortstatus, verifyPortstatus);
			reportInfo("Fleet Server Port Not filtered Successfully");
			reportScreenshot(testSetup.driver);	
		}
		
		testSetup.pageObjectManager.getDeviceSettingsPage().clickBackafterviewed();
		}
		catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
			
		}
		
	   
	}
	@Then("I edit a device setting {string}")
	public void i_edit_a_device_setting(String tcid) throws Exception {
	    try {
	    String UpdateDeviceName=randomStringGenerator();
		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"DeviceSettingPage","updateDeviceName",UpdateDeviceName,"VMM3377_1");
		test = logInfo.get().createNode("I Edit a device setting name");
		Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
		reportInfo(testData.toString());
	    testSetup.pageObjectManager.getDeviceSettingsPage().SearchDeviceSetting(testData);
		testSetup.pageObjectManager.getDeviceSettingsPage().clickeditDeviceSettingIcon();
		testSetup.pageObjectManager.getDeviceSettingsPage().editDeviceSettingname(testData);
		reportInfo("I Edit a Device setting name");
		reportScreenshot(testSetup.driver);
		String VerifyEditedsts = testSetup.pageObjectManager.getDeviceSettingsPage().ClickSaveBtnAfterEdit();
		reportScreenshot(testSetup.driver);
		if(VerifyEditedsts.contains("Settings is updated ")) {
			reportPass("I Verify Device Setting Name updated ", VerifyEditedsts, VerifyEditedsts);
			reportInfo("Device Setting Name updated Successfully");
		}
		else {
			reportFail("I Verify Device Setting Name updated ", VerifyEditedsts, VerifyEditedsts);
			reportInfo("Device Setting Name Not updated Successfully");
			reportScreenshot(testSetup.driver);	
		}
	    }
	    catch (Exception e) {
	    	testStepHandle("FAIL", testSetup.driver, test, e); 
		}
	    
}

	@Then("I using show filter to get the device setting details for after edit {string}")
	public void i_using_show_filter_to_get_the_device_setting_details_for_after_edit(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I Change the Device Setting Name As Core Controller");
		Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
		reportInfo(testData.toString());
		testSetup.pageObjectManager.getDeviceSettingsPage().SearchDeviceSettingForAfterEdit(testData);
		testSetup.pageObjectManager.getDeviceSettingsPage().clickeditDeviceSettingIcon();
		testSetup.pageObjectManager.getDeviceSettingsPage().editDeviceSettingnameCoreController(testData);
		reportInfo("I Change the Device Setting Name As Core Controller");
		reportScreenshot(testSetup.driver);
		reportInfo("I Verify given an error Message Shown As The name  Core  Controller is already in use");
		String EditNameCoreControllerSts =testSetup.pageObjectManager.getDeviceSettingsPage().ClickSaveBtnAfterEdit();
		reportScreenshot(testSetup.driver);
	    if(EditNameCoreControllerSts.contains("already in use")) {
			reportPass("I Verify given an error Message Shown As The name  Core  Controller is already in use", EditNameCoreControllerSts, EditNameCoreControllerSts);
		}
		else {
			reportFail("I Verify given an error Message Shown  As The name  Core  Controller is already in use", EditNameCoreControllerSts, EditNameCoreControllerSts);
			reportInfo("Im Not getting Error Message As The name  Core  Controller is already in use");
			reportScreenshot(testSetup.driver);	
		}
	    
	    testSetup.pageObjectManager.getDeviceSettingsPage().clickCancelAfterEdit();

		}
		catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
			
		}
	    
	}
	
	@Then("I delete a device setting {string}")
	public void i_delete_a_device_setting(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I Delete a device setting");
		Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
		reportInfo(testData.toString());
		reportInfo("I Delete the Created Device Setting");
		testSetup.pageObjectManager.getDeviceSettingsPage().SearchDeviceSettingForAfterEdit(testData);
		testSetup.pageObjectManager.getDeviceSettingsPage().DeleteDeviceSetting();
		String Deletedsts = testSetup.pageObjectManager.getDeviceSettingsPage().DeleteDeviceSettingConformation();
		reportScreenshot(testSetup.driver);
		if(Deletedsts.contains("Settings is deleted")) {
			reportPass("I Verify Device Setting Deleted ", Deletedsts, Deletedsts);
			reportInfo("Device Setting Deleted Successfully");
		}
		else {
			reportFail("I Verify Device Setting Deleted ", Deletedsts, Deletedsts);
			reportInfo("Device Setting Not  Deleted Successfully");
			reportScreenshot(testSetup.driver);	
		}
		
		}
		
		catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
		
	}

	
	

}
	

