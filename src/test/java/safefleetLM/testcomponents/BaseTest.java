package safefleetLM.testcomponents;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.stream.Collectors;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import safefleetLM.componentgroups.ResponseTags;


/*This class is responsible for loading the configurations from properties files,
Initializing the WebDriver, Implicit Waits, Extent Reports, and also to create the object of FileInputStream
which is responsible for pointing towards the file from which the data should be read.*/

public class BaseTest {
	public FileInputStream fis;
	public static Properties prop;
	public static ExtentSparkReporter report = null;
	public static ExtentReports extent = null;
	public ExtentTest test = null;
	public static ThreadLocal<ExtentTest> logInfo = new ThreadLocal<ExtentTest>(); // Thread safe
	public static String configpath = null;
	public static String runConfigSheetname = null;
	public static String env = null;
	public static String testDataFile = null;
	public static Properties properties;
	public static String baseURI = null;
	public static SoftAssert softAssert = null;
	public static String scenarioName = null;
	// dilip
	public static String tenantManager_baseURI = null;
	// Naincy
	public static String safeFleetID_baseURI = null;
	public static String bearertoken = null;
	public static String TestDataPath = null;

  public 	static Scenario scenario;
	//public static final String propertyFilePath = System.getProperty("user.dir")
	//		+ "//src//test//resources//globalSettings.properties";
  public static String propertyFilePath = (System.getProperty("user.dir")+ File.separator + String.join(File.separator,"src","test","resources","globalSettings.properties"));

  public static int rowcount = 1;
	public static String fileName;
	public WebDriver driver;


	// public LandingPage lp;
  public static synchronized String getProperty(String key) {
    synchronized(key) {
      return prop.getProperty(key);
    }
  }
  public static synchronized void setProperty(String key, String value) {

    prop.setProperty(key, value);
  }

	public BaseTest() throws IOException {

    prop = new Properties();
		fis = new FileInputStream(propertyFilePath);
		prop.load(fis);

    env = getProperty("Environment");
    if(env==null) {
      try {
        Thread.sleep(2000);
        env = getProperty("Environment");
      }
      catch(Exception e){
        e.getMessage();
      }

    }
      if (env.equals("TEST")) {
        baseURI = "https://test-license-manager-api.safefleetcloud.com";
        // dilip
        tenantManager_baseURI = "https://test-tenant-manager-api.safefleetcloud.com";
        // Naincy
        safeFleetID_baseURI = "https://test-id-manager-api-internal.safefleetcloud.com";
        //TestDataPath = "\\src\\test\\java\\testdata\\TEST\\TestData.xlsx";
        TestDataPath = File.separator + String.join(File.separator, "src", "test", "java", "testdata", "TEST", "TestData.xlsx");


      } //else if (prop.get("Environment").equals("DEV")) {
      else if (env.equals("DEV")) {
        baseURI = "https://dev-license-manager-api.safefleetcloud.com";
        // dilip
        tenantManager_baseURI = "https://dev-tenant-manager-api.safefleetcloud.com";
        // naincy
        safeFleetID_baseURI = "https://dev-id-manager-api-internal.safefleetcloud.com";
        //TestDataPath = "\\src\\test\\java\\testdata\\DEV\\TestData.xlsx";
        TestDataPath = File.separator + String.join(File.separator, "src", "test", "java", "testdata", "DEV", "TestData.xlsx");


      }//else if (prop.get("Environment").equals("STG")) {
      else if (env.equals("STG")) {
        baseURI = "https://stg-license-manager-api.safefleetcloud.com";
        // dilip
        tenantManager_baseURI = "https://stg-tenant-manager-api.safefleetcloud.com";
        // naincy
        safeFleetID_baseURI = "https://stg-id-manager-api-internal.safefleetcloud.com";
        //TestDataPath = "\\src\\test\\java\\testdata\\STG\\TestData.xlsx";
        TestDataPath = File.separator + String.join(File.separator, "src", "test", "java", "testdata", "STG", "TestData.xlsx");


      } else if (env.equals("PROD")) {
        baseURI = "https://license-manager-api.safefleetcloud.com";
        tenantManager_baseURI = "https://tenant-manager-api.safefleetcloud.com";
        safeFleetID_baseURI = "https://id-manager-api-internal.safefleetcloud.com";
        //TestDataPath = "\\src\\test\\java\\testdata\\PROD\\TestData.xlsx";
        TestDataPath = File.separator + String.join(File.separator, "src", "test", "java", "testdata", "PROD", "TestData.xlsx");


      }

	}

