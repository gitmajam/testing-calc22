package com.tribu.qaselenium.pages.mazaprendo;

import org.openqa.selenium.By;

import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class MAConfigurationP extends BasePO<MAConfigurationP> {

	private final String pageUrl = "https://api-beerambassador-stage.somosmaz.com/";
	private By performance = By.xpath("//a[@href='/admin/config/development/performance']/span[@class='label']");
	private By clearCache = By.xpath("/html//input[@id='edit-clear']");
	
	public MAConfigurationP getPerformance() {
		this.locator = performance;
		return this;
	}

	public MAConfigurationP getClearCache() {
		this.locator = clearCache;
		return this;
	}



	@Override
	public String getPageUrl() {
		return pageUrl;
	}

}
