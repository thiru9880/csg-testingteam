package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;

public class VMM_3492_Delete_button_is_not_giving_any_alert_when_a_device_type_can_not_be_deleted extends BaseTest {
		
	TestSetup testSetup;
    
	public VMM_3492_Delete_button_is_not_giving_any_alert_when_a_device_type_can_not_be_deleted(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}
	@Then("I create a New device type {string}")
	public void i_create_a_New_device_type(String tcid) throws Exception {
		try {
		test = logInfo.get().createNode("I create a new device type");
		
		Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceType", tcid);
		reportInfo(testData.toString());
		testSetup.pageObjectManager.getDeviceTypesPage().DeviceTypeCrete(testData);
		reportScreenshot(testSetup.driver);
		testSetup.pageObjectManager.getDeviceTypesPage().clickOnDeviceTypeSave();
		reportScreenshot(testSetup.driver);
		testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
		reportInfo("I created new device type successfully");
		} 
		catch (Exception e) 
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	} 
	
		
	@Then("I click on new and I create Device setting {string}")
	public void i_click_on_new_and_i_create_Device_setting(String tcid)  throws Exception { 
		try {
			test = logInfo.get().createNode("I click on new and I create Device setting");
			

			Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceSettingPage", tcid);
			reportInfo(testData.toString());
			testSetup.pageObjectManager.getDeviceSettingsPage().createdevicesetting(testData);
			reportScreenshot(testSetup.driver);
			
			testSetup.pageObjectManager.getDeviceSettingsPage().clickOndevicesttingsave();
			reportScreenshot(testSetup.driver);
			  
			reportInfo("I created device setting successfully");  
		}  
		catch (Exception e) 
		{
			testStepHandle("FAIL", testSetup.driver, test, e);  
		}
		}
		@Then("I try to delete the device type and I verify device type which is tied to a device setting alert popup displayed {string}")
		public void i_try_to_delete_the_device_type_and_i_verify_device_type_which_is_tied_to_a_device_setting_alert_popup_displayed(String tcid)  { 
			try {
				test = logInfo.get().createNode("I try to delete the device type and I verify device type which is tied to a device setting alert popup displayed");
				test.assignCategory("Devices");
				Map<String, String> testData = ExcelFileReader.getDataInMap("DeviceType", tcid);
				reportInfo(testData.toString());
				String alert =testSetup.pageObjectManager.getDeviceTypesPage().TiedDevicetypeDelete(testData);
				reportScreenshot(testSetup.driver);
				System.out.println(alert); 
				if(alert.contains("The  Device  Type you are trying to delete is tied to a  Device  Setting"))
				    reportPass("Alert messaeg", "The  Device  Type you are trying to delete is tied to a  Device  Setting", alert);
				else
					reportFail("Alert messaeg", "The  Device  Type you are trying to delete is tied to a  Device  Setting", alert);}
				catch (Exception e)
				{
					testStepHandle("FAIL", testSetup.driver, test, e);
				}  
				
}       
} 

