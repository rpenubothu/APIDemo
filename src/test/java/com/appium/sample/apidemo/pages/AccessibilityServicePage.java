package com.appium.sample.apidemo.pages;

	import io.appium.java_client.pagefactory.AndroidFindBy;
	import io.appium.java_client.pagefactory.AppiumFieldDecorator;

	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.PageFactory;


	public class AccessibilityServicePage {
		
		private WebDriver driver;
		
		public AccessibilityServicePage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
		}
		
	
			@AndroidFindBy(className = "android.widget.TextView")
			public WebElement detailText;
			
			@AndroidFindBy(className = "android.widget.ImageButton")
			public WebElement settingsButton;  // click on this takes user to Accessibility Settings page
			
			
			
			public void clickSettingsButton()
			{
				System.out.println("settings image button will be clicked");
				settingsButton.click();
			}
			
			//method / Action to click on device's back button
			public void back()
			{
				driver.navigate().back();
			}
			
			
	}
