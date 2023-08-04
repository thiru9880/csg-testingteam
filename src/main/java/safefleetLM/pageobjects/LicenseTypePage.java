package safefleetLM.pageobjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import safefleetLM.componentgroups.ReusableLibrary;

public class LicenseTypePage extends ReusableLibrary
{

	WebDriver driver;
	public LicenseTypePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//td[@class='ng-binding'][normalize-space()='Base App'])[22]")
	WebElement licenseType_BaseProduct_Btn;

	@FindBy(xpath="(//td[@class=\"ng-binding\"])[326]")
	WebElement licenseType_Device_Btn;

	@FindBy(xpath="(//td[@class=\"ng-binding\"])[328]")
	WebElement subLicenseType_Device_Btn;


	@FindBy(xpath="(//img[@title='SF ClearLane'])[1]")
	WebElement SFClearLaneforLicenseType_BaseProduct;

	@FindBy(xpath="(//span[@id='value_name'])[1]")
	WebElement baseProduct_NameforLicenseType_BaseProduct;

	@FindBy(xpath="(//img[@title='SF ClearLane'])[2]")
	WebElement SFClearLaneforLicenseType_Device;

	@FindBy(xpath="(//span[@id='value_name'])[1]")
	WebElement baseProduct_NameforLicenseType_Device;

	///3953

@FindBy(xpath="(//a[@ui-sref='software.detail({id:slotType.software.id})'][normalize-space()='Lane Enforcement'])[1]")
	WebElement BaseProduct1_3953;

	//@FindBy(xpath="(//td[@class='ng-binding'][normalize-space()='Base App'])[22]")
	@FindBy(xpath="//a[contains(text(),'Lane Enforcement')]/../..//td[contains(text(),'Base App')]")
	WebElement LT_BaseProduct_3953;

	//@FindBy(xpath="(//td[@class='ng-binding'][normalize-space()='Asset'])[14]")
	@FindBy(xpath="//a[contains(text(),'Lane Enforcement')]/../..//td[contains(text(),'Asset')]")
	WebElement LT_Device_3953;

	@FindBy(xpath="(//td[normalize-space()='ISAM3'])[1]")
	WebElement SLT_Device_3953;

	@FindBy(xpath="(//a[@ui-sref='software.detail({id:slotType.software.id})'][normalize-space()='Lane Enforcement'])[2]")
	WebElement BaseProduct2_3953 ;

	///3870

	@FindBy(xpath="(//a[@ui-sref='software.detail({id:slotType.software.id})'][normalize-space()='License Plate Aggregation'])[1]")
	WebElement BaseProduct1_3870;

	//@FindBy(xpath="(//td[@class='ng-binding'][normalize-space()='Base App'])[21]")
	@FindBy(xpath="//a[contains(text(),'License Plate Aggregation')]/../..//td[contains(text(),'Base App')]")
	WebElement LT_BaseProduct_3870;

	//@FindBy(xpath="(//span)[850]")
	@FindBy(xpath="(//a[contains(text(),'License Plate Aggregation')]/../..//span)[1]")
	WebElement RequiresData1_3870;

	//@FindBy(xpath="(//span)[852]")
	@FindBy(xpath="(//a[contains(text(),'License Plate Aggregation')]/../..//span)[2]")
	WebElement RequiresQTY1_3870;

	//@FindBy(xpath="(//span)[854]")
	@FindBy(xpath="(//a[contains(text(),'License Plate Aggregation')]/../..//span)[3]")
	WebElement RequiresDevice1_3870;

	//@FindBy(xpath="(//span)[856]")
	@FindBy(xpath="(//a[contains(text(),'License Plate Aggregation')]/../..//span)[4]")
	WebElement RequiresServer1_3870;

	//@FindBy(xpath="(//span)[856]")
	@FindBy(xpath="(//a[contains(text(),'License Plate Aggregation')]/../..//span)[5]")
	WebElement SyncToTM1_3870;

	@FindBy(xpath="(//a[@ui-sref='software.detail({id:slotType.software.id})'][normalize-space()='License Plate Aggregation'])[2]")
	WebElement BaseProduct2_3870;

	@FindBy(xpath="//a[contains(text(),'License Plate Aggregation')]/../..//td[contains(text(),'Asset')]")
	WebElement LT_BaseProduct2_3870;

	//@FindBy(xpath="(//span)[863]")
	@FindBy(xpath="(//td[contains(text(),'Asset')]/..//a[contains(text(),'License Plate Aggregation')]/../..//span)[1]")
	WebElement RequiresData2_3870;

	//@FindBy(xpath="(//span)[865]")
	@FindBy(xpath="(//td[contains(text(),'Asset')]/..//a[contains(text(),'License Plate Aggregation')]/../..//span)[2]")
	WebElement RequiresQTY2_3870;

	//@FindBy(xpath="(//span)[867]")
	@FindBy(xpath="(//td[contains(text(),'Asset')]/..//a[contains(text(),'License Plate Aggregation')]/../..//span)[3]")
	WebElement RequiresDevice2_3870;

	//@FindBy(xpath="(//span)[869]")
	@FindBy(xpath="(//td[contains(text(),'Asset')]/..//a[contains(text(),'License Plate Aggregation')]/../..//span)[4]")
	WebElement RequiresServer2_3870;

	//@FindBy(xpath="(//span)[871]")
	@FindBy(xpath="(//td[contains(text(),'Asset')]/..//a[contains(text(),'License Plate Aggregation')]/../..//span)[5]")
	WebElement SyncToTM2_3870;

