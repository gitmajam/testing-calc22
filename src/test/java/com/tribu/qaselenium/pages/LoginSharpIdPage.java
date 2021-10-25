package com.tribu.qaselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tribu.qaselenium.testframework.pagebase.BasePageObject;
import com.tribu.qaselenium.testframework.pagebase.GeneralUtils;

public class LoginSharpIdPage extends BasePageObject {

	private String pageUrl = "https://auth-stage.somosmaz.com/es/login";
	private By sharpIdField = By.xpath("//input[@id='sharp_id']");
	private By passwordField = By.xpath("//input[@id='opass']");
	private By loginButton = By.xpath("//button[@id='btn-login']");
	private By errorLoginMessage = By.xpath("//span[@class='text-center']");

	public SimplificaHomePage login(WebDriver driver, String sharpId, String password) {
		log.info(driver.hashCode() + " Executing login with sharpID [" + sharpId + "] and password [" + password + "]");
		type(driver, sharpId, sharpIdField);
		type(driver, password, passwordField);
		click(driver, loginButton);
		return new SimplificaHomePage();
	}

	public void negativelogin(WebDriver driver, String sharpId, String password) {
		log.info(driver.hashCode() + " Executing negative login with sharpID [" + sharpId + "] and password ["
				+ password + "]");
		type(driver, sharpId, sharpIdField);
		type(driver, password, passwordField);
		click(driver, loginButton);
	}

	public void waitForErrorMessage(WebDriver driver) {
		GeneralUtils.waitForVisibilityOf(errorLoginMessage, 5, driver);
	}

	public String getErrorMessageText(WebDriver driver) {
		return driver.findElement(errorLoginMessage).getText();
	}

	public String getPageUrl() {
		return pageUrl;
	}

}
