package safefleetLM.pageobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import safefleetLM.componentgroups.ReusableLibrary;

public class BaseProductPage extends ReusableLibrary
{
	WebDriver driver;

	public BaseProductPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(xpath="//td[text()='Lane Enforcement']")
	WebElement baseProductName_SFClearLane;
	
	@FindBy(xpath="//img[@ng-src='/assets/icons/LaneEnforcement/lane_enforcement.png']")
	WebElement baseProductIcon_SFClearLane;
	
	///3953
	
	//@FindBy(xpath="(//td[@id='name_41'])[1]")
	@FindBy(xpath="//td[text()='Lane Enforcement']")
	WebElement BaseProductName3953;
	
		////3870
	//@FindBy(xpath="(//td[@id='name_36'])[1]")
	@FindBy(xpath="//td[text()='License Plate Aggregation']")
	WebElement BaseProductName3870;
	
	//@FindBy(xpath="(//span)[261]")
	@FindBy(xpath="//td[text()='License Plate Aggregation']/..//input[contains(@id,'checkbox_cloud')]/..//span[@class='check']")
	WebElement BaseProductCloud3870;
	
	@FindBy(xpath="//td[text()='License Plate Aggregation']/..//input[contains(@id,'checkbox_local')]/..//span[@class='check']")
	WebElement BaseProductLocal3870;
	
	@FindBy(xpath="//td[text()='License Plate Aggregation']/..//a[text()='Web PTLW']")
	WebElement BaseProductEcosystem3870;

	//3584
	
	//@FindBy(xpath="//td[@id='name_11']")
	@FindBy(xpath="//td[text()='Cloud Courier for DES']")
	WebElement BaseProductName3584;

		
	//@FindBy(xpath="(//span)[236]")
	@FindBy(xpath="//td[text()='Cloud Courier for DES']/..//input[contains(@id,'checkbox_cloud')]/..//span[@class='check']")
	WebElement DESCloudCourierCloudBtn;
	
	//3261
	
	
	@FindBy(xpath="//span[normalize-space()='New']")
	WebElement CreateNew;
	
	@FindBy(xpath="(//input[@id='field_name'])[1]")
	WebElement enterName;	
	
	@FindBy(xpath="(//select[@id='field_softwareGroup'])[1]")
	WebElement enterEcosystem;
	
	@FindBy(xpath="//*[@id='checkbox_cloud']")
	WebElement enterCloud;
	
	@FindBy(xpath="//*[@id='checkbox_local']")
	WebElement enterLocal;
	
	@FindBy(xpath="(//input[@aria-label='Select box'])[1]")
	WebElement enterServer;

	@FindBy(xpath="(//button[@id='save_btn'])[1]")
	WebElement saveBtn;


	////

	@FindBy(xpath="(//td[@id='name_41'])[1]")
	WebElement SFClearlaneName;
	
	@FindBy(xpath="(//td[@id='name_11'])[1]")
	WebElement SFDESCloudCourierName;
	
	
	@FindBy(xpath="(//td[@id='name_1'])[1]")
	WebElement SFCommanderName;
	
	@FindBy(xpath="(//td[@id='name_5'])[1]")
	WebElement SFCompassName;
	
	@FindBy(xpath="(//td[@id='name_2'])[1]")
	WebElement SFDSPlayerName;
	
	@FindBy(xpath="(//td[@id='name_3'])[1]")
	WebElement SFLiveName;

	@FindBy(xpath="(//td[@id='name_16'])[1]")
	WebElement SFNexusName;
	
	@FindBy(xpath="(//td[@id='name_8'])[1]")
	WebElement SFPathName;
	
