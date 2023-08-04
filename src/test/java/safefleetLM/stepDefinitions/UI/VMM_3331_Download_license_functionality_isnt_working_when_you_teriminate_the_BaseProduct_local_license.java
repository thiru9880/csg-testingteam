package safefleetLM.stepDefinitions.UI;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
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

public class VMM_3331_Download_license_functionality_isnt_working_when_you_teriminate_the_BaseProduct_local_license extends BaseTest {

	TestSetup testSetup;

	public VMM_3331_Download_license_functionality_isnt_working_when_you_teriminate_the_BaseProduct_local_license(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}


	@Then("I create new Tenant with Onsite Type {string}")
	public void i_create_new_tenant_with_onsite_type(String tcid) {

		try {
			String tenantID=randomStringGenerator();
            UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM3331_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM3331_1");
			test = logInfo.get().createNode("I create new Tenant with Onsite Type");
			test.assignCategory("Licenses");
			reportInfo("I create new Tenant with Onsite Type");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			reportInfo("I Create a Tenant With Onsite Type");
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
				reportPass("Tenant ", "A new Tenant is created with identifier", AlertMsg);
			}


			catch (Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}

	}
	@Then("I Create a BaseProduct Onsite License {string}")
	public void i_create_a_base_product_onsite_license(String tcid) {

		try {
			test = logInfo.get().createNode("I Create a BaseProduct Onsite License");
			reportInfo("I Create a BaseProduct Onsite License");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getHomePage().navigateToLicensesTab();
			testSetup.pageObjectManager.getLicensesPage().CreateLicenseBaseProduct(testData);
			reportInfo("I Create a BaseProduct Onsite License");
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getLicensesPage().LicenseSave();
			reportInfo("License Created Successfully");
			reportScreenshot(testSetup.driver);

			}
			catch (Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}

	}
	@Then("I Publish The License {string}")
	public void i_publish_the_license(String tcid) {
		try {
			test = logInfo.get().createNode("I Publish The License");
			reportInfo("I Create a BaseProduct Onsite License");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().SearchPublishLicense(testData);
			testSetup.pageObjectManager.getLicensesPage().publishLicenseBaseProduct();
			reportInfo("I Publish The License");
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getLicensesPage().conformPublish();
			reportInfo("License published Successfully");
			reportScreenshot(testSetup.driver);
			}
			catch (Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}

	}
	@Then("I Teriminate The License and Select Download License CheckBox")
	public void i_teriminate_the_license_and_select_download_license_check_box() {

		try {
			test = logInfo.get().createNode("I Teriminate The License and Select Download License CheckBox");
			reportInfo("I Create a BaseProduct Onsite License");

			testSetup.pageObjectManager.getLicensesPage().TeriminateLicenseBaseProduct();
			reportInfo("I Teriminate The License with Download License CheckBox On");
			reportScreenshot(testSetup.driver);

			FileUtils.deleteDirectory(new File(System.getProperty("user.dir") + File.separator + "Downloads"));
			Thread.sleep(1000);

			testSetup.pageObjectManager.getLicensesPage().confromTeriminate();

			reportInfo("License Teriminate Successfully");
			reportScreenshot(testSetup.driver);

			}
			catch (Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}

	}
	@Then("I Verify if The License File Is Downloaded {string}")
	public void i_verify_if_the_license_file_is_downloaded(String tcid) {

		try {
			test = logInfo.get().createNode("I Verify if The License File Is Downloaded");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			String expFileName = "license-"+testData.get("TenantID").toLowerCase()+".vmax";
			File file = new File(System.getProperty("user.dir") + File.separator + "Downloads");
			String[] DownloadFile = file.list();
			String actualFile = DownloadFile[0];
			System.out.println("expected "+expFileName);

			if(expFileName.equals(actualFile)) {
				reportPass("License File", expFileName, actualFile);
				reportInfo("License File Downloaded Successfuly");
			}
			else {
				reportFail("License File Is Not Downloaded Successfully","" ,"" );
			}


			}
			catch (Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}


	}


}
