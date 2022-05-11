package com.tribu.qaselenium.pages.b22;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Predicate;
import com.tribu.qaselenium.testframework.pagebase.BasePO;
import com.tribu.qaselenium.testframework.testbase.PropertiesFile;

public class B22UnmappedP extends BasePO<B22UnmappedP> {

	private final String pageUrl = PropertiesFile.getProperties(PropertiesFile.getProperties("env") + "_url");
	private By appBusy = By.xpath("/html[@class='nprogress-busy']");
	private By unmappedTable = By.xpath("//table[@class='table table-unmapped']");
	private By buItem = By.xpath(".//tbody");
	private By button = By.xpath(".//button");
	private By funcItem = By.xpath(".//table//tr");
	private By funcUnmapped = By.xpath(".//td/div/span[@class='high-info']");
	private By inputUnmapped = By.xpath(".//td[12]/input");
	private By modal = By.xpath("//div[@class='modal-content']");
	private By saveButton = By.xpath("//button[@data-bs-placement='top']");
	
	public B22UnmappedP getModal(Predicate<WebElement>... predicates) {
		this.setWebElement(modal, predicates);
		return this;
	}

	public B22UnmappedP getSaveButton(Predicate<WebElement>... predicates) {
		this.setWebElement(saveButton, predicates);
		return this;
	}

	public B22UnmappedP getFuncItem(Predicate<WebElement>... predicates) {
		this.setWebElement(funcItem, predicates);
		return this;
	}

	public B22UnmappedP getButton(Predicate<WebElement>... predicates) {
		this.setWebElement(button, predicates);
		return this;
	}

	public B22UnmappedP getBuItem(Predicate<WebElement>... predicates) {
		this.setWebElement(buItem, predicates);
		return this;
	}

	public B22UnmappedP getFuncUnmapped(Predicate<WebElement>... predicates) {
		this.setWebElement(funcUnmapped, predicates);
		return this;
	}

	public B22UnmappedP getInputUnmapped(Predicate<WebElement>... predicates) {
		this.setWebElement(inputUnmapped, predicates);
		return this;
	}

	public B22UnmappedP getUnmappedTable(Predicate<WebElement>... predicates) {
		this.setWebElement(unmappedTable, predicates);
		return this;
	}

	public B22UnmappedP getAppBusy(Predicate<WebElement>... predicates) {
		this.setWebElement(appBusy, predicates);
		return this;
	}

	@SuppressWarnings("unchecked")
	public B22UnmappedP fillUnmapped() {
		List<WebElement> buItemList = this.getWebElement().findElements(this.buItem);
		Iterator<WebElement> buItemListIt = buItemList.stream().filter(e -> e.isDisplayed())
				.collect(Collectors.toList()).iterator();
		while (buItemListIt.hasNext()) {
			WebElement buItem = buItemListIt.next();
			this.setWebElement(buItem).setBaseElement().getButton().click();
			List<WebElement> funcItemList = buItem.findElements(this.funcItem);
			Iterator<WebElement> funcItemListIT = funcItemList.stream().filter(e -> e.isDisplayed())
					.collect(Collectors.toList()).iterator();
			while (funcItemListIT.hasNext()) {
				WebElement funcItem = funcItemListIT.next();
				if (!funcItem.findElements(this.funcUnmapped).isEmpty()) {
					String value = this.setWebElement(funcItem).setBaseElement().getFuncUnmapped().getWebElement()
							.getText();
					this.getInputUnmapped().type(value);
				}
			}
		}
		return this;
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}
}
