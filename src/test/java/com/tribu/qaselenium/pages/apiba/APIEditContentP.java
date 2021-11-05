package com.tribu.qaselenium.pages.apiba;

import org.openqa.selenium.By;

import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class APIEditContentP extends BasePO<APIEditContentP> {
	protected APIEditContentP este = this;

	private final String pageUrl = "https://api-beerambassador-stage.somosmaz.com/";
	private By mesage1 = By.tagName("//div[@role='contentinfo']//a[@href='/node/169']");
	private By mesage2 = By.xpath("//aside[@role='complementary']//div[@role='contentinfo']");
	private By menuContentButton = By.xpath("//li/a[@href='/admin/content']");

	public APIEditContentP getMenuContentButton() {
		this.locator = menuContentButton;
		return this;
	}

	public APIEditContentP getMesage2() {
		this.locator = mesage2;
		return this;
	}

	public APIEditContentP getMesage1() {
		this.locator = mesage1;
		return this;
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}
}
