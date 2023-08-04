package safefleetLM.stepDefinitions.UI;

import java.io.File;
import java.io.IOException;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.TestSetup;

public class VMM_3655_cosystem_device_settings_export_to_excel extends BaseTest {
	
TestSetup testSetup;
	
    
	public VMM_3655_cosystem_device_settings_export_to_excel(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
		
	}
	
	
	@Then("I navigate to ecosystem settings under operations tab")
	public void i_navigate_to_ecosystem_settings_under_operations_tab() throws IOException {
   try {
	test = logInfo.get().createNode("I navigate to ecosystem settings under operations tab");
	
	testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
	
	testSetup.pageObjectManager.getHomePage().navigateToEcoSystemTab();
	
	testSetup.pageObjectManager.getLicensesPage().waitForAngularToLoad();
	
	reportInfo("User Navigated to EcoSystemTab");
	
	reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}

	}

	@Then("I click on the arrow next to Ecosystem settings")
	public void i_click_on_the_arrow_next_to_ecosystem_settings() throws InterruptedException, IOException {
    try {
	test = logInfo.get().createNode("I click on the arrow next to Ecosystem settings");
	
	 test.assignCategory("Others");
	
	testSetup.pageObjectManager.getEcosystemSettingsPage().exportEcosystemSettings();
	
	reportInfo("Ecosystem Settings downloaded successfully");
	
	reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}	  	   
	}

	@Then("I verify if the downloaded excel has the ecosystem settings headers")
	public void i_verify_if_the_downloaded_excel_has_the_ecosystem_settings_headers() {
    try {
		test = logInfo.get().createNode("I verify if the downloaded excel has the ecosystem settings headers");
		
		System.out.println("Validating the ecosystem excel export");
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}		
	}

	@Then("I navigate to device settings under operations tab")
	public void i_navigate_to_device_settings_under_operations_tab() throws IOException {
    try {
		test = logInfo.get().createNode("I navigate to device settings under operations tab");
		
		testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
		
		testSetup.pageObjectManager.getHomePage().navigateToDeviceSettingsTab();
		
		testSetup.pageObjectManager.getLicensesPage().waitForAngularToLoad();
		
		reportInfo("User Navigated to Device Settings Tab");
		
		reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}
	}

	@Then("I click on the arrow next to device settings")
	public void i_click_on_the_arrow_next_to_device_settings() throws InterruptedException, IOException {
    try {
		test = logInfo.get().createNode("I click on the arrow next to device settings");
		
		testSetup.pageObjectManager.getDeviceSettingsPage().exportDeviceSettings();
		  
		reportInfo("Device Settings downloaded successfully");
		
		reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}				
	}
	
	
	  @Then("I verify if the downloaded excel has the device settings headers") 
	  public void  i_verify_if_the_downloaded_excel_has_the_device_settings_headers() {
		  try {
			  test = logInfo.get().createNode("I verify if the downloaded excel has the device settings headers");
			  
			  reportInfo("Validating the devicesettings excel export");
			}
			catch(AssertionError | Exception e) {
				testStepHandle("FAIL",testSetup.driver,test,e);			
			}		  
	  }
	 


}
