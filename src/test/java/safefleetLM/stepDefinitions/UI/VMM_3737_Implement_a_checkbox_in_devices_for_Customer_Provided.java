package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3737_Implement_a_checkbox_in_devices_for_Customer_Provided extends BaseTest {

	TestSetup testSetup;

	public VMM_3737_Implement_a_checkbox_in_devices_for_Customer_Provided(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}

	 @Then("I create Tenant {string}")
	 public void i_create_tenant_something(String tcid) throws Throwable
	 {
		 try
			{
	    		String tenantID=randomStringGenerator();
	    		String deviceID1 = randomStringGenerator();
	    		Thread.sleep(3000);
	    		String deviceID2 = randomStringGenerator();
	    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM3737_1");
	    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","TenantID",tenantID,"VMM3737_1");
	    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","TenantID",tenantID,"VMM3737_2");
	    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",deviceID1,"VMM3737_1");
	    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",deviceID2,"VMM3737_2");
	    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM3737_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Tenant ID",tenantID,"VMM3737_3");
	    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM3737_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Tenant ID",tenantID,"VMM3737_4");
	    		test = logInfo.get().createNode("I create Tenant");
	    		Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
				//testSetup.pageObjectManager.getTenantsPage().createANewTenant(testData);
        testSetup.pageObjectManager.getTenantsPage().createNewTenantSyncToTMOFF(testData);
				testSetup.pageObjectManager.getTenantsPage().clickOnSaveButtonn();
				reportInfo("Created Tenant successfully");
				reportScreenshot(testSetup.driver);
			}
			catch(Exception e)
			{
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	 }

	 @Then("I create Device with customer provided on {string}")
	 public void i_create_device_with_customer_provided_on_something(String tcid) throws Throwable
	 {
		 try
			{
	    		test = logInfo.get().createNode("I create Device with customer provided on");
	    		Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
				testSetup.pageObjectManager.getDevicePage().createDeviceeWithCustomerProvided(testData);
				reportInfo("Created Device with customer provided on successfully");
				reportScreenshot(testSetup.driver);
			}
			catch(Exception e)
			{
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	 }

	 @Then("I create Device with customer provided off {string}")
	 public void i_create_device_with_customer_provided_off_something(String tcid) throws Throwable
	 {
		 try
			{
	    		test = logInfo.get().createNode("I create Device with customer provided off");
	    		Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
	    		testSetup.pageObjectManager.getDevicePage().createDeviceeWithoutCustomerProvided(testData);
				reportInfo("Created Device with customer provided off successfully");
				reportScreenshot(testSetup.driver);
			}
			catch(Exception e)
			{
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	 }

	 @Then("I verify customer provided on for one Device {string}")
	 public void i_verify_customer_provided_on_for_one_device(String tcid) throws Throwable
	 {
		 try
			{
	    		test = logInfo.get().createNode("I verify customer provided on for one Device");
	    		Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
	    		boolean actual = testSetup.pageObjectManager.getDevicePage().filterDeviceThroughTenantIDAndScrollSideways(testData);
	    		if(actual == true)
	    		{
	    			reportPass("Customer provided on for one Device verified successfully", "true", "true");
	    			reportInfo("Customer provided on for one Device verified successfully");
	    			reportScreenshot(testSetup.driver);
	    		}
	    		else
	    		{
	    			reportFail("Customer provided on for one Device not verified successfully", "false", "false");
	    			reportInfo("Customer provided on for one Device not verified successfully");
	    			reportScreenshot(testSetup.driver);
	    		}
	    		testSetup.pageObjectManager.getDevicePage().clickOnClearr();
			}
			catch(Exception e)
			{
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	 }

	 @Then("I verify customer provided off for another Device {string}")
	 public void i_verify_customer_provided_off_for_another_device(String tcid) throws Throwable
	 {
		 try
			{
	    		test = logInfo.get().createNode("I verify customer provided off for another Device");
	    		Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
	    		boolean actual = testSetup.pageObjectManager.getDevicePage().filterDeviceThroughTenantIDAndScrollSidewaysAgain(testData);
	    		if(actual == false)
	    		{
	    			reportPass("Customer provided off for another Device verified successfully", "true", "true");
	    			reportInfo("Customer provided off for another Device verified successfully");
	    			reportScreenshot(testSetup.driver);
	    		}
	    		else
	    		{
	    			reportFail("Customer provided off for another Device not verified successfully", "false", "false");
	    			reportInfo("Customer provided off for another Device not verified successfully");
	    			reportScreenshot(testSetup.driver);
	    		}
			}
			catch(Exception e)
			{
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	 }

	 @Then("I Bulk upload Device with customer provided on and off")
	 public void i_bulk_upload_device_with_customer_provided_on_and_off() throws Throwable
	 {
		 try
			{
			 	String unique=randomIntGenerator();
			 	String uniqueString=randomStringGenerator();
	    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM3737_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Serial #",unique,"VMM3737_3");
	    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM3737_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Device ID",uniqueString,"VMM3737_3");
	    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",uniqueString,"VMM3737_3");
	    		Thread.sleep(3000);
	    		String unique2=randomIntGenerator();
	    		String uniqueString2=randomStringGenerator();
	    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM3737_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Serial #",unique2,"VMM3737_4");
	    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM3737_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","Device ID",uniqueString2,"VMM3737_4");
	    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+"\\upload\\VMM3737_Bulk_Upload_Sheet_Devices.xlsx","DevicesSpreadSheet","MAC Address",uniqueString2,"VMM3737_4");
	    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",uniqueString2,"VMM3737_4");
	    		test = logInfo.get().createNode("I Bulk upload Device with customer provided on and off");
	    		testSetup.pageObjectManager.getDevicePage().clickOnBulkUploadAndUploadSpreadheet();
	    		testSetup.pageObjectManager.getBulkDeviceUploadPage().uploadFile(System.getProperty("user.dir")+"\\upload\\VMM3737_Bulk_Upload_Sheet_Devices.xlsx");
	    		testSetup.pageObjectManager.getBulkDeviceUploadPage().clickOnUploadButton();
	    		testSetup.pageObjectManager.getBulkDeviceUploadPage().clickOnFinalize();
	    		reportInfo("Created Device with Bulk upload and customer provided on and offsuccessfully");
				reportScreenshot(testSetup.driver);
			}
			catch(Exception e)
			{
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	 }

	 @Then("I verify customer provided on for one Device again {string}")
	 public void i_verify_customer_provided_on_for_one_device_again_something(String tcid) throws Throwable
	 {
		 try
			{
	    		test = logInfo.get().createNode("I verify customer provided on for one Device again");
	    		Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
	    		boolean actual = testSetup.pageObjectManager.getDevicePage().filterDeviceThroughTenantIDAndScrollSideways(testData);
	    		if(actual == true)
	    		{
	    			reportPass("Customer provided on for one Device verified successfully", "true", "true");
	    			reportInfo("Customer provided on for one Device verified successfully");
	    			reportScreenshot(testSetup.driver);
	    		}
	    		else
	    		{
	    			reportFail("Customer provided on for one Device not verified successfully", "false", "false");
	    			reportInfo("Customer provided on for one Device not verified successfully");
	    			reportScreenshot(testSetup.driver);
	    		}
	    		testSetup.pageObjectManager.getDevicePage().clickOnClearr();
			}
			catch(Exception e)
			{
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	 }

	 @Then("I verify customer provided off for another Device again {string}")
	 public void i_verify_customer_provided_off_for_another_device_again(String tcid) throws Throwable
	 {
		 try
			{
	    		test = logInfo.get().createNode("I verify customer provided off for another Device again");
	    		Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
	    		boolean actual = testSetup.pageObjectManager.getDevicePage().filterDeviceThroughTenantIDAndScrollSidewaysAgain(testData);
	    		if(actual == false)
	    		{
	    			reportPass("Customer provided off for another Device verified successfully", "true", "true");
	    			reportInfo("Customer provided off for another Device verified successfully");
	    			reportScreenshot(testSetup.driver);
	    		}
	    		else
	    		{
	    			reportFail("Customer provided off for another Device not verified successfully", "false", "false");
	    			reportInfo("Customer provided off for another Device not verified successfully");
	    			reportScreenshot(testSetup.driver);
	    		}
			}
			catch(Exception e)
			{
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
	 }

		@Then("I unassign Tenant from the Device {string}")
		public void i_unassign_tenant_from_the_device(String tcid) {
			try {
				test = logInfo.get().createNode("I unassign Tenant from the Device");

				Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
				reportInfo(testData.toString());
				testSetup.driver.navigate().refresh();
				testSetup.pageObjectManager.getDevicePage().createdDevicesearch(testData);
				reportScreenshot(testSetup.driver);
				testSetup.pageObjectManager.getDevicePage().clickOnEditDevice();
				testSetup.pageObjectManager.getDevicePage().clickUnassignBtn();
				testSetup.pageObjectManager.getDevicePage().clickUnassigndevicetxtfield(testData);
				testSetup.pageObjectManager.getDevicePage().saveDevice();

				reportInfo("user should be able to unassign the Tenant Successfully");
			}
			catch (Exception e)
			{
				testStepHandle("FAIL", testSetup.driver, test, e);
			}
		}

		@Then("I delete the created Device {string}")
		public void i_delete_the_created_device(String tcid) {
			try
	        {
				test = logInfo.get().createNode("I delete the created Device");
				Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
				testSetup.driver.navigate().refresh();
	            testSetup.pageObjectManager.getDevicePage().SearchCreatedDeviceByContains(testData);
	            testSetup.pageObjectManager.getDevicePage().deleteTheDevice();
	    		reportInfo("I deleted the Device");
	        }
	        catch(Exception e)
	        {
	        	testStepHandle("FAIL", testSetup.driver, test, e);
	        }
		}

}
