package com.tribu.qaselenium.pages.mazaprendo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Predicate;
import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class MAHomeP extends BasePO<MAHomeP> {
	MAConfigurationP maConfigurationP;
	private String pageUrl = "https://api-beerambassador-stage.somosmaz.com/user/36";
	private By menuContentButton = By.xpath("//li/a[contains(@href,'/admin/content')]");
	private By cardList = By.xpath("//section/div/div");
	private By cardButton = By.xpath(".//a[contains(@class,'btn')]");
	private By menuStructureButton = By.xpath("/html//a[@id='toolbar-link-system-admin_structure']");
	private By menuAparienciaButton = By.xpath("//div//a[contains(@href,'/admin/appearance')]");
	private By menuAmpliarButton = By.xpath("//div//a[contains(@href,'/admin/modules')]");
	private By menuConfigurationButton = By.xpath("//div//a[contains(@href,'/admin/config')]");
	private By menuUsersButton = By.xpath("//div//a[contains(@href,'/admin/people')]");
	private By menuReportButton = By.xpath("//div//a[contains(@href,'/admin/reports')]");
	private By menuHelpButton = By.xpath("/html//a[@id='toolbar-link-help-main']");
	private By profileButton = By.xpath("/html//a[@id='dropdownUser1']");
	private By learningButton = By.xpath("/html//header[@id='site-header']/div/div/ul//a[contains(@href,'/my-learning')]");
	private By showCertificatesButton = By
			.xpath("/html//header[@id='site-header']/div/div/div[2]/ul//a[contains(@href,'/my-certificates')]");
	private By appLogo = By.xpath("//header[@id='site-header']/div/div/a//img");
	private By termsConditionsButton = By
			.xpath("//footer[@id='site-footer']//a[@title='Política de privacidad - Términos y Condiciones']");
	private By searchButton = By.xpath("/html//header[@id='site-header']//i[@class='bi bi-search']");
	private By searchField = By.xpath("//form[@id='collapseExample']/input[@type='search']");
	private By numCursosText = By
			.xpath("//div[@id='block-mazaprendotheme-content']/div/div[1]/section/p[@class='text-primary']");
	private By assingCoursesButton = By.xpath(
			"//div[@id='block-mazaprendotheme-content']//div[@id='main-wrapper']/div[@class='container-fluid']/section//a[2]//i");
	private By reportButton = By.xpath("//button[@id='report-courses-button']/i");
	private By playCourseButton = By.xpath(
			"/html//div[@id='block-mazaprendotheme-content']/div[@class='content']//img[contains(@src,'Test-cover-image')]/following::i");
	private By myCoursesButton = By.xpath("//span[text()='Mis cursos']");
	private By myRecordsButton = By.xpath("//span[text()='Historial']");
	private By myNPSButton = By.xpath("//span[text()='Mi NPS']");
	private By myLearningButton = By.xpath("//span[text()='Mi Aprendizaje']");
	private By myFilesButton = By.xpath("//span[text()='Mi Expediente']");
	
	public MAHomeP getCardButton(Predicate<WebElement>... predicates){
	this.setWebElement(cardButton,predicates);
	return this;
	}
	
	public MAHomeP getCardList(Predicate<WebElement>... predicates){
	this.setWebElement(cardList,predicates);
	return this;
	}
	
	public MAHomeP getMenuContentButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuContentButton,predicates);
	return this;
	}

	public MAHomeP getMenuStructureButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuStructureButton,predicates);
	return this;
	}

	public MAHomeP getMenuAparienciaButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuAparienciaButton,predicates);
	return this;
	}

	public MAHomeP getMenuAmpliarButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuAmpliarButton,predicates);
	return this;
	}

	public MAHomeP getMenuConfigurationButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuConfigurationButton,predicates);
	return this;
	}

	public MAHomeP getMenuUsersButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuUsersButton,predicates);
	return this;
	}

	public MAHomeP getMenuReportButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuReportButton,predicates);
	return this;
	}

	public MAHomeP getMenuHelpButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuHelpButton,predicates);
	return this;
	}

	public MAHomeP getProfileButton(Predicate<WebElement>... predicates){
	this.setWebElement(profileButton,predicates);
	return this;
	}

	public MAHomeP getLearningButton(Predicate<WebElement>... predicates){
	this.setWebElement(learningButton,predicates);
	return this;
	}

	public MAHomeP getShowCertificatesButton(Predicate<WebElement>... predicates){
	this.setWebElement(showCertificatesButton,predicates);
	return this;
	}

	public MAHomeP getAppLogo(Predicate<WebElement>... predicates){
	this.setWebElement(appLogo,predicates);
	return this;
	}

	public MAHomeP getTermsConditionsButton(Predicate<WebElement>... predicates){
	this.setWebElement(termsConditionsButton,predicates);
	return this;
	}

	public MAHomeP getSearchButton(Predicate<WebElement>... predicates){
	this.setWebElement(searchButton,predicates);
	return this;
	}

	public MAHomeP getSearchField(Predicate<WebElement>... predicates){
	this.setWebElement(searchField,predicates);
	return this;
	}

	public MAHomeP getNumCursosText(Predicate<WebElement>... predicates){
	this.setWebElement(numCursosText,predicates);
	return this;
	}

	public MAHomeP getAssingCoursesButton(Predicate<WebElement>... predicates){
	this.setWebElement(assingCoursesButton,predicates);
	return this;
	}

	public MAHomeP getReportButton(Predicate<WebElement>... predicates){
	this.setWebElement(reportButton,predicates);
	return this;
	}

	public MAHomeP getPlayCourseButton(Predicate<WebElement>... predicates){
	this.setWebElement(playCourseButton,predicates);
	return this;
	}

	public MAHomeP getMyCoursesButton(Predicate<WebElement>... predicates){
	this.setWebElement(myCoursesButton,predicates);
	return this;
	}

	public MAHomeP getMyRecordsButton(Predicate<WebElement>... predicates){
	this.setWebElement(myRecordsButton,predicates);
	return this;
	}
 
	public MAHomeP getMyNPSButton(Predicate<WebElement>... predicates){
	this.setWebElement(myNPSButton,predicates);
	return this;
	}

	public MAHomeP getMyLearningButton(Predicate<WebElement>... predicates){
	this.setWebElement(myLearningButton,predicates);
	return this;
	}

	public MAHomeP getMyFilesButton(Predicate<WebElement>... predicates){
	this.setWebElement(myFilesButton,predicates);
	return this;
	}
	
	@Override
	public String getPageUrl() {
		return pageUrl;
	}

	public MAHomeP cleanCache() {
		log.info("cleanCache");
		this.getMenuConfigurationButton().click(MAConfigurationP::new).get();
		maConfigurationP.getPerformance().click().getClearCache().click();
		return this;
	}
}
