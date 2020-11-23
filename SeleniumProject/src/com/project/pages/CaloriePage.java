package com.project.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CaloriePage {

	WebElement ageTextBox;
	
	List<WebElement> genderList;
	
	WebDriver driver;
	
	public CaloriePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void EnterCalorieDetails(String age, String sex)
	{
		ageTextBox = driver.findElement(By.id("cage"));
		ageTextBox.clear();
		ageTextBox.sendKeys(age);
		List<WebElement> genderList = driver.findElements(By.xpath("//*[@name='csex']"));
		if(genderList.size()>0)
		{
			for(WebElement gender: genderList)
			{
				if(gender.getAttribute("value").equals(sex));
				{
					if(!gender.isSelected()){
						gender.click();
						break;
					}
					
				}
			}
		}
		
	}
}
