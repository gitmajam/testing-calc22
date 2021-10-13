package com.atc.seleniumframework.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.atc.seleniumframework.utilities.GeneralUtils;

public class LoginSharpIdPage extends BasePageObject {

	private By sharpIdField = By.xpath("//input[@id='sharp_id']");
	
	private By passwordField = By.xpath("//input[@id='opass']");
	
	private By loginButton = By.xpath("//button[@id='btn-login']");
	
	private By errorLoginMessage= By.xpath("//span[@class='text-center']");


	public LoginSharpIdPage(Logger log) {
		super(log);
	}

	public SimplificaHomePage login(WebDriver driver, String sharpId, String password) {
		log.info(driver.hashCode() + " Executing login with sharpID [" + sharpId + "] and password [" + password + "]");
		type(driver,sharpId, sharpIdField);
		type(driver,password, passwordField);
		click(driver,loginButton);
		GeneralUtils.waitForPageToLoad(driver, log);
		return new SimplificaHomePage(driver, log);
	}

	public void negativelogin(WebDriver driver,String sharpId, String password) {
		log.info(driver.hashCode() + " Executing negative login with sharpID [" + sharpId + "] and password [" + password
				+ "]");
		type(driver,sharpId, sharpIdField);
		type(driver,password, passwordField);
		click(driver,loginButton);
	}

	public void waitForErrorMessage(WebDriver driver) {
		GeneralUtils.waitForVisibilityOf(errorLoginMessage, 5, driver);
	}

	public String getErrorMessageText(WebDriver driver) {
		return driver.findElement(errorLoginMessage).getText();
	}

}
