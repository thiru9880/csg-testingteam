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

public class VMM_3584_DES_BaseProduct extends BaseTest
{
	
	private static final String String = null;
	TestSetup testSetup;
	
	Response response = null;
	public static String resString=null;
    public static RequestSpecification req = null;
	public static ResponseSpecification res = null;
	
	public VMM_3584_DES_BaseProduct(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}

	
	@Then("I verify SF Cloud Courier For DES base product exists under Name column with test data {string}")
	public void i_verify_sf_cloud_courier_for_des_base_product_exists_under_name_column_with_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I verify SF Cloud Courier For DES base product exists under Name column with test data");
			
			 test.assignCategory("Integration with TM");
			
			Map<String, String> testData = ExcelFileReader.getDataInMap("BaseProductPage", tcid);
			
            String text=testSetup.pageObjectManager.getBaseProductPage().verifyBaseProductName3584(testData);
            
			reportPass("Base Product Text", testData.get("Name"),text );
			
			reportScreenshot(testSetup.driver);
			
		}
		catch(AssertionError | Exception e) {
			
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}
	}


	@Then("I create new tenant with test data {string}")
	public void i_create_new_tenant_with_test_data(String tcid) throws Exception {
		try {
			String tenantID=randomStringGenerator();

			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM-3584_1");
			  
			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3584_1");
		        
		      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3584_2");
		      
		      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"EcosytemSetting","TenantID",tenantID,"VMM-3584_1");
		      
		      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",tenantID,"VMM-3584_1");

		        		
			test = logInfo.get().createNode("I create new tenant with test data");
			
		        testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
		        
			    testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();
			    
			    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			    
			    testSetup.pageObjectManager.getTenantsPage().createNewTenantLicense(testData);
			    
			    reportInfo("New tenant is created with test data ");
			    
			    reportInfo("Test data "+testData);
			    
			    reportScreenshot(testSetup.driver);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  
	}
	
	@Then("I create licenses for {string} base product for the license types: BASE_PRODUCT with test data {string}")
	public void i_create_licenses_for_base_product_for_the_license_types_base_product_with_test_data(String string, String tcid) throws Exception {
		try {
			 testSetup.pageObjectManager. getHomePage().navigateToOperationsTab();
				
				testSetup.pageObjectManager. getHomePage().navigateToLicenseTab();
		        
				test = logInfo.get().createNode("I create new license for the license types: BASE_PRODUCT with test data ");
				
		    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
		    	
				testSetup.pageObjectManager.getLicensesPage().addLicensesforBaseProduct(testData);
				
				reportInfo("Created new license for the license types: BASE_PRODUCT with test data ");
				
				reportInfo("Test data "+testData);
				
				reportScreenshot(testSetup.driver);

		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  
	}

	@Then("I create licenses for {string} base product for the license types: ADD_ON_PRODUCT with test data {string}")
	public void i_create_licenses_for_base_product_for_the_license_types_add_on_product_with_test_data(String string, String tcid) throws Exception {
		try {
			 testSetup.pageObjectManager. getHomePage().navigateToOperationsTab();
				
				testSetup.pageObjectManager. getHomePage().navigateToLicenseTab();
		        
				test = logInfo.get().createNode("I create new license for the license types: ADD_ON_PRODUCT with test data");
				
		    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
		    	
				testSetup.pageObjectManager.getLicensesPage().createNewLicense(testData);
				
				reportInfo("Created new license for the license types: ADD_ON_PRODUCT with test data ");	
			
				reportInfo("Test data "+testData);
				
				reportScreenshot(testSetup.driver);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  
	}


	@Then("I publish both licenses created above with test data {string}")
	public void i_publish_both_licenses_created_above_with_test_data(String tcid) throws Exception 
	{
		try {
			  test = logInfo.get().createNode("I publish both licenses created above in LM");
		      
		        testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
		      
				testSetup.pageObjectManager. getHomePage().navigateToLicensesTab();
				
		    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
		    	
				testSetup.pageObjectManager.getLicensesPage().publishTwoLicense(testData);
				
				reportScreenshot(testSetup.driver);
				
				testSetup.pageObjectManager.getLicensesPage().clickPublishOK();
				
				reportInfo("published license for BASE_PRODUCT");
				
				reportInfo("published license for Cloud Couier");
				
				reportInfo("Test data "+testData);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}     
	}

	@Then("I verify the application ID in TM Swagger UI with test data {string}")
	public void i_verify_the_application_id_in_tm_swagger_ui_with_test_data(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I verfiy the response for getTenant API");
			
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
			
			
	        validateField("ApplicationID", testData.get("ApplicationID"), js.getString(ResponseTags.GetTenantDetails_APPLICATIONID));
	        
	        validateField("Description", testData.get("Description"), js.getString(ResponseTags.GetTenantDetails_DESCRIPTION));
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  

        }


}
