package com.appium.sample.apidemo.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

/**
 * Created by Rajani on 2017-04-15.
 */
public class APIDemoTests extends BaseTest {
	
	@Test
	public void testPageTitle() {
		Reporter.log("Title of the page is: " +apiDemosHome.title.getText() );
		Assert.assertEquals("API Demos", apiDemosHome.title.getText());
	}
	
	@Test
	public void testClickAccessibility()
	{
		Reporter.log("Tapping on first item in the list");
		apiDemosHome.clickListItemAtIndex(0);	
		Reporter.log("Tapping Custom View");
		//AccessibilityCustomViewPage customViewPage = listViewPage.tapItemWithName("Custom View");
		listviewPage.getItemWithName("Custom View")
					.click();
		// go back to listview page
		Reporter.log("Tapping on back from custom view page to return back");
		customviewPage.back();
		// go back to demo homepage
		Reporter.log("Tapping on back from listview page to return back to main listing page");
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
	
	
}
