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

public class VMM_3275_Call_the_appropriate_API_for_government_cloud_creation extends BaseTest {

	TestSetup testSetup;

	public VMM_3275_Call_the_appropriate_API_for_government_cloud_creation(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}

	String LicenseDetails;

	@Then("I create the Tenant with Deployment type is CLOUD GOVERNMENT {string}")
	public void i_create_the_tenant_with_deployment_type_is_cloud_government(String tcid) throws InterruptedException {
		try {

String tenantID=randomStringGenerator();

			System.out.println(tenantID);

			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_3275_1");
			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","EditedTenantID",tenantID,"VMM_3275_1");

			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM_3275_1");

			//  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM_3275_1");

			test = logInfo.get().createNode("I create the Tenant with Deployment type is CLOUD GOVERNMENT");
			test.assignCategory("Integration with TM");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getTenantsPage().createNewTenant(testData);
			reportScreenshot(testSetup.driver);
			String AlertMsg = testSetup.pageObjectManager.getTenantsPage().tenantSave(testData);
			reportScreenshot(testSetup.driver);
			if(AlertMsg.contains("A new Tenant is created with identifier")) {
				reportPass("Tenant ", "A new Tenant is created with identifier", AlertMsg);
				reportInfo("Tenant ID '"+testData.get("TenantID").toLowerCase()+"' created with Deployment type is CLOUD GOVERNMENT successfully");
			}
			else
				reportPass("Tenant ", "A new Tenant is created with identifier", AlertMsg);}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			testSetup.pageObjectManager.getTenantsPage().continueExecution();
			reportFail("","Tenant id is exist," ,"Tenant id must be unique" );
		}
	}
	@Then("I create license for the above created tenant {string}")
	public void i_create_license_for_the_above_created_tenant(String tcid) throws IOException {
		try {
			test = logInfo.get().createNode("I create license for the above created tenant");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			String Alert = testSetup.pageObjectManager.getLicensesPage().createLiceseWithQty(testData);
			//reportScreenshot(testSetup.driver);
			if(Alert.equalsIgnoreCase("Vmaxmanager App license.updated")) {
				reportPass("license", "Vmaxmanager App license.updated", Alert);
				reportInfo("Create license with valid data successfully");
			}
			else
				reportFail("license", "Vmaxmanager App license.updated", Alert);
			reportScreenshot(testSetup.driver);
			}
			catch (Exception e)
			{
				testStepHandle("FAIL", testSetup.driver, test, e);
				reportFail("","" ,"Unable to create license" );
				testSetup.baseTest.intializeDriver().quit();
				Assert.fail();

			}
	}
	@Then("I publish the license {string}")
	public void i_publish_the_license(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I publish the license");
		Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
		reportInfo(testData.toString());
		String AlertMsg = testSetup.pageObjectManager.getLicensesPage().publishLicense(testData);
		reportScreenshot(testSetup.driver);
    testSetup.pageObjectManager.getLicensesPage().waitForAngularRequestsToFinish();
		if(AlertMsg.equals("Vmaxmanager App license.updated"))
		{
			reportPass("license", "Vmaxmanager App license.updated", AlertMsg);
			reportInfo("License published successfully");
		}
		else
			reportFail("App license ", "Vmaxmanager App license.updated", AlertMsg);
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("","" ,"Unable to create license" );
		}

	}

	@Then("I click on Generate Keys and make sure that it navigates to TM government site {string}")
	public void i_click_on_generate_keys_and_make_sure_that_it_navigates_to_tm_government_site(String tcid) throws Exception {

		try {
		test = logInfo.get().createNode("I click on Generate Keys and make sure that it navigates to TM government site");
		Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
		reportInfo(testData.toString());
		//testSetup.pageObjectManager.getLicensesPage().verifyCeatedLicense(testData);
		//reportScreenshot(testSetup.driver);
		String env = getProperty("Environment");
		String title = testSetup.pageObjectManager.getLicensesPage().clickOnGenerateKeysToTMGsite(env, testData);
		reportScreenshot(testSetup.driver);
		if(title.equalsIgnoreCase("Tenant Manager")) {
			reportPass("Webpage", "Tenant Manager", title);
			reportInfo("Navigate to TM government site successfully");
		}
		else {
			reportFail("Webpage", "Tenant Manager", title);
			reportInfo("Navigate to TM government site NOT successful");
		}
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("","" ,"Unable to navigate to TM government site" );
		}
	}
	@Then("I verify creates an api client with the name scheme {string}")
	public void i_verify_creates_an_api_client_with_the_name_scheme(String tcid) throws Exception {
	 try {
		test = logInfo.get().createNode("I verify creates an api client with the name scheme");
		Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
		reportInfo(testData.toString());

		LicenseDetails = testSetup.pageObjectManager.getLicensesPage().verifyApiClientNameScheme(testData);
		reportScreenshot(testSetup.driver);
		if(LicenseDetails.equalsIgnoreCase("Tenant id : "+testData.get("TenantID")+" AND API CLIENT ID : "+testData.get("TenantID")+"-DES-Cloud-Sharing-apiClient")) {
			reportPass("Client with Name scheme", "Tenant id : "+testData.get("TenantID")+" AND API CLIENT ID : "+testData.get("TenantID")+"-DES-Cloud-Sharing-apiClient", LicenseDetails);
			reportInfo("I verified that creates an api client with the name scheme successfully");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","LMdetails",LicenseDetails,"VMM_3275_1");
		}
		else {
			reportFail("Client with Name scheme", "Tenant id : "+testData.get("TenantID")+" AND API CLIENT ID : "+testData.get("TenantID")+"-DES-Cloud-Sharing-apiClient", LicenseDetails);
			reportFail("","" ,"Verify creates an api client with the name scheme Failed!!" );
		}
	 }
	 catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("","" ,"Unable get the Details" );
		}

	}


	@When("I quite the browser")
	public void i_quite_the_browser_() throws IOException, InterruptedException {
		try {
		test = logInfo.get().createNode("I close the browser");
		Thread.sleep(3000);
		reportInfo("Browser closed successfully");
		testSetup.baseTest.intializeDriver().quit();
		}
		 catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}


	@When("I check the license type configuration for that license and see that resources are assigned {string}")
	public void i_check_the_license_type_configuration_for_that_license_and_see_that_resources_are_assigned(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I check the license type configuration for that license and see that resources are assigned");
			test.assignCategory("Integration with TM");
			Map<String, String> testData = ExcelFileReader.getDataInMap("BaseProductPage", tcid);
			reportInfo(testData.toString());
			Map<String, String> testData1 = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData1.toString());
			testSetup.pageObjectManager.getBaseProductPage().clickViewToVerifyBaseProduct(testData);
			String[] ApplicationIds = testSetup.pageObjectManager.getBaseProductPage().verifyBaseProductResources(testData,testData1);
			reportScreenshot(testSetup.driver);
			if(ApplicationIds[0].equalsIgnoreCase(ApplicationIds[1]))
			{
				reportPass("Application Id ", ApplicationIds[0] , ApplicationIds[1]);
				reportInfo("I checked that license type configuration for that license successfully");
				reportInfo("Resources are assigned for "+testData.get("Name")+" successfully");
			}
			else
			{
				reportFail("Application Id ", ApplicationIds[0] , ApplicationIds[1]);

				reportInfo("Resources are NOT assigned for "+testData.get("Name")+" successfully");
			}
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("","" ,"Unable get the Details" );
		}
	}

	@Then("I delete the published license {string}")
	public void i_delete_the_published_license(String tcid) {

		try {
			test = logInfo.get().createNode("I delete the published license");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			String licenseId = testSetup.pageObjectManager.getLicensesPage().deleteFeatureAppLicense(testData);
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getLicensesPage().deleteConfirmation();
			if(licenseId.equalsIgnoreCase(testData.get("TenantID").toLowerCase()))
			{
				reportPass("LicenseID", testData.get("TenantID").toLowerCase()+" license should delete successfully", licenseId+" license deleted successfully");
				reportInfo("License deleted for Tenant Id '"+testData.get("TenantID").toLowerCase()+"' successfully");
			}
			else
				reportFail("LicenseID", testData.get("TenantID").toLowerCase()+" license should delete successfully", licenseId+" license NOT deleted successfully");
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("","Unable to delete or","License NOT Found");
			//Assert.fail();
		}
	}
}
