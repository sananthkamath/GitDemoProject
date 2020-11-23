package JavaPack;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoAirDisplay {
	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.goair.in/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement ComponentsMenu = driver.findElement(By.xpath("//*[@id=\"mainmenu\"]/li[3]/p/span"));
		ComponentsMenu.click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		Actions actions=new Actions(driver);
		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mainmenu\"]/li[3]/ul/li[6]/a")));
			WebElement FlightSchedule = driver.findElement(By.xpath("//*[@id=\"mainmenu\"]/li[3]/ul/li[6]/a"));
			actions.moveToElement(FlightSchedule).click().build().perform();
			//PrinterElement.click();
		}catch(NoSuchElementException e){
			System.out.println("No Such Element");
		}

		  
		 	
		
				
	}
}
