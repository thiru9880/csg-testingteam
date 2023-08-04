package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.List;
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

public class VMM_5027_Bulk_upload_of_devices_without_deviceId extends BaseTest {

	TestSetup testSetup;

	public VMM_5027_Bulk_upload_of_devices_without_deviceId(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}


	@Then("I upload devices from spreadsheet via Bulk Upload operation {string}")
	public void i_click_on_bulk_upload_i_upload_all_the_devices_in_spread_sheet(String tcid) {
		try
		{
			test = logInfo.get().createNode("I click on bulk upload button and select upload spreadsheet");
			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getDevicePage().BlukUploadInDevices();
			reportInfo("I clicked on bulk upload button");
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getBulkDeviceUploadPage().uploadFile(System.getProperty("user.dir")+"\\upload\\"+testData.get("Spreadsheet FileName"));
			reportInfo("I upload the  spredsheet");
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getBulkDeviceUploadPage().clickOnUploadButton();

		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I verify error message for devices uploaded without device Id {string}")
	public void i_verify_all_the_device_is_created_successfully_with_no_error_or_warning_message(String tcid) {
		try
		{
			test = logInfo.get().createNode("I verify error message for devices uploaded without device Id");
			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
			reportInfo(testData.toString());
			boolean errorStatus = testSetup.pageObjectManager.getDevicePage().verifyErrorMessageForDevice(testData.get("TxtMessage"));
			
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getDevicePage().ArrowUpForDeviceErroredOut();
			if(errorStatus) {
				reportPass("I verify devices are not created", "An error message is displayed", testData.get("TxtMessage"));

			}
			else {
				reportFail("Devices are not errored","" ,"");
			}
		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}


	@Then("I verify the uploaded device is not available in the devices list {string}")
	public void i_verify_the_uploaded_device_is_not_available_in_the_devices_list(String tcid) {
		try
		{
			test = logInfo.get().createNode("I verify the uploaded device is not available in the devices list");
			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getDevicePage().SearchBulkCreatedDevice(testData);
			String data = testSetup.pageObjectManager.getDevicePage().verifyDeviceNotAvailable();
			reportInfo("I verify Device is not available in device list");
			reportScreenshot(testSetup.driver);
			reportInfo("Device is not created");
			System.out.println("Sav"+data);
			if(data.equals(""))
			{
				reportPass("Device is not created","Device is not created", "Device is not created");

			}else
				reportFail("Device list is not null for the search filter","" ,"");
			testSetup.reusableLibrary.reloadScreen();
			
		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}



}