	public WebDriver intializeDriver() throws IOException {

		prop = new Properties();
		fis = new FileInputStream(propertyFilePath);
		prop.load(fis);

		if (driver == null) {
			String browserName = System.getProperty("BrowserName") != null ? System.getProperty("BrowserName")
					: prop.getProperty("BrowserName");
      if(browserName==null) {
        try {
          Thread.sleep(2000);
          browserName = getProperty("BrowserName");
        } catch (Exception e) {
          e.getMessage();
        }
      }
			if (browserName.equalsIgnoreCase("edge")) {
				// Edge
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else if (browserName.equalsIgnoreCase("chrome")) {
				// Chrome
				WebDriverManager.chromedriver().setup();
				ChromeOptions opt = new ChromeOptions();
				opt.addArguments("--remote-allow-origins=*");
				opt.addArguments("--disable-dev-shm-usage");
				opt.addArguments("--headless");
				opt.addArguments("--no-sandbox");
				Map<String, Object> prefs = new HashMap<String, Object>();
				//prefs.put("download.default_content_setting_values.zoom_factor", 0.5);
				prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "Downloads");
				opt.setExperimentalOption("prefs", prefs);
				opt.addArguments("start-maximized");
				opt.addArguments("force-device-scale-factor=1.0");

				driver = new ChromeDriver(opt);
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().window().setSize(new Dimension(1920, 1080));
			driver.manage().window().setPosition(new Point(0, 0));
			driver.manage().window().maximize();

		}

		return driver;

	}

	public void closeBrowser() {
		driver.close();
	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

	}

	public static String getTimeStamp() {
		Locale locale = new Locale("en", "UK");
		DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
		String pattern = "dd-MMM-HH_mm_ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, dateFormatSymbols);

		String timestamp;
    timestamp = simpleDateFormat.format(new Date());
    return timestamp;
	}


	// Extent Report Configurations
	public static ExtentReports setUp() throws IOException {
		fileName = "Run_" + getTimeStamp();
		String reportLocation = System.getProperty("user.dir") + "\\AutomationReports\\"+ "\\" + fileName+ "\\" + "Report" + ".html";
		report = new ExtentSparkReporter(reportLocation);
		//report = new ExtentHtmlReporter(reportLocation);
		report.config().setDocumentTitle("Automation Test Report");
		report.config().setReportName("Automation Test Report");
		report.config().setEncoding("utf-8");
		report.loadXMLConfig(new File("extentconfig.xml"));
		// report.config().setAutoCreateRelativePathMedia(true);
		report.config().setTheme(Theme.STANDARD);
		report.viewConfigurer().viewOrder().as(new ViewName[] {ViewName.DASHBOARD,ViewName.TEST}).apply();
		System.out.println("Extent Report location initialized . . .");
		//report.start();

		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Application", "LM Regression Testing");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		System.out.println("System Info. set in Extent Report");
		return extent;
	}



	public void reportInfo(String msg) {
		test.pass(msg);
	}

	public void reportPass(String title, String exp, String act) {
		String message = "<b>" + "Expected " + title + " : " + "</b>" + "<font color=" + "green>" + exp + "</font>"
				+ "\t" + "<b>" + "Actual " + title + " : " + "</b>" + "<font color=" + "green>" + act + "</font>";
		test.pass(message);
	}

	public void reportFail(String title, String exp, String act) {
		String message = "<b>" + "Expected " + title + " : " + "</b>" + "<font color=" + "red>" + exp + "</font>" + "\t"
				+ "<b>" + "Actual " + title + " : " + "</b>" + "<font color=" + "red>" + act + "</font>";
		test.fail(message);
		softAssert.assertEquals(exp, act);
	}

	public void reportPayload(String msg) {
		Markup m = MarkupHelper.createCodeBlock(msg, CodeLanguage.JSON);
		test.info(m);
	}

	public void validateField(String title, String expected, String actual) {

		if (expected.equals(actual))
			reportPass(title, expected, actual);
		else
			reportFail(title, expected, actual);
	}

	public void validateNullValues(String title, String actual) {

		if (actual == null)
			reportPass(title, "shold have null ", "contain null");
		else
			reportFail(title, "shold have null ", "contain null");
	}

	public void reportScreenshot(String status, String exp, String act, WebDriver driver) throws IOException {

		String message = "<b>" + "Expected : " + "</font>" + "</b>" + exp + "\t" + "<b>" + "Actual : " + "</b>" + act;
		if (status.equals("PASS"))
			test.pass(message, MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());
		else if (status.equals("FAIL"))
			test.fail(message, MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());
		else if (status.equals("INFO"))
			test.info(message, MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());
	}

	public void reportScreenshot(WebDriver driver) throws IOException {

		test.info("<b>" + "<font color=" + "orange>" + "Screenshot" + "</b>",
				MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver)).build());
	}

	public String captureScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "\\AutomationReports\\"+ "\\" + fileName+ "\\" + getcurrentdateandtime() + ".jpg";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

	private static String getcurrentdateandtime() {
		String str = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
		} catch (Exception e) {
		}
		return str;
	}

	public void testStepHandle(String teststatus, WebDriver driver, ExtentTest extenttest, Throwable throwable) {
		switch (teststatus) {
		case "FAIL":
			extenttest.fail(MarkupHelper.createLabel("Test Case is Failed : ", ExtentColor.RED));
			//extenttest.error(throwable.fillInStackTrace());


			try {
				extenttest.addScreenCaptureFromPath(captureScreenShot(driver));
				extenttest.info(throwable);

			} catch (IOException e) {
				e.printStackTrace();
				 System.out.println(e.getMessage());
			}
			softAssert.fail();
			break;

		case "PASS":
			extenttest.pass(MarkupHelper.createLabel("Test Case is Passed : ", ExtentColor.GREEN));
			break;

		default:
			break;
		}
	}


	/* Validate GetFleetByDevice Response */
	public void validateGetFlletByDeviceResponse(Response response, Map<String, String> testData, String status) {

		String resString = response.then().extract().asPrettyString();
		JsonPath js = new JsonPath(resString);

		if (status.equalsIgnoreCase("Assigned")) {
			validateField("ID", testData.get("ID"), js.getString(ResponseTags.GetFleetByDevice_ID));
			validateField("Feet ID", testData.get("FLEETID"), js.getString(ResponseTags.GetFleetByDevice_FLEETID));
			validateField("Device Type", testData.get("DEVICETYPE"),
					js.getString(ResponseTags.GetFleetByDevice_DEVICETYPE));
		} else if (status.equalsIgnoreCase("Unassigned")) {

			if (resString.contains(testData.get("DEVICESTATUS"))) {
				reportPass("Device Status", testData.get("DEVICESTATUS"), resString);
			}

		}
		reportInfo("Response : " + response.asPrettyString());

	}

	/* Validate ActivateLicenses Response */
	public void validateActivateLicensesResponse(Response response, Map<String, String> testData, String status) {

		String resString = response.then().extract().asPrettyString();
		JsonPath js = new JsonPath(resString);
		validateField("License Id", "[" + testData.get("LICENSEIDS") + "]",
				js.getString(ResponseTags.ActivateLicense_LICENSEID));
		validateField("Status", "[" + testData.get("STATUS") + "]", js.getString(ResponseTags.ActivateLicense_STATUS));
		validateField("Status Comment", "[" + testData.get("STATUSCOMMENT") + "]",
				js.getString(ResponseTags.ActivateLicense_STATUSCOMMENT));

	}

	/* Validate DeactivateLicenses Response */
	public void validateDeactivateLicensesResponse(Response response, Map<String, String> testData, String status) {

		String resString = response.then().extract().asPrettyString();
		JsonPath js = new JsonPath(resString);
		validateField("License Id", "[" + testData.get("LICENSEIDS") + "]",
				js.getString(ResponseTags.ActivateLicense_LICENSEID));
		validateField("Status", "[" + testData.get("STATUS") + "]", js.getString(ResponseTags.ActivateLicense_STATUS));
		validateField("Status Comment", "[" + testData.get("STATUSCOMMENT") + "]",
				js.getString(ResponseTags.ActivateLicense_STATUSCOMMENT));

	}

	public void validateGetDeviceConfigResponse(Response response, Map<String, String> testData) {

		String resString = response.then().extract().asPrettyString();
		JsonPath js = new JsonPath(resString);
		validateField("Data", testData.get("Data"), js.getString(ResponseTags.GetDeviceConfig_DATA));

	}

	public void validateAvailableLicensesResponse(Response response, Map<String, String> testData, String status) {

		String resString = response.then().extract().asPrettyString();
		JsonPath js = new JsonPath(resString);

		if (status.equalsIgnoreCase("Available")) {
			validateField("ID", testData.get("ID"), js.getString(ResponseTags.GetAvailableLicense_ID));
			validateField("Fleet", testData.get("FLEET"), js.getString(ResponseTags.GetAvailableLicense_FLEET));
			validateField("Expiry Date", testData.get("EXPIRYDATE"),
					js.getString(ResponseTags.GetAvailableLicense__EXPIRYDATE));
			validateField("License Status", testData.get("LICENSESTATUS"),
					js.getString(ResponseTags.GetAvailableLicense_LICENSESTATUS));
			validateField("Slot Type", testData.get("SLOTTYPE"),
					js.getString(ResponseTags.GetAvailableLicense_SLOTTYPE));
			validateField("Slots", testData.get("SLOTS"), js.getString(ResponseTags.GetAvailableLicense_SLOTS));
			validateField("Slot Used", testData.get("SLOTUSED"),
					js.getString(ResponseTags.GetAvailableLicense_SLOTUSED));
		} else if (status.equalsIgnoreCase("Invalid")) {
			// validateField("Time Stamp", testData.get("TIMESTAMP"),
			// js.getString(ResponseTags.GetAvailableLicense_TIMESTAMP));
			validateField("Status", testData.get("STATUS"), js.getString(ResponseTags.GetAvailableLicense__STATUS));
			validateField("Error", testData.get("ERROR"), js.getString(ResponseTags.GetAvailableLicense_ERROR));
			validateField("Exception", testData.get("EXCEPTION"),
					js.getString(ResponseTags.GetAvailableLicense_EXCEPTION));
			validateField("Message", testData.get("MESSAGE"), js.getString(ResponseTags.GetAvailableLicense_MESSAGE));
			validateField("Path", testData.get("PATH"), js.getString(ResponseTags.GetAvailableLicense_PATH));

		}

		else if (status.equalsIgnoreCase("Unavailable")) {
			validateField("ID", "", js.getString(ResponseTags.GetAvailableLicense_ID));
			validateField("Fleet", "", js.getString(ResponseTags.GetAvailableLicense_FLEET));
			validateField("Expiry Date", "", js.getString(ResponseTags.GetAvailableLicense__EXPIRYDATE));
			validateField("License Status", "", js.getString(ResponseTags.GetAvailableLicense_LICENSESTATUS));
			validateField("Slot Type", "", js.getString(ResponseTags.GetAvailableLicense_SLOTTYPE));
			validateField("Slots", "", js.getString(ResponseTags.GetAvailableLicense_SLOTS));
			validateField("Slot Used", "", js.getString(ResponseTags.GetAvailableLicense_SLOTUSED));

		}

	}

	public void validateGetSoftwareTemplateAndSettingResponse(Response response, Map<String, String> testData,
			String status) {

		String resString = response.then().extract().asPrettyString();
		JsonPath js = new JsonPath(resString);

		if (status.equalsIgnoreCase("Assigned")) {
			validateField("Template ID", testData.get("TEMPLATEID"),
					js.getString(ResponseTags.getSoftwareTemplateAndSetting_TEMPLATEID));
			validateField("Template Name", testData.get("TEMPLATENAME"),
					js.getString(ResponseTags.getSoftwareTemplateAndSetting_TEMPLATENAME));
			validateField("Template Json: Name", testData.get("TEMPLATEJSON"),
					js.getString(ResponseTags.getSoftwareTemplateAndSetting_TEMPLATEJSON));
			validateField("SW Setting: Settings ID", testData.get("SWSETTING.SETTINGSID"),
					js.getString(ResponseTags.getSoftwareTemplateAndSetting_SWSETTING_SETTINGSID));
			validateField("SW Setting: Setting Json: ID", testData.get("SWSETTING.SETTINGSJSON"),
					js.getString(ResponseTags.getSoftwareTemplateAndSetting_SWSETTING_SETTINGSJSON));
			validateField("SW Setting: Settings Name", testData.get("SWSETTING.SETTINGSNAME"),
					js.getString(ResponseTags.getSoftwareTemplateAndSetting_SWSETTING_SETTINGSNAME));
			validateField("SW Settng: Current Setting", testData.get("SWSETTING.CURRENTSETTING"),
					js.getString(ResponseTags.getSoftwareTemplateAndSetting_SWSETTING_CURRENTSETTING));
		} else if (status.equalsIgnoreCase("Unassigned")) {
			// validateField("Time Stamp", testData.get("TIMESTAMP"),
			// js.getString(ResponseTags.GetAvailableLicense_TIMESTAMP));
			validateField("Status", testData.get("STATUS"),
					js.getString(ResponseTags.getSoftwareTemplateAndSetting__STATUS));
			validateField("Error", testData.get("ERROR"),
					js.getString(ResponseTags.getSoftwareTemplateAndSetting_ERROR));
			validateField("Exception", testData.get("EXCEPTION"),
					js.getString(ResponseTags.getSoftwareTemplateAndSetting_EXCEPTION));
			validateField("Message", testData.get("MESSAGE"),
					js.getString(ResponseTags.getSoftwareTemplateAndSetting_MESSAGE));
			validateField("Path", testData.get("PATH"), js.getString(ResponseTags.getSoftwareTemplateAndSetting_PATH));

		}

	}

	/* Validate GetAssignedLicense Response */
	public void validateGetAssignedLicenseResponse(Response response, Map<String, String> testData, String status) {

		String resString = response.then().extract().asPrettyString();
		JsonPath js = new JsonPath(resString);

		if (status.equalsIgnoreCase("Assigned")) {
			validateField("ID", testData.get("ID"), js.getString(ResponseTags.GetAssignedLicense_ID));
			validateField("FLeet", testData.get("FLEET"), js.getString(ResponseTags.GetAssignedLicense_FLEET));
			validateField("EXPIRY DATE", testData.get("EXPIRYDATE"),
					js.getString(ResponseTags.GetAssignedLicense__EXPIRYDATE));
			validateField("lICENSE STATUS", testData.get("LICENSESTATUS"),
					js.getString(ResponseTags.GetAssignedLicense_LICENSESTATUS));
			validateField("SLOT TYPE", testData.get("SLOTTYPE"),
					js.getString(ResponseTags.GetAssignedLicense_SLOTTYPE));

		} else if (status.equalsIgnoreCase("Unassigned")) {

		}
	}

	/* Validate DeviceTemplateAndSettings Response */
	public void validateGetDeviceTemplateAndSettingsResponse(Response response, Map<String, String> testData,
			String status) {

		String resString = response.then().extract().asPrettyString();
		JsonPath js = new JsonPath(resString);

		if (status.equalsIgnoreCase("Assigned")) {
			validateField("Template ID", testData.get("Template_ID"),
					js.getString(ResponseTags.GetDeviceTemplateAndSettings_TEMPLATEID));
			validateField("Template Name", testData.get("Template_Name"),
					js.getString(ResponseTags.GetDeviceTemplateAndSettings_TEMPLATENAME));
			validateField("Template JSON", testData.get("TemplateJSON"),
					js.getString(ResponseTags.GetDeviceTemplateAndSettings_TEMPLATEJSON));
			validateField("DeviceSettings SettingsID", testData.get("DeviceSettings.SettingsID"),
					js.getString(ResponseTags.GetDeviceTemplateAndSettings_DEVICESETTINGS_SETTINGSID));
			validateField("DeviceSettings SettingsJSON", testData.get("DeviceSettings.SettingsJSON"),
					js.getString(ResponseTags.GetDeviceTemplateAndSettings_DEVICESETTINGS_SETTINGSJSON));
			validateField("DeviceSettings SettingsName", testData.get("DeviceSettings.SettingsName"),
					js.getString(ResponseTags.GetDeviceTemplateAndSettings_DEVICESETTINGS_SETTINGSNAME));
			validateField("DeviceSettings CurrentSetting", testData.get("DeviceSettings.CurrentSetting"),
					js.getString(ResponseTags.GetDeviceTemplateAndSettings_DEVICESETTINGS_CURRENTSETTING));

		} else if (status.equalsIgnoreCase("Unassigned")) {

			validateNullValues("Template JSON", js.getString(ResponseTags.GetDeviceTemplateAndSettings_TEMPLATEJSON));
			validateNullValues("Template ID", js.getString(ResponseTags.GetDeviceTemplateAndSettings_TEMPLATEID));
			validateNullValues("Template Name", js.getString(ResponseTags.GetDeviceTemplateAndSettings_TEMPLATENAME));
			validateNullValues("Device Settings",
					js.getString(ResponseTags.GetDeviceTemplateAndSettings_DEVICESETTINGS));

		}
	}

	//Random String Generator

	public String randomStringGenerator() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		Date date = new Date();
		String timestamp = sdf.format(date);
		String randomString = "testauto" + timestamp;
		return randomString;
	}

	//Random Device name String Generator

	public String randomDeviceStringGenerator() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		Date date = new Date();
		String timestamp = sdf.format(date);
		String randomString = "testautod" + timestamp;
		return randomString;
	}

	//Random Device Type name String Generator

	public String randomDeviceTypeStringGenerator() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		Date date = new Date();
		String timestamp = sdf.format(date);
		String randomString = "testautoDT" + timestamp;
		return randomString;
	}

	//Random Integer Generator
	public String randomIntGenerator() {

		Random rand = new Random();
        int num = rand.nextInt((int) Math.pow(10, 10));
        String randomString = "testauto";
        return String.valueOf(randomString+num);

	}

	//// Random Email Generator

	public String randomEmailGenerator() {

		String[] emailProviders = {"gmail.com", "yahoo.com", "hotmail.com", "aol.com", "outlook.com"};
		Random random = new Random();
        String randomString = "testauto";
        for (int i = 0; i < 4; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            randomString += c;
        }
        return randomString + "@" + emailProviders[random.nextInt(emailProviders.length)];

	}

	public static String getRamdomMAcAddress() {
		Random rand = new Random();
		return String.format("%02x-%02x-%02x-%02x-%02x", rand.nextInt(256), 0x5e, rand.nextInt(256), 0x53, 0xaf);
	}

	public static void getCustomJsonReport() {


	    try {
		    BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + File.separator + "target"+File.separator +"cucumber.json"));
		    String jsonString = reader.lines().collect(Collectors.joining());
		    reader.close();

		    JSONArray jsonArraySource = new JSONArray(jsonString);
		    JSONArray result = new JSONArray();
		    for (int i=0;i< jsonArraySource.length();i++) {
			    JSONObject jsonObject = jsonArraySource.getJSONObject(i);
			    String name = jsonObject.getJSONArray("elements").getJSONObject(0).getString("name");
			    String status = jsonObject.getJSONArray("elements").getJSONObject(0).getJSONArray("after").getJSONObject(0).getJSONObject("result").getString("status");
			    switch(status) {
				    case "passed" :
				    	status = "PASS";
				    	break;
				    case "failed" :
				    	status = "FAIL";
				    	break;
			    }
			    JSONArray jsonArray = jsonObject.getJSONArray("elements").getJSONObject(0).getJSONArray("tags");
			    //System.out.println(name);
			    //System.out.println(status);

			    for (int j=0; j < jsonArray.length();j++) {
			    	JSONObject obj = jsonArray.getJSONObject(j);
			    	if(obj.getString("name").toLowerCase().contains("vmm")) {
			    		JSONObject ob = new JSONObject();
			    		ob.put("TestName", name);
			    		ob.put("JiraKey", obj.getString("name"));
			    		ob.put("Result", status);
				    	result.put(ob);
			    	}
			    }
			    System.out.println(result);
		    }

		    try {
		    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + File.separator + "target"+File.separator +"Custom_cucumber_report.json"));
		    	bufferedWriter.write(result.toString());
		    	bufferedWriter.close();
		    	} catch (IOException e) {
		    	e.printStackTrace();
		    	}


	    } catch (Exception e) {
	    	e.printStackTrace();
	    }

	}

	//Get current Date in MM/DD/YYYY format

	public String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String timestamp = sdf.format(date);

		return timestamp;
	}

}


