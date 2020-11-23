package JavaPack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoAirFlightStatus {
	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.goair.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement ComponentsMenu = driver.findElement(By.xpath("//*[@class='ng-scope']/ul/li[4]/a"));
		ComponentsMenu.click();
		
		  List<WebElement> statusList =
		  driver.findElements(By.name("flightstatus"));
		  if(statusList.size()>0){ for(WebElement status : statusList){
		  if(status.getAttribute("value").equals("3")) { if(!status.isSelected()){
		  status.click(); break; } } } }
		 	
		  WebElement fno = driver.findElement(By.xpath("//*[@id='txtMobile']"));
			fno.clear();
fno.sendKeys("123");
WebElement sel = driver.findElement(By.xpath("//*[@id='Flightstatus3']/div/table/tbody/tr/td[4]/div/button"));
sel.click();
WebElement noflight=driver.findElement(By.xpath("//*[@id='sectionBody']/div[1]/div[2]/div/span/b"));
if(noflight.getText().equalsIgnoreCase("No Flights Found")) {
	System.out.println("test success");
}
else {

	System.out.println("test not success");

}

				
	}
}
