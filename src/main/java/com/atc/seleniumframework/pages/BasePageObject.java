package com.atc.seleniumframework.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atc.seleniumframework.utilities.GeneralUtils;

public class BasePageObject {
	
	protected WebDriver driver;
	protected Logger log;

	public BasePageObject(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;
		PageFactory.initElements(driver, this);
	}
	
	/** Open page with given URL **/
	protected void openUrl(String url) {
		driver.get(url);
		GeneralUtils.waitForPageToLoad(driver, log);
	}
	
	// Click on element with given locator when its visible
	protected void click(WebElement element) {
		GeneralUtils.waitForVisibilityOf(element, 5, driver);
		element.click();
	}

	// Type given text into element with given locator
	protected void type(String text, WebElement element) {
		GeneralUtils.waitForVisibilityOf(element, 5, driver);
		element.sendKeys(text);
	}

	// Get URL of current page from browser
	public static String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
}
