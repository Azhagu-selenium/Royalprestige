package com.rp.qa.pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.ProtocolException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import com.rp.qa.util.Utilsetup;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Finallistoflinks extends FindActivelinks {

	FindActivelinks brokenlinks_objects;
	

	public void browser(String url) throws Exception {
    String browsername =prop.getProperty("browser");
		
    if(browsername.equalsIgnoreCase("chrome")) 
		{
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get(url);
	driver.manage().timeouts().pageLoadTimeout(Utilsetup.PAGE_LOAD_WAIT,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(Utilsetup.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.get(url);
		}
}
	
	public List<String> verifyexcellink (String sheetname)
			
			throws Exception, MalformedURLException, IOException, ProtocolException 
	{
		List<WebElement> link = driver.findElements(By.tagName("a"));
		link.addAll(driver.findElements(By.tagName("img")));

	List<WebElement> Responselink = tofind_Activelinks(link);
	List<String> Actual = new ArrayList<String>();

		FileInputStream File = new FileInputStream(prop.getProperty("FilePath"));

		XSSFWorkbook wb = new XSSFWorkbook(File);
		XSSFSheet sh = wb.getSheet(sheetname);

		// 4.check the href url with httpconnection obj
		for (int j = 0; j <Responselink.size(); j++) {

			XSSFRow row = sh.createRow(j);
			// cookie proplem
			CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));

			row.createCell(0).setCellValue(Responselink.get(j).getAttribute("href"));
			// verify the http connection against url
			try {
				HttpURLConnection connection;

				connection = (HttpURLConnection) new URL(Responselink.get(j).getAttribute("href")).openConnection();

				// TODO Auto-generated catch block

				connection.setRequestMethod("HEAD");

				String response = connection.getResponseMessage();
				connection.disconnect();
				row.createCell(1).setCellValue(response);
				if (response.toLowerCase().equals("ok")) {

					Actual.add(response);
				}
				//System.out.println(Responselink.get(j).getAttribute("href"));

			}

			catch (Exception e)

			{
				row.createCell(1).setCellValue(e.getMessage());
				System.out.println("Exception is: " + e);

			}
			FileOutputStream fos = new FileOutputStream(prop.getProperty("FilePath"));
			wb.write(fos);
			fos.close();

		}
		//Assert.assertEquals(Responselink.size(), Actual.size());
	
		return Actual;

	}
}
