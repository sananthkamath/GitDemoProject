package SeleniumPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingAjaxSuggestion {
	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize(); //maximizing window
		WebElement GoogleSearchTxtbox = driver.findElement(By.name("q"));
		GoogleSearchTxtbox.sendKeys("selenium");
		//To make sure that the list is appearing upon typing selenium
		//we need to check whether the 1st item list is appearing
		WebDriverWait wait = new WebDriverWait(driver,30);
		try{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@role='listbox']/li[1]")));
		List<WebElement> lst = driver.findElements(By.xpath("//*[@role='listbox']/li"));
		//select selenium tutorial
		for(WebElement element : lst){
			if(element.getText().equals("selenium tutorial")){
				element.click();
				break;
			}
		}
		}catch(NoSuchElementException e){
			System.out.println("List is not found");
		}
	}
}