	@FindBy(xpath="(//i[@class='material-icons small-icon'][normalize-space()='visibility'])[79]")
	WebElement BaseProduct_eyeBtn_3870;

	////create new license Type


	@FindBy(xpath="(//span[normalize-space()='New'])[1]")
	WebElement createNewBtn;

	@FindBy(xpath="(//select[@id='licensetypedropdown'])[1]")
	WebElement enterLicenseType;

	@FindBy(xpath="(//select[@id='softwaredropdown'])[1]")
	WebElement enterBaseProduct;

	@FindBy(xpath="(//input[@id='field_partNumber'])[1]")
	WebElement enterPart;

	@FindBy(xpath="(//span)[61]")
	WebElement requiresData;

	@FindBy(xpath="(//span)[63]")
	WebElement requiresQTY;

	@FindBy(xpath="(//span)[65]")
	WebElement requiresDevice;

	@FindBy(xpath="(//span)[67]")
	WebElement requiresServer;

	@FindBy(xpath="(//span)[69]")
	WebElement syncToTM;

	@FindBy(xpath="(//button[@id='savebutton'])[1]")
	WebElement saveBtn;

	/////3273
	@FindBy(xpath="(//span)[361]")
	WebElement syncToTM1;

	@FindBy(xpath="(//span)[375]")
	WebElement syncToTM2;

	@FindBy(xpath="(//i[contains(text(),'edit')])[22]")
	WebElement editBtn;

	@FindBy(xpath="(//span[@class='ng-binding ng-scope'])[1]")
	WebElement resources;

//----------------Melroy 3849----------------------

	@FindBy(xpath = "//button[@type='button']")
	WebElement Backbtn;

	@FindBy(xpath="//tbody/tr[3]/td[2]")
	WebElement BaseProduct1_3849;

	@FindBy(xpath="//tbody/tr[1]/td[2]")
	WebElement LT_BaseProduct_3849;

	@FindBy(xpath = "//tbody/tr[2]/td[2]")
	WebElement LST_BaseProduct_3849;

	@FindBy(xpath="//tbody/tr[5]/td[2]")
	WebElement RequiresData1_3849;

	@FindBy(xpath="//tbody/tr[6]/td[2]")
	WebElement RequiresQTY1_3849;

	@FindBy(xpath="//tbody/tr[7]/td[2]")
	WebElement RequiresDevice1_3849;

	@FindBy(xpath="//tbody/tr[8]/td[2]")
	WebElement RequiresEcoSystem1_3849;

	@FindBy(xpath="//tbody/tr[9]/td[2]")
	WebElement RequiresServe1_3849;

	@FindBy(xpath="//tbody/tr[10]/td[2]")
	WebElement SyncToTM1_3849;

	@FindBy(xpath = "(//span[text()='License Sub Type'])/../../../..//td[5]")
	List<WebElement> listofLicenseSubType;


	@FindBy(xpath="//tbody/tr[3]/td[2]")
	WebElement BaseProduct2_3849;

	@FindBy(xpath="//tbody/tr[1]/td[2]")
	WebElement LT_BaseProduct2_3849;

	@FindBy(xpath = "//tbody/tr[2]/td[2]")
	WebElement LST_BaseProduct2_3849;

	@FindBy(xpath="//tbody/tr[5]/td[2]")
	WebElement RequiresData2_3849;

	@FindBy(xpath="//tbody/tr[6]/td[2]")
	WebElement RequiresQTY2_3849;

	@FindBy(xpath="//tbody/tr[7]/td[2]")
	WebElement RequiresDevice2_3849;

	@FindBy(xpath="//tbody/tr[8]/td[2]")
	WebElement RequiresEcoSystem2_3849;

	@FindBy(xpath="//tbody/tr[9]/td[2]")
	WebElement RequiresServer2_3849;

	@FindBy(xpath="//tbody/tr[10]/td[2]")
	WebElement SyncToTM2_3849;

	@FindBy(xpath = "(//span[text()='Base Product'])/../../../..//td[3]")
	List<WebElement> licenseBaseName;
	//---------------------------------------------------------------------------
//---------------------------------------------VMM-3277-----------------------------------------


	@FindBy(xpath="//*[text()='New']")
	WebElement ClickNewForCreateLicenseType;

	@FindBy(xpath="//*[@id='licensetypedropdown']")
	WebElement EnterLicenseTypeField;

	@FindBy(xpath="//*[@id='softwaredropdown']")
	WebElement EnterBaseProductField;

	@FindBy(xpath="//*[@id='reqdata']")
	WebElement requiresDeviceCheckbox;

	@FindBy(xpath="//*[text()='Save']")
	WebElement ClickSaveForCreateLicenseType;


	//Rajath VMM-3326--------------------------------------------------------------

	@FindBy(xpath="//span[normalize-space()='New']")
	WebElement Newlicenstypebutton;

	@FindBy(xpath="//select[@id='licensetypedropdown']")
	WebElement EnterLicenseType;

	@FindBy(xpath="//select[@id='softwaredropdown']")
	WebElement EnterBaseproduct;

	@FindBy(xpath="//input[@id='field_partNumber']")
	WebElement Part;

	@FindBy(xpath="//body[1]/div[1]/div[2]/form[1]/div[2]/div[10]/div[1]/div[1]/label[1]/span[1]/span[1]")
	WebElement SynctoTM;

	@FindBy(xpath="//span[normalize-space()='Save']")
	WebElement Savebutton;

