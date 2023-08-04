package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

	
	public class VMM_3400_Bulk_Edit extends BaseTest {
		
		TestSetup testSetup;
		
	    
		public VMM_3400_Bulk_Edit(TestSetup testSetup) throws IOException {
			this.testSetup=testSetup;
		} 
		
		@Then("I Create a New Tenant For Bulk Edit {string}")
		public void i_create_a_new_tenant_for_bulk_edit(String tcid) {
			
			try {
				String tenantID=randomStringGenerator();
	            UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM3400_1");
	            UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","TenantID",tenantID,"VMM3400_1");
	            UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","TenantID",tenantID,"VMM3400_2");
				test = logInfo.get().createNode("I create new Tenant For Devices");
				reportInfo("I create new Tenant For Devices");
				Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
				reportInfo(testData.toString());
				testSetup.pageObjectManager.getTenantsPage().createNewTenant(testData);
				reportScreenshot(testSetup.driver);
				String AlertMsg = testSetup.pageObjectManager.getTenantsPage().tenantSave(testData);
				reportInfo("Tenant Created Successfully");
				reportScreenshot(testSetup.driver);
				if(AlertMsg.contains("A new Tenant is created with identifier")) {
					reportPass("Tenant ", "A new Tenant is created with identifier", AlertMsg);
					reportInfo("Tenant ID "+testData.get("TenantID").toLowerCase()+" created successfully");
				}
				else
					reportPass("Tenant ", "A new Tenant is created with identifier", AlertMsg);
				}
			
				
				catch (Exception e) {
					testStepHandle("FAIL", testSetup.driver, test, e);
				}
		  
		}
		
		@Then("I Create a First Devices For Bulk Edit {string}")
		public void i_create_a_First_devices_for_bulk_edit(String tcid) {
			
			try {
				test = logInfo.get().createNode("I create a First Devices for Bulk Edit");
				test.assignCategory("Devices");
				String serialID1=randomStringGenerator();
			
				String DeviceId1=randomStringGenerator();
				
				UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",serialID1,"VMM3400_1");
				UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",DeviceId1,"VMM3400_1");
				
				Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
				reportInfo(testData.toString());
				testSetup.pageObjectManager.getDevicePage().clickNewDevice(testData);
				reportInfo("I Create a Device With TestData");
				reportScreenshot(testSetup.driver);
				testSetup.pageObjectManager.getDevicePage().clicktoggleBtn(testData);
				testSetup.pageObjectManager.getDevicePage().clickassignDeviceBtn();
				testSetup.pageObjectManager.getDevicePage().DeviceSettingSaveConformation();

			}
			catch(Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}  
		 
		}
		
		@Then("I Create a Second Devices For Bulk Edit {string}")
		public void i_create_a_second_devices_for_bulk_edit(String tcid) {

			try {
                String serialID2=randomStringGenerator();
				
				String DeviceId2=randomStringGenerator();
				
				UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","serial",serialID2,"VMM3400_2");
				UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"Devices","DeviceID",DeviceId2,"VMM3400_2");
				
				test = logInfo.get().createNode("I create a second Devices for Bulk Edit");
				Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
				reportInfo(testData.toString());
				testSetup.pageObjectManager.getDevicePage().clickNewDevice(testData);
				reportInfo("I Create a Device With TestData");
				reportScreenshot(testSetup.driver);
				testSetup.pageObjectManager.getDevicePage().clicktoggleBtn(testData);
				testSetup.pageObjectManager.getDevicePage().clickassignDeviceBtn();
		        testSetup.pageObjectManager.getDevicePage().DeviceSettingSaveConformation();
			}
			catch(Exception e) {
				testStepHandle("FAIL", testSetup.driver, test, e);
			}  
		}
		
		@Then("I Select Multiple Tenant ID {string}")
		public void i_select_multiple_tenant_id(String tcid) throws Exception 
		{
			try {
			test = logInfo.get().createNode("i click on operations tab to navigate sales regions");
			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
			testSetup.pageObjectManager.getDevicePage().SearchTenant(testData);
			testSetup.pageObjectManager.getDevicePage().checkonDevices(testData);
			reportScreenshot(testSetup.driver);
			reportInfo("Selection of Multiple Tenant ID Successful");
			}
			catch(Exception e) 
			{
				testStepHandle("FAIL",testSetup.driver,test,e);	
			}
		}
		@Then("I Click on Bulk Edit")
		public void i_click_on_bulk_edit() throws Exception 
		{
			try {
			test = logInfo.get().createNode("I Click on Bulk Edit");
			testSetup.pageObjectManager.getDevicePage().clickonBulkEdit();
			reportInfo("Click on Bulk Edit Successful");
			}
			catch(Exception e)
			{
				testStepHandle("FAIL",testSetup.driver,test,e);	
			}
			
		}
		
		@Then("I Select Devices manually selected option and click Next")
		public void i_select_devices_manually_selected_option_and_click_next() throws Exception 
		{
			try {
			test = logInfo.get().createNode("I Select Devices manually selected option and click Next");
			testSetup.pageObjectManager.getDevicePage().clickonCircle();
			reportScreenshot(testSetup.driver);
			reportInfo("Selection 'Devices manually selected' option and click Next Successful");
			}
			catch(Exception e)
			{
				testStepHandle("FAIL",testSetup.driver,test,e);	
			}
		}
		
		@Then("I Select the Part check box and change the Part No. {string}")
		public void i_select_the_device_status_check_box_and_change_the_status_to_valid(String tcid) throws Exception 
		{
			try {
			test = logInfo.get().createNode("I Select the Device Part check box and change the Part No.");
			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
			testSetup.pageObjectManager.getDevicePage().clickonDviceStatus(testData);
			reportScreenshot(testSetup.driver);
			reportInfo("Selection of Device status check box and change the status to valid Successful");
			}
			catch(Exception e)
			{
				testStepHandle("FAIL",testSetup.driver,test,e);	
			}
		}
		
		@Then("I Click Next, then Next and Ok")
		public void i_click_next_then_next_and_ok() throws Exception 
		{
			try {
			test = logInfo.get().createNode("I Click Next, then Next and Ok");
			testSetup.pageObjectManager.getDevicePage().clickonNextOK();
			reportInfo("Click Next twice and Ok Successful"); 
			}
			catch(Exception e)
			{
				testStepHandle("FAIL",testSetup.driver,test,e);	
			}
		}
		
		@Then("I Verify Part No. is updated successfully with new Part No. selected {string}")
		public void i_verify_device_status_is_updated_successfully_with_valid_new_device_status_selected(String tcid) throws Exception 
		{
			try {
			test = logInfo.get().createNode("I Verify Part No. is updated successfully with new Part No. selected");
			Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
			String text=testSetup.pageObjectManager.getDevicePage().verifyDeviceStatus(testData);
			
			if(text.equals(testData.get("Part")))
			{
			reportPass("Parts",testData.get("Part"),text);
			reportScreenshot(testSetup.driver);
			reportInfo("Verify Device status is updated successfully with valid new device status selected");
			}
			else
			{
				reportFail("Parts ",testData.get("Part"),text);
				reportScreenshot(testSetup.driver);
			}
			testSetup.pageObjectManager.getDevicePage().AfterVerifyClear();
		}
			catch(Exception e)
			{
				testStepHandle("FAIL",testSetup.driver,test,e);	
			}

		}
		
		@Then("I delete the First Device {string}")
		public void i_delete_the_first_device(String tcid) {
			try {
				test = logInfo.get().createNode("I delete the First Device");
				Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
				reportInfo("I Delete The First Created Device");
				testSetup.pageObjectManager.getDevicePage().ClickHideFilter();
				testSetup.pageObjectManager.getDevicePage().SearchCreatedDevice(testData);
				testSetup.pageObjectManager.getDevicePage().UnassignTenantInDevices();
				testSetup.pageObjectManager.getDevicePage().SearchCreatedDevice(testData);
				testSetup.pageObjectManager.getDevicePage().SelectDeleteIconCreatedDevice();
				reportScreenshot(testSetup.driver);
				testSetup.pageObjectManager.getDevicePage().ConformDeleteCreatedDevice();
				}
				catch(Exception e)
				{
					testStepHandle("FAIL",testSetup.driver,test,e);	
				}
		    
		}

		@Then("I delete the Second Device {string}")
		public void i_delete_the_second_device(String tcid) {
			try {
				test = logInfo.get().createNode("I delete the Second Device");
				Map<String, String> testData = ExcelFileReader.getDataInMap("Devices", tcid);
				reportInfo("I Delete The Second Created Device");
				testSetup.pageObjectManager.getDevicePage().SearchCreatedDevice(testData);
				testSetup.pageObjectManager.getDevicePage().UnassignTenantInDevices();
				testSetup.pageObjectManager.getDevicePage().SearchCreatedDevice(testData);
				testSetup.pageObjectManager.getDevicePage().SelectDeleteIconCreatedDevice();
				reportScreenshot(testSetup.driver);
				testSetup.pageObjectManager.getDevicePage().ConformDeleteCreatedDevice();
			
				}
				catch(Exception e)
				{
					testStepHandle("FAIL",testSetup.driver,test,e);	
				}
		 
		}
		
	}
		

	
