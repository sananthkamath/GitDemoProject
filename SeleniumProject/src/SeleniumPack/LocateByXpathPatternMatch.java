package SeleniumPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByXpathPatternMatch {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize();
		System.out.println("Identify all elements by attribute id that starts with c using xpath.");
		List<WebElement> startswithc = driver.findElements(By.xpath("//*[starts-with(@id,'c')]"));
		System.out.println("Size: " + startswithc.size());
		for(WebElement element: startswithc)
		{
			System.out.println(element.getAttribute("id"));
		}

		System.out.println("Identify all elements by attribute id that contains height using xpath.");
		List<WebElement> containsheight = driver.findElements(By.xpath("//*[contains(@id,'height')]"));
		System.out.println("Size: " + containsheight.size());
		for(WebElement element: containsheight)
		{
			System.out.println(element.getAttribute("id"));
		}
	}
}
