package AssignmentPack;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class RedBusApp_T01
{
	WebDriver driver = null;
	@Test public void SignIn_SignOut() throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement LoginIcon = driver.findElement(By.xpath("//*[@id='i-icon-profile']"));
		LoginIcon.click();
		WebDriverWait wait = new WebDriverWait(driver,30); 
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='signInLink']")));
			WebElement SignIn_Up = driver.findElement(By.xpath("//*[@id='signInLink']"));
			SignIn_Up.click();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("No SignIn/SignUp Element");
		}
		wait = new WebDriverWait(driver,30); 
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className("modalIframe")));
			WebElement SignInOptElement = driver.findElement(By.className("modalIframe"));
			driver.switchTo().frame(SignInOptElement);
			WebElement googleElement = driver.findElement(By.xpath("//*[@id='customBtn']"));
			googleElement.click();
			
		}
		catch(NoSuchElementException e)
		{
			System.out.println("The Sign in frame does not appear.");
		}
		
		Set<String> winids = driver.getWindowHandles();
		System.out.println("Number of open windows: " + winids.size());
		Iterator<String> iter = winids.iterator();
		String redBusWindowId = iter.next().toString();
		String googleSignInWindowId = iter.next().toString();
		System.out.println("Main Window Id: " + redBusWindowId);
		System.out.println("Sub Window Id: " + googleSignInWindowId);
		driver.switchTo().window(googleSignInWindowId);
		wait = new WebDriverWait(driver,30);
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='identifierId']")));
			driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("seleniumjavaexample@gmail.com");
			WebElement nextButton = driver.findElement(By.xpath("//*[@id='identifierNext']/div/button"));
			nextButton.click();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Email valid email.");
		}
		Thread.sleep(2000);
		wait = new WebDriverWait(driver,40);
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")));
			driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("selenium1234.");
			WebElement nextButton = driver.findElement(By.xpath("//*[@id='passwordNext']/div/button"));
			nextButton.click();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Enter valid password.");
		}
		Thread.sleep(2000);
		driver.switchTo().window(redBusWindowId);
		Thread.sleep(8000);
		
		
		LoginIcon = driver.findElement(By.xpath("//*[@id='i-icon-profile']"));
		LoginIcon.click();
		wait = new WebDriverWait(driver,30); 
		Actions actions = new Actions(driver);
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='signOutLink']")));
			WebElement SignOut = driver.findElement(By.xpath("//*[@id='signOutLink']"));
			actions.moveToElement(SignOut).click().build().perform();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("No Sign Out Element");
		}
		
		Thread.sleep(2000);
		if(driver!=null)
		{
			driver.close();
			driver.quit();
		}
	}
}
