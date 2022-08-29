package com.tribu.qaselenium.pages.b22;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Predicate;
import com.tribu.qaselenium.testframework.pagebase.BasePO;
import com.tribu.qaselenium.testframework.testbase.PropertiesFile;
import com.tribu.qaselenium.tests.data.JobsDAO;

public class B22DashboardsP extends BasePO<B22DashboardsP> {

	private final String pageUrl = PropertiesFile.getProperties(PropertiesFile.getProperties("env") + "_url");
	private By summaryTable = By.xpath("//table[@id='summary-table']");
	private By updateDashboardButton = By.xpath("//a[@class='btn btn-primary']");
	private By inputLoadFileButton = By.xpath("//div[@id='ModalUploadFile']//div[@class='button-upload']/button");
	private By inputLoadFile = By.xpath("//div[@id='ModalUploadFile']//input");
	private By periodSelect = By.xpath("//select[@name='period_id']");
	private By period = By.xpath(".//option");
	private By saveUploadButton = By.xpath("//button[@id='btnActualizarDashboard']");
	private By cancelUploadButton = By.xpath("//button[contains(text(),'Cancel')]");
	private By button = By.xpath("//button");
	private By searchButton = By.xpath("//i[@class='bi-search']");
	private By modalUpload = By.xpath("//div[@id='ModalUploadFile']");
	private By modalRespUpload = By.xpath("//div[@id='upload-response-modal']");
	private By closeButton = By.xpath(".//button[@aria-label='Close']");
	private By succesUploadMessage = By.xpath("//div[@class='msg-alert']");
	private By registerInitiatives = By.xpath("//div[@class='col-md-6 data-total']/strong");
	private By totalInitiatives = By.xpath("//div[@class='col-md-6 data-total']/strong");
	private By filter = By.xpath("//div[@class='col-sm-6 col-md-4 col-xl-2 py-2']");
	private By select = By.xpath(".//div[@class='multiselect__select']");
	private By item = By.xpath(".//span[@data-deselect='X']");
	private By inputSearch = By.xpath(".//input[@id='single-select']");
	private By graphics = By.xpath("//div[@id='capture']");
	private By appBusy = By.xpath("/html[@class='nprogress-busy']");

	public B22DashboardsP getSearchButton(Predicate<WebElement>... predicates) {
		this.setWebElement(searchButton, predicates);
		return this;
	}

	public B22DashboardsP getModalUpload(Predicate<WebElement>... predicates) {
		this.setWebElement(modalUpload, predicates);
		return this;
	}

	public B22DashboardsP getModalRespUpload(Predicate<WebElement>... predicates) {
		this.setWebElement(modalRespUpload, predicates);
		return this;
	}

	public B22DashboardsP getButton(Predicate<WebElement>... predicates) {
		this.setWebElement(button, predicates);
		return this;
	}

	public B22DashboardsP getAppBusy(Predicate<WebElement>... predicates) {
		this.setWebElement(appBusy, predicates);
		return this;
	}

	public B22DashboardsP getGraphics(Predicate<WebElement>... predicates) {
		this.setWebElement(graphics, predicates);
		return this;
	}

	public B22DashboardsP getInputSearch(Predicate<WebElement>... predicates) {
		this.setWebElement(inputSearch, predicates);
		return this;
	}

	public B22DashboardsP getFilter(Predicate<WebElement>... predicates) {
		this.setWebElement(filter, predicates);
		return this;
	}

	public B22DashboardsP getSelect(Predicate<WebElement>... predicates) {
		this.setWebElement(select, predicates);
		return this;
	}

	public B22DashboardsP getItem(Predicate<WebElement>... predicates) {
		this.setWebElement(item, predicates);
		return this;
	}

	public B22DashboardsP getTotalInitiatives(Predicate<WebElement>... predicates) {
		this.setWebElement(totalInitiatives, predicates);
		return this;
	}

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
		