	@FindBy(xpath="//span[@class='showHideFilters ng-binding']")
	WebElement licensesshowfilter;

//---------------------------------Nitin------------------------------------------------------------//
		@FindBy(xpath="//span[text()='Sync to TM']")
		WebElement syncToTMHeading;

		@FindBy(xpath="//tr[@ng-repeat='slotType in slotTypes track by slotType.id']//descendant::input[@ng-model='slotType.syncTenantManager']//following-sibling::span[@class='checkbox-material']")
		List<WebElement> checkBoxes;

		@FindBy(xpath="(//td[contains(text(),'Base App')]//parent::tr[@ng-repeat='slotType in slotTypes track by slotType.id']//descendant::a[contains(text(),'Evidence Management')]//ancestor::tr//descendant::td)[9]//descendant::span[@class='check']")
		WebElement requiresServerCheckBox;

		@FindBy(xpath="(//td[contains(text(),'Base App')]//parent::tr[@ng-repeat='slotType in slotTypes track by slotType.id']//descendant::a[contains(text(),'Evidence Management')]//ancestor::tr//descendant::td)[11]//descendant::i[text()='edit']")
		WebElement requiresServerCheckBoxEdit;

		@FindBy(xpath="//input[@id='reqserver']//ancestor::div[@class='checkbox']//descendant::span[@class='check']")
		WebElement insideEditRequiresServerCheckBox;

		@FindBy(xpath = "//a[contains(text(),'Evidence Management')]//ancestor::tr//child::td[@class='ng-binding']")
		List<WebElement> sFNexusSoftwares;

		@FindBy(xpath = "//input[@type='search']")
		WebElement resourcess;

		@FindBy(xpath = "(//td[text()='WH8']//preceding-sibling::td[contains(text(),'Asset')]//parent::tr)[1]//td[11]//button[2]")
		WebElement editt;

		@FindBy(xpath = "//span[@class='close ui-select-match-close']")
		WebElement crosss;

		@FindBy(xpath = "//select[@id='licensesubtypedropdown']")
		WebElement licenseSubTypee;

		@FindBy(xpath = "//div[text()='sharing-controller-api']")
		WebElement sharingApiControllerr;

		@FindBy(xpath = "//tr//td[2]")
		List<WebElement> allLicenseTypeList;

		@FindBy(xpath = "//tr//td[3]//a")
		List<WebElement> allBaseProductList;

		@FindBy(xpath = "//tr//td[5]")
		List<WebElement> allLicenseSubTypeList;

		@FindBy(xpath = "(//span)[65]")
		WebElement requiresDevicee;

		//@FindBy(xpath = "(//td[text()='H2']//preceding-sibling::td[contains(text(),'Asset')]//parent::tr)[1]//td[11]//button[2]")
		@FindBy(xpath = "//td[contains(text(),'Asset')]//following-sibling::td/a[contains(text(),'License Plate Aggregation')]/..//following-sibling::td//button//i[text()='edit']")
		WebElement edittt;

		String edit = "(//td[text()='H2']//preceding-sibling::td[contains(text(),'Asset')]//parent::tr)[1]//td[11]//button[2]";

		@FindBy(xpath = "//input[@type='search']")
		WebElement clickk;

		@FindBy(xpath = "//div[text()='sharing-controller-api']")
		WebElement sharingappcontroller;
		//-----------------------------------Nitin-----------------------------------------------------------------------------------------//

/////3953


	public void verifyLicenceTypeBASE_PRODUCTforSFClearLane(Map<String, String> testData,String licenseType) throws InterruptedException
	{
		scrollToElement("(//td[@class='ng-binding'][normalize-space()='Base App'])[14]");
		//scrollToElement("//td[@class='ng-binding']");
		Thread.sleep(SLEEP_MAX);
		scrollToElement("//td[normalize-space()='Navigator']");
		//scrollToElement("//tbody/tr[40]/td[4]");
		Thread.sleep(SLEEP_MAX);
		String title1= BaseProduct1_3953.getText();
		String LP1=LT_BaseProduct_3953.getText();
		assert title1.equals(testData.get("BaseProduct"));
		assert LP1.equals(testData.get("LicenseType"));
		Thread.sleep(SLEEP_MAX);
}
	public void verifyLicenceTypeDEVICEforSFClearLane(Map<String, String> testData,String licenseType) throws InterruptedException
	{
		 String title2= BaseProduct2_3953.getText();
		    String LP2=LT_Device_3953.getText();
		    //String SLP= SLT_Device_3953.getText();
		    assert title2.equals(testData.get("BaseProduct"));
	    	assert LP2.equals(testData.get("LicenseType"));
	    	 //assert SLP.equals(testData.get("LicenseSubType"));

	 }

	//////3870

