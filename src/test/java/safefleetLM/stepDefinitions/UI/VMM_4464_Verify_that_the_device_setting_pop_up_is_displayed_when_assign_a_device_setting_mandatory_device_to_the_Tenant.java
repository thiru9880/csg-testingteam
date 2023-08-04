package safefleetLM.stepDefinitions.UI;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

import java.io.IOException;
import java.util.Map;

public class VMM_4464_Verify_that_the_device_setting_pop_up_is_displayed_when_assign_a_device_setting_mandatory_device_to_the_Tenant extends BaseTest {

	TestSetup testSetup;

	public VMM_4464_Verify_that_the_device_setting_pop_up_is_displayed_when_assign_a_device_setting_mandatory_device_to_the_Tenant(TestSetup testSetup) throws IOException {
		this.testSetup = testSetup;
	}



	@Then("I Create device with device type with test data {string}")
	public void i_create_device_with_device_type_with_test_data(String tcid) {


		try {
			String deviceID=randomStringGenerator();
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",deviceID,"VMM_4464_1");
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",deviceID,"VMM_4464_1");
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","partNo",deviceID,"VMM_4464_1");
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","IMEINo",deviceID,"VMM_4464_1");




			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","Device ID",deviceID,"VMM_4464_1");




			test = logInfo.get().createNode("I Create device with device type and  test data");

			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getDevicePage().Devicecreate(testData);
			//reportScreenshot(testSetup.driver);
			 reportInfo("New Device Created successfully");


		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}
@When("I Click New button Add required data to create a tenant with testdata {string}")
public void i_click_new_button_add_required_data_to_create_a_tenant_with_testdata(String tcid) {
	try
	{
		String tenantID=randomStringGenerator();


		  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_4464_1");
		  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","EditedTenantID",tenantID,"VMM_4464_1");


		test = logInfo.get().createNode("I create new Tenant with test data");

		    test.assignCategory("Tenants");

		    testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();

		    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);

		    //testSetup.pageObjectManager.getTenantsPage().createNewTenant(testData);
        testSetup.pageObjectManager.getTenantsPage().createNewTenantSyncToTMOFF(testData);

		    reportInfo("Test data "+testData);

		    reportScreenshot(testSetup.driver);

		    reportInfo("New tenant is created with test data successfully");


	}
	catch (Exception e)
	{
		testStepHandle("FAIL", testSetup.driver, test, e);
	}

}

@When("In Available Devices section select the device type which has device setting mandatory with testdata {string}")
public void in_available_devices_section_select_the_device_type_which_has_device_setting_mandatory_with_testdata(String tcid) {
try {
	test = logInfo.get().createNode("In Available Devices section select the device type which has device setting mandatory with testdata");
    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);

	 testSetup.pageObjectManager.getTenantsPage().clickdeviceType(testData);
	 reportScreenshot(testSetup.driver);
	 reportInfo("In Available Devices section select the device type which has device setting mandatory with testdata is successfully");




	} catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}

}

@When("I Select any available device and click on Assign button with testdata {string}")
public void i_select_any_available_device_and_click_on_assign_button_with_testdata(String tcid) {
try {
	test = logInfo.get().createNode("I Select any available device and click on Assign button with testdata");
    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);

	 testSetup.pageObjectManager.getTenantsPage().assigndevice(testData);
	 reportScreenshot(testSetup.driver);
	 reportInfo("Select any available device and click on Assign button is successful");



	} catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}

}
@When("I Select Device setting and assign the device with testdata {string} and Verify in Assigned Devices section")
public void i_select_device_setting_and_assign_the_device_with_testdata_and_verify_in_assigned_devices_section(String tcid) {
	try {
		test = logInfo.get().createNode("I Select the Setting and Verify in Assigned Devices section");
		Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
		//Map<String, String> testData2 = ExcelFileReader.getDataInMap("Devices", tcid);
		//reportInfo(testData2.toString());
		testSetup.pageObjectManager.getTenantsPage().assigndevicesettinginTenantpage(testData);

		testSetup.pageObjectManager.getDevicePage().clickassignDeviceBtn();
		 reportScreenshot(testSetup.driver);
		testSetup.pageObjectManager.getTenantsPage().tenantSave();
		reportInfo("Select the Setting and Verify in Assigned Devices section successfully");


		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}


}
@Then("I verify that the tenant is listed in tenants dashboard page along with number of devices assigned details with testdata {string}")
public void i_verify_that_the_tenant_is_listed_in_tenants_dashboard_page_along_with_number_of_devices_assigned_details_with_testdata(String tcid) {
try {
	test = logInfo.get().createNode("I verify that the tenant is listed in tenants dashboard page along with number of devices assigned details");
	 Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
	testSetup.pageObjectManager.getTenantsPage().TenantSearch(testData);
	reportScreenshot(testSetup.driver);
	reportInfo("verify that the tenant is listed in tenants dashboard page along with number of devices assigned details successfully");




	} catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}

}

@Then("I Search for the Device Id I created with testdata {string} and Verify the Device status and Data status of the device after Assign")
public void i_search_for_the_device_id_i_created_with_testdata_and_Verify_the_Device_status_and_Data_status_of_the_device_after_assign(String tcid) {// deviceSearch
try {
	test = logInfo.get().createNode("I Search for the Device Id I created with testdata and Verify the Device status and Data status of the device after Assign");
	Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
	testSetup.pageObjectManager.getDevicePage().deviceSearch(testData);// verifyDevicestatustxt

	String text = testSetup.pageObjectManager.getDevicePage().verifyDevicestatustxt();
	if (text.equalsIgnoreCase("Assigned")) {
		reportPass("Device status", "Assigned", text);
		reportScreenshot(testSetup.driver);
		reportInfo("Verify the Device status successfully");

	} else {
		reportFail("Device status", "Assigned", text);
		reportScreenshot(testSetup.driver);
		reportInfo("Verify the Device status not successfully");

	}

	String text1 = testSetup.pageObjectManager.getDevicePage().verifyDatastatustxt();
	if (text1.equalsIgnoreCase("Provisioned")) {
		reportPass("Data status", "Provisioned", text1);
		reportScreenshot(testSetup.driver);
		reportInfo("Verify the Data status successfully");

	} else {
		reportFail("Data status", "Provisioned", text1);
		reportScreenshot(testSetup.driver);
		reportInfo("Verify the Data status not successfully");

	}



	reportInfo("Search for the Device Id I created with testdata and Verify the Device status and Data status of the device successfully");


	} catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}

}

