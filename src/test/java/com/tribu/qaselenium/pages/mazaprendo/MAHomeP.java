package com.tribu.qaselenium.pages.mazaprendo;

import org.openqa.selenium.By;

import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class MAHomeP extends BasePO<MAHomeP> {

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
	private By appLogo = By.xpath("//header[@id='site-header']/div/div/a[@href='/my-learning']/img");
	private By termsConditionsButton = By.xpath("//footer[@id='site-footer']//a[@title='Política de privacidad - Términos y Condiciones']");
	private By searchButton = By.xpath("/html//header[@id='site-header']//i[@class='bi bi-search']");
	private By searchField = By.xpath("//form[@id='collapseExample']/input[@type='search']");
	private By numCursosText = By.xpath("//div[@id='block-mazaprendotheme-content']/div/div[1]/section/p[@class='text-primary']");

	public MAHomeP getMenuContentButton() {
		this.locator = menuContentButton;
		return this;
	}

	public MAHomeP getMenuStructureButton() {
		this.locator = menuStructureButton;
		return this;
	}

	public MAHomeP getMenuAparienciaButton() {
		this.locator = menuAparienciaButton;
		return this;
	}

	public MAHomeP getMenuAmpliarButton() {
		this.locator = menuAmpliarButton;
		return this;
	}

	public MAHomeP getMenuConfigurationButton() {
		this.locator = menuConfigurationButton;
		return this;
	}

	public MAHomeP getMenuUsersButton() {
		this.locator = menuUsersButton;
		return this;
	}

	public MAHomeP getMenuReportButton() {
		this.locator = menuReportButton;
		return this;
	}

	public MAHomeP getMenuHelpButton() {
		this.locator = menuHelpButton;
		return this;
	}

	public MAHomeP getProfileButton() {
		this.locator = profileButton;
		return this;
	}

	public MAHomeP getLearningButton() {
		this.locator = learningButton;
		return this;
	}

	public MAHomeP getAppLogo() {
		this.locator = appLogo;
		return this;
	}

	public MAHomeP getTermsConditionsButton() {
		this.locator = termsConditionsButton;
		return this;
	}

	public MAHomeP getSearchButton() {
		this.locator = searchButton;
		return this;
	}

	public MAHomeP getSearchField() {
		this.locator = searchField;
		return this;
	}

	public MAHomeP getNumCursosText() {
		this.locator = numCursosText;
		return this;
	}

		
	@Override
	public String getPageUrl() {
		return pageUrl;
	}

}
