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

public class VMM_4578_Verification_of_Settings_icon_in_Device_page_when_assigning_Tenant_in_Device_page extends BaseTest {
		
	TestSetup testSetup;
    
	Response response = null;
	public static String resString=null;
    public static RequestSpecification req = null;
	public static ResponseSpecification res = null;
	
	public VMM_4578_Verification_of_Settings_icon_in_Device_page_when_assigning_Tenant_in_Device_page(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}
	
	@Then("I creat New tenant with test data {string}")
	public void i_create_New_tenant_with_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I creat New tenant with test data");
			
			String tenantID=randomStringGenerator();   
			
			System.out.println(tenantID); 
	 		
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM_4578_1");
			 
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TenantID",tenantID,"VMM_4578_1");
     	     UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","TanantAlias",tenantID,"VMM_4578_1");
			 
	//		 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","TenantID",tenantID,"VMM_4578_1");
			 
			
			    
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
	
	
	@Then("I Create a device with device type and test data {string}")
	public void i_create_a_device_with_device_type_and_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I Create a device with device type and test data");
			
			
			String deviceID=randomStringGenerator();
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",deviceID,"VMM_4578_1");
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",deviceID,"VMM_4578_1");
			
			 
			 UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"GetTenant","DeviceID",deviceID,"VMM_4578_1");
			 
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
	 
	
	@Then("I using show filter to get device details and i verify the setting icon {string}")
	public void i_using_show_filter_to_get_device_details_and_i_verify_the_setting_icon(String tcid) {
		try {
			test = logInfo.get().createNode("I using show filter to get device details and i verify the setting icon");
			test.assignCategory("Devices");
			
			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
			reportInfo(testData.toString()); 
			testSetup.pageObjectManager.getDevicePage().createdDevicesearch(testData);
			reportScreenshot(testSetup.driver); 
			
			Boolean Btdisble = testSetup.pageObjectManager.getDevicePage().settingBtnDisabled();
			if (Btdisble==true) {
				reportPass("setting button is disabled", "true", "true");   
				reportScreenshot(testSetup.driver);  
				reportInfo("Verify that setting button is disabled");  
				 
			} else {
				reportFail("setting button", "false","false");
				reportScreenshot(testSetup.driver); 
				reportInfo("Verify that setting button not disabled"); 
			}  
		} 
		catch (Exception e)
		{ 
			testStepHandle("FAIL", testSetup.driver, test, e); 
		}
	   
	}
	@Then("I verify that Settings for the device created by using tenant ID {string}")
	public void i_verify_that_settings_for_the_device_created_by_using_tenant_id(String tcid) {
		try {
			test = logInfo.get().createNode("I verify that Settings for the device created by using tenant ID");
			
			Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString());
			
			testSetup.pageObjectManager.getDevicePage().clickOnEditDevice();
			
			testSetup.pageObjectManager.getDevicePage().TenantIdsearch(testData);
			
			Map<String, String> testData1 = ExcelFileReader.getDataInMap("Devices", tcid);
			String dialog1=testSetup.pageObjectManager.getDevicePage().dialogappear();
			if (dialog1.contains("Are you sure you want to assign the Device(s) with the following setting?")) {
				reportPass("dialog should appear", "Are you sure you want to assign the Device(s) with the following setting?", dialog1);
				reportScreenshot(testSetup.driver);
				reportInfo("Verify that dialog appear to assign Device Settings is successful");
				reportScreenshot(testSetup.driver); 
				
			} else {
				reportFail("dialog should appear", "Are you sure you want to assign the Device(s) with the following setting?", dialog1);
				reportScreenshot(testSetup.driver);
				reportInfo("Verify that dialog not appear to assign Device Settings");
				reportScreenshot(testSetup.driver); 
			}
			testSetup.pageObjectManager.getDevicePage().clicktoggleBtn(testData1);
			testSetup.pageObjectManager.getDevicePage().clickassignDeviceBtn();
			testSetup.pageObjectManager.getDevicePage().saveDevice();
			      
		}  
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e); 
		} 
	}
	
	
	
	@Then("I verify assigned devices are showed in swagger UI are not {string}")
	public void i_verify_assigned_devices_are_showed_in_swagger_ui_are_not(String tcid) {
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
	
	@Then("I Verify that the device is listed in Devices dashboard page along with Tenant Id details {string}")
	public void i_Verify_that_the_device_is_listed_in_devices_dashboard_page_along_with_tenant_id_details(String tcid) {
		
		try {
			test = logInfo.get().createNode("I Verify that the device is listed in Devices dashboard page along with Tenant Id details");
			
			
			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
			Map<String, String> testData2 = ExcelFileReader.getDataInMap("TenantPage", tcid);
			reportInfo(testData.toString()); 
			testSetup.pageObjectManager.getDevicePage().createdDeviceSearchFilterverify(testData);
		
			
			
			
			
			
			reportInfo("i Verify Tenant Id is Assigned in Device"); //1
			String verifytenantsts = testSetup.pageObjectManager.getDevicePage().VerifyAssignedTenant(testData2);
			System.out.println("txtField"+verifytenantsts);
			System.out.println("from xl"+testData.get("TenantID"));
			
			reportScreenshot(testSetup.driver);
			if(verifytenantsts.equals(verifytenantsts)) {
				reportPass("i Verify Tenant id is Assigned In Devices",verifytenantsts, verifytenantsts);
				reportInfo("tenanat Id Assigned Successfully");
			}
			else {
				reportFail("Not Assigned Successfully","false" ,"false");
			}
			
			
			
			reportInfo("i Verify The DeviceType And Data Status Of The Device");  //2
			String verifyDeviceTypetext = testSetup.pageObjectManager.getDevicePage().VerifyDeviceTypeTxtBx(testData);
			if(verifyDeviceTypetext.contains(verifyDeviceTypetext)) {
				reportPass("i Verify Device type",verifyDeviceTypetext, verifyDeviceTypetext);
				reportScreenshot(testSetup.driver);
				reportInfo("Device Status Updated Successfully");
			}
			else {
				reportFail("Not Updated Successfully","false" ,"false");
				reportScreenshot(testSetup.driver);
			}
			
			
			
			String VerifyDataSts = testSetup.pageObjectManager.getDevicePage().VerifyDataStatus(); //3
			if(VerifyDataSts.contains(VerifyDataSts)) {
				reportPass("i Verify Data Status",VerifyDataSts, VerifyDataSts);
				reportScreenshot(testSetup.driver);
				reportInfo("Data Status Updated Successfully");
			}
			else {
				reportFail("Not Updated Successfully","false" ,"false");
				reportScreenshot(testSetup.driver);
			}
			
			testSetup.pageObjectManager.getDevicePage().clickOnEditDevice(); 

			
		} 
		catch (Exception e)
		{ 
			testStepHandle("FAIL", testSetup.driver, test, e); 
		}
	   
	}
	
	
		
	@Then("I Click on Unassign and user should be able to unassign the devices {string}")
	public void i_click_on_unassign_and_user_should_be_able_to_unassign_the_devices(String tcid) {
		try {
			test = logInfo.get().createNode("I Click on Unassign and user should be able to unassign the devices");
			
			/*Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getDevicePage().createdDevicesearch(testData);
			reportScreenshot(testSetup.driver);  
			 
			testSetup.pageObjectManager.getDevicePage().clickOnEditDevice(); */
			
			testSetup.pageObjectManager.getDevicePage().clickUnassignBtn();  
			
			reportInfo("user should be able to unassign the devices Successfully");
		}  
		catch (Exception e) 
		{
			testStepHandle("FAIL", testSetup.driver, test, e); 
		}
	}
	
	
	@Then("I verify unassigned devices are showed in swagger UI are not {string}")
	public void i_verify_unassigned_devices_are_showed_in_swagger_ui_are_not(String tcid) {
			try {
    			test = logInfo.get().createNode("I verify that After unassign devices response for GetTenant API");
    			
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	@Then("I Delete the device {string}") 
	public void i_Delete_the_device(String tcid) {
		try { 
		test = logInfo.get().createNode("I Delete the device");
		
		Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
		reportInfo(testData.toString());
		testSetup.pageObjectManager.getDevicePage().createdDevicesearch(testData);
		
		testSetup.pageObjectManager.getDevicePage().deleteCreateddevice();
		reportScreenshot(testSetup.driver);
		
		testSetup.pageObjectManager.getDevicePage().deleteDeviceOkBtn();
		reportScreenshot(testSetup.driver);
		
		reportInfo("Device is deleted Successfully");
		}   
		catch (Exception e)  
		{
			testStepHandle("FAIL", testSetup.driver, test, e); 
		}
	}

}
	


