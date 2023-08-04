package safefleetLM.pageobjects;

import java.util.Map;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

import safefleetLM.componentgroups.ReusableLibrary;

public class SalesRegionPage extends ReusableLibrary
{
	WebDriver driver;

	public SalesRegionPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//--------------------Melroy VMM3379--------------------------
	
	@FindBy(xpath = "//span[@class='ng-scope ng-binding']")
	WebElement salesregionspage;
	
	
	@FindBy(xpath= "//span[text()='New']")
	WebElement createnewsalesregionBtn;
	
	@FindBy(xpath = "(//input[@id='field_name'])[1]")
	WebElement entername;
	
	@FindBy(xpath = "(//input[@id='field_emails'])[1]")
	WebElement enteremail;
	
	@FindBy(xpath = "(//input[@name='salesRepresentative'])[1]")
	WebElement entersalesRepresentative;
	
	@FindBy(xpath = "(//button[@type='submit'])[1]")
	WebElement saveBtn;
	
	@FindBy(xpath = "//tbody/tr/td")
	List<WebElement> verifysalesregionsname;
	
	@FindBy(xpath = "(//i[contains(text(),'visibility')])[19]")
	WebElement viewBtn;
	
	@FindBy(xpath = "(//td)[2]")
	WebElement verifyname;
	
	@FindBy(xpath = "//button[@type='button']")
	WebElement backBtn;
	
	@FindBy(xpath = "(//i[contains(text(),'edit')])[19]")
	WebElement editBtn;
	
	@FindBy(xpath = "//input[@id='field_salesRepresentative']")
	WebElement editData;
	
	@FindBy(xpath = "//tbody/tr/td")
	List<WebElement> editedData;
	
	@FindBy(xpath = "(//i[contains(text(),'assignment_turned_in')])[20]")
	WebElement clipboardBtn;
	
	@FindBy(xpath = "(//h2[normalize-space()='Entity Audits'])[1]")
	WebElement verifyEntityPage;
	
	@FindBy(xpath = "(//i)[13]")
	WebElement eyeBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Done']")
	WebElement doneBtn;
	
	@FindBy(xpath = "(//i[@class='material-icons small-icon'][normalize-space()='delete'])[19]")
	WebElement deleteBtn;
	
	@FindBy(xpath = "//button[@ng-disabled='deleteForm.$invalid']")
	WebElement clickondeleteBtn;
	
	String scrollToNamexpath= "//tbody/tr[19]/td[1]";
	
	@FindBy(xpath = "//div[@id='mm-0']/div[2]/div/div[2]/jh-alert/div/div/div/div/pre")
	WebElement saveAlertPopup;
	
	@FindBy(xpath = "//div[@class='table-responsive well']")
	List<WebElement> salesTable;
	//--------------------------------------------------------------------------------

	//-----------------------------------Nitin-----------------------------------------------------//
	@FindBy(xpath = "//button[@id='sales_delete_btn_1']")
	WebElement deleteVerify1;
	
	@FindBy(xpath = "//button[@id='sales_delete_btn_5']")
	WebElement deleteVerify2;
	//------------------------------------Nitin----------------------------------------------------//
	
	//-------------------Melroy VMM3379----------------------------------------------
	
	public void createnewsalesregion(Map<String, String> testData) throws InterruptedException
	{
		
		waitForElementToBeClickableThenClick(createnewsalesregionBtn);
		sleepMin();
		waitForElementToBeClickableThenSendkeys(entername, testData.get("Name"));
		sleepMin();
		waitForElementToBeClickableThenSendkeys(enteremail, testData.get("Email"));
		sleepMin();
		waitForElementToBeClickableThenSendkeys(entersalesRepresentative, testData.get("SalesRepresentative"));
		sleepMin();
		
	}
	
	public void salesregionSave1() throws InterruptedException
	{
		
		waitForElementToBeClickableThenClick(saveBtn);
		sleepAvg();
		
	}
	
	public boolean savedPopUp()
	{
		if(saveAlertPopup.isDisplayed())
				return true;
		else
			return false;
	}
	
	public String verifySalesRegionsName(Map<String, String> testData) throws InterruptedException
	{
		int count=verifysalesregionsname.size();
		System.out.println(count);
		for(int i=0; i<count-1; i++)
		{
			String BSName=verifysalesregionsname.get(i).getText();
			if(BSName.equalsIgnoreCase(testData.get("Name")))
			{
				System.out.println(BSName);
				int j=i;
				System.out.println(j);
				return BSName;
			}
			
		}
		return null;
	}
	
