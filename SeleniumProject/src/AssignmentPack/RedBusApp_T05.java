package AssignmentPack;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class RedBusApp_T05 
{
	WebDriver driver= null;
	@Test public void BusHire() throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//Login
		/*WebElement LoginIcon = driver.findElement(By.xpath("//*[@id='i-icon-profile']"));
		LoginIcon.click();*/
	    WebDriverWait wait = new WebDriverWait(driver,30); 
		/*try
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
		
		WebElement manageBooking = driver.findElement(By.id("select_box_managebooking"));
		manageBooking.click();
		wait = new WebDriverWait(driver,30);
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='hmb']/div[2]/ul/li[4]")));
			WebElement showMyTicket = driver.findElement(By.xpath("//*[@id='hmb']/div[2]/ul/li[4]"));
			showMyTicket.click();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("No Show My Ticket Element");
		}*/
		
		/*Bus Hire*/
	    //Accessing Hire A Vehicle 
		WebElement busHire = driver.findElement(By.id("redBus Bus Hire"));
		busHire.click();
		wait = new WebDriverWait(driver,30);
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='reactContentMount']/div/div[5]/div[2]/object")));
			WebElement hireAvehicle = driver.findElement(By.xpath("//*[@id='reactContentMount']/div/div[5]/div[2]/object"));
			driver.switchTo().frame(hireAvehicle);
			WebElement local = driver.findElement(By.xpath("//*[@id='app']/div/div[3]/div[2]/div[1]"));
			local.click();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("The \"Local\" Element does not exist.");
		}
		
		Thread.sleep(10000);
		
		//Filling In the Pickup Address
//		wait = new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("locationTextFieldLocal")));
		WebElement pickUp = driver.findElement(By.id("locationTextFieldLocal"));
		pickUp.sendKeys("Vijayanagar");
		wait = new WebDriverWait(driver,30);
		int flag1 = 0;
		try
		{
			System.out.println("inside Try");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ui-id-1']/li[1]")));
			List<WebElement> pickUpLocations = driver.findElements(By.xpath("//*[@id='ui-id-1']/li"));
			for(WebElement element: pickUpLocations)
			{
				System.out.println("inside floop1");
				WebElement divUnit = element.findElement(By.tagName("div"));
				List<WebElement> spanUnits = divUnit.findElements(By.tagName("span"));
				for(WebElement unit: spanUnits)
				{
					System.out.println("inside floop2");
					if(unit.getText().equals("Vijayanagar, Bengaluru, Karnataka, India"))
					{
						System.out.println("inside if");
						Thread.sleep(1000);
						element.click();
						flag1 = 1;
					}
				}
				if(flag1 == 1)
					break;
			}
		}
		catch(Exception e)
		{
			System.out.println("The element does not exist.");
		}
		
		driver.switchTo().parentFrame();
		Thread.sleep(1000);
		WebElement hireAvehicle = driver.findElement(By.xpath("//*[@id='reactContentMount']/div/div[5]/div[2]/object"));
		driver.switchTo().frame(hireAvehicle);
		
		Thread.sleep(2000);
		
		//Filling destination address
		WebElement destn = driver.findElement(By.id("local_dest_name"));
		destn.sendKeys("JP Nagar");
		wait = new WebDriverWait(driver,30);
		int flag2 = 0;
		try
		{
			System.out.println("inside try");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ui-id-2']/li[2]")));
			List<WebElement> destnLocations = driver.findElements(By.xpath("//*[@id='ui-id-2']/li"));
			for(WebElement element2: destnLocations)
			{
				System.out.println("inside floop1.");
				WebElement divUnit2 = element2.findElement(By.tagName("div"));
				List<WebElement> spanUnits2 = divUnit2.findElements(By.tagName("span"));
				for(WebElement unit2: spanUnits2)
				{
					System.out.println("inside floop2.");
					System.out.println(unit2.getText());
					if(unit2.getText().equals("J P Nagar 7th Phase, Bangalore, Karnataka, India") || unit2.getText().equals("J P Nagar 7th Phase, Bengaluru, Karnataka, India"));
					{
						System.out.println("inside if.");
						Thread.sleep(1000);
						element2.click();
						flag2 = 1;
					}
				}
				if(flag2 == 1)
					break;
			}
		}
		catch(Exception e)
		{
			System.out.println("The element does not exist.");
		}
		
		Thread.sleep(2000);
		
		//Selecting a Package
		List<WebElement> packageLabel = driver.findElements(By.xpath("//*[@id='LocalLeadGen_Pckage_Tap']/label"));
		wait = new WebDriverWait(driver,30);
		if(packageLabel.size()>0)
		{
			for(WebElement label: packageLabel)
			{
				WebElement input = label.findElement(By.tagName("input"));
				if(input.getAttribute("value").equals("12"))
				{
					if(!label.isSelected()){
						label.click();
						break;
					}
					
				}
			}
			//Entering Date and time
			Thread.sleep(2000);
//
//			
//			JavascriptExecutor jse2 = (JavascriptExecutor)driver;
//			jse2.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//			WebElement date_time = driver.findElement(By.id("LocalLeadGen_DateOfPickup_Click"));
//			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='LocalLeadGen_DateOfPickup_Click']")));
//			date_time.click();
			WebElement myelement = driver.findElement(By.id("LocalLeadGen_DateOfPickup_Click"));
			JavascriptExecutor jse2 = (JavascriptExecutor)driver;
			jse2.executeScript("arguments[0].scrollIntoView()", myelement); 
		}
		//Entering Date and Time
		//wait = new WebDriverWait(driver,30);
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[5]/div[3]/div/div[1]")));
			
		}
		catch(NoSuchElementException e)
		{
			System.out.println("The date time element does not exist.");
		}
		
		//Clicking on the year button
		WebElement yearButton = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[1]/div/div[1]/div[1]/button"));
		yearButton.click();
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		Actions a = new Actions(driver);
		try
		{
			wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[2]/div/div[1]")));
			WebElement year20 = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[2]/div/div[1]"));
			a.moveToElement(year20).click().build().perform();
		}
		catch(Exception e)
		{
			System.out.println("The 2021 year was not found.");
		}
		
		WebElement day = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[2]/div[2]/div/div[5]/div[1]/button"));
		day.click();
		WebDriverWait w1 = new WebDriverWait(driver,30);
		try
		{
			w1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[2]/div/div/span[4]")));
			WebElement hour = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[2]/div/div/span[4]"));
			hour.click();
		}
		catch(Exception e)
		{
			System.out.println("The hour element is not found.");
		}
		
		WebDriverWait w2 = new WebDriverWait(driver,30);
		try
		{
			w2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[2]/div/div/span[3]")));
			WebElement mins = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[1]/div/div[2]/div/div/span[3]"));
			mins.click();
		}
		catch(Exception e)
		{
			System.out.println("The mins element is not found.");
		}
		
		
		
		
//		Thread.sleep(2000);
//		
//		//Entering the number of passengers
//		WebElement noOfPassengers = driver.findElement(By.id("numberOfPax"));
//		noOfPassengers.sendKeys("5");
//		
//		Thread.sleep(2000);
//		
//		//Click on proceed
//		WebElement proceed = driver.findElement(By.id("proceedButtonLocal"));
//		proceed.click();
		
		//Log Out
		/*LoginIcon = driver.findElement(By.xpath("//*[@id='i-icon-profile']"));
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
		
		Thread.sleep(5000);
		if(driver!=null)
		{
			driver.close();
			driver.quit();
		}*/
	}
}
