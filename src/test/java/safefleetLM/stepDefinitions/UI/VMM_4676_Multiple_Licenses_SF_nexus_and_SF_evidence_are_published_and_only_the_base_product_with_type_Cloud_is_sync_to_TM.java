package safefleetLM.stepDefinitions.UI;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.And;
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

public class VMM_4676_Multiple_Licenses_SF_nexus_and_SF_evidence_are_published_and_only_the_base_product_with_type_Cloud_is_sync_to_TM extends BaseTest{

	TestSetup testSetup;
	
	Response response = null;
	public static String resString=null;
    public static RequestSpecification req = null;
	public static ResponseSpecification res = null;
	
	public VMM_4676_Multiple_Licenses_SF_nexus_and_SF_evidence_are_published_and_only_the_base_product_with_type_Cloud_is_sync_to_TM(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}
	
	@Then("I create a cloud commercial Tenant {string}")
    public void i_create_a_cloud_commercial_tenant_something(String tcid) throws Throwable
	{
		try
		{
			String tenantID=randomStringGenerator();
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM4676_1");
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM4676_1");
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",tenantID,"VMM4676_1");
			test = logInfo.get().createNode("I create a cloud commercial Tenant");
			test.assignCategory("Integration with TM");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
			testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();
			testSetup.pageObjectManager.getTenantsPage().createANewTenant(testData);
			testSetup.pageObjectManager.getTenantsPage().clickOnSaveButtonn();
			reportInfo("I create a cloud commercial Tenant successfully");
			reportScreenshot(testSetup.driver);
		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
    }

    @Then("I create SF evidence manager License for the Tenant created {string}")
    public void i_create_sf_evidence_manager_license_for_the_tenant_created_something(String tcid) throws Throwable 
    {
    	try
		{
			test = logInfo.get().createNode("I create SF evidence manager License for the Tenant created");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			Map<String, String> testData2 = ExcelFileReader.getDataInMap("TenantPage", tcid);
			testSetup.pageObjectManager.getHomePage().navigateToLicenseTab();
			String marketSegment = testSetup.pageObjectManager.getLicensesPage().createLicensesforDesktop(testData);
			if(marketSegment.equalsIgnoreCase(testData2.get("TenantType"))) {
				reportInfo("I create SF evidence manager License with Identity Provider and Market Segment values, for the Tenant created successfully");
				reportInfo("Identity Provider = osp and Market Segment = "+marketSegment);
			}
			reportScreenshot(testSetup.driver);
		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
    }

    @Then("I create SF nexus License for the Tenant created {string}")
    public void i_create_sf_nexus_license_for_the_tenant_created_something(String tcid) throws Throwable
    {
    	try
		{
			test = logInfo.get().createNode("I create SF nexus License for the Tenant created");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			testSetup.pageObjectManager.getLicensesPage().createLicensesSFNexus(testData);
			reportInfo("I create SF nexus License for the Tenant created successfully");
			reportScreenshot(testSetup.driver);
		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
    }
    
    @Then("I publish and download the License {string}")
    public void i_publish_and_download_the_license(String tcid) throws Throwable 
    {
    	try
		{
			test = logInfo.get().createNode("I publish and download the License");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			testSetup.pageObjectManager.getLicensesPage().verifyFilterLicense(testData);
			testSetup.pageObjectManager.getLicensesPage().goToLicensePublishAfterFilter();
			reportInfo("I publish and download the License successfully");
			reportScreenshot(testSetup.driver);
		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
    }
    
    @Then("I publish and download the License again")
    public void i_publish_and_download_the_license_again() throws Throwable 
    {       
    	try
		{
    		test = logInfo.get().createNode("I publish and download the License again");
    		testSetup.pageObjectManager.getLicensesPage().goToLicensePublishAfterFilterAgain();
			reportInfo("I publish and download the License again successfully");
			reportScreenshot(testSetup.driver);
		}
    	catch(Exception e)
    	{
    		testStepHandle("FAIL", testSetup.driver, test, e);
    	}
    }

    @And("I verify in TM swagger, that the SF nexus published License is synced to TM, where as SF evidence manager will not be synced to TM {string}")
    public void i_verify_in_tm_swagger_that_the_sf_nexus_published_license_is_synced_to_tm_where_as_sf_evidence_manager_will_not_be_synced_to_tm(String tcid) throws Throwable 
    {
    	try {
    			test = logInfo.get().createNode("I verfiy the response for GetTenant API");
    			
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
    			
    			validateField("TenantID", testData.get("TenantID"), js.getString(ResponseTags.GetTenantDetails_TENANTID));
    			
    			validateField("TenantName", testData.get("TenantName"), js.getString(ResponseTags.GetTenantDetails_TENANTNAME));

    			validateField("TenantType", testData.get("TenantType"), js.getString(ResponseTags.GetTenantDetails_TENANTTYPE));

    			validateField("ApplicationID", testData.get("ApplicationID"), js.getString(ResponseTags.GetTenantDetails_APPLICATIONID));

    			validateField("Description", testData.get("Description"), js.getString(ResponseTags.GetTenantDetails_DESCRIPTION));
    			
    		}
    		catch(Exception e) {
    			testStepHandle("FAIL", testSetup.driver, test, e);
    		}  
    }
	
}
