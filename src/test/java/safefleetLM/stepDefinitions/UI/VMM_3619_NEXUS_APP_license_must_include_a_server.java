package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;

public class VMM_3619_NEXUS_APP_license_must_include_a_server extends BaseTest{

TestSetup testSetup;
	
	public VMM_3619_NEXUS_APP_license_must_include_a_server(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}

    @Then("I make sure that APP License Type of NEXUS software has Requires Server option checked")
    public void i_make_sure_that_app_license_type_of_nexus_software_has_requires_server_option_checked_something() throws Throwable 
    {
        try
        {
        	test = logInfo.get().createNode("I make sure that APP License Type of NEXUS software has Requires Server option checked");
        	test.assignCategory("License Types");
        	boolean actual = testSetup.pageObjectManager.getLicenseTypePage().verifyRequiresServerIsChecked();
        	if(actual==true)
        	{
        		boolean expected = true;
        		Assert.assertEquals(actual, expected);
        		reportPass("APP license type of NEXUS software has require option checked", "true", "true");
        		reportInfo("I made sure that APP License Type of NEXUS software has require option checked successfully");
        		reportScreenshot(testSetup.driver);
        	}
        	else
        	{
        		reportFail("APP License Type of NEXUS software has no require option checked", "false", "false");
				reportInfo("APP License Type of NEXUS software has require option not checked successfully");
        		reportScreenshot(testSetup.driver);
        	}
        }
        catch(Exception e)
        {
        	testStepHandle("FAIL", testSetup.driver, test, e);
        }
    }
	
}
