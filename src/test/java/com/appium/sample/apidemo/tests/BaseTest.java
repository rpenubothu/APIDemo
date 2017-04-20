package com.appium.sample.apidemo.tests;

import com.appium.sample.apidemo.controller.AppController;
import com.appium.sample.apidemo.controller.ExtentReportingController;
import com.appium.sample.apidemo.controller.TestBase;
import com.appium.sample.apidemo.pages.APIDemosListPage;
import com.appium.sample.apidemo.pages.AccessibilityListViewPage;
import com.appium.sample.apidemo.pages.AccessibilityCustomViewPage;
import com.appium.sample.apidemo.pages.AccessibilitySettingsPage;
import com.appium.sample.apidemo.pages.AccessibilityServicePage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


import com.aventstack.extentreports.ExtentTestInterruptedException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * Created by Rajani on 2017-04-15.
 */
public class BaseTest extends TestBase{
    
	public ExtentReports extent;
	public ExtentTest test;
	public ExtentTestInterruptedException testexception;
		
	
	protected APIDemosListPage apiDemosHome;	
    protected AccessibilityListViewPage listviewPage;
    protected AccessibilityCustomViewPage customviewPage;
    protected AccessibilitySettingsPage settingsPage;
    protected AccessibilityServicePage servicePage;

    @BeforeSuite
	public void BeforeSuite(){
		ExtentReportingController.instance.createInstance();
	}
    
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
    
    @AfterSuite
	public void AfterSuite(){
		extent.flush();
	}

}
