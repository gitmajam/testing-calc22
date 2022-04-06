package com.tribu.qaselenium.pages.mazaprendo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Predicate;
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
	
	public MAAssingCourseP getMenuContentButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuContentButton,predicates);
	return this;
	}

	public MAAssingCourseP getMenuStructureButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuStructureButton,predicates);
	return this;
	}

	public MAAssingCourseP getMenuAparienciaButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuAparienciaButton,predicates);
	return this;
	}

	public MAAssingCourseP getMenuAmpliarButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuAmpliarButton,predicates);
	return this;
	}

	public MAAssingCourseP getMenuConfigurationButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuConfigurationButton,predicates);
	return this;
	}

	public MAAssingCourseP getMenuUsersButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuUsersButton,predicates);
	return this;
	}

	public MAAssingCourseP getMenuReportButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuReportButton,predicates);
	return this;
	}

	public MAAssingCourseP getMenuHelpButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuHelpButton,predicates);
	return this;
	}

	public MAAssingCourseP getCreateCourse(Predicate<WebElement>... predicates){
	this.setWebElement(createCourse,predicates);
	return this;
	}

	public MAAssingCourseP getEditCourse(Predicate<WebElement>... predicates){
	this.setWebElement(editCourse,predicates);
	return this;
	}

	public MAAssingCourseP getAssingCourse(Predicate<WebElement>... predicates){
	this.setWebElement(assingCourse,predicates);
	return this;
	}

	public MAAssingCourseP getSelectCourse(Predicate<WebElement>... predicates){
	this.setWebElement(selectCourse,predicates);
	return this;
	}

	public MAAssingCourseP getSelectCourseItem(Predicate<WebElement>... predicates){
	this.setWebElement(selectCourseItem,predicates);
	return this;
	}

	public MAAssingCourseP getTitleSonCourse(Predicate<WebElement>... predicates){
	this.setWebElement(titleSonCourse,predicates);
	return this;
	}

	public MAAssingCourseP getInitEndDateCheck(Predicate<WebElement>... predicates){
	this.setWebElement(initEndDateCheck,predicates);
	return this;
	}

	public MAAssingCourseP getSaveCourseButton(Predicate<WebElement>... predicates){
	this.setWebElement(saveCourseButton,predicates);
	return this;
	}

	public MAAssingCourseP getSelectAssingSonCourse(Predicate<WebElement>... predicates){
	this.setWebElement(selectAssingSonCourse,predicates);
	return this;
	}

	public MAAssingCourseP getSelectAssingSonCourseItem(Predicate<WebElement>... predicates){
	this.setWebElement(selectAssingSonCourseItem,predicates);
	return this;
	}

	public MAAssingCourseP getInitEndDateAssingCheck(Predicate<WebElement>... predicates){
	this.setWebElement(initEndDateAssingCheck,predicates);
	return this;
	}

	public MAAssingCourseP getUploadAssingFile(Predicate<WebElement>... predicates){
	this.setWebElement(uploadAssingFile,predicates);
	return this;
	}

	public MAAssingCourseP getAssignCourseButton(Predicate<WebElement>... predicates){
	this.setWebElement(assignCourseButton,predicates);
	return this;
	}

	public MAAssingCourseP getRegValidationText(Predicate<WebElement>... predicates){
	this.setWebElement(regValidationText,predicates);
	return this;
	}

	public MAAssingCourseP getTeacherOption(Predicate<WebElement>... predicates){
	this.setWebElement(teacherOption,predicates);
	return this;
	}

	public MAAssingCourseP getEvidenceOption(Predicate<WebElement>... predicates){
	this.setWebElement(evidenceOption,predicates);
	return this;
	}

	public MAAssingCourseP getFeedbackOption(Predicate<WebElement>... predicates){
	this.setWebElement(feedbackOption,predicates);
	return this;
	}

	public MAAssingCourseP getDatekOption(Predicate<WebElement>... predicates){
	this.setWebElement(datekOption,predicates);
	return this;
	}

	public MAAssingCourseP getTeacherSharpId(Predicate<WebElement>... predicates){
	this.setWebElement(teacherSharpId,predicates);
	return this;
	}

	public MAAssingCourseP getCheckTeacherSharpIdButton(Predicate<WebElement>... predicates){
	this.setWebElement(checkTeacherSharpIdButton,predicates);
	return this;
	}

	public MAAssingCourseP getDateStart(Predicate<WebElement>... predicates){
	this.setWebElement(dateStart,predicates);
	return this;
	}

	public MAAssingCourseP getDateEnd(Predicate<WebElement>... predicates){
	this.setWebElement(dateEnd,predicates);
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
