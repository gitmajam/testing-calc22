package com.atc.seleniumframework.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SSOLandingPage extends BasePageObject {

	private String pageUrl = "https://auth-stage.somosmaz.com";
	private By sharpIdButton = By.xpath("//button[contains(text(),'NO')]");
	private By emailButton = By.xpath("//button[contains(text(),'SI')]");

	public SSOLandingPage(Logger log) {
		super(log);
	}

	/** Open Welcome page **/
	public void openPage(WebDriver driver) {
		openUrl(driver, pageUrl);
		log.info(driver.hashCode() + " Driver despues de abrir la URL");
	}

	public LoginSharpIdPage loginBySharId(WebDriver driver) {
		log.info(driver.hashCode() + " Clicking sharpId button");
		click(driver, sharpIdButton);
		return new LoginSharpIdPage(log);
	}

	public LoginEmailPage loginByEmail(WebDriver driver) {
		click(driver, emailButton);
		log.info(driver.hashCode() + " Clicking email button");
		return new LoginEmailPage(driver, log);
	}
}
