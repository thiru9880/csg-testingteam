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

public class VMM_5021_Device_ID_Serial_number_and_Mac_address_fields_are_mandatory_for_all_embedded_devices extends BaseTest {
		
	TestSetup testSetup;
	
    
	public VMM_5021_Device_ID_Serial_number_and_Mac_address_fields_are_mandatory_for_all_embedded_devices(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}

	
	@Then("I verify Device Id Serial number and Mac Address field mandatory and create a embedded device {string}")
	public void i_verify_device_id_serial_mac_address_field_mandatory_and_create_a_device(String tcid) throws Exception {
		try {
		String SerialUniqueID=randomStringGenerator();
		String DeviceUniqueID=randomStringGenerator();
		String MacUniqueID=randomStringGenerator();
		
		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",SerialUniqueID,"VMM5021_1");
		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",DeviceUniqueID,"VMM5021_1");
		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","MAC Address",MacUniqueID,"VMM5021_1");
	
		
		test = logInfo.get().createNode("I verify Device Id Serial number and Mac Address field mandatory and create a embedded device");
		Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
		reportInfo(testData.toString());
		boolean saveBtnStatus = testSetup.pageObjectManager.getDevicePage().verify_DeviceId_Serial_MacAdd_FieldIsMandatory(testData);
		if(saveBtnStatus)
		{
			reportInfo("I verified the Device Id Serial number and Mac Address field are mandatory");
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getDevicePage().DeviceSave();
			testSetup.pageObjectManager.getDevicePage().searchDevice(testData);
			reportInfo("Device created successfully");
		}

		
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	    
	}
	

	
	@Then("I update the device type and verify Device ID and Mac Address field is mandatory {string}")
	public void i_update_the_device_type_and_verify_device_id_mac_address_field_mandatory(String tcid) throws Exception {
		try {
				
		test = logInfo.get().createNode("I update the device type and verify Device ID and Mac Address field is mandatory");
		Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
		reportInfo(testData.toString());
		testSetup.pageObjectManager.getDevicePage().clickdeviceEditBtn();
		testSetup.pageObjectManager.getDevicePage().editDeviceType(testData.get("DeviceType2"));
		boolean saveBtnStatus = testSetup.pageObjectManager.getDevicePage().verify_DeviceId_MacAddress_FieldIsMandatory(testData);
		if(saveBtnStatus)
		{
			reportInfo("I verified the Device Id and Mac Address field are mandatory");
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getDevicePage().DeviceSave();
			reportInfo("I updated the Device and saved");
			testSetup.pageObjectManager.getDevicePage().deviceSearch(testData);
			reportInfo("Device updated successfully");
		}

		
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	    
	}
	
   
}
		

	

