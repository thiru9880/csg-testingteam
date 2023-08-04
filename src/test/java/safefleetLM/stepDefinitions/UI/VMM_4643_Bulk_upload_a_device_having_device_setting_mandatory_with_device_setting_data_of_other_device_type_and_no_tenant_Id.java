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

public class VMM_4643_Bulk_upload_a_device_having_device_setting_mandatory_with_device_setting_data_of_other_device_type_and_no_tenant_Id extends BaseTest {

	TestSetup testSetup;

	public VMM_4643_Bulk_upload_a_device_having_device_setting_mandatory_with_device_setting_data_of_other_device_type_and_no_tenant_Id(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}

	@Then("I Create a Tenant For Devices {string}")
	public void i_create_a_tenant_for_devices(String tcid) {
		try {
			String tenantID=randomStringGenerator();
			Thread.sleep(3000);
			String SerialUniqueID1=randomStringGenerator();
			Thread.sleep(3000);
			String SerialUniqueID2=randomStringGenerator();
			Thread.sleep(3000);
			String SerialUniqueID3=randomStringGenerator();
			Thread.sleep(3000);
			String DeviceUniqueID1=randomStringGenerator();
			Thread.sleep(3000);
			String DeviceUniqueID2=randomStringGenerator();
			Thread.sleep(3000);
			String DeviceUniqueID3=randomStringGenerator();

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM4643_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM4643_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Tenant ID",tenantID,"VMM4643_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM4643_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Tenant ID",tenantID,"VMM4643_2");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","TenantID",tenantID,"VMM4643_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","TenantID",tenantID,"VMM4643_2");

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",SerialUniqueID1,"VMM4643_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",SerialUniqueID2,"VMM4643_2");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",SerialUniqueID3,"VMM4643_3");

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM4643_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Serial #",SerialUniqueID1,"VMM4643_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM4643_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Serial #",SerialUniqueID2,"VMM4643_2");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM4643_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Serial #",SerialUniqueID3,"VMM4643_3");


			UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM4643_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Device ID",DeviceUniqueID1,"VMM4643_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM4643_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Device ID",DeviceUniqueID2,"VMM4643_2");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM4643_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Device ID",DeviceUniqueID3,"VMM4643_3");

			test = logInfo.get().createNode("I create a tenant for Bulk Upload Devices");
			test.assignCategory("Devices");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getTenantsPage().createNewTenant(testData);
			reportInfo("i Create a Tenant With Test Data");
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getTenantsPage().tenantSave(testData);
			reportInfo("tenant Created Successfully");
			reportScreenshot(testSetup.driver);

		}

		catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	@Then("I Click On Bulk Upload  I Upload All The Devices In SpreadSheet")
	public void i_click_on_bulk_upload_i_upload_all_the_devices_in_spread_sheet() {
		try
		{

      String SerialUniqueID1=randomStringGenerator();
      Thread.sleep(2000);
      String SerialUniqueID2=randomStringGenerator();
      Thread.sleep(2000);
      String SerialUniqueID3=randomStringGenerator();
      Thread.sleep(2000);
      String DeviceUniqueID1=randomStringGenerator();
      Thread.sleep(2000);
      String DeviceUniqueID2=randomStringGenerator();
      Thread.sleep(2000);
      String DeviceUniqueID3=randomStringGenerator();


      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",SerialUniqueID1,"VMM4643_1");
      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",SerialUniqueID2,"VMM4643_2");
      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",SerialUniqueID3,"VMM4643_3");

      UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM4643_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Serial #",SerialUniqueID1,"VMM4643_1");
      UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM4643_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Serial #",SerialUniqueID2,"VMM4643_2");
      UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM4643_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Serial #",SerialUniqueID3,"VMM4643_3");


      UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM4643_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Device ID",DeviceUniqueID1,"VMM4643_1");
      UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM4643_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Device ID",DeviceUniqueID2,"VMM4643_2");
      UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM4643_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Device ID",DeviceUniqueID3,"VMM4643_3");


      test = logInfo.get().createNode("I click on bulk upload button and select upload spreadsheet");
			testSetup.pageObjectManager.getDevicePage().BlukUploadInDevices();
			reportInfo("I clicked on bulk upload button");
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getBulkDeviceUploadPage().uploadFile(System.getProperty("user.dir")+"\\upload\\VMM4643_Bulk_Upload_Sheet_Devices.xlsx");
			reportInfo("i Upload The  Spredsheet");
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getBulkDeviceUploadPage().clickOnUploadButton();


		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I Verify All the device is created successfully")
	public void i_verify_all_the_device_is_created_successfully_with_no_error_or_warning_message() {
		try
		{
			test = logInfo.get().createNode("I Verify All the device is created successfully");
			String VerifyCreatedSts = testSetup.pageObjectManager.getDevicePage().verifyDeviceIsCreatedSuccessfully();
			reportInfo("i Verify Device is Created Successfully");
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getDevicePage().ArrowUpForDeviceIsCreatedSuccessfully();
			if(VerifyCreatedSts.contains("successfully created")) {
				reportPass("i Verify Device is Successfully Created", "The following  devices have been successfully created", "The following  devices have been successfully created");
				reportInfo("Device Is Created Successfully");
			}
			else {
				reportFail("Not Successfully Created","Device Is Not Created" ,"Device Is Not Created");
			}
		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}



	}

	@Then("I Verify warning message for device setting data of other device type and no tenant Id data")
	public void i_verify_warning_message_for_device_setting_data_of_other_device_type_and_no_tenant_id_data() {

		try
		{
			test = logInfo.get().createNode("I Verify warning message for device setting data of other device type and no tenant Id data");
			String VerifyWarningSts = testSetup.pageObjectManager.getDevicePage().VerifyWarningMessageForDeviceSettingDataOfOtherDeviceType();
			reportInfo("i Verify warning message for device setting data of other device type and no tenant Id data");
			reportScreenshot(testSetup.driver);
			if(VerifyWarningSts.contains("created with warnings")) {
				reportPass("verify warning Message", "The following  devices have been successfully created with warnings", "The following  devices have been successfully created with warnings");
				reportInfo("successfully Created With Warnings");

			}
			else {
				reportFail("Verify Warning Message" ,"Not Showing Warning","Not Showing Warning");
			}
			testSetup.pageObjectManager.getBulkDeviceUploadPage().clickOnFinalize();
		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I Verify  whether the uploaded device is available in the devices list, with device setting data and assigned Tenant Id {string}")
	public void i_verify_whether_the_uploaded_device_is_available_in_the_devices_list_with_device_setting_data_and_assigned_tenant_id(String tcid) {
		try
		{
			test = logInfo.get().createNode("I Verify whether the uploaded device is available in the devices list, with device setting data and assigned Tenant Id");
			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
			reportInfo(testData.toString());
			reportInfo("i verify Device Is Available In Device List");
			testSetup.pageObjectManager.getDevicePage().SearchBulkCreatedDevice(testData);
			testSetup.pageObjectManager.getDevicePage().SelectAllFields();
			reportScreenshot(testSetup.driver);
			reportInfo("device Is Created Successfully");



			reportInfo("i Verify Tenant Id Is Assigned In Device");
			String verifytenantsts = testSetup.pageObjectManager.getDevicePage().VerifyAssignedTenant(testData);
			reportScreenshot(testSetup.driver);
			if(verifytenantsts.equals(testData.get("TenantID"))) {
				reportPass("i Verify Tenant id is Assigned In Devices",verifytenantsts, verifytenantsts);
				reportInfo("tenanat Id Assigned Successfully");
			}
			else {
				reportFail("Not Assigned Successfully","false" ,"false");
			}



			reportInfo("i Verify The Device Status And Data Status Of The Device");
			String VerifyDeviceSts = testSetup.pageObjectManager.getDevicePage().VerifyDeviceStatus();
			if(VerifyDeviceSts.contains(VerifyDeviceSts)) {
				reportPass("i Verify Device Status",VerifyDeviceSts, VerifyDeviceSts);
				reportScreenshot(testSetup.driver);
				reportInfo("Device Status Updated Successfully");
			}
			else {
				reportFail("Not Updated Successfully","false" ,"false");
				reportScreenshot(testSetup.driver);
			}

			String VerifyDataSts = testSetup.pageObjectManager.getDevicePage().VerifyDataStatus();
			if(VerifyDataSts.contains(VerifyDataSts)) {
				reportPass("i Verify Data Status",VerifyDataSts, VerifyDataSts);
				reportScreenshot(testSetup.driver);
				reportInfo("Data Status Updated Successfully");
			}
			else {
				reportFail("Not Updated Successfully","false" ,"false");
				reportScreenshot(testSetup.driver);
			}



			reportInfo("i Verify Device Setting Data In Devices");

			boolean verifyDeviceSettingEnabled = testSetup.pageObjectManager.getDevicePage().verifyDeviceSettingIconEnabled();
			if(verifyDeviceSettingEnabled==true) {
				reportPass("i Verify Device Setting Data Assigned","true", "true");
			}
			else {
				reportFail("Not Assigned Successfully","false" ,"false");
			}
			testSetup.pageObjectManager.getDevicePage().navigatetoSettingViewPage();
			reportScreenshot(testSetup.driver);
			reportInfo("device Setting data Assigned Successfully");
			testSetup.pageObjectManager.getDevicePage().BackInSettingViewPage();


		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}


	@Then("I Verify  whether the uploaded device is available in the devices list, with no device setting data and assigned Tenant Id {string}")
	public void i_verify_whether_the_uploaded_device_is_available_in_the_devices_list_with_no_device_setting_data_and_assigned_tenant_id(String tcid) {
		try
		{
			test = logInfo.get().createNode("I Verify whether the uploaded device is available in the devices list, with no device setting data and assigned Tenant Id");
			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
			reportInfo(testData.toString());
			reportInfo("i verify Device Is Available In Device List");
			testSetup.pageObjectManager.getDevicePage().SearchBulkCreatedDevice(testData);
			reportScreenshot(testSetup.driver);
			reportInfo("device Is Available In Device List");



			reportInfo("i Verify Tenant Id Is Assigned In Device");
			String verifytenantsts = testSetup.pageObjectManager.getDevicePage().VerifyAssignedTenant(testData);
			System.out.println(verifytenantsts);
			reportScreenshot(testSetup.driver);
			System.out.println(testData.get("TenantID"));
			if(verifytenantsts.contains(testData.get("TenantID"))) {
				reportPass("I verify Tenant id is Assigned In Devices",verifytenantsts, verifytenantsts);
				reportInfo("Tenanat Id Assigned Successfully");
			}
			else {
				reportFail("Not Assigned Successfully","false" ,"false");
			}



			reportInfo("i Verify The Device Status And Data Status Of The Device");
			String VerifyDeviceSts = testSetup.pageObjectManager.getDevicePage().VerifyDeviceStatus();
			if(VerifyDeviceSts.contains(VerifyDeviceSts)) {
				reportPass("i Verify Device Status",VerifyDeviceSts, VerifyDeviceSts);
				reportScreenshot(testSetup.driver);
				reportInfo("device Status Updated Successfully");
			}
			else {
				reportFail("Not Updated","false" ,"false");
			}

			String VerifyDataSts = testSetup.pageObjectManager.getDevicePage().VerifyDataStatus();
			if(VerifyDataSts.contains(VerifyDataSts)) {
				reportPass("i Verify Data Status",VerifyDataSts, VerifyDataSts);
				reportScreenshot(testSetup.driver);
				reportInfo("data Status Updated Successfully");
			}
			else {
				reportFail("Not Updated","false" ,"false");
			}



			reportInfo("i Verify Device Setting Data Not Assigned In Devices");
			String verifyDeviceSettingDisabled = testSetup.pageObjectManager.getDevicePage().verifyDeviceSettingIconDisabled();
			if(verifyDeviceSettingDisabled.contains("true")) {
				reportPass("i Verify Device Setting Data Not Assigned","true", "true");
				reportInfo("device Setting data Not Assigned");
			}
			else {
				reportFail("Assigned Successfully"," Assigned" ," Assigned");
			}

			testSetup.pageObjectManager.getDevicePage().UnassignTenantInDevices();

		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I Verify  whether the uploaded device is available in the devices list, with device setting data of other device type and no tenant Id {string}")
	public void i_verify_whether_the_uploaded_device_is_available_in_the_devices_list_with_device_setting_data_of_other_device_type_and_no_tenant_id(String tcid) {
		try
		{
			test = logInfo.get().createNode("I Verify whether the uploaded device is available in the devices list, with Other device type and no Tenant Id");
			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
			reportInfo(testData.toString());
			reportInfo("i verify Device Is Available In Device List");
			testSetup.pageObjectManager.getDevicePage().SearchBulkCreatedDevice(testData);
			reportScreenshot(testSetup.driver);
			reportInfo("device Is Available In Device List");



			reportInfo("i Verify Tenant Is not Assigned In  Device");
			String verifyNotAssignedTenant = testSetup.pageObjectManager.getDevicePage().VerifyNotAssignedTenant();
			reportScreenshot(testSetup.driver);
			if(verifyNotAssignedTenant.equals("notAssigned")) {
				reportPass("I verify Tenant id is Not Assigned In Devices","true", "true");
				reportInfo("Tenanat Id Is Not Assigned");
			}
			else {
				reportFail("Tenant id Assigned Successfully","Assigned" ,"Assigned");
			}


			reportInfo("I Verify the Device status and Data status of the device");
			String VerifyDeviceSts = testSetup.pageObjectManager.getDevicePage().VerifyDeviceStatus();
			if(VerifyDeviceSts.contains(VerifyDeviceSts)) {
				reportPass("i Verify Device Status",VerifyDeviceSts, VerifyDeviceSts);
				reportScreenshot(testSetup.driver);
				reportInfo("device Status Updated Successfully");
			}
			else {
				reportFail("Not Updated Successfully","false" ,"false");
				reportScreenshot(testSetup.driver);
			}

			String VerifyDataSts = testSetup.pageObjectManager.getDevicePage().VerifyDataStatus();
			if(VerifyDataSts.contains(VerifyDataSts)) {
				reportPass("i Verify Data Status",VerifyDataSts, VerifyDataSts);
				reportScreenshot(testSetup.driver);
				reportInfo("data Status Updated Successfully");
			}
			else {
				reportFail("Not Updated Successfully","false" ,"false");
			}

			reportInfo("i Verify Device Setting Data Not Assigned In Devices");
			String verifyDeviceSettingDisabled = testSetup.pageObjectManager.getDevicePage().verifyDeviceSettingIconDisabled();
			System.out.println(verifyDeviceSettingDisabled);
			if(verifyDeviceSettingDisabled.contains("true")) {
				reportPass("i Verify Device Setting Data Not Assigned","true", "true");
				reportInfo("device Setting Data Not Assigned");
			}
			else {
				reportFail("Assigned Successfully"," Assigned" ," Assigned");
			}
			test = logInfo.get().createNode("I Delete the Device Of Other device type and no tenant id");
			testSetup.pageObjectManager.getDevicePage().deleteBulkCreatedDevice();
			reportScreenshot(testSetup.driver);
			reportInfo("Device deleted Successfully");
		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

  @Then("I verify that Bulk Upload Sync Jobs - SyncTM section is displayed post Bulk device upload")
  public void i_verify_that_device_sync_jobs_in_sync_tm_section_is_displayed_post_bulk_upload_device() {

    try {
      test = logInfo.get().createNode("I verify that Bulk Upload Sync Jobs - SyncTM section is displayed post Bulk device upload");
      test.assignCategory("Production");
      //Map<String, String> testData = ExcelFileReader.getDataInMap("Login", env);
      String syncJobs = testSetup.pageObjectManager.getHomePage().getSyncJobsDetails();
      //testSetup.pageObjectManager.getHomePage().hoverOnToolTipIcon();
      reportScreenshot(testSetup.driver);
      String status = testSetup.pageObjectManager.getHomePage().getUploadDeviceSyncJobStatus();

      if(syncJobs.contains("SyncTM (UPLOAD_DEVICE)") && (status.equals("IN_PROGRESS") || status.equals("COMPLETED"))) {
        reportPass("The Bulk Upload Sync Jobs - SyncTM section is displayed post Bulk device upload", "status = COMPLETED/IN PROGRESS" , "Status = "+status);
      }
      else {
        reportFail("The Bulk Upload Sync Jobs - SyncTM section is displayed post Bulk device upload", "status = COMPLETED/IN PROGRESS" , "Status "+status);
      }

    }
    catch(AssertionError | Exception e) {
      testStepHandle("FAIL",testSetup.driver,test,e);
    }
  }

	@Then("I Delete The Device Of With Device Setting {string}")
	public void i_delete_the_device_of_With_device_Setting(String tcid) {
		try
		{
			test = logInfo.get().createNode("I Delete The Device Of with Device Setting Data");
			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getDevicePage().SearchBulkCreatedDevice(testData);
			testSetup.pageObjectManager.getDevicePage().UnassignTenantInDevices();
			testSetup.pageObjectManager.getDevicePage().SearchBulkCreatedDevice(testData);
			testSetup.pageObjectManager.getDevicePage().deleteBulkCreatedDevice();
			reportInfo("I Delete The Device Of with Device Setting Data");
			reportScreenshot(testSetup.driver);
			reportInfo("Device deleted Successfully");

		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I Delete The Device Of No Device Setting {string}")
	public void i_delete_the_device_Of_No_Device_Setting(String tcid) {
		try
		{
			test = logInfo.get().createNode("I Delete The Device Of No Device Setting");
			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getDevicePage().SearchBulkCreatedDevice(testData);
			testSetup.pageObjectManager.getDevicePage().deleteBulkCreatedDevice();
			reportInfo("I Delete The Device Of No Device Setting");
			reportScreenshot(testSetup.driver);
			reportInfo("Device deleted Successfully");

		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}



}
