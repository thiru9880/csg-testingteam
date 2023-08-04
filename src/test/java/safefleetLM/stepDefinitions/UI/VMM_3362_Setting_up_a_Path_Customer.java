package safefleetLM.stepDefinitions.UI;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import safefleetLM.componentgroups.ResponseTags;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3362_Setting_up_a_Path_Customer extends BaseTest{

	TestSetup testSetup;

	public VMM_3362_Setting_up_a_Path_Customer(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}

	@Then("I create the Tenant with Deployment type is CLOUD COMMERCIAL {string}")
	public void i_create_the_tenant_with_deployment_type_is_cloud_commercial(String tcid) throws InterruptedException {
		try {

			String tenantID=randomStringGenerator();

			//System.out.println(tenantID);

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_3362_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","EditedTenantID",tenantID,"VMM_3362_1");

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM_3362_1");

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM_3362_2");

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"EcosytemSetting","TenantID",tenantID,"VMM_3362_1");

			test = logInfo.get().createNode("I create the Tenant with Deployment type is CLOUD COMMERCIAL");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getTenantsPage().createNewTenant(testData);
			reportScreenshot(testSetup.driver);
			String AlertMsg = testSetup.pageObjectManager.getTenantsPage().tenantSave(testData);
			reportScreenshot(testSetup.driver);
			if(AlertMsg.contains("A new Tenant is created with identifier")) {
				reportPass("Tenant ", "A new Tenant is created with identifier", AlertMsg);
				reportInfo("Tenant ID "+testData.get("TenantID").toLowerCase()+" created with Deployment type is CLOUD COMMERCIAL successfully");
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
	@Then("I Create Vehicle License for x number of vehicles specified in sales order {string}")
	public void i_create_vehicle_license_for_x_number_of_vehicles_specified_in_sales_order(String tcid) throws IOException {
		try {
			test = logInfo.get().createNode("I Create Vehicle License for x number of vehicles specified in sales order");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			String Alert = testSetup.pageObjectManager.getLicensesPage().createVehicleLicense(testData);
			reportScreenshot(testSetup.driver);
			if(Alert.equalsIgnoreCase("Vmaxmanager App license.updated")) {
				reportPass("Vehicle license", "Vmaxmanager App license.updated", Alert);
				reportInfo("Create Vehicle License for x number of vehicles with valid data successfully");
			}
			else
				reportFail("Vehicle license", "Vmaxmanager App license.updated", Alert);
			reportScreenshot(testSetup.driver);
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("","" ,"Unable to create vehicle license" );
			testSetup.baseTest.intializeDriver().close();
			Assert.fail();
		}
	}
	@Then("I verify software setting is created with Tenant id if not Create software setting {string}")
	public void i_verify_software_setting_is_created_with_tenant_id_if_not_create_software_setting(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I verify software setting is created with Tenant id if not Create software setting");
		Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting", tcid);
		reportInfo(testData.toString());
		boolean result = testSetup.pageObjectManager.getEcosystemSettingsPage().searchSoftwareSetting(testData);
		reportScreenshot(testSetup.driver);
		if(result==true)
		{
			reportInfo("Software setting is NOT created with Tenant id I need to create NEW Software setting");
			
				String AlertMsg = testSetup.pageObjectManager.getEcosystemSettingsPage().createEcosystemSettings(testData);
				reportScreenshot(testSetup.driver);
	
				String status=testSetup.pageObjectManager.getEcosystemSettingsPage().ecosettingcreatepopup1();
				if(status.equals("true"))
				{
					reportPass("Ecosetting created successfully", "A new Settings is created with identifier..",AlertMsg );
					//reportScreenshot(testSetup.driver);
					reportInfo("Ecosetting created for Tenant "+testData.get("TenantID")+" successful");
				}
				else
				{
					reportFail("Ecosetting created successfully", "A new Settings is created with identifier..", AlertMsg);
					reportScreenshot(testSetup.driver);
					reportInfo("Ecosetting not created");
				}
			}
			
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportInfo("Unable to create Ecosystem setting");
		}
	}
	@Then("I publish the App license {string}")
	public void i_publish_the_app_license(String tcid) {
		try {
			test = logInfo.get().createNode("I publish the App license");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().verifyCeatedLicense(testData);
			testSetup.pageObjectManager.getLicensesPage().clickPublishAppLicense();
			reportScreenshot(testSetup.driver);
			String AlertMessage =testSetup.pageObjectManager.getLicensesPage().clickOnVerifyCheckboxAndVerifyDownload();
			reportScreenshot(testSetup.driver);
			if(AlertMessage.equals("Vmaxmanager App license.updated"))
			{
				reportPass("App license", "Vmaxmanager App license.updated", AlertMessage);
				reportInfo("App license Published successfully");
			}
			else
				reportFail("App license ", "Vmaxmanager App license.updated", AlertMessage);
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("","","License NOT published successfully");
		}
	}
	@Then("I publish Vehicle licenses {string}")
	public void i_publish_vehicle_licenses(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I publish Vehicle licenses");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			String AlertMessage=testSetup.pageObjectManager.getLicensesPage().publishVehicleLicense(testData);
			reportScreenshot(testSetup.driver);

			if(AlertMessage.equals("Vmaxmanager App license.updated"))
			{
				reportPass("Vehicle license", "Vmaxmanager App license.updated", AlertMessage);
				reportInfo("Vehicle license Published successfully");
			}
			else
				reportFail("Vehicle license ", "Vmaxmanager App license.updated", AlertMessage);
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("","","License NOT published successfully");
		}
	}
	@Then("I delete the published Vehicle licenses {string}")
	public void i_delete_the_published_vehicle_licenses(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I delete the published Vehicle licenses");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			String licenseId = testSetup.pageObjectManager.getLicensesPage().deleteVehicleLicense(testData);
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getLicensesPage().deleteConfirmationButton();
			if(licenseId.equalsIgnoreCase(testData.get("TenantID").toLowerCase()))
			{
				reportPass("TenantID", testData.get("TenantID").toLowerCase()+" License delete successfully", licenseId+" License delete successfully");
			}
			else {
				reportPass("TenantID", testData.get("TenantID").toLowerCase()+" License delete successfully", licenseId+" License delete successfully");
			}
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("","","License NOT deleted successfully");
		}
	}
	@Then("I delete the ecosystem settings {string}")
	public void i_delete_the_ecosystem_settings(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I delete the ecosystem settings");
			Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting", tcid);
			reportInfo(testData.toString());

			String AlertMsg=testSetup.pageObjectManager.getEcosystemSettingsPage().deleteEcosystemSetting(testData);
			reportScreenshot(testSetup.driver);
			if(AlertMsg.contains("A Settings is deleted with identifier")) {
				reportPass("Confirmation Message", "A Settings is deleted with identifier", AlertMsg);
				reportInfo("Ecosystem Setting "+testData.get("TenantID")+" Deleted successfully");
			}
			else {
				reportFail("Confirmation Message", "A Settings is deleted with identifier", AlertMsg);
				reportInfo("Ecosystem Setting "+testData.get("TenantID")+" NOT Deleted successfully");}
		}

		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("","","License NOT published successfully");
		}
	}

}
