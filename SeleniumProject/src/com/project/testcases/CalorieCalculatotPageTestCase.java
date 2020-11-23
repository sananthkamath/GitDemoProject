package com.project.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.project.pages.CaloriePage;
import com.project.pages.CaloriePage2;
import com.project.pages.CaloriePage3;

public class CalorieCalculatotPageTestCase {

	WebDriver driver = null;
	@Test
	public void EnterCalorieDetails()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize();
		
		CaloriePage cp = new CaloriePage(driver);
		cp.EnterCalorieDetails("45", "f");
		
		
		CaloriePage2 cp2 = new CaloriePage2(driver);
		cp2.EnterCalorieDetails("75", "f");
		
		CaloriePage3 cp3 = new CaloriePage3(driver);
		cp3 = PageFactory.initElements(driver, CaloriePage3.class);
		cp3.EnterCalorieDetails("67", "m");
	}
}
