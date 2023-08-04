package safefleetLM.componentgroups;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.paulhammant.ngwebdriver.NgWebDriver;

//repetitive in nature such as waits, actions, capturing screenshots, accessing excels, sending email, etc.,

public class ReusableLibrary {
	WebDriver driver;
	public static int SLEEP_MIN=1500;
	public static int SLEEP_AVG=3000;
	public static int SLEEP_MAX=5000;

	public ReusableLibrary(WebDriver driver) {
		this.driver = driver;
	}

	public void reloadScreen() {
		driver.navigate().refresh();
	}


	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForElementToAppear(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	public void waitForElementToBeClickableThenClick(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();

	}

	public void waitForElementToBeClickableThenClick(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(findBy)).click();

	}

	public void waitForElementToBeClickableThenSendkeys(WebElement webElement, String data) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(data);
		// driver.findElement((By) webElement).sendKeys(data);
	}

	public void waitForElementToBeClickableThenClearThenSendkeys(WebElement webElement, String data) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(webElement)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(data);
		// driver.findElement((By) webElement).sendKeys(data);
	}

	public void waitForElementToBeClickableThenClear(WebElement webElement, String data) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(webElement)).clear();
	}

	public void waitForElementToBeClickableThenSendkeys(By findBy, String data) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(findBy)).sendKeys(data);
		;

	}

	public String waitForPresenceOfElementThenGettext(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		String text = wait.until(ExpectedConditions.presenceOfElementLocated((By) webElement)).getText();
		return text;
	}

	public String waitForPresenceOfElementThenGettext(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(findBy));
		return driver.findElement(findBy).getText();
	}

	public String getWebelementText(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.visibilityOf(ele)).getText();

	}

	public void getAlertText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
			System.out.println("alert was not present");
		} else {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert Text "+alert.getText());
			alert.accept();
			System.out.println("alert was present and accepted");
		}


	}

	// Angular method to wait
	public NgWebDriver getNGDriver() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (new NgWebDriver(js));
	}

	public void waitForAngularRequestsToFinish() {
		try {
			getNGDriver().waitForAngularRequestsToFinish();
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Failed : waitForAngularRequestsToFinish");
		}

	}

	public String encodeData(String data) {
		String basicBase64format = Base64.getEncoder().encodeToString(data.getBytes());
		return basicBase64format;
	}

	public String decodeData(String encodedData) {
		byte[] actualByte = Base64.getDecoder().decode(encodedData);

		String actualString = new String(actualByte);
		return actualString;
	}
	public static void sleepMin() throws InterruptedException {
		Thread.sleep(SLEEP_MIN);
	}
	public static void sleepAvg() throws InterruptedException {
		Thread.sleep(SLEEP_AVG);
	}
	public static void sleepMAX() throws InterruptedException {
		Thread.sleep(SLEEP_MAX);
	}

	public void scrollToElement(String xpath) {
		String javascript = "arguments[0].scrollIntoView()";
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		try {
			jsExecutor.executeScript(javascript, driver.findElement(By.xpath(xpath)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void scrollToElement(WebElement ele) {
		String javascript = "arguments[0].scrollIntoView()";
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		try {
			jsExecutor.executeScript(javascript, ele );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Savitha
	public void scrollTillEnd(String cssSelector) {
		try {
 		((JavascriptExecutor)driver).executeScript("document.querySelector('"+cssSelector+"').scrollTop= 10000");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void scrollDown() {
		try {
			((JavascriptExecutor)driver).executeScript("document.querySelector('.table-responsive.well').scrollTop= 10000");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

  public void scrollDown(int x) {
    try {
      for(int i = 0; i<=x; i++){
        ((JavascriptExecutor)driver).executeScript("document.querySelector('.table-responsive.well').scrollTop= 10000");
        waitForAngularRequestsToFinish();
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();

    }
  }

	public void scrollDownTill(int value) {
		try {
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0, "+value+");");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}



	public void scrollTop() {
		try {
			((JavascriptExecutor)driver).executeScript("document.querySelector('.table-responsive.well').scrollTop= 0");
			//((JavascriptExecutor)driver).executeScript("window.scrollTo(0, 0);");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public static void selectListByVisibleText(WebElement obj,String item)
	{
		try{

			Select select = new Select(obj);
			select.selectByVisibleText(item);

		}catch(Exception e)
		{

		}
	}

	public static void selectListByValue(WebElement obj,String item)
	{
		try{

			Select select = new Select(obj);
			select.selectByValue(item);
		}catch(Exception e)
		{

		}
	}

	public static void selectListByIndex(WebElement obj,int item)
	{
		try{

			Select select = new Select(obj);
			select.selectByIndex(item);
		}catch(Exception e)
		{

		}
	}

	//Unzip file
	    public static void unzip(String zipFilePath, String destDirectory) throws IOException {
	        File destDir = new File(destDirectory);
	        if (!destDir.exists()) {
	            destDir.mkdir();
	        }
	        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
	        ZipEntry entry = zipIn.getNextEntry();
	        while (entry != null) {
	            String filePath = destDirectory + File.separator + entry.getName();
	            if (!entry.isDirectory()) {
	                extractFile(zipIn, filePath);
	            } else {
	                File dir = new File(filePath);
	                dir.mkdir();
	            }
	            zipIn.closeEntry();
	            entry = zipIn.getNextEntry();
	        }
	        zipIn.close();
	    }

	    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
	        FileOutputStream fos = new FileOutputStream(filePath);
	        byte[] bytes = new byte[1024];
	        int length;
	        while ((length = zipIn.read(bytes)) >= 0) {
	            fos.write(bytes, 0, length);
	        }
	        fos.close();
	    }

		protected static String getCurrentDate() {
			String str = null;
			try {
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				Date date = new Date();
				str = dateFormat.format(date);
				//str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
			} catch (Exception e) {
			}
			return str;
		}

		protected static String getFutureDate(int days) {
			String str = null;
			try {
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new Date());
				calendar.add(Calendar.DAY_OF_YEAR, days);
				Date newDate = calendar.getTime();
				str = dateFormat.format(newDate);

			} catch (Exception e) {
			}
			return str;
		}

		public void hoverOnElement(WebElement ele) {
			Actions actions = new Actions(driver);
			actions.moveToElement(ele).build().perform();
			try {
				sleepMin();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}

		public void listOfxlsxFileFromDownloads() {

		}

}
