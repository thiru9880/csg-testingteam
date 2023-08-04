package safefleetLM.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import safefleetLM.componentgroups.ReusableLibrary;

public class LMHomePage extends ReusableLibrary
{
		WebDriver driver;

		public String urlDevicesettingPage = "https://test-license-manager.safefleetcloud.com/#/settings-instance?settingsType=Device";
		public String urlEcoSystemSettingPage="https://test-license-manager.safefleetcloud.com/#/settings-instance?settingsType=Software";
		public LMHomePage(WebDriver driver) {
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}



		@FindBy(id="lifecycle")
		WebElement operationsTab;

		@FindBy(id="lifecycle-customer")
		WebElement customersTab;

		@FindBy(xpath = "//li[@id='systemadmin']//a[@class='mm-next mm-fullsubopen']")
		WebElement systemAdminTab;

		@FindBy(xpath = "//span[@id='system-admin-user-manage']")
		WebElement usersTab;

		@FindBy(id="devicetype")
		WebElement deviceTypeTab;

		@FindBy(xpath="//*[@id='lifecycle-device']")
		WebElement devicesTab;

		@FindBy(xpath="//span[text()='Base Apps']")
		WebElement baseProductTab;

		@FindBy(xpath="(//span[text()='License Types'])[1]")
		WebElement LicenseTypesTab;

		@FindBy(xpath="//span[text()='Device Types']")
		WebElement DeviceTypesTab;

		@FindBy(xpath="//span[text()='Licenses']")
		WebElement LicensesTab;

		@FindBy(xpath="//span[text()='Tenants']")
		WebElement TenantsTab;

		@FindBy(xpath="//span[text()='Tenants']")
		WebElement TenantTypeTab;

		@FindBy(xpath="//*[@id='lifecycle-license']")
		WebElement licenseTab;

		@FindBy(xpath="//*[@id='lifecycle-fleet']")
		WebElement tenantsTab;

		@FindBy(xpath="//*[@id='lifecycle-softwareSettings']")
		WebElement ecosystemTab;

		@FindBy(xpath="//*[@id='lifecycle-deviceSettings']")
		WebElement deviceSettingsTab;

		//bhanu
		@FindBy(xpath="//span[text()='Tenant Types']")
		WebElement tenantTypesTab;

		@FindBy(xpath="//span[text()='Servers']")
		WebElement serversTab;

		//melroy
		@FindBy(xpath="(//span[text()='Sales Regions'])[1]")
		WebElement salesregions;

		@FindBy(xpath="//span[@class='current-user-name text-primary ng-binding']")
		WebElement currentUser;

		@FindBy(xpath="//i[@title='Export to Excel']")
		WebElement exportexcel;

		//Sunilkumar(VMM-3268)logo verification
		@FindBy(xpath="//img[@src='/assets/icons/logo/LicenseManager/license-manager-logo.png']")
		WebElement LMLogo;

		//Savitha
		@FindBy(xpath="//p[@translate='version']")
		WebElement lmAppVersionUser;

		@FindBy(xpath="//*[@id='Customers']")
		WebElement customerPanel;

		@FindBy(xpath="//*[@id='Tenants']")
		WebElement tenantsPanel;

		@FindBy(xpath="//*[@id='Licenses']")
		WebElement licensesPanel;

		@FindBy(xpath="//*[@id='Devices']")
		WebElement devicesPanel;

		@FindBy(xpath="//*[@id='licensesPie']")
		WebElement licensesPie;

		@FindBy(xpath="//*[@id='usagePie']")
		WebElement usagePie;

		@FindBy(xpath="//th[text()='Base Apps']/../../../tbody")
		WebElement softwareNamesAndAmt;

		@FindBy(xpath="//th[text()='Status']/../../../tbody")
		WebElement deviceUsageStatusAndAmt;

		@FindBy(xpath="//span[text()='Tenant Manager']/..//*[@title='Server is Up & Running']")
		WebElement tmServerStatus;

		@FindBy(xpath="//span[text()='Sync Jobs']/../..//div[@ng-controller='JobController']")
		WebElement syncJobsDetails;

		@FindBy(xpath="//*[contains(text(),'SyncTM (DAILY_JOB)')]/../..//img")
		WebElement dailySyncJobToolTipTxt;

		@FindBy(css ="li > div > div.div-2.ng-binding > img")
		WebElement dailySyncJobToolTipIcon;

    @FindBy(xpath="//*[contains(text(),'SyncTM (UPLOAD_DEVICE)')]/../..//div/span")
    WebElement uploadDeviceSyncJobStatus;

    @FindBy(xpath="//span[text()='Dashboard']")
    WebElement lmDashboardTab;

		public void navigateToOperationsTab() {
			//waitForElementToBeClickableThenClick(operationsTab);
			waitForAngularRequestsToFinish();
			operationsTab.click();
			waitForAngularRequestsToFinish();
		}

		public void navigateToCustomerTab() {
			waitForAngularRequestsToFinish();
			customersTab.click();
			waitForAngularRequestsToFinish();

		}

