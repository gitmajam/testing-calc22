package com.tribu.qaselenium.pages.b22;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Predicate;
import com.tribu.qaselenium.testframework.pagebase.BasePO;
import com.tribu.qaselenium.testframework.testbase.PropertiesFile;
import com.tribu.qaselenium.tests.data.JobsDAO;

public class B22DashboardsP extends BasePO<B22DashboardsP> {

	private final String pageUrl = PropertiesFile.getProperties(PropertiesFile.getProperties("env") + "_url");
	private By summaryTable = By.xpath("//table[@id='summary-table']");
	private By updateDashboardButton = By.xpath("//a[@class='btn btn-primary']");
	private By inputLoadFile = By.xpath("//div[@id='ModalUploadFile']//input[@id='file_upload']");
	private By periodSelect = By.xpath("//select[@name='period_id']");
	private By period = By.xpath(".//option");
	private By saveUploadButton = By.xpath("//button[@id='btnActualizarDashboard']");
	private By cancelUploadButton = By.xpath("//button[contains(text(),'Cancel')]");
	private By button = By.xpath("//button");
	private By closeButton = By.xpath("//button[@class='btn-close']");
	private By succesUploadMessage = By.xpath("//div[@class='msg-alert']");
	private By registerInitiatives = By.xpath("//div[@class='col-md-6 data-total']/strong");

	public B22DashboardsP getRegisterInitiatives(Predicate<WebElement>... predicates) {
		this.setWebElement(registerInitiatives, predicates);
		return this;
	}

	public B22DashboardsP getSuccesUploadMessage(Predicate<WebElement>... predicates) {
		this.setWebElement(succesUploadMessage, predicates);
		return this;
	}

	public B22DashboardsP getCloseButton(Predicate<WebElement>... predicates) {
		this.setWebElement(closeButton, predicates);
		return this;
	}

	public B22DashboardsP getButton(Predicate<WebElement>... predicates) {
		this.setWebElement(button, predicates);
		return this;
	}

	public B22DashboardsP getUpdateDashboardButton(Predicate<WebElement>... predicates) {
		this.setWebElement(updateDashboardButton, predicates);
		return this;
	}

	public B22DashboardsP getInputLoadFile(Predicate<WebElement>... predicates) {
		this.setWebElement(inputLoadFile, predicates);
		return this;
	}

	public B22DashboardsP getPeriodSelect(Predicate<WebElement>... predicates) {
		this.setWebElement(periodSelect, predicates);
		return this;
	}

	public B22DashboardsP getPeriod(Predicate<WebElement>... predicates) {
		this.setWebElement(period, predicates);
		return this;
	}

	public B22DashboardsP getSaveUploadButton(Predicate<WebElement>... predicates) {
		this.setWebElement(saveUploadButton, predicates);
		return this;
	}

	public B22DashboardsP getCancelUploadButton(Predicate<WebElement>... predicates) {
		this.setWebElement(cancelUploadButton, predicates);
		return this;
	}

	public B22DashboardsP getSummaryTable(Predicate<WebElement>... predicates) {
		this.setWebElement(summaryTable, predicates);
		return this;
	}

	public B22DashboardsP verifyTargets(List<Map<String, String>> provider, List<Map<String, String>> table) {
		for (Map<String, String> mapP : provider) {
			for (Map<String, String> mapT : table) {
				if (mapT.get("Function BU").contentEquals(mapP.get("BU"))) {
					String tableValue = mapT.get(mapP.get("package") + " Target").replace("M", "");
					softAssertSupplier.get().assertTrue(tableValue.contentEquals(mapP.get("targetM")),
							"Traget value is diferent: " + mapP.get("BU") + " " + mapP.get("package") + " file: "
									+ mapP.get("targetM") + " table: " + tableValue);
				}
			}
		}
		return this;
	}

	public B22DashboardsP verifyAmounts(List<Map<String, String>> provider, List<Map<String, String>> table) {
		for (Map<String, String> mapP : provider) {
			for (Map<String, String> mapT : table) {
				if (mapT.get("Function BU").contentEquals(mapP.get("BU"))) {
					String tableValue = mapT.get(mapP.get("package") + " Real").replace("M", "").replace("k", "");
					softAssertSupplier.get().assertTrue(tableValue.contentEquals(mapP.get("amount")),
							"Amount value is diferent: " + mapP.get("BU") + " " + mapP.get("package") + " file: "
									+ mapP.get("amount") + " table: " + tableValue);
				}
			}
		}
		return this;
	}

	public B22DashboardsP verifyLoadFinish() {
		JobsDAO jobsDAO = new JobsDAO();
		Boolean loadFinished = false;
		try {
			Wait<JobsDAO> wait = new FluentWait<JobsDAO>(jobsDAO)
					.withTimeout(Duration.ofMinutes(10L))
					.pollingEvery(Duration.ofMinutes(1L))
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);

			loadFinished = wait.until((j)->j.verifyEmptyJobs());
		} catch (Exception e) {
			log.info("WaitForImage timeout");
		}
		softAssertSupplier.get().assertTrue(loadFinished,"Load not finished");
		return this;
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}
}
