package com.tribu.qaselenium.pages.apiba;

import org.openqa.selenium.By;

import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class APIConfigurationP extends BasePO<APIConfigurationP> {

	private final String pageUrl = "https://api-beerambassador-stage.somosmaz.com/";
	private By performance = By.xpath("//a[@href='/admin/config/development/performance']/span[@class='label']");
	private By clearCache = By.xpath("/html//input[@id='edit-clear']");

	@Override
	public String getPageUrl() {
		return pageUrl;
	}

}
