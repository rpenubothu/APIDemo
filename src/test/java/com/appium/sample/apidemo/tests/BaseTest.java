package com.appium.sample.apidemo.tests;

import com.appium.sample.apidemo.controller.AppController;
import com.appium.sample.apidemo.controller.TestBase;
import com.appium.sample.apidemo.pages.APIDemosListPage;
import com.appium.sample.apidemo.pages.AccessibilityListViewPage;
import com.appium.sample.apidemo.pages.AccessibilityCustomViewPage;
import com.appium.sample.apidemo.pages.AccessibilitySettingsPage;
import com.appium.sample.apidemo.pages.AccessibilityServicePage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import com.aventstack.extentreports.ExtentTestInterruptedException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.appium.sample.apidemo.tests.ExtentTestNGITestListener;

/**
 * Created by Rajani on 2017-04-15.
 */

@Listeners(ExtentTestNGITestListener.class)
public class BaseTest extends TestBase{
    
	public ExtentReports extent;
	public ExtentTest test;
	public ExtentTestInterruptedException testexception;
		
	
	protected APIDemosListPage apiDemosHome;	
    protected AccessibilityListViewPage listviewPage;
    protected AccessibilityCustomViewPage customviewPage;
    protected AccessibilitySettingsPage settingsPage;
    protected AccessibilityServicePage servicePage;

 
    @BeforeClass
    public void setUp() throws Exception {
        AppController.instance.start();
        switch (AppController.executionOS) {
            case ANDROID:
            	apiDemosHome = new APIDemosListPage(driver());
            	listviewPage = new AccessibilityListViewPage(driver());
            	customviewPage = new AccessibilityCustomViewPage(driver());
            	servicePage = new AccessibilityServicePage(driver());
            	settingsPage = new AccessibilitySettingsPage(driver());
            	
                break;
            case IOS:
               // create page objects for ios app here.
                break;
        }
    }

    @AfterClass
    public void tearDown() {
        AppController.instance.stop();
    }
    
 
}
