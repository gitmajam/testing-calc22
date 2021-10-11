package com.atc.seleniumframework.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginEmailPage extends BasePageObject {

	private String pageUrl = "https://auth-stage.somosmaz.com";

	public LoginEmailPage(WebDriver driver, Logger log) {
		super(driver, log);
		PageFactory.initElements(driver, this);
		log.info("Welcome page recibe el driver#: " + driver.hashCode());
	}

}
