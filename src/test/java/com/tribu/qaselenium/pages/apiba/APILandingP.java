package com.tribu.qaselenium.pages.apiba;

import org.openqa.selenium.By;

import com.tribu.qaselenium.testframework.pagebase.BasePO;
import com.tribu.qaselenium.testframework.testbase.PropertiesFile;

public class APILandingP extends BasePO<APILandingP> {

	private final String pageUrl = PropertiesFile.getProperties(PropertiesFile.getProperties("env") + "_api_url");
	private By loginButton = By.xpath("//a[@href='/user/login']");
	

	public APILandingP getLoginButton() {
		this.locator = loginButton;
		return this;
	}

	@Override
	public String getPageUrl() {
		// TODO Auto-generated method stub
		return pageUrl;
	}
}
