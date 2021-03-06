package com.appium.sample.apidemo.pages;

import io.appium.java_client.MobileElement;
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
public class AccessibilityListViewPage {
	
	private WebDriver driver;
	
	public AccessibilityListViewPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}

	/**
	 * Page Object best practice is to describe interactions with target 
	 * elements by methods. This methods describe business logic of the page/screen.
	 * Here lazy instantiated elements are public.
	 * It was done so just for obviousness
	 */
	
	// Title element whose text is : API Demos
	@AndroidFindBy(className = "android.widget.TextView")
	public WebElement pageTitle;
	
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/list\")")
	// List of TextView elements in ListView. Has 4 elements.
	@AndroidFindBy(className = "android.widget.TextView")
	public List<WebElement> accessibilityListItems;
	
	
	public WebElement getItemWithName(String itemText)
	{
		System.out.println("Trying to look up for item to click is :" + itemText);
		for(int i =0; i< accessibilityListItems.size(); i++){
			if(accessibilityListItems.get(i).getText().equals(itemText))
			{
				return accessibilityListItems.get(i);
			}
		}return null;
	}
		
	//method / Action to click on device's back button
	public void back()
	{
		driver.navigate().back();
	}
}