package com.tribu.qaselenium.pages.mazaprendo;

import org.openqa.selenium.By;

import com.tribu.qaselenium.pages.sso.SSOLandingP;
import com.tribu.qaselenium.pages.sso.SSOLoginP;
import com.tribu.qaselenium.testframework.pagebase.BasePO;
import com.tribu.qaselenium.testframework.testbase.PropertiesFile;

public class MALandingP extends BasePO<MALandingP> {
	SSOLandingP ssoLandingP;
	SSOLoginP ssoLoginP;
	MAHomeP maHomeP;
	private final String pageUrl = PropertiesFile.getProperties(PropertiesFile.getProperties("env") + "_ma_url");
	private By loginButton = By.xpath("/html//input[@id='edit-openid-connect-client-generic-login']");

	public MALandingP getLoginButton() {
		this.locator = loginButton;
		return this;
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}

	public MAHomeP login(String sharpId, String password) {
		log.info("login");
		driver.get().get(getPageUrl());
		ssoLandingP = this.getLoginButton().click(SSOLandingP::new).get();
		ssoLoginP = ssoLandingP.getVideoCloseButton().click(2000)
								.getSharpIdButton().click(SSOLoginP::new).get();
		maHomeP = ssoLoginP.getSharpIdField().type(sharpId)
							.getPasswordField().type(password)
							.getLoginButton().click(MAHomeP::new).get();
		return maHomeP;
	}
}
