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
import safefleetLM.testcomponents.GenerateBearerToken;
import safefleetLM.testcomponents.TestSetup;

public class CommonSteps extends BaseTest {

	TestSetup testSetup;

	public CommonSteps(TestSetup testSetup) throws IOException {
		this.testSetup = testSetup;
	}

	@Given("I login to LM application with valid credentials")
	public void i_login_to_lm_application_with_valid_credentials() throws Exception {
		try {
			test = logInfo.get().createNode("I login to LM application with valid credentials");

			String env = getProperty("Environment");
			Map<String, String> testData = ExcelFileReader.getDataInMap("Login", env);
			testSetup.pageObjectManager.getLandingPage().launchLM(testData.get("URL"));
			if(env.equals("PROD")){
			testSetup.pageObjectManager.getLandingPage().loginLM(testData.get("USERNAME"), testData.get("PASSWORD"));
			}
			else{
			testSetup.pageObjectManager.getLandingPage().loginLMNew(testData.get("USERNAME"), testData.get("PASSWORD"));
			}
			//zoomOut(3);
			Thread.sleep(2000);
			if (!testSetup.pageObjectManager.getHomePage().currentUserText().isEmpty()) {
				reportPass("User logged in succesfully", "Current User",
						testSetup.pageObjectManager.getHomePage().currentUserText());
				reportScreenshot(testSetup.driver);
			}
			else
				reportFail("User logged in succesfully", "Current User",
						testSetup.pageObjectManager.getHomePage().currentUserText());
		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I navigate to Base Product Tab")
	public void i_navigate_to_base_product_tab() throws InterruptedException, IOException {
		try {
			test = logInfo.get().createNode("I navigate to Base Product tab");
			testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
			testSetup.pageObjectManager.getHomePage().navigateTobaseProductTab();
			reportInfo("User navigated to Base Product Tab successfully");

		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I navigate to license Type Tab")
	public void i_navigate_to_license_type_tab() throws InterruptedException, IOException {
		try {
			test = logInfo.get().createNode("I navigate to license Type Tab");
			testSetup.pageObjectManager.getHomePage().navigateToLicenseTypesTab();
			reportInfo("User navigated to license Type Tab successfully");

		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I navigate to Device Type Tab")
	public void i_navigate_to_device_type_tab() throws InterruptedException, IOException {
		try {
			test = logInfo.get().createNode("I navigate to Device Type Tab");
			// testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
			testSetup.pageObjectManager.getHomePage().navigateToDeviceTypesTab();
			reportInfo("User navigated to Device Type Tab successfully");

		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I navigate to Licences Tab")
	public void i_navigate_to_licence_tab() {
		try {
			test = logInfo.get().createNode("I navigate to licence Tab");
			testSetup.pageObjectManager.getHomePage().navigateToLicensesTab();
			reportScreenshot(testSetup.driver);
			reportInfo("Navigate to the licence Tab is successful");
		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I navigate to Tenant tab")
	public void i_navigate_to_tenant_tab() throws InterruptedException, IOException {
		try {
			test = logInfo.get().createNode("I navigate to Tenant Tab");
			testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
			testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();
			reportInfo("User navigated to Tenant Tab successfully");

		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@When("I close the browser")
	public void i_close_the_browser() throws IOException, InterruptedException {
		try {
			test = logInfo.get().createNode("I close the browser");
			reportInfo("Browser closed successfully");
			testSetup.baseTest.intializeDriver().close();
		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I navigate to ecosystem settings tab")
	public void i_navigate_to_ecosystem_settings_tab() throws InterruptedException, IOException {
		try {
			test = logInfo.get().createNode("I navigate to ecosystem settings Tab");
			testSetup.pageObjectManager.getHomePage().navigateToEcoSystemTab();
			reportInfo("User navigated to licenses Tabecosystem settings successfully");

		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I navigate to the Operation Tab")
	public void i_navigate_to_the_operation_tab() {
		try {
			test = logInfo.get().createNode("I navigate to Operation tab");
			testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
			reportInfo("User navigated to Operations Page successfully");
		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I navigate to devices tab")
	public void i_navigate_to_devices_tab() throws InterruptedException {
		try {
			test = logInfo.get().createNode("I navigate to devices tab");
			testSetup.pageObjectManager.getDevicePage().navigateToDevices();
			reportInfo("navigate to devices tab successfully");
		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

  @Then("I navigate to lm dashboard Tab")
  public void i_navigate_to_lm_dashboard_tab() throws InterruptedException, IOException {
    try {
      test = logInfo.get().createNode("I navigate to LM Dashboard Tab");
      testSetup.pageObjectManager.getHomePage().navigateToLMDashboardTab();
      reportInfo("User navigated to LM Dashboard Tab successfully");

    } catch (Exception e) {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }

  }

	@Then("I navigate to the System Admins Tab")
	public void i_navigate_to_the_system_admin_tab_now() {
		try {
			test = logInfo.get().createNode("I navigate to the System Admin Tab");
			testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
			reportInfo("System admin type navigated successfully");
			reportScreenshot(testSetup.driver);
		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I navigate to License Types Tab")
	public void i_navigate_to_license_types_tab() throws InterruptedException, IOException {
		try {
			test = logInfo.get().createNode("I navigate to license Type Tab");
			testSetup.pageObjectManager.getHomePage().navigateToLicenseTypesTab();
			reportInfo("User navigated to license Type Tab successfully");

		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I navigate to Tenants Tab")
	public void i_navigate_to_tenant_tab_only() throws InterruptedException, IOException {
		try {
			test = logInfo.get().createNode("I navigate to Tenant Tab");
			testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();
			reportInfo("User navigated to Tenant Tab successfully");
			Thread.sleep(5000);
		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I navigate to Device tab")
	public void i_navigate_to_device_tab() throws InterruptedException {
		try {
			test = logInfo.get().createNode("I navigate to devices tab");
			testSetup.pageObjectManager.getDevicePage().navigateToDevices();
			reportInfo("navigate to devices tab successfully");
		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I navigate to Users tab")
	public void i_navigate_to_users_tab()
	{
		try
		{
			test = logInfo.get().createNode("I navigate to Users tab");
			testSetup.pageObjectManager.getHomePage().navigateToUserTab();
			reportInfo("navigate to Users Tab successfully");
		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	//Savitha
	@Then("I logout of LM application")
	public void i_logout_of_lm_application() {
		try
		{
			test = logInfo.get().createNode("I logout of LM application");
			boolean flag = testSetup.pageObjectManager.getLandingPage().logoutUser();
			if(flag==true)
				reportPass("User logged out succesfully", "","");
			else
				reportPass("User failed to logged out", "","");
			reportScreenshot(testSetup.driver);

		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@When("I navigate to Device Settings tab")
	public void i_navigate_to_device_settings_tab() throws InterruptedException, IOException {
		try {
			test = logInfo.get().createNode("I navigate to Device ettings Tab");
			testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
			testSetup.pageObjectManager.getHomePage().navigateToDeviceSettingsTab();
			reportInfo("User navigated to Device Settings tab successfully");

		} catch (Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}

	}

	@Then("I click on system admin to navigate Base App Tab")
	public void i_click_on_system_admin_to_navigate_base_app_tab() {
		try {
			test = logInfo.get().createNode("I click on system admin to navigate Base App Tab");
			testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
			testSetup.pageObjectManager.getHomePage().navigateTobaseProductTab();
			reportInfo("Navigate to Base App Tab successfully");
			reportScreenshot(testSetup.driver);
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	@Then("I click on system admin to navigate Device Type Tab")
	public void i_click_on_system_admin_to_navigate_device_type_tab() {
		try {
			test = logInfo.get().createNode("I click on system admin to navigate Device Type Tab");
			testSetup.pageObjectManager.getHomePage().navigateToSystemAdminTab();
			testSetup.pageObjectManager.getHomePage().navigateToDeviceTypeTab();
			reportInfo("Navigate to Device Type Tab successfully");
			reportScreenshot(testSetup.driver);
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

  @Then("I click on Operations to navigate Licenses Tab")
  public void i_click_on_operations_to_navigate_licenses_tab() {
    try {
      test = logInfo.get().createNode("I click on system admin to navigate Device Type Tab");
      testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
      testSetup.pageObjectManager.getHomePage().navigateToLicenseTab();
      reportInfo("Navigate to Licenses Tab successfully");
      reportScreenshot(testSetup.driver);
    }
    catch (Exception e)
    {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

  @Then("I click on Operations to navigate Devices Tab")
  public void i_click_on_operations_to_navigate_devices_tab() {
    try {
      test = logInfo.get().createNode("I click on Operations to navigate Devices Tab");
      testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
      testSetup.pageObjectManager.getHomePage().navigateToDevicesTab();
      reportInfo("Navigate to Devices Tab successfully");
      reportScreenshot(testSetup.driver);
    }
    catch (Exception e)
    {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }

  @Then("I click on operations to Navigate Ecosystem Settings")
  public void i_click_on_operations_to_navigate_ecosystem_settings()
  {
    try {
      test = logInfo.get().createNode("I click on operations to Navigate Ecosystem Settings");
      testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
      testSetup.pageObjectManager.getHomePage().navigateToEcoSystemTab();
      reportInfo("Navigate Ecosystem Settings Successfully");
    }
    catch (Exception e)
    {
      testStepHandle("FAIL", testSetup.driver, test, e);
      reportFail("","Navigate Ecosystem Settings is Failed" ,"" );
    }
  }

}
