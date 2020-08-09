package com.qa.darksky.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.darksky.base.BasePage;

public class ElementUtil extends BasePage{
	
	WebDriver driver;
	WebDriverWait wait;
	JavaScriptUtil javaScriptUtil;
	Properties prop;
	
	public ElementUtil(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, Constants.DEFAULT_TIME);
		javaScriptUtil = new JavaScriptUtil(driver);
	}
		
	public WebElement getElement(By locator){
		waitForElementPresent(locator);
		WebElement element = null;
		try{
		element = driver.findElement(locator);
//			if(flash) {
//				JavaScriptUtil.flash(element, driver);
//			}
		}
		catch (Exception e) {
			System.out.println("Some exception occured while creating webelement " +locator);
		}
		return element;
	}
	
	public boolean waitForElementPresent(By locator){
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		return true;
	}
	
	public boolean waitForTitlePresent(String title){
		wait.until(ExpectedConditions.titleIs(title));
		return true;
	}
	
	public boolean waitForElementVisible(By locator){
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;
	}
	
	public void doClick(By locator){
		waitForElementPresent(locator);
		try{
		getElement(locator).click();
		}
		catch(Exception e) {}
		
	}
	
	public void doSendKeys(By locator, String value){
		try{
			WebElement element  = getElement(locator);
			element.clear();
			element.sendKeys(value);
		}
		catch(Exception e){
			System.out.println("Some exception occured while sending to  webelement " + locator);
		}
	}
	
	public String doGetText(By locator){
		String text = null;
		try{
		text = getElement(locator).getText();
		}
		catch(Exception e){
			System.out.println("Some exception occured while getting text for element " + locator);
		}
		return text;
	}
	
	public String waitForGetPageTitle(String title){
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	
	public boolean isElementDisplayed(By locator){
		try{
			return getElement(locator).isDisplayed();
		}catch(Exception e){
			System.out.println("Some exception occured while checking webelement displayed "+ locator);
		}
		return false;
	}
	
	public boolean isElementSelected(By locator){
		try{
			return getElement(locator).isSelected();
		}catch(Exception e){
			System.out.println("Some exception occured while checking webelement selected "+ locator);
		}
		return false;
	}

	public String doGetPageTitle() {
		return driver.getTitle();
	}

	public void verifyGetText(By locator, String verifyText ) {
		String text = driver.findElement(locator).getText();
		if (text.equals(verifyText)) {
			System.out.println("Text is correct.");
		} else {
			System.out.println("Text is not correct.");
		}
	}
	
	public void compareValues(By DisplayedLocator, By ActualLocator, String value) {
		String displayed = driver.findElement(DisplayedLocator).getText();
		String actual = driver.findElement(ActualLocator).getText();
			
		if ((displayed.compareTo(actual))==0) {
			System.out.println(value + " is verified : " + displayed);
		} else {
			System.out.println(value + " is not verified. Actual " + value + " is: " + actual);
		}

	}
	
	
	public void getVerifyLowest(By listLocator, By lowestLocator ) {
		waitForElementVisible(listLocator);
		
		List<WebElement> list = driver.findElements(listLocator);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		for (int i = 0; i < list.size(); i++) {
			arrayList.add(Integer.parseInt(list.get(i).getText().replaceAll("\\D+", "")));		
		}
		Collections.sort(arrayList);
		System.out.println(arrayList);
		System.out.println(arrayList.get(0));
		
		int expectedValue = arrayList.get(0);
		int actualValue= Integer.parseInt(driver.findElement(lowestLocator).getText().replaceAll("\\D+", ""));

		Assert.assertEquals(actualValue, expectedValue);
	}
	
	public void getVerifyHighest(By listLocator, By highestLocator ) {
		waitForElementVisible(listLocator);
		
		List<WebElement> list = driver.findElements(listLocator);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		for (int i = 0; i < list.size(); i++) {
			arrayList.add(Integer.parseInt(list.get(i).getText().replaceAll("\\D+", "")));		
		}
		Collections.sort(arrayList);
		System.out.println(arrayList);
		int highIndex = arrayList.size()-1;
		
		System.out.println(arrayList.get(highIndex));
		
		int expectedValue = arrayList.get(highIndex);
		int actualValue= Integer.parseInt(driver.findElement(highestLocator).getText().replaceAll("\\D+", ""));

		Assert.assertEquals(actualValue, expectedValue);
	}
	
	
	
}









