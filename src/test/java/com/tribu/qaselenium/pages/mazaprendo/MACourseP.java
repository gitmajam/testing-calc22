package com.tribu.qaselenium.pages.mazaprendo;

import org.openqa.selenium.By;

import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class MACourseP extends BasePO<MACourseP> {

	private String pageUrl = "https://api-beerambassador-stage.somosmaz.com/user/36";
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
	private By appLogo = By.xpath("//header[@id='site-header']/div/div/a//img");
	private By termsConditionsButton = By.xpath("//footer[@id='site-footer']//a[@title='Política de privacidad - Términos y Condiciones']");
	private By searchButton = By.xpath("/html//header[@id='site-header']//i[@class='bi bi-search']");
	private By searchField = By.xpath("//form[@id='collapseExample']/input[@type='search']");
	private By numCursosText = By.xpath("//div[@id='block-mazaprendotheme-content']/div/div[1]/section/p[@class='text-primary']");
	private By assingCoursesButton = By.xpath("//div[@id='block-mazaprendotheme-content']//div[@id='main-wrapper']/div[@class='container-fluid']/section//a//i");
	private By reportButton = By.xpath("//button[@id='report-courses-button']/i");
	private By playCourseButton = By.xpath("/html//div[@id='block-mazaprendotheme-content']/div[@class='content']//img[contains(@src,'Test-cover-image_1')]/following::i");
	
	public MACourseP getPlayCourseButton() {
		this.locator = playCourseButton;
		return this;
	}

	public MACourseP getAssingCoursesButton() {
		this.locator = assingCoursesButton;
		return this;
	}

	public MACourseP getReportButton() {
		this.locator = reportButton;
		return this;
	}
	
	public MACourseP getMenuContentButton() {
		this.locator = menuContentButton;
		return this;
	}

	public MACourseP getMenuStructureButton() {
		this.locator = menuStructureButton;
		return this;
	}

	public MACourseP getMenuAparienciaButton() {
		this.locator = menuAparienciaButton;
		return this;
	}

	public MACourseP getMenuAmpliarButton() {
		this.locator = menuAmpliarButton;
		return this;
	}

	public MACourseP getMenuConfigurationButton() {
		this.locator = menuConfigurationButton;
		return this;
	}

	public MACourseP getMenuUsersButton() {
		this.locator = menuUsersButton;
		return this;
	}

	public MACourseP getMenuReportButton() {
		this.locator = menuReportButton;
		return this;
	}

	public MACourseP getMenuHelpButton() {
		this.locator = menuHelpButton;
		return this;
	}

	public MACourseP getProfileButton() {
		this.locator = profileButton;
		return this;
	}

	public MACourseP getLearningButton() {
		this.locator = learningButton;
		return this;
	}

	public MACourseP getAppLogo() {
		this.locator = appLogo;
		return this;
	}

	public MACourseP getTermsConditionsButton() {
		this.locator = termsConditionsButton;
		return this;
	}

	public MACourseP getSearchButton() {
		this.locator = searchButton;
		return this;
	}

	public MACourseP getSearchField() {
		this.locator = searchField;
		return this;
	}

	public MACourseP getNumCursosText() {
		this.locator = numCursosText;
		return this;
	}

		
	@Override
	public String getPageUrl() {
		return pageUrl;
	}

}