		List<Map<String, String>> buTarget = provider.stream().filter(m -> m.get("buTarget").contentEquals("TRUE"))
																.collect(Collectors.toList());
		for (Map<String, String> mapP : buTarget) {
			for (Map<String, String> mapT : table) {
				if (mapT.get("Function BU").contentEquals(mapP.get("BU"))) {
					String tableValue = mapT.get(mapP.get("package") + " Target").replace("M", "");
					softAssertSupplier.get().assertTrue(tableValue.contentEquals(mapP.get("targetM")),
							"Target value is diferent, " + mapP.get("BU") + " " + mapP.get("package") + " expected: "
									+ mapP.get("targetM") + " but found: " + tableValue + ", ");
				}
			}
		}
		return this;
	}

	public B22DashboardsP verifyAmounts(List<Map<String, String>> provider, List<Map<String, String>> table,String amount) {
		for (Map<String, String> mapP : provider) {
			for (Map<String, String> mapT : table) {
				if (mapT.get("Function BU").contentEquals(mapP.get("BU"))) {
					String tableValue = mapT.get(mapP.get("package") + " Real").replace("M", "").replace("k", "");
					softAssertSupplier.get().assertTrue(tableValue.contentEquals(mapP.get(amount)),
							"Amount value is diferent: " + mapP.get("BU") + " " + mapP.get("package") + " expected: "
									+ mapP.get(amount) + " found: " + tableValue + ", ");
				}
			}
		}
		return this;
	}

	public B22DashboardsP verifyLoadFinish() {
		JobsDAO jobsDAO = new JobsDAO();
		Boolean loadFinished = false;
		try {
			Wait<JobsDAO> wait = new FluentWait<JobsDAO>(jobsDAO).withTimeout(Duration.ofMinutes(15L))
					.pollingEvery(Duration.ofMinutes(1L))
					.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);

			loadFinished = wait.until((jobs) -> jobs.verifyEmptyJobs());
		} catch (Exception e) {
			log.info("Wait for load file timeout");
		}
		softAssertSupplier.get().assertTrue(loadFinished, "Load not finished");
		return this;
	}

	@SuppressWarnings("unchecked")
	public B22DashboardsP verifyFilters(String filterL1, List<Map<String, String>> filters) {
		Map<String, List<Map<String, String>>> filterGroups = filters.stream()
				.collect(Collectors.groupingBy(map -> map.get("filter")));
		for (String filter : filterGroups.keySet()) {
			for (Map<String, String> mapP : filterGroups.get(filter)) {
				this.getAppBusy().waitForNotPresence()
						.getFilter(e -> e.getText().contains(mapP.get("filter")))
						.getSelect().click()
						.getItem(e -> e.getText().contentEquals(mapP.get("item"))).click()
						.getSearchButton().click().getAppBusy().waitForNotPresence()
						.getTotalInitiatives(e -> e.getText().contentEquals(mapP.get(filterL1)))
						.assertExist("Total filter doesn't match, expected: " + mapP.get(filterL1) + " but found: " + this.getTotalInitiatives().getWebElement().getText())
						.getFilter(e -> e.getText().contains(mapP.get("filter")))
						.getSelect().click()
						.getItem(e -> e.getAttribute("class").contains("selected")).click()
						.getSelect().click();
			}
		}
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public B22DashboardsP verifyCombinedFilters(List<Map<String, String>> provider) {
		Map<String, List<Map<String, String>>> filterGroups = provider.stream()
				.collect(Collectors.groupingBy(map -> map.get("filter")));
		for (String filter : filterGroups.keySet()) {
			int acum = 0;
			this.getFilter(e -> e.getText().contains(filter)).getSelect().click();
			for (Map<String, String> mapP : filterGroups.get(filter)) {
				if (mapP.get("type").contentEquals("combined")) {
					acum = acum + Integer.parseInt(mapP.get("initiatives"));
					this.getItem(e -> e.getText().contentEquals(mapP.get("item"))).click();
				}
			}
			this.getSearchButton().click().getAppBusy().waitForNotPresence();
			String acumS = Integer.toString(acum);
			this.getTotalInitiatives(e -> e.getText().contentEquals(acumS))
					.assertExist("combinated filter: " + filter + " valueFile: " + acumS + " valueFound: "
							+ this.getWebElement().getText())
					.getButton(e -> e.getText().contentEquals("Clear filters")).click().getAppBusy()
					.waitForNotPresence();
		}
		return this;
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}
}
