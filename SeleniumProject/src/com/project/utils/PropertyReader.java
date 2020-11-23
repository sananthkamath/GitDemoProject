package com.project.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	public static FileInputStream inputStream = null;
	public static Properties prop = null;
	public static String ReadProperty(String PropertyName) throws IOException{
		String PropertyValue = null;
		String ProjectPath = System.getProperty("user.dir");
		inputStream = new FileInputStream(ProjectPath + "/src/com/project/config/config.properties");
		prop = new Properties();
		prop.load(inputStream);
		PropertyValue = prop.getProperty(PropertyName);		
		return PropertyValue;
	}
	
	public static void main(String args[]) throws IOException{
		System.out.println(PropertyReader.ReadProperty("browser"));
		System.out.println(PropertyReader.ReadProperty("appurl"));
		System.out.println(PropertyReader.ReadProperty("chromedriverpath"));
	}
}
