package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_4347_Verify_the_license_file_generated_for_new_version_of_Evidence_manager_with_Idp_and_Market_segment_values extends BaseTest {

	TestSetup testSetup;

	public VMM_4347_Verify_the_license_file_generated_for_new_version_of_Evidence_manager_with_Idp_and_Market_segment_values(TestSetup testSetup) throws IOException
	{
		this.testSetup=testSetup;
	}

    @Then("I create an onsite Tenant {string}")
    public void i_create_an_onsite_tenant_something(String tcid) throws Throwable
    {
    	try
		{
    		String tenantID=randomStringGenerator();
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"TenantPage","TenantID",tenantID,"VMM4347_1");
    		UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM4347_1");
      UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","TenantID",tenantID,"VMM4347_2");

    		test = logInfo.get().createNode("I create an onsite Tenant");
    		test.assignCategory("Licenses");
    		testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
			testSetup.pageObjectManager.getHomePage().navigateToTenantsTab();
    		Map<String, String> testData = ExcelFileReader.getDataInMap("TenantPage", tcid);
			testSetup.pageObjectManager.getTenantsPage().createANewTenant(testData);
			testSetup.pageObjectManager.getTenantsPage().clickOnSaveButtonn();
			reportInfo("Created Tenant onsite successfully");
			reportScreenshot(testSetup.driver);
		}
		catch(Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
    }

    @Then("I create app License for evidence manager with valid identity provider {string}")
    @Then("I create Chain Of Custody Add-on module License for evidence manager {string}")
    public void i_create_app_and_addon_module_license_for_evidence_manager_with_valid_identity_provider(String tcid) throws Throwable
    {
    	try
    	{
    		test = logInfo.get().createNode("I create app or Add-on module License for evidence manager with valid identity provider");

    		Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
    		String futureDate = testSetup.pageObjectManager.getLicensesPage().getExpirationDate(30);
            UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","ExpiryDate",futureDate,"VMM4347_1");
            UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"LicensePage","ExpiryDate",futureDate,"VMM4347_2");

			testSetup.pageObjectManager.getLicensesPage().createLicensesforDesktopwithoutAddingAnother(testData);
			testSetup.pageObjectManager.getLicensesPage().verifyCeatedLicense(testData);
			reportInfo("I create app or Add-on module License for evidence manager with valid identity provider successfully");
			reportScreenshot(testSetup.driver);
    	}
    	catch(Exception e)
    	{
    		testStepHandle("FAIL", testSetup.driver, test, e);
    	}
    }

  @Then("I publish Chain Of Custody License {string}")
  public void i_publish_addon_module_license(String tcid) throws Throwable
  {
    try
    {
      test = logInfo.get().createNode("I publish Chain Of Custody License");
      Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
      testSetup.pageObjectManager.getLicensesPage().clickonClear();
      testSetup.pageObjectManager.getLicensesPage().searchLicenseWithTenantAndMultiCondition(testData);
      testSetup.pageObjectManager.getLicensesPage().publishLicense();
      testSetup.pageObjectManager.driver.navigate().refresh();
      testSetup.pageObjectManager.getLicensesPage().verifyFilterLicense(testData);
      reportInfo("I publish and download the License successfully");
      reportScreenshot(testSetup.driver);
    }
    catch(Exception e)
    {
      testStepHandle("FAIL", testSetup.driver, test, e);
    }
  }


    @Then("I publish App license and download the License file")
    public void i_publish_app_license_and_download_the_license_file() throws Throwable
    {
    	try
    	{
    		test = logInfo.get().createNode("I publish and download the License");
    		testSetup.pageObjectManager.getLicensesPage().goToLicensePublishAfterFilter();
    		reportInfo("I publish and download the License successfully");
			reportScreenshot(testSetup.driver);
    	}
    	catch(Exception e)
    	{
    		testStepHandle("FAIL", testSetup.driver, test, e);
    	}
    }

}
