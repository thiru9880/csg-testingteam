package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3358_SettingUpCommanderCustomer extends BaseTest  {
	
	private static final String String = null;
	TestSetup testSetup;

	public VMM_3358_SettingUpCommanderCustomer(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	
	
	
	@Then("I create new tenant for VVMM3358 with test data {string}")
	public void i_create_new_tenant_for_vvmm3358_with_test_data(String tcid) throws Exception {
		try {
		      String tenantID=randomStringGenerator();
				
					  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM-3358_1");
					  
					  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3358_1");
				        
				      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3358_2");
				      
				      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"EcosytemSetting","TenantID",tenantID,"VMM-3358_1");

					test = logInfo.get().createNode("I create new tenant with test data");
					
					 test.assignCategory("Licenses");
					
			        testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
			        
				    testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();
				    
				    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
				    
				    testSetup.pageObjectManager.getTenantsPage().createNewTenantWithAdminMail(testData);
				    
				    reportScreenshot(testSetup.driver);
				    
				    reportInfo("New tenant is created with test data ");
				    
				    reportInfo("Test data "+testData);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  

	}

	@Then("I create APP license for SF Commander with test data {string}")
	public void i_create_app_license_for_des_sf_live_with_test_data(String tcid) throws Exception {
		try {
		    testSetup.pageObjectManager. getHomePage().navigateToLicenseTab();
	        
			test = logInfo.get().createNode("I create APP license for DES SF Live+ with test data");
			
	    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
	    	
			testSetup.pageObjectManager.getLicensesPage().addLicensesforBaseProduct(testData);
			reportScreenshot(testSetup.driver);
			
			reportInfo("Created new license for the license types: types:BASE_PRODUCT with test data ");	
		
			reportInfo("Test data "+testData);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  

	}

	@Then("I create Vehicle license for SF Commander with test data {string}")
	public void i_create_vehicle_license_for_des_sf_live_with_test_data(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I create Vehicle license for DES SF Live+ with test data");
			
	    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
	    	
			testSetup.pageObjectManager.getLicensesPage().createNewLicense(testData);
			reportScreenshot(testSetup.driver);
			
			reportInfo("Created new license for the license types: types:BASE_PRODUCT with test data ");	
		
			reportInfo("Test data "+testData);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  

	}

	@Then("I verify License tab with test data {string}")
	public void i_verify_license_tab_with_test_data(String tcid) throws Exception {
		try {
	        test = logInfo.get().createNode("I verify License tab with test data ");
			
	    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
	    	
			testSetup.pageObjectManager.getLicensesPage().verifyLicenseTab(testData);
			
			reportScreenshot(testSetup.driver);
			
			reportInfo("License Tab is showing up in Red because Licenses are currently in Draft");	
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  

	
	}

}
