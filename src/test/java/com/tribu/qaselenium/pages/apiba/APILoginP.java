package com.tribu.qaselenium.pages.apiba;

import org.openqa.selenium.By;

import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class APILoginP extends BasePO<APILoginP> {

	private String pageUrl = "https://api-beerambassador-stage.somosmaz.com/user/login";
	private By sharpIdField = By.xpath("//input[@id='edit-name']");
	private By passwordField = By.xpath("//input[@id='edit-pass']");
	private By errorLoginMessage = By.xpath("//div/h2[contains(text(),'Mensaje de error')]");
	private By loginButton = By.xpath("//input[@id='edit-submit']");

	public APILoginP getSharpIdField() {
		this.locator = sharpIdField;
		return this;
	}

	public APILoginP getPasswordField() {
		this.locator = passwordField;
		return this;
	}

	public APILoginP getErrorLoginMessage() {
		this.locator = errorLoginMessage;
		return this;
	}

	public APILoginP getLoginButton() {

		this.locator = loginButton;
		return this;
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}

}
