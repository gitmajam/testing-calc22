package com.tribu.qaselenium.pages.mazaprendo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Predicate;
import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class MAConfigurationP extends BasePO<MAConfigurationP> {

	private final String pageUrl = "https://api-beerambassador-stage.somosmaz.com/";
	private By configurationButton = By
			.xpath("//nav[@role='navigation']/div[@class='toolbar-menu-administration']/ul//a[contains(@href,'/admin/config')]");
	private By emptyCacheAlert = By.xpath("/html/body//main[@role='main']//div[@role='contentinfo']");
	private By performance = By.xpath("//a[contains(@href,'/admin/config/development/performance')]/span[@class='label']");
	private By clearCache = By.xpath("/html//input[@id='edit-clear']");
	
	public MAConfigurationP getConfigurationButton(Predicate<WebElement>... predicates){
	this.setWebElement(configurationButton,predicates);
	return this;
	}

	public MAConfigurationP getEmptyCacheAlert(Predicate<WebElement>... predicates){
	this.setWebElement(emptyCacheAlert,predicates);
	return this;
	}

	public MAConfigurationP getPerformance(Predicate<WebElement>... predicates){
	this.setWebElement(performance,predicates);
	return this;
	}

	public MAConfigurationP getClearCache(Predicate<WebElement>... predicates){
	this.setWebElement(clearCache,predicates);
	return this;
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}

}
