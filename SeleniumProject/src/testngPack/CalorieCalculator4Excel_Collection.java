package testngPack;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.utils.ExcelReader2;

public class CalorieCalculator4Excel_Collection 
{
	WebDriver driver = null;
	
	@BeforeMethod
	//@BeforeClass - runs both the tests together
	public void LaunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider = "getCalorieData") 
	public void EnterCalorieDetails(Hashtable<String,String> data)
	{
		// TODO Auto-generated method stub
		//WebElement ageTextbox = driver.findElement(By.id("cage"));
		WebElement ageTextbox = driver.findElement(By.xpath("//*[@id='cage']"));
		ageTextbox.clear();
		ageTextbox.sendKeys(data.get("age"));
		
		List<WebElement> genderList = driver.findElements(By.xpath("//*[@name='csex']"));
		if(genderList.size()>0)
		{
			for(WebElement gender: genderList)
			{
				if(gender.getAttribute("value").equals(data.get("gender")))
				{
					if(!gender.isSelected()){
						gender.click();
						break;
					}
					
				}
			}
		}
	}
	
	@Test
	public void ExtractWebTable()
	{
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
	
	@AfterMethod
	//@AfterClass - both will run both the tests together
	public void CloseBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		if(driver!=null)
		{
			driver.close();
			driver.quit();
		}
	}
	
	@DataProvider
	public Object[][] getCalorieData() throws IOException
	{
		String ProjectPath = System.getProperty("user.dir");
        String filepath = ProjectPath + "/src/com/project/testdata";
        String filename = "CalorieTestData.xlsx";
        String sheetname ="CalorieTestSheet";
        return ExcelReader2.ReadFromExcel(filepath, filename, sheetname);
		
	}
}