	public void viewsalesregion(Map<String, String> testData) throws InterruptedException
	{
		int count=salesTable.size();
		System.out.println(count);
		for(int i=0; i<count; i++)
		{
			String BSName=salesTable.get(i).getText();
			if(BSName.equalsIgnoreCase(testData.get("Name")))
			{
				
				int j=i;
				System.out.println(j);
				break;
			}
			
		}
		scrollToElement("//td[text()='"+testData.get("Name")+"']");
		WebElement editBtnBaseProduct=driver.findElement(By.xpath("//td[text()='"+testData.get("Name")+"']/..//button//i[text()='visibility']"));
		waitForElementToBeClickableThenClick(editBtnBaseProduct);
		waitForAngularRequestsToFinish();
		
	}
	
	public String metadataverify(Map<String, String> testData) throws Exception 
	{
		
		String text = verifyname.getText();
		waitForElementToBeClickableThenClick(backBtn);
		scrollToElement(scrollToNamexpath);
		return text;
	}
	
	public void editsalesregion(Map<String, String> testData) throws InterruptedException
		{
		int count=salesTable.size();
		System.out.println(count);
		for(int i=0; i<count; i++)
		{
			String BSName=salesTable.get(i).getText();
			if(BSName.equalsIgnoreCase(testData.get("Name")))
			{
				
				int j=i;
				System.out.println(j);
				break;
			}
			
		}
		scrollToElement("//td[text()='"+testData.get("Name")+"']");
		WebElement editBtnBaseProduct=driver.findElement(By.xpath("//td[text()='"+testData.get("Name")+"']/..//button//i[text()='edit']"));
		waitForElementToBeClickableThenClick(editBtnBaseProduct);
		sleepAvg();
		waitForElementToBeClickableThenClearThenSendkeys(entersalesRepresentative, testData.get("SalesRepresentative1"));
		waitForAngularRequestsToFinish();
		
		}
	
	public void salesregionSave2() throws InterruptedException
	{
		waitForElementToBeClickableThenClick(saveBtn);
		sleepAvg();
	}
	
	public String verifyedit(Map<String, String> testData) throws InterruptedException
	{
		int count=editedData.size();
		System.out.println(count);
		for(int i=0; i<count-1; i++)
		{
			String BSName=editedData.get(i).getText();
			if(BSName.equalsIgnoreCase(testData.get("SalesRepresentative1")))
			{
				System.out.println(BSName);
				int j=i;
				System.out.println(j);
				return BSName;
			}
			
		}
		return null;
		
	}
	
	public void clickonclipboard(Map<String, String> testData) throws InterruptedException
	{
		int count=salesTable.size();
		System.out.println(count);
		for(int i=0; i<count; i++)
		{
			String BSName=salesTable.get(i).getText();
			if(BSName.equalsIgnoreCase(testData.get("Name")))
			{
				
				int j=i;
				System.out.println(j);
				break;
			}
			
		}
		scrollToElement("//td[text()='"+testData.get("Name")+"']");
		WebElement editBtnBaseProduct=driver.findElement(By.xpath("//td[text()='"+testData.get("Name")+"']/..//button//i[text()='assignment_turned_in']"));
		waitForElementToBeClickableThenClick(editBtnBaseProduct);
		waitForAngularRequestsToFinish();
		
	}
	 
	public void verifyAuditPage() throws InterruptedException 
	{
		waitForElementToBeClickableThenClick(eyeBtn);
		sleepAvg();
		
	}
	public void clickonDone() throws InterruptedException 
	{
		waitForElementToBeClickableThenClick(doneBtn);
	
	}
	
	public void deletesalesregion(Map<String, String> testData) throws InterruptedException
	{
		int count=salesTable.size();
		System.out.println(count);
		for(int i=0; i<count; i++)
		{
			String BSName=salesTable.get(i).getText();
			if(BSName.equalsIgnoreCase(testData.get("Name")))
			{
				
				int j=i;
				System.out.println(j);
				break;
			}
			
		}
		scrollToElement("//td[text()='"+testData.get("Name")+"']");
		WebElement editBtnBaseProduct=driver.findElement(By.xpath("//td[text()='"+testData.get("Name")+"']/..//button//i[text()='delete']"));
		waitForElementToBeClickableThenClick(editBtnBaseProduct);
		
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(clickondeleteBtn);
		sleepMin();
		
		
	}

	//------------------------------------Nitin----------------------------------------------------//
	public boolean deleteVerifyStepForDisabled()
	{
		if(deleteVerify1.isEnabled())
		{
			return true;
		}
		return false;
	}

	public boolean deleteVerifyStepForEnabled()
	{
		if(deleteVerify2.isEnabled())
		{
			return true;
		}
		return false;
	}
	//---------------------------------------Nitin-------------------------------------------------------//

	//--------------------------------------------------------------------------------------


}

