package safefleetLM.pageobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dev.failsafe.internal.util.Assert;
import safefleetLM.componentgroups.ReusableLibrary;

public class DeviceTypesPage extends ReusableLibrary {

	WebDriver driver;

	public DeviceTypesPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}




	@FindBy(xpath="//*[@id='device_new_btn']/span")
	WebElement systemAdminTab;

	@FindBy(id="field_name")
	WebElement nameInputTxt;

	@FindBy(xpath="//div[@class='ng-scope']/input[@type='text']")
	WebElement custSearchTxt;

	@FindBy(xpath="//div[@class='ui-grid-canvas']")
	WebElement custTable;

	//(//span)[185]
	@FindBy(xpath="(//td[normalize-space()='ISAM3'])[1]")
	WebElement ISAM3Device;

	@FindBy(xpath="(//span)[183]")
	WebElement ISAM3RequireDeviceID;

	@FindBy(xpath="(//span)[185]")
	WebElement ISAM3RequireDeviceSetting;

	//---------------------------------------------------------------VMM_3286-------------------------------------------------------------

	@FindBy(xpath="//*[text()='New']")
	WebElement DeviceTypesNewBtnForCreate;

	@FindBy(xpath= "//*[@id='field_name']")
	WebElement EnterDeviceTypeNameField;

	@FindBy(xpath= "(//*[@class='check'])[2]")
	WebElement CheckBoxBtnDeviceType;

	@FindBy(xpath= "//*[text()='Save']")
	WebElement ClickDeviceTypeSave;




	@FindBy(xpath= "//div[@id='mm-0']/div[2]/div/div[2]/jh-alert/div/div/div/div/pre")
	WebElement DevicesTypeCreatedPopUp;

	int j;
	@FindBy(xpath="//i[text()='delete'][j]")
	WebElement indexofDelete;

	@FindBy(xpath="//span[text()='Cancel']/../../button[2]/span")
	WebElement deleteConfirmation;

	@FindBy(xpath="//span[text()='Name']/../../../..//td")
	List<WebElement> listOfNames;

	//---------------------------------------------------------Melroy VMM-3849---------------------------------

	String scrolltoDevice1="//td[normalize-space()='DH6']";


	@FindBy(xpath = "//tbody/tr[1]/td[2]")
	WebElement DeviceDH6;

	@FindBy(xpath = "//tbody/tr[3]/td[2]")
	WebElement DeviceIDDH6;

	@FindBy(xpath = "//tbody/tr[4]/td[2]")
	WebElement ImportIDDH6;

	@FindBy(xpath = "//tbody/tr[5]/td[2]")
	WebElement RequiredIDDH6;

	@FindBy(xpath = "//tbody/tr[5]/td[2]")
	WebElement DeviceSettingDH6;

	String scrolltoDevice2="//td[normalize-space()='DH8']";

	@FindBy(xpath ="//tbody/tr[1]/td[2]")
	WebElement DeviceDH8;

	@FindBy(xpath = "//tbody/tr[3]/td[2]")
	WebElement DeviceIDDH8;

	@FindBy(xpath = "//tbody/tr[4]/td[2]")
	WebElement ImportIDDH8;

	@FindBy(xpath = "//tbody/tr[5]/td[2]")
	WebElement RequiredIDDH8;

	@FindBy(xpath = "//tbody/tr[5]/td[2]")
	WebElement DeviceSettingDH8;

	@FindBy(xpath = "//span[normalize-space()='Name']/../../../..//td[1]")
	List<WebElement> DeviceName;

	@FindBy(xpath = "//button[@type='button']")
	WebElement backBTn;

	//----------------------------------------------------------------------------------------------


	//Bhanu-----------------------VMM_3410---------------------------------------------------------

	@FindBy(xpath="//tr//td[1]")
	List<WebElement> allDeviceTypesList;

	@FindBy(xpath="//input[@name='deviceIdLabel']")
	WebElement DeviceIdLabelTextBox;

	@FindBy(xpath="//input[@id='requiresSettingsCheckbox']/..//span[@class='check']")
	WebElement RequiresDeviceSettingCheckbx;

	@FindBy(xpath="//pre[@class='ng-binding ng-scope']")
	WebElement SavePopup;

	@FindBy(xpath="//td[text()='Test100']/../td[8]//button//i[text()='delete']")
	WebElement deletePerticularDevicetype;

	@FindBy(xpath="//pre[@class='ng-binding ng-scope']")
	WebElement deleteAlertMsg;


	//----------------Sunilkumar(VMM3251)----------------
	@FindBy(xpath = "//div[6]//div[1]//div[1]//label[1]//span[1]//span[1]")
	WebElement Requiresdevicetypecheckbox;



	//----------------------Sunilkumar(VMM3733)-----------------------------------
	@FindBy(xpath = "//div[5]//div[1]//div[1]//label[1]//span[1]//span[1]")
	WebElement RequiresdeviceIDcheckbox;



	//Rajath VMM-3492----------------------------------------------------
	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement devicesavebutton;

	@FindBy(xpath = "//input[@id='requiresSettingsCheckbox']/..//span[@class='check']")
	WebElement Checkboxrequired;




	public Map<String, String> DeviceTypeConfigValidation(Map<String, String> testData, String deviceType){

		Map<String, String> deviceDetails =new HashMap<String,String>();

		String deviceTypeXpath = "//*[text()='"+deviceType+"']";

		String cradlepointXpath = "//*[text()='Cradlepoint']";

		scrollToElement(cradlepointXpath);

		scrollDown();
		waitForAngularRequestsToFinish();
		scrollDown();
		waitForAngularRequestsToFinish();
		scrollTop();

		String deviceIDLabel = getWebelementText(driver.findElement(By.xpath(deviceTypeXpath +"/following-sibling::td[2]")));

		//Boolean requiresDeviceID = driver.findElement(By.xpath(deviceTypeXpath +"/following-sibling::td[4]//input")).isSelected();

		Boolean requiresDeviceSettings = driver.findElement(By.xpath(deviceTypeXpath +"/following-sibling::td[4]//input")).isSelected();

		//System.out.println(deviceIDLabel + " " + requiresDeviceID + " "+ requiresDeviceSettings);

		deviceDetails.put("deviceIDLabel", deviceIDLabel);

		//deviceDetails.put("requiresDeviceID", String.valueOf(requiresDeviceID));

		deviceDetails.put("requiresDeviceSetting", String.valueOf(requiresDeviceSettings));

		return deviceDetails;

	}
	public void DeviceTypeConfigValidationforISAM3(Map<String, String> testData)
	{


		scrollToElement("(//td[normalize-space()='ISAM3'])[1]");

		String deviceIDLabel = getWebelementText(ISAM3Device);

		Boolean requiresDeviceID=ISAM3RequireDeviceID.isSelected();
		Boolean requiresDeviceSettings=ISAM3RequireDeviceSetting.isSelected();









	}
	///3953

	public String ValidateDeviceTypeName(Map<String, String> testData)
	{


		scrollToElement("(//td[normalize-space()='Flashback'])[1]");

		String deviceIDLabel = getWebelementText(ISAM3Device);
		return deviceIDLabel;

	}
	public String ValidateDeviceTypeSetting(Map<String, String> testData)
	{
		Boolean requiresDeviceSettings=ISAM3RequireDeviceSetting.isSelected();
		String str=requiresDeviceSettings.toString();
		return str;
	}
	public String ValidateDeviceID(Map<String, String> testData)
	{
		Boolean requiresDeviceID=ISAM3RequireDeviceID.isSelected();
		String str=requiresDeviceID.toString();
		return str;
	}





	//surya---------------------------------------------------------------VMM_3286-------------------------------------------------------------




	public void createNewDeviceType(Map<String, String> testData) throws InterruptedException {
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(DeviceTypesNewBtnForCreate);
		waitForElementToBeClickableThenSendkeys(EnterDeviceTypeNameField, testData.get("Name"));
		waitForElementToBeClickableThenClick(CheckBoxBtnDeviceType);

	}

	public void SaveDeviceType(Map<String, String> testData) throws InterruptedException {

		waitForElementToBeClickableThenClick(ClickDeviceTypeSave);
		waitForAngularRequestsToFinish();

	}



	public String VerifyDeviceTypeCreated() {
		String DTstatus = getWebelementText(DevicesTypeCreatedPopUp);
		if(DTstatus!=null)
			return DTstatus;
		else
			return null;

	}

	public void verifyDeviceDeleted(Map<String, String> testData) throws InterruptedException
	{
		sleepMin();
		String scro1="(//i[text()='visibility'])[20]";
		sleepMAX();
		String scro2="(//i[text()='visibility'])[40]";
		sleepMAX();
		String scro3="(//i[text()='visibility'])[50]";
		scrollToElement(scro1);
		sleepMAX();
		scrollToElement(scro2);
		sleepMAX();
		scrollToElement(scro3);
		int count = listOfNames.size();
		for (int i=0;i<count;i++)
		{
			String CName = listOfNames.get(i).getText();
			if(CName.equalsIgnoreCase(testData.get("Name")))
			{
				System.out.println(CName);
				int k=i;
				System.out.println(k);
				driver.findElement(By.xpath("(//i[text()='delete'])["+(k-342)+"]")).click();
				sleepMin();
				waitForElementToBeClickableThenClick(deleteConfirmation);
				break;
			}
		}
	}

	//--------------------------Melroy VMM-3849------------------------------

	public String verifyDeviceName(Map<String, String> testData) throws InterruptedException
	{
		scrollDown();
		waitForAngularRequestsToFinish();
		int count=DeviceName.size();
		for(int i=1; i<count; i++)
		{
			String DName=DeviceName.get(i).getText();
			if(DName.equalsIgnoreCase(testData.get("Name")))
			{
				System.out.println(DName);
				//int j=i;
				//System.out.println(j);
				scrollTop();
				waitForElementToBeClickableThenClick(driver.findElement(By.xpath(("(//i[contains(text(),'visibility')])["+(i+1)+"]"))));
				//driver.findElement(By.xpath(("(//i[contains(text(),'visibility')])["+(j+1)+"]"))).click();
				//sleepMAX();
        waitForAngularRequestsToFinish();

				return DName;
			}

		}
		return null;
	}

  public String getDeviceTypeName(Map<String, String> testData) throws InterruptedException
  {
    int count=DeviceName.size();
    for(int i=1; i<count; i++)
    {
      String DName=DeviceName.get(i).getText();
      if(DName.equalsIgnoreCase(testData.get("Name")))
      {
        System.out.println(DName);
        return DName;
      }

    }
    return null;
  }
	public String verifyDeviceTypeDH6(Map<String, String> testData) throws InterruptedException
	{
		//scrollToElement(scrolltoDevice1);
		sleepAvg();
		String text=DeviceDH6.getText();
		return text;
	}

	public String verifyDeviceIDofDH6(Map<String, String> testData) throws InterruptedException
	{
		sleepAvg();
		String text=DeviceIDDH6.getText();
		return text;
	}

	public String verifyImportIDDH6(Map<String, String> testData)
	{
		String text=ImportIDDH6.getText();
		return text;
	}
	public String verifyRequiredIDDH6(Map<String, String> testData)
	{

		String str=RequiredIDDH6.getText();
		return str;
	}

	public String verifyDeviceSettingDH8(Map<String, String> testData)
	{

		String str=DeviceSettingDH6.getText();
		return str;
	}
	public void clickonBackBtn()
	{
		waitForElementToBeClickableThenClick(backBTn);
	}

	public String verifydeviceNameDH8(Map<String, String> testData) throws InterruptedException
	{
		int count=DeviceName.size();
		for(int i=1; i<count; i++)
		{
			String DName=DeviceName.get(i).getText();
			if(DName.equalsIgnoreCase(testData.get("Name1")))
			{
				System.out.println(DName);
				int j=i;
				System.out.println(j);
				scrollTop();
				waitForElementToBeClickableThenClick(driver.findElement(By.xpath(("(//i[contains(text(),'visibility')])["+(j+1)+"]"))));
				//driver.findElement(By.xpath(("(//i[contains(text(),'visibility')])["+(j+1)+"]"))).click();
				sleepMAX();
				return DName;
			}

		}
		return null;
	}
	public String verifyDeviceTypeDH8(Map<String, String> testData) throws InterruptedException
	{
		//scrollToElement(scrolltoDevice2);
		sleepAvg();
		String text=DeviceDH8.getText();
		return text;
	}

	public String verifyDeviceIDofDH8(Map<String, String> testData) throws InterruptedException
	{
		sleepAvg();
		String text=DeviceIDDH8.getText();
		return text;
	}

	public String verifyImportIDDH8(Map<String, String> testData)
	{

		String str=ImportIDDH8.getText();
		return str;
	}
	public String verifyRequiredIDDH8(Map<String, String> testData)
	{

		String str=RequiredIDDH8.getText();
		return str;
	}
	public String verifyDeviceSettingDH6(Map<String, String> testData)
	{

		String str=DeviceSettingDH8.getText();
		return str;
	}
	//------------------------------------------------------------------------------

	///Bhanu-------------------------VMM_3410----------------------------------------------------------

	public String verifySettingStatusDeviceTypes(List<String> deviceTypeList) throws InterruptedException {

		waitForAngularRequestsToFinish();
		/*
		List<WebElement> visibleTo30 = driver.findElements(By.xpath("(//tr//td[1])[30]"));
		if(visibleTo30.size()>0)
			scrollToElement("(//tr//td[1])[30]");

		waitForAngularRequestsToFinish();

		List<WebElement> visibleTo55 = driver.findElements(By.xpath("(//tr//td[1])[50]"));
		if(visibleTo55.size()>0)
			scrollToElement("(//tr//td[1])[55]");
		*/
		for(int i=1; i<=3; i++) {
			scrollDown();
			waitForAngularRequestsToFinish();
		}

		int countAll= allDeviceTypesList.size();
		int countOfDeviceEnabled=deviceTypeList.size();

		ArrayList<String> List=new ArrayList<>();
		for(int i=0;i<countAll-1;i++)
		{
			String Name = allDeviceTypesList.get(i).getText();
			//System.out.println(Name);
			List.add(Name);
		}


		int Pass=0,Fail=0;

		for(int i=0; i<=countOfDeviceEnabled-1; i++)
		{
			String status1 = driver.findElement(By.xpath("//td[text()='"+deviceTypeList.get(i)+"']/../td[5]//input")).getAttribute("aria-checked");

			//	System.out.println(status1);
			if(status1.equals("true"))
			{
				Pass++;
				//System.out.println("Have device setting :"+deviceTypeList.get(i));
			}
			else
			{
				//System.out.println("Dont Have : === "+deviceTypeList.get(i));
				Fail++;
			}
		}
		//System.out.println(Pass+" "+Fail);
		if(Fail+Pass==countOfDeviceEnabled)
			return "PASS";
		else
			return "FAIL";
	}
	public void createDeviceType(Map<String, String> testData) throws InterruptedException {
		waitForElementToBeClickableThenClick(DeviceTypesNewBtnForCreate);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(EnterDeviceTypeNameField, testData.get("Name"));
		sleepMin();
		waitForElementToBeClickableThenSendkeys(DeviceIdLabelTextBox, testData.get("DeviceIDLabel"));
		if(testData.get("RequiresDeviceSetting").equalsIgnoreCase("TRUE"))
		{
			waitForElementToBeClickableThenClick(RequiresDeviceSettingCheckbx);
		}
	}
	public String saveDeviceType()
	{
		waitForElementToBeClickableThenClick(ClickDeviceTypeSave);
		String status = SavePopup.getText();
		return status;
	}
	public String deleteDeviceType(Map<String, String> testData) throws InterruptedException {

		waitForAngularRequestsToFinish();
		scrollTillEnd(".table-responsive.well");
		waitForAngularRequestsToFinish();

		for(int i=0; i<allDeviceTypesList.size()-1;i++)
		{
			String DeviceTypeName = allDeviceTypesList.get(i).getText();

			if(testData.get("Name").equalsIgnoreCase(DeviceTypeName))
			{
				//System.out.println("Element number ="+i);
				System.out.println(allDeviceTypesList.get(i).getText()+"=="+testData.get("Name"));
				scrollToElement("(//tr//td[1])["+(i-1)+"]");
				break;
			}
		}
		WebElement deleteBtnPerticularName = driver.findElement(By.xpath("//td[text()='"+testData.get("Name")+"']/..//i[text()='delete']"));

		//sleepMin();
		waitForElementToBeClickableThenClick(deleteBtnPerticularName);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(deleteConfirmation);
		String message =deleteAlertMsg.getText();

		return message;
	}

	//VMM_4439
	public ArrayList<String> getAllDeviceTyps() throws InterruptedException {

		waitForAngularRequestsToFinish();
		/*
		List<WebElement> visibleTo30 = driver.findElements(By.xpath("(//tr//td[1])[30]"));
		if(visibleTo30.size()>0)
			scrollToElement("(//tr//td[1])[30]");

		waitForAngularRequestsToFinish();

		List<WebElement> visibleTo55 = driver.findElements(By.xpath("(//tr//td[1])[50]"));
		if(visibleTo55.size()>0)
			scrollToElement("(//tr//td[1])[55]");
	*/
		scrollDown();
		waitForAngularRequestsToFinish();
		scrollDown();
		waitForAngularRequestsToFinish();
		scrollDown();
		waitForAngularRequestsToFinish();

		int countAll= allDeviceTypesList.size();
		ArrayList<String> List=new ArrayList<>();

		for(int i=0;i<countAll;i++)
		{
			String Name = allDeviceTypesList.get(i).getText();
			//System.out.println(Name);
			List.add(Name);
		}


		return List;
	}


	///*****************************






	//-----------------Sunilkumar---------------VMM3251-------------------
	public void createnewdevicetype(Map<String, String> testData) throws InterruptedException {
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(DeviceTypesNewBtnForCreate);
		waitForElementToBeClickableThenSendkeys(EnterDeviceTypeNameField, testData.get("Name"));
		sleepMin();
		waitForElementToBeClickableThenClick(Requiresdevicetypecheckbox);
		sleepMin();
		waitForElementToBeClickableThenClick(ClickDeviceTypeSave);
		waitForAngularRequestsToFinish();

	}

	public String deleteDeviceType1(Map<String, String> testData) throws InterruptedException {
		sleepMin();
		scrollToElement("(//tr//td[1])[30]");
		sleepMin();
		scrollToElement("(//tr//td[1])[50]");
		sleepMin();
		WebElement deleteBtnPerticularName = driver.findElement(By.xpath("//td[text()='"+testData.get("Name")+"']/../td[8]//button//i[text()='delete']"));
		scrollToElement("deleteBtnPerticularName");
		sleepMin();
		waitForElementToBeClickableThenClick(deleteBtnPerticularName);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(deleteConfirmation);
		String message =deleteAlertMsg.getText();
		System.out.println(message);
		return message;
	}

	//-----------------------Sunilkumar(VMM3733)-----------------------------------
	public void createDeviceType1(Map<String, String> testData) {
		waitForElementToBeClickableThenClick(DeviceTypesNewBtnForCreate);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(EnterDeviceTypeNameField, testData.get("Name"));
		waitForElementToBeClickableThenSendkeys(DeviceIdLabelTextBox, testData.get("DeviceIDLabel"));
		if(testData.get("RequiresDeviceSetting").trim().equalsIgnoreCase("TRUE"))
		{
			waitForElementToBeClickableThenClick(RequiresDeviceSettingCheckbx);
		}
		/*
		if (testData.get("RequiresDeviceID").equalsIgnoreCase("TRUE"))
		{
			waitForElementToBeClickableThenClick(RequiresdeviceIDcheckbox);
		}*/
	}



	//Rajath VMM-3492----------------------------------------------------
	public void DeviceTypeCrete (Map<String, String> testData) throws InterruptedException {
		waitForElementToBeClickableThenClick(DeviceTypesNewBtnForCreate);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(EnterDeviceTypeNameField, testData.get("Name"));
		sleepMin();
		waitForElementToBeClickableThenClick(Checkboxrequired);
		sleepMin();
	}

	public void clickOnDeviceTypeSave () throws InterruptedException {
		waitForElementToBeClickableThenClick(devicesavebutton);
		sleepMin();

	}


	public String TiedDevicetypeDelete (Map<String, String> testData) throws InterruptedException {
		waitForAngularRequestsToFinish();
		//scrollToElement("(//tr//td[1])[30]");
		//sleepMin();
		//scrollToElement("(//tr//td[1])[50]");
		//sleepMin();

		scrollDown();
		sleepMin();
		System.out.println("Count of all Devices :"+allDeviceTypesList.size());

		for(int i=0; i<allDeviceTypesList.size()-1;i++)
		{
			String DeviceTypeName = allDeviceTypesList.get(i).getText();

			if(testData.get("Name").equalsIgnoreCase(DeviceTypeName))
			{
				System.out.println("Element number ="+i);
				System.out.println(allDeviceTypesList.get(i).getText()+"=="+testData.get("Name"));
				scrollToElement("(//tr//td[1])["+i+"]");
				break;
			}
		}
		WebElement deleteBtnPerticularName = driver.findElement(By.xpath("//td[text()='"+testData.get("Name")+"']/..//i[text()='delete']"));
		sleepMin();
		waitForElementToBeClickableThenClick(deleteBtnPerticularName);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(deleteConfirmation);
		String message =deleteAlertMsg.getText();
		System.out.println(message);
		return message;
	}

////////////////// Naincy

	public void verifyNH16andNH16KDevice() throws InterruptedException
	{
		sleepMin();
		scrollToElement("(//tr//td[1])[30]");
		sleepMin();
		scrollToElement("(//tr//td[1])[40]");
		sleepMin();
	}

	public void verifyTH8andTH12Device() throws InterruptedException
	{

		scrollToElement("(//tr//td[1])[66]");
		sleepMin();
	}

}
