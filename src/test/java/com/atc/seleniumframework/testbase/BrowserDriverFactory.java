package com.atc.seleniumframework.testbase;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriverFactory {

	/**
	 * static variable that relates an specific webdriver instance with a thread, it
	 * is like a dictionary
	 */
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public void createDriver(String browser, Logger log) {
		browser.toLowerCase();

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
			driver.set(new ChromeDriver());
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
			driver.set(new FirefoxDriver());
			break;

		default:
			System.out.println("Do not know how to start: " + browser + ", starting chrome.");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
			driver.set(new ChromeDriver());
			break;
		}
		// Create driver
		log.info(driver.get().hashCode() + " Factory crea driver: ");
	}

	/** this method returns the driver related with the current thread */
	public WebDriver getDriver() {
		return driver.get();
	}
}
