package com.automationpractice.WEB_Tests.pages;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.automationpractice.WEB_Tests.utilities.DriverFactory;
import com.automationpractice.WEB_Tests.utilities.Utilities;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class PageBase {

	public static WebDriver driver;
	public static Utilities u;

	public static void getDriver() {
		driver = DriverFactory.getDriver();
		}	
	
}