	public void verifyLicenceTypeBASE_PRODUCTforSFCognition(Map<String, String> testData)throws InterruptedException
    {
		//(//td[@class='ng-binding'][normalize-space()='Base App'])[21],(//i[contains(text(),'visibility')])[79], (//i[contains(text(),'visibility')])[61]

  	  scrollToElement("(//td[@class='ng-binding'][normalize-space()='Base App'])[14]");
  	  sleepMAX();

	    	  scrollToElement("//td[normalize-space()='Navigator']");
	    	  Thread.sleep(SLEEP_MAX);
	    	  Thread.sleep(SLEEP_MAX);
	    	  Thread.sleep(SLEEP_MAX);


	    	 // waitForElementToBeClickableThenClick(BaseProduct_eyeBtn_3870);
	    	 // BaseProduct_eyeBtn_3870.click();

		    	String title1=BaseProduct1_3870.getText();
		    	String LP1=LT_BaseProduct_3870.getText();
		    	sleepMAX();
		    	Boolean RequiresData1= RequiresData1_3870.isSelected();
		    	Boolean RequiresQTY1=RequiresQTY1_3870.isSelected();
		    	Boolean RequiresDevice1= RequiresDevice1_3870.isSelected();
		    	Boolean RequiresServer1=RequiresServer1_3870.isSelected();
		    	Boolean SyncToTM1=SyncToTM1_3870.isSelected();
//		    	System.out.println(title1);
//		    	System.out.println(LP1);

		    	assert title1.equals(testData.get("BaseProduct"));
		    	assert LP1.equals(testData.get("LicenseType"));
		    	 RequiresData1.equals(testData.get("RequiresData"));
		    	 RequiresQTY1.equals(testData.get("RequiresQTY"));
		    	  RequiresDevice1.equals(testData.get("RequiresDevice"));
		    	 RequiresServer1.equals(testData.get("RequiresServer"));
		    	 SyncToTM1.equals(testData.get("SyncToTM"));
	    	 // System.out.println(testData.get("BaseProduct"));
 	    	  Thread.sleep(SLEEP_MAX);
      	    }

