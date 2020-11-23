package testngPack;
	
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
	
 
public class ExtentReportsClass{
public ExtentHtmlReporter htmlReporter = null;
public ExtentReports extent = null;
public ExtentTest logger = null;
public WebDriver driver = null; 

 @BeforeTest
 public void startReport(){
     htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/STMExtentReport.html");
     extent = new ExtentReports();
     extent.attachReporter(htmlReporter);
     extent.setSystemInfo("Host Name", "SoftwareTesting");
     extent.setSystemInfo("Environment", "Automation Testing");
     extent.setSystemInfo("User Name", "TestEngineer");
	 htmlReporter.config().setDocumentTitle("Title of the Report");
	 htmlReporter.config().setReportName("Selenium Regression Test Suite");
	 htmlReporter.config().setTheme(Theme.STANDARD);		
 }
 
	@BeforeMethod
	public void LaunchBrowser(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//Creating object instance of ChromeDriver class
		//This will launch chrome browser		
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.calculator.net/calorie-calculator.html");		
	}
	@Test
	public void verifyTitle(){
		logger = extent.createTest("Verify the Calorie Calculator Title");
		Assert.assertEquals(driver.getTitle(), "Calorie Calculator");
	}
	
	@Test
	public void VerifyPresentOfAgeTextbox(){
		logger = extent.createTest("Verify the Age Textbox is Present or not");
		boolean flg = driver.findElement(By.id("cage")).isDisplayed();
		//create node for each step 
		logger.createNode("The age Textbox is present");
		Assert.assertTrue(flg);
		logger.createNode("The age textbox is not present");
		Assert.assertFalse(flg);
	}
	
	
	public String getScreenshot(WebDriver driver, String ScreenshotName) throws IOException{
		//for that we need to reference another jar files 
		//one for the extent report and another is for snapshot
		//please go to google driver and unzip common-io jars and reference it in the project
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String destination = System.getProperty("user.dir")+"/Screenshots/" + ScreenshotName + dateName + ".png"; 
		//added common-io jars
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}
	
	@AfterMethod
	public void CloseBrowser(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE){
			//log the results
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed ", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed ", ExtentColor.RED));
			logger.fail("Test Case Failed Snapshot is below - " + logger.addScreenCaptureFromPath(getScreenshot(driver,result.getName())));
		}
		else if(result.getStatus() == ITestResult.SKIP){
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped ", ExtentColor.ORANGE));
		}
		else if(result.getStatus() == ITestResult.SUCCESS){
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case Passed ", ExtentColor.GREEN));
		}
		driver.quit();
		
	}
	@AfterTest
	public void stopTest(){
		extent.flush(); //at the end of all tests - it will append the test results to the htmlreport when flushed
	}

}
