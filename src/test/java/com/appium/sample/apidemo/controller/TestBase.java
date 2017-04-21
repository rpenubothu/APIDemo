package com.appium.sample.apidemo.controller;

import io.appium.java_client.AppiumDriver;

/**
 * Created by Rajani on 2017-04-15.
 */
public abstract class TestBase {

    public AppiumDriver driver() {
        return AppController.instance.driver;
    }
  
}