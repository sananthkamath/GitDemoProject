package JavaPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Booking {
	public static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
	
	driver.get("https://www.goair.in/");
	driver.manage().window().maximize();
	
	WebElement book=driver.findElement(By.xpath("//*[@id=\"mainmenu\"]/li[4]/a"));
	book.click();
	/*
	 * WebDriverWait wait = new WebDriverWait(driver,10); Actions actions=new
	 * Actions(driver); try{
	 * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
	 * "//*[@id='destinationName']"))); WebElement BookingSearchTxtbox =
	 * driver.findElement(By.xpath("//*[@id='destinationName']"));
	 * actions.moveToElement(BookingSearchTxtbox).sendKeys("Dubai");
	 * 
	 * //PrinterElement.click();
	 * 
	 * }catch(NoSuchElementException e){ System.out.println("No Such Element"); }
	 */
	driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);

	
	  WebElement BookingSearchTxtbox=
	  driver.findElement(By.xpath("//*[@id='destinationName']"));
	  //BookingSearchTxtbox.clear();
	 
	 BookingSearchTxtbox.sendKeys("Kerala"); 
	 driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);

	  WebElement search= driver.findElement(By.xpath("//*[@id='a55a6d504d3ec99f']/div/div[2]/div/form/div/div[2]/a"));
	 search.click();
	 driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);

		  WebElement viewdetails= driver.findElement(By.xpath("//*[@id='Bestsellers']/div/div[3]/a/div[3]/button"));
		  viewdetails.click();
		  driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		  
			
			
			
			
	  WebDriverWait wait = new WebDriverWait(driver,60); Actions actions=new
	  Actions(driver); 
	  try{
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath( "//*[@id=\"dCityExId\"]"))); WebElement dest =
	  driver.findElement(By.xpath("//*[@id=\"dCityExId\"]"));
	//  actions.moveToElement(dest).sendValue("4320"); //PrinterElement.click();
	  }catch(NoSuchElementException e){ System.out.println("No Such Element"); }
	 
	  
	  
		/*
		 * WebElement inputElement = driver.findElement(By.className("acInput"));
		 * inputElement.sendKeys(value);
		 */
      By autoSuggSel = By.xpath("//div[@class='yui-ac-container']//div[@class='yui-ac-bd']//li");
      WebElement autoSuggestEl = driver.findElement(autoSuggSel);
      WebDriverWait wait1 = new WebDriverWait(driver, 10);
      wait1.until(ExpectedConditions.visibilityOf(autoSuggestEl)).click();
	  
	  
	  
	  
		  WebElement cal=driver.findElement(By.xpath("//*[@id='dateSelect']/a"));//calender icon
		 // WebElement date=driver.findElement(By.xpath("//*[@id='travelDt']"));//date feild
		  cal.findElement(By.xpath("/html/body/div[9]/div/div[2]/div[1]/table/tbody/tr[4]/td[4]/a")); //Select Wednesday, Dec 23, 2020
		  WebElement room= driver.findElement(By.xpath("//*[@id='numRooms1']"));
		  Select dd = new Select(room);
		  dd.selectByValue("2");
		  WebElement price=driver.findElement(By.xpath("//*[@id=\"tvlDtlsUpdForm\"]/ul/li[9]/a"));
		  price.click();
		 
		
		//  Thread.sleep(3000); driver.close();
		 
	}

}
