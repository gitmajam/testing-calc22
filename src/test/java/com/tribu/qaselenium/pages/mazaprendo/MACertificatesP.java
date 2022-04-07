package com.tribu.qaselenium.pages.mazaprendo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Predicate;
import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class MACertificatesP extends BasePO<MACertificatesP> {

	private String pageUrl = "https://api-beerambassador-stage.somosmaz.com/user/36";
	private String xpathPart1= "/html//div[@id='block-mazaprendotheme-content']/div//span[contains(text(),'";
	private By menuContentButton = By.xpath("//li/a[contains(@href,'/admin/content')]");
	private By menuStructureButton = By.xpath("/html//a[@id='toolbar-link-system-admin_structure']");
	private By menuAparienciaButton = By.xpath("//div//a[contains(@href,'/admin/appearance')]");
	private By menuAmpliarButton = By.xpath("//div//a[contains(@href,'/admin/modules')]");
	private By menuConfigurationButton = By.xpath("//div//a[contains(@href,'/admin/config')]");
	private By menuUsersButton = By.xpath("//div//a[contains(@href,'/admin/people')]");
	private By menuReportButton = By.xpath("//div//a[contains(@href,'/admin/reports')]");
	private By menuHelpButton = By.xpath("/html//a[@id='toolbar-link-help-main']");
	private By profileButton = By.xpath("/html//a[@id='dropdownUser1']");
	private By learningButton = By.xpath("/html//header[@id='site-header']/div/div/ul//a[@href='/my-learning']");
	private By pageTitle = By.xpath("/html//div[@id='block-mazaprendotheme-content']//div/div[1]/section//h2");
	private By certificadoName = By.xpath("/html//h4[@id='course_certificate_name']");
	private By showCertificate = By.xpath("/html//button[@id='preview_certificate_button']");
	private By certificateText1 = By.xpath("//div[@id='certificateHtml']//p[@class='certificate-content-p-label-credit']");
	private By certificateText2 = By.xpath("//div[@id='certificateHtml']//h3[@class='certificate-content--user']");
	private By certificateText3 = By.xpath("//div[@id='certificateHtml']//p[@class='certificate-content-p-label-completed']");
	private By downloadCertButton = By.xpath("/html//button[@id='download-certificate-action']");
	private By exitCertButton = By.xpath("/html//div[@id='mainModal']//div[@class='modal-footer']/button[1]");
	private By appLogo = By.xpath("//header[@id='site-header']/div/div/a//img");
	private By termsConditionsButton = By.xpath("//footer[@id='site-footer']//a[@title='Política de privacidad - Términos y Condiciones']");
	private By searchButton = By.xpath("/html//header[@id='site-header']//i[@class='bi bi-search']");
	private By searchField = By.xpath("//form[@id='collapseExample']/input[@type='search']");
	private By numCursosText = By.xpath("//div[@id='block-mazaprendotheme-content']/div/div[1]/section/p[@class='text-primary']");
	private By assingCoursesButton = By.xpath("//div[@id='block-mazaprendotheme-content']//div[@id='main-wrapper']/div[@class='container-fluid']/section//a[2]//i");
	private By reportButton = By.xpath("//button[@id='report-courses-button']/i");
	private By playCourseButton = By.xpath("/html//div[@id='block-mazaprendotheme-content']/div[@class='content']//img[contains(@src,'Test-cover-image')]/following::i");
	
	public MACertificatesP getMenuContentButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuContentButton,predicates);
	return this;
	}

	public MACertificatesP getMenuStructureButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuStructureButton,predicates);
	return this;
	}

	public MACertificatesP getMenuAparienciaButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuAparienciaButton,predicates);
	return this;
	}

	public MACertificatesP getMenuAmpliarButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuAmpliarButton,predicates);
	return this;
	}

	public MACertificatesP getMenuConfigurationButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuConfigurationButton,predicates);
	return this;
	}

	public MACertificatesP getMenuUsersButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuUsersButton,predicates);
	return this;
	}

	public MACertificatesP getMenuReportButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuReportButton,predicates);
	return this;
	}

	public MACertificatesP getMenuHelpButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuHelpButton,predicates);
	return this;
	}

	public MACertificatesP getProfileButton(Predicate<WebElement>... predicates){
	this.setWebElement(profileButton,predicates);
	return this;
	}

	public MACertificatesP getLearningButton(Predicate<WebElement>... predicates){
	this.setWebElement(learningButton,predicates);
	return this;
	}

	public MACertificatesP getPageTitle(Predicate<WebElement>... predicates){
	this.setWebElement(pageTitle,predicates);
	return this;
	}

	public MACertificatesP getCertificadoName(Predicate<WebElement>... predicates){
	this.setWebElement(certificadoName,predicates);
	return this;
	}

	public MACertificatesP getShowCertificate(Predicate<WebElement>... predicates){
	this.setWebElement(showCertificate,predicates);
	return this;
	}

	public MACertificatesP getCertificateText1(Predicate<WebElement>... predicates){
	this.setWebElement(certificateText1,predicates);
	return this;
	}

	public MACertificatesP getCertificateText2(Predicate<WebElement>... predicates){
	this.setWebElement(certificateText2,predicates);
	return this;
	}

	public MACertificatesP getCertificateText3(Predicate<WebElement>... predicates){
	this.setWebElement(certificateText3,predicates);
	return this;
	}

	public MACertificatesP getDownloadCertButton(Predicate<WebElement>... predicates){
	this.setWebElement(downloadCertButton,predicates);
	return this;
	}

	public MACertificatesP getExitCertButton(Predicate<WebElement>... predicates){
	this.setWebElement(exitCertButton,predicates);
	return this;
	}

	public MACertificatesP getAppLogo(Predicate<WebElement>... predicates){
	this.setWebElement(appLogo,predicates);
	return this;
	}

	public MACertificatesP getTermsConditionsButton(Predicate<WebElement>... predicates){
	this.setWebElement(termsConditionsButton,predicates);
	return this;
	}

	public MACertificatesP getSearchButton(Predicate<WebElement>... predicates){
	this.setWebElement(searchButton,predicates);
	return this;
	}

	public MACertificatesP getSearchField(Predicate<WebElement>... predicates){
	this.setWebElement(searchField,predicates);
	return this;
	}

	public MACertificatesP getNumCursosText(Predicate<WebElement>... predicates){
	this.setWebElement(numCursosText,predicates);
	return this;
	}

	public MACertificatesP getAssingCoursesButton(Predicate<WebElement>... predicates){
	this.setWebElement(assingCoursesButton,predicates);
	return this;
	}

	public MACertificatesP getReportButton(Predicate<WebElement>... predicates){
	this.setWebElement(reportButton,predicates);
	return this;
	}

	public MACertificatesP getPlayCourseButton(Predicate<WebElement>... predicates){
	this.setWebElement(playCourseButton,predicates);
	return this;
	}

	//part xpath
		public MACertificatesP getXpathPart1(String locatorPart) {
			this.xpathPart = xpathPart1;
			By question = By.xpath(this.xpathPart + locatorPart + "')]/following::div/a");
			this.locator = question;
			return this;
		}
		
	@Override
	public String getPageUrl() {
		return pageUrl;
	}

}
