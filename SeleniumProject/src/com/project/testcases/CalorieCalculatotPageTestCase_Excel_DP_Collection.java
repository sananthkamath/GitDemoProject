package com.project.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.pages.CaloriePage;
import com.project.pages.CaloriePage2;
import com.project.pages.CaloriePage3;
import com.project.utils.ExcelReader2;

public class CalorieCalculatotPageTestCase_Excel_DP_Collection {

	WebDriver driver = null;
	@Test(dataProvider = "getCalorieData")
	public void EnterCalorieDetails(Hashtable<String,String> data)
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize();
		
		CaloriePage cp = new CaloriePage(driver);
		cp.EnterCalorieDetails(data.get("age"), data.get("gender"));
		
		
		CaloriePage2 cp2 = new CaloriePage2(driver);
		cp2.EnterCalorieDetails(data.get("age"), data.get("gender"));
		
		CaloriePage3 cp3 = new CaloriePage3(driver);
		cp3 = PageFactory.initElements(driver, CaloriePage3.class);
		cp3.EnterCalorieDetails(data.get("age"), data.get("gender"));
	}
	
	@DataProvider
	public Object[][] getCalorieData() throws IOException
	{
		String ProjectPath = System.getProperty("user.dir");
        String filepath = ProjectPath + "/src/com/project/testdata";
        String filename = "TestData.xlsx";
        String sheetname ="Sheet1";
        return ExcelReader2.ReadFromExcel(filepath, filename, sheetname);
		
	}
}