    public void verifyLicenceTypeDEVICEforSFCognition(Map<String, String> testData)throws Exception
    {

		    	String title2=BaseProduct2_3870.getText();
		    	String LP2=LT_BaseProduct2_3870.getText();
		    	Boolean RequiresData2= RequiresData2_3870.isSelected();
		    	Boolean RequiresQTY2=RequiresQTY2_3870.isSelected();
		    	Boolean RequiresDevice2= RequiresDevice2_3870.isSelected();
		    	Boolean RequiresServer2=RequiresServer2_3870.isSelected();
		    	Boolean SyncToTM2=SyncToTM2_3870.isSelected();

//		    	System.out.println(title2);
//                System.out.println(LP2);
		    	assert title2.equals(testData.get("BaseProduct"));
		    	assert LP2.equals(testData.get("LicenseType"));
		    	 RequiresData2.equals(testData.get("RequiresData"));
		    	 RequiresQTY2.equals(testData.get("RequiresQTY"));
		    	  RequiresDevice2.equals(testData.get("RequiresDevice"));
		    	 RequiresServer2.equals(testData.get("RequiresServer"));
		    	 SyncToTM2.equals(testData.get("SyncToTM"));
 	    	    Thread.sleep(SLEEP_MAX);
      	    }
						 public void createLicenseType(Map<String, String> testData)throws InterruptedException
    {

    	waitForElementToBeClickableThenClick(createNewBtn);
		selectListByVisibleText(enterLicenseType, testData.get("LicenseType"));
		selectListByVisibleText(enterBaseProduct, testData.get("BaseProduct"));
		waitForElementToBeClickableThenSendkeys(enterPart, testData.get("Part#"));
		waitForElementToBeClickableThenClick(requiresData);
		waitForElementToBeClickableThenClick(requiresQTY);
		waitForElementToBeClickableThenClick(requiresDevice);
		waitForElementToBeClickableThenClick(requiresServer);
		waitForElementToBeClickableThenClick(syncToTM);
		waitForElementToBeClickableThenClick(saveBtn);
		sleepMAX();
    }

/////////////////3273
public String verifyDESCloudCourierSyncToTM1(Map<String, String> testData) throws InterruptedException
{
	  scrollToElement("(//td[@class='ng-binding'][normalize-space()='Base App'])[8]");
	Boolean TM=syncToTM1.isDisplayed();
	String str=TM.toString();
	return str;
}

public String verifyDESCloudCourierSyncToTM2(Map<String, String> testData) throws InterruptedException
{
	Boolean TM=syncToTM2.isDisplayed();
	String str=TM.toString();
	return str;
}

public String verifyResourses() throws InterruptedException
{
	waitForElementToBeClickableThenClick(editBtn);
	sleepMAX();
	sleepMAX();
	sleepMAX();
	String str=resources.getText();
	return str;
}
//--------------------Melroy 3849-------------------------
public String verifyLicenceTypeBaseProductDH6(Map<String, String> testData) throws InterruptedException
{
	String text=LT_BaseProduct_3849.getText();
	return text;
}

public String verifyDVRIcon(Map<String, String> testData) {
	String str= BaseProduct1_3849.getText();
	return str;
	}

public String verifyLicensesubType_3849(Map<String, String> testData) throws InterruptedException
{
	sleepAvg();
	String text= LST_BaseProduct_3849.getText();
	return text;
}

public String verifyRequiresData_3849(Map<String, String> testData)
{

	String str=RequiresData1_3849.getText();
	return str;
}

public String verifyRequiresQTY1_3849(Map<String, String> testData)
{

	String str=RequiresQTY1_3849.getText();
	return str;
}

public String verifyRequiresDevice_3849(Map<String, String> testData)
{

	String str=RequiresDevice1_3849.getText();
	return str;
}
public String verifyrequiresEcoSystem1_3849(Map<String, String> testData)
{

	String str=RequiresEcoSystem1_3849.getText();
	return str;
}
public String verifyRequireserver_3849(Map<String, String> testData)
{

	String str=RequiresServe1_3849.getText();
	return str;
}
public String verifySyncToTM1_3849(Map<String, String> testData)
{

	String str=SyncToTM1_3849.getText();
	return str;
}

public void clickonBackBtn()
{
	waitForElementToBeClickableThenClick(Backbtn);
}


public String verifyLicenceTypeBaseProductDVRFrimwareDH6(Map<String, String> testData) throws InterruptedException
{	/*
	scrollToElement("(//i[contains(text(),'visibility')])[40]");
	waitForAngularRequestsToFinish();
	scrollToElement("(//i[contains(text(),'visibility')])[47]");
	Thread.sleep(SLEEP_MAX);
	*/
	scrollDown();
	waitForAngularRequestsToFinish();
	scrollDown();
	waitForAngularRequestsToFinish();
	int count=listofLicenseSubType.size();
	for(int i=1; i<count; i++)
	{
		String LSubName=listofLicenseSubType.get(i).getText();
		if(LSubName.equalsIgnoreCase(testData.get("LicenseSubType")))
		{
			System.out.println("License subtype: "+LSubName);
			int j=i;
			System.out.println(j);
			System.out.println("(//i[contains(text(),'visibility')])["+(j+1)+"]");
			scrollTop();
			waitForElementToBeClickableThenClick(driver.findElement(By.xpath(("(//i[contains(text(),'visibility')])["+(j+1)+"]"))));
			//driver.findElement(By.xpath(("(//i[contains(text(),'visibility')])["+(j+1)+"]"))).click();
			waitForAngularRequestsToFinish();

			return LSubName;
		}

	}
	return null;
}

public String verifyLicenceTypeBaseProductDVRFrimwareDH8(Map<String, String> testData) throws InterruptedException
{	/*
	waitForAngularRequestsToFinish();
	scrollToElement("(//i[contains(text(),'visibility')])[40]");
	waitForAngularRequestsToFinish();
	scrollToElement("(//i[contains(text(),'visibility')])[47]");
	waitForAngularRequestsToFinish();
	scrollToElement("(//i[contains(text(),'visibility')])[57]");
	waitForAngularRequestsToFinish();
	scrollToElement("(//i[contains(text(),'visibility')])[75]");
	waitForAngularRequestsToFinish();
	scrollToElement("(//i[contains(text(),'visibility')])[100]");
	waitForAngularRequestsToFinish();
	*/
	waitForAngularRequestsToFinish();
	scrollDown();
	waitForAngularRequestsToFinish();
	scrollDown();
	waitForAngularRequestsToFinish();

	int count=listofLicenseSubType.size();
	for(int i=1; i<count; i++)
	{
		String LSubName=listofLicenseSubType.get(i).getText();
		if(LSubName.equalsIgnoreCase(testData.get("LicenseSubType1")))
		{
			System.out.println(LSubName);
			int j=i;
			scrollToElement("(//i[contains(text(),'visibility')])["+(j+1)+"]");
			System.out.println(j);
			scrollTop();
			waitForElementToBeClickableThenClick(driver.findElement(By.xpath(("(//i[contains(text(),'visibility')])["+(j+1)+"]"))));
			//driver.findElement(By.xpath(("(//i[contains(text(),'visibility')])["+(j+1)+"]"))).click();
			sleepMAX();

			return LSubName;
		}

	}
	return null;
}
public String verifyLicenceTypeBaseProduct_DH8(Map<String, String> testData) throws InterruptedException
{
	String text=LT_BaseProduct2_3849.getText();
	return text;
}

public String verifyDVRIcon_2(Map<String, String> testData) {
	String str= BaseProduct2_3849.getText();
	return str;
	}

public String verifyLicensesubType_3849_2(Map<String, String> testData) throws InterruptedException
{
	sleepAvg();
	String text= LST_BaseProduct2_3849.getText();
	return text;
}

public String verifyRequiresData_3849_2(Map<String, String> testData)
{

	String str=RequiresData2_3849.getText();
	return str;
}

public String verifyRequiresQTY1_3849_2(Map<String, String> testData)
{

	String str=RequiresQTY2_3849.getText();
	return str;
}

public String verifyRequiresDevice_3849_2(Map<String, String> testData)
{

	String str=RequiresDevice2_3849.getText();
	return str;
}
public String verifyrequiresEcoSystem1_3849_2(Map<String, String> testData)
{
	String str=RequiresEcoSystem2_3849.getText();
	return str;
}
public String verifyRequireserver_3849_2(Map<String, String> testData)
{

	String str=RequiresServer2_3849.getText();
	return str;
}
public String verifySyncToTM1_3849_2(Map<String, String> testData)
{

	String str=SyncToTM2_3849.getText();
	return str;
}
//--------------------Melroy 3289-------------------------
public String verifyLicenceTypeBaseProductDESCloudCourier(Map<String, String> testData) throws InterruptedException
{
	scrollToElement("(//i[contains(text(),'visibility')])[40]");
	sleepMAX();
	scrollToElement("(//i[contains(text(),'visibility')])[60]");
	Thread.sleep(SLEEP_MAX);
	scrollToElement("(//i[contains(text(),'visibility')])[40]");
	sleepMAX();
	scrollToElement("(//i[contains(text(),'visibility')])[40]");
	sleepMAX();
	scrollToElement("(//i[contains(text(),'visibility')])[20]");
	int count=licenseBaseName.size();
	for(int i=1; i<count; i++)
	{
		String LSubName=licenseBaseName.get(i).getText();
		if(LSubName.equalsIgnoreCase(testData.get("BaseProduct")))
		{
			System.out.println(LSubName);
			int j=i;
			System.out.println(j);
			sleepMAX();
			String license=driver.findElement(By.xpath("//tbody/tr["+(j+1)+"]/td[2]")).getText();  ////tbody/tr[21]/td[2] //tbody/tr["+(j+1)+"]/td[2]
			return license;
		}

	}
	return null;
}
public String verifyLicenceTypeBaseProductDESCloudCourier2(Map<String, String> testData) throws InterruptedException
{
	int count=licenseBaseName.size();
	for(int i=1; i<count; i++)
	{
		String LSubName=licenseBaseName.get(i).getText();
		if(LSubName.equalsIgnoreCase(testData.get("BaseProduct")))
		{
			System.out.println(LSubName);
			int j=i;
			System.out.println(j);
			sleepMAX();
			String license=driver.findElement(By.xpath("//tbody/tr["+(j+2)+"]/td[2]")).getText();  ////tbody/tr[21]/td[2] //tbody/tr["+(j+1)+"]/td[2]
			return license;
		}

	}
	return null;
}

//----------------------------------------VMM_3277-----------------------------------