	@FindBy(xpath="(//td[@id='name_4'])[1]")
	WebElement SFStreamName;
	
	
		//--------------Melroy 3849----------------
	String scrolltoBP="//td[@id='name_33']";
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]")
	WebElement BaseProductName3849;
	
	@FindBy(xpath = "//tbody/tr[2]/td[2]")
	WebElement DVRFrimwareIcon;
	
	@FindBy(xpath="//tbody/tr[3]/td[2]")
	WebElement BaseProductCloud3849;
	
	@FindBy(xpath="//tbody/tr[4]/td[2]")
	WebElement BaseProductLocal3849;
	
	@FindBy(xpath="//tbody/tr[5]/td[2]")
	WebElement BaseProductEcosystem3849;
	
	@FindBy(xpath = "//tr/td")
	List<WebElement> baseProductName;
	//----------------------------------------------
	//--------------Melroy 3289----------------
	String BPscroll="(//i[@class='material-icons small-icon'][normalize-space()='visibility'])[14]";
	String BPscroll2="(//i[@class='material-icons small-icon'][normalize-space()='visibility'])[22]";
	
	@FindBy(xpath = "//tr/td")
	List<WebElement> BaseProductType;
	
	@FindBy(xpath = "//button[@id='software_btn_new']")
	WebElement clicknewBtn;
	
	@FindBy(xpath = "//select[@id='field_softwareGroup']")
	WebElement BasePEcoSys;
	
	@FindBy(xpath = "//input[@id='field_name']")
	WebElement BasePEdit;
	
	@FindBy(xpath = "//input[@id='checkbox_cloud']")
	WebElement cloudCheckBox;
	
	@FindBy(xpath = "//input[@aria-label='Select box']")
	WebElement selectBoxServer;
	
	@FindBy(xpath = "//ul[@class='ui-select-choices ui-select-choices-content ui-select-dropdown dropdown-menu']")
	List<WebElement> serverList;
	
	//------------------------------------------------------------------------------------
	//--------------------------------VMM3283 Melroy----------------------------------------------
	@FindBy(xpath = "//span[contains(text(),'FLEET5')]")
	WebElement server1;
	
	@FindBy(xpath = "//span[contains(text(),'FLEET1')]")
	WebElement server2;
	
	@FindBy(xpath = "//span[contains(text(),'FLEET3')]")
	WebElement srever3;
	
	@FindBy(xpath = "//span[contains(text(),'test2')]")
	WebElement server4;
	
	@FindBy(xpath = "//button[@id='software_edit_76']")
	WebElement clickeditBtn;
	
	@FindBy(xpath = "(//div)[38]")
	WebElement sereverTextField;
	
	@FindBy(xpath = "//div[@id='field_servers']//span/span/span/span/span[1]")
	List<WebElement> serverLables;
	
	@FindBy(xpath = "//div[@id='field_servers']")
	WebElement serverNewList;
	
	@FindBy(xpath = "//button[@id='cancel_btn']")
	WebElement cancleBTN;
	//---------------------------------------------------------------------------------------------

