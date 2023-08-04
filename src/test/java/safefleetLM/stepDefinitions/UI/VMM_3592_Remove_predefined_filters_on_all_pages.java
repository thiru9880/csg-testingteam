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

public class VMM_3592_Remove_predefined_filters_on_all_pages extends BaseTest {

	TestSetup testSetup;

	public VMM_3592_Remove_predefined_filters_on_all_pages(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}

	@Then("I create a new tenant for with test datas {string}")
	public void i_create_new_tenant_for_with_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I create a new tenant for with test data");

			String tenantID=randomStringGenerator();

			System.out.println(tenantID);

			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_3592_1");
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM_3592_1");
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"EcosytemSetting","TenantID",tenantID,"VMM_3592_1");

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




	@Then("I Verify that there is no pre-defined filter on the Tenants page {string}")
	public void i_verify_that_there_is_no_pre_defined_filter_on_the_tenants_page(String tcid) {
		try {
			test = logInfo.get().createNode("I Verify that there is no pre-defined filter on the Tenants page");
			test.assignCategory("Others");

			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getTenantsPage().TenantSearch(testData);
			reportScreenshot(testSetup.driver);

			testSetup.pageObjectManager.getTenantsPage().TenantSearchWithClearValue(testData);
			reportScreenshot(testSetup.driver);


			reportInfo("I verify that there is no predefined filter on tanant page successfully");
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}


	@Then("I Verify that there is no pre-defined filter on the Licenses page {string}")
	public void i_verify_that_there_is_no_pre_defined_filter_on_the_licenses_page(String tcid) {
		try {
			test = logInfo.get().createNode("I Verify that there is no pre-defined filter on the Licenses page");

			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().licenseSearch(testData);
			reportScreenshot(testSetup.driver);

			testSetup.pageObjectManager.getLicensesPage().licenseSearchWithClearValue(testData);
			reportScreenshot(testSetup.driver);


			reportInfo("I verify that there is no predefined filter in licenses page successfully");
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I create device with device type and test data {string}")
	public void i_create_device_with_device_type_and_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I Create device with device type and test data");



			String deviceID=randomStringGenerator();
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",deviceID,"VMM_3592_1");
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",deviceID,"VMM_3592_1");

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


	@Then("I Verify that there is no pre-defined filter on the Devices page {string}" )
	public void i_verify_that_there_is_no_pre_defined_filter_on_the_devices_page(String tcid) {
		try {
			test = logInfo.get().createNode("I Verify that there is no pre-defined filter on the Devices page");

			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getDevicePage().deviceSearch(testData);
			reportScreenshot(testSetup.driver);

			testSetup.pageObjectManager.getDevicePage().deviceSearchWithClearValue(testData);
			reportScreenshot(testSetup.driver);


			reportInfo("I verify that there is no predefined filter in devices page successfully");
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}


	@Then("I Verify that there is no pre-defined filter on the Device Settings page {string}")
	public void i_verify_that_there_is_no_pre_defined_filter_on_the_device_settings_page(String tcid) {
		try {
			test = logInfo.get().createNode("I Verify that there is no pre-defined filter on the Device Settings page");

			testSetup.pageObjectManager. getHomePage().navigateToDeviceSettingsTab();

			Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getDeviceSettingsPage().deviceSettingSearch(testData);
			reportScreenshot(testSetup.driver);

			testSetup.pageObjectManager.getDeviceSettingsPage().deviceSettingSearchWithClearValue(testData);
			reportScreenshot(testSetup.driver);

			reportInfo("I verify that there is no predefined filter in device settings page successfully");
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}


	}
	@Then("I Verify that there is no pre-defined filter on the Ecosystem setting page {string}")
	public void i_verify_that_there_is_no_pre_defined_filter_on_the_ecosystem_settings_page(String tcid) {
		try {
			test = logInfo.get().createNode("I Verify that there is no pre-defined filter on the Ecosystem setting page");

			Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getEcosystemSettingsPage().EcosystemSettingSearch(testData);
			reportScreenshot(testSetup.driver);

			testSetup.pageObjectManager.getEcosystemSettingsPage().EcosystemSettingSearchWithClearValue(testData);
			reportScreenshot(testSetup.driver);

			reportInfo("I verify that there is no predefined filter in Ecosystem setting page successfully");
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}



	@Then("I delete the licenses {string}")
	public void i_delete_the_licenses(String tcid) {

		try {
			test = logInfo.get().createNode("I delete the licenses");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().licenseSearch(testData);

			testSetup.pageObjectManager.getLicensesPage().ClickExpandBtn();
			reportScreenshot(testSetup.driver);

			testSetup.pageObjectManager.getLicensesPage().ClickDeleteOkBtn();
			reportScreenshot(testSetup.driver);


		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}


	@Then("I Delete a device settings {string}")
	public void i_Delete_device_settings(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I delete a device settings");
			Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getDeviceSettingsPage().FilterDeviceSettings(testData);
			String alert = testSetup.pageObjectManager.getDeviceSettingsPage().DeleteDeviceSetting1();
			reportScreenshot(testSetup.driver);
			if(alert.equalsIgnoreCase("A Settings is deleted with identifier "+testData.get("DeviceName")))
				reportPass("Alert messaeg", "A Settings is deleted with identifier "+testData.get("DeviceName"), alert);
			else
				reportFail("Alert messaeg", "A Settings is deleted with identifier "+testData.get("DeviceName"), alert);
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}


	@Then("I Delete Ecosystem Settings {string}")
	public void i_Delete_Ecosystem_Settings(String tcid) {
		try {
		  test = logInfo.get().createNode("I delete the Ecosystem Setting and verify");
		  Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting",tcid );
		  testSetup.pageObjectManager.getEcosystemSettingsPage().searchecosetting(testData);
		  testSetup.pageObjectManager.getEcosystemSettingsPage().deletedata();
		  reportScreenshot(testSetup.driver);
		 // reportInfo("I delete the Ecosystem Setting verify successfully");
		  testSetup.pageObjectManager.getEcosystemSettingsPage().searchecosetting(testData);
		  reportScreenshot(testSetup.driver);

		  testSetup.pageObjectManager.getEcosystemSettingsPage().ClickOnEcosystemDeleteBtn();
		  reportScreenshot(testSetup.driver);

		reportInfo("I delete the Ecosystem Setting and verify successfully");
	}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
}