		public void createLicenseTypesRequiresDataON(Map<String, String> testData) throws InterruptedException {
			waitForElementToBeClickableThenClick(ClickNewForCreateLicenseType);
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenSendkeys(EnterLicenseTypeField, testData.get("LicenseType"));
			waitForElementToBeClickableThenSendkeys(EnterBaseProductField, testData.get("BaseProduct"));
			waitForElementToBeClickableThenClick(requiresData);


		}

		public void createLicenseTypesRequiresQtyON(Map<String, String> testData) throws InterruptedException {
			waitForElementToBeClickableThenClick(ClickNewForCreateLicenseType);
			sleepMAX();
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenSendkeys(EnterLicenseTypeField, testData.get("LicenseTypeQty"));
			waitForElementToBeClickableThenSendkeys(EnterBaseProductField, testData.get("BaseProduct"));
			waitForElementToBeClickableThenClick(requiresQTY);

		}

		public void clickSaveLicenseType() throws InterruptedException {
			waitForElementToBeClickableThenClick(ClickSaveForCreateLicenseType);
			sleepMAX();
		}


//suryaaa----------------------------VMM3249---------------------------------------

	 public void CreateLicenseType(Map<String, String> testData)throws InterruptedException {
      waitForElementToBeClickableThenClick(createNewBtn);
      selectListByVisibleText(enterLicenseType, testData.get("LicenseType"));
      selectListByVisibleText(enterBaseProduct, testData.get("BaseProduct"));
      waitForElementToBeClickableThenSendkeys(enterPart, testData.get("Part#"));
      waitForElementToBeClickableThenClick(requiresData);
      waitForElementToBeClickableThenClick(requiresQTY);
      waitForElementToBeClickableThenClick(requiresDevice);
      waitForElementToBeClickableThenClick(syncToTM);



     }

	 public void licensetypesave() throws InterruptedException {
		 waitForElementToBeClickableThenClick(saveBtn);
	      sleepMAX();
	    	driver.navigate().refresh();

	 }

		 //Rajath VMM-3326--------------------------------------------------------------
	 public void LicenseTypecreate (Map<String, String> testData)throws InterruptedException {
		 waitForElementToBeClickableThenClick(Newlicenstypebutton);
	      selectListByVisibleText(EnterLicenseType, testData.get("LicenseType"));
	      selectListByVisibleText(EnterBaseproduct, testData.get("BaseProduct"));
	      waitForElementToBeClickableThenSendkeys(Part, testData.get("Part#"));
	      waitForElementToBeClickableThenClick(SynctoTM);
	      Thread.sleep(2000);
	      waitForElementToBeClickableThenClick(Savebutton);
	      sleepMAX();

	 }
	public void clickOnLicensesShowFilter() {
			waitForElementToBeClickableThenClick(licensesshowfilter);

}

//----------------------------------------------Nitin----------------------------------------------------//
			public boolean verifyRequiresServerIsChecked() throws InterruptedException
			{
				scrollToElement("(//td[contains(text(),'Base App')]//parent::tr[@ng-repeat='slotType in slotTypes track by slotType.id']//descendant::a[contains(text(),'Evidence Management')]//ancestor::tr//descendant::td)[9]//descendant::span[@class='check']");
				boolean value = requiresServerCheckBox.isSelected();
				if(value == true)
				{
					return true;
				}
				else
				{
					requiresServerCheckBoxEdit.click();
					insideEditRequiresServerCheckBox.click();
					return true;
				}
			}
			public void verifySyncToTMHeading(Map<String, String> testData) throws InterruptedException
			{
					scrollToElement("//span[text()='Sync to TM']");
					waitForAngularRequestsToFinish();
					String title = syncToTMHeading.getText();
					assert title.equals(testData.get("Text"));
			}

			public boolean verifyCheckBoxesSyncToTM()
			{
				for(WebElement checkbox:checkBoxes)
				{
					if(checkbox.isEnabled())
					{
						return true;
					}
				}
				return false;
			}

			public void createLicenseTypeWithMinimumData(Map<String, String> testData)throws InterruptedException
		    {
				waitForAngularRequestsToFinish();
		    	waitForElementToBeClickableThenClick(createNewBtn);
				selectListByVisibleText(enterLicenseType, testData.get("LicenseType"));
				selectListByVisibleText(enterBaseProduct, testData.get("BaseProduct"));
				waitForElementToBeClickableThenClick(syncToTM);
				waitForElementToBeClickableThenClick(saveBtn);
				waitForAngularRequestsToFinish();
		    }

