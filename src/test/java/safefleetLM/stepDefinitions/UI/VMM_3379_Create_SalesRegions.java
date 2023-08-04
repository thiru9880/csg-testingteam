package safefleetLM.stepDefinitions.UI;

import java.io.IOException;
import java.util.Map;

import io.cucumber.java.en.Then;
import safefleetLM.testcomponents.BaseTest;
import safefleetLM.testcomponents.ExcelFileReader;
import safefleetLM.testcomponents.TestSetup;

public class VMM_3379_Create_SalesRegions extends BaseTest {
		
	TestSetup testSetup;
	
    
	public VMM_3379_Create_SalesRegions(TestSetup testSetup) throws IOException {
		this.testSetup=testSetup;
	}
	
	@Then("I click on Operations Tab to navigate Sales Regions Tab")
	public void i_click_on_operations_tab_to_navigate_sales_regions() throws Exception 
	{
		test = logInfo.get().createNode("i click on operations tab to navigate sales regions");
		testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
		testSetup.pageObjectManager.getHomePage().navigateToSalesRegions();
		Thread.sleep(3000);
		reportScreenshot(testSetup.driver);
		reportInfo("Click on Operations Tab to Navigate Sales Regions Successful");
	}  
	
	@Then("I click the NEW button")
	public void i_click_the_new_button()  
	{
		test = logInfo.get().createNode("I click the NEW button");
		reportInfo("Click on NEW button Successful");
	}
	
	@Then("I fill all required fields with test data and Click on Save {string}")
	public void i_fill_all_required_fields_with_test_data_vmm3379_and_click_on_save(String tcid) throws Exception 
	{
		try {
		test = logInfo.get().createNode("I fill all required fields with test data and Click on Save ");
		test.assignCategory("Tenants");
		reportInfo("Filling all required fields with test data and Click on Save");
		Map<String, String> testData = ExcelFileReader.getDataInMap("SalesRegionCreate", tcid);
		reportInfo(testData.toString());
		testSetup.pageObjectManager.getSalesRegionPage().createnewsalesregion(testData);
		reportScreenshot(testSetup.driver);
		testSetup.pageObjectManager.getSalesRegionPage().salesregionSave1();
		boolean status=testSetup.pageObjectManager.getSalesRegionPage().savedPopUp();
		
		if(status=true) {
			reportPass("Save Alert PopUp Displayed", "true", "true");
			reportScreenshot(testSetup.driver);
		}
		else
		{
			reportFail("Save Alert Popup not Displayed", "false", "false");
		}
		
		reportInfo("New Sales Region Created Successfully");
		}
		catch(Exception e){
			testStepHandle("FAIL",testSetup.driver,test,e);	
		}
	}
	
	@Then("I verify a new entry has been added to the Sales Regions Table {string}")
	public void i_verify_a_new_entry_has_been_added_to_the_sales_regions_table(String tcid) throws Exception 
	{
		try {
		test = logInfo.get().createNode("I verify a new entry has been added to the Sales Regions Table");
		Map<String, String> testData = ExcelFileReader.getDataInMap("SalesRegionCreate", tcid);
		String text=testSetup.pageObjectManager.getSalesRegionPage().verifySalesRegionsName(testData);
		if(text.equals(testData.get("Name"))) 
		{
		reportPass("Sales Regions ", testData.get("Name"), text);
		reportInfo("Verifying a new entry has been added to the Sales Regions Table");
		reportScreenshot(testSetup.driver);
		reportInfo("Verifying a new entry has been added to the Sales Regions Table Successful");
		}
		else
		{
			reportFail("Sales Regions ", testData.get("Name"), text);
			reportScreenshot(testSetup.driver);
			reportInfo("Verifying a new entry has been added to the Sales Regions Table Not Successful");
		}
		}
		catch(Exception e){
			testStepHandle("FAIL",testSetup.driver,test,e);	
		}
	}
	
	@Then("I click on view to get Sales Region metadata {string}")
	public void i_click_on_view_to_get_sales_region_metadata(String tcid) throws InterruptedException, IOException 
	{
		try {
		test = logInfo.get().createNode("I click on view to get Sales Region metadata");
		reportInfo("Click on View to get Sales Region metadata");
		Map<String, String> testData = ExcelFileReader.getDataInMap("SalesRegionCreate", tcid);
		testSetup.pageObjectManager.getSalesRegionPage().viewsalesregion(testData);
		reportScreenshot(testSetup.driver);
		reportInfo("Click on View to get Sales Region metadata Successful");
		
		}
		catch(AssertionError | Exception e){
			testStepHandle("FAIL",testSetup.driver,test,e);	
		}
	}
	
