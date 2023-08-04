package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;

public class VMM_3625_Nexus_license_type extends BaseTest{

	TestSetup testSetup;
    
	public VMM_3625_Nexus_license_type(TestSetup testSetup) throws IOException{
		this.testSetup=testSetup;
	}

    @Then("I verify that these License Types are available for the NEXUS software APP FEATURE_APP DEVICE--BW DEVICE--ICV {string}")
    public void i_verify_that_these_licenses_types_are_available_for_the_nexus_software_app_featureapp_devicebw_deviceicv_something(String tcid) throws Throwable 
    {
        try
        {
        	test = logInfo.get().createNode("I verify that these License Types are available for the NEXUS software APP FEATURE_APP DEVICE--BW DEVICE--ICV");
        	test.assignCategory("License Types");
        	Map<String, String> testData = ExcelFileReader.getDataInMap("LicenseTypePage", tcid);
        	boolean actual = testSetup.pageObjectManager.getLicenseTypePage().verifyLicenseTypeWithSFNexusSoftware(testData);
        	if(actual == true)
        	{
        		reportPass("I verify that these License Types are available for the NEXUS software APP FEATURE_APP DEVICE--BW DEVICE--ICV", "true", "true");
    			reportInfo("I verify that these License Types are available for the NEXUS software APP FEATURE_APP DEVICE--BW DEVICE--ICV");
				reportScreenshot(testSetup.driver);
        	}
        	else
        	{
        		reportFail("I couldnt verify that these License Types are available for the NEXUS software APP FEATURE_APP DEVICE--BW DEVICE--ICV", "false", "false");
				reportInfo("I couldnt verify that these License Types are available for the NEXUS software APP FEATURE_APP DEVICE--BW DEVICE--ICV");
				reportScreenshot(testSetup.driver);
        	}
        }
        catch(Exception e)
        {
        	testStepHandle("FAIL", testSetup.driver, test, e);
        }
    }

}
