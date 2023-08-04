package safefleetLM.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import safefleetLM.componentgroups.ReusableLibrary;

public class EcosystemSettingsPage extends ReusableLibrary  {

	WebDriver driver;

	public EcosystemSettingsPage(WebDriver driver)  {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}




	@FindBy(xpath="//*[@id='mm-0']/div[2]/div/div[1]/div[2]/button")
	WebElement newEcosystemSettingsBtn;


//
	@FindBy(xpath="//*[@id='field_fleet_id']/div[1]/span")
	WebElement tenantIDTxt;

	@FindBy(xpath="(//input[@type='search'])[2]")
	WebElement tenantIDTxtBox;

	@FindBy(xpath="//span[@class='ui-select-choices-row-inner']")
	WebElement suggestionRowFirstValue;


	@FindBy(xpath="//*[@id='field_softwareGroup']")
	WebElement ecosystemTxt;

	@FindBy(xpath="//*[@id='field_fleet_id']/input[1]")
	WebElement ecosystemInp;



	@FindBy(xpath="//*[@id=\"mm-0\"]/div[2]/form/div[1]/div/button[2]")
	WebElement saveEcosystemBtn;

	@FindBy(xpath="//*[@id=\"assign_setting_select_field\"]/div[1]/span/span[2]")
	WebElement deviceSettingsDrp;

	@FindBy(xpath="//*[@id=\"mm-0\"]/div[2]/div/div[2]/div[2]/table/thead/tr/th[3]/export/i")
	WebElement ecosystemSettingsExportBtn;




	//------------------------Sunilkumar(VMM-3375)--------------------------

	@FindBy(xpath="//span[@class='showHideFilters ng-binding']")
	WebElement showfilterBtn;

	@FindBy(xpath="//*[@id=\"mm-0\"]/div[2]/div/div[2]/div[1]/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[1]/div/select")
	WebElement ecosystemfilter1;

	@FindBy(xpath="//*[@id=\"mm-0\"]/div[2]/div/div[2]/div[1]/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[2]/div[1]/select")
	WebElement ecosystemfilter2;

	@FindBy(xpath="//*[@id=\"mm-0\"]/div[2]/div/div[2]/div[1]/query-builder-container/div[2]/query-builder/div/div[2]/div/div/div/div/p[3]/div/input")
	WebElement ecosystemfilter3;

	@FindBy(xpath="//*[@id=\"mm-0\"]/div[2]/div/div[2]/div[1]/query-builder-container/div[3]/button[2]/span")
	WebElement filterBtn;

	@FindBy(xpath="//td[normalize-space()='abcd02']")
	WebElement verifyecosetting;


	@FindBy(xpath="//i[normalize-space()='visibility']")
	WebElement viewmetadata;

	@FindBy(xpath="//h4[normalize-space()='View Ecosystem Settings']")
	WebElement verifymetadata;

	@FindBy(xpath="//option[@value='string:m']")
	WebElement verifyedit;

	@FindBy(xpath="//*[@id=\"mm-0\"]/div[2]/div/div[2]/div[2]/table/tbody/tr/td[3]/button[2]/i")
	WebElement editecosetting;

	@FindBy(xpath="//*[@id=\"jsonIdDistanceUnits\"]")
	WebElement editdistance;

	@FindBy(xpath="//*[@id=\"mm-0\"]/div[2]/form/div[1]/div/button[1]/span")
	WebElement backtoecosetting;

	@FindBy(xpath="//*[@id=\"mm-0\"]/div[2]/form/div[1]/div/button[2]/span")
	WebElement saveedit;

	@FindBy(xpath="(//i[normalize-space()='delete'])[1]")
	WebElement deletemetadata;

	@FindBy(xpath="(//span[normalize-space()='Delete'])[1]")
	WebElement confirmdelete;

	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	WebElement EcosysCancleBtn;


	//------------------------Sunilkumar(VMM-3393)--------------------------
	@FindBy(xpath = "//div[@class='filterButtons']//span[@class='ng-scope'][normalize-space()='Clear']")
	WebElement clearfilterBtn;

