package com.tribu.qaselenium.pages.mazaprendo;

import org.openqa.selenium.By;

import com.tribu.qaselenium.testframework.pagebase.BasePO;
import com.tribu.qaselenium.testframework.testbase.PropertiesFile;

public class MALandingP extends BasePO<MALandingP> {

	private final String pageUrl = PropertiesFile.getProperties(PropertiesFile.getProperties("env") + "_ma_url");
	private By loginButton = By.xpath("/html//input[@id='edit-openid-connect-client-generic-login']");
	
	public MALandingP getLoginButton() {
		this.locator = loginButton;
		return this;
	}

	@Override
	public String getPageUrl() {
		// TODO Auto-generated method stub
		return pageUrl;
	}
}
