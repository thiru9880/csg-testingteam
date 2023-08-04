package safefleetLM.pageobjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import safefleetLM.componentgroups.ReusableLibrary;

public class BulkDeviceUploadPage extends ReusableLibrary{

	WebDriver driver;

	public BulkDeviceUploadPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//--------------------------Nitin-----------------------------------------------------------//
	@FindBy(xpath = "//input[@id='file']")
	WebElement upload;
	
	@FindBy(xpath = "//span[text()='Upload']")
	WebElement uploadButton;
	
	@FindBy(xpath = "//div[@class='col-xs-10 col-sm-11']//child::span[text()='Success. ']")
	WebElement successMessage;
	
	@FindBy(xpath = "//span[text()='Finalize']")
	WebElement finalize;
	//--------------------------------------------------------------Nitin-----------------------------//
////Naincy
	
	@FindBy(xpath = "//i[@ng-show='!isCollapseUpdatedDevicesContainer']")
	WebElement DropDownBtn;
	
	@FindBy(xpath = "//span[text()='Customer Provided']")
	WebElement CustomerProvided;
	
	@FindBy(xpath = "(//td[@class='ng-binding'][normalize-space()='Not Assigned'])[1]")
	WebElement DeviceStatus;	
	
	@FindBy(xpath = "(//input[@aria-label='Filter for column'])[3]")
	WebElement DeviceTypeFilter;
	

	@FindBy(xpath = "(//select[@class='ui-grid-filter-select ui-grid-filter-input-0 ng-dirty ng-touched'])[1]")
	WebElement showFiltersBtn;
	//------------------------------------------------Nitin-------------------------------------------//
	public void uploadFile(String file) throws InterruptedException
	{
		upload.sendKeys(file);
	}
	
	public void clickOnUploadButton()
	{
		uploadButton.click();
	}
	
	public boolean verifySuccessMessage()
	{
		String text = successMessage.getText();
		if(text.contains("Success"))
		{
			return true;
		}
		return false;
	}
	
	public void clickOnFinalize()
	{
		finalize.click();
	}
	//----------------------------------------------------------Nitin--------------------------------------------//


		////Naincy
	
	
	public void bulkDeviceUploadDropdown()
	{
		DropDownBtn.click();
	}
	
	public String verifyCustomerProvidedFeild()
	{
		String text=waitForPresenceOfElementThenGettext(CustomerProvided);
		return text;
	}
	
	public String verifyDeviceStatus()
	{
		String text=waitForPresenceOfElementThenGettext(DeviceStatus);
		return text;
	}
	
	public void filter()
	{
		waitForElementToBeClickableThenSendkeys(DeviceTypeFilter, "1992");
	}

	  public void deviceTypeFilter(Map<String, String> testData) throws InterruptedException {
			 
		 waitForElementToBeClickableThenClick(showFiltersBtn);
		 
//		 selectListByVisibleText(filterFieldsDrp, "Tenant ID");
//		 
//		 selectListByVisibleText(filterOperationsDrp, "equals");
//		 
//		 waitForElementToBeClickableThenClearThenSendkeys(tenantTxt, testData.get("TenantID"));
//		 
//	//	waitForElementToBeClickableThenClearThenSendkeys(tenantIDSrch, testData.get("TenantID"));
//		
//		 sleepMAX();
//		 
//		 waitForElementToBeClickableThenClick(filterBtn);
//		 
//		 sleepMAX();
//		 
//		 waitForElementToBeClickableThenClick(hideFiltersBtn);
//		 
//		 sleepMin();
	  }

}
