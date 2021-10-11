package com.atc.seleniumframework.testbase;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

	protected WebDriver driver;
	protected Logger log;
	protected BrowserDriverFactory factory;
	protected String testSuiteName;
	protected String testName;
	protected String testMethodName;

	@BeforeTest(alwaysRun = true)
	public void createBrowserFactory() {
		factory = new BrowserDriverFactory();
	}

	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method, @Optional("chrome") String browser, ITestContext ctx) {
		String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);
		factory.createDriver(browser, log);
		factory.getDriver().manage().window().maximize();
		
		this.testSuiteName = ctx.getSuite().getName();
		this.testName = testName;
		this.testMethodName = method.getName();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		log.info("Close driver" + "drive: " + factory.getDriver().hashCode());
		// Close browser
		factory.getDriver().quit();
	}
}