			public void createLicenseTypeWithResourceData(Map<String, String> testData) throws InterruptedException
			{
				waitForAngularRequestsToFinish();
				waitForElementToBeClickableThenClick(createNewBtn);
				waitForAngularRequestsToFinish();
				selectListByVisibleText(enterLicenseType, testData.get("LicenseType"));
				waitForAngularRequestsToFinish();
				selectListByVisibleText(enterBaseProduct, testData.get("BaseProduct"));
				waitForAngularRequestsToFinish();
				selectListByVisibleText(licenseSubTypee, testData.get("LicenseSubType"));
				waitForAngularRequestsToFinish();
				waitForElementToBeClickableThenClick(syncToTM);
				waitForAngularRequestsToFinish();
				waitForElementToBeClickableThenClick(resourcess);
				waitForAngularRequestsToFinish();
				waitForElementToBeClickableThenClick(sharingApiControllerr);
				waitForAngularRequestsToFinish();
				waitForElementToBeClickableThenClick(saveBtn);
				waitForAngularRequestsToFinish();
			}

			public boolean verifyLicenseTypeWithSFNexusSoftware(Map<String, String> testData)
			{
				scrollToElement("//a[contains(text(),'Evidence Management')]//ancestor::tr//child::td[@class='ng-binding']");
				for(WebElement sFNexusSoftware:sFNexusSoftwares)
				{
					String text = sFNexusSoftware.getText();
					if(text.contains(testData.get("LicenseType")) || text.contains(testData.get("LicenseTypeFirst")) || text.contains(testData.get("LicenseTypeSecond")) || text.contains(testData.get("LicenseTypeThird")))
					{
						return true;
					}
				}
				return false;
			}

			public void searchAndUnassignResourcesToLicenseType(Map<String, String> testData) throws InterruptedException
			{

				waitForAngularRequestsToFinish();
				List<WebElement> visibleTo30 = driver.findElements(By.xpath("(//tr//td[1])[30]"));
				if(visibleTo30.size()>0)
					scrollToElement("(//tr//td[1])[30]");

				waitForAngularRequestsToFinish();

				List<WebElement> visibleTo55 = driver.findElements(By.xpath("(//tr//td[1])[55]"));
				if(visibleTo55.size()>0)
					scrollToElement("(//tr//td[1])[55]");

				waitForAngularRequestsToFinish();

				List<WebElement> visibleTo80 = driver.findElements(By.xpath("(//tr//td[1])[80]"));
				if(visibleTo80.size()>0)
					scrollToElement("(//tr//td[1])[80]");

				waitForAngularRequestsToFinish();

				List<WebElement> visibleTo110 = driver.findElements(By.xpath("(//tr//td[1])[110]"));
				if(visibleTo110.size()>0)
					scrollToElement("(//tr//td[1])[110]");

				System.out.println("All license type Count ="+allLicenseTypeList.size());
				for(int i=0; i<allLicenseTypeList.size();i++)
				{
					String licenseTypeName = allLicenseTypeList.get(i).getText();
					String baseProductName = allBaseProductList.get(i).getText();
					String licenseSubTypeName = allLicenseSubTypeList.get(i).getText();
					if(testData.get("LicenseType").contains(licenseTypeName) && testData.get("BaseProduct").contains(baseProductName) && testData.get("LicenseSubType").contains(licenseSubTypeName))
					{
						System.out.println(allLicenseTypeList.get(i).getText()+"=="+testData.get("LicenseType"));
						System.out.println(allBaseProductList.get(i).getText()+"=="+testData.get("BaseProduct"));
						System.out.println(allLicenseSubTypeList.get(i).getText()+"=="+testData.get("LicenseSubType"));
						scrollToElement("(//tr//td[2])["+i+"]");
						break;
					}
				}
				waitForAngularRequestsToFinish();
				waitForElementToBeClickableThenClick(editt);
				waitForAngularRequestsToFinish();
				waitForElementToBeClickableThenClick(crosss);
				waitForAngularRequestsToFinish();
				waitForElementToBeClickableThenClick(saveBtn);
			}

			public void searchAndAssignResourcesAgainToLicenseType(Map<String, String> testData) throws InterruptedException
			{

				waitForAngularRequestsToFinish();
				List<WebElement> visibleTo30 = driver.findElements(By.xpath("(//tr//td[1])[30]"));
				if(visibleTo30.size()>0)
					scrollToElement("(//tr//td[1])[30]");

				waitForAngularRequestsToFinish();

				List<WebElement> visibleTo55 = driver.findElements(By.xpath("(//tr//td[1])[55]"));
				if(visibleTo55.size()>0)
					scrollToElement("(//tr//td[1])[55]");

				waitForAngularRequestsToFinish();

				List<WebElement> visibleTo80 = driver.findElements(By.xpath("(//tr//td[1])[80]"));
				if(visibleTo80.size()>0)
					scrollToElement("(//tr//td[1])[80]");

				waitForAngularRequestsToFinish();

				List<WebElement> visibleTo110 = driver.findElements(By.xpath("(//tr//td[1])[110]"));
				if(visibleTo110.size()>0)
					scrollToElement("(//tr//td[1])[110]");

				waitForAngularRequestsToFinish();

				System.out.println("All license type Count ="+allLicenseTypeList.size());
				for(int i=0; i<allLicenseTypeList.size();i++)
				{
					String licenseTypeName = allLicenseTypeList.get(i).getText();
					String baseProductName = allBaseProductList.get(i).getText();
					String licenseSubTypeName = allLicenseSubTypeList.get(i).getText();
					if(testData.get("LicenseType").contains(licenseTypeName) && testData.get("BaseProduct").contains(baseProductName) && testData.get("LicenseSubType").contains(licenseSubTypeName))
					{
						System.out.println(allLicenseTypeList.get(i).getText()+"=="+testData.get("LicenseType"));
						System.out.println(allBaseProductList.get(i).getText()+"=="+testData.get("BaseProduct"));
						System.out.println(allLicenseSubTypeList.get(i).getText()+"=="+testData.get("LicenseSubType"));
						scrollToElement("(//tr//td[2])["+i+"]");
						break;
					}
				}
				waitForAngularRequestsToFinish();
				waitForElementToBeClickableThenClick(editt);
				waitForElementToBeClickableThenClick(clickk);
				waitForElementToBeClickableThenClick(sharingappcontroller);
				waitForElementToBeClickableThenClick(saveBtn);
			}

