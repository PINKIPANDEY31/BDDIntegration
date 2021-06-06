package com.web.automation.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;
import com.web.automation.base.DriverInstance;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "FeatureFile", monochrome = true, dryRun = false, glue = "com.web.automation.steps", plugin = {
		"html:target/cucumber-reports", "json:target/cucumber-reports/Cucumber.json",
		"junit:target/cucumber-reports/Cucumber.xml", "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:" })

public class TestRunner {

	@BeforeClass
	public static void setReportConfiguration() {
		ExtentProperties property = ExtentProperties.INSTANCE;
		property.setReportPath("./Reports/Reports.html");

	}

	@AfterClass
	public static void setConfiguration() {
		DriverInstance.closeDriverInstance();
		Reporter.loadXMLConfig("./ConfigFiles/extent-config.xml");
	}
	
}
