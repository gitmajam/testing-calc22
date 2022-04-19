package com.tribu.qaselenium.pages.b22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Predicate;
import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class B22HomeP extends BasePO<B22HomeP> {
	private String pageUrl = "https://b22-stage.somosmaz.com/";
	private By logo = By.xpath("//img[contains(@src,'logo-b22')]");
	private By targets = By.linkText("Targets");

	public B22HomeP getTargets(Predicate<WebElement>... predicates) {
		this.setWebElement(targets, predicates);
		return this;
	}

	public B22HomeP getLogo(Predicate<WebElement>... predicates) {
		this.setWebElement(logo, predicates);
		return this;
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}
}
