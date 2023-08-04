package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;

public class VMM_3242_Application_ID_generation_for_base_product extends BaseTest{

	TestSetup testSetup;
	     
	public VMM_3242_Application_ID_generation_for_base_product(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}

    @And("I verify Base Product in view has application id")
    public void i_verify_base_product_in_view_has_application_id() throws Exception 
    {
    	try
    	{
    		test = logInfo.get().createNode("I verify Base Product in view has application id");
    		test.assignCategory("System Admin");
    		testSetup.pageObjectManager.getHomePage().navigateTobaseProductTab();
    		testSetup.pageObjectManager.getBaseProductPage().clickOnVieww();
    		boolean actual = testSetup.pageObjectManager.getBaseProductPage().verifyApplicationID();
    		if(actual == true)
    		{
    			reportPass("Application id verified", "true", "true");
    			reportInfo("Application id verified successfully");
				reportScreenshot(testSetup.driver);
    		}
    		else
    		{
    			reportFail("Application id not verified", "false", "false");
				reportInfo("Application id not verified successfully");
				reportScreenshot(testSetup.driver);
    		}
    	}
    	catch(Exception e)
    	{
    		testStepHandle("FAIL", testSetup.driver, test, e);
    	}
    }

    @And("I verify converting Base Product name to uppercase")
    public void i_verify_converting_base_product_name_to_uppercase() throws Exception 
    {
    	try
    	{
    		test = logInfo.get().createNode("I verify converting Base Product name to uppercase");
    		boolean actual = testSetup.pageObjectManager.getBaseProductPage().verifyApplicationIDCaps();
    		if(actual == true)
    		{
    			reportPass("Converting Base Product name to uppercase", "true", "true");
    			reportInfo("Converting Base Product name to uppercase successfully");
				reportScreenshot(testSetup.driver);
    		}
    		else
    		{
    			reportFail("Could not convert Base Product name to uppercase", "false", "false");
				reportInfo("Could not convert Base Product name to uppercase successfully");
				reportScreenshot(testSetup.driver);
    		}
    	}
    	catch(Exception e)
    	{
    		testStepHandle("FAIL", testSetup.driver, test, e);
    	}
    }

    @And("I verify spaces in Base Product name with -")
    public void i_verify_spaces_in_base_product_name_with_() throws IOException
    {
    	try
    	{
    		test = logInfo.get().createNode("I verify spaces in Base Product name with -");
    		boolean actual = testSetup.pageObjectManager.getBaseProductPage().verifyApplicationIDWithHyphen();
    		if(actual == true)
    		{
    			reportPass("Application id with hyphen", "true", "true");
    			reportInfo("Application id with hyphen verified successfully");
				reportScreenshot(testSetup.driver);
    		}
    		else
    		{
    			reportFail("Application id with no hyphen", "false", "false");
				reportInfo("Application id with hyphen not verified successfully");
				reportScreenshot(testSetup.driver);
    		}
    	}
    	catch(Exception e)
    	{
    		testStepHandle("FAIL", testSetup.driver, test, e);
    	}
    }

    @And("I verify Base Product name is upto 50 characters only")
    public void i_verify_base_product_name_is_upto_50_characters_only() throws IOException
    {
    	try
    	{
    		test = logInfo.get().createNode("I verify Base Product name is upto 50 characters only");
    		Map<String, String> testData = ExcelFileReader.getDataInMap("BaseProductPage", "VMM3242_1");
    		testSetup.pageObjectManager.getHomePage().navigateTobaseProductTab();
    		testSetup.pageObjectManager.getBaseProductPage().createBaseProduct(testData);
    		testSetup.pageObjectManager.getBaseProductPage().viewBaseApp(testData);
    		boolean actual = testSetup.pageObjectManager.getBaseProductPage().verifyBaseAppNameWithLength();
    		if(actual == true)
    		{
    			reportPass("Base App name with length 50", "true", "true");
    			reportInfo("Base App name with length 50 verified successfully");
				reportScreenshot(testSetup.driver);
    		}
    		else
    		{
    			reportFail("Base App name with length not 50", "false", "false");
				reportInfo("Base App name with length 50 not verified successfully");
    			reportScreenshot(testSetup.driver);
    		}
    	}
    	catch(Exception e)
    	{
    		testStepHandle("FAIL", testSetup.driver, test, e);
    	}
    }
	
}
