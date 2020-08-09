package com.qa.darksky.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qa.darksky.base.BasePage;
import com.qa.darksky.utils.ElementUtil;

public class TodayPage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	WebElement element;
	
	By todayBtn = By.xpath("//span[contains(text(),'Today')]");
					//By.xpath("//span[contains(@class, 'name')][1]");
	By tempList = By.xpath("//div[@id='timeline']//div[@class='temps']//span");
				//By.xpath("//div[2]/div[2]/div/div/div[4]/span");
				//By.xpath("(//div[@class='temps'])[2]//span//span");
	By minTempActual = 	By.className("low-temp-text");					
						//By.xpath("//span[@class='minTemp'][1]");
	By maxTempActual = By.className("high-temp-text");
						//By.xpath("//span[@class='maxTemp'][1]");
	//By currentLoc = By.xpath("//a[@class='currentLocationButton']//img");
	
	public TodayPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public TodayPage clickToday() {
		elementUtil.waitForElementVisible(todayBtn);
		elementUtil.doClick(todayBtn);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new TodayPage(driver);
	}
	
	public void verifyLowTemp() {
		elementUtil.getVerifyLowest(tempList, minTempActual);		
	}
		
	public void verifyHighTemp() {	
		elementUtil.getVerifyHighest(tempList, maxTempActual);	
	}
	

}










/*
	 public void verifyHighTemp() {
	  	elementUtil.waitForElementVisible(tempList);
		List<WebElement> list = driver.findElements(tempList);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			arrayList.add(Integer.parseInt(list.get(i).getText().replaceAll("\\D+", "")));		
		}
		Collections.sort(arrayList);
		int highIndex = arrayList.size()-1;
		System.err.println(arrayList.get(highIndex));
		int expectedTemp = arrayList.get(highIndex);
		int actualTemp = Integer.parseInt(driver.findElement(maxTempActual).getText().replaceAll("\\D+", ""));
		Assert.assertEquals(actualTemp, expectedTemp);
	}
	 	  
	public void verifyLowTemp() {
		clickToday();
		elementUtil.waitForElementVisible(tempList);
		List<WebElement> list = driver.findElements(tempList);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			arrayList.add(Integer.parseInt(list.get(i).getText().replaceAll("\\D+", "")));		
		}
		Collections.sort(arrayList);
		System.out.println(arrayList);
		System.err.println(arrayList.get(0));
		int expectedTemp = arrayList.get(0);
		int actualTemp = Integer.parseInt(driver.findElement(minTempActual).getText().replaceAll("\\D+", ""));
		Assert.assertEquals(actualTemp, expectedTemp);	
	}
	  
	  
	  
	  
	  
	  
	  
 */





