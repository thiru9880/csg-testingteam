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

public class VMM_4758_Multiple_devices_device_are_un_assigned_to_existing_Tenant_and_synced_to_TM extends BaseTest {

	TestSetup testSetup;
	Response response = null;
	public static String resString=null;
    public static RequestSpecification req = null;
	public static ResponseSpecification res = null;

	public VMM_4758_Multiple_devices_device_are_un_assigned_to_existing_Tenant_and_synced_to_TM(TestSetup testSetup) throws IOException {
		this.testSetup = testSetup;
	}

	@Then("I create a New tenant with test data {string}")
	public void i_create_New_tenant_with_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I create a new tenant for with test data");

			String tenantID=randomStringGenerator();

			System.out.println(tenantID);

			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_4758_1");

			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",tenantID,"VMM_4758_1");

			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TanantAlias",tenantID,"VMM_4758_1");

			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","TenantID",tenantID,"VMM_4758_1");

			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_4758_2");

             UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",tenantID,"VMM_4758_2");

             UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TanantAlias",tenantID,"VMM_4758_2");

             UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","TenantID",tenantID,"VMM_4758_2");



			   // testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();

			    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);

			    testSetup.pageObjectManager.getTenantsPage().createNewTenantLicense(testData);

			    reportScreenshot(testSetup.driver);
			    reportInfo("New tenant is created Successfully ");


		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I Search for a tenant and verify the details {string}")
	public void i_search_for_a_tenant_and_verify_the_details(String tcid) {
		try {
			test = logInfo.get().createNode("I Search for a tenant and verify the details");
			test.assignCategory("Integration with TM");

			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());

			testSetup.pageObjectManager.getTenantsPage().TenantSearch(testData);
			testSetup.pageObjectManager.getTenantsPage().clickOnTenantViewBtn();
			reportScreenshot(testSetup.driver);

			String verify=testSetup.pageObjectManager.getTenantsPage().VerifyCretedTenant();

			testSetup.pageObjectManager.getTenantsPage().clickOnTenantBackBtn();

			if(verify.equalsIgnoreCase("Tenant ID"))
			{
				reportPass("Tenant verified", "Tenant ID", verify);
				reportInfo("I verified tenent details successfully");
			}
			else {
				reportFail("Tenant not verified", "Tenant ID", verify);
				reportInfo("I verified tenent details not successfully");
			}
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}
		@Then("I create device with a device type and test data {string}")
		public void i_create_device_with_a_device_type_and_test_data(String tcid) {
			try {
				test = logInfo.get().createNode("I Create device with device type and test data");


				String deviceID=randomStringGenerator();

				String MACAddress=getRamdomMAcAddress();

				 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",deviceID,"VMM_4758_1");

				 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",deviceID,"VMM_4758_1");

				 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","DeviceID",deviceID,"VMM_4758_1");
				 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",deviceID,"VMM_4758_1");
	             UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","DeviceID",deviceID,"VMM_4758_1");

				 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","MAC Address",MACAddress,"VMM_4758_1");
			//	 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","DeviceType",deviceID,"VMM_4758_1");


				Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
				reportInfo(testData.toString());
				testSetup.pageObjectManager.getDevicePage().NewdeviceCreate(testData);
				reportScreenshot(testSetup.driver);

			}
			catch (Exception e)
			{
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
		}

		@Then("I click on Save button on the Tenant page")
        public void I_click_on_Save_button_on_the_Tenant_page() {
            try {
                test = logInfo.get().createNode("I click on Save button on the Tenant page");

                 testSetup.pageObjectManager.getTenantsPage().tenantSave();
            }
            catch (Exception e)
            {
                testStepHandle("FAIL", testSetup.driver, test, e);
            }

        }


		@Then("I verify that the assigned devices are showed in swagger UI are not {string}")
		public void i_verify_that_the_assigned_devices_are_showed_in_swagger_ui_are_not(String tcid) {
				try {
	    			test = logInfo.get().createNode("I verify that After Assign devices response for GetTenant API");

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

	    			validateField("TenantType", testData.get("TenantType"), js.getString(ResponseTags.GetTenantDetails_TENANTTYPE));// GetTenantDetails_DEVICEID

	    		//	validateField("Description", testData.get("Description"), js.getString(ResponseTags.GetTenantDetails_DESCRIPTION));

	    			validateField("deviceId", testData.get("DeviceID"), js.getString(ResponseTags.GetTenantDetails_DEVICEID));

	    			validateField("DeviceType", testData.get("DeviceType"), js.getString(ResponseTags.GetTenantDetails_DeviceType));


			}
			catch (Exception e)
			{
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
		}

		@Then("I click On Unassign and User should be able to unassign the devices {string}")
		public void i_click_On_Unassign_and_ser_should_be_able_to_unassign_the_devices(String tcid) {
			try {
				test = logInfo.get().createNode("I click On Unassign and User should be able to unassign the devices");

				Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
				reportInfo(testData.toString());
				testSetup.pageObjectManager.getDevicePage().createdDevicesearch(testData);
				reportScreenshot(testSetup.driver);

				testSetup.pageObjectManager.getDevicePage().clickOnEditDevice();

				testSetup.pageObjectManager.getDevicePage().clickUnassignBtn();

				reportInfo("user should be able to unassign the devices Successfully");
			}
			catch (Exception e)
			{
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
		}

		@Then("I Select the Device status while Unassigning the Device from Tenant with testdata {string} and save")
        public void i_select_the_device_status_with_testdata_and_save(String tcid) {
            try {
                test = logInfo.get().createNode("I Select the Device status while Unassigning the Device from Tenant with testdata and save");

                Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
                testSetup.pageObjectManager.getDevicePage().clickUnassigndevicetxtfield(testData);

                testSetup.pageObjectManager.getTenantsPage().clickOnTenantsave();

                reportInfo("Select the Device status with testdata successfully");


            } catch (Exception e) {
                testStepHandle("FAIL", testSetup.driver, test, e);
            }

        }


		@Then("I verify that the unassigend devices are showed in swagger UI are not {string}")
		public void i_verify_that_the_unassigned_devices_are_showed_in_swagger_ui_are_not(String tcid) {
				try {
		    		test = logInfo.get().createNode("I verify that After Unassign devices response for GetTenant API");

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

			    	validateField("TenantType", testData.get("TenantType"), js.getString(ResponseTags.GetTenantDetails_TENANTTYPE));// GetTenantDetails_DEVICEID



					}
					catch (Exception e)
					{
						testStepHandle("FAIL", testSetup.driver, test, e);
					}
		}

				@Then("I create a New Tenant for with test data {string}")
				public void i_create_new_tenant_for_with_test_data(String tcid) {
					try {
						test = logInfo.get().createNode("I create a new tenant for with test data");

						String tenantID=randomStringGenerator();

						System.out.println(tenantID);

						 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_4758_2");

						 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","TenantID",tenantID,"VMM_4758_2");

						 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",tenantID,"VMM_4758_2");
						 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TanantAlias",tenantID,"VMM_4758_2");

						  //  testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();

						    Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);

						    testSetup.pageObjectManager.getTenantsPage().createNewTenantLicense(testData);
//						    reportInfo("New tenant is created with test data ");


						   // reportInfo("Test data "+testData);
						    reportScreenshot(testSetup.driver);
						    reportInfo("New tenant is created Successfully ");

					}
					catch (Exception e)
					{
						testStepHandle("FAIL", testSetup.driver, test, e);
					}
				}
					@Then("I creat device with device type and test data {string}")
					public void i_creat_device_with_device_type_and_test_data(String tcid) {
						try {
							test = logInfo.get().createNode("I creat device with device type and test data");


							String deviceID=randomStringGenerator();

							String MACAddress=getRamdomMAcAddress();

							 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",deviceID,"VMM_4758_2");

							 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",deviceID,"VMM_4758_2");

							 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","DeviceID",deviceID,"VMM_4758_2");

							 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","MAC Address",MACAddress,"VMM_4758_2");


							Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
							reportInfo(testData.toString());
							testSetup.pageObjectManager.getDevicePage().clickNewDevicemultiple(testData);
							reportScreenshot(testSetup.driver);

						}
						catch (Exception e)
						{
							testStepHandle("FAIL", testSetup.driver, test, e);
						}
					}




						@Then("I verify that assigned devices are showed in swagger UI are not {string}")
						public void i_verify_that_the_assigned_devices_are_showed_in_Swagger_ui_are_not(String tcid) {
								try {
						    		test = logInfo.get().createNode("I verified that After assign Devices response for GetTenant API");

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

							    	validateField("TenantType", testData.get("TenantType"), js.getString(ResponseTags.GetTenantDetails_TENANTTYPE));// GetTenantDetails_DEVICEID


					    			validateField("deviceId", testData.get("DeviceID"), js.getString(ResponseTags.GetTenantDetails_DEVICEID));

					    			validateField("DeviceType", testData.get("DeviceType"), js.getString(ResponseTags.GetTenantDetails_DeviceType));

									}
									catch (Exception e)
									{
										testStepHandle("FAIL", testSetup.driver, test, e);
									}
		}



						@Then("I will Unassign the devices and click On save {string}")
						public void i_Wili_unassign_the_devices_and_click_on_save(String tcid) {
							try {
								test = logInfo.get().createNode("I will Unassign the devices and click On save");

								Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
								reportInfo(testData.toString());

								testSetup.pageObjectManager.getTenantsPage().selectDeviceTypeandDeviceID(testData);
								reportScreenshot(testSetup.driver);

								testSetup.pageObjectManager.getTenantsPage().selectUnAssignBtn();
								reportScreenshot(testSetup.driver);

							    reportInfo("I unassign the devicess Successfully ");
							}
							catch (Exception e)
							{
								testStepHandle("FAIL", testSetup.driver, test, e);
							}
						}

						@Then("I verify that unssigned devices are showed in swagger UI are not {string}")
						public void i_verify_that_unssigned_devices_are_showed_in_Swagger_ui_are_not(String tcid) {
								try {
						    		test = logInfo.get().createNode("I verified that After unassign Devices response for GetTenant API");

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

							    	validateField("TenantType", testData.get("TenantType"), js.getString(ResponseTags.GetTenantDetails_TENANTTYPE));// GetTenantDetails_DEVICEID



									}
									catch (Exception e)
									{
										testStepHandle("FAIL", testSetup.driver, test, e);
									}
		}
	}
