package com.tribu.qaselenium.pages.beerpassion;

import org.openqa.selenium.By;

import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class BPLandingP extends BasePO<BPLandingP> {
	private String pageUrl = "https://beerpassionperu-stage.somosmaz.com/";
	private By loginButton = By.xpath("/html//div[@id='root']/div[@class='main-pe']//button[@class='btn login-without btn-secondary']");
	private By title = By.xpath("/html//div[@id='root']/div[@class='main-pe']/div[@class='withOut']//h1[@class='big-text fs-6'");


	public BPLandingP getLoginButton() {
		this.locator = loginButton;
		return this;
	}
	

	public BPLandingP getTitle() {
		this.locator = title;
		return this;
	}
	
	// change environment from dataprovider
	public void setPageUrl(String url) {
		pageUrl =  url;
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}


}
