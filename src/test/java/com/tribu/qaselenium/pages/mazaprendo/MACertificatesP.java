package com.tribu.qaselenium.pages.mazaprendo;

import org.openqa.selenium.By;

import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class MACertificatesP extends BasePO<MACertificatesP> {

	private String pageUrl = "https://api-beerambassador-stage.somosmaz.com/user/36";
	private String xpathPart1= "/html//div[@id='block-mazaprendotheme-content']/div//span[contains(text(),'";
	
	private By menuContentButton = By.xpath("//li/a[@href='/admin/content']");
	private By menuStructureButton = By.xpath("/html//a[@id='toolbar-link-system-admin_structure']");
	private By menuAparienciaButton = By.xpath("//div//a[@href='/admin/appearance']");
	private By menuAmpliarButton = By.xpath("//div//a[@href='/admin/modules']");
	private By menuConfigurationButton = By.xpath("//div//a[@href='/admin/config']");
	private By menuUsersButton = By.xpath("//div//a[@href='/admin/people']");
	private By menuReportButton = By.xpath("//div//a[@href='/admin/reports']");
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
	
	public MACertificatesP getPageTitle() {
		this.locator = pageTitle;
		return this;
	}

	public MACertificatesP getCertificadoName() {
		this.locator = certificadoName;
		return this;
	}

	public MACertificatesP getShowCertificate() {
		this.locator = showCertificate;
		return this;
	}

	public MACertificatesP getCertificateText1() {
		this.locator = certificateText1;
		return this;
	}

	public MACertificatesP getCertificateText2() {
		this.locator = certificateText2;
		return this;
	}

	public MACertificatesP getCertificateText3() {
		this.locator = certificateText3;
		return this;
	}

	public MACertificatesP getDownloadCertButton() {
		this.locator = downloadCertButton;
		return this;
	}

	public MACertificatesP getExitCertButton() {
		this.locator = exitCertButton;
		return this;
	}
	
	public MACertificatesP getPlayCourseButton() {
		this.locator = playCourseButton;
		return this;
	}

	public MACertificatesP getAssingCoursesButton() {
		this.locator = assingCoursesButton;
		return this;
	}

	public MACertificatesP getReportButton() {
		this.locator = reportButton;
		return this;
	}
	
	public MACertificatesP getMenuContentButton() {
		this.locator = menuContentButton;
		return this;
	}

	public MACertificatesP getMenuStructureButton() {
		this.locator = menuStructureButton;
		return this;
	}

	public MACertificatesP getMenuAparienciaButton() {
		this.locator = menuAparienciaButton;
		return this;
	}

	public MACertificatesP getMenuAmpliarButton() {
		this.locator = menuAmpliarButton;
		return this;
	}

	public MACertificatesP getMenuConfigurationButton() {
		this.locator = menuConfigurationButton;
		return this;
	}

	public MACertificatesP getMenuUsersButton() {
		this.locator = menuUsersButton;
		return this;
	}

	public MACertificatesP getMenuReportButton() {
		this.locator = menuReportButton;
		return this;
	}

	public MACertificatesP getMenuHelpButton() {
		this.locator = menuHelpButton;
		return this;
	}

	public MACertificatesP getProfileButton() {
		this.locator = profileButton;
		return this;
	}

	public MACertificatesP getLearningButton() {
		this.locator = learningButton;
		return this;
	}

	public MACertificatesP getAppLogo() {
		this.locator = appLogo;
		return this;
	}

	public MACertificatesP getTermsConditionsButton() {
		this.locator = termsConditionsButton;
		return this;
	}

	public MACertificatesP getSearchButton() {
		this.locator = searchButton;
		return this;
	}

	public MACertificatesP getSearchField() {
		this.locator = searchField;
		return this;
	}

	public MACertificatesP getNumCursosText() {
		this.locator = numCursosText;
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
