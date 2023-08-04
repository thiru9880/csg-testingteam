package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3852_DeviceSettingsAndAssignDevices extends BaseTest {

	TestSetup testSetup;

	public VMM_3852_DeviceSettingsAndAssignDevices(TestSetup testSetup) throws IOException {
		this.testSetup = testSetup;
	}

	@Then("I navigate to Device Type Tab to select device")
	public void i_navigate_to_device_type_tab_to_select_device() {
		try {
			test = logInfo.get().createNode("I select device for which require device setting is unchecked");
			test.assignCategory("Devices");
			testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
			testSetup.pageObjectManager.getHomePage().navigateToDeviceTypesTab();
			reportScreenshot(testSetup.driver);
			reportInfo("Require device setting is unchecked for DH6 device");
		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I create new tenant for VMM3852 with test data {string}")
	public void i_create_new_tenant_for_vmm3852_with_test_data(String tcid) {
		try {
			  String tenantID=randomStringGenerator();

			  String MACAddress=getRamdomMAcAddress();

			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM-3852_1");

			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3852_1");

			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","TenantID",tenantID,"VMM-3852_1");

			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","MAC Address",MACAddress,"VMM-3852_1");

			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",tenantID,"VMM-3852_1");

			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",tenantID,"VMM-3852_1");


			   test = logInfo.get().createNode("I create new tenant with test data");

			    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);

			    testSetup.pageObjectManager.getTenantsPage().createNewTenantSyncToTMOFF(testData);
          testSetup.pageObjectManager.getTenantsPage().clickOnSaveButtonn();

			    reportInfo("New tenant is created with test data ");

			    reportInfo("Test data "+testData);

			    reportScreenshot(testSetup.driver);
			}
			catch(Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	}
	@Then("I Create a device and assign tenant with device type and test data {string}")
	public void i_create_a_device_and_assign_tenant_with_device_type_and_test_data(String tcid) {
		try {

//			String serialID=randomStringGenerator();
//
//			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",serialID,"VMM-3852_1");

			   test = logInfo.get().createNode("I Create a device and assign tenant with device type ");

			    Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);

			    testSetup.pageObjectManager.getDevicePage().NewdeviceCreate(testData);


			    reportInfo("Test data "+testData);

			    reportScreenshot(testSetup.driver);
			}
			catch(Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	}
	@Then("I create license with VEHICLE license type with test data {string}")
	public void i_create_license_with_unit_vehicle_license_type_with_test_data(String tcid) {
		try {
			testSetup.pageObjectManager. getHomePage().navigateToLicensesTab();

			test = logInfo.get().createNode("I create license with UNIT/VEHICLE license type with test data");

			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

			testSetup.pageObjectManager.getLicensesPage().createNewLicense(testData);

			reportInfo("Created new license with test data "+testData);

			reportScreenshot(testSetup.driver);
			}
			catch(Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	}

	@Then("I verify setting button is disabled with test data {string}")
	public void i_verify_setting_button_is_disabled_with_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I verify setting button is disabled with test data");

	    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

			testSetup.pageObjectManager.getLicensesPage().verifyActionButton(testData);

			reportInfo("Verified setting button is disabled with test data");

			reportScreenshot(testSetup.driver);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	@Then("I delete the created license {string}")
	public void i_delete_the_created_license(String tcid) {
		try {
			test = logInfo.get().createNode("I delete the license");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
			testSetup.pageObjectManager.getHomePage().navigateToLicenseTab();
			testSetup.pageObjectManager.getLicensesPage().searchTenant(testData);
			testSetup.pageObjectManager.getLicensesPage().deleteCreatedLicense();
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getLicensesPage().deleteConformationLicense();
			reportInfo("License deleted Successfully");

		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
}
