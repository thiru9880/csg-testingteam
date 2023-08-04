package safefleetLM.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import safefleetLM.componentgroups.ReusableLibrary;

public class DevicePage extends ReusableLibrary {

WebDriver driver;

	public DevicePage(WebDriver driver)  {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//New updates

	@FindBy(xpath="//*[@class='btn btn-default form-control ui-select-toggle']")
	WebElement TenantTxtFieldClick;

	@FindBy(xpath="//input[@aria-label='Select box']")
	WebElement TenantTxtField;

	@FindBy(xpath="//span[@class='ui-select-choices-row-inner']")
	WebElement suggestionRowFirstValue;

	@FindBy(xpath="//input[@id='field_macAddress']")
	WebElement MacAddressField;

	//--------------





	@FindBy(xpath="//*[@id='device_new_btn']/span")
	WebElement newDeviceBtn;

	@FindBy(xpath="//*[@id=\"field_deviceType\"]")
	WebElement deviceTypeDrp;

	@FindBy(xpath="//*[@id='field_deviceId']")
	WebElement deviceIDTxt;

	@FindBy(xpath="//*[@id='field_fleet_id']")
	WebElement tenantIDTxt;

	@FindBy(xpath="//*[@id=\"assign_setting_select_field\"]/div[1]/span/span[2]")
	WebElement deviceSettingsDrp;

	@FindBy(xpath="//span[@class='ui-select-choices-row-inner']")
	WebElement deviceSettingsDrpRow1;

	@FindBy(xpath="//*[@id=\"ui-select-choices-row-1-0\"]/span")
	WebElement deviceSetting;

	@FindBy(xpath="//*[@id='assign_setting_confirm_btn']")
	WebElement assignDeviceBtn;

	@FindBy(xpath="//*[@id='device_cancel_btn']")
	WebElement deviceCancelBtn;

	@FindBy(xpath="(//*[@class='ui-grid-filter-container ng-scope'])[3]//select")
	WebElement deviceTypeFilterDrp;

	@FindBy(xpath="//*[@class='ui-grid-canvas']/div[1]//span[@id='fleetId']")
	WebElement deviceTypeFilterListRow1;

	@FindBy(xpath="//*[@class='ui-grid-canvas']/div[4]//span[@id='fleetId']")
	WebElement deviceTypeFilterListRow4;

	@FindBy(xpath="(//*[@class='btn-group-xs btn-group'])[1]/button[1]")
	WebElement deviceSettingsBtn1;

	@FindBy(xpath="(//*[@class='btn-group-xs btn-group'])[4]/button[4]")
	WebElement deviceSettingsBtn4;




//-------------------------------VMM3286---------------------------------------

		@FindBy(xpath= "//*[@id='field_deviceType']")
		WebElement DevicesTypeField;

		@FindBy(xpath="//*[text()='New']")
		WebElement DeviceTypesNewBtnForCreateD;

		@FindBy(xpath= "//*[@id='field_deviceId']")
		WebElement deviceIdField;

		@FindBy(xpath= "//select[@id='field_fleet_id']")
		WebElement TenantIdField;

		@FindBy(xpath= "//*[@id='field_serialNumber']")
		WebElement serialNumberfield;

		@FindBy(xpath= "//*[@id='field_partNumber']")
		WebElement PartNumberField;

		@FindBy(xpath= "//*[@id='field_providers']")
		WebElement cellularField;

		@FindBy(xpath= "//*[@id='field_providerId']")
		WebElement IMEIField;

		@FindBy(xpath= "//*[@id='device_save_btn']")
		WebElement DeviceSaveBTn;

		@FindBy(xpath="//*[contains(text(),'Show Filters')]")
		WebElement showFilterBtn;

		@FindBy(xpath="//select[@class='form-control fields-select ng-pristine ng-untouched ng-valid']")
		WebElement clickshowFilterTypeForDeviceid;

		@FindBy(xpath="//select[@class='form-control conditions-select ng-pristine ng-untouched ng-valid']")
		WebElement SelectConditionType;

		@FindBy(xpath="(//*[@type='text'])[1]")
		WebElement passingshowFilterValueForDeviceid;

		@FindBy(xpath="//div[@class='filterButtons']//button[@class='btn btn-primary btn-raised']")
		WebElement clickfilter;


		@FindBy(xpath="//*[text()='edit']")
		WebElement EditIcon;

		@FindBy(xpath="//div[@id='mm-0']/div[2]/div/div[2]/jh-alert/div/div/div/div/pre")
		WebElement DeviceCreatedPopUp;


		@FindBy(xpath= "//*[text()='Save']")
		WebElement ClickSaveAfterEdit;


		@FindBy(xpath= "//*[@id='deviceId']")
		WebElement DeviceId;


		@FindBy(xpath= "//a/*[text()='Devices']")
		WebElement DevicesTab;
		//*[@id='deviceId']
		@FindBy(xpath= "//*[@id='deviceId']")
		WebElement GetDevicesIdText;


		@FindBy(xpath= "//*[text()='delete']")
		WebElement DeleteDevice;

		@FindBy(xpath= "//*[@class='ng-scope' and text()='Delete']")
		WebElement DeleteDevicepopup;

		@FindBy(xpath= "//h2[text()='Devices']")
		WebElement devicesPageTitle;




		//surya------------------------------------VMM-3878---------------------------------


		@FindBy(xpath = "(//select[@placeholder='Filter for column'])[1]")
		WebElement DeviceTypeDropDwn;


		@FindBy(xpath = "(//select[@placeholder='Filter for column'])[1]//option[@label]")
		List<WebElement> DeviceTypeDropDwnValues;


		@FindBy(xpath = "(//select[@placeholder='Filter for column'])[2]")
		WebElement DeviceStatusDropDwn;


		@FindBy(xpath = "(//select[@placeholder='Filter for column'])[2]//option[@label]")
		List<WebElement> DeviceStatusDropDwnValues;

		//------------------------------------Melroy VMM3400------------------------------------
		@FindBy(xpath = "//span[@id='lifecycle-device']")
		WebElement deviceTab;

		@FindBy(xpath = "//button[@id='device_new_btn']")
		WebElement clickonNewbtn;

		@FindBy(xpath = "(//i[@class='material-icons'][normalize-space()='edit'])[9]")
		WebElement clickoneditBtn1;


		@FindBy(xpath = "(//i[@class='material-icons'][normalize-space()='edit'])[19]")
		WebElement clickoneditBtn2;

		@FindBy(xpath = "(//span[@id='fleetId'])")
		List<WebElement> tableValues;

		@FindBy(xpath = "//select[@id='field_deviceType']")
		WebElement selectDevicetypeField;

		@FindBy(xpath ="//select[@id='field_fleet_id']")
		WebElement selectTenantField;

		@FindBy(xpath ="//input[@id='field_deviceId']")
		WebElement selectDeviceIDField;

		@FindBy(xpath = "//input[@id='field_partNumber']")
		WebElement selectPartNumField;

		@FindBy(xpath = "//input[@id='field_serialNumber']")
		WebElement selectSerialNumField;

		@FindBy(xpath = "//button[@id='device_save_btn']")
		WebElement clickonSaveBtn;

		@FindBy(xpath="//span[@class='showHideFilters ng-binding']")
		WebElement showfilterBtn;

		@FindBy(xpath = "//*[@id=\"outer\"]/div[1]/div[2]/div/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[1]/div/select")
		WebElement tenentIDFilter;

		@FindBy(xpath = "//select[@class='form-control conditions-select ng-pristine ng-untouched ng-valid']")
		WebElement equalsFilter;

		@FindBy(xpath = "(//div[@role='checkbox'])[10]")
		WebElement ChecktenantID1;

		@FindBy(xpath = "(//div[@role='checkbox'])[11]")
		WebElement ChecktenantID2;

		@FindBy(xpath = "(//div[@role='checkbox'])[17]")
		WebElement ChecktenantID3;

		@FindBy(xpath = "//span[normalize-space()='Bulk Edit']")
		WebElement BluckEdit;

		@FindBy(xpath = "(//span[@class='circle'])[1]")
		WebElement tickonfirstcircle;

		@FindBy(xpath = "//button[@class='btn btn-primary btn-raised']")
		WebElement nextButton;


		@FindBy(xpath = "(//span[@class='check'])[5]")
		WebElement devicestatus;

		@FindBy(xpath = "//input[@id='field_partNumber']")
		WebElement selectPart;

		@FindBy(xpath = "//button[@class='btn btn-primary btn-raised btn-create']")
		WebElement nextButton2;

		@FindBy(xpath = "//p[@class='ng-binding']")
		WebElement textverify;

		@FindBy(xpath = "//button[@class='btn btn-primary btn-raised btn-create']")
		WebElement nextButton3;

		@FindBy(xpath = "//span[normalize-space()='Ok']")
		WebElement okButton;

		@FindBy(xpath = "//span[normalize-space()='Finalize']")
		WebElement finalizeButton;

		String tofleetID="(//span[@id='fleetId'])[10]";

		String tofleetID2="(//span[@id='fleetId'])[11]";

		String tofleetID3="(//span[@id='fleetId'])[17]";

		String toDeciveStatus="//div[@class='ui-grid-cell-contents ng-binding ng-scope ui-grid-cell-focus']";

		@FindBy(xpath = "//div[contains(text(),'3')]")
		WebElement verifyPart;

		String toDeviceStatus2="(//div[@class='ui-grid-cell-contents ng-binding ng-scope'][normalize-space()='DH6'])[1]";

		@FindBy(xpath = "//div[@class='filterButtons']//span[@class='ng-scope'][normalize-space()='Clear']")
		WebElement ClearBtn;

		@FindBy(xpath = "//button[@class='btn btnShowFilterGroups btn-info btn-raised']")
		WebElement ClickHideFilter;

		@FindBy(xpath="//pre[@class='ng-binding ng-scope']")
		WebElement AlertMessage;

		@FindBy(xpath = "(//div[contains(text(),'3')])[1]")
		WebElement verifydeviceType2;

		String toDeviceStatus3="(//div[@class='ui-grid-cell-contents ng-binding ng-scope'][normalize-space()='DH6'])[2]";


	//--------------------------------------------------------------------------------------------

				//--------------------Sunilkumar(VMM4443)----------------------------------------------------
		@FindBy(xpath = "//p[@id='assign_setting_new']")
		WebElement assigndevices;

		@FindBy(xpath = "//div[@aria-disabled='false']//span[@class='ui-select-match-text pull-left']")
		WebElement toggleBtn;



		@FindBy(xpath = "//ul[@class='ui-select-choices ui-select-choices-content ui-select-dropdown dropdown-menu']")
		List<WebElement> assignDeviceList;

		@FindBy(xpath = "//i[normalize-space()='edit']")
		WebElement deviceEdit;

		@FindBy(xpath = "//span[normalize-space()='UNASSIGN']")
		WebElement UnassignBtn;

		@FindBy(xpath = "//select[@id='unassign_status_select_field']")
		WebElement Unassigndevicetxtfield;

		@FindBy(xpath = "//span[normalize-space()='Unassign Device']")
		WebElement UnassigndeviceBtn;

		@FindBy(xpath = "//span[@aria-disabled='true']")
		WebElement TenantidTxtfild;

		@FindBy(xpath="//select[@id='unassign_status_select_field']")
		WebElement EnterNotAssigned;

		@FindBy(xpath="//span[normalize-space()='Unassign Devices']")
		WebElement ConformUnAssign;


		//-------------------------------------Sunilkumar(VMM4423)-------------------------------

		@FindBy(xpath = "//div[@ng-show='!isEdit && showAddAnother']//span[@class='check']")
		WebElement addanother;


		//--------------------------------------Sunilkumar(VMM4464)---------------------------------
		@FindBy(xpath = "(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[9]")
		WebElement Devicestatustxt;

		@FindBy(xpath = "(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[10]")
		WebElement Datastatustxt;

		@FindBy(xpath = "(//p[@class='ng-scope'])[2]")
		WebElement unassigndialog;





		//Rajath VMM_4578-------------------------------------------------------------------
		@FindBy(xpath = "//i[normalize-space()='edit']")
		WebElement editbtn;

		@FindBy(xpath = "//button[@title='Settings']")
		WebElement settingicon;

		@FindBy(xpath = "//div[@class='filterButtons']//span[@class='ng-scope'][normalize-space()='Clear']")
		WebElement cleardevice;


		@FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div[3]/div") //
		WebElement devicetypetxtbox;

		//--------------------------------------------------Nitin----------------------------------------------------//
		@FindBy(xpath = "//span[text()='Bulk Upload']")
		WebElement bulkUploadDrop;

		@FindBy(xpath = "//a[text()='Upload Spreadsheet']")
		WebElement uploadSpreadsheetDrop;

		@FindBy(xpath = "//a[text()='Download Spreadsheet']")
		WebElement downloadSpreadsheetDrop;

		@FindBy(xpath="//span[contains(text(),'Show Filters')]")
		WebElement showFilters;

		@FindBy(xpath = "(//select)[2]")
		WebElement showFiltersFirstDropDown;

		@FindBy(xpath = "(//select)[3]")
		WebElement showFiltersSecondDropDown;

		@FindBy(xpath="(//input[@type='text'])[1]")
		WebElement showFiltersFirstText;

		@FindBy(xpath = "(//span[text()='Filter'])[2]")
		WebElement filterButton;

		@FindBy(xpath = "//span[@id='fleetId']")
		List<WebElement> listOfFilter;

		@FindBy(xpath = "//button[@ng-click='addCondition()']")
		WebElement addConditionn;

		@FindBy(xpath = "(//select)[5]")
		WebElement showFiltersFirstDropDownn;

		@FindBy(xpath = "(//select)[7]")
		WebElement showFiltersSecondDropDownn;

		@FindBy(xpath = "(//select)[8]")
		WebElement showFiltersSecondTextt;

		@FindBy(xpath = "//span[text()='UNASSIGN']")
		WebElement unassignn;

		@FindBy(xpath = "(//select)[6]")
		WebElement statuss;

		@FindBy(xpath = "//span[text()='Unassign Device']")
		WebElement unassignDevicee;

		@FindBy(xpath = "//span[text()='Save']")
		WebElement savee;

		@FindBy(xpath = "//select[@id='field_deviceType']//child::option")
		List<WebElement> deviceTypeListt;

		@FindBy(xpath = "(//span[@class='check'])[1]")
		WebElement checkBoxxCustomerProvided;

		@FindBy(xpath = "//span[@aria-label='Select box activate']")
		WebElement tenantIdd;

		@FindBy(xpath = "//input[@type='search']")
		WebElement tenantIddd;

		@FindBy(xpath = "//span[@class='ui-select-choices-row-inner']")
		WebElement suggestionRowFirstValuee;

		@FindBy(xpath = "//span[@class='check']")
		WebElement showwAllFieldss;

		@FindBy(xpath = "(//input[@type='checkbox'])[3]")
		WebElement customerProvidedd;

		@FindBy(xpath = "(//span[text()='Clear'])[2]")
		WebElement clearr;
		//---------------------------------------------------Nitin---------------------------------------------------//
	///Naincy

	    @FindBy(xpath = "(//div[@role='checkbox'])[1]")
	    WebElement DeviceOne;

	    @FindBy(xpath = "(//div[@role='checkbox'])[2]")
	    WebElement DeviceTwo;

	    @FindBy(xpath = "//span[normalize-space()='Bulk Edit']")
	    WebElement BulkEditBtn;

	    @FindBy(xpath = "//label[normalize-space()='Devices manually selected']")
	    WebElement DevicesManuallySelectedBtn;

	    @FindBy(xpath = "//span[normalize-space()='Next']")
	    WebElement NextBtn;

	    @FindBy(xpath = "//span[normalize-space()='Ok']")
	    WebElement OkBtn;

	    @FindBy(xpath = "(//span[@class='check'])[4]")
	    WebElement selectDeviceTypeBtn;

	    @FindBy(xpath = "(//select[@id='field_deviceType'])[1]")
	    WebElement DeviceTypeList;

	//Surya--------------------------------------------------VMM-4643-----------------------------------------------
		@FindBy(xpath = "(//*[text()='keyboard_arrow_down'])[1]")
		WebElement keyboard_arrow_down_ForCreatedSuccessfully;

		@FindBy(xpath = "(//*[text()='keyboard_arrow_up'])[1]")
		WebElement keyboard_arrow_up_ForCreatedSuccessfully;

		@FindBy(xpath = "(//span[contains(text(),'devices have been successfully created')])[1]")
		WebElement VerifyDeviceCreatedSuccessfullyText;

		@FindBy(xpath = "(//*[text()='keyboard_arrow_down'])[3]")
		WebElement keyboard_arrow_down_ForWarning;

		@FindBy(xpath = "(//*[text()='keyboard_arrow_up'])[3]")
		WebElement keyboard_arrow_up_ForWarning;

		@FindBy(xpath = "(//span[contains(text(),'devices have been successfully created with warnings')])")
		WebElement VerifyWarningText;

		@FindBy(xpath = "//span[@id='fleetId']")
		WebElement VerifyTenantAssigned;

		@FindBy(xpath = "//i[normalize-space()='edit']")
		WebElement EditDevice;

		@FindBy(xpath = "//span[normalize-space()='UNASSIGN']")
		WebElement UnAssignDevice;

		@FindBy(xpath = "//select[@id='unassign_status_select_field']")
		WebElement DeviceSettingStatus;

		@FindBy(xpath = "//span[normalize-space()='Unassign Device']")
		WebElement ConformUnAssignDevice;

		@FindBy(xpath = "//span[normalize-space()='Save']")
		WebElement EditDeviceSave;

		@FindBy(xpath = "//select[@class='form-control fields-select ng-pristine ng-untouched ng-valid']")
		WebElement SelectFilterType;

		@FindBy(xpath = "//input[@class='form-control data-input ng-pristine ng-untouched ng-valid']")
		WebElement PassingValueInShowFilter;

		@FindBy(xpath = "//input[@id='field_name_device']")
		WebElement VerifyDeviceSettingData;

		@FindBy(xpath = "//button[@title='Settings']")
		WebElement NavigateToSettingIcon;

		@FindBy(xpath = "//span[normalize-space()='Back']")
		WebElement BackInViewSettingPage;

		@FindBy(xpath = "(//*[@class='ui-grid-cell-contents ng-binding ng-scope'])[8]")
		WebElement VerifyDeviceStatus;

		@FindBy(xpath = "(//*[@class='ui-grid-cell-contents ng-binding ng-scope'])[9]")
		WebElement VerifyDataStatus;

		@FindBy(xpath = "//span[@class='check']")
		WebElement SelectAllFields;

		@FindBy(xpath = "//span[text()='Setting' and @class='ui-grid-header-cell-label ng-binding']")
		WebElement ScrollToSetting;

		//---------------------------


		//Savitha
		@FindBy(xpath = "(//*[text()='keyboard_arrow_down'])[2]")
		WebElement keyboard_arrow_down_ForError;

		@FindBy(xpath = "(//*[text()='keyboard_arrow_up'])[2]")
		WebElement keyboard_arrow_up_ForError;


		@FindBy(xpath = "//*[@id='collapseRemoveDevices']//tbody/tr")
		List<WebElement> deviceErrorMsg;

		@FindBy(xpath = "(//*[contains(@class,'ui-grid-viewport')])[2]")
		WebElement deviceDashboardList;

		@FindBy(xpath = "(//*[text()='keyboard_arrow_down'])[1]")
		WebElement keyboard_arrow_down_ForSuccess;

		@FindBy(xpath = "(//*[text()='keyboard_arrow_up'])[1]")
		WebElement keyboard_arrow_up_ForSuccess;

		@FindBy(xpath = "//*[@id='collapseUpdatedDevices']//tbody/tr")
		List<WebElement> deviceCreatedList;



	public Boolean checkDeviceTypeFld(String deviceType) {

		waitForElementToBeClickableThenClick(newDeviceBtn);
	//	waitForElementToBeClickableThenClick(deviceTypeDrp);
		selectListByVisibleText(deviceTypeDrp, deviceType);
		selectListByVisibleText(deviceIDTxt, deviceType);

		if(deviceIDTxt.getAttribute("aria-required").equalsIgnoreCase("true")) {

		waitForElementToBeClickableThenClick(deviceCancelBtn);
		return true;

			}
		else {
			waitForElementToBeClickableThenClick(deviceCancelBtn);
			return false;
		}


	}

	public void checkDeviceSettings(String deviceType) throws AWTException, InterruptedException {
		waitForElementToBeClickableThenClick(newDeviceBtn);

		selectListByVisibleText(deviceTypeDrp, deviceType);
		selectListByVisibleText(deviceIDTxt, deviceType);
		//selectListByVisibleText(tenantIDTxt, "testdatatenant");


			sleepMAX();

			}

	public Boolean checkDeviceSettingsPopup(String deviceType) throws Exception {


			if(deviceType.equals("test1")) {
				waitForElementToBeClickableThenClick(TenantTxtFieldClick);
				waitForElementToBeClickableThenSendkeys(TenantTxtField, "test");
				waitForElementToBeClickableThenClick(suggestionRowFirstValue);

				waitForElementToBeClickableThenClick(deviceSettingsDrp);
				waitForElementToBeClickableThenClick(deviceSettingsDrpRow1);
				/*
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				*/
				waitForElementToBeClickableThenClick(assignDeviceBtn);
				waitForElementToBeClickableThenClick(deviceCancelBtn);
				return true;
				}
			else{
					waitForElementToBeClickableThenClick(deviceCancelBtn);
					return false;


				}


	}

	public Map<String,String> settingsButtonTest(String DeviceType) {

		selectListByVisibleText(deviceTypeFilterDrp, DeviceType);

		Map<String,String> settingsStatus = new HashMap<String,String>();

		for(int i = 1; i<=5;i++) {

		String deviceTypeFilterList = "//*[@class='ui-grid-canvas']/div["+i+"]//span[@id='fleetId']";

		String SettingsAttribute = "(//*[@class='btn-group-xs btn-group'])["+i+"]/button[4]";

		String tenantID = driver.findElement(By.xpath(deviceTypeFilterList)).getText();

		if(tenantID.equals("")) {

			settingsStatus.put("WithoutTenant", driver.findElement(By.xpath(SettingsAttribute)).getAttribute("aria-disabled")) ;

		}else {

			settingsStatus.put("WithTenant",driver.findElement(By.xpath(SettingsAttribute)).getAttribute("aria-disabled"));
		}




		}


		return settingsStatus;

	}


	public String settingsButtonTest2(String DeviceType) {

		selectListByVisibleText(deviceTypeFilterDrp, DeviceType);

		waitForAngularRequestsToFinish();

		String settingsAttribute = "(//*[@class='btn-group-xs btn-group'])[1]/button[4]";

		return driver.findElement(By.xpath(settingsAttribute)).getAttribute("aria-disabled");

	}

//surya---------------------------------------------VMM3286------------------------------------------


	public void createDevice(Map<String, String> testData) {
		waitForElementToBeClickableThenClick(DeviceTypesNewBtnForCreateD);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(DevicesTypeField, testData.get("DeviceType"));
		waitForElementToBeClickableThenSendkeys(deviceIdField, testData.get("DeviceID"));
		if(testData.get("MAC Address")!="") {
		waitForElementToBeClickableThenSendkeys(MacAddressField, testData.get("MAC Address"));
	    }
		waitForElementToBeClickableThenSendkeys(serialNumberfield, testData.get("serial"));
		waitForElementToBeClickableThenSendkeys(PartNumberField, testData.get("partNo"));
		waitForElementToBeClickableThenSendkeys(cellularField, testData.get("cellular"));
		waitForElementToBeClickableThenSendkeys(IMEIField, testData.get("IMEINo"));
		waitForElementToBeClickableThenClick(DeviceSaveBTn);
	}

	public void searchDevice(Map<String, String> testData) throws InterruptedException {
		sleepAvg();
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(showFilterBtn);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(clickshowFilterTypeForDeviceid,"Serial #");
		waitForElementToBeClickableThenSendkeys(SelectConditionType,"equals");
		waitForElementToBeClickableThenClearThenSendkeys(passingshowFilterValueForDeviceid, testData.get("serial"));
		waitForElementToBeClickableThenClick(clickfilter);
		waitForAngularRequestsToFinish();
		VerifyDeviceCreated();
		sleepMin();

	}

	public void PassingMorethan32LettersAndNumbers(Map<String, String> testData) throws InterruptedException {
		waitForElementToBeClickableThenClick(EditIcon);
		waitForElementToBeClickableThenClearThenSendkeys(deviceIdField, testData.get("DeviceIdMoreThan32"));
	}
	public String VerifyDeviceIdNotAllowMoreThan32() {
		String DIDText = GetDevicesIdText.getText();
	   if(DIDText!=null)
	     return DIDText;
	   else
          return null;
	}

	public String VerifyDeviceCreated() {
			String DEstatus = getWebelementText(DeviceId);
		   if(DEstatus!=null)
		     return DEstatus;
		   else
	          return null;
		}

	public void navigateToDevices() throws InterruptedException {
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(DevicesTab);
		waitForAngularRequestsToFinish();
	}

	public void deleteDevice() {
		waitForElementToBeClickableThenClick(DeleteDevice);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(DeleteDevicepopup);
		waitForAngularRequestsToFinish();

	}


	//---------------------------------Melroy VMM-3400----------------------------------
	public void createnewDevices() throws Exception
	{

		waitForElementToBeClickableThenClick(clickoneditBtn1);
		sleepMAX();

		waitForElementToBeClickableThenClearThenSendkeys(selectTenantField, "TenantID");
		sleepAvg();

		waitForElementToBeClickableThenClick(clickonSaveBtn);
		sleepMin();

		waitForElementToBeClickableThenClearThenSendkeys(selectTenantField, "TenantID");
		sleepAvg();

		waitForElementToBeClickableThenClick(clickonSaveBtn);
		sleepMin();
	}

		public void SearchTenant(Map<String, String> testData) throws InterruptedException {
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(showFilterBtn);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(clickshowFilterTypeForDeviceid,"Tenant ID");
		waitForElementToBeClickableThenSendkeys(SelectConditionType,"equals");
		waitForElementToBeClickableThenSendkeys(passingshowFilterValueForDeviceid, testData.get("TenantID"));
		waitForElementToBeClickableThenClick(clickfilter);
		sleepMAX();
	}

		public void checkonDevices(Map<String, String> testData) throws Exception
	{
			int count=tableValues.size();
		for(int i=1; i<count; i++)
		{
			String BSName=tableValues.get(i).getText();
			if(BSName.equalsIgnoreCase(testData.get("TenantID")))
			{
				int j=i;
				waitForElementToBeClickableThenClick(By.xpath(("(//div[@role='checkbox'])["+j+"]")));
				waitForElementToBeClickableThenClick(By.xpath(("(//div[@role='checkbox'])["+(j+1)+"]")));
				sleepAvg();

			}

		}

	}

	public void clickonBulkEdit() throws InterruptedException
	{
		waitForElementToBeClickableThenClick(BluckEdit);
		sleepMAX();
	}

	public void clickonCircle() throws InterruptedException
	{
		waitForElementToBeClickableThenClick(tickonfirstcircle);
		sleepMAX();
		waitForElementToBeClickableThenClick(nextButton);
	}

	public void clickonDviceStatus(Map<String, String> testData) throws InterruptedException
	{
		waitForElementToBeClickableThenClick(devicestatus);
		sleepAvg();
		waitForElementToBeClickableThenSendkeys(selectPart, testData.get("Part"));
		sleepMin();
	}

	public void clickonNextOK() throws InterruptedException
	{
		waitForElementToBeClickableThenClick(nextButton2);
		sleepAvg();
		waitForElementToBeClickableThenClick(nextButton3);
		sleepAvg();
		waitForElementToBeClickableThenClick(okButton);
		sleepAvg();
		waitForElementToBeClickableThenClick(finalizeButton);
		sleepMin();
	}

	public String verifyDeviceStatus(Map<String, String> testData) throws InterruptedException
	{
		sleepAvg();
		waitForElementToBeClickableThenClick(showFilterBtn);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(clickshowFilterTypeForDeviceid,"Tenant ID");
		waitForElementToBeClickableThenSendkeys(SelectConditionType,"equals");
		waitForElementToBeClickableThenSendkeys(passingshowFilterValueForDeviceid, testData.get("TenantID"));
		waitForElementToBeClickableThenClick(clickfilter);
		waitForAngularRequestsToFinish();
		String text=verifyPart.getText();
		return text;

	}

	public void AfterVerifyClear() throws InterruptedException
	{   waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(ClearBtn);

	}


	public void ClickHideFilter() throws InterruptedException
	{
		waitForElementToBeClickableThenClick(ClickHideFilter);

	}

	public void DeviceSettingSaveConformation() {
	    waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(DeviceSaveBTn);
	}




//suryaaa-----------------------------VMM-3249-----------------------------------------------------------
	public void CreateDeviceNew(Map<String, String> testData) throws InterruptedException {
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(DeviceTypesNewBtnForCreateD);
		waitForAngularRequestsToFinish();
		selectListByVisibleText(DevicesTypeField, testData.get("DeviceType"));
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(deviceIdField, testData.get("DeviceID"));
		if(testData.get("MAC Address")!="") {
		waitForElementToBeClickableThenSendkeys(MacAddressField, testData.get("MAC Address"));
	    }
		waitForElementToBeClickableThenSendkeys(serialNumberfield, testData.get("serial"));
		waitForElementToBeClickableThenSendkeys(PartNumberField, testData.get("partNo"));
		waitForElementToBeClickableThenSendkeys(cellularField, testData.get("cellular"));
		waitForElementToBeClickableThenSendkeys(IMEIField, testData.get("IMEINo"));
	}
	public void DeviceSave() throws InterruptedException {
		waitForElementToBeClickableThenClick(DeviceSaveBTn);
		waitForAngularRequestsToFinish();
	}

	public void SearchCreatedDevice(Map<String, String> testData) throws InterruptedException {
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(showFilterBtn);
		waitForElementToBeClickableThenSendkeys(clickshowFilterTypeForDeviceid,"Serial #");
		waitForElementToBeClickableThenSendkeys(SelectConditionType,"equals");
		waitForElementToBeClickableThenSendkeys(passingshowFilterValueForDeviceid, testData.get("serial"));
		waitForElementToBeClickableThenClick(clickfilter);
		sleepMAX();

	}

	public void deleteTheDevice() throws InterruptedException {
		waitForElementToBeClickableThenClick(DeleteDevice);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(DeleteDevicepopup);
		waitForAngularRequestsToFinish();
	}

	public void SelectDeleteIconCreatedDevice() throws InterruptedException {
		waitForElementToBeClickableThenClick(DeleteDevice);
		waitForAngularRequestsToFinish();
	}

	public void ConformDeleteCreatedDevice() throws InterruptedException {
		waitForElementToBeClickableThenClick(DeleteDevicepopup);
		waitForAngularRequestsToFinish();
	}

		//-----------------------------------Sunilkumar(VMM4443)---------------------------------
   	public void clickNewDevice(Map<String, String> testData) throws Exception { // TenantIdField
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(DeviceTypesNewBtnForCreateD);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(DevicesTypeField, testData.get("DeviceType"));
		waitForElementToBeClickableThenSendkeys(deviceIdField, testData.get("DeviceID"));
		if(testData.get("MAC Address")!="") {
		waitForElementToBeClickableThenSendkeys(MacAddressField, testData.get("MAC Address"));
	    }
		waitForElementToBeClickableThenSendkeys(serialNumberfield, testData.get("serial"));
		waitForElementToBeClickableThenSendkeys(PartNumberField, testData.get("partNo"));
		waitForElementToBeClickableThenSendkeys(cellularField, testData.get("cellular"));
		waitForElementToBeClickableThenSendkeys(IMEIField, testData.get("IMEINo"));
		waitForElementToBeClickableThenClick(TenantTxtFieldClick);
		if(testData.get("TenantID")!="") {
		waitForElementToBeClickableThenSendkeys(TenantTxtField, testData.get("TenantID"));
		waitForElementToBeClickableThenClick(suggestionRowFirstValue);
		}

	}

   	public void createNewDeviceNotAssignToTenant(Map<String, String> testData) throws Exception { // TenantIdField
		waitForAngularRequestsToFinish();
		sleepAvg();
		waitForElementToBeClickableThenClick(DeviceTypesNewBtnForCreateD);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(DevicesTypeField, testData.get("DeviceType"));
		waitForElementToBeClickableThenSendkeys(deviceIdField, testData.get("DeviceID"));
		if(testData.get("MAC Address")!="") {
		waitForElementToBeClickableThenSendkeys(MacAddressField, testData.get("MAC Address"));
	    }
		waitForElementToBeClickableThenSendkeys(serialNumberfield, testData.get("serial"));
		waitForElementToBeClickableThenSendkeys(PartNumberField, testData.get("partNo"));
		waitForElementToBeClickableThenSendkeys(cellularField, testData.get("cellular"));
		waitForElementToBeClickableThenSendkeys(IMEIField, testData.get("IMEINo"));
		waitForElementToBeClickableThenClick(DeviceSaveBTn);
		waitForAngularRequestsToFinish();
		sleepMin();
	}

	public void saveDevice() throws Exception {
		sleepAvg();
		waitForElementToBeClickableThenClick(DeviceSaveBTn);
		waitForAngularRequestsToFinish();
		sleepMAX();



	}

	public String dialogappear() throws Exception {
		sleepAvg();
		String dialog = assigndevices.getText();
		return dialog;
	}


	public void clicktoggleBtn(Map<String, String> testData) {
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(toggleBtn);
		int count=assignDeviceList.size();

		for(int i=0; i<count; i++)
		{
			String BSName=assignDeviceList.get(i).getText();
			if(BSName.equalsIgnoreCase(testData.get("Setting")))
			{
				System.out.println(BSName);
				int j=i;

				break;
			}

		}
		WebElement assignSettings=driver.findElement(By.xpath("//div[contains(text(),'"+testData.get("Setting")+"')]"));
		waitForElementToBeClickableThenClick(assignSettings);
		waitForAngularRequestsToFinish();


	}
	public void clickassignDeviceBtn() throws Exception {
		sleepMin();
		waitForElementToBeClickableThenClick(assignDeviceBtn);
		sleepMin();
		waitForAngularRequestsToFinish();
	}
	public void clickdeviceEditBtn() throws Exception {
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(deviceEdit);
		waitForAngularRequestsToFinish();
	}

	public Boolean UnassignBtnEnable() {

		if (UnassignBtn.isEnabled()) {

			return true;
		}
		return null;

		}
	public Boolean UnassignBtndisplayed() {

		if (UnassignBtn.isDisplayed()) {

			return true;
		}
		return null;

		}

			public String verifyTenantidTxtfild() {
			String status = TenantidTxtfild.getAttribute("aria-disabled");
			return status;

		}

	public void clickUnassignBtn() {
		waitForElementToBeClickableThenClick(UnassignBtn);
		waitForAngularRequestsToFinish();
	}

	public void clickUnassigndevicetxtfield(Map<String, String> testData) throws Exception {

		waitForAngularRequestsToFinish();
		//waitForElementToBeClickableThenClick(Unassigndevicetxtfield);
		selectListByVisibleText(EnterNotAssigned,"NOT_ASSIGNED");
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(UnassigndeviceBtn);
		waitForAngularRequestsToFinish();


	}

	//----------------------------------Sunilkumar(VMM4423)-----------------------------------------
		 public void createMultipleDevice(Map<String, String> testData) throws Exception {
			 waitForElementToBeClickableThenClick(newDeviceBtn);
			 waitForAngularRequestsToFinish();
				waitForElementToBeClickableThenSendkeys(DevicesTypeField, testData.get("DeviceType"));
				sleepMin();
				waitForElementToBeClickableThenSendkeys(deviceIdField, testData.get("DeviceID"));
				sleepMin();
				if(testData.get("MAC Address")!="") {
		         waitForElementToBeClickableThenSendkeys(MacAddressField, testData.get("MAC Address"));
	             }
				waitForElementToBeClickableThenSendkeys(serialNumberfield, testData.get("serial"));
				sleepMin();
				waitForElementToBeClickableThenSendkeys(PartNumberField, testData.get("partNo"));
				sleepMin();
				waitForElementToBeClickableThenSendkeys(cellularField, testData.get("cellular"));
				sleepMin();
				waitForElementToBeClickableThenSendkeys(IMEIField, testData.get("IMEINo"));
				sleepAvg();

				if(testData.get("addAnother").equals("YES")) {
					waitForElementToBeClickableThenClick(addanother);
				}

				waitForElementToBeClickableThenClick(DeviceSaveBTn);
				sleepMin();
				waitForElementToBeClickableThenSendkeys(deviceIdField, testData.get("DeviceID"));
				if(testData.get("MAC Address")!="") {
		      waitForElementToBeClickableThenSendkeys(MacAddressField, testData.get("MAC Address"));
	              }
				sleepMin();
				waitForElementToBeClickableThenSendkeys(serialNumberfield, testData.get("serial"));
				sleepMin();
				waitForElementToBeClickableThenSendkeys(PartNumberField, testData.get("partNo"));
				sleepMin();
				waitForElementToBeClickableThenSendkeys(cellularField, testData.get("cellular"));
				sleepMin();
				waitForElementToBeClickableThenSendkeys(IMEIField, testData.get("IMEINo"));
				sleepAvg();
				waitForElementToBeClickableThenClick(DeviceSaveBTn);

		 }
		 public void Devicecreate (Map<String, String> testData) throws Exception  {
			 sleepMAX();
        waitForAngularRequestsToFinish();
				waitForElementToBeClickableThenClick(DeviceTypesNewBtnForCreateD);
				waitForAngularRequestsToFinish();
				 sleepMin();
				waitForElementToBeClickableThenSendkeys(DevicesTypeField, testData.get("DeviceType"));
				sleepMin();
				waitForElementToBeClickableThenSendkeys(deviceIdField, testData.get("DeviceID"));
				if(testData.get("MAC Address")!="") {
		        waitForElementToBeClickableThenSendkeys(MacAddressField, testData.get("MAC Address"));
	            }
				sleepMin();
				waitForElementToBeClickableThenSendkeys(serialNumberfield, testData.get("serial"));
				sleepMin();
				waitForElementToBeClickableThenSendkeys(PartNumberField, testData.get("partNo"));
				sleepMin();
				waitForElementToBeClickableThenSendkeys(cellularField, testData.get("cellular"));
				sleepMin();
				waitForElementToBeClickableThenSendkeys(IMEIField, testData.get("IMEINo"));
				sleepMin();
				waitForElementToBeClickableThenClick(DeviceSaveBTn);
				sleepAvg();

		 }


		 //------------------------------------Sunulkumar(VMM4464)-------------------------------------------
		 public String verifyDevicestatustxt() {

			 String text = Devicestatustxt.getText();
			return text;

		 }

         public String verifyDatastatustxt() {

			 String text = Datastatustxt.getText();
			return text;

		 }

         public String unassigndialog() throws Exception {
     		sleepAvg();
     		String dialog = unassigndialog.getText();
     		return dialog;
     	}








	//surya=========================================VMM-3878=================================================

	//DeviceTypeDropDownInLicensesPage


	ArrayList<String> ActualDeviceTypeDropDwnValues=new ArrayList<String>();

	ArrayList<String> ExpectedDeviceTypeDropDwnValues=new ArrayList<String>();




	public List[] verifyDeviceTypeDropTownOrderINDevices() throws InterruptedException {
		sleepAvg();
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(DeviceTypeDropDwn);
		 for(int i=0;i<DeviceTypeDropDwnValues.size();i++) {

			 String DeviceTypeDropDwnText = DeviceTypeDropDwnValues.get(i).getText();

			 ActualDeviceTypeDropDwnValues.add(DeviceTypeDropDwnText);


		 }
		 ExpectedDeviceTypeDropDwnValues=ActualDeviceTypeDropDwnValues;
		 Collections.sort(ExpectedDeviceTypeDropDwnValues);
		 return new List[] {ActualDeviceTypeDropDwnValues,ExpectedDeviceTypeDropDwnValues};
	}

	//DeviceStatusDropDownInLicensesPage


		ArrayList<String> ActualDeviceStatus1DropDwnValues=new ArrayList<String>();

		ArrayList<String> ExpectedDeviceStatus1DropDwnValues=new ArrayList<String>();

		public List[] verifyDeviceStatusDropDown_OrderINDevicesINDevices() throws InterruptedException {
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenClick(DeviceStatusDropDwn);
			 for(int i=0;i<DeviceStatusDropDwnValues.size();i++) {

				 String DeviceStatus1DropDwnText = DeviceStatusDropDwnValues.get(i).getText();

				 ActualDeviceStatus1DropDwnValues.add(DeviceStatus1DropDwnText);


			 }
			 ExpectedDeviceStatus1DropDwnValues=ActualDeviceStatus1DropDwnValues;
			 Collections.sort(ExpectedDeviceStatus1DropDwnValues);
			 return new List[] {ActualDeviceStatus1DropDwnValues,ExpectedDeviceStatus1DropDwnValues};
		}




public void scrollToDeviceStatus() throws InterruptedException {
			scrollToElement("//*[text()='Device ID' and @class='ui-grid-header-cell-label ng-binding']");
			sleepMin();
			scrollToElement("//*[text()='Device Status' and @class='ui-grid-header-cell-label ng-binding']");
		}




//-----------------------------------------------------Nitin---------------------------------------------------------//
	public void clickOnBulkUploadAndUploadSpreadheet() throws InterruptedException
	{
		bulkUploadDrop.click();
		uploadSpreadsheetDrop.click();
		waitForAngularRequestsToFinish();
	}

	public void filterDeviceThroughTenantID(Map<String, String> testData) throws InterruptedException
	{
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(showFilters);
		waitForAngularRequestsToFinish();
		selectListByVisibleText(showFiltersFirstDropDown, "Tenant ID");
		waitForAngularRequestsToFinish();
		selectListByVisibleText(showFiltersSecondDropDown, "equals");
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(showFiltersFirstText, testData.get("TenantID"));
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(filterButton);
	}

	public boolean verifyTenantIDCreatedThroughSpreadsheet(Map<String, String> testData) throws InterruptedException
	{
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(showFilters);
		waitForAngularRequestsToFinish();
		selectListByVisibleText(showFiltersFirstDropDown, "Tenant ID");
		waitForAngularRequestsToFinish();
		selectListByVisibleText(showFiltersSecondDropDown, "equals");
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(showFiltersFirstText, testData.get("TenantID"));
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(addConditionn);
		waitForAngularRequestsToFinish();
		selectListByVisibleText(showFiltersFirstDropDownn, "Device Type");
		waitForAngularRequestsToFinish();
		selectListByVisibleText(showFiltersSecondDropDownn, "equals");
		waitForAngularRequestsToFinish();
		selectListByVisibleText(showFiltersSecondTextt, "Flashback");
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(filterButton);
		waitForAngularRequestsToFinish();
		for(WebElement list:listOfFilter)
		{
			String text = list.getText();
			if(text.contains(testData.get("TenantID")))
			{
				return true;
			}
		}
		return false;
	}

	public void clickUnassigndevice()
	{
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(unassignn);
		waitForAngularRequestsToFinish();
		selectListByVisibleText(statuss, "NOT_ASSIGNED");
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(unassignDevicee);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(savee);
	}

	public void createDeviceForSFCognitionn(Map<String, String> testData) throws InterruptedException {
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(DeviceTypesNewBtnForCreateD);
		waitForAngularRequestsToFinish();
		selectListByVisibleText(DevicesTypeField, testData.get("DeviceType"));
		waitForAngularRequestsToFinish();
		for(WebElement deviceTypee:deviceTypeListt)
		{
			System.out.println(deviceTypee.getText());
		}
		waitForElementToBeClickableThenSendkeys(deviceIdField, testData.get("DeviceID"));
		waitForElementToBeClickableThenSendkeys(PartNumberField, testData.get("partNo"));
		waitForElementToBeClickableThenClick(tenantIdd);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(tenantIddd, testData.get("TenantID"));
		waitForElementToBeClickableThenClick(suggestionRowFirstValuee);
		waitForElementToBeClickableThenClick(savee);
	}

	public void createDeviceeWithCustomerProvided(Map<String, String> testData)
	{
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(DeviceTypesNewBtnForCreateD);
		waitForAngularRequestsToFinish();
		selectListByVisibleText(DevicesTypeField, testData.get("DeviceType"));
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(deviceIdField, testData.get("DeviceID"));
		waitForElementToBeClickableThenSendkeys(PartNumberField, testData.get("partNo"));
		waitForElementToBeClickableThenClick(tenantIdd);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(tenantIddd, testData.get("TenantID"));
		waitForElementToBeClickableThenClick(suggestionRowFirstValuee);
		waitForElementToBeClickableThenClick(checkBoxxCustomerProvided);
		waitForElementToBeClickableThenClick(savee);
	}

	public void createDeviceeWithoutCustomerProvided(Map<String, String> testData)
	{
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(DeviceTypesNewBtnForCreateD);
		waitForAngularRequestsToFinish();
		selectListByVisibleText(DevicesTypeField, testData.get("DeviceType"));
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(deviceIdField, testData.get("DeviceID"));
		waitForElementToBeClickableThenSendkeys(PartNumberField, testData.get("partNo"));
		waitForElementToBeClickableThenClick(tenantIdd);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(tenantIddd, testData.get("TenantID"));
		waitForElementToBeClickableThenClick(suggestionRowFirstValuee);
		waitForElementToBeClickableThenClick(savee);
	}

	public boolean filterDeviceThroughTenantIDAndScrollSideways(Map<String, String> testData) throws InterruptedException
	{
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(showFilters);
		waitForAngularRequestsToFinish();
		selectListByVisibleText(showFiltersFirstDropDown, "Device ID");
		waitForAngularRequestsToFinish();
		selectListByVisibleText(showFiltersSecondDropDown, "equals");
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(showFiltersFirstText, testData.get("DeviceID"));
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(filterButton);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(showwAllFieldss);
		waitForAngularRequestsToFinish();
		scrollToElement("//*[text()='Device ID' and @class='ui-grid-header-cell-label ng-binding']");
		sleepMin();
		scrollToElement("//*[text()='Device Status' and @class='ui-grid-header-cell-label ng-binding']");
		sleepMin();
		scrollToElement("//*[text()='MEID/IMEI' and @class='ui-grid-header-cell-label ng-binding']");
		sleepMin();
		scrollToElement("//*[text()='Customer Provided' and @class='ui-grid-header-cell-label ng-binding']");
		waitForAngularRequestsToFinish();
		if(customerProvidedd.isSelected())
		{
			return true;
		}
		return false;
	}

	public void clickOnClearr()
	{
		waitForElementToBeClickableThenClick(clearr);
		waitForAngularRequestsToFinish();

	}

	public boolean filterDeviceThroughTenantIDAndScrollSidewaysAgain(Map<String, String> testData) throws InterruptedException
	{
		waitForAngularRequestsToFinish();
		selectListByVisibleText(showFiltersFirstDropDown, "Device ID");
		waitForAngularRequestsToFinish();
		selectListByVisibleText(showFiltersSecondDropDown, "equals");
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(showFiltersFirstText, testData.get("DeviceID"));
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(filterButton);
		waitForAngularRequestsToFinish();
		if(customerProvidedd.isSelected())
		{
			return true;
		}
		return false;
	}
//------------------------------------------------------Nitin--------------------------------------------------------//




//Surya------------------------------------------------------VMM-4643--------------------------------------------------------

		public void BlukUploadInDevices() throws InterruptedException{
		    sleepAvg();
			waitForElementToBeClickableThenClick(bulkUploadDrop);
			sleepMin();
			waitForElementToBeClickableThenClick(uploadSpreadsheetDrop);
			sleepMin();
		}

		public String verifyDeviceIsCreatedSuccessfully() throws InterruptedException {
			waitForElementToBeClickableThenClick(keyboard_arrow_down_ForCreatedSuccessfully);
			sleepMAX();
			String VerifyText=getWebelementText(VerifyDeviceCreatedSuccessfullyText);
			if(VerifyText!=null) {
				return VerifyText;
			}
			else {
				return null;
			}
		}

		public void ArrowUpForDeviceIsCreatedSuccessfully() throws InterruptedException {
			sleepAvg();
			waitForElementToBeClickableThenClick(keyboard_arrow_up_ForCreatedSuccessfully);
			sleepMin();

		}
		public String VerifyWarningMessageForDeviceSettingDataOfOtherDeviceType() throws InterruptedException {

			waitForElementToBeClickableThenClick(keyboard_arrow_down_ForWarning);
			sleepMAX();
			String VerifyText=getWebelementText(VerifyWarningText);
			if(VerifyText!=null) {
				return VerifyText;
			}
			else {
				return null;
			}

		}

		public void ArrowUpForWarning() throws InterruptedException {
			sleepMin();
			waitForElementToBeClickableThenClick(keyboard_arrow_up_ForCreatedSuccessfully);
			sleepMin();

		}

		public String VerifyAssignedTenant(Map<String, String> testData) {

			String verifyTenanttext = getWebelementText(VerifyTenantAssigned);
			if(verifyTenanttext!=null) {
				return verifyTenanttext;
			}
			else {
				return null;
			}

		}

		public String VerifyNotAssignedTenant() {
			String verifyNotAssignedTenant = getWebelementText(VerifyTenantAssigned);
			if(verifyNotAssignedTenant.isEmpty()) {
				return "notAssigned";
			}
			else {
				return verifyNotAssignedTenant;
			}

		}

		public void UnassignTenantInDevices() throws InterruptedException {
			sleepMin();
			waitForElementToBeClickableThenClick(EditDevice);
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenClick(UnAssignDevice);
			selectListByVisibleText(DeviceSettingStatus, "NOT_ASSIGNED");
			waitForElementToBeClickableThenClick(ConformUnAssignDevice);
			waitForElementToBeClickableThenClick(EditDeviceSave);
			sleepAvg();


		}

		public void SearchBulkCreatedDevice(Map<String, String> testData) throws InterruptedException {
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenClick(showFilterBtn);
 			waitForElementToBeClickableThenSendkeys(SelectFilterType,"Serial #");
			waitForElementToBeClickableThenSendkeys(SelectConditionType,"equals");
			waitForElementToBeClickableThenSendkeys(PassingValueInShowFilter, testData.get("serial"));
			waitForElementToBeClickableThenClick(clickfilter);
      waitForAngularRequestsToFinish();
		}


		public boolean verifyDeviceSettingIconEnabled() throws InterruptedException{
		    sleepAvg();
		    boolean verifydeviceSettingEnabled = NavigateToSettingIcon.isEnabled();
			if(verifydeviceSettingEnabled==true) {
				return true;
			}
			else {
				return false;
			}

		}
		public String verifyDeviceSettingIconDisabled() throws InterruptedException{
		    sleepAvg();
		    String verifydeviceSettingDisabled = NavigateToSettingIcon.getAttribute("aria-disabled");

			if(verifydeviceSettingDisabled!=null) {
				return verifydeviceSettingDisabled;
			}
			else {
				return "false";
			}

		}

		public void navigatetoSettingViewPage() throws InterruptedException {
			waitForElementToBeClickableThenClick(NavigateToSettingIcon);
			waitForAngularRequestsToFinish();
			sleepAvg();

		}

		public void BackInSettingViewPage() throws InterruptedException {
			waitForElementToBeClickableThenClick(BackInViewSettingPage);
		}

		public String VerifyDeviceStatus() throws InterruptedException {


			String verifydevicestatus = getWebelementText(VerifyDeviceStatus);
			if(verifydevicestatus!=null) {
				return verifydevicestatus;
			}
			else {
				return null;
			}


		}

           public String VerifyDataStatus() throws InterruptedException {


			String verifydeviceData = getWebelementText(VerifyDataStatus);
			if(verifydeviceData!=null) {
				return verifydeviceData;
			}
			else {
				return null;
			}
		}

        public void deleteBulkCreatedDevice() throws InterruptedException {
        	sleepAvg();
        	waitForElementToBeClickableThenClick(DeleteDevice);
        	sleepAvg();
    		waitForElementToBeClickableThenClick(DeleteDevicepopup);
        }

        public void SelectAllFields() {
        	waitForElementToBeClickableThenClick(SelectAllFields);
        }


//---------------------------------------------------------------------------------------------------------------------



		////// Naincy
	public void SearchCreatedDeviceByContains(Map<String, String> testData) throws InterruptedException {
		waitForElementToBeClickableThenClick(showFilterBtn);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(clickshowFilterTypeForDeviceid,"Device ID");
		waitForElementToBeClickableThenSendkeys(SelectConditionType,"contains");
		waitForElementToBeClickableThenSendkeys(passingshowFilterValueForDeviceid, testData.get("DeviceID"));
		waitForElementToBeClickableThenClick(clickfilter);
		waitForAngularRequestsToFinish();
	}


    public void selectTwoDeviceForBulkEdit(Map<String, String> testData) throws InterruptedException {
				DeviceOne.click();
				DeviceTwo.click();
			}


    public void clickOnBulkEdit(Map<String, String> testData) throws InterruptedException {
    	BulkEditBtn.click();

	}

    public void clickOnDevicesManuallySelected() throws InterruptedException {
    	DevicesManuallySelectedBtn.click();
    	NextBtn.click();
	}

    //Edit Device Type
    public void editDeviceType() throws InterruptedException {
    	waitForElementToBeClickableThenClick(selectDeviceTypeBtn);
    	selectListByVisibleText(DeviceTypeList,"Core Controller");
    	NextBtn.click();
    	sleepMAX();
    	NextBtn.click();
    	waitForElementToBeClickableThenClick(OkBtn);

	}

	//Rajath VMM_3592-------------------------------------------------------------------

		public void deviceSearch(Map<String, String> testData) throws InterruptedException {
			sleepAvg();
			waitForElementToBeClickableThenClick(showFilterBtn);
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenSendkeys(clickshowFilterTypeForDeviceid,"Device ID");
			sleepMin();
			waitForElementToBeClickableThenSendkeys(SelectConditionType,"equals");
			sleepMin();
			waitForElementToBeClickableThenSendkeys(passingshowFilterValueForDeviceid, testData.get("DeviceID"));
			sleepMin();
			waitForElementToBeClickableThenClick(clickfilter);
			Thread.sleep(3000);
			//waitForElementToBeClickableThenClick(ClickHideFilter);
		}

		public void deviceSearchWithClearValue(Map<String, String> testData) throws InterruptedException {
			sleepMin();
			waitForElementToBeClickableThenClick(cleardevice);
			 sleepMin();
			waitForElementToBeClickableThenSendkeys(clickshowFilterTypeForDeviceid,"Device ID");
			sleepMin();
			waitForElementToBeClickableThenSendkeys(SelectConditionType,"equals");
			sleepMin();
			waitForElementToBeClickableThenClearThenSendkeys(passingshowFilterValueForDeviceid,"");
			//sleepMin();
			waitForAngularRequestsToFinish();
			//driver.navigate().refresh();

		}

			//Rajath VMM_4578-------------------------------------------------------------------
	public void NewdeviceCreate(Map<String, String> testData) throws InterruptedException {
		waitForElementToBeClickableThenClick(DeviceTypesNewBtnForCreateD);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(DevicesTypeField, testData.get("DeviceType"));
		sleepMin();
		waitForElementToBeClickableThenSendkeys(deviceIdField, testData.get("DeviceID"));
		if(testData.get("MAC Address")!="") {
		waitForElementToBeClickableThenSendkeys(MacAddressField, testData.get("MAC Address"));
	    }
		sleepMin();
		waitForElementToBeClickableThenSendkeys(serialNumberfield, testData.get("serial"));
		sleepMin();
		waitForElementToBeClickableThenSendkeys(PartNumberField, testData.get("partNo"));
		sleepMin();
		waitForElementToBeClickableThenSendkeys(cellularField, testData.get("cellular"));
		sleepMin();
		waitForElementToBeClickableThenSendkeys(IMEIField, testData.get("IMEINo"));
		sleepMin();
		waitForElementToBeClickableThenClick(DeviceSaveBTn);
	}

	public void createdDevicesearch(Map<String, String> testData) throws InterruptedException {
		//sleepAvg();
		waitForElementToBeClickableThenClick(showFilterBtn);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(clickshowFilterTypeForDeviceid,"Device ID");
		sleepMin();
		waitForElementToBeClickableThenSendkeys(SelectConditionType,"equals");
		sleepMin();
		waitForElementToBeClickableThenClearThenSendkeys(passingshowFilterValueForDeviceid, testData.get("DeviceID"));
		sleepMin();
		waitForElementToBeClickableThenClick(clickfilter);
		waitForAngularRequestsToFinish();
		Thread.sleep(3000);
	}

	public void clickOnEditDevice() throws InterruptedException {
		sleepMin();
		waitForElementToBeClickableThenClick(editbtn);
		waitForAngularRequestsToFinish();
	}

	public Boolean settingBtnDisabled() {

        if (settingicon.isDisplayed()) {

			return true;
		}
		return null;
	}
	public void deleteCreateddevice () throws InterruptedException {
		waitForElementToBeClickableThenClick(DeleteDevice);
		sleepAvg();
	}

	public void deleteDeviceOkBtn () throws InterruptedException {
		waitForElementToBeClickableThenClick(DeleteDevicepopup);
		sleepMin();

	}

	public void createdDeviceSearchFilterverify(Map<String, String> testData) throws InterruptedException {
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(showFilterBtn);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(clickshowFilterTypeForDeviceid,"Device ID");
		sleepMin();
		waitForElementToBeClickableThenSendkeys(SelectConditionType,"equals");
		sleepMin();
		waitForElementToBeClickableThenSendkeys(passingshowFilterValueForDeviceid, testData.get("DeviceID"));
		sleepMin();
		waitForElementToBeClickableThenClick(clickfilter);
		Thread.sleep(3000);
	}

	public String VerifyDeviceTypeTxtBx(Map<String, String> testData) {       //2

		String verifyDeviceTypetext = getWebelementText(devicetypetxtbox);
		if(verifyDeviceTypetext!=null) {
			return verifyDeviceTypetext;
		}
		else {
			return null;
		}

	}







	//Rajath VMM-4758------------------------------------------
	public void newDeviceCreate(Map<String, String> testData) throws InterruptedException {
		waitForElementToBeClickableThenClick(DeviceTypesNewBtnForCreateD);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(DevicesTypeField, testData.get("DeviceType"));
		sleepMin();

		sleepMin();
		waitForElementToBeClickableThenSendkeys(deviceIdField, testData.get("DeviceID"));
		if(testData.get("MAC Address")!="") {
		waitForElementToBeClickableThenSendkeys(MacAddressField, testData.get("MAC Address"));
	    }
		sleepMin();
		waitForElementToBeClickableThenSendkeys(serialNumberfield, testData.get("serial"));
		sleepMin();
		waitForElementToBeClickableThenSendkeys(PartNumberField, testData.get("partNo"));
		sleepMin();
		waitForElementToBeClickableThenSendkeys(cellularField, testData.get("cellular"));
		sleepMin();
		waitForElementToBeClickableThenSendkeys(IMEIField, testData.get("IMEINo"));
		sleepMin();
		waitForElementToBeClickableThenClick(DeviceSaveBTn);

	}

	public void clickNewDevicemultiple(Map<String, String> testData) throws Exception { // TenantIdField
		waitForElementToBeClickableThenClick(DeviceTypesNewBtnForCreateD);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(DevicesTypeField, testData.get("DeviceType"));
		sleepMin();
		waitForElementToBeClickableThenSendkeys(deviceIdField, testData.get("DeviceID"));
		if(testData.get("MAC Address")!="") {
		waitForElementToBeClickableThenSendkeys(MacAddressField, testData.get("MAC Address"));
	    }
		sleepMin();
		waitForElementToBeClickableThenSendkeys(serialNumberfield, testData.get("serial"));
		sleepMin();
		waitForElementToBeClickableThenSendkeys(PartNumberField, testData.get("partNo"));
		sleepMin();
		waitForElementToBeClickableThenSendkeys(cellularField, testData.get("cellular"));
		sleepMin();
		waitForElementToBeClickableThenSendkeys(IMEIField, testData.get("IMEINo"));
		sleepAvg();

		waitForElementToBeClickableThenClick(TenantTxtFieldClick);
		waitForElementToBeClickableThenSendkeys(TenantTxtField, testData.get("TenantID"));
		waitForElementToBeClickableThenClick(suggestionRowFirstValue);

		waitForElementToBeClickableThenClick(DeviceSaveBTn);
	}


	//Rajath VMM_4578-------------------------------------------------------------------
	 public void TenantIdsearch (Map<String, String> testData) throws InterruptedException {
		 sleepAvg();

		 waitForElementToBeClickableThenClick(TenantTxtFieldClick);
			waitForElementToBeClickableThenSendkeys(TenantTxtField, testData.get("TenantID"));
			waitForElementToBeClickableThenClick(suggestionRowFirstValue);
			sleepMin();


		// selectListByVisibleText(tenantidfield, testData.get("TenantID").toLowerCase());
		 //sleepAvg();
	  }

		public boolean verify_DeviceId_Serial_MacAdd_FieldIsMandatory(Map<String, String> testData) throws InterruptedException {
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenClick(DeviceTypesNewBtnForCreateD);
			waitForAngularRequestsToFinish();
			selectListByVisibleText(DevicesTypeField, testData.get("DeviceType"));
			waitForAngularRequestsToFinish();
			waitForElementToBeClickableThenSendkeys(deviceIdField, testData.get("DeviceID"));
			if(testData.get("MAC Address")!="") {
			waitForElementToBeClickableThenSendkeys(MacAddressField, testData.get("MAC Address"));
		    }
			waitForElementToBeClickableThenSendkeys(serialNumberfield, testData.get("serial"));
			waitForElementToBeClickableThenSendkeys(PartNumberField, testData.get("partNo"));
			waitForElementToBeClickableThenSendkeys(cellularField, testData.get("cellular"));
			waitForElementToBeClickableThenSendkeys(IMEIField, testData.get("IMEINo"));

			String[] a = {"DeviceID", "serial", "MAC Address"};
			WebElement[] b = {deviceIdField, serialNumberfield, MacAddressField};
			boolean flag =false;

			for(int i=0; i<a.length; i++) {
			flag =false;
			System.out.println(DeviceSaveBTn.getAttribute("aria-disabled"));
			if(DeviceSaveBTn.getAttribute("aria-disabled").equals("false"))
			{
				waitForElementToBeClickableThenClear(b[i], testData.get(a[i]));
				waitForAngularRequestsToFinish();
				if(DeviceSaveBTn.getAttribute("aria-disabled").equals("true"))
					System.out.println("Verified the field and is Mandatory");
				flag =true;
				waitForElementToBeClickableThenSendkeys(b[i], testData.get(a[i]));
				waitForAngularRequestsToFinish();
			}
			else
				flag = false;
			}

			return flag;


		}

		public void editDeviceType(String Device_Type) throws InterruptedException {
			waitForAngularRequestsToFinish();
	    	//waitForElementToBeClickableThenClick(selectDeviceTypeBtn);
	    	waitForElementToBeClickableThenClick(DeviceTypeList);
	    	waitForAngularRequestsToFinish();
	    	selectListByVisibleText(DeviceTypeList,Device_Type);
	    	waitForAngularRequestsToFinish();
	    	waitForElementToBeClickableThenClick(DeviceTypeList);
	    	//NextBtn.click();
	    	//sleepMAX();
	    	//NextBtn.click();
	    	//waitForElementToBeClickableThenClick(OkBtn);

		}

		public boolean verify_DeviceId_MacAddress_FieldIsMandatory(Map<String, String> testData) throws InterruptedException {

			waitForElementToBeClickableThenClear(serialNumberfield, testData.get("serial"));
			String[] a = {"DeviceID", "MAC Address"};
			WebElement[] b = {deviceIdField, MacAddressField};

			boolean flag =false;

			for(int i=0; i<a.length; i++) {
			flag =false;
			if(DeviceSaveBTn.getAttribute("aria-disabled").equals("false"))
			{
				waitForElementToBeClickableThenClear(b[i], testData.get(a[i]));
				waitForAngularRequestsToFinish();
				if(DeviceSaveBTn.getAttribute("aria-disabled").equals("true"))
					System.out.println("Verified the field and is Mandatory");
				flag =true;
				waitForElementToBeClickableThenSendkeys(b[i], testData.get(a[i]));
				waitForAngularRequestsToFinish();
			}
			else
				flag = false;
			}

			return flag;


		}

		public boolean verifyErrorMessageForDevice(String expErrorMsg) throws InterruptedException {
			boolean flag=false;
			waitForElementToBeClickableThenClick(keyboard_arrow_down_ForError);
			sleepMin();
			for(int i=0; i<deviceErrorMsg.size(); i++) {
				flag=false;
				if(deviceErrorMsg.get(i).getText().contains(expErrorMsg))
					flag=true;
				else
					break;
			}

				return flag;

		}

		public void ArrowUpForDeviceErroredOut() throws InterruptedException {
			sleepAvg();
			waitForElementToBeClickableThenClick(keyboard_arrow_up_ForError);
			sleepMin();

		}

		public String verifyDeviceNotAvailable() {
			String DEstatus = getWebelementText(deviceDashboardList);
		   if(DEstatus!=null)
		     return DEstatus;
		   else
	          return null;
		}

		public boolean verifySuccessMessageForDevice(String expSuccessMsg) throws InterruptedException {
			boolean flag=false;
			waitForElementToBeClickableThenClick(keyboard_arrow_down_ForSuccess);
			sleepMin();
			for(int i=0; i<deviceCreatedList.size(); i++) {
				flag=false;
				if(deviceCreatedList.get(i).findElement(By.tagName("td")).getText().contains(expSuccessMsg))
					flag=true;
				else
					break;
			}

				return flag;

		}

		@FindBy(xpath = "//*[@role='columnheader']//span[text()='Tenant ID']")
		WebElement colTenantID;

		@FindBy(xpath = "//*[@role='columnheader']//span[text()='Part #']")
		WebElement colPartNum;

		@FindBy(xpath = "//*[@role='columnheader']//span[text()='Device Type']")
		WebElement colDeviceType;

		@FindBy(xpath = "//*[@role='columnheader']//span[text()='Serial #']")
		WebElement colSerialNum;

		@FindBy(xpath = "//*[@role='columnheader']//span[text()='Device ID']")
		WebElement colDeviceID;

		@FindBy(xpath = "//*[@role='columnheader']//span[text()='MAC Address']")
		WebElement colMacAdd;

		@FindBy(xpath = "//*[@role='columnheader']//span[text()='SO #']")
		WebElement colSOnum;

		@FindBy(xpath = "//*[@role='columnheader']//span[text()='Expiration Date']")
		WebElement colExpDate;

		@FindBy(xpath = "//*[@role='columnheader']//span[text()='Device Status']")
		WebElement colDeviceStatus;

		@FindBy(xpath = "//*[@role='columnheader']//span[text()='Data Status']")
		WebElement colDataStatus;

		@FindBy(xpath = "//*[@role='columnheader']//span[text()='Provision Date']")
		WebElement colProvDate;

		@FindBy(xpath = "//*[@role='columnheader']//span[text()='Cellular Carrier']")
		WebElement colCellCarrier;

		@FindBy(xpath = "//*[@role='columnheader']//span[text()='Customer Provided']")
		WebElement colCustProvided;

		@FindBy(xpath = "//*[@role='columnheader']//span[text()='Setting']")
		WebElement colSetting;

		public boolean verifyAllColumnsAvailableInDevicesScreen() {

			waitForElementToBeClickableThenClick(showwAllFieldss);
			waitForAngularRequestsToFinish();

			colTenantID.isDisplayed();
					colPartNum.isDisplayed();
					colDeviceType.isDisplayed();
					colSerialNum.isDisplayed();
					colDeviceID.isDisplayed();
					colMacAdd.isDisplayed();
					scrollToElement(colCellCarrier);
					colSOnum.isDisplayed();
					colExpDate.isDisplayed();
					colDeviceStatus.isDisplayed();
					colDataStatus.isDisplayed();
					colProvDate.isDisplayed();
					colCellCarrier.isDisplayed();
					scrollToElement(colSetting);
					colCustProvided.isDisplayed();
					colSetting.isDisplayed();


			  return true;

		}

		public void clickOnNewDevice() {
			waitForElementToBeClickableThenClick(newDeviceBtn);
			waitForAngularRequestsToFinish();
		}

		public boolean verifyMandatoryFieldsForDeviceType1(Map<String, String> testData) throws Exception {

			waitForElementToBeClickableThenSendkeys(DevicesTypeField, testData.get("DeviceType"));
			//selectListByVisibleText(deviceTypeDrp, deviceType);
			if(deviceIDTxt.getAttribute("aria-required").equalsIgnoreCase("true") &&
					serialNumberfield.getAttribute("aria-required").equalsIgnoreCase("true") &&
					MacAddressField.getAttribute("aria-required").equalsIgnoreCase("true"))
			{
				return true;

			}
			else {
				return false;
			}

		}

		public boolean verifyMandatoryFieldsForDeviceType2(Map<String, String> testData) throws Exception {

			waitForElementToBeClickableThenSendkeys(DevicesTypeField, testData.get("DeviceType"));
			//selectListByVisibleText(deviceTypeDrp, deviceType);
			if(deviceIDTxt.getAttribute("aria-required").equalsIgnoreCase("true") &&
					MacAddressField.getAttribute("aria-required").equalsIgnoreCase("true"))
			{
				return true;

			}
			else {
				return false;
			}

		}

		public boolean verifyMandatoryFieldsForDeviceType3(Map<String, String> testData) throws Exception {

			waitForElementToBeClickableThenSendkeys(DevicesTypeField, testData.get("DeviceType"));
			//selectListByVisibleText(deviceTypeDrp, deviceType);
			if(deviceIDTxt.getAttribute("aria-required").equalsIgnoreCase("true"))
			{
				return true;

			}
			else {
				return false;
			}

		}

		public void clickOnCancelBtn() {
			waitForElementToBeClickableThenClick(deviceCancelBtn);
		}

		//Tenant Filter - Start
		@FindBy(xpath="//button[@ng-click='addCondition()']")
		WebElement AddConditionBtn;

	  	@FindBy(xpath="(//select)[2]")
		WebElement conditionField1;

		@FindBy(xpath="(//select)[3]")
		WebElement conditionOperation1;

		@FindBy(xpath="(//select)[5]")
		WebElement conditionFieldValue1;

		@FindBy(xpath="(//select)[6]")
		WebElement conditionField2;

		@FindBy(xpath="(//select)[8]")
		WebElement conditionOperation2;

		@FindBy(xpath="(//select)[9]")
		WebElement conditionFieldValue2;

		@FindBy(xpath="(//select)[10]")
		WebElement conditionField3;

		@FindBy(xpath="(//select)[12]")
		WebElement conditionOperation3;

		@FindBy(xpath="(//select)[13]")
		WebElement conditionFieldValue3;
		//Tenant Filter - end

		@FindBy(xpath="//*[@id='deviceType']")
		WebElement deviceTypeTxt;

		@FindBy(xpath="//*[@id='status']")
		WebElement deviceStatusTxt;

	    @FindBy(xpath="//i[normalize-space()='visibility']")
		WebElement deviceView;

		public void filter1(Map<String, String> testData) {
			selectListByVisibleText(conditionField1,testData.get("Filter1"));
			selectListByVisibleText(conditionOperation1,testData.get("FilterOperation1"));
			//waitForElementToBeClickableThenClearThenSendkeys(conditionFieldValue1,testData.get("FilterValue1"));
			//waitForElementToBeClickableThenClick(conditionFieldValue1);
			selectListByVisibleText(conditionFieldValue1,testData.get("FilterValue1"));
		}

		public void filter2(Map<String, String> testData) {
			waitForElementToBeClickableThenClick(AddConditionBtn);
			selectListByVisibleText(conditionField2,testData.get("Filter2"));
			selectListByVisibleText(conditionOperation2,testData.get("FilterOperation2"));
			//waitForElementToBeClickableThenClick(conditionFieldValue2);
			selectListByVisibleText(conditionFieldValue2,testData.get("FilterValue2"));
		}

		public void filter3(Map<String, String> testData) {
			waitForElementToBeClickableThenClick(AddConditionBtn);
			selectListByVisibleText(conditionField3,testData.get("Filter3"));
			selectListByVisibleText(conditionOperation3,testData.get("FilterOperation3"));
			//waitForElementToBeClickableThenClick(conditionFieldValue3);
			selectListByVisibleText(conditionFieldValue3,testData.get("FilterValue3"));
		}

		public void clickOnShowFilter() {
			waitForElementToBeClickableThenClick(showFilterBtn);
		}

		public void searchDevicesWithTwoCondition(Map<String, String> testData) throws InterruptedException {

			filter1(testData);
			filter2(testData);

			waitForElementToBeClickableThenClick(clickfilter);
		  	waitForAngularRequestsToFinish();
			//waitForElementToBeClickableThenClick(ClickHideFilter);

		}

	     public void clickOnDeviceViewBtn ()  {
			 waitForElementToBeClickableThenClick(deviceView);
			 waitForAngularRequestsToFinish();
	     }


		 public String getDeviceTypeFromViewScreen() {

				return deviceTypeTxt.getText();
		 }

		 public String getDeviceStatusFromViewScreen() {

			 return deviceStatusTxt.getText();
		 }

		 public void clickOnBulkUpload()
		 {
			 bulkUploadDrop.click();
		 }

		 public boolean verifyBulkUploadOptions()
		 {
			 if(uploadSpreadsheetDrop.isDisplayed() && downloadSpreadsheetDrop.isDisplayed())
				{
					return true;

				}
				else {
					return false;
				}
		 }


		 public void clickBulkDownloadSpreadsheet() throws InterruptedException
		 {
			 waitForElementToBeClickableThenClick(downloadSpreadsheetDrop);
			 Thread.sleep(3000);
		 }

		 public String getDeviceId() {
			 String deviceId = getWebelementText(DeviceId).trim();

			 return deviceId;
		 }

			@FindBy(xpath= "//pre")
			WebElement responseData;

		 public String hitPHPEndpoint(Map<String, String> testdata, String env) {
			 String url = null;
			 String deviceId_TEST = testdata.get("DeviceID_TEST");
			 String deviceId_STG = testdata.get("DeviceID_STG");
			 String deviceId = testdata.get("DeviceID");
			 if(env.equals("PROD"))
				 url = testdata.get("PHP_endpoint")+deviceId;
			 else if(env.equals("STG"))
			 {
				 if(!deviceId_STG.isEmpty())
					 deviceId = deviceId_STG;
				 url = "https://stg-license-manager.safefleetcloud.us/device.php?id="+deviceId;
			 }
			 else if(env.equals("TEST"))
			 {
				 if(!deviceId_TEST.isEmpty())
					 deviceId = deviceId_TEST;
				 url = "https://test-license-manager.safefleetcloud.us/device.php?id="+deviceId;
			 }

			 driver.get(url);
			 System.out.println(url);
			 String response = responseData.getText();
			 return response;
		 }

		 public String hitDeviceConfigEndpoint(Map<String, String> testdata, String env) {
			 String url = null;
			 String response = null;
			 String deviceId = testdata.get("DeviceID");
			 if(env.equals("PROD"))
				 url = testdata.get("DeviceConfig_endpoint")+deviceId;
			 else if(env.equals("STG"))
				 url = "https://stg.safefleetcloud.com/deviceConfig/"+deviceId;
			 else if(env.equals("TEST"))
				 url = "https://test.safefleetcloud.com/deviceConfig/"+deviceId;


			 driver.get(url);
			 try {
			 response = responseData.getText();
			 }
			 catch(Exception e) {
				 System.out.println("No response data available");
			 }
			 return response;
		 }

		 public String getTheCurrentUrl() {

			 String currentUrl = driver.getCurrentUrl();

			return currentUrl;

		 }

		 public String hitCloudConfigEndpoint(Map<String, String> testdata, String env) {
			 String url = null;
			 String response = null;
			 String deviceId = testdata.get("DeviceID");
			 if(env.equals("PROD"))
				 url = testdata.get("CloudConfig_endpoint")+deviceId;
			 else if(env.equals("STG"))
				 url = "https://stg.safefleetcloud.com/cloudConfig/"+deviceId;
			 else if(env.equals("TEST"))
				 url = "https://test.safefleetcloud.com/cloudConfig/"+deviceId;


			 driver.get(url);
			 try {
			 response = responseData.getText();
			 }
			 catch(Exception e) {
				 System.out.println("No response data available");
			 }
			 return response;
		 }


}
