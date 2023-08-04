package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.List;
import java.util.Map;



import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;

public class VMM_3283_Move_Server_into_Software extends BaseTest {
		
	TestSetup testSetup;
	
    
	public VMM_3283_Move_Server_into_Software(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	
	List<String> BaseProductServer;
	
	List<String> LicensesServer;
	

@Then("I Select one Base Product and Click Edit to verify servers Selected {string}")
public void i_select_one_base_product_and_click_edit_to_verify_servers_selected(String tcid) throws Exception 
{
	try { 
	test = logInfo.get().createNode("I Select one Base Product and Click Edit to verify servers Selected");
	test.assignCategory("Servers");
	Map<String, String> testData = ExcelFileReader.getDataInMap("BaseProductPage", tcid);
	String text=testSetup.pageObjectManager.getBaseProductPage().verifyBaseProductclickedit(testData);
	reportPass("Base Product Name", testData.get("Name"), text);
	BaseProductServer=testSetup.pageObjectManager.getBaseProductPage().baseProductservers(testData);
	String ServerofbaseProduct=BaseProductServer.toString();
	reportInfo("The servers selected in base product are= "+ServerofbaseProduct);
	reportScreenshot(testSetup.driver);
	reportInfo("verify servers Selected exist Successful");
	}
	catch (Exception e)
	{ 
		testStepHandle("FAIL", testSetup.driver, test, e);
	}	
}
@Then("I fill the necessary fields click on Server text Box and Verify servers are available in the servers dropdown {string}")
public void i_fill_the_necessary_fields_click_on_server_text_box_and_verify_servers_are_available_in_the_servers_dropdown(String tcid) throws Exception 
{
	try {
	test = logInfo.get().createNode("I fill the necessary fields click on Server text Box and Verify servers are available in the servers dropdown");
	Map<String, String> testData = ExcelFileReader.getDataInMap("LicensePage", tcid);
	LicensesServer=testSetup.pageObjectManager.getLicensesPage().licensesServers(testData);
	String ServerofLicenses=LicensesServer.toString();
	reportInfo("The servers selected in base product are= "+ServerofLicenses);
	reportScreenshot(testSetup.driver); 
	
	boolean result=testSetup.pageObjectManager.getLicensesPage().compareServer(BaseProductServer,LicensesServer);
	if(result==true)
	{
		reportPass("Base Server Data and Licenses Server Data Matches", "Servers Selected in Software", "Servers in Licenses Server TextBox");
		reportInfo("Verifying servers are available in the servers dropdown Successful");
	}
	else
	{
		reportFail("Base Server Data and Licenses Server Data Not Matches", "Servers Selected in Software", "Servers in Licenses Server TextBox");
		reportInfo("Verifying servers are available in the servers dropdown Successful");
	}
	}
	catch (Exception e)
	{
		testStepHandle("FAIL", testSetup.driver, test, e);
	}
	
}

	
}
