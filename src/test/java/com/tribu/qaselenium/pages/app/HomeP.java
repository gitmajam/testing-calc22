package com.tribu.qaselenium.pages.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Predicate;
import com.tribu.qaselenium.testframework.pagebase.BasePO;
import com.tribu.qaselenium.testframework.testbase.PropertiesFile;

public class HomeP extends BasePO<HomeP> {
	
	@SuppressWarnings("unchecked")
	public HomeP() {
		this.getModal().ifFoundOrElse(()-> this.getModalNoButton().click(), null)
		.getLogo().assertExist("main logo is not displayed");
		this.setLanguage();
	}
	
	private String pageUrl = "https://b22-stage.somosmaz.com/";
	private By logo = By.xpath("//img[contains(@src,'logo-b22')]");
	private By targets = By.linkText("Targets");
	private By dashboards = By.linkText("Dashboards");
	private By reports = By.linkText("Reports");
	private By unmapped = By.linkText("Unmapped");
	private By others = By.linkText("Others");
	private By appBusy = By.xpath("/html[@class='nprogress-busy']");
	private By translateButton = By.xpath("//div[@class='dropdown language']");
	private By englishButton = By.linkText("English");
	private By modal = By.xpath("//div[@class='modal-nps']");
	private By modalNoButton = By.xpath("//button[contains(@class,'btn-nps-no')]");
	
	public HomeP getOthers(Predicate<WebElement>... predicates) {
		this.setWebElement(others, predicates);
		return this;
	}

	public HomeP getReports(Predicate<WebElement>... predicates){
	this.setWebElement(reports,predicates);
	return this;}
	
	public HomeP getModalNoButton(Predicate<WebElement>... predicates) {
		this.setWebElement(modalNoButton, predicates);
		return this;
	}
	
	public HomeP getModal(Predicate<WebElement>... predicates) {
		this.setWebElement(modal, predicates);
		return this;
	}

	public HomeP getEnglishButton(Predicate<WebElement>... predicates) {
		this.setWebElement(englishButton, predicates);
		return this;
	}

	public HomeP getTranslateButton(Predicate<WebElement>... predicates) {
		this.setWebElement(translateButton, predicates);
		return this;
	}

	public HomeP getUnmapped(Predicate<WebElement>... predicates) {
		this.setWebElement(unmapped, predicates);
		return this;
	}

	public HomeP getAppBusy(Predicate<WebElement>... predicates) {
		this.setWebElement(appBusy, predicates);
		return this;
	}

	public HomeP getDashboards(Predicate<WebElement>... predicates) {
		this.setWebElement(dashboards, predicates);
		return this;
	}

	public HomeP getTargets(Predicate<WebElement>... predicates) {
		this.setWebElement(targets, predicates);
		return this;
	}

	public HomeP getLogo(Predicate<WebElement>... predicates) {
		this.setWebElement(logo, predicates);
		return this;
	}

	@SuppressWarnings("unchecked")
	public HomeP setLanguage() {
		if (PropertiesFile.getProperties("language").contentEquals("en")) {
			this.getAppBusy().waitForNotPresence().getTranslateButton().click()
				.getEnglishButton().click();
		}
		return this;
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}
}
