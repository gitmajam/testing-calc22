package com.tribu.qaselenium.pages.mazaprendo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.base.Predicate;
import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class MAMyCoursesP extends BasePO<MAMyCoursesP> {

	private By profileButton = By.xpath("/html//a[@id='dropdownUser1']");
	private By learningButton = By.xpath("/html//header[@id='site-header']/div/div/ul//a[contains(@href,'/my-learning')]");
	private By appLogo = By.xpath("//header[@id='site-header']/div/div/a//img");
	private By termsConditionsButton = By
			.xpath("//footer[@id='site-footer']//a[@title='Política de privacidad - Términos y Condiciones']");
	private By coursesList = By.xpath("//div[contains(@class,'sidebar')]//ul/li");
	private By tabList = By.xpath("//section/div//nav/div/button");
	private By itemsList = By.xpath("//section/div[contains(@id,'teacher-content')]//div/ul/li");
	private By feedback = By.xpath(".//ul/li");
	private By evidenceLink = By.xpath(".//a/span");
	private By downloadGuide = By.xpath(
			"//div[@id='block-mazaprendotheme-content']/div[@class='content']/div[3]/section/div[2]//a[contains(@href,'http://')]");
	private By teacherComments = By.xpath("//div[@id='nav-tabContent']/div[2]/ul/li//textarea");
	private By saveButton = By.xpath(".//div[2]/button");
	private By continueButton = By.xpath("//button[@id='modal_continue']");
	private By score = By.xpath(".//input[contains(@name,'score')]");
	private By closeCourse = By.xpath("//button");
	private By closeCourse2 = By.xpath("//button");
	
	public MAMyCoursesP getEvidenceLink(Predicate<WebElement>... predicates){
	this.setWebElement(evidenceLink,predicates);
	return this;
	}
	
	public MAMyCoursesP getCloseCourse2(Predicate<WebElement>... predicates){
	this.setWebElement(closeCourse2,predicates);
	return this;
	}

	public MAMyCoursesP getCloseCourse(Predicate<WebElement>... predicates) {
		this.setWebElement(closeCourse, predicates);
		return this;
	}
	
	public MAMyCoursesP getContinueButton(Predicate<WebElement>... predicates) {
		this.setWebElement(continueButton, predicates);
		return this;
	}
	
	public MAMyCoursesP getFeedback(Predicate<WebElement>... predicates) {
		this.setWebElement(feedback, predicates);
		return this;
	}

	public MAMyCoursesP getTeacherComments(Predicate<WebElement>... predicates) {
		this.setWebElement(teacherComments, predicates);
		return this;
	}

	public MAMyCoursesP getSaveButton(Predicate<WebElement>... predicates) {
		this.setWebElement(saveButton, predicates);
		return this;
	}

	public MAMyCoursesP getScore(Predicate<WebElement>... predicates) {
		this.setWebElement(score, predicates);
		return this;
	}

	public MAMyCoursesP getCoursesList(Predicate<WebElement>... predicates) {
		this.setWebElement(coursesList, predicates);
		return this;
	}

	public MAMyCoursesP getTabList(Predicate<WebElement>... predicates) {
		this.setWebElement(tabList, predicates);
		return this;
	}

	public MAMyCoursesP getItemsList(Predicate<WebElement>... predicates) {
		this.setWebElement(itemsList, predicates);
		return this;
	}

	public MAMyCoursesP getDownloadGuide(Predicate<WebElement>... predicates) {
		this.setWebElement(downloadGuide, predicates);
		return this;
	}

	public MAMyCoursesP getProfileButton(Predicate<WebElement>... predicates) {
		this.setWebElement(profileButton, predicates);
		return this;
	}

	public MAMyCoursesP getLearningButton(Predicate<WebElement>... predicates) {
		this.setWebElement(learningButton, predicates);
		return this;
	}

	public MAMyCoursesP getAppLogo(Predicate<WebElement>... predicates) {
		this.setWebElement(appLogo, predicates);
		return this;
	}

	public MAMyCoursesP getTermsConditionsButton(Predicate<WebElement>... predicates) {
		this.setWebElement(termsConditionsButton, predicates);
		return this;
	}

	@Override
	public String getPageUrl() {
		// TODO Auto-generated method stub
		return null;
	}

}
