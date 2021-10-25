package com.tribu.qaselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tribu.qaselenium.testframework.pagebase.BasePageObject;

public class SSOLandingPage extends BasePageObject {

	private String pageUrl = "https://auth-stage.somosmaz.com";
	private By sharpIdButton = By.xpath("//button[contains(text(),'NO')]");
	private By emailButton = By.xpath("//button[contains(text(),'SI')]");

	public String getPageUrl() {
		return pageUrl;
	}

	public LoginSharpIdPage loginBySharId(WebDriver driver) {
		log.info(driver.hashCode() + " Clicking sharpId button");
		click(driver, sharpIdButton);
		return new LoginSharpIdPage();
	}

	public LoginEmailPage loginByEmail(WebDriver driver) {
		click(driver, emailButton);
		log.info(driver.hashCode() + " Clicking email button");
		return new LoginEmailPage();
	}
}
