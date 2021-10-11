package com.atc.seleniumframework.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSOLandingPage extends BasePageObject {

	private String pageUrl = "https://auth-stage.somosmaz.com";

	@FindBy(xpath = "//button[contains(text(),'NO')]")
	private WebElement sharpIdButton;

	@FindBy(xpath = "//button[contains(text(),'SI')]")
	private WebElement emailButton;

	public SSOLandingPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Open Welcome page **/
	public void openPage() {
		openUrl(pageUrl);
		log.info("Welcome abre url con driver#: " + driver.hashCode());
	}

	public LoginSharpIdPage loginBySharId() {
		sharpIdButton.click();
		log.info("Clicking sharpId button driver#: " + driver.hashCode());
		return new LoginSharpIdPage(driver, log);
	}

	public LoginEmailPage loginByEmail() {
		emailButton.click();
		log.info("Clicking email button driver#: " + driver.hashCode());
		return new LoginEmailPage(driver, log);
	}
}
