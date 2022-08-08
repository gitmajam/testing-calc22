package com.tribu.qaselenium.pages.b22;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Predicate;
import com.tribu.qaselenium.testframework.pagebase.BasePO;
import com.tribu.qaselenium.testframework.testbase.PropertiesFile;

public class B22ReportsFunctionP extends BasePO<B22ReportsFunctionP> {

	private final String pageUrl = PropertiesFile.getProperties(PropertiesFile.getProperties("env") + "_url");
	private By button = By.xpath("//button");
	private By filter = By.xpath("//div[@class='col-md']");
	private By multiSelect = By.xpath(".//div[@class='multiselect__select']");
	private By singleSelect = By.xpath(".//select[@class='form-select']");
	private By multiItem = By.xpath(".//li/span[@data-deselect='X']");
	private By singleItem = By.xpath(".//option");
	private By infoBox = By.xpath("//div[@class='informative-box-maz']");
	private By infoText = By.xpath(".//div[contains(@class,'txt-bold')]");
	private By graphBox = By.xpath("//div[@class='graphics-boxBU']");
	private By graphValue = By.xpath(".//span[@class='white-info']");
	private By appBusy = By.xpath("/html[@class='nprogress-busy']");

	public B22ReportsFunctionP getMultiSelect(Predicate<WebElement>... predicates) {
		this.setWebElement(multiSelect, predicates);
		return this;
	}

	public B22ReportsFunctionP getSingleSelect(Predicate<WebElement>... predicates) {
		this.setWebElement(singleSelect, predicates);
		return this;
	}

	public B22ReportsFunctionP getMultiItem(Predicate<WebElement>... predicates) {
		this.setWebElement(multiItem, predicates);
		return this;
	}

	public B22ReportsFunctionP getSingleItem(Predicate<WebElement>... predicates) {
		this.setWebElement(singleItem, predicates);
		return this;
	}

	public B22ReportsFunctionP getInfoBox(Predicate<WebElement>... predicates) {
		this.setWebElement(infoBox, predicates);
		return this;
	}

	public B22ReportsFunctionP getInfoText(Predicate<WebElement>... predicates) {
		this.setWebElement(infoText, predicates);
		return this;
	}

	public B22ReportsFunctionP getGraphBox(Predicate<WebElement>... predicates) {
		this.setWebElement(graphBox, predicates);
		return this;
	}

	public B22ReportsFunctionP getGraphValue(Predicate<WebElement>... predicates) {
		this.setWebElement(graphValue, predicates);
		return this;
	}

	public B22ReportsFunctionP getButton(Predicate<WebElement>... predicates) {
		this.setWebElement(button, predicates);
		return this;
	}

	public B22ReportsFunctionP getAppBusy(Predicate<WebElement>... predicates) {
		this.setWebElement(appBusy, predicates);
		return this;
	}

	public B22ReportsFunctionP getFilter(Predicate<WebElement>... predicates) {
		this.setWebElement(filter, predicates);
		return this;
	}

	public B22ReportsFunctionP verifyAmounts(List<Map<String, String>> provider, List<Map<String, String>> table) {
		for (Map<String, String> mapP : provider) {
			for (Map<String, String> mapT : table) {
				if (mapT.get("Function BU").contentEquals(mapP.get("BU"))) {
					String tableValue = mapT.get(mapP.get("package") + " Real").replace("M", "").replace("k", "");
					softAssertSupplier.get().assertTrue(tableValue.contentEquals(mapP.get("amount")),
							"Amount value is diferent: " + mapP.get("BU") + " " + mapP.get("package") + " expected: "
									+ mapP.get("amount") + " found: " + tableValue + ", ");
				}
			}
		}
		return this;
	}

	@SuppressWarnings("unchecked")
	public B22ReportsFunctionP verifyTargetPercentages(List<Map<String, String>> provider) {
		
		List<Map<String, String>> functionList = provider.stream()
				.filter(m -> m.get("filter").contains("Function"))
				.collect(Collectors.toList());
		
		List<Map<String, String>> stageList = provider.stream()
				.filter(m -> m.get("type").contains("stage"))
				.collect(Collectors.toList());	
		
		Map<String, List<Map<String, String>>> periodList = provider.stream()
				.filter(m -> m.get("filter").contains("Periods"))
				.collect(Collectors.groupingBy(m -> m.get("item")));
		
		this.getAppBusy().waitForNotPresence()
		.getFilter(e -> e.getText().contains("Function"))
		.getMultiSelect().click();	
	
		functionList.stream().filter(mapF -> mapF.get("type").contentEquals("AND")).forEach(mapF -> {
		this.getMultiItem(e -> e.getText().trim().contentEquals(mapF.get("item"))).click();
		});
		
		stageList.forEach(m -> {
		this.getAppBusy().waitForNotPresence()
			.getFilter(e -> e.getText().contains(m.get("filter")))
			.getSingleSelect().click()	
			.getSingleItem(e -> e.getText().trim().contentEquals(m.get("item"))).click()
			.checkPeriods(periodList, m.get("item"));
		});
		
		return this;
	}
	
	@SuppressWarnings("unchecked")
	private void checkPeriods(Map<String, List<Map<String, String>>> periodList, String stage) {
		
		periodList.forEach((k,v)->{
		this.getFilter(e -> e.getText().contains("Periods"))
			.getSingleSelect().click()
			.getSingleItem(e -> e.getText().contains(k)).click()
			.getAppBusy().waitForNotPresence();
			
			v.forEach(m->{
				this.getGraphBox(e -> e.getText().contains(m.get("bu")))
				.getGraphValue().assertString(WebElement::getText, m.get(stage), 
						"Percentage doesn't match, BU: " + m.get("bu") + ", Period: " + k + ", Stage: " + stage);
			});
		});
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}
}