	@FindBy(xpath ="//tbody/tr[1]/td[3]/button[4]/i[1]")
	WebElement ecoclipboardBtn;

	@FindBy(xpath ="//button[@class='btn btn-primary pull-right']")
	WebElement auditchangelist;

	@FindBy(xpath ="//p[contains(text(),'Last')]")
	WebElement ChangesforSettingsInstance;

	@FindBy(xpath="//div[@id='mm-0']/div[2]/div/div[2]/div[2]/jh-alert/div/div/div/div/pre")
	WebElement ecosettingcreatesuccesspopup;

	@FindBy(xpath="//div[@id='mm-0']/div[2]/form/div[2]/jh-alert-error/div/div/div/div/pre")
	WebElement ecosettingExistpopup;

	//----------------Sunilkumar(VMM3408)-------------------------------------------
	@FindBy(xpath="//div[@class='form-group label-floating ng-scope is-empty']//label[@class='control-label']")
	WebElement tenantIDlabel;

	@FindBy(xpath="//span[normalize-space()='Back']")
	WebElement ecosettingbackBtn;

	@FindBy(xpath="(//span[@class='ng-binding ng-scope'])[2]")
	WebElement tenantidfield;

	@FindBy(xpath="//pre[@class='ng-binding ng-scope']")
	WebElement ecosysAlertMessage;

	@FindBy(xpath = "//button[@class='btn btn-default btn-raised']")
	WebElement cancleSetting;


	//Bhanu-------------------------------------------------------------
	@FindBy(xpath="//option[@label='Setting Type']")
	WebElement settingTypeFilter;

	@FindBy(xpath="//p[@class='input-group'][1]")
	WebElement SelectFilterType;

	@FindBy(xpath="(//div[@class='form-group'])[1]")
	WebElement SelectFilterType2;

	@FindBy(xpath="//span[contains(text(),'Show Filter')]")
	WebElement ShowFilterClick;

	@FindBy(xpath="(//option[@label='equals'][1]/..)[1]")
	WebElement EqualsBoxFilter;

	@FindBy(xpath="//option[@label='Tenant ID']")  //option[@label='Tenant ID']]
	WebElement TenantIdOption;

	@FindBy(xpath="//td[contains(text(),'test')]")
	List<WebElement> ThreeFilterFoundedValues;

	@FindBy(xpath="(//span[text()='Filter'])[2]")
	WebElement filterButton;

	@FindBy(xpath="//i[text()='delete']")
	WebElement deleteEcoBtn;

	@FindBy(xpath="//span[text()='Delete']") //span[text()='Delete']
	WebElement dleteConfirmBtn;

	@FindBy(xpath="//span[text()='Delete']") //span[text()='Delete']
	List<WebElement>  dleteConfirmBtnS;

	@FindBy(xpath = "//pre[@class='ng-binding ng-scope']")
	WebElement Alertpopup;




	//	------------------------------------VMM_3665------------------------------------
	@FindBy(xpath="//*[contains(text(),'Show Filters')]")
	WebElement showFilterBtn;


	@FindBy(xpath="//select[@class='form-control fields-select ng-pristine ng-untouched ng-valid']")
	WebElement selectType;

	@FindBy(xpath="//select[@class='form-control conditions-select ng-pristine ng-untouched ng-valid']")
	WebElement EnterNotEqual;

	@FindBy(xpath="//select[@class='form-control conditions-select ng-pristine ng-untouched ng-valid']")
	WebElement EnterEcosystemType;



	//Rajath VMM-3848------------------------------------------------------
	@FindBy(xpath="//span[@id='lifecycle-softwareSettings']")
	WebElement Ecosystemsetting;

	@FindBy(xpath="//span[normalize-space()='New']")
	WebElement ecosystemnewbutt;

	@FindBy(xpath="//div[@id='field_fleet_id']//span[@aria-label='Select box activate']")
	WebElement EnterTenantID;

