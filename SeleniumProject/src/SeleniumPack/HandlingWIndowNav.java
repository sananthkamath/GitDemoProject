package SeleniumPack;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingWIndowNav {

static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.online.citibank.co.in/");
		driver.manage().window().maximize();
		String ParentWindowId = driver.getWindowHandle();
		System.out.println("Parent WIndow Id: " + ParentWindowId);
		WebElement LoginNow = driver.findElement(By.xpath("//*[@title='Login']"));
		LoginNow.click();
		
		Set<String> winids = driver.getWindowHandles();
		System.out.println("Number of open windows: " + winids.size());
		Iterator<String> iter = winids.iterator();
		String mainWindowId = iter.next().toString();
		String subWindowId = iter.next().toString();
		System.out.println("Main Window Id: " + mainWindowId);
		System.out.println("Sub Window Id: " + subWindowId);
		driver.switchTo().window(subWindowId);
		WebDriverWait wait = new WebDriverWait(driver,30);
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("User_Id")));
			driver.findElement(By.id("User_Id")).sendKeys("Selenium");
			Thread.sleep(3000);
			driver.close();
			driver.switchTo().window(mainWindowId);
			driver.findElement(By.id("topMnuinsurance")).click();
		}
		catch(Exception e)
		{
			System.out.println("Element USerId is not found.");
		}
	}
}
