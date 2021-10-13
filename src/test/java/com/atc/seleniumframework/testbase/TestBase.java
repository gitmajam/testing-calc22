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

public class TestBase extends TestUtilities{

	protected Logger log;
	protected BrowserDriverFactory factory;


	@BeforeTest(alwaysRun = true)
	
	/** create a Browser driver factory it lets run several test in parallel*/
	public void createBrowserFactory(ITestContext ctx) {
		
		/* this lines create a new instance of a logger to write out the status during the script execution */
		this.testName = ctx.getCurrentXmlTest().getName();
		this.testSuiteName = ctx.getSuite().getName();
		log = LogManager.getLogger(testName);
		
		log.info("Se crea factory");
		factory = new BrowserDriverFactory();
	}

	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method, @Optional("chrome") String browser) {
		/* this variable isn't used */
		this.testMethodName = method.getName();
		
		log.info("Se ejecuta setup() ");
		
		/* factory creates a new instance of webdriver "browser" */
		factory.createDriver(browser, log);
		factory.getDriver().manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		// Close browser
		factory.getDriver().quit();
	}
}
