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

public class VMM_3286_Device_ID_should_allow_number_and_letter_characters extends BaseTest {
		
	TestSetup testSetup;
	
    
	public VMM_3286_Device_ID_should_allow_number_and_letter_characters(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	@Then("I navigate to system admin")
	public void i_navigate_to_system_admin() {
		test = logInfo.get().createNode("I navigate to system admin");
		testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
		reportInfo("I navigate to system admin successfully");
	}
	
	
	@Then("I Create a device with device type and  test data {string}")
	public void i_create_a_device_with_device_type_and_test_data(String tcid) throws Exception {
		try {
		String SerialUniqueID=randomStringGenerator();
		Thread.sleep(2000);
		String DeviceUniqueID=randomStringGenerator();
		
		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",SerialUniqueID,"VMM3286_1");
		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",DeviceUniqueID,"VMM3286_1");
	
		
		test = logInfo.get().createNode("I create a Device With Required Device Id Device Type");
		Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
		reportInfo(testData.toString());
		reportInfo("I create a Device With Required Device Id Device Type");
		testSetup.pageObjectManager.getDevicePage().CreateDeviceNew(testData);
		reportScreenshot(testSetup.driver);
		testSetup.pageObjectManager.getDevicePage().DeviceSave();
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	    
	}
	@Then("I using show filter to get device details {string}")
	public void i_using_show_filter_to_get_device_details(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I using show filter to get device details");
		reportInfo("I using show filter to get the device details");
		Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
		reportInfo(testData.toString());
		testSetup.pageObjectManager.getDevicePage().searchDevice(testData);
		reportScreenshot(testSetup.driver);
		reportInfo("Device Is Created Successfully");
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	@Then("I verify device id  field accepts letters, numbers Not More than 32 {string}")
	public void i_verify_device_id_field_accepts_letters_numbers(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I verify device id  field accepts letters, numbers not greater than 32 characters");
		test.assignCategory("Devices");
		
		reportInfo("I Verify device id field accepts letters, numbers and both with length not greater than 32 characters");
		
		Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
		reportInfo(testData.toString());
		

		reportInfo("I try to Edit The Device Id With using More Than 32 Letters And Numbers------:"+"  "+testData.get("DeviceIdMoreThan32"));
		
		testSetup.pageObjectManager.getDevicePage().PassingMorethan32LettersAndNumbers(testData);
		reportScreenshot(testSetup.driver);
		//reportInfo("Device id Accepting Only 32 Letters And Numbers");
		testSetup.pageObjectManager.getDevicePage().DeviceSave();
		
		
		testSetup.pageObjectManager.getDevicePage().searchDevice(testData);
		String AcutalDeviceID = testSetup.pageObjectManager.getDevicePage().VerifyDeviceIdNotAllowMoreThan32();
		if(testData.get("DeviceIdMoreThan32")!=AcutalDeviceID) {
			reportPass("Device Id Field","Enterning Device Id More than 32 Letters And Numbers---:   "+testData.get("DeviceIdMoreThan32"),"Accepted Device Id Length Only Less than Equal to 32---:   "+AcutalDeviceID);
			reportInfo("Device id Accepting Only 32 Letters And Numbers ------    :"+"  "+AcutalDeviceID);
			reportInfo("Device is created with only 32 letters and numbers");
			
		}else {
			reportFail("device id accepting more than 32",AcutalDeviceID,AcutalDeviceID);
		}
		
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
		
	}
	   @Then("I delete the device {string}") 
	   public void i_delete_device(String tcid) throws Exception
	   {   try {
		   test = logInfo.get().createNode("I delete the device ");
		   Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
		   reportInfo("I delete the Device");
		   testSetup.pageObjectManager.getDevicePage().SelectDeleteIconCreatedDevice();
		   reportScreenshot(testSetup.driver);
		   testSetup.pageObjectManager.getDevicePage().ConformDeleteCreatedDevice();
	   }
		   catch(Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	   }
}
		

	

