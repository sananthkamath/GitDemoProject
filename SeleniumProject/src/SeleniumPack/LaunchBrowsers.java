package SeleniumPack;
import java.util.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class LaunchBrowsers {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.print("Enter the browser name you want to open (chrome, ie, firefox): ");
		Scanner sc = new Scanner(System.in);
		String web = sc.nextLine();
		System.out.print("Enter the URL: ");
		String url = sc.nextLine();
		if(web.equals("chrome"))
		{
			// TODO Auto-generated method stub
			//System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Training\\Softwares\\chromedriver_win32 (1)\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.get(url);
			Thread.sleep(3000);
			driver.close();
		}
		else if(web.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			FirefoxDriver driver = new FirefoxDriver();
			driver.get(url);
			Thread.sleep(3000);
			driver.close();
		}
		else if(web.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			InternetExplorerDriver driver = new InternetExplorerDriver();
			driver.get(url);
			Thread.sleep(3000);
			driver.close();
		}
		sc.close();	
	}
}
