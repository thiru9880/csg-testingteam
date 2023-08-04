package safefleetLM.stepDefinitions.UI;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.FileUtils;
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
import java.time.LocalDate;

public class VMM_4677_Multiple_Licenses_SF_nexus_and_DVR_firmware_are_published_and_only_the_base_product_with_type_Cloud_is_sync_to_TM extends BaseTest {

	TestSetup testSetup;
	Response response = null;
	public static String resString=null;
    public static RequestSpecification req = null;
	public static ResponseSpecification res = null;

	public VMM_4677_Multiple_Licenses_SF_nexus_and_DVR_firmware_are_published_and_only_the_base_product_with_type_Cloud_is_sync_to_TM(TestSetup testSetup) throws IOException {
		this.testSetup = testSetup;
	}

	@Then("I create an cloud-Government tenant {string}")
	public void i_create_an_cloud_government_tenant(String tcid) {
		try {
			String tenantID=randomStringGenerator();
            UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM4677_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM4677_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM4677_2");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",tenantID,"VMM4677_1");
			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TanantAlias",tenantID,"VMM4677_1");
			test = logInfo.get().createNode("I create an cloud-Government tenant");
			test.assignCategory("Integration with TM");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getTenantsPage().createNewTenant(testData);
			reportInfo("I create an cloud-Government tenant");
			reportScreenshot(testSetup.driver);
			String Alertmsg = testSetup.pageObjectManager.getTenantsPage().tenantSave(testData);
			reportInfo("Tenant Created Successfully");
			reportScreenshot(testSetup.driver);
			if(Alertmsg.contains("A new Tenant is created with identifier")) {
				reportPass("Tenant ", Alertmsg, Alertmsg);
				reportInfo("Tenant created successfully");
			}
			else {
				reportFail("Tenant ", "Not Created", "Not Created");}
			}

