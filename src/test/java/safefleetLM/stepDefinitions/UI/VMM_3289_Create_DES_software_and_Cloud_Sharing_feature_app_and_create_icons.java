package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;

public class VMM_3289_Create_DES_software_and_Cloud_Sharing_feature_app_and_create_icons extends BaseTest {
		
	TestSetup testSetup;
	
    
	public VMM_3289_Create_DES_software_and_Cloud_Sharing_feature_app_and_create_icons(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	} 
	
	@Then("I Verify that DES Cloud Courier software exists {string}")
	public void i_verify_that_des_cloud_courier_software_exists(String tcid) throws Exception 
	{ 
		test = logInfo.get().createNode("I verify the base product SF Cloud Courier For DES");
		test.assignCategory("License Types");
		Map<String, String> testData = ExcelFileReader.getDataInMap("BaseProductPage", tcid);
		 String text=testSetup.pageObjectManager.getBaseProductPage().verifyBaseProductDESCloudCourier(testData);
		 reportPass("Base Product Name", testData.get("Name"), text);
		 reportScreenshot(testSetup.driver);
		 reportInfo("verify the base product SF Cloud Courier For DES exist Successful");
	}
	
	@Then("I Verify that there are two License Types exist for DES Cloud Courier software and both have DES icons {string}")
	public void i_verify_that_there_are_two_license_types_exist_for_des_cloud_courier_software_and_both_have_des_icons(String tcid) throws Exception 
	{
		test = logInfo.get().createNode("I Verify that there are two License Types exist for DES Cloud Courier software and both have DES icons");
		Map<String, String> testData = ExcelFileReader.getDataInMap("LicenseTypePage", tcid);
		String text1=testSetup.pageObjectManager.getLicenseTypePage().verifyLicenceTypeBaseProductDESCloudCourier(testData);
	    //reportPass("License Type", testData.get("BaseProduct"), text1);
		String text2=testSetup.pageObjectManager.getLicenseTypePage().verifyLicenceTypeBaseProductDESCloudCourier2(testData);
	    reportScreenshot(testSetup.driver);
	    reportInfo("Verify that there are two License Type exist " +text1+" And "+text2+" for DES Cloud Courier software exist and both have DES icons Successful");
	}
 
}
