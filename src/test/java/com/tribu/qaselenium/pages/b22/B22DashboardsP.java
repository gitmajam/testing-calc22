package com.tribu.qaselenium.pages.b22;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Predicate;
import com.tribu.qaselenium.testframework.pagebase.BasePO;
import com.tribu.qaselenium.testframework.testbase.PropertiesFile;

public class B22DashboardsP extends BasePO<B22DashboardsP> {

	private final String pageUrl = PropertiesFile.getProperties(PropertiesFile.getProperties("env") + "_url");
	private By summaryTable = By.xpath("//table[@id='summary-table']");

	public B22DashboardsP getSummaryTable(Predicate<WebElement>... predicates) {
		this.setWebElement(summaryTable, predicates);
		return this;
	}

	public B22DashboardsP verifyTargets(List<Map<String, String>> provider, List<Map<String, String>> table,
			SoftAssert softAssert) {
		for (Map<String, String> mapF : provider) {
			for (Map<String, String> mapT : table) {
				if(mapT.get("Function BU").contentEquals(mapF.get("BU"))) {		
					String tableValue = mapT.get(mapF.get("package") + " Target").replace("M", "");
					softAssert.assertTrue(tableValue.contentEquals(mapF.get("targetM")), "value is diferent: " + mapF.get("BU") + " " + mapF.get("package") + " file: " + mapF.get("targetM") + " table: " + tableValue);
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
