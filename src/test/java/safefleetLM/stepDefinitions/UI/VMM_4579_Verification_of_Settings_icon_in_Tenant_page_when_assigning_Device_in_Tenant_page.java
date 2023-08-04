package safefleetLM.stepDefinitions.UI;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

import java.io.IOException;
import java.util.Map;

public class VMM_4579_Verification_of_Settings_icon_in_Tenant_page_when_assigning_Device_in_Tenant_page extends BaseTest {

	TestSetup testSetup;

	public VMM_4579_Verification_of_Settings_icon_in_Tenant_page_when_assigning_Device_in_Tenant_page(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}


	@Then("I create a new tenant for with test data {string}")
	public void i_create_new_tenant_for_with_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I create a new tenant for with test data");

			String tenantID=randomStringGenerator();

			System.out.println(tenantID);

			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_4579_1");

			// test = logInfo.get().createNode("I create a new tenant with test data");

			    testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();

			    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);

			    //testSetup.pageObjectManager.getTenantsPage().createNewTenantLicense(testData);
          testSetup.pageObjectManager.getTenantsPage().createNewTenantSyncToTMOFF(testData);
          testSetup.pageObjectManager.getTenantsPage().clickOnSaveButtonn();
//			    reportInfo("New tenant is created with test data ");


			   // reportInfo("Test data "+testData);
			    reportScreenshot(testSetup.driver);
			    reportInfo("New tenant is created Successfully ");


		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I Create device with device type and test data {string}")
	public void i_create_device_with_device_type_and_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I Create device with device type and test data");


			String deviceID=randomStringGenerator();
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",deviceID,"VMM_4579_1");
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",deviceID,"VMM_4579_1");


			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getDevicePage().NewdeviceCreate(testData);
			reportScreenshot(testSetup.driver);

		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}


	@Then("By using showfilter i get tenant ID {string}")
	public void by_using_showfilter_i_get_tenant_id(String tcid) {
		try {
			test = logInfo.get().createNode("By using showfilter i get tenant ID ");


			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());

			testSetup.pageObjectManager.getTenantsPage().navigateToTenantCheck();
			testSetup.pageObjectManager.getTenantsPage().navigateToTenantCheck();

			testSetup.pageObjectManager.getLicensesPage().searchTenant(testData);
			reportScreenshot(testSetup.driver);

			testSetup.pageObjectManager.getTenantsPage().clickOnTenantEdit();

			reportInfo("I get created tenant ID by using show filter Successfully");

		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}


	@Then("I select device type created by devices and I will assign the devices {string}")
	public void i_select_device_type_created_by_devices_and_i_will_assign_the_devices(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I select device type created by devices and I will assign the devices ");
			test.assignCategory("Tenants");

		Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
		reportInfo(testData.toString());

		testSetup.pageObjectManager.getTenantsPage().selectDeviceType(testData);
		reportScreenshot(testSetup.driver);

		reportInfo("I select a device type Successfully");
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I Assign the devices to the tenant i created {string}")
	public void i_assign_the_devices_to_the_tenant_i_created(String tcid) {
		try {
			test = logInfo.get().createNode("I Assign the devices to the tenant i created");

			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			testSetup.pageObjectManager.getTenantsPage().clickemptyTextFieldBtn(testData);//clickassignDeviceBtn
			reportScreenshot(testSetup.driver);

			testSetup.pageObjectManager.getDevicePage().clickassignDeviceBtn();// saveDevice
			reportScreenshot(testSetup.driver);
			reportInfo("I assign a devices Successfully");
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}


	@Then("I verify that setting icon for Assign devices is Enabled")
	public void i_verify_that_setting_icon_for_assign_devices_is_Enabled() {
		try {
			test = logInfo.get().createNode("I verify that setting icon for Assign devices is Enabled");


			Boolean BtEnable = testSetup.pageObjectManager.getTenantsPage().AssignDeviceSettingBtn();
			if (BtEnable==true) {
				reportPass("setting button is Enabled", "true", "true");
				reportScreenshot(testSetup.driver);
				reportInfo("Verify that setting button is Enabled");

			} else {
				reportFail("setting button", "false","false");
				reportScreenshot(testSetup.driver);
				reportInfo("Verify that setting button not Enabled");
			}

		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}


	@Then("I Unassign the devices and click On save {string}")
	public void i_unassign_the_devices_and_click_on_save(String tcid) {
		try {
			test = logInfo.get().createNode("I Unassign the devices and click On save");

			testSetup.pageObjectManager.getTenantsPage().selectUnAssignBtn();
			reportScreenshot(testSetup.driver);

			//Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
			//testSetup.pageObjectManager.getDevicePage().clickUnassigndevicetxtfield(testData);

			//testSetup.pageObjectManager.getDevicePage().clickUnassignBtn();
				//testSetup.pageObjectManager.getDevicePage().clickUnassigndevicetxtfield(testData);
				//testSetup.pageObjectManager.getTenantsPage().tenantSave();

		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I create a new tenant with test data {string}")
	public void i_create_new_tenant_for_vmm4579_2_with_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I create a new tenant with test data");

			String tenantID=randomStringGenerator();

			System.out.println(tenantID);

			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_4579_2");

		//	 test = logInfo.get().createNode("I create a new tenant with test data");

			    testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();

			    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);

			    //testSetup.pageObjectManager.getTenantsPage().createNewTenantLicense(testData);
          testSetup.pageObjectManager.getTenantsPage().createNewTenantSyncToTMOFF(testData);
          testSetup.pageObjectManager.getTenantsPage().clickOnSaveButtonn();
//			    reportInfo("New tenant is created with test data ");


			   // reportInfo("Test data "+testData);
			    reportScreenshot(testSetup.driver);
			    reportInfo("New tenant is created Successfully ");
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I Create Device with a device type and test data {string}")
	public void i_Create_Device_with_a_device_type_and_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I Create Device with a device type and test data");


			String deviceID=randomStringGenerator();
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",deviceID,"VMM_4579_2");
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",deviceID,"VMM_4579_2");
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",deviceID,"VMM_4758_2");
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",deviceID,"VMM_4758_2");
             UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","DeviceID",deviceID,"VMM_4758_2");

			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getDevicePage().NewdeviceCreate(testData);
			reportScreenshot(testSetup.driver);

		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}


	@Then("I verify that setting icon for Assign devices is Disabled")
	public void i_verify_that_setting_icon_for_assign_devices_is_Disabled() {
		try {
			test = logInfo.get().createNode("I verify that setting icon for Assign devices is Disabled");


			Boolean BtDisable = testSetup.pageObjectManager.getTenantsPage().AssignDeviceSettingDisabledBtn();
			if (BtDisable==true) {
				reportPass("setting button is Disabled", "true", "true");
				reportScreenshot(testSetup.driver);
				reportInfo("Verify that setting button is Disabled");

			} else {
				reportFail("setting button", "false","false");
				reportScreenshot(testSetup.driver);
				reportInfo("Verify that setting button not Disabled");
			}
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
}

