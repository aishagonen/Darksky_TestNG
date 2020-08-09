package com.qa.darksky.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.darksky.base.BasePage;
import com.qa.darksky.pages.TodayPageBasic;


public class TodayPageBasicTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	TodayPageBasic todayPageBasic;
	

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		todayPageBasic = new TodayPageBasic(driver);								
	}
	
	@Test(priority=1)
	public void clickTodayTest() {
		todayPageBasic.clickToday();
	}
	
	@Test(priority=2)
	public void verifyLowTempTest() {
		todayPageBasic.verifyLowTemp();
	}
	
	@Test(priority=23)
	public void verifyHighTempTest() {
		todayPageBasic.verifyHighTemp();
	}
	
	@AfterTest
	public void tearDown() {
		basePage.quitBrowser();
	}
		
	
	
}
