package com.tribu.seleniumframework.testbase;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserDriverFactory {
	
	public static ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type");
		options.addArguments("disable-infobars");// disabling infobars
		//options.addArguments("--disable-gpu");// applicable to windows os only
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-extensions"); // disabling extensions
		options.addArguments("start-maximised");// open Browser in maximized mode
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		options.addArguments("--no-sandbox");// Bypass OS security model
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		options.setCapability(ChromeOptions.CAPABILITY, options);
		return options;
	}

	/**
	 * static variable that relates an specific webdriver instance with a thread, it
	 * is like a dictionary
	 */
	//private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	static WebDriver driver;
	public void createDriver(String browser, Logger log) {
		browser.toLowerCase();

		switch (browser) {
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
			//driver.set(new ChromeDriver());
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(getChromeOptions());
			break;

		case "firefox":
			//System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
			//driver.set(new FirefoxDriver());
			WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();
			break;

		default:
			System.out.println("Do not know how to start: " + browser + ", starting chrome.");
			//System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
			//driver.set(new ChromeDriver());
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		}
		// Create driver
		//log.info(driver.get().hashCode() + " Factory crea driver: ");
		log.info(" Factory crea driver: ");
	}

	/** this method returns the driver related with the current thread */
	public WebDriver getDriver() {
		return driver;
	}
}
