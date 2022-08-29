package com.tribu.qaselenium.pages.b22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Predicate;
import com.tribu.qaselenium.testframework.pagebase.BasePO;
import com.tribu.qaselenium.testframework.testbase.PropertiesFile;

public class B22OthersP extends BasePO<B22OthersP> {

	private final String pageUrl = PropertiesFile.getProperties(PropertiesFile.getProperties("env") + "_url");

	private By button = By.xpath("//button");
	private By appBusy = By.xpath("/html[@class='nprogress-busy']");
	private By newInitiative = By.id("create-others-initiative-button");
	private By code = By.xpath("//input[@name='code']");
	private By title = By.xpath("//input[@name='title']");
	private By ownerName = By.xpath("//input[@name='ownerName']");
	private By description = By.id("description");
	private By bu = By.id("bu");
	private By country = By.id("country");
	private By status = By.id("status");
	private By risk = By.id("risk");
	private By startDate = By.xpath("//input[@name='startDate']");
	private By duration = By.xpath("//input[@name='duration']");
	private By initiativeType = By.id("type");
	private By anualized = By.xpath("//input[@name='anualized']");
	private By calendarized = By.xpath("//input[@name='calendarized']");
	private By jan = By.xpath("//input[@name='jan']");
	private By feb = By.xpath("//input[@name='feb']");
	private By mar = By.xpath("//input[@name='mar']");
	private By apr = By.xpath("//input[@name='apr']");
	private By may = By.xpath("//input[@name='may']");
	private By jun = By.xpath("//input[@name='jun']");
	private By jul = By.xpath("//input[@name='jul']");
	private By aug = By.xpath("//input[@name='aug']");
	private By sep = By.xpath("//input[@name='sep']");
	private By oct = By.xpath("//input[@name='oct']");
	private By nov = By.xpath("//input[@name='nov']");
	private By dec = By.xpath("//input[@name='dec']");
	private By modal = By.xpath("//div[@class='modal-content']");
	private By modalAcceptMessage = By
			.xpath("//div[@id='registerOthersInitiativeModal']//div[@class='modal-content']/div[2]");
	private By modalAcceptButton = By
			.xpath("//div[@id='registerOthersInitiativeModal']//div[@class='modal-content']/div[3]/button");

	public B22OthersP getModalAcceptButton(Predicate<WebElement>... predicates) {
		this.setWebElement(modalAcceptButton, predicates);
		return this;
	}

	private By saveButton = By.xpath("//div[@id='createOthersInitiativeModal']//button[2]");

	public B22OthersP getSaveButton(Predicate<WebElement>... predicates) {
		this.setWebElement(saveButton, predicates);
		return this;
	}

	public B22OthersP getModal(Predicate<WebElement>... predicates) {
		this.setWebElement(modal, predicates);
		return this;
	}

	public B22OthersP getModalAcceptMessage(Predicate<WebElement>... predicates) {
		this.setWebElement(modalAcceptMessage, predicates);
		return this;
	}

	public B22OthersP getSep(Predicate<WebElement>... predicates) {
		this.setWebElement(sep, predicates);
		return this;
	}

	public B22OthersP getCalendarized(Predicate<WebElement>... predicates) {
		this.setWebElement(calendarized, predicates);
		return this;
	}

	public B22OthersP getCode(Predicate<WebElement>... predicates) {
		this.setWebElement(code, predicates);
		return this;
	}

	public B22OthersP getTitle(Predicate<WebElement>... predicates) {
		this.setWebElement(title, predicates);
		return this;
	}

	public B22OthersP getOwnerName(Predicate<WebElement>... predicates) {
		this.setWebElement(ownerName, predicates);
		return this;
	}

	public B22OthersP getDescription(Predicate<WebElement>... predicates) {
		this.setWebElement(description, predicates);
		return this;
	}

	public B22OthersP getBu(Predicate<WebElement>... predicates) {
		this.setWebElement(bu, predicates);
		return this;
	}

	public B22OthersP getCountry(Predicate<WebElement>... predicates) {
		this.setWebElement(country, predicates);
		return this;
	}

	public B22OthersP getStatus(Predicate<WebElement>... predicates) {
		this.setWebElement(status, predicates);
		return this;
	}

	public B22OthersP getRisk(Predicate<WebElement>... predicates) {
		this.setWebElement(risk, predicates);
		return this;
	}

	public B22OthersP getStartDate(Predicate<WebElement>... predicates) {
		this.setWebElement(startDate, predicates);
		return this;
	}

	public B22OthersP getDuration(Predicate<WebElement>... predicates) {
		this.setWebElement(duration, predicates);
		return this;
	}

	public B22OthersP getInitiativeType(Predicate<WebElement>... predicates) {
		this.setWebElement(initiativeType, predicates);
		return this;
	}

	public B22OthersP getAnualized(Predicate<WebElement>... predicates) {
		this.setWebElement(anualized, predicates);
		return this;
	}

	public B22OthersP getJan(Predicate<WebElement>... predicates) {
		this.setWebElement(jan, predicates);
		return this;
	}

	public B22OthersP getFeb(Predicate<WebElement>... predicates) {
		this.setWebElement(feb, predicates);
		return this;
	}

	public B22OthersP getMar(Predicate<WebElement>... predicates) {
		this.setWebElement(mar, predicates);
		return this;
	}

	public B22OthersP getApr(Predicate<WebElement>... predicates) {
		this.setWebElement(apr, predicates);
		return this;
	}

	public B22OthersP getMay(Predicate<WebElement>... predicates) {
		this.setWebElement(may, predicates);
		return this;
	}

	public B22OthersP getJun(Predicate<WebElement>... predicates) {
		this.setWebElement(jun, predicates);
		return this;
	}

	public B22OthersP getJul(Predicate<WebElement>... predicates) {
		this.setWebElement(jul, predicates);
		return this;
	}

	public B22OthersP getAug(Predicate<WebElement>... predicates) {
		this.setWebElement(aug, predicates);
		return this;
	}

	public B22OthersP getOct(Predicate<WebElement>... predicates) {
		this.setWebElement(oct, predicates);
		return this;
	}

	public B22OthersP getNov(Predicate<WebElement>... predicates) {
		this.setWebElement(nov, predicates);
		return this;
	}

	public B22OthersP getDec(Predicate<WebElement>... predicates) {
		this.setWebElement(dec, predicates);
		return this;
	}

	public B22OthersP getNewInitiative(Predicate<WebElement>... predicates) {
		this.setWebElement(newInitiative, predicates);
		return this;
	}

	public B22OthersP getButton(Predicate<WebElement>... predicates) {
		this.setWebElement(button, predicates);
		return this;
	}

	public B22OthersP getAppBusy(Predicate<WebElement>... predicates) {
		this.setWebElement(appBusy, predicates);
		return this;
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}
}
