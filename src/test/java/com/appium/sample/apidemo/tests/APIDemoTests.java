package com.appium.sample.apidemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

/**
 * Created by Rajani on 2017-04-15.
 */
public class APIDemoTests extends BaseTest {
	
	@Test
	public void testPageTitle() {
		System.out.println("Title of the page is: " +apiDemosHome.title.getText() );
		Assert.assertEquals("API Demos", apiDemosHome.title.getText());
	
	}
	
	@Test
	public void testClickAccessibility()
	{
		extent.createTest("testClickAccessibility");
		apiDemosHome.clickListItemAtIndex(0);
		
		//AccessibilityCustomViewPage customViewPage = listViewPage.tapItemWithName("Custom View");
		listviewPage.getItemWithName("Custom View")
					.click();
		// go back to listview page
		customviewPage.back();
		// go back to demo homepage
		listviewPage.back();
	}
	
	
	@Test
	public void testAccessibilitySettingsValueForTitle()
	{
		apiDemosHome.clickListItemAtIndex(0);
		listviewPage.getItemWithName("Accessibility Service").click();
		servicePage.clickSettingsButton();
		String settingValue = settingsPage.getCurrentSettingFor("Captions");
		String expectedValue = "Off";
		// get the control back to home.
		settingsPage.back();
		servicePage.back();
		listviewPage.back();
		Assert.assertEquals(settingValue, expectedValue);
	}
	
	
	
	@DataProvider
	public Object[][] testDataForAccessibilitySettings()
	{
		return new Object[][]{
			new Object[]{"Captions", "Off"},
			new Object[]{"ClockBack", "On"},
			new Object[]{"Magnification gestures", "Off"}};
	}
	
	@Test(dataProvider ="testDataForAccessibilitySettings")
	public void testAccessibilitySettingsUsingDataProvider(String title, String expected)
	{
		apiDemosHome.clickListItemAtIndex(0);
		listviewPage.getItemWithName("Accessibility Service").click();
		servicePage.clickSettingsButton();
		String settingValue = settingsPage.getCurrentSettingFor(title);
		// get the control back to home.
		settingsPage.back();
		servicePage.back();
		listviewPage.back();
		Assert.assertEquals(settingValue, expected);
	}
	
	
	/*
	 * Need to find a solution to be able to scroll through a list.
	 * 
	 * String uiSelector = "new UiSelector().descriptionContains(\"" + contentDescription + "\")";

		can use: findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
        + uiSelector + ".instance(0));");
	 * 
	 */
	
	
	
	/*
	 * When a test fails, capture the screenshot.
	 * 
	 */
	
	
	/*
	 * Best way to add logging for organized reporting on test results.
	 */
	
	
}
