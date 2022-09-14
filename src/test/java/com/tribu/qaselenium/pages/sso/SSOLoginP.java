package com.tribu.qaselenium.pages.sso;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Predicate;
import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class SSOLoginP extends BasePO<SSOLoginP> {
	
	private By sharpIdField = By.xpath("//input[@id='sharp_id']");
	private By passwordField = By.xpath("//input[@id='opass']");
	private By loginButton = By.xpath("//button[@id='btn-login']");
	private By errorLoginMessage = By.xpath("//span[@class='text-center']");

	public SSOLoginP getSharpIdField(Predicate<WebElement>... predicates){
	this.setWebElement(sharpIdField,predicates);
	return this;
	}

	public SSOLoginP getPasswordField(Predicate<WebElement>... predicates){
	this.setWebElement(passwordField,predicates);
	return this;
	}

	public SSOLoginP getLoginButton(Predicate<WebElement>... predicates){
	this.setWebElement(loginButton,predicates);
	return this;
	}

	public SSOLoginP getErrorLoginMessage(Predicate<WebElement>... predicates){
	this.setWebElement(errorLoginMessage,predicates);
	return this;
	}

	@Override
	public String getPageUrl() {
		// TODO Auto-generated method stub
		return null;
	}

}
