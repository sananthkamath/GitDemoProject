package SeleniumPack;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlertPopUps {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('This is an informational alert')");
		//we need to switch control to alert
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		Thread.sleep(2000);
		alert.accept();//Clicks on OK button
		if(alertMsg.equals("This is an informational alert"))
			System.out.println("alert message match found");
		else
			System.out.println("Alert message match not found.");
		
		js.executeScript("confirm('Do you want to continue (y/n):')");
		//we need to switch control to confirm
		Alert alert1 = driver.switchTo().alert();
		String alertMsg1 = alert1.getText();
		Thread.sleep(2000);
		alert1.dismiss();//Clicks on cancel button
		if(alertMsg1.equals("This is an informational alert"))
			System.out.println("alert message match found");
		else
			System.out.println("Alert message match not found.");
	}

}
