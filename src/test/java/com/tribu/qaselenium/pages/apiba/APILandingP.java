package com.tribu.qaselenium.pages.apiba;

import org.openqa.selenium.By;

import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class APILandingP extends BasePO<APILandingP> {

	private final String pageUrl = "https://api-beerambassador-dev.somosmaz.com/";
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
