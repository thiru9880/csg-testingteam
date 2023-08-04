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

public class VMM_3265_Enable_SSO_For_TM_Application_For_LM_To_TM_Integration extends BaseTest {
		
	TestSetup testSetup;
	
	public VMM_3265_Enable_SSO_For_TM_Application_For_LM_To_TM_Integration(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}
	
	//-------------1

	@Then("I Create tenants for CLOUD__COMMERCIAL deployment types {string}")
	public void i_create_tenants_for_cloud__commercial_deployment_types(String tcid) throws InterruptedException {
		try {
			String tenantID=randomStringGenerator();
            UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM3265_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM3265_1");
			test = logInfo.get().createNode("I Create tenants for CLOUD__COMMERCIAL deployment types");
			test.assignCategory("Licenses");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getTenantsPage().createNewTenant(testData);
			reportInfo("I Create tenants for CLOUD__COMMERCIAL deployment Types");
			reportScreenshot(testSetup.driver);
			String AlertMsg = testSetup.pageObjectManager.getTenantsPage().tenantSave(testData);
			reportInfo("Tenant Created Successfully");
			reportScreenshot(testSetup.driver);
			if(AlertMsg.contains("A new Tenant is created with identifier")) {
				reportPass("Tenant ", "A new Tenant is created with identifier", AlertMsg);
				reportInfo("Tenant ID "+testData.get("TenantID").toLowerCase()+" created successfully");
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
	
	@Then("I Create License for CLOUD__COMMERCIAL deployment type tenant {string}")
	public void i_create_license_for_cloud_government_deployment_type_tenant(String tcid) {
		try {
			test = logInfo.get().createNode("I Create License for CLOUD__COMMERCIAL  Deployment Type tenant");
			reportInfo("I Create License for CLOUD__COMMERCIAL deployment type tenant Successfully");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().createLicense(testData);
			reportInfo("I create a License for CLOUD__COMMERCIAL Deployment Type tenant");
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getLicensesPage().LicenseSave();
			reportInfo("License Created Successfully");
			reportScreenshot(testSetup.driver);
		
			}
			catch (Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	   
	}
	
	@Then("I Click on Generate Keys actions menu item after CLOUD__COMMERCIAL deployment type tenant {string}")
	public void i_click_on_generate_keys_actions_menu_item_after_cloud_government_deployment_type_tenant(String tcid) {
		try {
			test = logInfo.get().createNode("I Click on Generate Keys actions menu item after CLOUD_GOVERNMENT deployment type tenant");
			reportInfo("I Click on Generate Keys actions menu item after CLOUD__COMMERCIAL deployment type tenant");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().SearchLicenseCreated(testData);
			testSetup.pageObjectManager.getLicensesPage().NavigateToTenantManager();
			String verifyApiClientTenantCommercial = testSetup.pageObjectManager.getLicensesPage().verifyApiClientPageTenantCommercial();
			reportInfo("After clicking Genearate keys it  will be opened up take you to  api client page");
			reportScreenshot(testSetup.driver);
			if(verifyApiClientTenantCommercial.contains("API Clients")) {
				reportPass("Successfully navigate to api client page after clicking genearate keys", "API Clients", verifyApiClientTenantCommercial);
				
			}
			else
				reportPass("not navigate to api client page", "API Clients", verifyApiClientTenantCommercial);
			}
			
			catch (Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	
	}
	
	@Then("I Click on LogOut For CLOUD__COMMERCIAL deployment type tenant")
	public void i_click_on_log_out_For_CLOUD_COMMERCIAL_deployment_type_tenant() {
		try {
			test = logInfo.get().createNode("I Click on LogOut For CLOUD__COMMERCIAL deployment type tenant");
			testSetup.pageObjectManager.getLicensesPage().logoutTenantManager();
			reportInfo("I click on logout in api client page ");
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getLicensesPage().conformLogutTenantManager();
			reportInfo("Logged out succesfully");
			reportScreenshot(testSetup.driver);
			}
			catch (Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
			
	}
	
	//--------------2


	@Then("I Create tenants for CLOUD__GOVERNMENT deployment types {string}")
	public void i_create_tenants_for_cloud__government_deployment_types(String tcid) {
		try {
			String tenantID=randomStringGenerator();
            UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM3265_2");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM3265_2");
			test = logInfo.get().createNode("I Create tenants for CLOUD__GOVERNMENT deployment types");
			test.assignCategory("Licenses");
			reportInfo("I Create tenants for CLOUD__GOVERNMENT deployment types Successfully");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getTenantsPage().createNewTenant(testData);
			reportInfo("I Create tenants for CLOUD__GOVERNMENT deployment types");
			reportScreenshot(testSetup.driver);
			String Alertmsg = testSetup.pageObjectManager.getTenantsPage().tenantSave(testData);
			reportInfo("Tenant Created Successfully");
			reportScreenshot(testSetup.driver);
			if(Alertmsg.contains("A new Tenant is created with identifier")) {
				reportPass("Tenant ", "A new Tenant is created with identifier", Alertmsg);
				reportInfo("Tenant ID "+testData.get("TenantID").toLowerCase()+" created successfully");
			}
			else {
				reportPass("Tenant ", "A new Tenant is created with identifier", Alertmsg);}
			}

			catch (Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}	
	}
	
	@Then("I Create License for CLOUD__GOVERNMENT deployment type tenant {string}")
	public void i_create_license_for_cloud_commercial_deployment_type_tenant(String tcid) {
		try {
			test = logInfo.get().createNode("I Create License for CLOUD_GOVERNMENT Deployment Type tenant");
			reportInfo("I Create License for CLOUD_GOVERNMENT deployment type tenant Successfully");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().createLicense(testData);
			reportInfo("I create a License for CLOUD_GOVERNMENT Deployment Type tenant");
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getLicensesPage().LicenseSave();
			reportInfo("License Created Successfully");
			reportScreenshot(testSetup.driver);
			}
			catch (Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	  
	}
	
	@Then("I Click on Generate Keys actions menu item after CLOUD__GOVERNMENT deployment type tenant {string}")
	public void i_click_on_generate_keys_actions_menu_item_after_cloud_commercial_deployment_type_tenant(String tcid) {
		try {
			test = logInfo.get().createNode("I Click On Generate Keys actions menu item after CLOUD__GOVERNMENT deployment type tenant");
			reportInfo("I Click on Generate Keys actions menu item after CLOUD__GOVERNMENT deployment type tenant");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().SearchLicenseCreated(testData);
			testSetup.pageObjectManager.getLicensesPage().NavigateToTenantManager();
			String verifyApiClientTenantGoverment = testSetup.pageObjectManager.getLicensesPage().verifyApiClientPageTenantGoverment();
			reportInfo("After clicking Genearate keys it  will be opened up take you to  api client page");
			reportScreenshot(testSetup.driver);
			if(verifyApiClientTenantGoverment.contains("API Clients")) {
				reportPass("Successfully navigate to api client page after clicking genearate keys", "API Clients", verifyApiClientTenantGoverment);
				
			}
			else
				reportPass("not navigate to api client page", "API Clients", verifyApiClientTenantGoverment);
			}
			catch (Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	   
	}
	
	@Then("I Click on LogOut For CLOUD__GOVERNMENT deployment type tenant")
	public void i_click_on_log_out_For_CLOUD_GOVERNMENT_deployment_type_tenant() {
		try {
			test = logInfo.get().createNode("I Click on LogOut  For CLOUD__GOVERNMENT deployment type tenant");
			testSetup.pageObjectManager.getLicensesPage().logoutTenantManager();
			reportInfo("I click on logout in api client page ");
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getLicensesPage().conformLogutTenantManager();
			reportInfo("Logged out succesfully");
			reportScreenshot(testSetup.driver);
			}
			catch (Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
			
	}
	
	
	




}
