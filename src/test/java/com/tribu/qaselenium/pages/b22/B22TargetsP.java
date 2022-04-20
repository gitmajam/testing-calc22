package com.tribu.qaselenium.pages.b22;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Predicate;
import com.tribu.qaselenium.testframework.pagebase.BasePO;
import com.tribu.qaselenium.testframework.testbase.PropertiesFile;

public class B22TargetsP extends BasePO<B22TargetsP> {

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

	public B22TargetsP getDashboards(Predicate<WebElement>... predicates) {
		this.setWebElement(dashboards, predicates);
		return this;
	}

	public B22TargetsP getAcceptButton(Predicate<WebElement>... predicates) {
		this.setWebElement(acceptButton, predicates);
		return this;
	}

	public B22TargetsP getCountryList(Predicate<WebElement>... predicates) {
		this.setWebElement(countryList, predicates);
		return this;
	}

	public B22TargetsP getCountry(Predicate<WebElement>... predicates) {
		this.setWebElement(country, predicates);
		return this;
	}

	public B22TargetsP getYear(Predicate<WebElement>... predicates) {
		this.setWebElement(year, predicates);
		return this;
	}

	public B22TargetsP getTargetList(Predicate<WebElement>... predicates) {
		this.setWebElement(targetList, predicates);
		return this;
	}

	public B22TargetsP getTargetPackageRow(Predicate<WebElement>... predicates) {
		this.setWebElement(targetPackageRow, predicates);
		return this;
	}

	public B22TargetsP getPackageItem(Predicate<WebElement>... predicates) {
		this.setWebElement(packageItem, predicates);
		return this;
	}

	public B22TargetsP getPackageTargetInput(Predicate<WebElement>... predicates) {
		this.setWebElement(packageTargetInput, predicates);
		return this;
	}

	public B22TargetsP getCancelButton(Predicate<WebElement>... predicates) {
		this.setWebElement(cancelButton, predicates);
		return this;
	}

	public B22TargetsP getSaveButton(Predicate<WebElement>... predicates) {
		this.setWebElement(saveButton, predicates);
		return this;
	}

	@SuppressWarnings("unchecked")
	public B22TargetsP setTargets(List<Map<String, String>> provider) {
		Map<String, List<Map<String, String>>> groupsByCountry = provider.stream()
				.filter(map -> map.get("todo").contentEquals("TRUE"))
				.collect(Collectors.groupingBy(map -> map.get("country")));

		for (String country : groupsByCountry.keySet()) {
			this.getCountry(e -> e.getText().contains(country)).click(2000);
			for (Map<String, String> targetsMap : groupsByCountry.get(country)) {
				this.getTargetPackageRow(e -> e.getText().equalsIgnoreCase(targetsMap.get("package"))).getPackageTargetInput()
						.clear().type(targetsMap.get("target"));
			}
			this.getSaveButton(e -> e.getText().contains("Save")).click(2000).getAcceptButton().click()
					.waitForNotVisibility();
		}
		return this;
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}
}
