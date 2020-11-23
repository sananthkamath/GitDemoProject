
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingAjaxSuggestions {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		WebElement GoogleSearchText = driver.findElement(By.name("q"));
		GoogleSearchText.sendKeys("selenium");
		//to make sure the list is appearing upon typing selenium we need to 
		//check if first item in the list is appearing
		WebDriverWait wait = new WebDriverWait(driver,30);
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@role='listbox']/li[1]")));
			List<WebElement> lst = driver.findElements(By.xpath("//*[@role='listbox']/li"));
			//select selenium tutorial
			Thread.sleep(2000);
			for(WebElement element: lst)
			{
				if(element.getText().equals("selenium tutorial"))
				{
					element.click();
					break;
				}
			}
		}
		catch(NoSuchElementException e)
		{
			System.out.println("List is not found.");
		}
	}
}
