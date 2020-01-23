package com.rp.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

import com.rp.qa.util.Utilsetup;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {
	public static WebDriver driver;
	public static Properties prop;
	
	public  Testbase() {
		try {
			prop=new Properties();
		FileInputStream ip= new FileInputStream("C:\\Users\\Azhagu.R\\eclipse-workspace\\Royalprestige.com\\src"
				+ "\\main\\java\\com\\rp\\qa\\config\\config.properties");
		prop.load(ip);
		
	} catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}
	}
	
		
	
}
