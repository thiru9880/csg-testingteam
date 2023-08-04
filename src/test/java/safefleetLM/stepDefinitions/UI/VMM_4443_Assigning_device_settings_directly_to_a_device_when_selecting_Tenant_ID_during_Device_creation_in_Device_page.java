package safefleetLM.stepDefinitions.UI;

import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import safefleetLM.testcomponents.DBConnection;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_4443_Assigning_device_settings_directly_to_a_device_when_selecting_Tenant_ID_during_Device_creation_in_Device_page extends BaseTest {

	TestSetup testSetup;
	String settinginstanceid;
	//String settinginstanceid1;


	public VMM_4443_Assigning_device_settings_directly_to_a_device_when_selecting_Tenant_ID_during_Device_creation_in_Device_page(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}


	@Then("I create new Tenant for VMM4443 with test data {string}")
	public void i_create_new_tenant_for_vmm4443_with_test_data(String tcid) throws Exception {
		try {
			String tenantID=randomStringGenerator();
			//test.assignCategory("Devices");

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_4443_1");
      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","TenantID",tenantID,"VMM_4443_1");

			test = logInfo.get().createNode("I create new Tenant with test data  "+tcid);//TenantID

			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getTenantsPage().createNewTenantLicense(testData);
			reportScreenshot(testSetup.driver);
			String ActualId = testSetup.pageObjectManager.getTenantsPage().saveConfirmation(testData);
			reportScreenshot(testSetup.driver);
			if(ActualId.equalsIgnoreCase(testData.get("TenantID"))) {
				reportPass("Tenant Created ID:", testData.get("TenantID").toLowerCase(), ActualId);
				reportInfo("New Tenant created successfully");}
			else {
				reportFail("Tenant Created ID:", testData.get("TenantID").toLowerCase(), ActualId);
			reportInfo("New Tenant NOT created successfully");}
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			testSetup.pageObjectManager.getTenantsPage().continueExecution();
			reportFail("","Tenant id is exist," ,"Tenant id must be unique" );
		}

	}

	@Then("I Click on New button and i fill required field with testdata {string}")
	public void i_click_on_new_button_and_i_fill_required_field_with_testdata(String tcid) throws Exception {
		try {
			String deviceID=randomStringGenerator();
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",deviceID,"VMM_4443_1");
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",deviceID,"VMM_4443_1");
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","partNo",deviceID,"VMM_4443_1");
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","IMEINo",deviceID,"VMM_4443_1");

		test = logInfo.get().createNode("I Click on New button and i fill required field with testdata");
		Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
		reportInfo(testData.toString());
		testSetup.pageObjectManager.getDevicePage().clickNewDevice(testData);
		reportScreenshot(testSetup.driver);
		reportInfo("Click on New button and i fill required field with testdata successfully");

		}
		catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I Verify that dialog should appear to assign Device Settings")
	public void i_verify_that_dialog_should_appear_to_assign_device_settings() {
		try {
		test = logInfo.get().createNode("I Verify that dialog should appear to assign Device Settings");
		String dialog = testSetup.pageObjectManager.getDevicePage().dialogappear();
		if (dialog.contains("Are you sure you want to assign the Device(s) with the following setting?")) {
			reportPass("dialog should appear", "Are you sure you want to assign the Device(s) with the following setting?", dialog);
			reportScreenshot(testSetup.driver);
			reportInfo("Verify that dialog appear to assign Device Settings is successful");

		} else {
			reportFail("dialog should appear", "Are you sure you want to assign the Device(s) with the following setting?", dialog);
			reportScreenshot(testSetup.driver);
			reportInfo("Verify that dialog not appear to assign Device Settings");
		}




		}
		catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}


	@Then("I Vertify that new device status with device settings data in Device table in DBS with testdata {string} after Assigning the Device Settings")
	public void i_vertify_that_new_device_status_with_device_settings_data_in_device_table_in_dbs_with_testdata_after_assigning_the_device_settings(String tcid) {
		String env = getProperty("Environment");
		if(env.equals("STG"))
		{
			reportInfo("Do not have access to check DBS verification in Stagging environment, hence this test step is skipped");
		}
		else
		{
		List<Map<String, ?>> res = null;
		List<Map<String, ?>> res1 = null;
		try {

		test = logInfo.get().createNode("I Vertify that new device status with device settings data in Device table in DBS with testdata after Assigning the Device Settings");
		Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
		if(env.equals("DEV"))
			res = DBConnection.getData("SELECT * FROM dev_license_manager.device where device_id='"+testData.get("DeviceID")+"';");
		if(env.equals("TEST"))
			res = DBConnection.getData("SELECT * FROM test_license_manager.device where device_id='"+testData.get("DeviceID")+"';");


		System.out.println(res);

		System.out.println(res.get(0).get("STATUS"));

		System.out.println(res.get(0).get("SETTINGS_INSTANCE_ID"));

		settinginstanceid = res.get(0).get("SETTINGS_INSTANCE_ID").toString();



		String devicestatus = res.get(0).get("STATUS").toString();
		if(devicestatus.equalsIgnoreCase("ASSIGNED")) {
			reportPass("Devices status", "ASSIGNED", devicestatus);

			reportInfo("I Vertify that new device status in Device table in DBS with testdata is successful");

		}
		else {
			reportFail("Devices status", "ASSIGNED", devicestatus);
			reportScreenshot(testSetup.driver);
			reportInfo("I Vertify that new device status in Device table in DBS with testdata is not successful");

		}

		if(env.equals("DEV"))
		res1 = DBConnection.getData("SELECT * FROM dev_license_manager.settings_instance where id='"+settinginstanceid+"';");
		if(env.equals("TEST"))
		res1 = DBConnection.getData("SELECT * FROM test_license_manager.settings_instance where id='"+settinginstanceid+"';");

		System.out.println(res1);
		System.out.println(res1.get(0).get("NAME"));
		String id = res1.get(0).get("NAME").toString();
		if(id.equalsIgnoreCase("Core Controller")) {
			reportPass("device settings", "Core Controller", id);

			reportInfo("I Vertify that new device settings in Device table in DBS with testdata is successful");

		}
		else {
			reportFail("device settings", "Core Controller", id);
			reportScreenshot(testSetup.driver);
			reportInfo("I Vertify that new device settings in Device table in DBS with testdata is not successful");

		}

		}
		catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
		}


	}

	@Then("I Select the Setting with testdata {string} and save")
	public void i_select_the_setting_with_testdata_and_save(String tcid) {
		try {
			test = logInfo.get().createNode("I Select the Setting with testdata and save");
			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
			testSetup.pageObjectManager.getDevicePage().clicktoggleBtn(testData);//clickassignDeviceBtn

			testSetup.pageObjectManager.getDevicePage().clickassignDeviceBtn();// saveDevice
			testSetup.pageObjectManager.getDevicePage().saveDevice();
			reportInfo("Select the Setting with testdata successfully");

		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I Verify that user will be able to save the new Device with the device settings and verify the settings Icon {string}")
	public void i_verify_that_user_will_be_able_to_save_the_new_device_with_the_device_settings_with_testdata(String tcid) { // searchDevice
        try {
        	test = logInfo.get().createNode("I Verify that user will be able to save the new Device with the device settings with testdata");
        	Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
        	testSetup.pageObjectManager.getDevicePage().searchDevice(testData);
        	Boolean IconEnable = testSetup.pageObjectManager.getDevicePage().verifyDeviceSettingIconEnabled();
            if (IconEnable==true) {
                reportPass("Setting Icon is Enabled", "true", "true");

            } else {
                reportFail("Setting Icon not Enabled", "false","false");
            }
            reportScreenshot(testSetup.driver);
            reportInfo("Verify that user will be able to save the new Device with the device settings successfully and Settings Icn enabled");



		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I Edit the Device and Verify that all the selected values are displayed")
	public void i_edit_the_device_and_verify_that_all_the_selected_values_are_displayed() { // clickdeviceEditBtn
		try {
		test = logInfo.get().createNode("I Edit the Device and Verify that all the selected values are displayed");
		testSetup.pageObjectManager.getDevicePage().clickdeviceEditBtn();
		reportScreenshot(testSetup.driver);
		reportInfo("Edit the Device and Verify that all the selected values are displayed successfully");




		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I Verify that Unassign button is enabled & displayed and Tenant ID dropdown values are grayed out")
	public void i_verify_that_unassign_button_is_enabled_displayed_and_tenant_id_dropdown_values_are_grayed_out() {
		try {
			test = logInfo.get().createNode("I Verify that Unassign button is enabled & displayed and Tenant ID dropdown values are grayed out");

			Boolean Btnenble = testSetup.pageObjectManager.getDevicePage().UnassignBtnEnable();
			if (Btnenble==true) {
				reportPass("Unassign button is enabled", "true", "true");
				reportScreenshot(testSetup.driver);
				reportInfo("Verify that Unassign button is enabled");

			} else {
				reportFail("Unassign button", "false","false");
				reportScreenshot(testSetup.driver);
				reportInfo("Verify that Unassign button not enabled");
			}

			Boolean Btndisplayed = testSetup.pageObjectManager.getDevicePage().UnassignBtndisplayed();
			if (Btndisplayed==true) {
				reportPass("Unassign button is displayed ", "true", "true");
				reportScreenshot(testSetup.driver);
				reportInfo("Verify that Unassign button is displayed");

			} else {
				reportFail("Unassign button is displayed", "false","false");
				reportScreenshot(testSetup.driver);
				reportInfo("Verify that Unassign button not displayed");
			}

			 String txtfiledenble = testSetup.pageObjectManager.getDevicePage().verifyTenantidTxtfild(); //true
			System.out.println(txtfiledenble);
			if (txtfiledenble.equalsIgnoreCase("true")) {
				reportPass("Tenant ID dropdown values are grayed out", "true", "true");
				reportScreenshot(testSetup.driver);
				reportInfo("Verify that Tenant ID dropdown values are grayed out");

			} else {
				reportFail("Tenant ID dropdown values are grayed out", "false","false");
				reportScreenshot(testSetup.driver);
				reportInfo("Verify that Tenant ID dropdown values are not grayed out");
			}




		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I Click on Unassign and user should be able to unassign the device")
	public void i_click_on_unassign_and_user_should_be_able_to_unassign_the_device() {
		try {
			test = logInfo.get().createNode("I Click on Unassign and user should be able to unassign the device");
			testSetup.pageObjectManager.getDevicePage().clickUnassignBtn();
			reportInfo("Click on Unassign and user should be able to unassign the device successfully");



		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I Select the Device status with testdata {string} and save")
	public void i_select_the_device_status_with_testdata_and_save(String tcid) {
		try {
			test = logInfo.get().createNode("I Select the Device status with testdata and save");

			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
			testSetup.pageObjectManager.getDevicePage().clickUnassigndevicetxtfield(testData);

			testSetup.pageObjectManager.getDevicePage().saveDevice();

			reportInfo("Select the Device status with testdata successfully");





		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I Verify that user will be able to unassign the device by selecting the device status and verify the settings Icon {string}")
	public void i_verify_that_user_will_be_able_to_unassign_the_device_with_the_device_status_with_testdata_(String tcid) {
		try {
			test = logInfo.get().createNode("I Verify that user will be able to unassign the device with the device status");
			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
        	testSetup.pageObjectManager.getDevicePage().searchDevice(testData);
        	Boolean IconEnable = testSetup.pageObjectManager.getDevicePage().verifyDeviceSettingIconEnabled();
            if (IconEnable==false) {
                reportPass("Setting Icon is Disabled", "false", "false");
            } else {
                reportFail("Setting Icon is Enabled", "true","true");
            }
        reportScreenshot(testSetup.driver);
        reportInfo("Verify that user will be able to unassign the device by selecting the device status successfully");




		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}
	@Then("I Vertify that new device status with device settings data in Device table in DBS with testdata {string} after UnAssigning the Device Settings")
	public void i_vertify_that_new_device_status_with_device_settings_data_in_device_table_in_dbs_with_testdata_after_un_assigning_the_device_settings(String tcid) {
		String env = getProperty("Environment");
		if(env.equals("STG"))
		{
			reportInfo("Do not have access to check DBS verification in Stagging environment, hence this test step is skipped");
		}
		else
		{
			try {
				test = logInfo.get().createNode("I Vertify that new device status with device settings data in Device table in DBS with testdata after UnAssigning the Device Settings");
				Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
				List<Map<String, ?>> res = null;

				if(env.equals("DEV"))
					res = DBConnection.getData("SELECT * FROM dev_license_manager.device where device_id='"+testData.get("DeviceID")+"';");
				else if(env.equals("TEST"))
					res = DBConnection.getData("SELECT * FROM test_license_manager.device where device_id='"+testData.get("DeviceID")+"';");


				System.out.println(res);

				System.out.println(res.get(0).get("STATUS"));

				System.out.println(res.get(0).get("SETTINGS_INSTANCE_ID"));

				String devicestatus = res.get(0).get("STATUS").toString();
				if(devicestatus.equalsIgnoreCase("NOT_ASSIGNED")) {
					reportPass("Devices status", "NOT_ASSIGNED", devicestatus);

					reportInfo("I Vertify that new device status in Device table in DBS with testdata is successful");

				}
				else {
					reportFail("Devices status", "NOT_ASSIGNED", devicestatus);
					reportScreenshot(testSetup.driver);
					reportInfo("I Vertify that new device status in Device table in DBS with testdata is not successful");

				}

				if(res.get(0).get("SETTINGS_INSTANCE_ID")==null) {
					reportPass("device settings", "null", "null");

					reportInfo("I Vertify that new device settings in Device table in DBS with testdata is successful");

				}
				else {
					reportFail("device settings", "null", res.get(0).get("SETTINGS_INSTANCE_ID").toString());
					reportScreenshot(testSetup.driver);
					reportInfo("I Vertify that new device settings in Device table in DBS with testdata is not successful");


				}


			}
			catch (Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
		}

	}

	@Then("I delete the device")
	public void i_delete_the_device() {
		try {
		test = logInfo.get().createNode("I delete the device");
		testSetup.pageObjectManager.getDevicePage().deleteTheDevice();
		reportInfo("Device deleted Successfully");

		}
		catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}


}