	@Then("I verify information {string} and click the back button")
	public void i_verify_information_and_click_the_back_button(String tcid) throws Exception 
	{
		try {
		test = logInfo.get().createNode("I verify information and click the back button");
		Map<String, String> testData = ExcelFileReader.getDataInMap("SalesRegionCreate", tcid);
		String text=testSetup.pageObjectManager.getSalesRegionPage().metadataverify(testData);
		
		if(text.equals( testData.get("Name"))) 
		{
		reportInfo("Verifying Information and Click the back button to come on Sales Regions Page");
		reportPass("Sales Regions Name", testData.get("Name"), text);
		reportScreenshot(testSetup.driver);
		reportInfo("Verifying Information and Click the back button Successful");
		}
		else
		{
			reportFail("Sales Regions Name ", testData.get("Name"), text);
			reportScreenshot(testSetup.driver);
		}
		}
		catch(Exception e){
			testStepHandle("FAIL",testSetup.driver,test,e);	
		}
	}
	
	@Then("I edit Sales Region metadata with test data {string} and click on SAVE")
	public void i_edit_sales_region_metadata_with_test_data_and_click_on_save(String tcid) throws Exception 
	{
		try {
		test = logInfo.get().createNode("I edit Sales Region metadata with test data and click on SAVE");
		reportInfo("Edit Sales Region metadata with test data");
		Map<String, String> testData = ExcelFileReader.getDataInMap("SalesRegionCreate", tcid);
		reportInfo(testData.toString());
		
		testSetup.pageObjectManager.getSalesRegionPage().editsalesregion(testData);
		reportInfo("Alter the form data and hit SAVE");
		reportScreenshot(testSetup.driver);
		testSetup.pageObjectManager.getSalesRegionPage().salesregionSave2();
		
		reportInfo("Sales Region Edited Successfully");
		}
		catch(Exception e){
			testStepHandle("FAIL",testSetup.driver,test,e);	
		}
	}
	
	@Then("I verify the change to data in the Sales Region table{string}")
	public void i_verify_the_change_to_data_in_the_sales_region_table(String tcid) throws Exception 
	{
		try {
		test = logInfo.get().createNode("I verify the change to data in the Sales Region table");
		Map<String, String> testData = ExcelFileReader.getDataInMap("SalesRegionCreate", tcid);
		String text=testSetup.pageObjectManager.getSalesRegionPage().verifyedit(testData);
		
		if(text.equals(testData.get("SalesRepresentative1"))) 
		{
		reportPass("Sales Regions Sales Representative ", testData.get("SalesRepresentative1"), text);
		reportInfo("Verify the Change to Data in the Sales Regions table");
		reportScreenshot(testSetup.driver);
		reportInfo("Verifying the Change to Data in the Sales Regions table Successful");
		}
		else
		{
			reportFail("Sales Regions ", testData.get("SalesRepresentative1"), text);
			reportScreenshot(testSetup.driver);
		}
		}
		catch(Exception e){
			testStepHandle("FAIL",testSetup.driver,test,e);	
		}
	}
	
	@Then("I track sales Region {string}")
	public void i_track_sales_region(String tcid) throws Exception 
	{
		try {
		test = logInfo.get().createNode("I track sales Region");
		Map<String, String> testData = ExcelFileReader.getDataInMap("SalesRegionCreate", tcid);
		testSetup.pageObjectManager.getSalesRegionPage().clickonclipboard(testData);
		reportInfo("Verify the Entity Audits page loads when Clicked on Clipboard Symbol");
		reportScreenshot(testSetup.driver);
		testSetup.pageObjectManager.getSalesRegionPage().verifyAuditPage();
		reportInfo("Verify that the Audit Details prompt appears when Clicked on Green Eye Symbol");
		reportScreenshot(testSetup.driver);
		testSetup.pageObjectManager.getSalesRegionPage().clickonDone();
		testSetup.pageObjectManager.getHomePage().navigateToOperationsTab();
		testSetup.pageObjectManager.getHomePage().navigateToSalesRegions();
		reportInfo("Tracking sales Region Successful and Verifying Audit Detailse Successful");
		}
		catch(Exception e){
			testStepHandle("FAIL",testSetup.driver,test,e);	
		}
	}
	
	@Then("I click DELETE {string}")
	public void i_click_delete(String tcid) throws IOException, InterruptedException 
	{
		try {
		test = logInfo.get().createNode("I click DELETE");
		Map<String, String> testData = ExcelFileReader.getDataInMap("SalesRegionCreate", tcid);
		testSetup.pageObjectManager.getSalesRegionPage().deletesalesregion(testData);
		reportInfo("I Click on Red rash Symbol and Delete Confirmation Alert Appers");
		reportScreenshot(testSetup.driver);
		reportInfo("Deleting a new Sales Regions Successful");
		
		}
		catch(Exception e){
			testStepHandle("FAIL",testSetup.driver,test,e);	
		}
		
	}
	
}
