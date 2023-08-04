package safefleetLM.stepDefinitions.UI;

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
import safefleetLM.componentgroups.ResponseTags;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.GenerateBearerToken;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_5652_Prod_Verify_LM_dashboard_screen extends BaseTest {
	
	TestSetup testSetup;

	public VMM_5652_Prod_Verify_LM_dashboard_screen(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}


	@Then("I verify that the Customer, Tenanats, Devices, Licenses panels displayed with number of count")
	public void i_verify_that_the_customer_tenanats_devices_licenses_panels_displayed_with_number_of_count() {
		
		try {
			test = logInfo.get().createNode("I verify that the Customer, Tenanats, Devices, Licenses panels displayed with number of count");
			test.assignCategory("Production");
			boolean panelPresent = testSetup.pageObjectManager.getHomePage().verifyLMDashboardPanels();
			reportScreenshot(testSetup.driver);
			if(panelPresent==true) {
				reportPass("The Customer, Tenanats, Devices, Licenses panels displayed", "True" , "True");
			}
			else {
				reportFail("The Customer, Tenanats, Devices, Licenses panels displayed", "False", "False");
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}	
	}
	
	@Then("I verify that the Licenses & Device usage sections are displayed with Data & Pie chart respectively")
	public void i_verify_that_the_licenses_device_usage_sections_are_displayed_with_pie_chart_data_respectively() {
		
		try {
			test = logInfo.get().createNode("I verify that the Licenses & Device Usage sections are displayed with Data & Pie chart respectively");
			test.assignCategory("Production");
			boolean pieChartPresent = testSetup.pageObjectManager.getHomePage().verifyLMPieCharts();
			boolean pieChartDataPresent = testSetup.pageObjectManager.getHomePage().verifyLicensesandDeviceUsageDataValues();
			reportScreenshot(testSetup.driver);
			if(pieChartPresent==true && pieChartDataPresent==true) {
				reportPass("The Licenses & Device Usage sections are displayed with Data", "True" , "True");
			}
			else {
				reportFail("The Licenses & Device Usage sections are displayed with Data", "False", "False");
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}	
	}
	
	@Then("I verify that Tenant Manager section is displayed with the status icon")
	public void i_verify_that_tenant_manager_section_is_displayed_with_the_status_icon() {
		
		try {
			test = logInfo.get().createNode("I verify that Tenant Manager section is displayed with the status icon");
			test.assignCategory("Production");
			boolean tmServerStatusPresent = testSetup.pageObjectManager.getHomePage().verifyTenantManagerServerStatus();
			reportScreenshot(testSetup.driver);
			if(tmServerStatusPresent==true) {
				reportPass("The Tenant Manager section is displayed with the status icon", "True" , "True");
			}
			else {
				reportFail("The Tenant Manager section is displayed with the status icon", "False", "False");
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}	
	}
	
	@Then("I verify that Daily Sync Jobs - SyncTM section is displayed with the tool tip")
	public void i_verify_that_daily_sync_jobs_sync_tm_section_is_displayed_with_the_tool_tip() {
		
		try {
			test = logInfo.get().createNode("I verify that Daily Sync Jobs - SyncTM section is displayed with the tool tip");
			test.assignCategory("Production");
			//Map<String, String> testData = ExcelFileReader.getDataInMap("Login", env);
			String syncJobs = testSetup.pageObjectManager.getHomePage().getSyncJobsDetails();
			//testSetup.pageObjectManager.getHomePage().hoverOnToolTipIcon();
			reportScreenshot(testSetup.driver);
			String toolTipTxt = testSetup.pageObjectManager.getHomePage().getDailySyncJobToolTipDetail();
			
			if(syncJobs.contains("SyncTM (DAILY_JOB)") && toolTipTxt.contains("Daily Job runs once every 24 hours") && toolTipTxt.contains("Approximate run time:")) {
				reportPass("The Daily Sync Jobs - SyncTM section is displayed with the tool tip details", "Daily Job runs once every 24 hours" , toolTipTxt);
			}
			else {
				reportFail("The Daily Sync Jobs - SyncTM section is displayed with the tool tip details", "Daily Job runs once every 24 hours", toolTipTxt);
			}

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}	
	}
	
	}