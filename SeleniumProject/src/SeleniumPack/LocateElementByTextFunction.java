package SeleniumPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElementByTextFunction {

	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize();
		List<WebElement> containsActiveList = driver.findElements(By.xpath("//*[@id='cactivity']/option[contains(text(),'Active')]"));
		for(WebElement element : containsActiveList) 
		{
			System.out.println(element.getText());
		}
		
		List<WebElement> startswithExtraList = driver.findElements(By.xpath("//*[@id='cactivity']/option[starts-with(text(),'Extra')]"));
		for(WebElement element : startswithExtraList) 
		{
			System.out.println(element.getText());
		}
		
		List<WebElement> VeryActiveElement = driver.findElements(By.xpath("//*[@id='cactivity']/option[text()='Very Active: intense exercise 6-7 times/week']"));
		for(WebElement element : VeryActiveElement) 
		{
			System.out.println(element.getText());
		}
		
		
	
	}
}