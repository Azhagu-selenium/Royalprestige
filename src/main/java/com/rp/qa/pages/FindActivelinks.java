package com.rp.qa.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;

import javax.net.ssl.ExtendedSSLSession;
import javax.net.ssl.HttpsURLConnection;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
//import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.SocketHandler;

import org.apache.http.ProtocolException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.helper.HttpConnection.Response;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.rp.qa.base.Testbase;

public class FindActivelinks extends Testbase
{
	
	
	public FindActivelinks()
	{
		PageFactory.initElements(driver, this);
	}
	

	public void popuphandle()
	{
		
		
		try {
			WebElement feedbackform=driver.findElement(By.id("feedbackform"));
			feedbackform.findElement(By.className("modal-body mdlbody form-group popscrl")).click();
			feedbackform.findElement(By.className("closeblock")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(""+e);
		}
		Alert myAlert = driver.switchTo().alert();
		myAlert.accept();
			String parentapp=driver.getWindowHandle();
			Set<String> s1=driver.getWindowHandles();
			Iterator<String> i1=s1.iterator();
			
			while(i1.hasNext()) {
				String childwindow=i1.next();
				
				if(!parentapp.equalsIgnoreCase(childwindow)) {
					driver.switchTo().window(childwindow);
					driver.findElement(By.xpath("//*[@id=\"fullName\"]")).sendKeys("dd");
                    driver.findElement(By.className("closeblock")).click();

				}
			}
					driver.switchTo().window(parentapp);
				
	}	
					
	public List<WebElement> tofind_Activelinks(List<WebElement> link) 
			{	
		//1.get the links and images
		

		//2. iterate the  linklist : exclude all the links/images - doesnt have any href attributes
	
		List<WebElement> Activelinks=new ArrayList<WebElement>();
		
		
		for(int i=0;i<link.size();i++) 
		{
			
		if(link.get(i).getAttribute("href")!= null
				&& (!link.get(i).getAttribute("href").isEmpty())
				&& (!link.get(i).getAttribute("href").contains("javascript"))
				&& (!link.get(i).getAttribute("href").contains("mailto:")))
						
			{
				Activelinks.add(link.get(i));
				
			 }
					

		}
		
		//3.get the active links
		System.out.println("size of full Active links and images "+Activelinks.size());
		return Activelinks;
		
			}
		}


