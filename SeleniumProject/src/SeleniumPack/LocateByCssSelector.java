package SeleniumPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByCssSelector {
	static WebDriver driver;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize();
		WebElement ageLabelByCss = driver.findElement(By.cssSelector("#calinputtable > tbody > tr:nth-child(1) > td:nth-child(1)"));
		System.out.println(ageLabelByCss.getText());
		WebElement ageTextBox = driver.findElement(By.cssSelector("#cage"));
		ageTextBox.clear();
		ageTextBox.sendKeys("65");
		System.out.println("The css value of the ageTextBox: " + ageTextBox.getCssValue("width"));
		
		
		WebElement table = driver.findElement(By.cssSelector(".cinfoT "));
		//List<WebElement> rows = table.findElements(By.tagName("tr"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		if(rows.size()>0)
		{
			for(WebElement row: rows)
			{
				//List<WebElement> cols = row.findElements(By.tagName("td"));
				List<WebElement> cols = row.findElements(By.tagName("td"));
				for(WebElement col: cols)
				{
					System.out.print(col.getText() + "\t");
				}
				System.out.println();
			}
		}
	}
	

}
