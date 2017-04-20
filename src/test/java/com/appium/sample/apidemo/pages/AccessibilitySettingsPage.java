package com.appium.sample.apidemo.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Rajani on 2017-04-15.
 */
public class AccessibilitySettingsPage {
	
	private WebDriver driver;
	
	public AccessibilitySettingsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
		@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/list\")")
		@AndroidFindBy(className = "android.widget.RelativeLayout")
		public List<WebElement> allSettings;
		
		@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/list\")")
		@AndroidFindBy(className = "android.widget.TextView")
		public List<WebElement> settingTitles;
		
		public WebElement servicesSettingsTitle;
		public WebElement systemSettingsTitle;
		
		//method / Action to click on device's back button
		public void back()
		{
			driver.navigate().back();
		}
		
		// get current setting for a particular item using its setting title
		public String getCurrentSettingFor(String settingTitle)
		{
			System.out.println("Setting Title queried :"+settingTitle);
			// loop through the list of all settings webelements to find the element whose text matches to the setting title
			// and return the elements summary value.
			for (WebElement elem : allSettings) {
				if(elem.findElement(By.id("android:id/title")).getText().equals(settingTitle))
				{
					String settingValue = elem.findElement(By.id("android:id/summary")).getText();
					System.out.println("Setting Title queried :"+settingTitle   +"setting value found is:" +settingValue);
					return settingValue;
				}
			}
			
			return "";
		}
		
		
}
