package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;


public class VMM_5665_Prod_Verify_LM_Software_Version_and_Expiration_date_availablity_for_Evidence_Manager_License extends BaseTest {

	TestSetup testSetup;
	List<String> expListOfBaseApps;
	String env = getProperty("Environment");

	public VMM_5665_Prod_Verify_LM_Software_Version_and_Expiration_date_availablity_for_Evidence_Manager_License(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}


	@Then("I store the Base App list to compare and verify later")
	public void i_store_the_Base_App_list_to_compare_and_verify_later() {
		try {
      if (!env.equals("PROD")) {
        test = logInfo.get().createNode("I store the Base App list to compare and verify later");
        testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
        testSetup.pageObjectManager.getHomePage().navigateTobaseProductTab();
        expListOfBaseApps = testSetup.pageObjectManager.getBaseProductPage().getAllBaseApps();
        reportScreenshot(testSetup.driver);
        if (!expListOfBaseApps.isEmpty())
          reportInfo("The list of Base Apps are stored successfully");
        else
          reportFail("Base Apps", "", "Fetching the list of Base Apps failed");
      }

		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I select filter as Base App and verify that all the Base Apps are getting listed for Base App dropdown {string}")
	public void i_select_filter_as_Base_App_and_verify_that_all_the_Base_Apps_are_getting_listed_for_Base_App_dropdown(String tcid) {

		try {
			test = logInfo.get().createNode("I select filter as Base App and verify that all the Base Apps are getting listed for Base App dropdown");
			test.assignCategory("Production");
			Map<String, String> testData = ExcelFileReader.getDataInMap("ProductionData", tcid);

      if(env.equals("PROD")) {
         String baseAppList = testData.get("BaseAppList");
        expListOfBaseApps = Arrays.asList(baseAppList.split("\\s*,\\s*"));
      }

			testSetup.pageObjectManager.getLicensesPage().selectFilterField(testData);
			boolean result = testSetup.pageObjectManager.getLicensesPage().verifyAvailableBaseAppWithBaseAppsList(expListOfBaseApps);
			reportScreenshot(testSetup.driver);
			testSetup.pageObjectManager.getLicensesPage().hideFiltersBtn();
			if(result==true)
        reportPass("Base App verification", "", "All the Base App are listed in the Device Type dropdown in the Available Devices section");
			else
        reportFail("Base App verification", "", "All the Base App are not listed in the Device Type dropdown in the Available Devices section");

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}

	@Then("I expand license and click on Action button")
	public void i_expand_license_and_click_on_Action_button() {

		try {
			test = logInfo.get().createNode("I expand license and click on Action button");
			testSetup.pageObjectManager.getLicensesPage().licenseExpand();
			testSetup.pageObjectManager.getLicensesPage().clickOnActionBtn();

		}
		catch(AssertionError | Exception e) {
			testStepHandle("FAIL",testSetup.driver,test,e);
		}
	}


	}
