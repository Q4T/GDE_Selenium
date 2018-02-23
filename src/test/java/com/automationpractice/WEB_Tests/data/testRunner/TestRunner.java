package com.automationpractice.WEB_Tests.data.testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features= "features",glue="com.automationpractice.WEB_Tests",
plugin = {"html:target/cucumber_html_report",
		  "json:target/cucumber.json" ,
          "junit:target/cucumber.xml"},
		   monochrome = true)

public class TestRunner {

	public TestRunner() {
		
	}	
}


//classpath:src/test/java/com.automationpractice.WEB_Tests.stepDefinitions/stepDefinitions",