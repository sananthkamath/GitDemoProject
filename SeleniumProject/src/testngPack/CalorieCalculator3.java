package testngPack;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalorieCalculator3{
	
	@Test(dataProvider="login")
	//@Test(dataProvider = "getLoginData")
	public void Login(String username, String password)
	{
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println("Click on Submit");
	}
	@DataProvider(name="login")
	public Object[][] getLoginData()
	{
		String[][]  data = new String[2][2];
		data[0][0] = "user1";
		data[0][1] = "pass1";
		data[1][0] = "user2";
		data[1][1] = "pass2";
		return data;
	}
}