		public void navigateToSystemAdminTab() {
			waitForAngularRequestsToFinish();
			systemAdminTab.click();
			waitForAngularRequestsToFinish();
		}

		public void navigateToUserTab() {
			waitForAngularRequestsToFinish();
			usersTab.click();
			waitForAngularRequestsToFinish();
		}

		public void navigateToDeviceTypeTab() {
			waitForAngularRequestsToFinish();
			deviceTypeTab.click();
			waitForAngularRequestsToFinish();
		}

		public void navigateToDevicesTab() {
			waitForAngularRequestsToFinish();
			devicesTab.click();
			waitForAngularRequestsToFinish();
		}

		public void navigateTobaseProductTab()
		{
			waitForAngularRequestsToFinish();
			baseProductTab.click();
			waitForAngularRequestsToFinish();
		}

		public void navigateToLicenseTypesTab()
		{
			waitForAngularRequestsToFinish();
			LicenseTypesTab.click();
			waitForAngularRequestsToFinish();
		}

		public void navigateToDeviceTypesTab()
		{
			waitForAngularRequestsToFinish();
			DeviceTypesTab.click();
			waitForAngularRequestsToFinish();
		}

		public void navigateToLicensesTab()
		{
			waitForAngularRequestsToFinish();
			LicensesTab.click();
			waitForAngularRequestsToFinish();
		}

		public void navigateToTenantsTab()
		{
			waitForAngularRequestsToFinish();
			TenantsTab.click();
			waitForAngularRequestsToFinish();

		}

		public void navigateToTenantsTypeTab()
		{
			waitForAngularRequestsToFinish();
			TenantTypeTab.click();
			waitForAngularRequestsToFinish();
		}



		public void navigateToEcoSystemTab() {
			waitForAngularRequestsToFinish();
			ecosystemTab.click();
			waitForAngularRequestsToFinish();
		}

		public void navigateToLicenseTab() {
			waitForAngularRequestsToFinish();
			licenseTab.click();
			waitForAngularRequestsToFinish();
		}

		public void navigateToDeviceSettingsTab() {
			waitForAngularRequestsToFinish();
			deviceSettingsTab.click();
			waitForAngularRequestsToFinish();
		}

		//bhanu
		public void navigateToTenantTypesTab() {
			waitForAngularRequestsToFinish();
			tenantTypesTab.click();
			waitForAngularRequestsToFinish();
		}

		public void navigateToServersTab() {
			waitForAngularRequestsToFinish();
			serversTab.click();
			waitForAngularRequestsToFinish();
		}

		//melroy
			public void navigateToSalesRegions() {
				waitForAngularRequestsToFinish();
			salesregions.click();
			waitForAngularRequestsToFinish();
		}

  public void navigateToLMDashboardTab() {
    waitForAngularRequestsToFinish();
    lmDashboardTab.click();
    waitForAngularRequestsToFinish();
  }

		public String currentUserText() {

			return currentUser.getText();
		}
		public void clickExportExcel() {
			waitForElementToBeClickableThenClick(exportexcel);
		}

		public void openDevicesettingPage() {
			driver.get(urlDevicesettingPage);
		}
		public void openEcoSystemSettingPage() {
			driver.get(urlEcoSystemSettingPage);
		}

		//Sunilkumar(VMM-3268)logo verification
		public String verifyLMLogo() {

			if (LMLogo.isDisplayed())
			{
				//System.out.println("LM Logo Displayed");
				return "true";

			}
			else
			{
				//System.out.println("LM Logo not Displayed");
				return "false";
			}

		}

		 //----------------------Savitha----------------------------//

		public String getLMAPPVersionTxt()
		{
			return lmAppVersionUser.getText();
		}

		public boolean verifyLMDashboardPanels() {
			if (customerPanel.isDisplayed() && tenantsPanel.isDisplayed() && devicesPanel.isDisplayed() && licensesPanel.isDisplayed())
			{
				return true;
			}
			else
			{
				return false;
			}

		}

		public boolean verifyLMPieCharts() {
			if (licensesPie.isDisplayed() && usagePie.isDisplayed())
			{
				return true;
			}
			else
			{
				return false;
			}

		}

		public boolean verifyLicensesandDeviceUsageDataValues() {
			if (!softwareNamesAndAmt.getText().isEmpty() && !deviceUsageStatusAndAmt.getText().isEmpty())
			{
				return true;
			}
			else
			{
				return false;
			}

		}

		public boolean verifyTenantManagerServerStatus() {
			if (tmServerStatus.isDisplayed())
			{
				return true;
			}
			else
			{
				return false;
			}

		}

		public String getSyncJobsDetails() {
			return syncJobsDetails.getText();
		}

		public void hoverOnToolTipIcon() {
			hoverOnElement(dailySyncJobToolTipIcon);
		}

		public String getDailySyncJobToolTipDetail() {
			return dailySyncJobToolTipTxt.getAttribute("title");
		}

    public String getUploadDeviceSyncJobStatus() {
      return uploadDeviceSyncJobStatus.getText();
  }

}
