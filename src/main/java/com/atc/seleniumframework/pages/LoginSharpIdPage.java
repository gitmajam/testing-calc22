package com.atc.seleniumframework.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.atc.seleniumframework.utilities.GeneralUtils;

public class LoginSharpIdPage extends BasePageObject {

	@FindBy(xpath = "//input[@id='sharp_id']")
	private WebElement sharpIdField;

	@FindBy(xpath = "//input[@id='opass']")
	private WebElement passwordField;

	@FindBy(xpath = "//button[@id='btn-login']")
	private WebElement loginButton;

	@FindBy(xpath = "//span[@class='text-center']")
	private WebElement errorLoginMessage;

	public LoginSharpIdPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public SimplificaHomePage login(String sharpId, String password) {
		log.info("Executing login with sharpID [" + sharpId + "] and password [" + password + "]" + "drive: "
				+ driver.hashCode());
		this.type(sharpId, sharpIdField);
		this.type(password, passwordField);
		this.click(loginButton);
		GeneralUtils.waitForPageToLoad(driver, log);
		return new SimplificaHomePage(driver, log);
	}

	public void negativelogin(String sharpId, String password) {
		log.info("Executing negative login with sharpID [" + sharpId + "] and password [" + password + "]" + "drive: "
				+ driver.hashCode());
		this.type(sharpId, sharpIdField);
		this.type(password, passwordField);
		this.click(loginButton);
	}

	public void waitForErrorMessage() {
		GeneralUtils.waitForVisibilityOf(errorLoginMessage, 5, driver);
	}

	public String getErrorMessageText() {
		return errorLoginMessage.getText();
	}

}
