package safefleetLM.stepDefinitions.UI;

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

import static io.restassured.RestAssured.given;

public class VMM_3870_offer_SFCognition extends BaseTest {
	
	private static final String String = null;
	TestSetup testSetup;
	
	Response response = null;
	public static String resString=null;
    public static RequestSpecification req = null;
	public static ResponseSpecification res = null;

	public VMM_3870_offer_SFCognition(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	
	@Then("I verify SF Cognition details in Base Product Tab with expected test data {string}")
	public void i_verify_sf_cognition_details_in_base_product_tab_with_expected_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I verify SF Cognition details in Base Product Tab with expected test data");
			
			test.assignCategory("Licenses");
			
			Map<String, String> testData = ExcelFileReader.getDataInMap("BaseProductPage", tcid);
			
            String text=testSetup.pageObjectManager.getBaseProductPage().verifyBaseProductName3870(testData);
            
			reportPass("Base Product Text", testData.get("Name"),text );
			
			String eco=testSetup.pageObjectManager.getBaseProductPage().verifyBaseProductEcosystem3870(testData);
			
			reportPass("Base Product Ecosystem", testData.get("Ecosystem"),eco);
				
		    String cloud=testSetup.pageObjectManager.getBaseProductPage().verifyBaseProductCloud3870(testData);
		    
			reportPass("Base Product Cloud", testData.get("Cloud"),cloud );
			
			String local=testSetup.pageObjectManager.getBaseProductPage().verifyBaseProductLocal3870(testData);
			
			reportPass("Base Product Local", testData.get("Local"),local );
			
			reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}
	}

	@Then("I verify Application ID in TM Swagger with expected test data {string}")
	public void i_verify_application_id_in_tm_swagger_with_expected_test_data(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I verfiy the response for getApplicationID API");
			
			Map<String, String> testData = ExcelFileReader.getDataInMap("GetApplication", tcid);
		
			String BearerToken = GenerateBearerToken.tenantManagerApi();				
			
			response = given().header("Authorization", BearerToken).baseUri(tenantManager_baseURI).and().when().get("/application/"+testData.get("Description")).then().extract().response();
			
			if (response!=null)
			 {
				reportInfo("API triggered Successfully");
			}
			
			String resString = response.then().extract().asPrettyString();
			
			validateField("Staus Code ","200", String.valueOf(response.getStatusCode()));
					
			JsonPath js = new JsonPath(resString);
			
			reportPayload(response.getBody().asPrettyString());
			
			validateField("ApplicationID", testData.get("ApplicationID"), js.getString(ResponseTags.GetApplicationIDDetails_APPLICATIONID));
			
			validateField("Description", testData.get("Description"), js.getString(ResponseTags.GetApplicationIDDetails_DESCRIPTION));
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  

	}

	@Then("I verify license types: BASE_PRODUCT details for SF Congnition with expected test data {string}")
	public void i_verify_license_types_base_product_details_for_sf_congnition_with_expected_test_data(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I verify license types: BASE_PRODUCT details for SF Congnition with expected test data");
			
	    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicenseTypePage", tcid);
	    	
			testSetup.pageObjectManager.getLicenseTypePage().verifyLicenceTypeBASE_PRODUCTforSFCognition(testData);
			
			reportInfo("verified license types: BASE_PRODUCT details for SF Congnition");
			
			reportScreenshot(testSetup.driver);	
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  

	}

	@Then("I verify license types: DEVICE details for SF Congnition with expected test data {string}")
	public void i_verify_license_types_device_details_for_sf_congnition_with_expected_test_data(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I verify license types: DEVICE details for SF Congnition with expected test data");
			
	    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicenseTypePage", tcid);
	    	
			testSetup.pageObjectManager.getLicenseTypePage().verifyLicenceTypeDEVICEforSFCognition(testData);
			
			reportInfo("verified license types: DEVICE details for SF Congnition");
			
			reportScreenshot(testSetup.driver);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  

	}
	
	
	@Then("I create new tenant for VMM3870 with test data {string}")
	public void i_create_new_tenant_for_vmm3870_with_test_data(String tcid) throws Exception {
		try {
			String tenantID=randomStringGenerator();
			
			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM-3870");
			  
			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3870");
		        
		      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3870_2");
		      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3870_3");
		      
		      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"EcosytemSetting","TenantID",tenantID,"VMM-3870");

		      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetApplication","TenantID",tenantID,"VMM-3870");
		      
	          UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",tenantID,"VMM-3870");
		      
		      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TanantAlias",tenantID,"VMM-3870");

		      
		        		
			test = logInfo.get().createNode("I create new tenant with test data");
			
		        testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
		        
			    testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();
			    
			    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			    
			    testSetup.pageObjectManager.getTenantsPage().createNewTenantLicense(testData);;
			    
			    reportInfo("New tenant is created with test data ");
			    
			    reportInfo("Test data "+testData);
			    
			    reportScreenshot(testSetup.driver);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  

	}
	
   
    @Then("I create license for BASE_PRODUCT License Type with test data {string}")
    public void i_create_license_for_base_product_license_type_with_test_data(String tcid) throws Exception {
    	try {
    		test = logInfo.get().createNode("I create new license for the license types: BASE_PRODUCT with test data");
    		
        	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
        	
    		testSetup.pageObjectManager.getLicensesPage().addLicensesforBaseProduct(testData);
    		
    		reportInfo("Created new license for the license types: BASE_PRODUCT with test data");
    		
    		reportInfo("Test data "+testData);
    		reportScreenshot(testSetup.driver);
    	}
    	catch(Exception e) {
    		testStepHandle("FAIL", testSetup.driver, test, e);
    	}  

    }

	@Then("I create new license for SFCognition with test data {string}")
	public void i_create_new_license_for_sf_cognition_with_test_data(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I create new license for SFCognition with test data");
			
	    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
	    	
			testSetup.pageObjectManager.getLicensesPage().createNewLicense(testData);
			
			reportInfo("Created new license with test data "+testData);
			
			reportScreenshot(testSetup.driver);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  

	}

	@Then("I create new license for Genetec Integration Add-on Module with test data {string}")
	public void i_create_new_license_for_genetec_integration_add_on_module_with_test_data(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I create new license, Genetec Integration Add-on Module with test data");
			
	    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
	    	
			testSetup.pageObjectManager.getLicensesPage().createNewLicenseWithoutOTY(testData);
			
			reportInfo("Created new license with test data "+testData);
			
			reportScreenshot(testSetup.driver);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  

	}
	
	@Then("I create unique ecosystem setting with test data {string}")
	public void i_create_unique_ecosystem_setting_with_test_data(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I create unique ecosystem setting with test data");
			
	    	Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting", tcid);
	    	
			testSetup.pageObjectManager.getEcosystemSettingsPage().createEcosystemSettings(testData);
			
			reportInfo("Created unique ecosystem setting with test data "+testData);
			
			reportScreenshot(testSetup.driver);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  

	}

	@Then("I publish SF Cognition license in LM with test data {string}")
	public void i_publish_sf_cognition_license_in_lm_with_test_data(String tcid) throws Exception {
		try {
			test = logInfo.get().createNode("I publish SF Cognition license in LM");
		      
	        testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
	      
			testSetup.pageObjectManager. getHomePage().navigateToLicensesTab();
			
	    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
	    	
			testSetup.pageObjectManager.getLicensesPage().publishTwoLicense(testData);
			
			reportScreenshot(testSetup.driver);
			
			testSetup.pageObjectManager.getLicensesPage().clickPublishOK();
			
			reportInfo("published SF Cognition license "+testData);
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  

				
	}


	
	@Then("I verify published license details for SF Cognition in TM via swagger with expected test data {string}")
	public void i_verify_published_license_details_for_sf_cognition_in_tm_via_swagger_with_expected_test_data(String tcid) throws Exception {
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
			
			validateField("TenantID", testData.get("TenantID"), js.getString(ResponseTags.GetTenantDetails_TENANTID));
			
			validateField("TenantName", testData.get("TenantName"), js.getString(ResponseTags.GetTenantDetails_TENANTNAME));
		    
	        validateField("TenantType", testData.get("TenantType"), js.getString(ResponseTags.GetTenantDetails_TENANTTYPE));

	        validateField("TanantAlias", testData.get("TanantAlias"), js.getString(ResponseTags.GetTenantDetails_TENANTALIAS));

	        validateField("ApplicationID", testData.get("ApplicationID"), js.getString(ResponseTags.GetTenantDetails_APPLICATIONID));
	        
	        validateField("Description", testData.get("Description"), js.getString(ResponseTags.GetTenantDetails_DESCRIPTION));
			
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  

	}

}