	@FindBy(xpath="//select[@id='field_softwareGroup']")
	WebElement EnterEcosystem;

	@FindBy(xpath="//span[@class='showHideFilters ng-binding']")
	WebElement ecosystemshowfilter;


	@FindBy(xpath="//select[@class='form-control fields-select ng-valid ng-dirty ng-valid-parse ng-touched']")
	WebElement ecosyssettingfilter1;

	@FindBy(xpath="//select[@class='form-control conditions-select ng-valid ng-dirty ng-valid-parse ng-touched']")
	WebElement ecosyssettingfilter2;


	@FindBy(xpath="(//input[@type='text'])[1]")
	WebElement Tenantvalue;

	@FindBy(xpath="//div[@class='filterButtons']//button[@class='btn btn-primary btn-raised']")
	WebElement FilterButton;

	@FindBy(xpath="//div[@class='filterButtons']//button[@class='btn btn-danger btn-raised']")
	WebElement ClearButton;

	@FindBy(xpath="//ul[@class='pagination ng-isolate-scope ng-valid']//span[@class='ng-binding']")
	WebElement Recordcount1;

	@FindBy(xpath="//ul[@class='pagination ng-isolate-scope ng-valid']//span[@class='ng-binding']")
	WebElement Recordcount2;


	@FindBy(xpath="//button[@type='button']//i[@class='material-icons small-icon']")
	WebElement deletesymbol;

	@FindBy(xpath="//button[@ng-disabled='deleteForm.$invalid']")
	WebElement deleteEcosystemsetting;


	//Rajath VMM_4578-------------------------------------------------------------------

	@FindBy(xpath="//div[@class='filterButtons']//span[@class='ng-scope'][normalize-space()='Filter']")
	WebElement ecosystemfilterbtn;

	@FindBy(xpath="//div[@class='filterButtons']//span[@class='ng-scope'][normalize-space()='Clear']")
	WebElement ecosystemclearbtn;

	//Rajath VMM-3592-------------------------------------------------------------------

	@FindBy(xpath="/html/body/div[4]/div/div/form/div[3]/button[2]/span")
	WebElement deleteecosettingsystem;

	//Savitha
	@FindBy(xpath = "//thead//span[text()='Tenant ID']")
	WebElement colTenantID;

	@FindBy(xpath = "//thead//span[text()='Ecosystem']")
	WebElement colEcosystem;

	@FindBy(xpath="//*[@id='field_fleet_id']")
	WebElement tenantIDField;

	@FindBy(xpath="//*[@id='field_softwareGroup']")
	WebElement ecosystemField;

	@FindBy(xpath="//*[@id='field_softwareGroup']//option[@selected='selected']")
	WebElement ecosystemValue;

  	@FindBy(xpath="(//select[@ng-model='rule.field'])[1]")
	WebElement conditionField1;

	@FindBy(xpath="(//select[@ng-model='rule.condition'])[2]")
	WebElement conditionOperation1;

	//@FindBy(xpath="//*[@class='group-conditions']//input[@type='text']")
	@FindBy(xpath="(//select[@ng-model='rule.model'])[1]")
	WebElement conditionFieldValue1;

    @FindBy(xpath="//i[normalize-space()='visibility']")
	WebElement ecosystemView;

	public String createEcosystemSettings(String TenantID) throws InterruptedException, AWTException {

		waitForElementToBeClickableThenClick(newEcosystemSettingsBtn);

		waitForAngularRequestsToFinish();

		waitForElementToBeClickableThenClick(tenantIDTxt);
	    sleepMin();
		waitForElementToBeClickableThenSendkeys(tenantIDTxtBox, TenantID);
		waitForElementToBeClickableThenClick(suggestionRowFirstValue);

		waitForAngularRequestsToFinish();

		selectListByValue(ecosystemTxt, "1");

		sleepMin();

		waitForElementToBeClickableThenClick(saveEcosystemBtn);

		String alertMsg = Alertpopup.getText();
		return alertMsg;

	}

