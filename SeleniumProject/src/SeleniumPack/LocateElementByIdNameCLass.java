package SeleniumPack;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElementByIdNameCLass {
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize();
		//WebElement ageTextbox = driver.findElement(By.id("cage"));
		WebElement ageTextbox = driver.findElement(By.xpath("//*[@id='cage']"));
		ageTextbox.clear();
		ageTextbox.sendKeys("45");
		System.out.println("Tagname of ageTextBox: " + ageTextbox.getTagName());
		System.out.println("Id value of ageTextBox: " + ageTextbox.getAttribute("id"));
		System.out.println("Name value of ageTextBox: " + ageTextbox.getAttribute("name"));
		System.out.println("type value of ageTextBox: " + ageTextbox.getAttribute("type"));
		System.out.println("class value of ageTextBox: " + ageTextbox.getAttribute("class"));
		System.out.println("Value of ageTextBox: " + ageTextbox.getAttribute("value"));
		
		//locate using name attribute
		//List<WebElement> genderList = driver.findElements(By.name("csex"));
		List<WebElement> genderList = driver.findElements(By.xpath("//*[@name='csex']"));
		if(genderList.size()>0)
		{
			for(WebElement gender: genderList)
			{
				if(gender.getAttribute("value").equals("f"))
				{
					if(!gender.isSelected()){
						gender.click();
						break;
					}
					
				}
			}
		}
		
		//locate using class
		//WebElement table = driver.findElement(By.className("cinfoT"));
		WebElement table = driver.findElement(By.xpath("//*[@class='cinfoT ']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		if(rows.size()>0)
		{
			for(WebElement row: rows)
			{
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