//-------BHanu---------
	@FindBy(xpath="//tr//td[1]")
	List<WebElement> allBaseProductList;
	
	@FindBy(xpath = "//span[@id='value_applicationId']")
	WebElement baseProductAppId;
	
		//---------------------------------------------Nitin------------------------------------------------//
			//@FindBy(xpath="(//td[text()='testauto testauto testauto testauto testauto testa']//parent::tr//button)[1]")
			@FindBy(xpath="//*[@id='software_view_1']")
			WebElement vieww;
			
			@FindBy(xpath="//span[@id='value_applicationId']")
			WebElement applicationID;
			
			@FindBy(xpath="//input[@id='checkbox_cloud']")
			WebElement enterCloudd;
			
			@FindBy(xpath="//span[@id='value_name']")
			WebElement baseAppName;
			
		//-----------------------------------------------Nitin-----------------------------------------------//


		//surya--------------------------------------VMM4677----------------------------------------------
			
			@FindBy(xpath="//*[@id='value_applicationId']")
			WebElement VerifyApplicationId;
			

	//Savitha
		@FindBy(xpath="//tr//td[1]")
		List<WebElement> allBaseAppList;
			
		@FindBy(xpath="//span[text()='Cancel']/../../button[2]/span")
		WebElement deleteConfirmation;
		
		@FindBy(xpath="//pre[@class='ng-binding ng-scope']")
		WebElement deleteAlertMsg;


	public void verifyBaseProductNameAndIcon(Map<String, String> testData, String baseProduct)
	{
		
		scrollToElement("//td[text()='Lane Enforcement']");
		//String baseProductText = getWebelementText(baseProductName_SFClearLane);
		



}

	////3953
	
	public String verifyBaseProductName(Map<String, String> testData, String baseProduct)
	{
		//By.xpath("(//td[@id='name_41'])[1]")
		scrollToElement("(//td[@id='name_7'])[1]");
		//String text=waitForPresenceOfElementThenGettext(By.xpath("(//td[@id='name_41'])[1]"));
		String text=BaseProductName3953.getText();
		return text;
		
	}
	
   ////3870
	
	public String verifyBaseProductName3870(Map<String, String> testData) throws InterruptedException
	{
		scrollToElement("(//td[@id='name_78'])[1]");
		Thread.sleep(SLEEP_MAX);
		String text=BaseProductName3870.getText();
		return text;
		
	}
	
	public String verifyBaseProductEcosystem3870(Map<String, String> testData) throws InterruptedException
	{
		
		
		Thread.sleep(SLEEP_MAX);
		String text= BaseProductEcosystem3870.getText();
		return text;
		
	}
	public String verifyBaseProductCloud3870(Map<String, String> testData)
	{
		
		Boolean requiresDeviceSettings=BaseProductCloud3870.isEnabled();
		String str=requiresDeviceSettings.toString();
		return str;
	}
	public String verifyBaseProductLocal3870(Map<String, String> testData)
	{
		
		Boolean requiresDeviceSettings=BaseProductLocal3870.isSelected();
		String str=requiresDeviceSettings.toString();
		return str;
		
	}
	///3584
	public String verifyBaseProductName3584(Map<String, String> testData) throws InterruptedException
	{
		 ////td[@id='name_11']       
		scrollToElement("(//td[@id='name_41'])[1]");
				 sleepMAX();
				
				 String text=BaseProductName3584.getText();
					return text;
		
	}
	
	//3262
	
	public void createBaseProduct(Map<String, String> testData) throws InterruptedException
	{
		        
		waitForElementToBeClickableThenClick(CreateNew);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClearThenSendkeys(enterName,testData.get("Name"));
		selectListByVisibleText(enterEcosystem, testData.get("Ecosystem"));
		waitForElementToBeClickableThenClick(enterCloud);
		//waitForElementToBeClickableThenClick(enterLocal);
		waitForElementToBeClickableThenClearThenSendkeys(enterServer,testData.get("Server")); 
		waitForElementToBeClickableThenClick(saveBtn);
		waitForAngularRequestsToFinish();
	}
	public String verifyDESCloudCourierName(Map<String, String> testData) throws InterruptedException
	{
		 ////td[@id='name_11']       
		//scrollToElement("(//td[@id='name_41'])[1]");
				 //sleepMAX();
				
				 String text=BaseProductName3584.getText();
					return text;
		
	}
	public String verifyDESCloudCourierCloud(Map<String, String> testData) throws InterruptedException
	{
		Boolean DESCloudCourierCloud=DESCloudCourierCloudBtn.isDisplayed();
		String str =DESCloudCourierCloud.toString();
		return str;
						
		
	}

	////

		
	public String verifySFClearlaneName(Map<String, String> testData) throws InterruptedException
	{	
		scrollToElement("(//td[@id='name_7'])[1]");
		String text=SFClearlaneName.getText();
		return text;	
	}
	public String verifySFDESCloudCourierName(Map<String, String> testData) throws InterruptedException
	{	
		String text=SFDESCloudCourierName.getText();
		return text;	
	}
	public String verifySFCognitionName(Map<String, String> testData) throws InterruptedException
	{	
		String text=BaseProductName3870.getText();
		return text;	
	}
	
	public String verifySFCommanderName(Map<String, String> testData) throws InterruptedException
	{	
		String text=SFCommanderName.getText();
		return text;	
	}
	
	public String verifySFCompassName(Map<String, String> testData) throws InterruptedException
	{	
		String text=SFCompassName.getText();
		return text;	
	}

	public String verifySFDSPlayerName(Map<String, String> testData) throws InterruptedException
	{	
		String text=SFDSPlayerName.getText();
		return text;	
	}
	
	public String verifySFLiveName(Map<String, String> testData) throws InterruptedException
	{	
		String text=SFLiveName.getText();
		return text;	
	}
	
	public String verifySFNexusName(Map<String, String> testData) throws InterruptedException
	{	
		String text=SFNexusName.getText();
		return text;	
	}
	
	public String verifySFPathName(Map<String, String> testData) throws InterruptedException
	{	
		String text=SFPathName.getText();
		return text;	
	}
	
	public String verifySFStreamName(Map<String, String> testData) throws InterruptedException
	{	
		String text=SFStreamName.getText();
		return text;	
	}

				//-------------------------------Melroy 3849------------------------------------------------
	public String verifyBaseProductDVRFrimware(Map<String, String> testData) throws InterruptedException
	{
		int count=baseProductName.size();
		for(int i=0; i<count-1; i++)
		{
			String BSName=baseProductName.get(i).getText();
			if(BSName.equalsIgnoreCase(testData.get("Name")))
			{
				System.out.println(BSName);
				int j=i;
				System.out.println(j);
				WebElement viewBaseProduct=driver.findElement(By.xpath(("(//i[contains(text(),'visibility')])["+(j+1)+"]")));
				waitForElementToBeClickableThenClick(viewBaseProduct);
				sleepMAX();
				return BSName;
			}
			
		}
		
		return null;	
	}
	public String verifyBaseProductclickview(Map<String, String> testData) throws InterruptedException
	{
		int count=baseProductName.size();
		System.out.println(count);
		for(int i=0; i<count-1; i++)
		{
			String BSName=baseProductName.get(i).getText();
			if(BSName.equalsIgnoreCase(testData.get("Name")))
			{
				System.out.println(BSName);
				int j=i;
				System.out.println(j);
				//scrollToElement("(//tr/td[1])["+j+"]");
				break;
			}
			
		}
		WebElement editBtnBaseProduct=driver.findElement(By.xpath("//td[text()='"+testData.get("Name")+"']/..//button[1]"));
		waitForElementToBeClickableThenClick(editBtnBaseProduct);
		waitForAngularRequestsToFinish();
		String BSName=testData.get("Name");
		return BSName;
		
	}
	
	public String verifyBaseProductName3849(Map<String, String> testData) throws InterruptedException
	{
		//scrollToElement(scrolltoBP);
		sleepAvg();
		String text=BaseProductName3849.getText();
		return text;
	}
	
	public String verifyDVRIcon(Map<String, String> testData) 
	{
		String text=DVRFrimwareIcon.getText();
		return text;
		}
			
	public String verifyBaseProductEcosystem3849(Map<String, String> testData) throws InterruptedException
	{
		sleepAvg();
		String text= BaseProductEcosystem3849.getText();
		return text;
	}
	
	public String verifyBaseProductCloud3849(Map<String, String> testData)
	{
		String str=BaseProductCloud3849.getText();
		return str;
	}
	
	public String verifyBaseProductLocal3849(Map<String, String> testData)
	{
		String str=BaseProductLocal3849.getText();
		return str;
	}
	//-----------------------------------------------------------------------------------------------
	//-------------------------------Melroy VMM3829------------------------------------------------
	public String verifyBaseProductDESCloudCourier(Map<String, String> testData) throws InterruptedException
	{
		//scrollToElement(BPscroll);
		//sleepAvg();
		scrollToElement(BPscroll2);
		int count=BaseProductType.size();
		System.out.println(count);
		for(int i=0; i<count-1; i++)
		{
			String BSName=BaseProductType.get(i).getText();
			if(BSName.equalsIgnoreCase(testData.get("Name")))
			{
				//scrollToElement("(//i[@class='material-icons small-icon'][normalize-space()='visibility'])["+i+"]");
				//scrollToElement("(//tr/td[1])["+i+"]");
				System.out.println(BSName);
				int j=i;
				System.out.println(j);
				
				
				//sleepAvg();
				//driver.findElement(By.xpath(("(//i[contains(text(),'visibility')]))["+(j+1)+"]"))).click();
				//sleepMAX();
				return BSName;
			}
			
		}
		return null;
	
	}
	
	public String verifyBaseProductf2(Map<String, String> testData) throws InterruptedException
	{
		int count=baseProductName.size();
		for(int i=1; i<count; i++)
		{
			String BSName=baseProductName.get(i).getText();
			if(BSName.equalsIgnoreCase(testData.get("Name")))
			{
				System.out.println(BSName);
				int j=i;
				System.out.println(j);
				driver.findElement(By.xpath(("(//i[contains(text(),'Edit')])["+(j+1)+"]"))).click();
				sleepMAX();
				return BSName;
			}
			
		}
		return null;	
	}

	
	//----------------------------------------------------------------------------------------------------------------------
	//---------------------------------------VMM3283 Melroy---------------------------------------------
	public String verifyBaseProductclickedit(Map<String, String> testData) throws InterruptedException
	{
		int count=baseProductName.size();
		System.out.println(count);
		for(int i=0; i<count; i++)
		{
			String BSName=baseProductName.get(i).getText();
			if(BSName.equalsIgnoreCase(testData.get("Name")))
			{
				System.out.println(BSName);
				int j=i;
				System.out.println(j);
				break;
			}
			
		}
		WebElement editBtnBaseProduct=driver.findElement(By.xpath("//td[text()='"+testData.get("Name")+"']/..//button[2]"));
		waitForElementToBeClickableThenClick(editBtnBaseProduct);
		waitForAngularRequestsToFinish();
		String BSName=testData.get("Name");
		return BSName;
		
	}
	
	
	
	public  ArrayList<String> baseProductservers(Map<String, String> testData) throws Exception{
	
	int count =serverLables.size();
	System.out.println(count);
	ArrayList<String> baseServers=new ArrayList<>();
	for(int i=0;i<count;i++)
	{
		String Name = serverLables.get(i).getText();
		baseServers.add(Name);
	}
	System.out.println(baseServers);
	
	return baseServers;

	}
	


