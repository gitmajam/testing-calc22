package com.tribu.qaselenium.pages.b22;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Predicate;
import com.tribu.qaselenium.pages.sso.SSOLandingP;
import com.tribu.qaselenium.pages.sso.SSOLoginP;
import com.tribu.qaselenium.testframework.pagebase.BasePO;
import com.tribu.qaselenium.testframework.testbase.PropertiesFile;

public class B22LandingP extends BasePO<B22LandingP> {
	SSOLandingP ssoLandingP;
	SSOLoginP ssoLoginP;
	B22HomeP b22HomeP;
	private final String pageUrl = PropertiesFile.getProperties(PropertiesFile.getProperties("env") + "_url");
	private By loginButton = By.linkText("Log-in");

	public B22LandingP getLoginButton(Predicate<WebElement>... predicates) {
		this.setWebElement(loginButton, predicates);
		return this;
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}

	@SuppressWarnings("unchecked")
	public B22HomeP login(Map<String, String> credentialMap) {
		log.info("login");
		
		ssoLandingP = this.getLoginButton().click(SSOLandingP::new,2000).get();	
		ssoLoginP = ssoLandingP.getVideoCloseButton().click()
								.getSharpIdButton().click(SSOLoginP::new).get();
		
		b22HomeP = ssoLoginP.getSharpIdField().type(credentialMap.get("sharpId"))
							.getPasswordField().type(credentialMap.get("password"))
							.getLoginButton().click(B22HomeP::new).get();
		
		return b22HomeP;
	}
}
