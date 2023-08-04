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

public class VMM_3277_License_Type_Issues extends BaseTest {

	TestSetup testSetup;

	public VMM_3277_License_Type_Issues(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}

	@Then("I create new Tenant For Licenses {string}")
	public void i_create_new_tenant_for_licenses(String tcid) {
		try {
			String tenantID=randomStringGenerator();
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM3277_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM3277_1");
			test = logInfo.get().createNode("I create new Tenant For Licenses");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			reportInfo("I Create a Tenant With TestData");
			//testSetup.pageObjectManager.getTenantsPage().createNewTenant(testData);
      testSetup.pageObjectManager.getTenantsPage().createNewTenantSyncToTMOFF(testData);
			reportScreenshot(testSetup.driver);
			String AlertMsg = testSetup.pageObjectManager.getTenantsPage().tenantSave(testData);
			reportInfo("Tenant Created Successfully");
			reportScreenshot(testSetup.driver);
			if(AlertMsg.contains("A new Tenant is created with identifier")) {
				reportPass("Tenant ", "A new Tenant is created with identifier", AlertMsg);
				reportInfo("Tenant ID "+testData.get("TenantID").toLowerCase()+" created successfully");
			}
			else
				reportFail("Tenant ", "A new Tenant is Not created with identifier", AlertMsg);
		}

		catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I Verify that Data Amount field is not mandatory field create a new Licesnse with License Type {string}")
	public void i_Verify_that_Data_amount_field_is_not_mandatory_field_create_a_new_licesnse_with_license_type(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I Verify that Data Amount field is not mandatory field");
			test.assignCategory("License Types");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			reportInfo("I create a new Licesnse with Requires Data Status On License Type");
			testSetup.pageObjectManager.getLicensesPage().CreateLicense(testData);
			reportScreenshot(testSetup.driver);
			reportInfo("I Verify Without Entering Data Amount Field save button is Enable or not");
			boolean saveBtnEnabledSts = testSetup.pageObjectManager.getLicensesPage().VerifySaveBtnEnabled();
			if(saveBtnEnabledSts==true) {
				reportPass("I verify Save Button In Creating License", "Enabled","Enabled" );
				reportInfo("save button Enabled Without Entering Data Amout Value So Data Amount field is not mandatory");
			}
			else {
				reportFail("I verify Save Button In Creating License", "Not Enabled", "Not Enabled");
				reportInfo("save button Not Enabled so  Data Amount field is mandatory");
			}
			String LicenseAlertMsg = testSetup.pageObjectManager.getLicensesPage().LicenseSaveAndVerifyAlert();
			reportScreenshot(testSetup.driver);
			if(LicenseAlertMsg.contains("updated")) {
				reportPass("I verify License Is Created", LicenseAlertMsg, LicenseAlertMsg);
				reportInfo("License created successfully without dataAmount Field");
			}
			else {
				reportFail("I verify License Is Created ", "fail", "fail");
				reportInfo("License is Not created successfully without dataAmount Field");
			}

		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I Verify that Qty field is mandatory create a new Licesnse with License Type {string}")
	public void i_verify_that_qty_field_is_mandatory_create_a_new_licesnse_with_license_type(String tcid) {

		try {
			test = logInfo.get().createNode("I Verify that Qty field is mandatory field");
			reportInfo("I Verify QTY field is mandatory");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());

			reportInfo("I create a new Licesnse with Requires Qty Status On License Type");
			testSetup.pageObjectManager.getLicensesPage().createLicenseWithoutQtyField(testData);
			reportInfo("I Verify Without Entering Qty Field Value");
			reportScreenshot(testSetup.driver);
			String saveBtnDisabledSts = testSetup.pageObjectManager.getLicensesPage().VerifySaveBtnDisabled();
			if(saveBtnDisabledSts.contains("true")) {
				reportPass("I verify Save Button In Creating License", "Not Enabled","Not Enabled" );
				reportInfo("Save Button Is Not Enabled Without Enterning Qty Field Value");
			}
			else {
				reportFail("I verify Save Button In Creating License", "Enabled", "Enabled");
				reportInfo("Save Button Is Enabled Without Enterning Qty Field Value Also");
			}

			reportInfo("                         ");

			reportInfo("I Verify After Entering Qty filed value");
			testSetup.pageObjectManager.getLicensesPage().EnterQtyField(testData);
			reportScreenshot(testSetup.driver);
			boolean saveBtnEnabledSts = testSetup.pageObjectManager.getLicensesPage().VerifySaveBtnEnabled();
			if(saveBtnEnabledSts==true) {
				reportPass("I verify Save Button In Creating License", "Enabled", "Enabled");
				reportInfo("After Enterning Qty Field Value Only Save Button Is Enabled, So Qty Field is Mandatory");

			}
			else {
				reportFail("I verify Save Button In Creating License", "Not Enabled", "Not Enabled");
				reportInfo("After Enterning Qty Field Value Save Button Is Not Enabled");

			}
			testSetup.pageObjectManager.getLicensesPage().CancelAfterSettingPage();

		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I delete the License {string}")
	public void i_delete_the_licenses(String tcid) {

		try {
			test = logInfo.get().createNode("I delete the License ");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().searchTenant(testData);
			testSetup.pageObjectManager.getLicensesPage().deleteCreatedLicense();
			reportInfo("I Delete the License");
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getLicensesPage().deleteConformationLicense();
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I delete the Created Tenant {string}")
	public void i_delete_the_created_tenant(String tcid) {
		try {
			test = logInfo.get().createNode("I delete the Tenant");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().searchTenant(testData);
			reportInfo("I Delete the Tenant");
			testSetup.pageObjectManager.getTenantsPage().deleteTheTenant(testData);
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getTenantsPage().deleteTenantConformation(testData);
			reportScreenshot(testSetup.driver);

		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);


		}



	}
	}


