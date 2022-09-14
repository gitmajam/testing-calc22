package com.tribu.qaselenium.pages.app;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Predicate;
import com.tribu.qaselenium.testframework.pagebase.BasePO;
import com.tribu.qaselenium.testframework.testbase.PropertiesFile;

public class TargetsP extends BasePO<TargetsP> {

	private final String pageUrl = PropertiesFile.getProperties(PropertiesFile.getProperties("env") + "_url");
	private By countryList = By.xpath("//div[@id='collapseExample']/ul");
	private By country = By.xpath("//div[@id='collapseExample']/ul//li/a");
	private By year = By.xpath("//select[@required='required']/option");
	private By targetList = By.xpath("//div[@class='content-target']");
	private By targetPackageRow = By.xpath("//div[@class='content-target']/div[@class='row']");
	private By packageItem = By.xpath(".//div[@class='m-3']");
	private By packageTargetInput = By.xpath(".//input[@class='form-control value-target']");
	private By cancelButton = By.xpath("//button[@class='btn btn-outline']");
	private By saveButton = By.xpath("//button[@class='btn btn-primary']");
	private By acceptButton = By.xpath("//button[@data-bs-dismiss='modal']");
	private By dashboards = By.linkText("Dashboards");
	private By appBusy = By.xpath("/html[@class='nprogress-busy']");

	public TargetsP getAppBusy(Predicate<WebElement>... predicates) {
		this.setWebElement(appBusy, predicates);
		return this;
	}

	public TargetsP getDashboards(Predicate<WebElement>... predicates) {
		this.setWebElement(dashboards, predicates);
		return this;
	}

	public TargetsP getAcceptButton(Predicate<WebElement>... predicates) {
		this.setWebElement(acceptButton, predicates);
		return this;
	}

	public TargetsP getCountryList(Predicate<WebElement>... predicates) {
		this.setWebElement(countryList, predicates);
		return this;
	}

	public TargetsP getCountry(Predicate<WebElement>... predicates) {
		this.setWebElement(country, predicates);
		return this;
	}

	public TargetsP getYear(Predicate<WebElement>... predicates) {
		this.setWebElement(year, predicates);
		return this;
	}

	public TargetsP getTargetList(Predicate<WebElement>... predicates) {
		this.setWebElement(targetList, predicates);
		return this;
	}

	public TargetsP getTargetPackageRow(Predicate<WebElement>... predicates) {
		this.setWebElement(targetPackageRow, predicates);
		return this;
	}

	public TargetsP getPackageItem(Predicate<WebElement>... predicates) {
		this.setWebElement(packageItem, predicates);
		return this;
	}

	public TargetsP getPackageTargetInput(Predicate<WebElement>... predicates) {
		this.setWebElement(packageTargetInput, predicates);
		return this;
	}

	public TargetsP getCancelButton(Predicate<WebElement>... predicates) {
		this.setWebElement(cancelButton, predicates);
		return this;
	}

	public TargetsP getSaveButton(Predicate<WebElement>... predicates) {
		this.setWebElement(saveButton, predicates);
		return this;
	}

	@SuppressWarnings("unchecked")
	public TargetsP setTargets(List<Map<String, String>> provider) {
		Map<String, List<Map<String, String>>> groupsByCountry = provider.stream()
				.filter(map -> map.get("todo").contentEquals("TRUE"))
				.filter(map -> map.get("countryTarget").contentEquals("TRUE"))
				.collect(Collectors.groupingBy(map -> map.get("country")));

		for (String country : groupsByCountry.keySet()) {
			this.getCountry(e -> e.getText().contains(country)).click()
			.getAppBusy().waitForNotPresence();
			for (Map<String, String> targetsMap : groupsByCountry.get(country)) {
				this.getTargetPackageRow(e -> e.getText().equalsIgnoreCase(targetsMap.get("package")))
					.getPackageTargetInput().clear().type(targetsMap.get("target"));
			}
			this.getSaveButton(e -> e.getText().contains("Save")).click()
				.getAppBusy().waitForNotPresence()
				.getAcceptButton().click().waitForNotVisibility();
		}
		return this;
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}
}
