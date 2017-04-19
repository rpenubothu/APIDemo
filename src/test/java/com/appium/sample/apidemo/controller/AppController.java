package com.appium.sample.apidemo.controller;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rajani on 2017-04-15.
 */
public class AppController {

    public static OS executionOS = OS.ANDROID;

    public enum OS {
        ANDROID,
        IOS
    }
    public static AppController instance = new AppController();
    public AppiumDriver<MobileElement> driver;

    public void start() throws MalformedURLException {
        if (driver != null) {
            return;
        }
        switch(executionOS){
            case ANDROID:
             	File classpathRoot = new File(System.getProperty("user.dir"));
                File appDir = new File(classpathRoot, "/apps");
         	    File app = new File(appDir, "android-sample-app.apk");
         	    DesiredCapabilities capabilities = new DesiredCapabilities();
         	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
         	    capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
         	    capabilities.setCapability("avd", "Demo");
         	    driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
         	   break;
            	
            case IOS:
                classpathRoot = new File(System.getProperty("user.dir"));
                appDir = new File(classpathRoot, "/app/iOS/");
                app = new File(appDir, "ContactsSimulator.app");
                capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "ios");
                capabilities.setCapability("deviceName", "=iPhone 6s");
                capabilities.setCapability("app", app.getAbsolutePath());
                driver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
                break;
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