//***********Bhanu****************
	
	public void clickViewToVerifyBaseProduct(Map<String, String> testData) throws InterruptedException {
		
		
		
		sleepMin();
		List<WebElement> visibleTo30 = driver.findElements(By.xpath("(//tr//td[1])[30]"));
		if(visibleTo30.size()>0)
			 scrollToElement("(//tr//td[1])[30]");
		
		sleepMin();
		
		List<WebElement> visibleTo55 = driver.findElements(By.xpath("(//tr//td[1])[55]"));
		if(visibleTo55.size()>0)
			 scrollToElement("(//tr//td[1])[55]");
		
		System.out.println("Visible Number : "+visibleTo30.size()+" and "+visibleTo55.size());
		sleepMin();
		
		
		System.out.println("Count of all Devices :"+allBaseProductList.size()); 
		
		for(int i=0; i<allBaseProductList.size()-1;i++)
		{
			String BaseProductName = allBaseProductList.get(i).getText();
			
			if(testData.get("Name").equalsIgnoreCase(BaseProductName))
			{
				System.out.println("Element number ="+i);
				System.out.println(allBaseProductList.get(i).getText()+"=="+testData.get("Name"));
			     scrollToElement("(//tr//td[1])["+i+"]");
			     break;
			}
		}
		WebElement baseProductViewButton = driver.findElement(By.xpath("//td[text()='"+testData.get("Name")+"']/../td[5]//button//i[text()='visibility']"));

		sleepMin();
		waitForElementToBeClickableThenClick(baseProductViewButton);
		waitForAngularRequestsToFinish();
	}

	public String[] verifyBaseProductResources(Map<String, String> testData,Map<String, String> testData1) {
		
		String ApplicationIdInLMWeb = baseProductAppId.getText();
		//System.out.println("ApplicationId : "+ApplicationIdInLMWeb);
		
		//System.out.println(testData1.get("LMdetails"));
		
		String[] LMdetails = testData1.get("LMdetails").split("-");
		//String[] ActualId = new String[5];
		String ApplicationIdInLM = LMdetails[1]+"-"+LMdetails[2]+"-"+LMdetails[3];
		System.out.println("Actual id from LM : "+LMdetails[1]+"-"+LMdetails[2]+"-"+LMdetails[3]);
		
		//return [ApplicationIdInLM, ApplicationIdInLMWeb] ;
		
		return new String[] {ApplicationIdInLMWeb , ApplicationIdInLM};
	}
	
	
