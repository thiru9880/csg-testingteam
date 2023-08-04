package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;


public class VMM_5662_Prod_Verify_LM_Licenses_screen_and_readonly_functionality extends BaseTest {

	TestSetup testSetup;
	ArrayList<String> expListOfDeviceTypes;
	String env = getProperty("Environment");

	public VMM_5662_Prod_Verify_LM_Licenses_screen_and_readonly_functionality(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}

	@Then("I click on NEW license button")
	public void i_click_on_new_license_button() {

		try {
			test = logInfo.get().createNode("I click on NEW license button");
			testSetup.pageObjectManager.getLicensesPage().clickOnNewLicenseBtn();
			reportScreenshot(testSetup.driver);

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I select Tenant ID and Base App as Embedded Entity and verify that License type dropdown displays the corresponding licenses {string}")
	public void i_select_tenant_id_and_base_app_as_Embedded_Entity_and_verify_that_License_type_dropdown_displays_the_corresponding_licenses(String tcid) {

		try {
			test = logInfo.get().createNode("I select Tenant ID and Base App as Embedded Entity and verify that License type dropdown displays the corresponding licenses");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().selectTenantId(testData);
			testSetup.pageObjectManager.getLicensesPage().selectBaseApp(testData);
			String[] expLicenseTypes  = {"DH6","DH8","NH16","NH16K","TH8","TH12","LaneEnf","LPA","DH4v2","Generic_Manufacturing"};
			List<String> actLicenseTypes = testSetup.pageObjectManager.getLicensesPage().getListOfLicenseTypes(expLicenseTypes);
			reportScreenshot(testSetup.driver);

			if(	actLicenseTypes.containsAll(Arrays.asList(expLicenseTypes)))
			{
				reportPass("Verified Embedded Entity License types list", Arrays.toString(expLicenseTypes), actLicenseTypes.toString());

			}
			else {
				reportFail("Embedded Entity License types list verification failed", Arrays.toString(expLicenseTypes), actLicenseTypes.toString());
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I select License Type as DH8 and verify the corresponding mandatory fields {string}")
	public void i_select_license_type_as_DH8_and_verify_the_corresponding_mandatory_fields(String tcid) {

		try {
			test = logInfo.get().createNode("I select License Type as DH8 and verify the corresponding mandatory fields");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().selectLicenseType(testData);
			boolean result = testSetup.pageObjectManager.getLicensesPage().verifyMandatoryFieldsForEmbeddedEntity();
			reportScreenshot(testSetup.driver);
			if(result==true) {
				reportPass("Verification of mandatory fields for DH8 License type", "The QTY, Software Version & Part number fields are mandatory" , "The QTY, Software Version & Part number fields are mandatory");
			}
			else {
				reportFail("Verification of mandatory fields for DH8 License type", "The QTY, Software Version & Part number fields are mandatory" , "The QTY, Software Version & Part number fields are not mandatory");
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I change the Base App as Evidence Management and verify that License type dropdown displays the corresponding licenses {string}")
	public void i_change_base_app_as_Evidence_Management_and_verify_that_License_type_dropdown_displays_the_corresponding_licenses(String tcid) {

		try {
			test = logInfo.get().createNode("I change the Base App as Evidence Management and verify that License type dropdown displays the corresponding licenses");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().selectBaseApp(testData);
			String[] expLicenseTypes  = {"Base App","Asset - BWC","Asset - ICV","Add-on Module - Cloud Courier"};
			List<String> actLicenseTypes = testSetup.pageObjectManager.getLicensesPage().getListOfLicenseTypes(expLicenseTypes);
			reportScreenshot(testSetup.driver);

			if(	actLicenseTypes.equals(Arrays.asList(expLicenseTypes)))
			{
				reportPass("Verified Evidence Management License types list", Arrays.toString(expLicenseTypes), actLicenseTypes.toString());

			}
			else {
				reportFail("Evidence Management License types list verification failed", Arrays.toString(expLicenseTypes), actLicenseTypes.toString());
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I select License Type as Base App and Verify that Server field is not mandatory {string}")
	public void i_select_license_type_as_base_app_for_Evidence_Management_and_verify_the_corresponding_mandatory_fields(String tcid) {

		try {
			test = logInfo.get().createNode("I select License Type as Base App and verify the corresponding mandatory fields");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().selectLicenseType(testData);
			boolean result = testSetup.pageObjectManager.getLicensesPage().verifyMandatoryFieldsFortBaseApp();
			reportScreenshot(testSetup.driver);
			if(result==true) {
				reportPass("Verification of mandatory fields for Base App License type", "The Server & Part number fields are mandatory" , "The Server & Part number fields are mandatory");
			}
			else {
				reportFail("Verification of mandatory fields for Base App License type", "The Server & Part number fields are mandatory" , "The Server & Part number fields are not mandatory");
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I change the Base App as Cloud Starter and verify that License type dropdown displays the corresponding licenses {string}")
	public void i_change_base_app_as_Cloud_Starter_and_verify_that_License_type_dropdown_displays_the_corresponding_licenses(String tcid) {

		try {
			test = logInfo.get().createNode("I change the Base App as Cloud Starter and verify that License type dropdown displays the corresponding licenses");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().selectBaseApp(testData);
			String[] expLicenseTypes  = {"Base App","Asset - CleverIVN","Asset - J1939","Asset - INIT"};
			List<String> actLicenseTypes = testSetup.pageObjectManager.getLicensesPage().getListOfLicenseTypes(expLicenseTypes);
			reportScreenshot(testSetup.driver);

			if(	actLicenseTypes.equals(Arrays.asList(expLicenseTypes)))
			{
				reportPass("Verified Cloud Starter License types list", Arrays.toString(expLicenseTypes), actLicenseTypes.toString());

			}
			else {
				reportFail("Cloud Starter License types list verification failed", Arrays.toString(expLicenseTypes), actLicenseTypes.toString());
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I select License Type as Asset for Cloud Starter and Verify that Qty ,Part & Charge type fields are mandatory {string}")
	public void i_select_license_type_as_asset_for_Cloud_Starter_and_verify_the_corresponding_mandatory_fields(String tcid) {

		try {
			test = logInfo.get().createNode("I select License Type as Asset for Cloud Starter and Verify that Qty ,Part & Charge type fields are mandatory");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().selectLicenseType(testData);
			boolean result = testSetup.pageObjectManager.getLicensesPage().verifyMandatoryFieldsForAsset();
			reportScreenshot(testSetup.driver);
			if(result==true) {
				reportPass("Verification of mandatory fields for Asset License type", "The Qty, Part & Charge type fields are mandatory" , "The Qty, Part & Charge type fields are mandatory");
			}
			else {
				reportFail("Verification of mandatory fields for Asset License type", "The Qty, Part & Charge type fields are mandatory" , "The Qty, Part & Charge type fields are not mandatory");
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I change the Base App as AVL GPS Tracking and and verify that License type dropdown displays the corresponding licenses {string}")
	public void i_change_base_app_as_AVL_GPS_Tracking_and_verify_that_License_type_dropdown_displays_the_corresponding_licenses(String tcid) {

		try {
			test = logInfo.get().createNode("I change the Base App as AVL GPS Tracking and and verify that License type dropdown displays the corresponding licenses");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().selectBaseApp(testData);
			String[] expLicenseTypes  = {"Base App","Asset","Add-on Module - Live Streaming","Add-on Module - Device Health","Add-on Module - Student Tracking","Add-on Module - Zonar Integration","Add-on Module - Transfinder Integration","User"};
			List<String> actLicenseTypes = testSetup.pageObjectManager.getLicensesPage().getListOfLicenseTypes(expLicenseTypes);
			reportScreenshot(testSetup.driver);

			if(	actLicenseTypes.equals(Arrays.asList(expLicenseTypes)))
			{
				reportPass("Verified AVL GPS Tracking License types list", Arrays.toString(expLicenseTypes), actLicenseTypes.toString());

			}
			else {
				reportFail("AVL GPS Tracking License types list verification failed", Arrays.toString(expLicenseTypes), actLicenseTypes.toString());
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I select Add-on Module - Device Health and Verify that only part, Inaugural date & Charge type fileds are mandatory {string}")
	public void i_select_license_type_as_add_on_module_and_verify_the_corresponding_mandatory_fields(String tcid) {

		try {
			test = logInfo.get().createNode("I select Add-on Module - Device Health and Verify that only part, Inaugural date & Charge type fileds are mandatory");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().selectLicenseType(testData);
			boolean result = testSetup.pageObjectManager.getLicensesPage().verifyMandatoryFieldsForAddOnModule();
			reportScreenshot(testSetup.driver);
			if(result==true) {
				reportPass("Verification of mandatory fields for Add-on Module License type", "The Part & Charge type fields are mandatory" , "The Part & Charge type fields are mandatory");
			}
			else {
				reportFail("Verification of mandatory fields for Add-on Module License type", "The Part & Charge type fields are mandatory" , "The Part & Charge type fields are not mandatory");
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}


	}
