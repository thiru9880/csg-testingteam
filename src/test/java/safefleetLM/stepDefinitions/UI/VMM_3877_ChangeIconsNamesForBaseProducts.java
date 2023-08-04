package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;

public class VMM_3877_ChangeIconsNamesForBaseProducts extends BaseTest {
	
	private static final String String = null;
	TestSetup testSetup;

	public VMM_3877_ChangeIconsNamesForBaseProducts(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	
	@Then("I verify name and icon for SF Base Product with expected test data {string}")
	public void i_verify_name_and_icon_for_sf_base_product_with_expected_test_data(String tcid) {
	    
		try {
			test = logInfo.get().createNode("I verify name and icon for SF Base Product with expected test data");
			
			test.assignCategory("System Admin");
			
			Map<String, String> testData = ExcelFileReader.getDataInMap("BaseProductPage", tcid);
			
          String text5=testSetup.pageObjectManager.getBaseProductPage().verifySFClearlaneName(testData);
            
			reportPass("Base Product Text", testData.get("Name9"),text5 );
			
		      String text6=testSetup.pageObjectManager.getBaseProductPage().verifySFDESCloudCourierName(testData);
	            
				reportPass("Base Product Text", testData.get("Name10"),text6);
			
            String text=testSetup.pageObjectManager.getBaseProductPage().verifySFCognitionName(testData);
            
			reportPass("Base Product Text", testData.get("Name"),text );
			
			String eco=testSetup.pageObjectManager.getBaseProductPage().verifySFCommanderName(testData);
			
			reportPass("Base Product Text", testData.get("Name2"),eco);
				
		    String cloud=testSetup.pageObjectManager.getBaseProductPage().verifySFCompassName(testData);
		    
			reportPass("Base Product Text", testData.get("Name3"),cloud );
			
			String local=testSetup.pageObjectManager.getBaseProductPage().verifySFDSPlayerName(testData);
			
			reportPass("Base Product Local", testData.get("Name4"),local );
			
			String text4=testSetup.pageObjectManager.getBaseProductPage().verifySFLiveName(testData);
	            
			reportPass("Base Product Text", testData.get("Name5"),text4 );
			
			String text1=testSetup.pageObjectManager.getBaseProductPage().verifySFNexusName(testData);
	            
			reportPass("Base Product Text", testData.get("Name6"),text1 );
				
			String text2=testSetup.pageObjectManager.getBaseProductPage().verifySFPathName(testData);
		            
			reportPass("Base Product Text", testData.get("Name7"),text2 );
			
			String text3=testSetup.pageObjectManager.getBaseProductPage().verifySFStreamName(testData);
            
			reportPass("Base Product Text", testData.get("Name8"),text3 );
			
			reportScreenshot(testSetup.driver);
		}
		catch(AssertionError | Exception e) {
			
			testStepHandle("FAIL",testSetup.driver,test,e);			
		}
	}

}
