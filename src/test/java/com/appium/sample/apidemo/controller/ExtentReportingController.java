package com.appium.sample.apidemo.controller;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportingController {

public static ExtentReports extent;
public static ExtentReportingController instance = new ExtentReportingController();

public static ExtentReports getInstance() {
	if (extent == null)
		createInstance();
	
    return extent;
}

public static ExtentReports createInstance() {
	String fileName = "test-output/extent.html";
    ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
    htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
    htmlReporter.config().setChartVisibilityOnOpen(true);
    htmlReporter.config().setTheme(Theme.STANDARD);
    htmlReporter.config().setDocumentTitle(fileName);
    htmlReporter.config().setEncoding("utf-8");
    htmlReporter.config().setReportName(fileName);
    
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
    
    return extent;
}

}