@Then("I Search an existing tenant and click on edit Icon with testdata {string}")
public void i_search_an_existing_tenant_and_click_on_edit_icon_with_testdata(String tcid) {
try {
	test = logInfo.get().createNode("I Search an existing tenant and click on edit Icon");
	Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
	testSetup.pageObjectManager.getTenantsPage().TenantSearch(testData);// clickTenantEditBtn
	testSetup.pageObjectManager.getTenantsPage().clickTenantEditBtn();

	reportInfo("Search an existing tenant and click on edit Icon with testdata successfully");



	} catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}

}

@Then("In Assigned Devices section select the device and click on UNASSIGN button and Verify that the device unassign pop up window is displayed")
public void in_assigned_devices_section_select_the_device_and_click_on_unassign_button_and_Verify_that_the_device_unassign_pop_up_window_is_displayed() {
try {
	test = logInfo.get().createNode("In Assigned Devices section select the device and click on UNASSIGN button and Verify that the device unassign pop up window is displayed");
	testSetup.pageObjectManager.getTenantsPage().selectUnAssignBtn();
	String dialog = testSetup.pageObjectManager.getDevicePage().unassigndialog();
	if (dialog.contains("Are you sure you want to unassign the Device(s) with the following status?")) {
		reportPass("dialog should appear", "Are you sure you want to unassign the Device(s) with the following status?", dialog);
		reportScreenshot(testSetup.driver);
		reportInfo("Verify that the device unassign pop up window is displayed successfully");

	} else {
		reportFail("dialog should appear", "Are you sure you want to unassign the Device(s) with the following status?", dialog);
		reportScreenshot(testSetup.driver);
		reportInfo("Verify that dialog not appear to Unassign Device Settings");
	}




	} catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}

}

@Then("I Select Not Assigned option from dropdown and click on Un-Assign button with testdata {string}")
public void i_select_not_assigned_option_from_dropdown_and_click_on_un_assign_button_with_testdata(String tcid) {
try {
	test = logInfo.get().createNode("I Select the Device status with testdata and save");
	// clickUnassigndevicetxtfield
	Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
	testSetup.pageObjectManager.getDevicePage().clickUnassigndevicetxtfield(testData);

	testSetup.pageObjectManager.getTenantsPage().tenantSave();

	reportInfo("Select the Device status with testdata successfully");



	} catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}

}

@When("I verify that the tenant is listed in tenants dashboard page and no devices assigned to it with testdata {string}")
public void i_verify_that_the_tenant_is_listed_in_tenants_dashboard_page_and_no_devices_assigned_to_it_with_testdata(String tcid) {
try {
	test = logInfo.get().createNode("I verify that the tenant is listed in tenants dashboard page and no devices assigned to it");
	 Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
	testSetup.pageObjectManager.getTenantsPage().TenantSearch(testData);
	reportScreenshot(testSetup.driver);
	reportInfo("Verify that the tenant is listed in tenants dashboard page and no devices assigned to it successfully");



	} catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}

}

@Then("I Search for the Device Id I created with testdata {string} and Verify the Device status and Data status of the device after Unassign")
public void i_search_for_the_device_id_i_created_with_testdata_and_verify_the_device_status_and_data_status_of_the_device_after_unassign(String tcid) {
	try {
		test = logInfo.get().createNode("I Search for the Device Id I created with testdata and Verify the Device status and Data status of the device after Unassign");
		Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
		testSetup.pageObjectManager.getDevicePage().deviceSearch(testData);

		String text = testSetup.pageObjectManager.getDevicePage().verifyDevicestatustxt();
		if (text.equalsIgnoreCase("Not Assigned")) {
			reportPass("Device status", "Not Assigned", text);
			reportScreenshot(testSetup.driver);
			reportInfo("Verify the Device status successfully");

		} else {
			reportFail("Device status", "Not Assigned", text);
			reportScreenshot(testSetup.driver);
			reportInfo("Verify the Device status not successfully");

		}

		String text1 = testSetup.pageObjectManager.getDevicePage().verifyDatastatustxt();
		if (text1.equalsIgnoreCase("Provisioned")) {
			reportPass("Data status", "Provisioned", text1);
			reportScreenshot(testSetup.driver);
			reportInfo("Verify the Data status successfully");

		} else {
			reportFail("Data status", "Provisioned", text1);
			reportScreenshot(testSetup.driver);
			reportInfo("Verify the Data status not successfully");

		}




		reportInfo("Search for the Device Id I created with testdata and Verify the Device status and Data status of the device successfully");


		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

}


@Then("I delete the Device with testdata {string}")
public void i_delete_the_device_with_testdata(String string) throws Exception {
	try {
	test = logInfo.get().createNode("I delete the Device with testdata");
	testSetup.pageObjectManager.getDevicePage().deleteCreateddevice();
	testSetup.pageObjectManager.getDevicePage().deleteDeviceOkBtn();
	reportScreenshot(testSetup.driver);
	reportInfo("I delete the Device with testdata successfully");
	}
	catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}

}

}
