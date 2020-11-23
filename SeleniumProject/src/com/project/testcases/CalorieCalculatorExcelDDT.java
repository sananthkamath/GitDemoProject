package com.project.testcases;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.config.EnvSettings;
import com.project.utils.ExcelReader;
import com.project.utils.ExcelReader2;

public class CalorieCalculatorExcelDDT {
	WebDriver driver = null;
	@BeforeClass
	//@BeforeMethod
	public void LaunchBrowser(){
		System.setProperty("webdriver.chrome.driver", EnvSettings.QAEnv.chromedriverpath);
		driver = new ChromeDriver();
		driver.get(EnvSettings.QAEnv.appurl);
		driver.manage().window().maximize(); //maximizing window
	}

	@Test(dataProvider="getCalorieData")
	public void EnterCalorieDetails(Hashtable<String,String> caldata) throws InterruptedException{
		WebElement ageTextbox = driver.findElement(By.id("cage"));		
		ageTextbox.clear(); //clears the textbox
		ageTextbox.sendKeys(caldata.get("age")); //enters value into the textbox
		List<WebElement> genderList = driver.findElements(By.name("csex"));
		if(genderList.size()>0){
			for(WebElement gender : genderList){
				if(gender.getAttribute("value").equals(caldata.get("gender")))
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
	public void ExtractWebTable(){
		//By class attribute
		WebElement table = driver.findElement(By.className("cinfoT"));
		table = driver.findElement(By.xpath("//*[@class='cinfoT ']"));
		//all this while we were using findElement and findElements with respect to driver object
		//here we will use it with respect to the table element
		//if i identify rows by driver object - it will rows of all tables in the web page - we
		//want only rows of the table which is identified by cinfoT and only the first table
		List<WebElement> rows = table.findElements(By.tagName("tr")); //all rows with respect to table element
		for(WebElement row : rows){
			List<WebElement> cols = row.findElements(By.tagName("td")); //identifies all cols for the current row
			for(WebElement col : cols){
				System.out.print(col.getText() + "\t"); //this is to print all the cellss of a particular row in the same line
			}
			System.out.println(""); //go to the next line before print the cell values of next row
		}		

	}
	
	@DataProvider
	public Object[][] getCalorieData() throws IOException{
/*		Object[][] data = new Object[2][1];
		Hashtable<String,String> rec1 = new Hashtable<String,String>();
		rec1.put("age", "45");
		rec1.put("gender", "f");
		Hashtable<String,String> rec2 = new Hashtable<String,String>();
		rec2.put("age", "56");
		rec2.put("gender", "m");

		data[0][0] = rec1;
		data[1][0] = rec2;
		return data;
		
*/
		String ProjectPath = System.getProperty("user.dir");
		String filepath = ProjectPath + "/src/com/project/testdata";
		String filename = "CalorieTestData.xlsx";
		String sheetname ="CalorieTestSet";
		return ExcelReader2.ReadFromExcel(filepath, filename, sheetname);
	}
	@AfterClass
	//@AfterMethod
	public void CloseBrowser() throws InterruptedException{
		Thread.sleep(3000);
		if(driver!=null)
		{
			driver.close();
			driver.quit();
		}

	}

}
