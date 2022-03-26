package com.tribu.qaselenium.pages.mazaprendo;

import org.openqa.selenium.By;

import com.tribu.qaselenium.testframework.pagebase.BasePO;
import com.tribu.qaselenium.testframework.testbase.PropertiesFile;
import com.tribu.qaselenium.tests.mazaprendo.data.UserCourseAssign;
import com.tribu.qaselenium.tests.mazaprendo.data.UserCourseAssignDAO;
import com.tribu.qaselenium.tests.mazaprendo.data.UserLessonAssign;
import com.tribu.qaselenium.tests.mazaprendo.data.UserLessonAssignDAO;

public class MAAssingCourseP extends BasePO<MAAssingCourseP> {
	private final String pageUrl = PropertiesFile.getProperties(PropertiesFile.getProperties("env") + "_ma_assing_url");
	private String xpathPart1 = "/html//select[@id='edit-type']/option[contains(text(),";
	private String xpathPart2 = "/html//select[@id='edit-type']/option[contains(text(),";

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
	private By selectCourse = By.xpath("/html//select[@id='edit-type']");
	private By selectCourseItem = By.xpath("/html//select[@id='edit-type']/option[contains(text(),'Test-Curso')]");
	private By titleSonCourse = By.xpath("/html//input[@id='input-title']");
	private By initEndDateCheck = By.xpath("/html//input[@id='input-date']");
	private By saveCourseButton = By.xpath("/html//input[@id='submit-save']");
	private By selectAssingSonCourse = By.xpath("/html//select[@id='edit-type']");
	private By selectAssingSonCourseItem = By
			.xpath("/html//select[@id='edit-type']/option[contains(text(),'Test-Son-Curso')]");
	private By initEndDateAssingCheck = By.xpath("/html//select[@id='edit-type']");
	private By uploadAssingFile = By.xpath("/html//input[@id='input-excel']");
	private By assignCourseButton = By.xpath("/html//input[@id='submit-save']");
	private By regValidationText = By.xpath("/html//table[@id='success_table']//td[4]");
	private By teacherOption = By.xpath("/html//input[@id='input-professor']");
	private By evidenceOption = By.xpath("/html//input[@id='input-evidence']");
	private By feedbackOption = By.xpath("/html//input[@id='input-feedback']");
	private By datekOption = By.xpath("/html//input[@id='input-date']");
	private By teacherSharpId = By.xpath("/html//input[@id='input-professor-id']");
	private By checkTeacherSharpIdButton = By.xpath("/html//input[@id='submit-professor-id']");
	private By dateStart = By.xpath("/html//input[@id='input-date-start']");
	private By dateEnd = By.xpath("/html//input[@id='input-date-end']");
	
	public MAAssingCourseP getDateStart() {
		this.locator = dateStart;
		return this;
	}

	public MAAssingCourseP getDateEnd() {
		this.locator = dateEnd;
		return this;
	}
	
	public MAAssingCourseP getDatekOption() {
		this.locator = datekOption;
		return this;
	}
	
	public MAAssingCourseP getTeacherSharpId() {
		this.locator = teacherSharpId;
		return this;
	}

	public MAAssingCourseP getCheckTeacherSharpIdButton() {
		this.locator = checkTeacherSharpIdButton;
		return this;
	}
	
	public MAAssingCourseP getTeacherOption() {
		this.locator = teacherOption;
		return this;
	}

	public MAAssingCourseP getEvidenceOption() {
		this.locator = evidenceOption;
		return this;
	}

	public MAAssingCourseP getFeedbackOption() {
		this.locator = feedbackOption;
		return this;
	}

	public MAAssingCourseP getAssignCourseButton() {
		this.locator = assignCourseButton;
		return this;
	}

	public MAAssingCourseP getRegValidationText() {
		this.locator = regValidationText;
		return this;
	}

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

	public MAAssingCourseP getUploadAssingFile() {
		this.locator = uploadAssingFile;
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

	// part xpath
	public MAAssingCourseP getXpathPart1(String locatorPart) {
		this.xpathPart = xpathPart1;
		By question = By.xpath(this.xpathPart + locatorPart);
		this.locator = question;
		return this;
	}

	public MAAssingCourseP getXpathPart2(String locatorPart) {
		this.xpathPart = xpathPart2;
		By question = By.xpath(this.xpathPart + locatorPart);
		this.locator = question;
		return this;
	}


	@Override
	public String getPageUrl() {
		return pageUrl;
	}

}
