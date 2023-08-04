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

public class VMM_3848_Null_tenant_id_values_are_not_returning_in_the_notequal_filter_of_TenantID_in_Software_Settings_page extends BaseTest {
		
	TestSetup testSetup;
    
	public VMM_3848_Null_tenant_id_values_are_not_returning_in_the_notequal_filter_of_TenantID_in_Software_Settings_page(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}
		
	@Then("I Navigate to Ecosystem Settings")
	public void i_click_on_operations_to_navigate_ecosystem_settings() {
		try {
		test = logInfo.get().createNode("I Navigate to Ecosystem Settings");
		testSetup.pageObjectManager.getEcosystemSettingsPage().clickOnEcosystemSettings();

		reportInfo("I navigate to ecosystem page successfully");    
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e); 
		}
		
	}
	@Then("I create new Ecosystem Settings with test data {string}")
	public void i_create_new_ecosystem_settings_with_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I create new Ecosystem Settings with test data");
		//testSetup.pageObjectManager.getEcosystemSettingsPage().clickOnEcosystemNewbtn();
		Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting", tcid);
    	testSetup.pageObjectManager.getEcosystemSettingsPage().createEcosystemSettings(testData);
    	reportInfo(testData.toString());
    	reportScreenshot(testSetup.driver);
		reportInfo("I create new ecosystem settings successfully");  
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e); 
		}
		
	}
	@Then("I click on SHOW FILTERS")
	public void i_click_on_show_filters() {
		try {
			test = logInfo.get().createNode("I click on SHOW FILTERS");
			testSetup.pageObjectManager.getEcosystemSettingsPage().clickOnEcoSysShowFilter();
			reportInfo("I click on show filter successfully");  
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e); 
		}

		
	}
	@Then("I Filter on TenantID with not equal to values {string}")
	public void i_filter_on_tenant_id_with_not_equal_to_values(String tcid) {
		try {
			test = logInfo.get().createNode("I Filter on TenantID with not equal to values"); 
			test.assignCategory("Ecosystem Settings");
			
			Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting", tcid);
	    	testSetup.pageObjectManager.getEcosystemSettingsPage().clickShowOnFilterNotequal(testData);
	    	reportInfo(testData.toString());
	    	//testSetup.pageObjectManager.getEcosystemSettingsPage().ClickOnFilterButton();
	    	reportScreenshot(testSetup.driver);
	    	
			reportInfo("I filter with Tenant ID successfully");  
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e); 
		}
		
	
		 
	}
	@Then("I verify that the record count correct")
	public void i_verify_that_the_record_count_correct() {
		try {
			test = logInfo.get().createNode("I verify that the record count correct"); 
			
			String text1=testSetup.pageObjectManager.getEcosystemSettingsPage().EcosettingRecordCount1();
			testSetup.pageObjectManager.getEcosystemSettingsPage().ClickOnFilterButton();
			reportScreenshot(testSetup.driver);
			
			String text2=testSetup.pageObjectManager.getEcosystemSettingsPage().EcosettingRecordCount2();
			testSetup.pageObjectManager.getEcosystemSettingsPage().ClickOnClearButton(); 
			reportScreenshot(testSetup.driver);
			
			if(text1!=text2)
			{
				reportPass("Record Count", text1+" "+text2 ,  text1+" "+text2 );
				//reportScreenshot(testSetup.driver);
				reportInfo("I verify the record count successfully"); 
			}
			else
			{
				reportFail("Record Count", text1+" "+text2 ,  text1+" "+text2);
				//reportScreenshot(testSetup.driver);
				reportInfo("I verify the record count successfully");
			}		 		 
		}
		catch (Exception e)
			{
			testStepHandle("FAIL", testSetup.driver, test, e); 
			}
	
		} 
		@Then("I delete the Ecosystem {string}")
		public void I_delete_the_Ecosystem(String tcid) throws Exception {
			try {
				test = logInfo.get().createNode("I delete the Ecosystem"); 
		Map<String, String> testData = ExcelFileReader.getDataInMap("EcosytemSetting", tcid);
	    testSetup.pageObjectManager.getEcosystemSettingsPage().SearchEcosystem(testData);
	    
	    testSetup.pageObjectManager.getEcosystemSettingsPage().ClickOnFilterButton();
	    testSetup.pageObjectManager.getEcosystemSettingsPage().clickOnDeleteButton();
	    testSetup.pageObjectManager.getEcosystemSettingsPage().clickOnDeleteEcosytemSymbol();
	    reportScreenshot(testSetup.driver);
	    reportInfo("I deleted ecosystem successfully");   
			
		
		}
		catch (Exception e)
			{
			testStepHandle("FAIL", testSetup.driver, test, e); 
			}	 
			
			    
			
		
	}
		/*
		@Then("I click on navigate Tenants tab")
		public void i_click_on_navigate_tenants_tab() throws IOException {
			test = logInfo.get().createNode("I click on navigate Tenants tab");
			//testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
			testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();
			reportInfo("Navigate to Tenants tab successfully");
		}
		*/
}









