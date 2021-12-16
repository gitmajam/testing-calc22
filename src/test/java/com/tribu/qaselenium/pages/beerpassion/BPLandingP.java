package com.tribu.qaselenium.pages.beerpassion;

import org.openqa.selenium.By;

import com.tribu.qaselenium.testframework.pagebase.BasePO;
import com.tribu.qaselenium.testframework.testbase.PropertiesFile;

public class BPLandingP extends BasePO<BPLandingP> {
	private String pageUrl = PropertiesFile.getProperties(PropertiesFile.getProperties("env") + "_bp_url");

	private By loginButton = By
			.xpath("/html//div[@id='root']/div[@class='main-pe']//button[@class='btn login-without btn-secondary']");
	private By title = By
			.xpath("/html//div[@id='root']/div[@class='main-pe']/div[@class='withOut']//h1[@class='big-text fs-6'");
	private By banner = By
			.xpath("/html//div[@id='root']/div[@class='main-pe']//img[@src='/customs/main-pe/without-image.jpg']");
	private By faviconImg = By.xpath("/html/head//link[@id=\"favicon\"]");

	public BPLandingP getBanner() {
		this.locator = banner;
		return this;
	}

	public BPLandingP getFaviconImg() {
		this.locator = faviconImg;
		return this;
	}

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
		pageUrl = url;
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}

}
