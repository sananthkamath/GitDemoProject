package SeleniumPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElementByXpath 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize();
		
		WebElement AgeByAbsPath = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[5]/table[1]/tbody/tr[1]/td[1]"));
		System.out.println("Identifying the label value by Absolute Path: " +  AgeByAbsPath.getText());
		
		WebElement AgeByRelPath = driver.findElement(By.xpath("//table[@id='calinputtable']/tbody/tr[1]/td[1]"));
		System.out.println("Identifying the label value by Relative Path: " +  AgeByRelPath.getText());
		
	}
}
