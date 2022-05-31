package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;

	public WebDriver launchBrowser(String url) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriver launchBrowser1(String browser, String url) throws InterruptedException {
/*
		switch (browser) {

		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "Firefox":
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", "src\\test\\resources\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("Invalid Browser");
			break;

		}*/
	
	if(browser=="Chrome")
	{
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	else if(browser== "Firefox") {
		System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	else if(browser== "IE") {
		System.setProperty("webdriver.ie.driver", "src\\test\\resources\\Drivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}
	else {
		System.out.println("Invalid Browser");
	}
		
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		return driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void screenshotfailed(WebDriver driver,String test) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(
				"src\\test\\resources\\Screenshots\\"
						+test+ timestamp() + ".png");
		Files.copy(SrcFile, DestFile);

	}

	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	public ExtentReports extendReportCreation() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Buffalocart Report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;
	}

	public void ExtentReportcreateTest(String createtest) {
		test = extent.createTest(createtest, "Test");
	}

	public void ExtentReportinfo(String createtest) {
		test.log(Status.INFO, createtest);
	}

	public void extendTestPass(String passString) {
		test.pass("Testing Passed" + passString);
	}

	public void extendTestFail(String passString) {
		test.pass("Testing Failed" + passString);
	}

	public void explicitwaitClick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(element)).click();
	}

	public String explicitwaitgetText(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		String word = wait.until(ExpectedConditions.visibilityOf(element)).getText();
		return word;
	}

	public void explicitwaitSendkeys(WebElement element, String word) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(word);
	}

	public void explicitwaitSendkeysClear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(element)).click();
	}
	public void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void JavascriptClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public String JavascriptGetText(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		String value=(String) executor.executeScript("arguments[0].getText();", element);
		return value;
	}

	public void click(WebDriver driver, WebElement value) {
		value.click();
	}

	public void sendKeys(WebDriver driver, WebElement value, String value1) {
		value.sendKeys(value1);
	}

	public void sendKeysClear(WebDriver driver, WebElement value, String value1) {
		value.sendKeys(value1);
		value.click();
	}
	public void screenshotCommon(WebDriver driver) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(
				"src\\test\\resources\\Screenshots\\Test "
						+ timestamp() + ".png");
		Files.copy(SrcFile, DestFile);

	}
	public void fileUploadftn(String path) throws AWTException, InterruptedException {
		StringSelection s = new StringSelection(
				path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);

		Robot robot = new Robot();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

}
