package com.appium.sample.apidemo.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Rajani on 2017-04-15.
 */
public class AccessibilityCustomViewPage {
	
	private WebDriver driver;
	
	public AccessibilityCustomViewPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	
	// Title element whose text is : Accessibility/CustomView
		@AndroidFindBy(className = "android.widget.TextView")
		public WebElement pageTitle;
		
		@AndroidFindBy(className = "android.view.View")
		public List<WebElement> radioButtons;   // this has 2 radio buttons 
		
		
		//method / Action to click on device's back button
		public void back()
		{
			driver.navigate().back();
		}
		
		
}
