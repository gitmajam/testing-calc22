package com.tribu.qaselenium.pages.mazaprendo;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Predicate;
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

	public MALandingP getLoginButton(Predicate<WebElement>... predicates) {
		this.setWebElement(loginButton, predicates);
		return this;
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}

	@SuppressWarnings("unchecked")
	public MAHomeP login(Map<String, String> credentialMap) {
		log.info("login");

		driverFunc.get().get(getPageUrl());
		ssoLandingP = this.getLoginButton().click(SSOLandingP::new, 2000).get();
		ssoLoginP = ssoLandingP.getVideoCloseButton().click().getSharpIdButton().click(SSOLoginP::new).get();
		maHomeP = ssoLoginP.getSharpIdField().type(credentialMap.get("sharpId")).getPasswordField()
				.type(credentialMap.get("password")).getLoginButton().click(MAHomeP::new).get();
		return maHomeP;
	}
}
