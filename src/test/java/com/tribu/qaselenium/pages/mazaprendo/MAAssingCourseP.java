package com.tribu.qaselenium.pages.mazaprendo;

import org.openqa.selenium.By;

import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class MAAssingCourseP extends BasePO<MAAssingCourseP> {

	private String pageUrl = "https://mazaprendo-stage.somosmaz.com/admin/structure/maz_aprendo_admin_courses/create";
	private By menuContentButton = By.xpath("//li/a[@href='/admin/content']");
	private By menuStructureButton = By.xpath("/html//a[@id='toolbar-link-system-admin_structure']");
	private By menuAparienciaButton = By.xpath("//div//a[@href='/admin/appearance']");
	private By menuAmpliarButton = By.xpath("//div//a[@href='/admin/modules']");
	private By menuConfigurationButton = By.xpath("//div//a[@href='/admin/config']");
	private By menuUsersButton = By.xpath("//div//a[@href='/admin/people']");
	private By menuReportButton = By.xpath("//div//a[@href='/admin/reports']");
	private By menuHelpButton = By.xpath("/html//a[@id='toolbar-link-help-main']");
	private By createCourse = By.xpath(
			"//div[@id='block-seven-content']/nav[@role='navigation']/nav[@role='navigation']//a[@href='/admin/structure/maz_aprendo_admin_courses/create']");
	private By editCourse = By.xpath(
			"//div[@id='block-seven-content']/nav[@role='navigation']/nav[@role='navigation']//a[@href='/admin/structure/maz_aprendo_admin_courses/edit']");
	private By assingCourse = By.xpath(
			"//div[@id='block-seven-content']/nav[@role='navigation']/nav[@role='navigation']//a[@href='/admin/structure/maz_aprendo_admin_courses/assing']");
	private By selectCourse = By.xpath("/html//select[@id='edit-type']/option[2]");
	private By selectCourseItem = By.xpath("/html//select[@id='edit-type']/option[contains(text(),'Test-Curso')]");
	private By titleSonCourse = By.xpath("/html//input[@id='input-title']");
	private By initEndDateCheck = By.xpath("/html//input[@id='input-date']");
	private By saveCourseButton = By.xpath("/html//input[@id='submit-save']");

	private By selectAssingSonCourse = By.xpath("/html//select[@id='edit-type']");
	private By selectAssingSonCourseItem = By
			.xpath("/html//select[@id='edit-type']/option[contains(text(),'Test-Son-Curso')]");
	private By initEndDateAssingCheck = By.xpath("/html//select[@id='edit-type']");
	private By chooseAssingFileButton = By.xpath("/html//input[@id='input-excel']");

	public MAAssingCourseP getCreateCourse() {
		this.locator = createCourse;
		return this;
	}

	public MAAssingCourseP getEditCourse() {
		this.locator = editCourse;
		return this;
	}

	public MAAssingCourseP getAssingCourse() {
		this.locator = assingCourse;
		return this;
	}

	public MAAssingCourseP getSelectCourse() {
		this.locator = selectCourse;
		return this;
	}

	public MAAssingCourseP getSelectCourseItem() {
		this.locator = selectCourseItem;
		return this;
	}

	public MAAssingCourseP getTitleSonCourse() {
		this.locator = titleSonCourse;
		return this;
	}

	public MAAssingCourseP getInitEndDateCheck() {
		this.locator = initEndDateCheck;
		return this;
	}

	public MAAssingCourseP getSaveCourseButton() {
		this.locator = saveCourseButton;
		return this;
	}

	public MAAssingCourseP getSelectAssingSonCourse() {
		this.locator = selectAssingSonCourse;
		return this;
	}

	public MAAssingCourseP getSelectAssingSonCourseItem() {
		this.locator = selectAssingSonCourseItem;
		return this;
	}

	public MAAssingCourseP getInitEndDateAssingCheck() {
		this.locator = initEndDateAssingCheck;
		return this;
	}

	public MAAssingCourseP getChooseAssingFileButton() {
		this.locator = chooseAssingFileButton;
		return this;
	}

	public MAAssingCourseP getMenuContentButton() {
		this.locator = menuContentButton;
		return this;
	}

	public MAAssingCourseP getMenuStructureButton() {
		this.locator = menuStructureButton;
		return this;
	}

	public MAAssingCourseP getMenuAparienciaButton() {
		this.locator = menuAparienciaButton;
		return this;
	}

	public MAAssingCourseP getMenuAmpliarButton() {
		this.locator = menuAmpliarButton;
		return this;
	}

	public MAAssingCourseP getMenuConfigurationButton() {
		this.locator = menuConfigurationButton;
		return this;
	}

	public MAAssingCourseP getMenuUsersButton() {
		this.locator = menuUsersButton;
		return this;
	}

	public MAAssingCourseP getMenuReportButton() {
		this.locator = menuReportButton;
		return this;
	}

	public MAAssingCourseP getMenuHelpButton() {
		this.locator = menuHelpButton;
		return this;
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}

}
