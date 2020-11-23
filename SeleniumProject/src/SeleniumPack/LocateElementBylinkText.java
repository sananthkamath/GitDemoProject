package SeleniumPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElementBylinkText {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement bmi = driver.findElement(By.linkText("BMI"));
		bmi.click();
		System.out.println("Title of the page: " + driver.getTitle());
		Thread.sleep(2000);
		driver.navigate().back();
		System.out.println("Url of the page: " + driver.getCurrentUrl());
		Thread.sleep(2000);
		WebElement weightLink = driver.findElement(By.partialLinkText("Weight"));
		weightLink.click();
		System.out.println("Pagesource: " + driver.getPageSource());
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.findElement(By.linkText("BMI")).click();
		
		
		
	}

}
