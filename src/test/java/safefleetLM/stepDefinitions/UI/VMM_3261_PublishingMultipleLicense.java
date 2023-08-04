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

public class VMM_3261_PublishingMultipleLicense extends BaseTest{

	private static final String String = null;
	TestSetup testSetup;
	
	Response response = null;
	public static String resString=null;
    public static RequestSpecification req = null;
	public static ResponseSpecification res = null;
	
	public VMM_3261_PublishingMultipleLicense(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}

@Then("I create new tenant for VMM3261 with test data {string}")
public void i_create_new_tenant_for_vmm3261_with_test_data(String tcid) throws Exception {
try {
	  String tenantID=randomStringGenerator();
		 
	  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM-3261_2");
	  
	  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3261_1");
    
    UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3261_2");
    
    UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"EcosytemSetting","TenantID",tenantID,"VMM-3261_1");
    
    UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",tenantID,"VMM-3261_1");
    
    UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TanantAlias",tenantID,"VMM-3261_1");
	  
	   test = logInfo.get().createNode("I create new tenant with test data");
	   
	   test.assignCategory("Licenses");
	    
	    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
	    
	    //String env = testSetup.prop.getEnvName();
	    //testSetup.pageObjectManager.getTenantsPage().createNewTenantLicense(env,testData);
	    testSetup.pageObjectManager.getTenantsPage().createNewTenantLicense(testData);
	    
	    reportInfo("New tenant is created with test data ");
	    
	    reportInfo("Test data "+testData);
	    
	    reportScreenshot(testSetup.driver);
	}
	catch(Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}  
}


@Then("I create new license for license types: BASE_PRODUCT with test data {string}")
public void i_create_new_license_for_license_types_base_product_with_test_data(String tcid) throws Exception {
try {
	testSetup.pageObjectManager. getHomePage().navigateToLicensesTab();
	
	test = logInfo.get().createNode("I create new license for license types: BASE_PRODUCT with test data");
	
	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
	
	testSetup.pageObjectManager.getLicensesPage().addLicensesforBaseProduct(testData);
	
	reportInfo("Created new license with test data "+testData);
	
	reportScreenshot(testSetup.driver);
	}
	catch(Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}  	
}

@Then("I create new license for license types: DEVICE  with test data {string}")
public void i_create_new_license_for_license_types_device_with_test_data(String tcid) throws Exception {
try {
test = logInfo.get().createNode("I create new license for license types: DEVICE with test data");
	
	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
	
	testSetup.pageObjectManager.getLicensesPage().createNewLicense(testData);
	
	reportInfo("Created new license with test data "+testData);
	
	reportScreenshot(testSetup.driver);
	}
	catch(Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}  
}

@Then("I publish all license in LM with test data {string}")
public void i_publish_all_license_in_lm_with_test_data(String tcid) throws Exception {
try {
	 test = logInfo.get().createNode("I publish all license in LM");

	testSetup.pageObjectManager. getHomePage().navigateToLicensesTab();
	
    Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

	testSetup.pageObjectManager.getLicensesPage().publishTwoLicense(testData);
	
	reportScreenshot(testSetup.driver);
	
	testSetup.pageObjectManager.getLicensesPage().clickOK();
	
	reportInfo("published license for BASE_PRODUCT");
	
	reportInfo("published license for DEVICE");
	}
	catch(Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}  
}

@Then("I verify published license details in TM via swagger with expected test data {string}")
public void i_verify_published_license_details_in_tm_via_swagger_with_expected_test_data(String tcid) throws Exception {
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
		
		validateField("Licenses", testData.get("Licenses"), js.getString(ResponseTags.GetTenantDetails_LICENSES));
	}
	catch(Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}  
	
}

}
