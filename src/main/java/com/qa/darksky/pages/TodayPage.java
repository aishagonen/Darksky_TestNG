package com.qa.darksky.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.darksky.base.BasePage;
import com.qa.darksky.utils.ElementUtil;
import com.qa.darksky.utils.JavaScriptUtil;



public class TodayPage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;
	WebElement element;
	
	By todayBtn = By.xpath("//span[contains(text(),'Today')]");
	By minTemp = By.xpath("//span[@class='minTemp'][1]");
	By maxTemp = By.xpath("//span[@class='maxTemp'][1]");
	By minTempActual = By.xpath("//span[@class='temp'][1]");
	By maxTempActual = By.xpath("//span[@class='lowTemp swap']//span[1]"); 
	
	
	public TodayPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		javaScriptUtil = new JavaScriptUtil(driver);
	}
	
	public void clickToday() {
		elementUtil.waitForElementPresent(todayBtn);
		elementUtil.doClick(todayBtn);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void verifyLowTemp() {
		elementUtil.compareValues(minTemp, minTempActual, "Lowest temperature");
		
	}
	
	public void verifyHighTemp() {
		elementUtil.compareValues(maxTemp, maxTempActual, "Highest temperature");
		
	}
	
	
}
