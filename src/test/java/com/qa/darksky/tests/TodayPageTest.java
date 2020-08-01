package com.qa.darksky.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.darksky.base.BasePage;
import com.qa.darksky.pages.TodayPage;



public class TodayPageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	TodayPage todayPage;
	

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		driver.get(prop.getProperty("url"));
		todayPage = new TodayPage(driver);								
	}
	
	@Test(priority=1)
	public void clickTodayTest() {
		todayPage.clickToday();
	}
	
	@Test(priority=2)
	public void verifyLowTempTest() {
		todayPage.verifyLowTemp();
	}
	
	@Test(priority=23)
	public void verifyHighTempTest() {
		todayPage.verifyHighTemp();
	}
	
	@AfterTest
	public void tearDown() {
		basePage.quitBrowser();
	}
		
	
	
}
