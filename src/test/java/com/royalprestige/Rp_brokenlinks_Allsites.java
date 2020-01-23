package com.royalprestige;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rp.qa.base.Testbase;
import com.rp.qa.pages.FindActivelinks;
import com.rp.qa.pages.Finallistoflinks;
import com.rp.qa.pages.Finallistoflinks;

import net.bytebuddy.matcher.AccessibilityMatcher;

public class Rp_brokenlinks_Allsites extends Testbase {
	Finallistoflinks Finallinks;

	public Rp_brokenlinks_Allsites() {
		super();
	}

	@BeforeMethod
	public void setup() throws Exception {
		Finallinks = new Finallistoflinks();
	}

	@Test (priority=1)
	public void Toverifylink_US_Eng() throws Exception {
		
		Finallinks.browser(prop.getProperty("UsEngurl"));
		Finallinks.verifyexcellink("Useng");

	}
	
	@Test(priority=2)
	public void Toverifylink_US_Span() throws Exception {
		
		Finallinks.browser(prop.getProperty("UsSpanurl"));
		Finallinks.verifyexcellink("Usspan");
	}
	
	@Test(priority=3)
	public void Toverifylink_CA_Span() throws Exception {
		
		Finallinks.browser(prop.getProperty("CanadaSpanurl"));
		Finallinks.verifyexcellink("Caspan");
	}

	@Test(priority=4)
	public void Toverifylink_Mexico() throws Exception {
		
		Finallinks.browser(prop.getProperty("Mexicourl"));
		Finallinks.verifyexcellink("Mexico");
	}
	
	@Test(priority=5)
	public void Toverifylink_Brazil() throws Exception {
		
		Finallinks.browser(prop.getProperty("Brazilurl"));
		Finallinks.verifyexcellink("Brazil");
	}
	@Test(priority=6)
	public void Toverifylink_Dominicano() throws Exception {
		
		Finallinks.browser(prop.getProperty("Dominicanaurl"));
		Finallinks.verifyexcellink("Dominicano");
	}
	@Test(priority=7)
	public void Toverifylink_Peru() throws Exception {
		
		Finallinks.browser(prop.getProperty("Peruurl"));
		Finallinks.verifyexcellink("Peru");
	}
	@Test(priority=8)
	public void Toverifylink_Argentina() throws Exception {
		
		Finallinks.browser(prop.getProperty("Argentinaurl"));
		Finallinks.verifyexcellink("Argentina");
	}
	@Test(priority=9)
	public void Toverifylink_Ecudor() throws Exception {
		
		Finallinks.browser(prop.getProperty("Ecudorurl"));
		Finallinks.verifyexcellink("Ecudor");
	}
	
	@Test(priority=10)
	public void Toverifylink_Colombia() throws Exception {
		
		Finallinks.browser(prop.getProperty("Colombiaurl"));
		Finallinks.verifyexcellink("Colombia");
	}
	
	@AfterMethod

	public void teardown() {
		driver.quit();
	}
}
