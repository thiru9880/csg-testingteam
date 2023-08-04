package safefleetLM.stepDefinitions.UI;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import safefleetLM.componentgroups.ResponseTags;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.GenerateBearerToken;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_4755_Sync_all_the_devices_created_via_bulk_operation_except_for_SF_Live_devices extends BaseTest {

	TestSetup testSetup;
	Response response = null;

	public VMM_4755_Sync_all_the_devices_created_via_bulk_operation_except_for_SF_Live_devices(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}

	@Then("I create a cloud-commercial tenant {string}")
	public void i_create_a_cloud_commercial_tenant(String tcid) {

		try {
			String tenantID=randomStringGenerator();
            UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM4755_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM4755_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM4755_2");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM4755_3");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM4755_4");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",tenantID,"VMM4755_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"EcosytemSetting","TenantID",tenantID,"VMM4755_1");

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM_4755_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Tenant ID",tenantID,"VMM4755_3");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM_4755_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Tenant ID",tenantID,"VMM4755_4");


			test = logInfo.get().createNode("I create an cloud-commercial tenant");
			test.assignCategory("Integration with TM");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getTenantsPage().createNewTenant(testData);
			reportInfo("I create an cloud-commercial tenant");
			reportScreenshot(testSetup.driver);
			String Alertmsg = testSetup.pageObjectManager.getTenantsPage().tenantSave(testData);
			reportInfo("Tenant Created Successfully");
			reportScreenshot(testSetup.driver);
			if(Alertmsg.contains("A new Tenant is created with identifier")) {
				reportPass("Tenant ", Alertmsg, Alertmsg);
				reportInfo("Tenant created successfully");
			}
			else {
				reportFail("Tenant ", "Not Created", "Not Created");}
			}

			catch (Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}


	}

	@Then("I upload devices from spreadsheet via Bulk upload operation {string}")
	public void i_click_on_bulk_upload_i_upload_all_the_devices_in_spread_sheet(String tcid) {
		try
		{
    		String deviceID1 = randomDeviceStringGenerator();
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",deviceID1,"VMM4755_1");
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",deviceID1,"VMM4755_1");
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM_4755_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Device ID",deviceID1,"VMM4755_1");
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM_4755_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Serial #",deviceID1,"VMM4755_1");

    		Thread.sleep(1000);
    		String deviceID2 = randomDeviceStringGenerator();
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",deviceID2,"VMM4755_2");
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",deviceID2,"VMM4755_2");
    		//UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","MAC Address",deviceID2,"VMM4755_2");
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM_4755_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Device ID",deviceID2,"VMM4755_2");
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM_4755_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Serial #",deviceID2,"VMM4755_2");
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM_4755_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","MAC Address",deviceID2,"VMM4755_2");

    		Thread.sleep(1000);
    		String deviceID3 = randomDeviceStringGenerator();
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",deviceID3,"VMM4755_3");
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",deviceID3,"VMM4755_3");
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","DeviceID",deviceID3,"VMM4755_1");
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM_4755_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Device ID",deviceID3,"VMM4755_3");
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM_4755_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Serial #",deviceID3,"VMM4755_3");

    		Thread.sleep(1000);
    		String deviceID4 = randomDeviceStringGenerator();
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",deviceID4,"VMM4755_4");
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",deviceID4,"VMM4755_4");
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","DeviceID2",deviceID4,"VMM4755_1");
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM_4755_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Device ID",deviceID4,"VMM4755_4");
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM_4755_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Serial #",deviceID4,"VMM4755_4");
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM_4755_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","MAC Address",deviceID4,"VMM4755_4");

    		System.out.println(deviceID1);
    		System.out.println(deviceID2);
    		System.out.println(deviceID3);
    		System.out.println(deviceID4);

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


	@Then("I verify all the devices are created successfully")
	public void i_verify_all_the_device_is_created_successfully_with_no_error_or_warning_message() {
		try
		{
			test = logInfo.get().createNode("I Verify All the device is created successfully");
			String VerifyCreatedSts = testSetup.pageObjectManager.getDevicePage().verifyDeviceIsCreatedSuccessfully();
			reportInfo("i Verify Device is Created Successfully");
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getDevicePage().ArrowUpForDeviceIsCreatedSuccessfully();
			if(VerifyCreatedSts.contains("The following 4 devices have been successfully created.")) {
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

	@Then("I create Base App licence for the tenant created {string}")
	public void i_create_base_app_licences_for_the_tenant_created(String tcid) throws Exception {
		try {

			test = logInfo.get().createNode("I create Base App licence for the tenant created");
			test.assignCategory("Integration with TM");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().addLicensesforBaseProduct(testData);
			testSetup.pageObjectManager.getLicensesPage().searchLicense(testData);
			reportScreenshot(testSetup.driver);
			reportInfo("Base App license for the tenant with TenantID: " +testData.get("TenantID") + " is created successfully"   );

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I create Asset licence for the tenant created {string}")
	public void i_create_asset_licences_for_the_tenant_created(String tcid) throws Exception {
		try {

			test = logInfo.get().createNode("I create Asset licence for the tenant created");
			test.assignCategory("Integration with TM");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().createNewLicenseWithoutServer(testData);
			testSetup.pageObjectManager.getLicensesPage().searchLicense(testData);
			reportScreenshot(testSetup.driver);
			reportInfo("Asset license for the tenant with TenantID: " +testData.get("TenantID") + " is created successfully"   );

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I verify that Assign Device option is enabled for AVL GPS Tracking Asset license {string}")
	public void i_verify_that_assign_device_option_is_enabled_for_avl_gps_tracking_asset_license(String tcid) {
		try {
			test = logInfo.get().createNode("I verify that Assign device option is enabled for AVL GPS Tracking Asset license");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			String result = testSetup.pageObjectManager.getLicensesPage().verifyAssignDeviceOptionEnabledOrNot(testData);
			reportScreenshot(testSetup.driver);
			if(result.equals("false")) {
				reportPass("Assign Device", "Assign Device option should enable for AVL GPS Tracking Asset license type", "Assign Device option should enable for AVL GPS Tracking Asset license type");
			}
			else {
				reportFail("Assign Device", "Assign Device option is not enabled for AVL GPS Tracking Asset license type", "Assign Device option is not enabled for AVL GPS Tracking Asset license type");
        reportInfo("Failed");
      }
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I verify that Assign Device option is not enabled for Lane Enforcement Asset license {string}")
	public void i_verify_that_assign_device_option_is_enabled_for_lane_enforcement_asset_license(String tcid) {
		try {
			test = logInfo.get().createNode("I verify that Assign device option is enabled for Lane Enforcement Asset license");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			String result = testSetup.pageObjectManager.getLicensesPage().verifyAssignDeviceOptionEnabledOrNot(testData);
			reportScreenshot(testSetup.driver);
			if(result.equals("true")) {
				reportPass("Assign Device", "Assign Device option is not enabled for Lane Enforcement Asset license type", "Assign Device option is not enabled for Lane Enforcement Asset license type");
			}
			else {
				reportFail("Assign Device", "Assign Device option is enabled for Lane Enforcement Asset license type", "Assign Device option is enabled for Lane Enforcement Asset license type");
			}
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I assign a device without device settings to license {string}")
	public void i_assign_a_device_without_device_settings_to_license(String tcid) {

		try {
			test = logInfo.get().createNode("I assign a device without device settings to license");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			//testSetup.pageObjectManager.getLicensesPage().showFilterClick();
			testSetup.pageObjectManager.getLicensesPage().filterLicenseWithMultiCondition(testData);
			Map<String, String> testData2 = ExcelFileReader.getDataInMap("Devices", tcid);
			reportInfo(testData2.toString());
			testSetup.pageObjectManager.getLicensesPage().SelectAssignDevicesInLicense();
			testSetup.pageObjectManager.getLicensesPage().DeviceAssignToLicense(testData2);
			reportInfo("I Assign The Device to the License");
			reportScreenshot(testSetup.driver);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I assign a device with device settings to license {string}")
	public void i_assign_a_device_with_device_settings_to_license(String tcid) {

		try {
			test = logInfo.get().createNode("I assign a device with device settings to license");
			Map<String, String> testData2 = ExcelFileReader.getDataInMap("Devices", tcid);
			reportInfo(testData2.toString());
			//testSetup.pageObjectManager.getLicensesPage().SelectAssignDevicesInLicense();
			testSetup.pageObjectManager.getLicensesPage().LicenseAssignToDevice(testData2);
			testSetup.pageObjectManager.getLicensesPage().ConformAssignDevice(testData2);
			reportScreenshot(testSetup.driver);
			reportInfo("I Assign The Device to the License");


		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I publish the first licenses {string}")
	public void i_publish_the_first_license(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I publish the licenses");
		Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
		reportInfo(testData.toString());
		testSetup.pageObjectManager.getLicensesPage().filterLicenseWithTenantAndBaseApp(testData);
		testSetup.pageObjectManager.getLicensesPage().publishLicense();
		//String AlertMsg = testSetup.pageObjectManager.getLicensesPage().publishLicense(testData);
		reportScreenshot(testSetup.driver);
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("","" ,"Unable to create license" );
		}
	}

	@Then("I publish the filtered licenses {string}")
	public void i_publish_the_filtered_license(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I publish the licenses");
		Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
		reportInfo(testData.toString());
		testSetup.pageObjectManager.getLicensesPage().filterLicenseWithMultiCondition(testData);
		testSetup.pageObjectManager.getLicensesPage().publishLicense();
		//String AlertMsg = testSetup.pageObjectManager.getLicensesPage().publishLicense(testData);
		reportScreenshot(testSetup.driver);
		/*
		if(AlertMsg.equals("Vmaxmanager App license.updated"))
		{
			reportPass("license", "Vmaxmanager App license.updated", AlertMsg);
			reportInfo("License published successfully");
		}
		else
			reportFail("App license ", "Vmaxmanager App license.updated", AlertMsg);*/
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("","" ,"Unable to create license" );
		}
	}

	@Then("I verify in TM Swagger, that the devices created via bulk operation except for AVL GPS Tracking devices will be synced to TM {string}")
	public void i_verify_in_tm_swagger_that_the_devices_created_via_bulk_operation_except_for_avl_gps_tracking_devices_will_not_be_synced_to_tm(String tcid) {

		try {
			test = logInfo.get().createNode("I Verify in TM Swagger, that the devices created via bulk operation except for AVL GPS Tracking devices will be synced to TM {string}");

			Map<String, String> testData = ExcelFileReader.getDataInMap("GetTenant", tcid);
			reportInfo(testData.toString());
			String BearerToken = GenerateBearerToken.tenantManagerApi();

			response = given().header("Authorization", BearerToken).baseUri(tenantManager_baseURI).and().when().get("/tenant/"+testData.get("TenantID")).then().extract().response();

			if (response!=null) {
				reportInfo("API triggered Successfully");
			}

			String resString = response.then().extract().asPrettyString();

			validateField("Staus Code ","200", String.valueOf(response.getStatusCode()));

			JsonPath js = new JsonPath(resString);

			reportPayload(response.getBody().asPrettyString());

			validateField("TenantID", testData.get("TenantID"), js.getString(ResponseTags.GetTenantDetails_TENANTID));
			validateField("ApplicationID", testData.get("ApplicationID"), js.getString(ResponseTags.GetTenantDetails_APPLICATIONID));
			validateField("ApplicationID", testData.get("ApplicationID2"), js.getString(ResponseTags.GetTenantDetails_APPLICATIONID2));

			int devicesCount= js.getList(ResponseTags.GetTenantDetails_DEVICES).size();
			validateField("Total number of Devices in TM", "2" , Integer.toString(devicesCount));

			//Device 1
			validateField("deviceId", testData.get("DeviceID"), js.getString(ResponseTags.GetTenantDetails_DEVICEID));
			validateField("DeviceType", testData.get("DeviceType"), js.getString(ResponseTags.GetTenantDetails_DeviceType));

			//Device 2
			validateField("deviceId", testData.get("DeviceID2"), js.getString(ResponseTags.GetTenantDetails_DEVICEID2));
			validateField("DeviceType", testData.get("DeviceType2"), js.getString(ResponseTags.GetTenantDetails_DeviceType2));

		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I Unassign the Device from Asset License in License {string}")
	public void i_unassign_device_in_license(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I Unassign the Device In License");
		Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
		reportInfo(testData.toString());
		testSetup.pageObjectManager.getLicensesPage().filterLicenseWithMultiCondition(testData);
		testSetup.pageObjectManager.getLicensesPage().SelectAssignDevicesInLicense();
		testSetup.pageObjectManager.getLicensesPage().UnAssignDevice();
		testSetup.pageObjectManager.getLicensesPage().UnAssignDevice();
		reportInfo("I UnAssign The Device in License");
		reportScreenshot(testSetup.driver);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}



}
