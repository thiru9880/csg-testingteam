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

public class VMM_3953_LaneEnforcement extends BaseTest
{
	private static final String String = null;
	TestSetup testSetup;

	Response response = null;
	public static String resString=null;
    public static RequestSpecification req = null;
	public static ResponseSpecification res = null;

    public VMM_3953_LaneEnforcement(TestSetup testSetup) throws IOException {
	this.testSetup=testSetup;
}

    @Then("I verfy Base Product details for the {string} in test data {string}")
    public void i_verfy_base_product_details_for_the_in_test_data(String baseProduct, String tcid)
    {
	try {
			test = logInfo.get().createNode("I verify Base Product details in test data");
			test.assignCategory("Integration with TM");
			Map<String, String> testData = ExcelFileReader.getDataInMap("BaseProductPage", tcid);
            String text=testSetup.pageObjectManager.getBaseProductPage().verifyBaseProductName(testData, baseProduct);
			reportPass("Base Product Text", testData.get("Name"),text );
			reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
    	}


    @Then("I verify license types: BASE_PRODUCT details for SF ClearLane with expected test data {string}")
    public void i_verify_license_types_base_product_details_for_sf_clear_lane_with_expected_test_data(String tcid) throws Exception {
    	try {
    		test = logInfo.get().createNode("I verify license types: BASE_PRODUCT details for SF ClearLane with expected test data");
    		Map<String, String> testData = ExcelFileReader.getDataInMap("LicenseTypePage", tcid);
    		testSetup.pageObjectManager.getLicenseTypePage().verifyLicenceTypeBASE_PRODUCTforSFClearLane(testData, tcid);
    		reportInfo("verified license types: BASE_PRODUCT details for SF Clearlane");
    		reportScreenshot(testSetup.driver);
    	}
    	catch(Exception e) {
    		testStepHandle("FAIL", testSetup.driver, test, e);
    	}

    }

    @Then("I verify license types: DEVICE details for SF ClearLane with expected test data {string}")
    public void i_verify_license_types_device_details_for_sf_clear_lane_with_expected_test_data(String tcid) throws Exception {
    	try {
        	test = logInfo.get().createNode("I verify license types: DEVICE details for SF ClearLane with expected test data");
    		Map<String, String> testData = ExcelFileReader.getDataInMap("LicenseTypePage", tcid);
    		testSetup.pageObjectManager.getLicenseTypePage().verifyLicenceTypeDEVICEforSFClearLane(testData, tcid);
    		reportInfo("verified license types: DEVICE details for SF Clearlane");
    		reportScreenshot(testSetup.driver);
    	}
    	catch(Exception e) {
    		testStepHandle("FAIL", testSetup.driver, test, e);
    	}

    }



    @Then("I verify details for ISAM3 device type with expected test data {string}")
    public void i_verify_details_for_isam3_device_type_with_expected_test_data(String tcid) {
    	try {
			test = logInfo.get().createNode("I verify details for ISAM3 device type with expected test data");
			Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceType", tcid);
			String text=testSetup.pageObjectManager.getDeviceTypesPage().ValidateDeviceTypeName(testData);
			validateField("Device Type Text", testData.get("Name"),text);
			String setting=testSetup.pageObjectManager.getDeviceTypesPage().ValidateDeviceTypeSetting(testData);
			validateField("Device Type setting", testData.get("RequiresDeviceSetting"),setting);
			String ID=testSetup.pageObjectManager.getDeviceTypesPage().ValidateDeviceID(testData);
			validateField("DeviceID", testData.get("RequiresDeviceSetting"),ID);
			reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
    }

    @Then("I create new tenant for VMM3953 with test data {string}")
    public void i_create_new_tenant_for_vmm3953_with_test_data(String tcid) throws Exception {
    	try {
    		String tenantID=randomStringGenerator();

    		  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM-3953");

    		  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3953");

    	      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM-3953_2");

    	      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"EcosytemSetting","TenantID",tenantID,"VMM-3953");

    	      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",tenantID,"VMM-3953");

    	      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TanantAlias",tenantID,"VMM-3953");



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

    @Then("I create new license for BASE_PRODUCT License Type with test data {string}")
    public void i_create_new_license_for_base_product_license_type_with_test_data(String tcid) throws Exception {
    	try {
        	test = logInfo.get().createNode("I create new license for the license types: BASE_PRODUCT with test data");

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

    @Then("I create new license for SFClearLane with test data {string}")
    public void i_create_new_license_for_sf_clear_lane_with_test_data(String tcid) throws Exception {
    	try {
			test = logInfo.get().createNode("I create new license for for SFClearLane with test data ");
	    	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			testSetup.pageObjectManager.getLicensesPage().createNewLicense(testData);
			reportInfo("Created new license with test data "+testData);
			reportScreenshot(testSetup.driver);
    	}
    	catch(Exception e) {
    		testStepHandle("FAIL", testSetup.driver, test, e);
    	}

    }


    @Then("I publish SF ClearLane licenses in LM with test data {string}")
    public void i_publish_sf_clear_lane_licenses_in_lm_with_test_data(String tcid) throws Exception {
    	try {
        	test = logInfo.get().createNode("I publish SF ClearLane license in LM");

            testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();

    		testSetup.pageObjectManager. getHomePage().navigateToLicensesTab();

        	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);

    		testSetup.pageObjectManager.getLicensesPage().publishTwoLicense(testData);

    		reportScreenshot(testSetup.driver);

    		testSetup.pageObjectManager.getLicensesPage().clickPublishOK();

    		reportInfo("published SF CLearLane license "+testData);

//    		reportScreenshot(testSetup.driver);
    	}
    	catch(Exception e) {
    		testStepHandle("FAIL", testSetup.driver, test, e);
    	}

    }

    @Then("I verify the published licenses details for SF ClearLane in TM via swagger with expected test data {string}")
    public void i_verify_the_published_licenses_details_for_sf_clear_lane_in_tm_via_swagger_with_expected_test_data(String tcid) throws Exception {
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
