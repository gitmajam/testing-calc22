package com.tribu.qaselenium.pages.sso;

import org.openqa.selenium.By;

import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class SSOLoginP extends BasePO<SSOLoginP> {

	private By sharpIdField = By.xpath("//input[@id='sharp_id']");
	private By passwordField = By.xpath("//input[@id='opass']");
	private By loginButton = By.xpath("//button[@id='btn-login']");
	private By errorLoginMessage = By.xpath("//span[@class='text-center']");

	public SSOLoginP getSharpIdField() {
		this.locator = sharpIdField;
		return this;
	}

	public SSOLoginP getPasswordField() {
		this.locator = passwordField;
		return this;
	}

	public SSOLoginP getLoginButton() {
		this.locator = loginButton;
		return this;
	}

	public SSOLoginP getErrorLoginMessage() {
		this.locator = errorLoginMessage;
		return this;
	}

	@Override
	public String getPageUrl() {
		// TODO Auto-generated method stub
		return null;
	}

}