			public void searchLicenseTypeWhichIsCreated(Map<String, String> testData) throws InterruptedException
			{

				waitForAngularRequestsToFinish();
				/*
				List<WebElement> visibleTo30 = driver.findElements(By.xpath("(//tr//td[1])[30]"));
				if(visibleTo30.size()>0)
					scrollToElement("(//tr//td[1])[30]");

				waitForAngularRequestsToFinish();

				List<WebElement> visibleTo55 = driver.findElements(By.xpath("(//tr//td[1])[55]"));
				if(visibleTo55.size()>0)
					scrollToElement("(//tr//td[1])[55]");

				waitForAngularRequestsToFinish();

				List<WebElement> visibleTo80 = driver.findElements(By.xpath("(//tr//td[1])[80]"));
				if(visibleTo80.size()>0)
					scrollToElement("(//tr//td[1])[80]");

				waitForAngularRequestsToFinish();

				List<WebElement> visibleTo110 = driver.findElements(By.xpath("(//tr//td[1])[110]"));
				if(visibleTo110.size()>0)
					scrollToElement("(//tr//td[1])[110]");

				waitForAngularRequestsToFinish();

				List<WebElement> visibleTo130 = driver.findElements(By.xpath("(//tr//td[1])[130]"));
				if(visibleTo130.size()>0)
					scrollToElement("(//tr//td[1])[130]");

				waitForAngularRequestsToFinish();

				List<WebElement> visibleTo156 = driver.findElements(By.xpath("(//tr//td[1])[156]"));
				if(visibleTo156.size()>0)
					scrollToElement("(//tr//td[1])[156]");
				*/
				List<WebElement> visibleList = driver.findElements(By.xpath("//tr//td[1]"));
				scrollDown();
				waitForAngularRequestsToFinish();
				List<WebElement> visibleList2 = driver.findElements(By.xpath("//tr//td[1]"));
				for(int i=0; i<=10 ; i++) {

				if(visibleList2.size()>visibleList.size())
				{
				scrollDown();
				sleepMin();
				//waitForAngularRequestsToFinish();
				visibleList = visibleList2;
				visibleList2 = driver.findElements(By.xpath("//tr//td[1]"));
				}
				else
					break;
				}
				/*for(int i=0; i<allLicenseTypeList.size();i++)
				{
					String licenseTypeName = allLicenseTypeList.get(i).getText();
					String baseProductName = allBaseProductList.get(i).getText();
					String licenseSubTypeName = allLicenseSubTypeList.get(i).getText();
					if(testData.get("LicenseType").contains(licenseTypeName) && testData.get("BaseProduct").contains(baseProductName) && testData.get("LicenseSubType").contains(licenseSubTypeName))
					{
						System.out.println(allLicenseTypeList.get(i).getText()+"=="+testData.get("LicenseType"));
						System.out.println(allBaseProductList.get(i).getText()+"=="+testData.get("BaseProduct"));
						System.out.println(allLicenseSubTypeList.get(i).getText()+"=="+testData.get("LicenseSubType"));
						scrollToElement("(//tr//td[2])["+i+"]");
						break;
					}
				}*/
				scrollTop();
				waitForElementToBeClickableThenClick(edittt);
				waitForElementToBeClickableThenClick(saveBtn);
				waitForAngularRequestsToFinish();
				driver.navigate().refresh();
			}
			//---------------------------------------------Nitin-----------------------------------------------------------------------------//
	////// Naincy

			public boolean verifyLicenseType(Map<String, String> testData) throws InterruptedException
			{

        for(int i=0; i<allLicenseTypeList.size();i++)
        {
          String licenseTypeName = allLicenseTypeList.get(i).getText();
          String baseProductName = allBaseProductList.get(i).getText();
          String licenseSubTypeName = allLicenseSubTypeList.get(i).getText();
          if(testData.get("LicenseType").contains(licenseTypeName) && testData.get("BaseProduct").contains(baseProductName) && testData.get("LicenseSubType").contains(licenseSubTypeName))
          {
            System.out.println(allLicenseTypeList.get(i).getText()+"=="+testData.get("LicenseType"));
            System.out.println(allBaseProductList.get(i).getText()+"=="+testData.get("BaseProduct"));
            System.out.println(allLicenseSubTypeList.get(i).getText()+"=="+testData.get("LicenseSubType"));
            return true;
          }

        }
        return false;

			}




}
