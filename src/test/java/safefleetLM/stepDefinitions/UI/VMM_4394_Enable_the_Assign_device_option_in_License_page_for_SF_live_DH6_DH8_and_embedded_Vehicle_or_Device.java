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

public class VMM_4394_Enable_the_Assign_device_option_in_License_page_for_SF_live_DH6_DH8_and_embedded_Vehicle_or_Device extends BaseTest {

	TestSetup testSetup;

	public VMM_4394_Enable_the_Assign_device_option_in_License_page_for_SF_live_DH6_DH8_and_embedded_Vehicle_or_Device(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}

	@Then("I create license for DH6 license type {string}")
	public void i_create_license_for_DH6_license_type(String tcid) {
		try {
			test = logInfo.get().createNode("I create license for DH6 license type");
			test.assignCategory("Licenses");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().createDVRFirmwareLicense(testData);
			reportScreenshot(testSetup.driver);
			String Alert = testSetup.pageObjectManager.getLicensesPage().clickOnSave();
			reportScreenshot(testSetup.driver);
			if(Alert.equalsIgnoreCase("Vmaxmanager App license.updated")) {
				reportPass("license", "Vmaxmanager App license.updated", Alert);
			//	reportInfo("create a SF commander license with crossed expiration date successfully");
			}
			else {
				reportFail("license", "Vmaxmanager App license.updated", Alert);
				reportScreenshot(testSetup.driver);
			}
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}
	
	@Then("I create license for DH8 license type {string}")
	public void i_create_license_for_DH8_license_type(String tcid) {
		try {
			test = logInfo.get().createNode("I create license for DH8 license type");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			
			testSetup.pageObjectManager.getLicensesPage().createDVRFirmwareLicense(testData);
			reportScreenshot(testSetup.driver);
			String Alert = testSetup.pageObjectManager.getLicensesPage().clickOnSave();
			reportScreenshot(testSetup.driver);
			if(Alert.equalsIgnoreCase("Vmaxmanager App license.updated")) {
				reportPass("license", "Vmaxmanager App license.updated", Alert);
			//	reportInfo("create a SF commander license with crossed expiration date successfully");
			}
			else {
				reportFail("license", "Vmaxmanager App license.updated", Alert);
				reportScreenshot(testSetup.driver);
			}

		}

		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}
	
	@Then("I verify that Assign device option is enabled for DH6 and DH8 {string}")
	public void i_verify_that_assign_device_option_is_enabled_for_dh6_and_dh8(String tcid) {
		try {
			test = logInfo.get().createNode("I verify that Assign device option is enabled for DH6 and DH8");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			String result1 = testSetup.pageObjectManager.getLicensesPage().verifyAssignDeviceForDH8(testData);
			reportScreenshot(testSetup.driver);
			if(result1.equals("false")) {
				reportPass("Assign Device", "Assign Device option enable for DH8", "Assign Device option enable for DH8");
			}
			else {
				reportFail("Assign Device", "Assign Device option enable for DH8", "Assign Device option Disable for DH8");
			}
			String result2= testSetup.pageObjectManager.getLicensesPage().verifyAssignDeviceForDH6(testData);
			reportScreenshot(testSetup.driver);
			if(result2.equals("false")) {
				reportPass("Assign Device", "Assign Device option should enable for DH6", "Assign Device option enable for DH6");
			}
			else {
				reportFail("Assign Device", "Assign Device option enable for DH6", "Assign Device option Disable for DH6");
			}
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I verify that Assign device option is enabled for SF live+ {string}")
	public void i_verify_that_assign_device_option_is_enabled_for_sf_live(String tcid) {
		try {
			test = logInfo.get().createNode("I verify that Assign device option is enabled for SF live+");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			String result = testSetup.pageObjectManager.getLicensesPage().verifyAssignDeviceForSFlive(testData);
			reportScreenshot(testSetup.driver);
			if(result.equals("false")) {
				reportPass("Assign Device", "Assign Device option should enable for SF live+", "Assign Device option is enable for SF live+");
				reportPass("Assign Device", "Assign Device option should enable for Unit/Vehicle license types", "Assign Device option enable for Unit/Vehicle license types");
			}
			else {
				reportFail("Assign Device", "Assign Device option should enable for SF live+", "Assign Device option Disable for SF live+");
				reportFail("Assign Device", "Assign Device option should enable for Unit/Vehicle license types", "Assign Device option Disable for Unit/Vehicle license types");
			}
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I verify that Assign device option is enabled for Vehicle\\/Device licenses {string}")
	public void i_verify_that_assign_device_option_is_enabled_for_vehicle_device_licenses(String tcid) {




	}
	@Then("I verify that Assign device option is disabled for all other licenses except for SF live+,DH6,DH8 and embedded Vehicle\\/Device licenses {string}")
	public void i_verify_that_assign_device_option_is_disabled_for_all_other_licenses_except_for_sf_live_dh6_dh8_and_embedded_vehicle_device_licenses(String tcid) {
		try {
			test = logInfo.get().createNode("I verify that Assign device option is disabled for all other licenses except for SF live+,DH6,DH8 and embedded Vehicle Device licenses");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			
			String result1 = testSetup.pageObjectManager.getLicensesPage().verifyBaseProductLicenseAssignDeviceOption(testData);
			reportScreenshot(testSetup.driver);
			if(result1.equals("true")) {
				reportPass("Assign Device", "Assign Device option should Disable for Base Product license type", "Assign Device option is Disable for Base Product license type");
			}
			else {
				reportFail("Assign Device", "Assign Device option should Disable for Base Product license type", "Assign Device option enable for Base Product license type");
			}

			String result2 = testSetup.pageObjectManager.getLicensesPage().verifyDeviceLicenseAssignDeviceOption(testData);
			reportScreenshot(testSetup.driver);
			if(result2.equals("true")) {
				reportPass("Assign Device", "Assign Device option should Disable for Device license type", "Assign Device option is Disable for Device license type");
			}
			else {
				reportFail("Assign Device", "Assign Device option should Disable for Device license type", "Assign Device option enable for Device license type");
			}
			
			String result3 = testSetup.pageObjectManager.getLicensesPage().verify_ADD_ON_PRODUCT_LicenseAssignDeviceOption(testData);
			reportScreenshot(testSetup.driver);
			if(result3.equals("true")) {
				reportPass("Assign Device", "Assign Device option should Disable for ADD_ON_PRODUCT license type", "Assign Device option is Disable for ADD_ON_PRODUCT license type");
			}
			else {
				reportFail("Assign Device", "Assign Device option should Disable for ADD_ON_PRODUCT license type", "Assign Device option enable for ADD_ON_PRODUCT license type");
			}
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

}
