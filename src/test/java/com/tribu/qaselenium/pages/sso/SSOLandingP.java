package com.tribu.qaselenium.pages.sso;

import org.openqa.selenium.By;

import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class SSOLandingP extends BasePO<SSOLandingP> {

	private By sharpIdButton = By.xpath("//button[contains(text(),'NO')]");
	private By emailButton = By.xpath("//button[contains(text(),'SI')]");
	private By abLogo = By.xpath("/html//div[@id='second']//img[@alt='AbInBev']");

	public SSOLandingP getAbLogo() {
		this.locator = abLogo;
		return this;
	}

	public SSOLandingP getSharpIdButton() {
		this.locator = sharpIdButton;
		return this;
	}

	public SSOLandingP getEmailButton() {
		this.locator = emailButton;
		return this;
	}

	@Override
	public String getPageUrl() {
		// TODO Auto-generated method stub
		return null;
	}
}
