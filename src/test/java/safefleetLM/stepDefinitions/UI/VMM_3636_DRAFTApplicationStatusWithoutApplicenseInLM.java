package safefleetLM.stepDefinitions.UI;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import safefleetLM.componentgroups.ResponseTags;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.GenerateBearerToken;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3636_DRAFTApplicationStatusWithoutApplicenseInLM extends BaseTest{
	
	private static final String String = null;
	TestSetup testSetup;
	
	Response response = null;
	public static String resString=null;
    public static RequestSpecification req = null;
	public static ResponseSpecification res = null;

	public VMM_3636_DRAFTApplicationStatusWithoutApplicenseInLM(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	
	
	@Then("I create new tenant for VVMM3636 with test data {string}")
	public void i_create_new_tenant_for_vvmm3636_with_test_data(String tcid) throws Exception {
		try {/*
			 String tenantID=randomStringGenerator();
				
			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM-3636_1");
			  
			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3636_1");
		        
		      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3636_2");
		      
		      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"EcosytemSetting","TenantID",tenantID,"VMM-3636_1");

		      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",tenantID,"VMM-3636_1");
*/
			test = logInfo.get().createNode("I create new tenant with test data");
			
			test.assignCategory("Integration with TM");
			
	       testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
	       
		    testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();
		    
		    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
		    
		    testSetup.pageObjectManager.getTenantsPage().createNewTenantLicense(testData);
		    
		    reportScreenshot(testSetup.driver);
		    
		    reportInfo("New tenant is created with test data");
		    
		    reportInfo("Test data "+testData);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  
		
	}

	@Then("I create DEVICE BW license for Nexus with test data {string}")
	public void i_create_device_bw_license_for_nexus_with_test_data(String tcid) throws Exception {
		try {
			testSetup.pageObjectManager. getHomePage().navigateToLicenseTab();
	        
			test = logInfo.get().createNode("I create APP license with test data ");
			
	    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
	    	
			testSetup.pageObjectManager.getLicensesPage().createNewLicense(testData);
			reportScreenshot(testSetup.driver);
			
			reportInfo("Created new license for the license types: types:DEVICE BW with test data ");	
		
			reportInfo("Test data "+testData);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  

		
	}
	
	@Then("I publish DEVICE BW license for Nexus with test data {string}")
	public void i_publish_device_bw_license_for_nexus_with_test_data(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I publish DEVICE BW license for Nexus in LM");
		      
	        testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
	      
			testSetup.pageObjectManager. getHomePage().navigateToLicensesTab();
			
	    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
	    	
			testSetup.pageObjectManager.getLicensesPage().publishOneLicense(testData);
			
			reportScreenshot(testSetup.driver);
			
			testSetup.pageObjectManager.getLicensesPage().clickPublishOK();
			
			reportInfo("published DEVICE BW license for Nexus ");
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  

	}

	
	@Then("I verify  application status as DRAFT in TM swagger with test data {string}")
	public void i_verify_application_status_as_draft_in_tm_swagger_with_test_data(String tcid) throws Exception {
		try {
			 test = logInfo.get().createNode("\"I verify  application status as DRAFT in TM swagger");
				
				Map<String, String> testData = ExcelFileReader.getDataInMap("GetTenant", tcid);
			
				String BearerToken = GenerateBearerToken.tenantManagerApi();				
				
				response = given().header("Authorization", BearerToken).baseUri(tenantManager_baseURI).and().when().get("/tenant/"+testData.get("TenantID")).then().extract().response();
				
				if (response!=null) {
					reportInfo("API triggered Successfully");
				}
				
				String resString = response.then().extract().asPrettyString();
				
				validateField("Staus Code ","200", String.valueOf(response.getStatusCode()));
						
				JsonPath js = new JsonPath(resString);
				
				reportPayload(response.getBody().asPrettyString());
				
				validateField("License Status", testData.get("Status"), js.getString(ResponseTags.GetTenantDetails_STATUS));
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  

	}

	@Then("I create DEVICE ICV license for Nexus with test data {string}")
	public void i_create_device_icv_license_for_nexus_with_test_data(String tcid) throws Exception {
		try {
			testSetup.pageObjectManager. getHomePage().navigateToLicenseTab();
	        
			test = logInfo.get().createNode("I create DEVICE ICV license for Nexus  ");
			
	    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
	    	
			testSetup.pageObjectManager.getLicensesPage().createNewLicense(testData);
			reportScreenshot(testSetup.driver);
			
			reportInfo("Created new license for the license types: types:DEVICE ICV with test data ");	
		
			reportInfo("Test data "+testData);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  

	}
	

	@Then("I publish DEVICE ICV license for Nexus with test data {string}")
	public void i_publish_device_icv_license_for_nexus_with_test_data(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I publish DEVICE ICV license for Nexus in LM");
		      
	        testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
	      
			testSetup.pageObjectManager. getHomePage().navigateToLicensesTab();
			
	    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
	    	
			testSetup.pageObjectManager.getLicensesPage().publishSecondLicense(testData);
			
			reportScreenshot(testSetup.driver);
			
			testSetup.pageObjectManager.getLicensesPage().clickPublishOK();
			
			reportInfo("published DEVICE ICV license for Nexus ");
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  

	}

	@Then("I delete the published Asset license {string}")
	public void i_delete_the_published_asset_license(String tcid) {
	  
		try {
			test = logInfo.get().createNode("I delete the published license");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			String licenseId = testSetup.pageObjectManager.getLicensesPage().deleteAssetLicense(testData);
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
