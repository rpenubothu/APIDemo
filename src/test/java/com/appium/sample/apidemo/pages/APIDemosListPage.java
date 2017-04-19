package com.appium.sample.apidemo.pages;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**

 */
public class APIDemosListPage {
	/**
	 * Page Object best practice is to describe interactions with target 
	 * elements by methods. This methods describe business logic of the page/screen.
	 * Here lazy instantiated elements are public.
	 * It was done so just for obviousness
	 */
	
	private WebDriver driver;
	/*
	public APIDemosListPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
	*/
	public APIDemosListPage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
	}
    

	// Title element whose text is : API Demos
	@AndroidFindBy(className = "android.widget.TextView")
	public WebElement title;
	
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/list\")")
    //the searching starts here
    @AndroidFindBy(className = "android.widget.TextView") //this element is nested
    //and so on
    public List<WebElement> list;
	
	
	//action method to allow user click on listitem based on its index.
	//public AccessibilityListViewPage clickListItemAtIndex(int index_value)
	public void clickListItemAtIndex(int index_value)
	{
		System.out.println("element trying to be clicked is:" +list.get(index_value).getText());
		list.get(index_value).click();
		//return new AccessibilityListViewPage(driver);
	}

	
}