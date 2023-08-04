package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;
import safefleetLM.testcomponents.UpdateXlFile;

public class VMM_3746_IssuesWithSoftwareCreation extends BaseTest{
	
	TestSetup testSetup;

	public VMM_3746_IssuesWithSoftwareCreation(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	
	
	@Then("I create Base App {string}")
	public void i_create_base_app(String tcid) {
		try {
			String BaseProduct=randomStringGenerator();			 
			  UpdateXlFile.writeToXl(System.getProperty("user.dir")+TestDataPath,"BaseProductPage","Name",BaseProduct,"VMM-3746_1");
			test = logInfo.get().createNode("I create Base App ");
			Map<String, String> testData = ExcelFileReader.getDataInMap("BaseProductPage", tcid);
			testSetup.pageObjectManager.getBaseProductPage().createBaseProductWithMinimumData(testData);
			reportScreenshot(testSetup.driver);
			reportInfo("Verified save button is enabled after entering mandatory values while creating new base product");
		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	
	
	@Then("I verify multiple feild while editing Base Product with test data {string}")
	public void i_verify_multiple_feild_while_editing_base_product_with_test_data(String tcid) {
		try {
			test = logInfo.get().createNode("I verify multiple feild while editing Base Product with test data");
			Map<String, String> testData = ExcelFileReader.getDataInMap("BaseProductPage", tcid);
			testSetup.pageObjectManager.getBaseProductPage().verifyBaseProductclickedit(testData);
			reportScreenshot(testSetup.driver);
			reportInfo("Verified icon feild is not present while creating new base product");

		}
		catch (Exception e)
		{
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}
	
	@Then("I delete the Base App {string}")
	public void I_delete_the_base_app(String tcid) {
		try {
			test = logInfo.get().createNode("I delete the Base App");
			Map<String, String> testData = ExcelFileReader.getDataInMap("BaseProductPage", tcid);
			reportInfo(testData.toString());
			String alert = testSetup.pageObjectManager.getBaseProductPage().deleteBaseApp(testData);
			if(alert.equalsIgnoreCase("A Base App is deleted with identifier "+testData.get("Name")))
			{
				reportPass("Alert messaeg", "A Base App is deleted with identifier "+testData.get("Name"), alert);
			    reportInfo("Base App deleted Successfully");
			}
			else
				reportFail("Alert messaeg", "", alert);
			
			reportScreenshot(testSetup.driver);
			
		}
		catch(Exception e) {
			testStepHandle("FAIL", testSetup.driver, test, e);
		}
	}

	}




