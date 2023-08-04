package safefleetLM.stepDefinitions.UI;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

public class VMM_4423_Publish_APP_and_H2_Device_Licenses_for_SF_Cognition_base_product_with_multiple_devices_assigned_via_tenant_page extends BaseTest {

	private static final String String = null;
	TestSetup testSetup;

	Response response = null;
	public static String resString=null;
    public static RequestSpecification req = null;
	public static ResponseSpecification res = null;

	public VMM_4423_Publish_APP_and_H2_Device_Licenses_for_SF_Cognition_base_product_with_multiple_devices_assigned_via_tenant_page(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}


@Then("I create new Tenant for VMM4423 with test data {string}")
public void i_create_new_tenant_for_vmm4423_with_test_data(String tcid) {
	try {

		String tenantID=randomStringGenerator();

		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_4423_1");
		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"EcosytemSetting","TenantID",tenantID,"VMM_4423_1");
		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM_4423_1");
		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM_4423_2");
		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM_4423_3");
		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",tenantID,"VMM_4423_1");
		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TanantAlias",tenantID,"VMM_4423_1");

		test = logInfo.get().createNode("I create new Tenant for VMM4423 with test data");

		testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();

		testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();

		Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);

		testSetup.pageObjectManager.getTenantsPage().createNewTenant(testData);
		testSetup.pageObjectManager.getTenantsPage().tenantSave();

		reportInfo("New tenant is created with test data ");

		reportInfo("Test data "+testData);

		reportScreenshot(testSetup.driver);
	}
	catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}

}


@Then("I Create APP and H2 Device Licenses for SF Cognition base product with I Created Tenant with testdata {string}")
public void i_create_app_and_h2_device_licenses_for_sf_cognition_base_product_with_i_created_tenant_with_testdata(String tcid) {
	try {
		test = logInfo.get().createNode("I Create APP and H2 Device Licenses for SF Cognition base product with I Created Tenant with testdata");
		test.assignCategory("Tenants");
		testSetup.pageObjectManager.getHomePage().navigateToLicensesTab();
		Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
		testSetup.pageObjectManager.getLicensesPage().CreateAPPandH2DeviceLicenses(testData);
		reportScreenshot(testSetup.driver);



		reportInfo("I Create APP and H2 Device Licenses for SF Cognition base product with valid data successfully");



	}
	catch (Exception e)
	{
		testStepHandle("FAIL", testSetup.driver, test, e);
	}



}
@Then("I Create first device with device type and test data {string}")
public void i_create_first_device_with_device_type_and_test_data(String tcid) {
	try {
		String deviceID=randomStringGenerator();
		 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",deviceID,"VMM_4423_1");
		 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",deviceID,"VMM_4423_1");
		 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","partNo",deviceID,"VMM_4423_1");
		 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","IMEINo",deviceID,"VMM_4423_1");
		 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","Device ID",deviceID,"VMM_4423_1");

		test = logInfo.get().createNode("I Create first device with device type and  test data");

		Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
		reportInfo(testData.toString());
		testSetup.pageObjectManager.getDevicePage().Devicecreate(testData);
		//reportScreenshot(testSetup.driver);
		 reportInfo("Create first device with device type is successful");


	}
	catch (Exception e)
	{
		testStepHandle("FAIL", testSetup.driver, test, e);
	}


}
@Then("I Create second device with device type and test data {string}")
public void i_create_second_device_with_device_type_and_test_data(String tcid) {
	try {
		String deviceID=randomStringGenerator();
		 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",deviceID,"VMM_4423_2");
		 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",deviceID,"VMM_4423_2");
		 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","partNo",deviceID,"VMM_4423_2");
		 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","IMEINo",deviceID,"VMM_4423_2");
		 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","Device ID2",deviceID,"VMM_4423_1");

		test = logInfo.get().createNode("I Create second device with device type and  test data");

		Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
		reportInfo(testData.toString());
		testSetup.pageObjectManager.getDevicePage().Devicecreate(testData);
		 reportInfo("Create second device with device type is successful");

	}
	catch (Exception e)
	{
		testStepHandle("FAIL", testSetup.driver, test, e);
	}

}


