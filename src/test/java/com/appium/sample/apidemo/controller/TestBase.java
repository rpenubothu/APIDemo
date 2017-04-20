package com.appium.sample.apidemo.controller;

import io.appium.java_client.AppiumDriver;
import com.appium.sample.apidemo.controller.ExtentReportingController;
import com.aventstack.extentreports.ExtentReports;


/**
 * Created by Rajani on 2017-04-15.
 */
public abstract class TestBase {

    protected AppiumDriver driver() {
        return AppController.instance.driver;
    }
    
    protected ExtentReports extent(){
    	return ExtentReportingController.instance.extent;
    }
}