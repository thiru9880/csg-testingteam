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

public class VMM_3621_Send_tenant_admin_email_to_tenant_manager extends BaseTest {

	private static final String String = null;
	TestSetup testSetup;

	Response response = null;
	public static String resString=null;
	public static RequestSpecification req = null;
	public static ResponseSpecification res = null;

	public VMM_3621_Send_tenant_admin_email_to_tenant_manager(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}


	@Then("I create a tenant with admin email {string}")
	public void i_create_a_tenant_with_admin_email(String tcid) throws InterruptedException {
		try {
			String tenantID=randomStringGenerator();
			System.out.println(tenantID);
        //3621
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_3621_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","EditedTenantID",tenantID,"VMM_3621_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM_3621_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",tenantID,"VMM_3621_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TanantAlias",tenantID,"VMM_3621_1");

		//4501
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_4501_1");
      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","EditedTenantID",tenantID,"VMM_4501_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM_4501_1");
      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM_4501_2");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",tenantID,"VMM_4501_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TanantAlias",tenantID,"VMM_4501_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"EcosytemSetting","TenantID",tenantID,"VMM_4501_1");

		//4338
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_4338_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM_4338_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",tenantID,"VMM_4338_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TanantAlias",tenantID,"VMM_4338_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"EcosytemSetting","TenantID",tenantID,"VMM_4338_1");


		//3699
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_3699_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM_3699_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",tenantID,"VMM_3699_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TanantAlias",tenantID,"VMM_3699_1");


			test = logInfo.get().createNode("I create a tenant with admin email");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getTenantsPage().createNewTenant(testData);
			testSetup.pageObjectManager.getTenantsPage().tenantWithAdminEmail(testData);
			reportScreenshot(testSetup.driver);
			String AlertMsg = testSetup.pageObjectManager.getTenantsPage().tenantSave(testData);
			reportScreenshot(testSetup.driver);
			if(AlertMsg.contains("A new Tenant is created with identifier")) {
				reportPass("Tenant ", "A new Tenant is created with identifier", AlertMsg);
				reportInfo("Tenant ID "+testData.get("TenantID").toLowerCase()+" is created with admin Email successfully");
			}
			else
				reportFail("Tenant ", "A new Tenant is created with identifier", AlertMsg);}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
			testSetup.pageObjectManager.getTenantsPage().continueExecution();
			reportFail("","Tenant id is exist," ,"Tenant id must be unique" );
		}
	}
	@Then("I verify in Tenant Manager via Swagger UI to make sure tenant Admin Email make it to TM {string}")
	public void i_verify_the_tenant_in_tenant_manager_via_swagger_ui(String tcid) {
		try {
			test = logInfo.get().createNode("I verify in Tenant Manager via Swagger UI to make sure tenant Admin Email make it to TM");

			test.assignCategory("Integration with TM");

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

			validateField("TenantAdminEmail", testData.get("TenantAdminEmail"), js.getString(ResponseTags.GetTenantDetails_TENANTADMINEMAIL));

		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

}
