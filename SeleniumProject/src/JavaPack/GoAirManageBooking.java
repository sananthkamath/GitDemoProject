package JavaPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoAirManageBooking {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.goair.in/");
		driver.manage().window().maximize();
		WebElement manage=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[2]/div/div/div/div/div[2]/div/div/div/div[2]/ul/li[2]/a"));
manage.click();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

WebElement pnr=driver.findElement(By.xpath("//*[@id=\"managecheckin\"]/div/div/div[1]/div/input"));
pnr.sendKeys("A1200");
WebElement email=driver.findElement(By.xpath("//*[@id=\"managecheckin\"]/div/div/div[2]/div/input"));
email.sendKeys("sapna@gmail.com");
WebElement retrive=driver.findElement(By.xpath("//*[@id=\"managecheckin\"]/div/div/div[3]/div/button"));
retrive.click();

Alert alert=driver.switchTo().alert();
driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);


alert.accept();
String actualUrl="https://www.goair.in/";
String currentUrl=driver.getCurrentUrl();
if(actualUrl.equalsIgnoreCase(currentUrl)) {
	System.out.println("test passed");
}
else {
	System.out.println("test  not passed");

}
Thread.sleep(3000);
driver.close();
	}

}
