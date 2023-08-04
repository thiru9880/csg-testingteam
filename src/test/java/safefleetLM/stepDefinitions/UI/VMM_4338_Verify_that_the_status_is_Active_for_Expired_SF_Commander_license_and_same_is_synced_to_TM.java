package safefleetLM.stepDefinitions.UI;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
import safefleetLM.testcomponents.DBConnection;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.GenerateBearerToken;
import safefleetLM.testcomponents.TestSetup;

public class VMM_4338_Verify_that_the_status_is_Active_for_Expired_SF_Commander_license_and_same_is_synced_to_TM extends BaseTest {

	private static final String String = null;
	TestSetup testSetup;

	Response response = null;
	public static String resString=null;
	public static RequestSpecification req = null;
	public static ResponseSpecification res = null;

	String LicenseId;

	public VMM_4338_Verify_that_the_status_is_Active_for_Expired_SF_Commander_license_and_same_is_synced_to_TM(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}


	@Then("I create a SF commander license with crossed expiration date {string}")
	public void i_create_a_SF_commander_license_with_crossed_expiration_date(String tcid) throws IOException {
		try {
			test = logInfo.get().createNode("I create a SF commander license with crossed expiration date");
			test.assignCategory("Integration with TM");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().createExpiredSFCommanderLicense(testData);
			reportScreenshot(testSetup.driver);
			String Alert = testSetup.pageObjectManager.getLicensesPage().clickOnSave();
			reportScreenshot(testSetup.driver);
			if(Alert.equalsIgnoreCase("Vmaxmanager App license.updated")) {
				reportPass("license", "Vmaxmanager App license.updated", Alert);
				reportInfo("create a SF commander license with crossed expiration date successfully");
			}
			else {
				reportFail("license", "Vmaxmanager App license.updated", Alert);
				reportScreenshot(testSetup.driver);
			}
		}
		catch (Exception e) 
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			reportFail("","" ,"Unable to create license" );
			testSetup.baseTest.intializeDriver().quit();
			Assert.fail();
		}
	}


	@Then("I search for SF commander license which has crossed the expiration date {string}")
	public void i_search_for_sf_commander_license_which_has_crossed_the_expiration_date(String tcid) {
		try {
			test = logInfo.get().createNode("I search for SF commander license which has crossed the expiration date");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			String Result = testSetup.pageObjectManager.getLicensesPage().searchExpiredSFCommanderLicense(testData);
			reportScreenshot(testSetup.driver);
		}
		catch (Exception e) 
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	@Then("I verify that the license status is Active {string}")
	public void i_verify_that_the_license_status_is(String tcid) {
		try {
			test = logInfo.get().createNode("I verify that the license status is Active");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			reportScreenshot(testSetup.driver);
			String[] Result = testSetup.pageObjectManager.getLicensesPage().verifyLicenseStatus(testData);
			LicenseId=Result[1];
			if(Result[0].equalsIgnoreCase("ACTIVE") || Result[0].equalsIgnoreCase("PUBLISHED"))
			{
				reportPass("License Status", "PUBLISHED", Result[0]);
				reportInfo("I verified that expired SF commander license status is "+Result[0]+" it confirm that the license is ACTIVE");
			}
			else {
				reportFail("License Status", "PUBLISHED", Result[0]);
				reportInfo("I verified that expired SF commander license status is "+Result+" ");
			}

		}
		catch (Exception e) 
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	@Then("I verify in swagger that the above expired license has status as Active in TM {string}")
	public void i_verify_in_swagger_that_the_above_expired_license_has_status_as_in_tm(String tcid) {
		try {
			test = logInfo.get().createNode("I verify in swagger that the above expired license has status as Active in TM");

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

			validateField("Description", testData.get("Status"), js.getString(ResponseTags.GetTenantDetails_STATUS));

			if(js.getString(ResponseTags.GetTenantDetails_STATUS).equalsIgnoreCase("ACTIVE")) {
				reportPass("License Status", "ACTIVE",  js.getString(ResponseTags.GetTenantDetails_STATUS));
				reportInfo("I verified in swagger that expired SF commander license status is "+js.getString(ResponseTags.GetTenantDetails_STATUS)+" in TM");
			}
			else
				reportFail("License Status", "ACTIVE", js.getString(ResponseTags.GetTenantDetails_STATUS));
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  

	}
	@Then("I verify in DB under license table that license status should be ACTIVE {string}")
	public void i_verify_in_db_under_license_table_that_license_status_should_be_active(String tcid) throws SQLException {
		try {

			test = logInfo.get().createNode("I verify in DB under license table that license status should be ACTIVE");
			System.out.println(LicenseId);
			List<Map<String, ?>> res = DBConnection.getData("SELECT * FROM test_license_manager.license where id='"+LicenseId+"';");
			System.out.println(res);
			System.out.println(res.get(0).get("LICENSE_STATUS"));

			System.out.println(res.get(0).get("ID"));
			String LicenseStatus = res.get(0).get("LICENSE_STATUS").toString();
			if(LicenseStatus.equalsIgnoreCase("PUBLISHED")) {
				reportPass("License status", "PUBLISHED", LicenseStatus);
				reportInfo("verified in Data Base under license table that expired SF commander license status is "+LicenseStatus+" it confirm that licese is ACTIVE");

			}
			else {
				reportFail("License status", "PUBLISHED", LicenseStatus);

			}
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}  
	}
	@Then("I verify in DB that No renewal status available for license even if it is expired {string}")
	public void i_verify_in_db_that_no_renewal_status_available_for_license_even_if_it_is_expired(String tcid) throws SQLException {
		try {
			test = logInfo.get().createNode("I verify in DB that No renewal status available for license even if it is expired");
			List<Map<String, ?>> res = DBConnection.getData("SELECT * FROM test_license_manager.license where id='"+LicenseId+"';");
			System.out.println(res.get(0).get("RENEWAL_STATUS"));
			
			//String RenewalStatus = res.get(0).get("RENEWAL_STATUS").toString();
			//System.out.println(" Status : "+RenewalStatus);
			if(res.get(0).get("RENEWAL_STATUS")==null) {
				reportPass("Renewal status", "null", "null");
				reportInfo("verify in DB successfully that No renewal status available for license even if it is expired and it returns "+res.get(0).get("RENEWAL_STATUS"));
			}
			else
				reportFail("Renewal status", "null", res.get(0).get("RENEWAL_STATUS").toString());
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		} 
	}
}
