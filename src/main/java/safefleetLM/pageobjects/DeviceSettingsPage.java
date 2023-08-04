package safefleetLM.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import safefleetLM.componentgroups.ReusableLibrary;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeviceSettingsPage extends ReusableLibrary {

WebDriver driver;

	public DeviceSettingsPage(WebDriver driver)  {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	Map<String,String> deviceConfigDetails = new HashMap<String,String>();

	@FindBy(xpath="//*[@id='mm-0']/div[2]/div/div[2]/div[2]/table/thead/tr/th[3]/export/i")
	WebElement deviceSettingsExportBtn;

	@FindBy(xpath="//*[@id='field_fleet_id']/div[1]/span")
	WebElement tenantIDTxt;

	@FindBy(xpath="//*[@id='field_softwareGroup']")
	WebElement ecosystemTxt;

	@FindBy(xpath="//*[@id='field_fleet_id']/input[1]")
	WebElement ecosystemInp;

	@FindBy(xpath="//table[@class='table table-striped']//*[text()='f23'][1]/parent::tr")
	WebElement deviceSettingRow;

	@FindBy(xpath="//table[@class='table table-striped']//*[text()='f23'][1]/parent::tr/td[3]/button[2]")
	WebElement editDeviceSettingBtn;
	//table[@class='table table-striped']//*[text()='f23'][1]/parent::tr/td[3]/button[3]

	//sav

	@FindBy(xpath="(//i[text()='edit'])[1]")
	WebElement editBtn;

	@FindBy(xpath="(//i[text()='delete'])[1]")
	WebElement deleteBtn;

	@FindBy(xpath="//table[@class='table table-striped']//*[text()='f23'][1]/parent::tr/td[3]/button[3]")
	WebElement deleteDeviceSettingBtn;

	@FindBy(xpath="//table[@class='table table-striped']//*[text()='f23']")
	WebElement deviceSettingNamelbl;

	@FindBy(xpath="//*[@id='field_name_device']")
	WebElement deviceSettingNameTxt;

	@FindBy(xpath="//*[@id='jsonIdmsgtimer']")
	WebElement configMsgSendTimerTxt;

	@FindBy(xpath="//*[@id='jsonIdpostimer']")
	WebElement configMsgPostTimerTxt;

	@FindBy(xpath="//*[@id='jsonIdackmsgto']")
	WebElement configAckReqMsgTimerTxt;

	@FindBy(xpath="//*[@id='jsonIdhostport']")
	WebElement configFleetServerPortTxt;

	@FindBy(xpath="//*[@id='jsonIdhostip']")
	WebElement configFleetServerHostTxt;

	@FindBy(xpath="//*[@type='submit']")
	WebElement saveDeviceSettingBtn;

	@FindBy(xpath="(//table[@class='table table-bordered table-hover table-striped']//tbody)[1]/tr[1]/td[2]")
	WebElement track_recentActionlbl;

	@FindBy(xpath="(//table[@class='table table-bordered table-hover table-striped']//tbody)[1]/tr[1]/td[3]")
	WebElement track_recentVersionlbl;

	@FindBy(xpath="(//table[@class='table table-bordered table-hover table-striped']//tbody)[1]/tr[1]/td[4]/table//tr[2]/td/span")
	WebElement track_deviceSettingNamelbl;

	@FindBy(xpath="(//table[@class='table table-bordered table-hover table-striped']//tbody)[1]/tr[1]/td[4]/table//tr[3]/td/span")
	WebElement track_changeNoteslbl;


	@FindBy(xpath="(//table[@class='table table-bordered table-hover table-striped']//tbody)[1]/tr[1]/td[4]/table//tr[4]/td/span")
	WebElement track_deviceSettingTemplatelbl;


	@FindBy(xpath="//*[@class='btn btn-primary btn-raised btn-create']")
	WebElement createNewDeviceSettingBtn;

	@FindBy(xpath="//*[@id='field_name_device']")
	WebElement deviceSettingName;

	@FindBy(xpath="//*[@id='field_deviceType']")
	WebElement deviceTypeDrp;

	@FindBy(xpath="//*[@type='submit']")
	WebElement newDeviceSettingSaveBtn;

	@FindBy(xpath="//*[@class='modal-footer']/button[2]")
	WebElement deleteDeviceSettingPopupBtn;




//surya-------------------------------------VM3377----------------------------------------------------------

	@FindBy(xpath="//*[contains(text(),'Show Filters')]")
	WebElement showFilterBtn;

	@FindBy(xpath="//*[@class='showHideFilters ng-binding']")
	WebElement showFilterBtn2;

	@FindBy(xpath="//select[@class='form-control fields-select ng-pristine ng-untouched ng-valid']")
	WebElement clickshowFilterTypeForName;

	@FindBy(xpath="//select[@class='form-control conditions-select ng-pristine ng-untouched ng-valid']")
	WebElement SelectConditionType;

	@FindBy(xpath="//input[@type='text']")
	WebElement passingshowFilterValueForName;

	@FindBy(xpath="//div[@class='filterButtons']//button[@class='btn btn-primary btn-raised']")
	WebElement clickfilter;

	@FindBy(xpath="(//*[@class='table table-striped']/tbody/tr/td)[1]")
	WebElement resulttablelogin;

	@FindBy(xpath="//i[text()='delete']")
	WebElement clickDeleteIcon;

	@FindBy(xpath="//*[@class='btn btn-info']/*[text()='Delete']")
	WebElement ClickDeletePopup;

	@FindBy(xpath="(//*[text()='Clear'])[2]")
	WebElement ClickClearBtnSF;

	@FindBy(xpath="//*[contains(text(),'Filter by')]")
	WebElement SelectFilter;

	@FindBy(xpath="//div[@id='mm-0']/div[2]/div/div[2]/div[2]/jh-alert/div/div/div/div/pre")
	WebElement alert;

	@FindBy(xpath="//*[text()='visibility']")
	WebElement visiblityIcon;

	@FindBy(xpath="//*[@id=\"settingsSearch\"]")
	WebElement Searchfleet;

	@FindBy(xpath="(//*[contains(text(),'Server IP')])[1]")
	WebElement verifyfleetserverIP;

	@FindBy(xpath="(//*[contains(text(),'Server Port')])[1]")
	WebElement verifyfleetserverPort;

	@FindBy(xpath="//*[text()='Back']")
	WebElement ClickBackAfterView;

	@FindBy(xpath="//*[@class='material-icons small-icon'and text()='edit']")
	WebElement ClickEditDeviceSetting ;

	@FindBy(xpath="(//input[@type='text'])[3]")
	WebElement PassingEditedname;

	@FindBy(xpath="//div[@id='mm-0']/div[2]/div/div[2]/div[2]/jh-alert/div/div/div/div/pre ")
	WebElement EditDeviceSettingpopup;

	@FindBy(xpath="//*[@type='submit' and @class='btn btn-primary btn-raised']")
	WebElement EditSaveBtn;

	@FindBy(xpath="//*[@class='showHideFilters ng-binding']")
	WebElement Hidefilter;

	@FindBy(xpath="//*[text()='Dashboard']")
	WebElement DashboardBtn;

	@FindBy(xpath="//*[@class='ng-binding ng-scope' and text()='demo17']")
	WebElement verifyDeviceSettingCreatedTxt;

	@FindBy(xpath="//div[@type='success']")
	WebElement DeviceSettingCreatedPopUp;

	@FindBy(xpath="//div[@id='mm-0']/div[2]/div/div[2]/div[2]/jh-alert/div/div/div/div/pre")
	WebElement DeviceSettingDeletedPopUp;

	@FindBy(xpath="//pre[@class='ng-binding ng-scope']")
	WebElement AlertMessage;

	@FindBy(xpath="//span[normalize-space()='Cancel']")
	WebElement CancelBtn;





//Bhanu
	@FindBy(xpath="//option[@label='Setting Type']")
	WebElement settingTypeFilter;

	@FindBy(xpath="//option[@label='Device Type']")
	WebElement deviceTypeFilter;

	@FindBy(xpath="//option[@label='Name']")
	WebElement nameFilter;

	@FindBy(xpath="//*[@id=\"mm-0\"]/div[2]/div/div[2]/div[1]/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[3]/div/select")
	WebElement deviceTypeValue;

	@FindBy(xpath="//option[text()='DigiRouter']")
	WebElement DigiRooterDT;

	//String path="//td[text()='DigiRouter']";
	@FindBy(xpath="//td[text()='DigiRouter']")
	WebElement confirm1;

	@FindBy(xpath="(//td[@class='ng-binding ng-scope'])[1]")
	WebElement confirm2;

	@FindBy(xpath="(//div[@class='form-group'])[1]/select")
	WebElement SelectFilterType;
//VMM_3410
	@FindBy(xpath="//option[@label]")
	List<WebElement> settingStatusDeviceTypes;

	@FindBy(xpath="//input[@placeholder='30825']")
	WebElement FleetServerport;

	@FindBy(xpath="//pre[@class='ng-binding ng-scope']")
	WebElement alertPopup;


	//-------------------------------------------------------VMM_3665---------------------------------------------
	@FindBy(xpath="//select[@class='form-control conditions-select ng-pristine ng-untouched ng-valid']")
	WebElement EnterNotEqual;

	@FindBy(xpath="//*[@id='lifecycle-deviceSettings']")
	WebElement clickDeviceTypesTab;


	@FindBy(xpath="//select[@class='form-control conditions-select ng-pristine ng-untouched ng-valid']")
	WebElement EnterDeviceType;

	@FindBy(xpath="//select[@class='form-control fields-select ng-pristine ng-untouched ng-valid']")
	WebElement selectDeviceType;


	@FindBy(xpath="//select[@class='form-control conditions-select ng-valid ng-dirty ng-valid-parse ng-touched']")
	WebElement VerifyNotEqual;

	//--------------------------Sunilkumar(VMM3733)--------------------------------
	@FindBy(xpath = "//div[@role='button']//div//span[@class='ng-binding'][normalize-space()='Advanced Settings']")
	WebElement verifyAdvancedSettings;

	@FindBy(xpath = "//tbody/tr[1]/td[3]/button[1]/i[1]")
	WebElement DeviceSettingviewBtn;

	@FindBy(xpath = "//span[normalize-space()='Back']")
	WebElement DeviceSettingbackwBtn;

	@FindBy(xpath = "//i[normalize-space()='edit']")
	WebElement DeviceSettingeditBtn;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement DeviceSettingesaveBtn;


	 //Rajath VMM-3492---------------------------------------------------
	@FindBy(xpath = "//span[@id='lifecycle-deviceSettings']")
	WebElement devicesettingnavigate;

	@FindBy(xpath = "//span[normalize-space()='New']")
	WebElement devicesettingnewbtn;

	@FindBy(xpath = "/html/body/div[1]/div[2]/form/div[2]/div[3]/div[1]/div[3]/input")
	WebElement deviceEntername;

	@FindBy(xpath = "/html/body/div[1]/div[2]/form/div[2]/div[3]/div[1]/div[5]/select")
	WebElement EnterdeviceType;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement devicesavebtn;

	//Rajath VMM-3592-----------------------------------------------------------
	@FindBy(xpath = "//button[@class='btn btnShowFilterGroups btn-info btn-raised']")
	WebElement devicesettingshwofilter;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div[1]/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[1]/div/select")
	WebElement EnterNamefilter;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div[1]/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[2]/div[1]/select")
	WebElement EnterNamequal;

	@FindBy(xpath = "//input[@type='text']")
	WebElement paasingdata;

	@FindBy(xpath = "//div[@class='filterButtons']//span[@class='ng-scope'][normalize-space()='Clear']")
	WebElement Devicesettingclearbtn;

	///// Naincy


	@FindBy(xpath = "//input[@id='jsonIdhostip']")
	WebElement FleetServerIP;

	@FindBy(xpath = "//input[@id='jsonIdhostport']")
	WebElement FleetServerPort;

	//Savitha
	@FindBy(xpath="//button[contains(@class,'btnShowFilter')]")
	WebElement showFiltersBtnDeviceSettingsPg;

	@FindBy(xpath="(//button[contains(@class,'btnShowFilter')]/..//select)[2]")
	WebElement selectName;

	@FindBy(xpath="(//button[contains(@class,'btnShowFilter')]/..//select)[3]")
	WebElement selectEquals;

	@FindBy(xpath="//button[contains(@class,'btnShowFilter')]/..//input[@type='text']")
	WebElement EnterName;

	@FindBy(xpath="//*[@class='filterButtons']/button[2]")
	WebElement filterBtn;

	//Savitha
	@FindBy(xpath = "//thead//span[text()='Name']")
	WebElement colName;

	@FindBy(xpath = "//thead//span[text()='Device Type']")
	WebElement colDeviceType;

	@FindBy(xpath="//*[@id='field_name_device']")
	WebElement nameField;

	@FindBy(xpath="//*[@id='field_deviceType']")
	WebElement deviceTypeField;

	@FindBy(xpath="//*[@id='field_deviceType']//option[@selected='selected']")
	WebElement deviceTypeTxt;

	public void exportDeviceSettings() throws InterruptedException {

		sleepMAX();

		waitForElementToBeClickableThenClick(deviceSettingsExportBtn);
		sleepMAX();
	}

	public File getDeviceSettingsExport() {

		File DeviceSettings = getLastModified(System.getProperty("user.dir") + "\\Downloads");

		return DeviceSettings;
	}

	public static File getLastModified(String directoryFilePath)
	{
	    File directory = new File(directoryFilePath);
	    File[] files = directory.listFiles(File::isFile);
	    long lastModifiedTime = Long.MIN_VALUE;
	    File chosenFile = null;

	    if (files != null)
	    {
	        for (File file : files)
	        {
	            if (file.lastModified() > lastModifiedTime)
	            {
	                chosenFile = file;
	                lastModifiedTime = file.lastModified();
	            }
	        }
	    }

	    return chosenFile;
	}

	public int getCurrentVersion(Map<String, String> testData) throws InterruptedException {

		String trackBtn = "//table[@class='table table-striped']//*[text()='" + testData.get("DeviceName") + "'][1]/parent::tr/td[3]/button[4]";

		sleepMin();

		driver.findElement(By.xpath(trackBtn)).click();

		sleepMin();

		String versionCount =driver.findElement(By.xpath("(//table[@class='table table-bordered table-hover table-striped']//tbody)[1]/tr[1]/td[3]")).getText();

		return Integer.parseInt(versionCount);

			}

	public void clickEditDeviceSetting() throws InterruptedException {
		waitForElementToBeClickableThenClick(editBtn);
		//waitForElementToBeClickableThenClick(editDeviceSettingBtn);

		sleepMin();

			}
	//Savitha
	public void filterDeviceSettings(Map<String, String> testData) throws InterruptedException {
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(showFiltersBtnDeviceSettingsPg);
		waitForAngularRequestsToFinish();
		selectListByVisibleText(selectName,"Name");
		selectListByVisibleText(selectEquals,"equals");
		waitForElementToBeClickableThenSendkeys(EnterName,testData.get("DeviceName").toLowerCase());

		waitForElementToBeClickableThenClick(filterBtn);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(showFiltersBtnDeviceSettingsPg);
		waitForAngularRequestsToFinish();
	}


	public Map<String,String> editDeviceSetting(Map<String, String> testData) throws InterruptedException{



		sleepMin();

		deviceConfigDetails.put("FleetServerHost",driver.findElement(By.xpath("//*[@id='jsonIdhostip']")).getAttribute("placeholder"));

		deviceConfigDetails.put("FleetServerPort",driver.findElement(By.xpath("//*[@id='jsonIdhostport']")).getAttribute("placeholder"));



		waitForElementToBeClickableThenClearThenSendkeys(configMsgSendTimerTxt, testData.get("MessageSendTimer"));

		waitForElementToBeClickableThenClearThenSendkeys(configAckReqMsgTimerTxt, testData.get("AcknowledgeRequestMessageTimer"));

		waitForElementToBeClickableThenClearThenSendkeys(deviceSettingNameTxt, testData.get("DeviceName"));

		sleepMin();

		scrollToElement("//*[@id='jsonIdmsgtimer']");



		return deviceConfigDetails;
	}


	public void saveDeviceSetting() throws InterruptedException {

		waitForElementToBeClickableThenClick(saveDeviceSettingBtn);

		sleepMin();
	}



	public void clickTrackDeviceSetting(Map<String, String> testData) throws InterruptedException {

		String trackBtn = "//table[@class='table table-striped']//*[text()='" + testData.get("DeviceName") + "'][1]/parent::tr/td[3]/button[4]";

		driver.findElement(By.xpath(trackBtn)).click();

		sleepMin();

		scrollToElement("(//table[@class='table table-bordered table-hover table-striped']//tbody)[1]/tr[1]/td[2]");

			}

	public Map<String,String>  trackDeviceSetting(Map<String, String> testData) throws InterruptedException {

		Map<String,String> resultData = new HashMap<String,String>();

		sleepMin();

		resultData.put("Action", driver.findElement(By.xpath("(//table[@class='table table-bordered table-hover table-striped']//tbody)[1]/tr[1]/td[2]")).getText());

		resultData.put("Version", driver.findElement(By.xpath("(//table[@class='table table-bordered table-hover table-striped']//tbody)[1]/tr[1]/td[3]")).getText());

		resultData.put("Name" , driver.findElement(By.xpath("(//table[@class='table table-bordered table-hover table-striped']//tbody)[1]/tr[1]/td[4]/table//tr[2]/td/span")).getText());

		resultData.put("Notes" , driver.findElement(By.xpath("(//table[@class='table table-bordered table-hover table-striped']//tbody)[1]/tr[1]/td[4]/table//tr[3]/td/span")).getText());

		resultData.put( "Template" , driver.findElement(By.xpath("(//table[@class='table table-bordered table-hover table-striped']//tbody)[1]/tr[1]/td[4]/table//tr[4]/td/span")).getText());

		return resultData;

	}

	public void createDeviceSetting(Map<String, String> testData) {

		waitForElementToBeClickableThenClick(createNewDeviceSettingBtn);

		waitForElementToBeClickableThenSendkeys(deviceSettingName, testData.get("DeviceName"));

		selectListByVisibleText(deviceTypeDrp, testData.get("DeviceType"));

		waitForAngularRequestsToFinish();

	}

	public void createDeviceSettingSave() {

		waitForElementToBeClickableThenClick(newDeviceSettingSaveBtn);
    waitForAngularRequestsToFinish();

	}

	public void scrollToNewDeviceSetting(String deviceSettingName) throws InterruptedException {

		scrollToElement("//table[@class='table table-striped']//*[text()='"+deviceSettingName+"']");

		sleepMAX();
	}

	public void deleteDeviceSetting(String deviceSettingName) throws InterruptedException {

		waitForElementToBeClickableThenClick(deleteBtn);
		//waitForElementToBeClickableThenClick(deleteDeviceSettingBtn);

		waitForAngularRequestsToFinish();

		waitForElementToBeClickableThenClick(deleteDeviceSettingPopupBtn);

		sleepMAX();
	}

//surya---------------------------------------VMM3377-------------------------------------------------



	public void clickShowFilter( ){
		waitForElementToBeClickableThenClick(showFilterBtn);

	}

	public void ClickClearAfterShowFilter() {
		waitForElementToBeClickableThenClick(ClickClearBtnSF);
	}

	public void selectFilterBy() {
	    waitForElementToBeClickableThenClick(SelectFilter);

	}

	public String ClickSaveBtnAfterEdit() {
		waitForAngularRequestsToFinish();
	   waitForElementToBeClickableThenClick(EditSaveBtn);
		String msg = AlertMessage.getText();
		return msg;

	}
	public void SearchDeviceSetting(Map<String, String> testData) throws InterruptedException{
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(showFilterBtn);
		waitForElementToBeClickableThenSendkeys(clickshowFilterTypeForName,"Name");
		waitForElementToBeClickableThenSendkeys(SelectConditionType,"equals");
		waitForElementToBeClickableThenSendkeys(passingshowFilterValueForName,testData.get("DeviceName"));
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(clickfilter);
		sleepMAX();

	}

	public void DeleteDeviceSetting( ) throws InterruptedException{
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(clickDeleteIcon);
		sleepAvg();
	}

	public void viewSetting() throws InterruptedException {
		   waitForAngularRequestsToFinish();
		   waitForElementToBeClickableThenClick(visiblityIcon);
		   sleepMAX();
	}

	public String verifyFleetServerIPInViewDevice() throws InterruptedException {
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(Searchfleet,"fleet");
		sleepMin();
		 String viewtext = verifyfleetserverIP.getText();
		if(viewtext!=null)
			return viewtext;
		   else
    	    return null;

	}

	public String verifyFleetServerPortInViewDevice() {
		 String viewtext = verifyfleetserverPort.getText();
		if(viewtext!=null)
			return viewtext;
		   else
    	    return null;

	}

	public void clickBackafterviewed() {
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(ClickBackAfterView);

	}


	public void clickeditDeviceSettingIcon() {
	   waitForAngularRequestsToFinish();
	   waitForElementToBeClickableThenClick(ClickEditDeviceSetting);
	}

	public  void editDeviceSettingname(Map<String, String> testData) {
	   waitForAngularRequestsToFinish();
	   waitForElementToBeClickableThenClearThenSendkeys(PassingEditedname,testData.get("updateDeviceName"));
	}

	public void SearchDeviceSettingForAfterEdit(Map<String, String> testData) throws InterruptedException{
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(showFilterBtn);
		waitForElementToBeClickableThenSendkeys(clickshowFilterTypeForName,"Name");
		waitForElementToBeClickableThenSendkeys(SelectConditionType,"equals");
		waitForElementToBeClickableThenSendkeys(passingshowFilterValueForName,testData.get("updateDeviceName"));
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(clickfilter);
		sleepMAX();

	}

	public void clickDashboardBtn() {
	    waitForAngularRequestsToFinish();
	    waitForElementToBeClickableThenClick(DashboardBtn);
		}


	public String VerifyDeviceSettingCreated() {
		String DSstatus = getWebelementText(DeviceSettingCreatedPopUp);
		if(DSstatus!=null)
		   return DSstatus;
	    else
		    return null;

	}

	public  String verifyeditedDeviceSettingname() {
		String edtstatus = EditDeviceSettingpopup.getText();
		if(edtstatus!=null)
			return edtstatus;
		else
			return null;
		}


	public String VerifyDeviceSettingDeleted() {
		String DSdeletedstatus = getWebelementText(DeviceSettingDeletedPopUp);
		if(DSdeletedstatus!=null)
		   return DSdeletedstatus;
	    else
		    return null;

	}

   public String DeviceSettingSaveConformation() {
	    waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(newDeviceSettingSaveBtn);
		String msg = AlertMessage.getText();
		return msg;

	}


   public String DeleteDeviceSettingConformation( ) throws InterruptedException{
	waitForAngularRequestsToFinish();
	waitForElementToBeClickableThenClick(ClickDeletePopup);
	String msg = AlertMessage.getText();
	return msg;
   }

   public  void editDeviceSettingnameCoreController(Map<String, String> testData) {
	   waitForAngularRequestsToFinish();
	   waitForElementToBeClickableThenClearThenSendkeys(PassingEditedname,testData.get("VerifyDeviceType"));

	}


	public void clickCancelAfterEdit() {

		waitForElementToBeClickableThenClick(CancelBtn);
		waitForAngularRequestsToFinish();

	}




	///Bhanu ---------------------------------------------------Bhanu---------------------------------------------

	@FindBy(xpath="//option[@selected='selected'])[2]")
	WebElement options;

	public String verifySettingTypeFilter(Map<String, String> testData) throws InterruptedException
	{
		waitForElementToBeClickableThenClick(showFilterBtn);

		waitForAngularRequestsToFinish();

		waitForElementToBeClickableThenClick(SelectFilterType);
		sleepMin();
		List<WebElement> settingFilter = driver.findElements(By.xpath("settingTypeFilter"));
		int count = settingFilter.size();

		if(count>=1){
			String FilterName = getWebelementText(settingTypeFilter);
			System.out.println(FilterName);
			return FilterName;
		}
		else
			return "Setting Type Filter Not available";
	}

	public boolean checkFilter1(Map<String, String> testData)
	{
		waitForElementToBeClickableThenClick(showFilterBtn);
		waitForElementToBeClickableThenClick(deviceTypeFilter);
		waitForElementToBeClickableThenSendkeys(SelectConditionType,"equals");
		//waitForElementToBeClickableThenSendkeys(deviceTypeValue, "");
		//waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(deviceTypeValue,testData.get("DeviceType"));
		waitForElementToBeClickableThenClick(clickfilter);
		waitForAngularRequestsToFinish();
		boolean Status1 =driver.findElement(By.xpath("//td[text()='"+testData.get("DeviceType")+"']")).isDisplayed();
		return Status1;
	}
	public boolean checkFilter2(Map<String, String> testData)
	{
		waitForElementToBeClickableThenClick(nameFilter);
		waitForElementToBeClickableThenSendkeys(SelectConditionType,"equals");
		waitForElementToBeClickableThenSendkeys(passingshowFilterValueForName,testData.get("DeviceName"));

		waitForElementToBeClickableThenClick(clickfilter);
		waitForAngularRequestsToFinish();

		boolean Status2 = confirm2.isDisplayed();
		return Status2;
	}
	public String DeleteDeviceSetting1( ) throws InterruptedException{
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(clickDeleteIcon);
		sleepMAX();
		waitForElementToBeClickableThenClick(ClickDeletePopup);
		String Alert = alertPopup.getText();
		waitForAngularRequestsToFinish();
		return Alert;
	}

	//VMM_3410
	public ArrayList<String> deviceTypesWhichHaveSettingStatus(Map<String, String> testData) {
		waitForElementToBeClickableThenClick(createNewDeviceSettingBtn);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(deviceTypeDrp);

		int count = settingStatusDeviceTypes.size();

		ArrayList<String> deviceTypeList=new ArrayList<>();
		for(int i=0;i<count;i++)
		{
			String Name = settingStatusDeviceTypes.get(i).getText();
			//System.out.println(Name);
			deviceTypeList.add(Name);
		}


		return deviceTypeList;
	}

	public String verifyFleetServerPort(Map<String, String> testData) throws InterruptedException {
		waitForElementToBeClickableThenClick(createNewDeviceSettingBtn);
		waitForAngularRequestsToFinish();
		selectListByVisibleText(deviceTypeDrp, "DigiRouter");
		waitForAngularRequestsToFinish();
		String port = FleetServerport.getAccessibleName();
		//System.out.println("FleetServerport is :"+port);
		//sleepAvg();
		return port;
	}

	public String createDeviceSettingSaveButton() {
		waitForElementToBeClickableThenClick(newDeviceSettingSaveBtn);
		String Alert = alertPopup.getText();
		return Alert;
	}

	public String verifyFleetServerPortForCreatedDeviceType(Map<String, String> testData) throws InterruptedException {
		waitForElementToBeClickableThenClick(createNewDeviceSettingBtn);
		waitForAngularRequestsToFinish();
		selectListByVisibleText(deviceTypeDrp, testData.get("DeviceType"));
		waitForAngularRequestsToFinish();
		String port = FleetServerport.getAccessibleName();
	//	System.out.println("FleetServerport is :"+port);
		sleepAvg();
		return port;
	}

	///**************

	//----------------------------------------VMM_3665----------------------------------------------

	public void VerifyNotMoreThanRecordNotEqualDevicesetting(Map<String, String> testData) {
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(showFilterBtn);
		waitForElementToBeClickableThenSendkeys(selectDeviceType,"Device Type");
		waitForElementToBeClickableThenSendkeys(EnterNotEqual,"not equal");
		waitForElementToBeClickableThenSendkeys(EnterDeviceType,testData.get("DeviceType"));
	}
	public void clickFilter() throws InterruptedException {
		waitForElementToBeClickableThenClick(clickfilter);
		sleepMAX();
	}
	public void verifynotEqualDeviceSetting() {
		System.out.println(getWebelementText(VerifyNotEqual));
	}

	//------------------------Sunilkumar(VMM3733)-------------------------------------------
	public String advancesetting() {

		String text = verifyAdvancedSettings.getText();
		return text;
	}

	public void clickDeviceSettingviewBtn() throws Exception {

		waitForElementToBeClickableThenClick(DeviceSettingviewBtn);
		waitForAngularRequestsToFinish();

	}

	public void DeviceSettingbackBtn() throws Exception {
		sleepAvg();
		waitForElementToBeClickableThenClick(DeviceSettingbackwBtn);

	}

	public void DeviceSettingeditBtn() throws Exception {
		waitForElementToBeClickableThenClick(DeviceSettingeditBtn);
		sleepMin();
		sleepAvg();
	}
	public void  DeviceSettingesaveBtn() throws Exception {
		waitForElementToBeClickableThenClick( DeviceSettingesaveBtn);
		sleepAvg();

	}



	//Rajath VMM-3492---------------------------------------------------

	public void clickOnDeviceSetting() {
		waitForElementToBeClickableThenClick(devicesettingnavigate);

	}

    public void createdevicesetting(Map<String, String> testData) throws InterruptedException {
		waitForElementToBeClickableThenClick(devicesettingnewbtn);
		sleepMin();
		waitForElementToBeClickableThenSendkeys(deviceEntername, testData.get("DeviceName"));
		sleepMin();
		selectListByVisibleText(EnterdeviceType, testData.get("DeviceType"));
		waitForAngularRequestsToFinish();

}
    public void clickOndevicesttingsave () throws InterruptedException {
	    waitForElementToBeClickableThenClick(devicesavebtn);
		sleepAvg();
}

	//Rajath VMM-3592
    public void Devicesettingfilter(Map<String, String> testData) throws InterruptedException{
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(devicesettingshwofilter);
		selectListByVisibleText(EnterNamefilter,"Name");
		selectListByVisibleText(EnterNamequal,"equals");
		waitForElementToBeClickableThenSendkeys(paasingdata,testData.get("DeviceName"));
		//waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(clickfilter);


	}

		 public void deviceSettingSearch (Map<String, String> testData) throws InterruptedException{
		sleepMin();
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(devicesettingshwofilter);
		sleepMin();
		selectListByVisibleText(EnterNamefilter,"Name");
		sleepMin();
		selectListByVisibleText(EnterNamequal,"equals");
		sleepMin();
		waitForElementToBeClickableThenSendkeys(paasingdata,testData.get("DeviceName"));
		sleepMAX();
		waitForElementToBeClickableThenClick(clickfilter);
		waitForAngularRequestsToFinish();

    }
    public void deviceSettingSearchWithClearValue (Map<String, String> testData) throws InterruptedException{
		sleepMin();
		waitForElementToBeClickableThenClick(Devicesettingclearbtn);
		 sleepMin();
		selectListByVisibleText(EnterNamefilter,"Name");
		sleepMin();
		selectListByVisibleText(EnterNamequal,"equals");
		sleepMin();
		waitForElementToBeClickableThenClearThenSendkeys(paasingdata,"");
		//sleepMin();
		waitForAngularRequestsToFinish();
		//driver.navigate().refresh();

    }

    public boolean FilterDeviceSettings(Map<String, String> testData)
	{
		waitForElementToBeClickableThenClick(showFilterBtn);
		waitForElementToBeClickableThenClick(nameFilter);
		waitForElementToBeClickableThenSendkeys(SelectConditionType,"equals");
		waitForElementToBeClickableThenSendkeys(paasingdata,testData.get("DeviceName"));
		waitForAngularRequestsToFinish();
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(clickfilter);
		waitForAngularRequestsToFinish();
				boolean Status1 =driver.findElement(By.xpath("//td[text()='"+testData.get("DeviceName")+"']")).isDisplayed();
		//boolean Status1 = confirm1.isDisplayed();
		return Status1;


    }




	 // Naincy ----------------------------------------------------

    public String verifyFleetServerIP() {
    	String text=FleetServerIP.getAttribute("placeholder");
		return text;

	}

    public String verifyFleetServerPort() {
    	String text=FleetServerPort.getAttribute("placeholder");
		return text;

	}

  //Savitha
    public boolean verifyColumnsInDeviceSettingsScreen(){

    	if(	colName.isDisplayed() &&
    			colDeviceType.isDisplayed())
    		return true;

    	return false;
    }

    public void clickOnNewDeviceSettingsBtn() {

		waitForElementToBeClickableThenClick(createNewDeviceSettingBtn);
		waitForAngularRequestsToFinish();
    }

	public boolean verifyMandatoryFieldsInNewDeviceSettingsScreen() throws Exception {

		if(nameField.getAttribute("aria-required").equalsIgnoreCase("true") &&
				deviceTypeField.isDisplayed() )

			return true;

		else
			return false;
	}

	 public String getDeviceTypeFromViewScreen() {

			return deviceTypeTxt.getText();
	 }

}
