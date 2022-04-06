package com.tribu.qaselenium.pages.sso;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Predicate;
import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class SSOLandingP extends BasePO<SSOLandingP> {
	
	private By sharpIdButton = By.xpath("//button[contains(text(),'NO')]");
	private By emailButton = By.xpath("//button[contains(text(),'SI')]");
	private By abLogo = By.xpath("/html//div[@id='second']//img[@alt='AbInBev']");
	private By videoCloseButton = By.xpath("//div[@id='myVideo']/div[@role='document']//div[@class='modal-footer']/button[@type='button']");

	public SSOLandingP getSharpIdButton(Predicate<WebElement>... predicates){
	this.setWebElement(sharpIdButton,predicates);
	return this;
	}

	public SSOLandingP getEmailButton(Predicate<WebElement>... predicates){
	this.setWebElement(emailButton,predicates);
	return this;
	}

	public SSOLandingP getAbLogo(Predicate<WebElement>... predicates){
	this.setWebElement(abLogo,predicates);
	return this;
	}

	public SSOLandingP getVideoCloseButton(Predicate<WebElement>... predicates){
	this.setWebElement(videoCloseButton,predicates);
	return this;
	}

	@Override
	public String getPageUrl() {
		// TODO Auto-generated method stub
		return null;
	}
}
