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

public class VMM_3326_Terminating_licenses_is_removing_the_license_from_the_licenses_page_instead_of_changing_the_status_to_TERMINATED extends BaseTest {
		
	TestSetup testSetup;
    
	public VMM_3326_Terminating_licenses_is_removing_the_license_from_the_licenses_page_instead_of_changing_the_status_to_TERMINATED(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}
	
	@Then("I create License Type Sync to TM status as on {string}")
	public void i_create_license_type_sync_to_tm_status_as_on(String tcid) {
		try {
			test = logInfo.get().createNode("I create License Type Sync to TM status as on");
			test.assignCategory("Licenses");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicenseTypePage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicenseTypePage().LicenseTypecreate(testData);
			reportScreenshot(testSetup.driver);
			reportInfo("I created license type successfully");   
		
		} 
		catch (Exception e)
		{ 
			testStepHandle("FAIL", testSetup.driver, test, e); 
		}
		
	}
	@Then("I click on operations and navigate Tenants tab and I create a new Tenant {string}")
	public void i_click_on_operations_and_navigate_tenants_tab(String tcid) {
		try {
			test = logInfo.get().createNode("I click on operations to navigate Tenants tab and I create a new Tenant");
			
			testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
			testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();
			String tenantID=randomStringGenerator();
			 
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_3326_1");
			
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM_3326_1");
			 
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getTenantsPage().TenantCreate(testData);
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getTenantsPage().clickOnTenantsave();
			reportScreenshot(testSetup.driver);
			reportInfo("I created tenant successfully");
			    
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e); 
		}	
	}
	
	@Then("I click on new to create license {string}")
	public void i_click_on_new_to_create_license(String tcid) {
		try {
			test = logInfo.get().createNode("I click on new to create license");
		
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getHomePage().navigateToLicensesTab();
			testSetup.pageObjectManager.getLicensesPage().NewLicenseCreate(testData);
			reportScreenshot(testSetup.driver);
			
			testSetup.pageObjectManager.getLicensesPage().ClickLicensesSave();
			reportScreenshot(testSetup.driver);
			
			reportInfo("I created licenses successfully");  
		}  
		catch (Exception e)
		{ 
			testStepHandle("FAIL", testSetup.driver, test, e); 
		}
	}
	  
	@Then("I Publish the license {string}")
	public void i_publish_the_license(String tcid) { 
		try {
			test = logInfo.get().createNode("I Publish the license");
			
			
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().PublishLicenses(testData);
			reportScreenshot(testSetup.driver); 
		
			//testSetup.pageObjectManager.getLicensesPage().Filterlicenses(testData);
		    //testSetup.pageObjectManager.getLicensesPage().publishLicense();
		    
			reportInfo("I Published licenses successfully");     
		} 
		catch (Exception e) 
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	   
	}
	@Then("Terminate the license {string}")
	public void terminate_the_license_and_make_sure_that_the_license_status_in_lm_is_changed_from_published_to_terminated(String tcid) {
		try {
			test = logInfo.get().createNode("Terminate the license");
			
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().TerminateLicenses(testData);
			reportScreenshot(testSetup.driver); 
			testSetup.pageObjectManager.getLicensesPage().TerminateLicensesOKBtn(); 
			reportScreenshot(testSetup.driver);  
			//testSetup.pageObjectManager.getLicensesPage().verifyTerminate();
			reportInfo("I terminated licenses and status in LM is changed to PUBLISHED to TERMINATED successfully");    
		}
		catch (Exception e)
		{ 
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I make sure that the license status in LM is changed from PUBLISHED to TERMINATED {string}")
	public void i_make_sure_that_the_license_status_in_LM_is_changed_from_PUBLISHED_to_TERMINATED(String tcid) {
		try {
			test = logInfo.get().createNode("I make sure that the license status in LM is changed from PUBLISHED to TERMINATED");
			
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			String verify=testSetup.pageObjectManager.getLicensesPage().Verifyterminatelicenses(testData);
			reportScreenshot(testSetup.driver); 
			if(verify.equalsIgnoreCase("TERMINATED"))  
			{
				reportPass("Licenses Terminated", "TERMINATED", verify);
				reportInfo("I terminated licenses and status in LM is changed to PUBLISHED to TERMINATED successfully");
			}
			else {
				reportFail("Licenses Not Terminated", "TERMINATED", verify);
				reportInfo("I terminated licenses and status in LM is changed to PUBLISHED to TERMINATED Not successfully");
			}
			
		}
		catch (Exception e)
		{ 
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
		}
	} 
	   