@Then("I search tenant I created and assign multiple devices with testdata {string}")
public void i_search_tenant_i_created_and_assign_multiple_devices_with_testdata(String tcid) {
	try {
		test = logInfo.get().createNode("I search tenant I created and assign multiple devices with testdata");
	    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
		 testSetup.pageObjectManager.getTenantsPage().searchTenants(testData);
		 testSetup.pageObjectManager.getTenantsPage().clickTenantEditBtn();
		 testSetup.pageObjectManager.getTenantsPage().clickdeviceType(testData);
		 testSetup.pageObjectManager.getTenantsPage().assignMultipledevice(testData);
		 reportScreenshot(testSetup.driver);
		 reportInfo("Navigate to Tenant page, search tenant I created and assign multiple devices with testdata successfully");

	}
	catch (Exception e)
	{
		testStepHandle("FAIL", testSetup.driver, test, e);
	}


}
@Then("I Navigate back to Licenses page and I will publish the licenses I created with testdata {string}")
public void i_navigate_back_to_licenses_page_and_i_will_publish_the_licenses_i_created_with_testdata(String tcid) {
	try {
		test = logInfo.get().createNode("I Navigate back to Licenses page and I will publish the licenses I created with testdata");
		 Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
		testSetup.pageObjectManager.getHomePage().navigateToLicensesTab();
		testSetup.pageObjectManager.getLicensesPage().SearchPublishLicense(testData);
		testSetup.pageObjectManager.getLicensesPage().PublishMultipleLicenses();
		 reportInfo("Publish the licenses Successfully ");






	}
	catch (Exception e)
	{
		testStepHandle("FAIL", testSetup.driver, test, e);
	}


}


@Then("I Verify in Swagger that the published licenses are in sync with TM and shows up correctly in TM swagger {string}")
public void i_verify_in_swagger_that_the_published_licenses_are_in_sync_with_tm_and_shows_up_correctly_in_tm_swagger(String tcid) {
	try {

		test = logInfo.get().createNode("I Verify in Swagger that the published licenses are in sync with TM and shows up correctly in TM swagger");

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



		validateField("TenantID", testData.get("TenantID").toLowerCase(), js.getString(ResponseTags.GetTenantDetails_TENANTID));

		validateField("TenantName", testData.get("TenantName"), js.getString(ResponseTags.GetTenantDetails_TENANTNAME));

		validateField("TenantType", testData.get("TenantType"), js.getString(ResponseTags.GetTenantDetails_TENANTTYPE));



		validateField("ApplicationID", testData.get("ApplicationID"), js.getString(ResponseTags.GetTenantDetails_APPLICATIONID));

		validateField("Description", testData.get("Description"), js.getString(ResponseTags.GetTenantDetails_DESCRIPTION));

		validateField("Description", testData.get("Status"), js.getString(ResponseTags.GetTenantDetails_STATUS));

	}
	catch (Exception e)
	{
		testStepHandle("FAIL", testSetup.driver, test, e);
	}


}
@Then("I Unassign the device {string}")
public void i_unassign_the_device(String tcid) throws Exception {
	try {
	test = logInfo.get().createNode("I Unassign the device with testdata");
	Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
	testSetup.pageObjectManager.getDevicePage().searchDevice(testData);

	testSetup.pageObjectManager.getDevicePage().clickdeviceEditBtn();
	testSetup.pageObjectManager.getDevicePage().clickUnassignBtn();
	testSetup.pageObjectManager.getDevicePage().clickUnassigndevicetxtfield(testData);
	testSetup.pageObjectManager.getDevicePage().saveDevice();
	reportScreenshot(testSetup.driver);
	 reportInfo("Unassign the device Successfully");
}
	catch (Exception e) {
		testStepHandle("FAIL", testSetup.driver, test, e);
	}
}

@Then("I search the licenses I created with testdata {string}")
public void i_search_the_licenses_i_created_with_testdata(String tcid) {
    try {
        test = logInfo.get().createNode("I search the licenses I created with testdata");
         Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
        testSetup.pageObjectManager.getLicensesPage().SearchPublishLicense(testData);
         reportInfo("License created is searched Successfully");

    }
    catch (Exception e)
    {
        testStepHandle("FAIL", testSetup.driver, test, e);
    }
}



}