			catch (Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}

	}


	@Then("I create device with a device type and test data and save {string}")
	public void i_create_device_with_a_device_type_and_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I Create device with device type and test data");

			String deviceID=randomStringGenerator();

			String MACAddress=getRamdomMAcAddress();

			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",deviceID,"VMM4677_1");

			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",deviceID,"VMM4677_1");

			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","DeviceID",deviceID,"VMM4677_1");

			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","MAC Address",MACAddress,"VMM4677_1");
		//	 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","DeviceType",deviceID,"VMM_4758_1");


			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getDevicePage().createNewDeviceNotAssignToTenant(testData);
			reportScreenshot(testSetup.driver);


		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I Create an DVR firmware DH6 license for the cloud-Government tenant {string}")
	public void i_create_an_dvr_firmware_dh6_license_for_the_cloud_government_tenant(String tcid) {

		try {
			test = logInfo.get().createNode("I Create an DVR firmware DH6 license for the cloud-Government tenant");
			reportInfo("I Create an DVR firmware DH6 license for the cloud-Government tenant");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().CreateLicenseWithSoftwareVersionField(testData);
			reportInfo("I Create an DVR firmware DH6 license");
			reportScreenshot(testSetup.driver);
			String LicenseAlertMsg = testSetup.pageObjectManager.getLicensesPage().LicenseSaveAndVerifyAlert();
			reportInfo("License Created Successfully");
			reportScreenshot(testSetup.driver);
			if(LicenseAlertMsg.contains("updated")) {
				reportPass("I verify License Is Created", LicenseAlertMsg, LicenseAlertMsg);
				reportInfo("License created successfully");
			}
			else {
				reportFail("I verify License Is Created ", "fail", "fail");
				reportInfo("License is Not created successfully ");
			}


			}
			catch (Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}

	}

	@Then("I assign device to license {string}")
	public void i_assign_device_to_license(String tcid) {

		try {
			test = logInfo.get().createNode("I assign device to license");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().searchTenant(testData);
			Map<String, String> testData2 = ExcelFileReader.getDataInMap("Devices", tcid);
			reportInfo(testData2.toString());
			testSetup.pageObjectManager.getLicensesPage().SelectAssignDevicesInLicense();
			testSetup.pageObjectManager.getLicensesPage().DeviceAssignToLicense(testData2);
			reportInfo("I Assign The Device to the License");
			reportScreenshot(testSetup.driver);


		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I Create an SF Commander license for the cloud-Government tenant {string}")
	public void i_create_an_sf_commander_license_for_the_cloud_government_tenant(String tcid) {


		try {
			test = logInfo.get().createNode("I Create an SF Commander license for the cloud-Government tenant");
			reportInfo("I Create an SF Commander license for the cloud-Government tenant");
			Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().createLicense(testData);
			reportInfo("I Create an SF Commander license");
			reportScreenshot(testSetup.driver);
			String LicenseAlertMsg = testSetup.pageObjectManager.getLicensesPage().LicenseSaveAndVerifyAlert();
			reportInfo("License Created Successfully");
			reportScreenshot(testSetup.driver);
			if(LicenseAlertMsg.contains("updated")) {
				reportPass("I verify License Is Created", LicenseAlertMsg, LicenseAlertMsg);
				reportInfo("License created successfully");
			}
			else {
				reportFail("I verify License Is Created ", "fail", "fail");
				reportInfo("License is Not created successfully ");
			}

			}
			catch (Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}

	}

	@Then("I publish and download the license for DVR firmware DH6 license {string}")
	public void i_publish_and_download_the_license_for_dvr_firmware_dh6_license(String tcid) {
		String filePath = System.getProperty("user.dir") + File.separator + "Downloads";

		try {
			test = logInfo.get().createNode("I publish and download the license for DVR firmware DH6 license");
			reportInfo("I publish and download the license for DVR firmware DH6 license");
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getLicensesPage().searchTenant(testData);
			testSetup.pageObjectManager.getLicensesPage().PublishDvrFirmwareLicense();
			reportInfo("I publish the DVR firmware DH6 license");
			reportScreenshot(testSetup.driver);
			FileUtils.deleteDirectory(new File(filePath));
			Thread.sleep(1000);
			testSetup.pageObjectManager.getLicensesPage().ConformPublishLicense();
			//Verifying downloaded License file
			File file = new File(filePath);
			String[] DownloadFile = file.list();
			String actualFile = DownloadFile[0];
			System.out.println(actualFile);
			String expFilePart1 = "DHDeviceLicenses-"+testData.get("TenantID");
			String expFilePart2 = LocalDate.now()+".zip";

			if(actualFile!=null && actualFile.contains(expFilePart1) && actualFile.contains(expFilePart2)) {
				reportPass("License file will be downloaded to Downloads folder in an encrypted format", "Tenant Id= "+expFilePart1 +"" + "Current Date= "+expFilePart2 , actualFile);
				reportInfo("License file downloaded successfully");
			}
			else {
				reportFail("License file will be Not downloaded successfully" ,"Tenant Id= "+expFilePart1 +""+"Current Date= "+expFilePart2, actualFile);
				reportScreenshot(testSetup.driver);
				}
			Map<String, String> testData2 = ExcelFileReader.getDataInMap("Devices", tcid);
			reportInfo(testData2.toString());

			String expectedFileName1 = "SN"+testData2.get("serial")+"MAC"+testData2.get("MAC Address")+"-"+LocalDate.now()+".sfptlic";
			String expectedFileName2 = "SN"+testData2.get("serial")+"MAC"+testData2.get("MAC Address")+"-"+LocalDate.now()+"_enc.key";

			//Unzip the license file and verify the file names
			testSetup.pageObjectManager.getLicensesPage().unzipAndVerifyDVRLicenseFile(filePath, filePath, expectedFileName1, expectedFileName2 );


		}
			catch (Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}

	}

	@Then("I publish the license for SF Commander license")
	public void i_publish_the_license_for_sf_commander_license() {
		try {
			test = logInfo.get().createNode("I publish the license for SF Commander license");
			testSetup.pageObjectManager.getLicensesPage().PublishSFCommanderLicense();
			reportInfo("I publish the SF Commander license");
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getLicensesPage().ConformPublishLicense();

			}
			catch (Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}


	}

	@Then("I Verify in TM Swagger, that the SF Commander published license is synced to TM, where as DVR firmware License will not be synced to TM {string}")
	public void i_verify_in_tm_swagger_that_the_sf_commander_published_license_is_synced_to_tm_where_as_dvr_firmware_license_will_not_be_synced_to_tm(String tcid) {

		try {
			test = logInfo.get().createNode("I Verify in TM Swagger, that the SF Commander published license is synced to TM, where as DVR firmware License will not be synced to TM {string}");

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

	@Then("I Verify Base Product SF Commander Appication Id In UI and Swagger {string}")
	public void i_verify_base_product_sf_commander_appication_id_in_ui_and_swagger(String tcid) {

		try {
			test = logInfo.get().createNode("I Verify Base Product SF Commander Appication Id In User Interface and  Available In TM Swagger ");
			Map<String, String> testData2 = ExcelFileReader.getDataInMap("GetTenant", tcid);
			String BearerToken = GenerateBearerToken.tenantManagerApi();
			response = given().header("Authorization", BearerToken).baseUri(tenantManager_baseURI).and().when().get("/tenant/"+testData2.get("TenantID")).then().extract().response();

				if (response!=null) {
					reportInfo("API triggered Successfully");
				}

				String resString = response.then().extract().asPrettyString();

				validateField("Staus Code ","200", String.valueOf(response.getStatusCode()));

				JsonPath js = new JsonPath(resString);

				reportPayload(response.getBody().asPrettyString());

			Map<String, String> testData = ExcelFileReader.getDataInMap("BaseProductPage", tcid);
		    testSetup.pageObjectManager.getBaseProductPage().clickViewToVerifyBaseProduct(testData);
		    reportInfo("I Verify Base Product Application Id In User Interface");
			reportScreenshot(testSetup.driver);
			String VerifyApplicationIdSts = testSetup.pageObjectManager.getBaseProductPage().verifySFCommanderBaseProductApplicationId();

			if(VerifyApplicationIdSts!=null) {
				reportPass("I click on view to verify that software in view has application id", VerifyApplicationIdSts, VerifyApplicationIdSts);

			}
			else {
				reportFail("I click on view to verify that software in view has application id" ,VerifyApplicationIdSts,VerifyApplicationIdSts);
				reportInfo("I View The Application Id In User Interface Not Available");
				reportScreenshot(testSetup.driver);
				}

			UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","VerifyApplicationID",VerifyApplicationIdSts,"VMM4677_1");
			reportInfo("I Verify Application Id Is Available In Tenant Manager Swagger");
			validateField("ApplicationID", testData2.get("VerifyApplicationID"), js.getString(ResponseTags.GetTenantDetails_APPLICATIONID));
			}
			catch (Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}

	}


	}