//**********************

	//-------------------Sunilkumar(VMM3284)-------------------------------------------
	public void viewbaseproduct(Map<String, String> testData) throws Exception {
		//sleepMin(); 
		//scrollToElement("(//tr//td[1])[40]");
		//sleepMin();
		//scrollToElement("(//tr//td[1])[50]");
		sleepMin();
		//WebElement deleteBtnPerticularName = driver.findElement(By.xpath("//td[text()='"+testData.get("Name")+"']/../td[8]//button//i[text()='delete']"));
		int count=baseProductName.size();
		System.out.println(count);
		for(int i=0; i<count; i++)
		{
			String BSName=baseProductName.get(i).getText();
			if(BSName.equalsIgnoreCase(testData.get("Name")))
			{
				System.out.println(BSName);
				int j=i;
				System.out.println(j);
				break;
			}
			
		}
		WebElement viewBtnPerticularName = driver.findElement(By.xpath("//td[text()='"+testData.get("Name")+"']/../td[5]//button//i[text()='edit']")); 

		sleepMin();
		waitForElementToBeClickableThenClick(viewBtnPerticularName); 
		waitForAngularRequestsToFinish();
		
		
	}



//------------------------------------------Nitin--------------------------------------------------------//
			public void createBaseProductWithMinimumData(Map<String, String> testData) throws InterruptedException
			{
				        
				waitForElementToBeClickableThenClick(CreateNew);
				waitForAngularRequestsToFinish();
				waitForElementToBeClickableThenClearThenSendkeys(enterName,testData.get("Name"));
				waitForAngularRequestsToFinish();
				selectListByVisibleText(enterEcosystem, testData.get("Ecosystem"));
				waitForAngularRequestsToFinish();
				waitForElementToBeClickableThenClick(enterCloudd);
				waitForAngularRequestsToFinish();
				waitForElementToBeClickableThenClearThenSendkeys(enterServer,testData.get("Server")); 
				waitForAngularRequestsToFinish();
				waitForAngularRequestsToFinish();
				waitForElementToBeClickableThenClick(saveBtn);
				waitForAngularRequestsToFinish();
				driver.navigate().refresh();
			}
			public boolean verifyApplicationID()
			{
				if(applicationID.isDisplayed())
				{
					if(!applicationID.getText().equals(""))
					{
						return true;
					}
				}
				return false;
			}
			public void clickOnVieww()
			{
				//scrollToElement("(//td[text()='testauto testauto testauto testauto testauto testa']//parent::tr//button)[1]");
				scrollDown();
				waitForElementToBeClickableThenClick(vieww);
			}
			public void clickOnNew()
			{
				CreateNew.click();
			}
			public boolean verifyApplicationIDCaps()
			{
				String text = applicationID.getText();
				for(int i=0;i<text.length();i++)
				{
					if(text.charAt(i) >= 'A' && text.charAt(i) <= 'Z')
					{
						return true;
					}
				}
				return false;
			}
			
			public boolean verifyApplicationIDWithHyphen()
			{
				String text = applicationID.getText();
				System.out.println("Sav Check : "+text);
				if(!text.contains("-"))
				{
					if(!text.contains(" ")) 
					{
						return true;
					}
				}				
					return false;
			}
			
			public boolean verifyApplicationIDWithLength()
			{
				String text = applicationID.getText();
				if(text.length() <= 50)
				{
					return true;
				}
				return false;
			}
			
			public boolean verifyBaseAppNameWithLength()
			{
				String text = baseAppName.getText();
				if(text.length() <= 50)
				{
					return true;
				}
				return false;
			}
			
			public void viewBaseApp(Map<String, String> testData)
			{
				scrollDown();
				WebElement viewBaseApp = driver.findElement(By.xpath("//td[text()='"+testData.get("Name")+"']/..//i[text()='visibility']"));
				waitForElementToBeClickableThenClick(viewBaseApp);
			}
	//--------------------------------------------Nitin---------------------------------------------------------------//



			
	//surya--------------------------------VMM-4677---------------------------------------------		
			
		public String verifySFCommanderBaseProductApplicationId() {
		
			String VerifyApplicationIdInSfCommander = getWebelementText(VerifyApplicationId);
			
			return VerifyApplicationIdInSfCommander;
		}

		//Savitha
		public String deleteBaseApp(Map<String, String> testData) {
			
			waitForAngularRequestsToFinish();
			scrollTillEnd(".table-responsive.well");
			waitForAngularRequestsToFinish();

			for(int i=0; i<allBaseAppList.size()-1;i++)
			{
				String baseAppName = allBaseAppList.get(i).getText();

				if(testData.get("Name").equalsIgnoreCase(baseAppName))
				{
					System.out.println(allBaseAppList.get(i).getText()+"=="+testData.get("Name"));
					scrollToElement("(//tr//td[1])["+(i-1)+"]");
					break;
				}
			}
			WebElement deleteBtnPerticularName = driver.findElement(By.xpath("//td[text()='"+testData.get("Name")+"']/..//i[text()='delete']"));
			waitForElementToBeClickableThenClick(deleteBtnPerticularName);
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenClick(deleteConfirmation);
			String message =deleteAlertMsg.getText();

			return message;
		}
		
		
		public ArrayList<String> getAllBaseApps() throws InterruptedException {

			waitForAngularRequestsToFinish();

			scrollDown();
			waitForAngularRequestsToFinish();

			int countAll= allBaseAppList.size();
			ArrayList<String> List=new ArrayList<>();

			for(int i=0;i<countAll;i++)
			{
				String Name = allBaseAppList.get(i).getText();
				//System.out.println(Name);
				List.add(Name);
			}
			return List;
		}
}
