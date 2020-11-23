package JavaPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoAirLogin {
	public static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		
		
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		
		driver.get("https://www.goair.in/");
		driver.manage().window().maximize();
		WebElement LoginNow=driver.findElement(By.xpath("/html/body/header/div[1]/div/span[2]/ul/li/a"));
		LoginNow.click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		Actions actions=new Actions(driver);
		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/header/div[1]/div/span[2]/ul/li/ul/li[2]/a")));
			WebElement gsme = driver.findElement(By.xpath("/html/body/header/div[1]/div/span[2]/ul/li/ul/li[2]/a"));
			actions.moveToElement(gsme).click().build().perform();
			//PrinterElement.click();
		}catch(NoSuchElementException e){
			System.out.println("No Such Element");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement user = driver.findElement(By.xpath("//*[@id='starterAgentLogin_Username']"));		
		//ageTextbox.clear();
		user.sendKeys("test@123");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement pass = driver.findElement(By.xpath("//*[@id='starterAgentLogin_Password']"));		
		//ageTextbox.clear();
		pass.sendKeys("test123");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement Login=driver.findElement(By.xpath("//*[@id='login_sme_submit_button']/span"));
		Login.click();
		//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		String actualUrl="https://book.goair.in/Agent/SMELogin";
		String currentUrl=driver.getCurrentUrl();
		if(actualUrl.equalsIgnoreCase(currentUrl)) {
			System.out.println("test passed");
		}
		else {
			System.out.println("test  not passed");

		}
		
		  Thread.sleep(3000); driver.close();
}
}
//*[@id="smeLoginForm"]/div[1]/div[2]
//*[@id="starterAgentLogin_Username"]