	public void exportEcosystemSettings() throws InterruptedException {

		sleepMAX();
		waitForElementToBeClickableThenClick(ecosystemSettingsExportBtn);
		sleepMAX();
	}

	public File getEcosystemSettingsExport() {

		File EcosystemSettings = getLastModified(System.getProperty("user.dir") + "\\Downloads");

		return EcosystemSettings;
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
	////3870

	public String createEcosystemSettings(Map <String, String> testData) throws InterruptedException, AWTException
	{
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(newEcosystemSettingsBtn);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(tenantIDTxt);
		sleepMin();
		waitForElementToBeClickableThenSendkeys(tenantIDTxtBox, testData.get("TenantID"));
		waitForElementToBeClickableThenClick(suggestionRowFirstValue);
		waitForAngularRequestsToFinish();
		selectListByValue(ecosystemTxt, "1");
		sleepMin();
		waitForElementToBeClickableThenClick(saveEcosystemBtn);
		String alertMsg = Alertpopup.getText();
		return alertMsg;
	}


	//----------------------------------Sunilkumar(VMM-3375)-----------------------------
	public void searchecosetting(Map <String, String> testData) throws InterruptedException
	{

		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(showfilterBtn);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(ecosystemfilter1,"Tenant ID");
		waitForElementToBeClickableThenSendkeys(ecosystemfilter2,"equals");
		waitForElementToBeClickableThenClearThenSendkeys(ecosystemfilter3,testData.get("TenantID"));
		waitForElementToBeClickableThenClick(filterBtn);
		waitForAngularRequestsToFinish();

	}
	public String ecosettingverify() {
		String text=verifyecosetting.getText();
		return text;
	}

	public void viewmetadata() throws InterruptedException {
		waitForElementToBeClickableThenClick(viewmetadata);
		sleepMAX();

	}

	public void backtoecosetting() throws InterruptedException {
		waitForElementToBeClickableThenClick(backtoecosetting);
		sleepMAX();
	}

	public String metadataverify() {
		String text=verifymetadata.getText();

		return text;
	}

	public void editmetadata(Map <String, String> testData) throws InterruptedException {

		waitForElementToBeClickableThenClick(editecosetting);
		waitForElementToBeClickableThenSendkeys(editdistance, testData.get("Distance_Measurement"));
		sleepMin();
		waitForElementToBeClickableThenClick(saveedit);
		sleepAvg();

	}

	public String verifyedit() {
		String text=verifyedit.getText();
		return text;
	}
	public void deletedata() throws InterruptedException {
		sleepMin();
		waitForElementToBeClickableThenClick(deletemetadata);
		waitForElementToBeClickableThenClick(confirmdelete);
		sleepMin();
	}



	public void ecosysCancleBtn()  {

		waitForElementToBeClickableThenClick(EcosysCancleBtn);
		waitForAngularRequestsToFinish();
	}

	//----------------------------------Sunilkumar(VMM-3393)-----------------------------

	public void newecobtn() throws InterruptedException  {

		waitForElementToBeClickableThenClick(newEcosystemSettingsBtn);
		sleepMAX();
	}

	public void tenanttxtfild(Map <String, String> testData) {
		waitForElementToBeClickableThenClick(tenantIDTxt);
		waitForElementToBeClickableThenSendkeys(ecosystemInp, testData.get("TenantID"));

	}
	public void ecosystemtxtfield(Map <String, String> testData) throws Exception {

		sleepMAX();
		Robot robot = new Robot ();

		robot.keyPress (KeyEvent.VK_ENTER);

		robot.keyRelease (KeyEvent.VK_ENTER);

		robot.delay (200);

		selectListByVisibleText(ecosystemTxt, testData.get("Ecosystem"));

		sleepMin();

		waitForElementToBeClickableThenClick(saveEcosystemBtn);


	}



	public void TenantIDequals(Map <String, String> testData) throws Exception {
		sleepAvg();
		//  waitForElementToBeClickableThenClick(showfilterBtn);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(ecosystemfilter1,"Tenant ID");
		waitForElementToBeClickableThenSendkeys(ecosystemfilter2,"equals");
		waitForElementToBeClickableThenClearThenSendkeys(ecosystemfilter3,testData.get("TenantID"));
		waitForElementToBeClickableThenClick(filterBtn);
		waitForAngularRequestsToFinish();
		sleepAvg();
	}

	public void TenantIDcontains(Map <String, String> testData) throws Exception {
		//waitForElementToBeClickableThenClick(clearfilterBtn);
		waitForElementToBeClickableThenClick(showfilterBtn);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(ecosystemfilter1,"Tenant ID");
		waitForElementToBeClickableThenSendkeys(ecosystemfilter2,"contains");
		waitForElementToBeClickableThenClearThenSendkeys(ecosystemfilter3,testData.get("TenantID"));
		waitForElementToBeClickableThenClick(filterBtn);
		sleepAvg();
	}

	public void TenantIDnotequals(Map <String, String> testData) throws Exception {
		waitForElementToBeClickableThenClick(clearfilterBtn);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(ecosystemfilter1,"Tenant ID");
		waitForElementToBeClickableThenSendkeys(ecosystemfilter2,"not equals");
		waitForElementToBeClickableThenClearThenSendkeys(ecosystemfilter3,testData.get("TenantID"));
		waitForElementToBeClickableThenClick(filterBtn);
		sleepMin();
	}
	public void clipboardBtn() throws Exception {
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(ecoclipboardBtn);
		sleepMin();
	}
	public void loadchangelist() throws Exception {
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(auditchangelist);
		sleepAvg();
	}
	public String entityAuditsverify() {
		String text=ChangesforSettingsInstance.getText();

		return text;

	}
	public void closebrowser() {
		driver.close();
	}

	public String ecosettingcreatepopup() {
		String text=ecosettingcreatesuccesspopup.getText();
		return text;
	}

	public String ecosettingduplicatepopup() {
		String text=ecosettingExistpopup.getText();
		return text;
	}


	public String ecosettingcreatepopup1() throws InterruptedException {
		sleepMin();
		if (ecosettingcreatesuccesspopup.isDisplayed()) {

			return "true";

		} else {

			return "false";
		}
	}


	public void createEcosystemSettings1(Map <String, String> testData) throws InterruptedException, AWTException
	{

		waitForElementToBeClickableThenClick(newEcosystemSettingsBtn);
		sleepAvg();

		waitForElementToBeClickableThenClick(tenantIDTxt);
		sleepMin();

		selectListByVisibleText(ecosystemInp, testData.get("TenantID"));


		sleepMAX();
		Robot robot = new Robot ();

		robot.keyPress (KeyEvent.VK_ENTER);

		robot.keyRelease (KeyEvent.VK_ENTER);

		robot.delay (200);

		selectListByValue(ecosystemTxt, "1");

		sleepMin();

		waitForElementToBeClickableThenClick(saveEcosystemBtn);


	}
	//-----------------------Sunilkumar(VMM3408)-------------------------------
	public void createEcosystemSettings2(Map <String, String> testData) throws InterruptedException, AWTException
	{

		waitForElementToBeClickableThenClick(newEcosystemSettingsBtn);

		waitForAngularRequestsToFinish();

		waitForElementToBeClickableThenClick(tenantIDTxt);
	    sleepMin();
		waitForElementToBeClickableThenSendkeys(tenantIDTxtBox, testData.get("TenantID"));
		waitForElementToBeClickableThenClick(suggestionRowFirstValue);

		waitForAngularRequestsToFinish();

		selectListByValue(ecosystemTxt, "1");

		sleepMin();


	}
	public String ecosettingSave(Map<String, String> testData) throws InterruptedException
	{
		waitForElementToBeClickableThenClick(saveEcosystemBtn);
		String msg = ecosysAlertMessage.getText();
		return msg;

	}
	public void continueExecutionSetting() throws InterruptedException {

		waitForElementToBeClickableThenClick(cancleSetting);
		sleepMin();
	}
	public String verifytenantIDlabel() {
		String label=tenantIDlabel.getText();
		return label;
	}
	public void clickecosettingbackBtn() throws Exception {
		sleepAvg();
		waitForElementToBeClickableThenClick(ecosettingbackBtn);
		sleepMin();

	}
	public void clickecosettingeditbtn() {
		waitForElementToBeClickableThenClick(editecosetting);
	}

	public String verifytenantIDfield() {
		String field=tenantidfield.getText();
		return field;
	}





	////-------------------Bhanu-----------------------------------------Bhanu--------------------------------------------


	public String verifySettingTypeFilter1(Map<String, String> testData) throws InterruptedException
	{
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(ShowFilterClick);
		waitForElementToBeClickableThenClick(SelectFilterType);
		List<WebElement> settingFilter = driver.findElements(By.xpath("settingTypeFilter"));
		int count = settingFilter.size();
		if(count>=1)
		{
			String FilterName = getWebelementText(settingTypeFilter);
			System.out.println(FilterName);
			return FilterName;
		}
		else
			return "Setting Type Filter Not available";
	}

	public void verifyThreeEqualsFilters(Map<String, String> testData) throws InterruptedException
	{
		waitForAngularRequestsToFinish();

		waitForElementToBeClickableThenClick(ShowFilterClick);

		waitForElementToBeClickableThenClick(SelectFilterType);

		waitForElementToBeClickableThenClick(TenantIdOption);

		waitForElementToBeClickableThenClick(EqualsBoxFilter);

	}

	public boolean verifyEqualsFilter(Map<String, String> testData) {

		waitForElementToBeClickableThenClick(TenantIdOption);

		waitForElementToBeClickableThenSendkeys(ecosystemfilter2,"equals");

		waitForElementToBeClickableThenClearThenSendkeys(ecosystemfilter3,testData.get("TenantID"));

		waitForElementToBeClickableThenClick(filterBtn);

		waitForAngularRequestsToFinish();
		boolean Status = ThreeFilterFoundedValues.isEmpty();

		return Status;
	}

	public boolean verifyNotEqualsFilter(Map<String, String> testData) {
		waitForElementToBeClickableThenSendkeys(ecosystemfilter2,"not equals");

		waitForElementToBeClickableThenClearThenSendkeys(ecosystemfilter3,testData.get("TenantID"));

		waitForElementToBeClickableThenClick(filterBtn);

		waitForAngularRequestsToFinish();

		boolean Status = ThreeFilterFoundedValues.isEmpty();

		return Status;
	}

	public boolean verifyContainsFilter(Map<String, String> testData) {
		waitForElementToBeClickableThenSendkeys(ecosystemfilter2,"contains");

		waitForElementToBeClickableThenClearThenSendkeys(ecosystemfilter3,testData.get("TenantID"));

		waitForElementToBeClickableThenClick(filterBtn);

		waitForAngularRequestsToFinish();

		boolean Status = ThreeFilterFoundedValues.isEmpty();

		return Status;
	}

	public String deleteEcosystemSetting(Map<String, String> testData) throws InterruptedException {
		sleepAvg();
		waitForAngularRequestsToFinish();
		driver.navigate().refresh();

		waitForAngularRequestsToFinish();

		waitForElementToBeClickableThenClick(ShowFilterClick);

		sleepMin();

		waitForElementToBeClickableThenClick(TenantIdOption);

		waitForElementToBeClickableThenSendkeys(ecosystemfilter2,"equals");

		waitForElementToBeClickableThenClearThenSendkeys(ecosystemfilter3,testData.get("TenantID").toLowerCase());

		waitForElementToBeClickableThenClick(filterBtn);

		waitForAngularRequestsToFinish();
		sleepAvg();

		waitForElementToBeClickableThenClick(deleteEcoBtn);

		waitForAngularRequestsToFinish();

		for(int i=0; i<dleteConfirmBtnS.size();i++)
		{
			boolean DeleteBtn = dleteConfirmBtnS.get(i).isDisplayed();

			if(DeleteBtn==true)
			{
				//System.out.println(i);
				dleteConfirmBtnS.get(i).click();
				break;
			}
		}
		String alertMsg = Alertpopup.getText();
		return alertMsg;
		//waitForElementToBeClickableThenClick(dleteConfirmBtn);
	}

	//VMM_3362
	public boolean searchSoftwareSetting(Map<String, String> testData) throws InterruptedException {
		waitForAngularRequestsToFinish();

		waitForElementToBeClickableThenClick(ShowFilterClick);

		sleepMin();
		waitForElementToBeClickableThenClick(TenantIdOption);

		waitForElementToBeClickableThenSendkeys(ecosystemfilter2,"equals");

		waitForElementToBeClickableThenClearThenSendkeys(ecosystemfilter3,testData.get("TenantID").toLowerCase());

		waitForElementToBeClickableThenClick(filterBtn);

		boolean Status = ThreeFilterFoundedValues.isEmpty();
		///	System.out.println(Status);
		return Status;
	}



	public String createEcosystemSettingWithoutRobotClass(Map<String, String> testData) throws InterruptedException, AWTException {

		waitForElementToBeClickableThenClick(newEcosystemSettingsBtn);

		waitForAngularRequestsToFinish();

		waitForElementToBeClickableThenClick(tenantIDTxt);
	    sleepMin();
		waitForElementToBeClickableThenSendkeys(tenantIDTxtBox, testData.get("TenantID"));
		waitForElementToBeClickableThenClick(suggestionRowFirstValue);

		waitForAngularRequestsToFinish();

		selectListByValue(ecosystemTxt, "1");

		sleepMin();

		waitForElementToBeClickableThenClick(saveEcosystemBtn);

		String alertMsg = Alertpopup.getText();
		return alertMsg;
	}




	//----------------------------------------------VMM_3665----------------------------------------------------------

	public void clickShowFilterAndVerifyNotEqualSoftwaresetting(Map<String, String> testData) {
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(showFilterBtn);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(selectType,"Ecosytem");
		waitForElementToBeClickableThenSendkeys(EnterNotEqual,"not equal");
		waitForElementToBeClickableThenSendkeys(EnterEcosystemType,testData.get("Ecosystem"));
	}


	//Rajath -3848------------------------------------------------
	public void clickOnEcosystemSettings ()  {
		waitForElementToBeClickableThenClick(Ecosystemsetting);
		waitForAngularRequestsToFinish();
	}
	public void clickOnEcosystemNewbtn ()  {
		waitForElementToBeClickableThenClick(ecosystemnewbutt);
		waitForAngularRequestsToFinish();
	}
	public void  createEcoSystemsettings (Map<String, String> testData) throws InterruptedException {
		waitForElementToBeClickableThenSendkeys(EnterTenantID, testData.get("TenantID"));
		sleepMin();
		waitForElementToBeClickableThenSendkeys(EnterEcosystem, testData.get("Ecosystem"));
		sleepMin();
	}
	public void  clickOnEcoSysShowFilter ()  {
		waitForElementToBeClickableThenClick(ecosystemshowfilter);
		waitForAngularRequestsToFinish();

	}
	public void  clickShowOnFilterNotequal(Map<String, String> testData) {
		waitForAngularRequestsToFinish();
		//waitForElementToBeClickableThenClick(showFilterBtn);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(selectType,"TenantID");
		waitForElementToBeClickableThenSendkeys(EnterNotEqual,"not equal");
		waitForElementToBeClickableThenSendkeys(Tenantvalue,testData.get("TenantID"));

	}
	public void  ClickOnFilterButton () throws InterruptedException  {
		waitForElementToBeClickableThenClick(FilterButton);
    waitForAngularRequestsToFinish();
	}

	public void  ClickOnClearButton () throws InterruptedException  {
		waitForElementToBeClickableThenClick(ClearButton);
		waitForAngularRequestsToFinish();
	}


	public String EcosettingRecordCount1() {
		String text=Recordcount1.getText();
		System.out.println(text);
		return text;
	}

	public String EcosettingRecordCount2() {
		String text=Recordcount2.getText();
		System.out.println(text);
		return text;
	}


	public void  SearchEcosystem(Map<String, String> testData) {
		waitForAngularRequestsToFinish();
		//waitForElementToBeClickableThenClick(showFilterBtn);
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenSendkeys(selectType,"TenantID");
		waitForElementToBeClickableThenSendkeys(EnterNotEqual,"equal");
		waitForElementToBeClickableThenSendkeys(Tenantvalue,testData.get("TenantID"));

	}
	public void clickOnDeleteButton ()  {
		waitForElementToBeClickableThenClick(deletesymbol);
    waitForAngularRequestsToFinish();
	}
	public void clickOnDeleteEcosytemSymbol () throws InterruptedException  {
		waitForElementToBeClickableThenClick(deleteEcosystemsetting);
    waitForAngularRequestsToFinish();
		Thread.sleep(3000);
	}



	//Rajath VMM_3592----------------------------------------------------------

	public void EcosystemSettingSearch(Map<String, String> testData) throws InterruptedException {
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(showFilterBtn);
		sleepMin();
		waitForElementToBeClickableThenSendkeys(selectType,"TenantID");
		sleepMin();
		waitForElementToBeClickableThenSendkeys(EnterNotEqual,"equal");
		sleepMin();
		waitForElementToBeClickableThenSendkeys(Tenantvalue,testData.get("TenantID"));
		sleepMin();
		waitForElementToBeClickableThenClick(ecosystemfilterbtn);
		sleepMAX();

	}

	public void EcosystemSettingSearchWithClearValue(Map<String, String> testData) throws InterruptedException {
		waitForAngularRequestsToFinish();
		waitForElementToBeClickableThenClick(ecosystemclearbtn);
		sleepMin();
		sleepMin();
		waitForElementToBeClickableThenSendkeys(selectType,"TenantID");
		sleepMin();
		waitForElementToBeClickableThenSendkeys(EnterNotEqual,"equal");
		sleepMin();
		waitForElementToBeClickableThenClearThenSendkeys(Tenantvalue,"");
		waitForAngularRequestsToFinish();
		sleepMin();
	}

	public void ClickOnEcosystemDeleteBtn ()  {
		waitForElementToBeClickableThenClick(deleteecosettingsystem);

	}

	public boolean verifyColumnsInEcosystemSettingsScreen(){

    	if(	colTenantID.isDisplayed() &&
    			colEcosystem.isDisplayed())
    		return true;

    	return false;
    }

	public boolean verifyMandatoryFieldsInNewEcosystemSettingsScreen() throws Exception {

		if(tenantIDField.getAttribute("aria-required").equalsIgnoreCase("true") &&
				ecosystemField.isDisplayed() )

			return true;

		else
			return false;
	}

	public void clickOnShowFilter() {
		waitForElementToBeClickableThenClick(showFilterBtn);
	}

	public void searchEcosystem(Map<String, String> testData) throws InterruptedException {

		selectListByVisibleText(conditionField1,testData.get("Filter1"));
		selectListByVisibleText(conditionOperation1,testData.get("FilterOperation1"));
		//waitForElementToBeClickableThenClearThenSendkeys(conditionFieldValue1,testData.get("FilterValue1"));
		//waitForElementToBeClickableThenClick(conditionFieldValue1);
		selectListByVisibleText(conditionFieldValue1,testData.get("FilterValue1"));
		waitForElementToBeClickableThenClick(FilterButton);
	  	waitForAngularRequestsToFinish();
	}

    public void clickEcosystemSettingsviewBtn () throws InterruptedException {
		 waitForElementToBeClickableThenClick(ecosystemView);
		 waitForAngularRequestsToFinish();
    }

	 public String getEcosystemValueFromViewScreen() {

			return ecosystemValue.getText();
	 }


}

