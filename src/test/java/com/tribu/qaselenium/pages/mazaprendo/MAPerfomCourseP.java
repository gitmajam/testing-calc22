package com.tribu.qaselenium.pages.mazaprendo;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.base.Predicate;
import com.tribu.qaselenium.testframework.pagebase.BasePO;
import com.tribu.qaselenium.testframework.pagebase.GUtils;

public class MAPerfomCourseP extends BasePO<MAPerfomCourseP> {
	
	private String pageUrl = "https://api-beerambassador-stage.somosmaz.com/user/36";

	private By menuContentButton = By.xpath("//li/a[contains(@href,'/admin/content')]");
	private By menuStructureButton = By.xpath("/html//a[@id='toolbar-link-system-admin_structure']");
	private By menuAparienciaButton = By.xpath("//div//a[contains(@href,'/admin/appearance')]");
	private By menuAmpliarButton = By.xpath("//div//a[contains(@href,'/admin/modules')]");
	private By menuConfigurationButton = By.xpath("//div//a[contains(@href,'/admin/config')]");
	private By menuUsersButton = By.xpath("//div//a[contains(@href,'/admin/people')]");
	private By menuReportButton = By.xpath("//div//a[contains(@href,'/admin/reports')]");
	private By menuHelpButton = By.xpath("/html//a[@id='toolbar-link-help-main']");
	private By profileButton = By.xpath("/html//a[@id='dropdownUser1']");
	private By learningButton = By.xpath("/html//header[@id='site-header']/div/div/ul//a[contains(@href,'/my-learning')]");
	private By appLogo = By.xpath("//header[@id='site-header']/div/div/a//img");
	private By termsConditionsButton = By
			.xpath("//footer[@id='site-footer']//a[@title='Política de privacidad - Términos y Condiciones']");
	private By searchButton = By.xpath("/html//header[@id='site-header']//i[@class='bi bi-search']");
	private By searchField = By.xpath("//form[@id='collapseExample']/input[@type='search']");
	private By startCourseButton = By.xpath("//div//div//section//div[2]/a[contains(text(),'ar')]");
	private By continuarPopupButton = By.xpath("/html//div[@id='mainModal']/div/div/div[3]/button[2]");
	private By iframe = By.tagName("iframe");
	private By frame = By.xpath("//frameset[@id='trivTitleMgrFrameset']/frame[@name='contentframe']");
	private By playVideoButton = By.xpath("//body//button[@title = 'Play']");
	private By pauseVideoButton = By.xpath("//body//button[@title = 'Pause']");
	private By contentCourseList = By
			.xpath("//div[@id='collapseMenu']/ul[@class='list-unstyled ps-0']//i[@class='bi bi-caret-down-fill']");
	private By lesson1Item = By.xpath("//div[@id='collapseMenu']/ul/li/div/ul/li[1]");
	private By lesson2Item = By.xpath("//div[@id='collapseMenu']/ul/li/div/ul/li[2]");
	private By lesson3Item = By.xpath("//div[@id='collapseMenu']/ul/li/div/ul/li[3]");
	private By video = By.xpath("//video");
	private By aceptarQuizButton = By.xpath("//body//div[5]/div");
	private By quizAttemps = By.xpath("//body//div[4]//div/p/span/span");
	private By quizAnswerA = By.xpath("//body//fieldset/div[3]//input");
	private By quizAnswerB = By.xpath("//body//fieldset/div[5]//input");
	private By quizAnswerC = By.xpath("//body//fieldset/div[7]//input");
	private By nextQuizQuestion = By.xpath("//body/div/div[3]/div");
	private By nps10 = By.xpath(
			"/html//div[@id='lesson_nps_container']/section/div/div[3]/div[@class='course-rating--scale']/div[2]/button[11]");
	private By npsComents = By
			.xpath("/html//div[@id='lesson_nps_container']/section/div/div[3]/div/div/textarea[@name='comments']");
	private By sendQuizButton = By.xpath("/html//button[@id='course_nps_button_send']");
	private By CourseProgress = By.xpath("//div/section/div/div[2]/*[name()='svg']/*[name()='text']");
	private By backQuizImg = By.xpath("//body/div/div/img");
	private By leccionTitle = By.xpath("/html//div[@id='block-mazaprendotheme-content']/div/div[2]/section//h2");
	private By courseTitle = By.xpath("//section/div/div/h3");
	private By seeVideoButton = By.xpath("//body/div/div[3]");
	private By testButton = By.xpath("//body/div/div[4]");
	private By lessonsButton = By.xpath("//div[@class='visualizator']//div[@id='collapseMenu']//button");
	private By lessonsList = By.xpath("//div[@class='visualizator']//ul[@id='ul-home-collapse']/li/a");
	private By modalMessage = By.xpath("//div[contains(@class,'modal')]//div[@id='modal_message']");
	private By modalCloseButton = By.xpath("//div[contains(@class,'modal')]//div[@class='modal-header']/button");
	private By evidenceButton = By.xpath("//input[@id='archivoSoporte']");
	private By evidenceFormText = By.xpath("//div[@id='evidence_files']");
	private By evidencesList = By.xpath("//ul[@id='files_list']/li");
	private By deleteFileButton = By.xpath(".//button[@class='delete_file']");
	
	public MAPerfomCourseP getDeleteFileButton(Predicate<WebElement>... predicates){
	this.setWebElement(deleteFileButton,predicates);
	return this;
	}

	public MAPerfomCourseP getEvidenceFormText(Predicate<WebElement>... predicates){
	this.setWebElement(evidenceFormText,predicates);
	return this;
	}
	
	public MAPerfomCourseP getCourseTitle(Predicate<WebElement>... predicates){
	this.setWebElement(courseTitle,predicates);
	return this;
	}
	
	public MAPerfomCourseP getMenuContentButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuContentButton,predicates);
	return this;
	}

	public MAPerfomCourseP getMenuStructureButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuStructureButton,predicates);
	return this;
	}

	public MAPerfomCourseP getMenuAparienciaButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuAparienciaButton,predicates);
	return this;
	}

	public MAPerfomCourseP getMenuAmpliarButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuAmpliarButton,predicates);
	return this;
	}

	public MAPerfomCourseP getMenuConfigurationButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuConfigurationButton,predicates);
	return this;
	}

	public MAPerfomCourseP getMenuUsersButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuUsersButton,predicates);
	return this;
	}

	public MAPerfomCourseP getMenuReportButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuReportButton,predicates);
	return this;
	}

	public MAPerfomCourseP getMenuHelpButton(Predicate<WebElement>... predicates){
	this.setWebElement(menuHelpButton,predicates);
	return this;
	}

	public MAPerfomCourseP getProfileButton(Predicate<WebElement>... predicates){
	this.setWebElement(profileButton,predicates);
	return this;
	}

	public MAPerfomCourseP getLearningButton(Predicate<WebElement>... predicates){
	this.setWebElement(learningButton,predicates);
	return this;
	}

	public MAPerfomCourseP getAppLogo(Predicate<WebElement>... predicates){
	this.setWebElement(appLogo,predicates);
	return this;
	}

	public MAPerfomCourseP getTermsConditionsButton(Predicate<WebElement>... predicates){
	this.setWebElement(termsConditionsButton,predicates);
	return this;
	}

	public MAPerfomCourseP getSearchButton(Predicate<WebElement>... predicates){
	this.setWebElement(searchButton,predicates);
	return this;
	}

	public MAPerfomCourseP getSearchField(Predicate<WebElement>... predicates){
	this.setWebElement(searchField,predicates);
	return this;
	}

	public MAPerfomCourseP getStartCourseButton(Predicate<WebElement>... predicates){
	this.setWebElement(startCourseButton,predicates);
	return this;
	}

	public MAPerfomCourseP getContinuarPopupButton(Predicate<WebElement>... predicates){
	this.setWebElement(continuarPopupButton,predicates);
	return this;
	}

	public MAPerfomCourseP getIframe(Predicate<WebElement>... predicates){
	this.setWebElement(iframe,predicates);
	return this;
	}

	public MAPerfomCourseP getFrame(Predicate<WebElement>... predicates){
	this.setWebElement(frame,predicates);
	return this;
	}

	public MAPerfomCourseP getPlayVideoButton(Predicate<WebElement>... predicates){
	this.setWebElement(playVideoButton,predicates);
	return this;
	}

	public MAPerfomCourseP getPauseVideoButton(Predicate<WebElement>... predicates){
	this.setWebElement(pauseVideoButton,predicates);
	return this;
	}

	public MAPerfomCourseP getContentCourseList(Predicate<WebElement>... predicates){
	this.setWebElement(contentCourseList,predicates);
	return this;
	}

	public MAPerfomCourseP getLesson1Item(Predicate<WebElement>... predicates){
	this.setWebElement(lesson1Item,predicates);
	return this;
	}

	public MAPerfomCourseP getLesson2Item(Predicate<WebElement>... predicates){
	this.setWebElement(lesson2Item,predicates);
	return this;
	}

	public MAPerfomCourseP getLesson3Item(Predicate<WebElement>... predicates){
	this.setWebElement(lesson3Item,predicates);
	return this;
	}

	public MAPerfomCourseP getVideo(Predicate<WebElement>... predicates){
	this.setWebElement(video,predicates);
	return this;
	}

	public MAPerfomCourseP getAceptarQuizButton(Predicate<WebElement>... predicates){
	this.setWebElement(aceptarQuizButton,predicates);
	return this;
	}

	public MAPerfomCourseP getQuizAttemps(Predicate<WebElement>... predicates){
	this.setWebElement(quizAttemps,predicates);
	return this;
	}

	public MAPerfomCourseP getQuizAnswerA(Predicate<WebElement>... predicates){
	this.setWebElement(quizAnswerA,predicates);
	return this;
	}

	public MAPerfomCourseP getQuizAnswerB(Predicate<WebElement>... predicates){
	this.setWebElement(quizAnswerB,predicates);
	return this;
	}

	public MAPerfomCourseP getQuizAnswerC(Predicate<WebElement>... predicates){
	this.setWebElement(quizAnswerC,predicates);
	return this;
	}

	public MAPerfomCourseP getNextQuizQuestion(Predicate<WebElement>... predicates){
	this.setWebElement(nextQuizQuestion,predicates);
	return this;
	}

	public MAPerfomCourseP getNps10(Predicate<WebElement>... predicates){
	this.setWebElement(nps10,predicates);
	return this;
	}

	public MAPerfomCourseP getNpsComents(Predicate<WebElement>... predicates){
	this.setWebElement(npsComents,predicates);
	return this;
	}

	public MAPerfomCourseP getSendQuizButton(Predicate<WebElement>... predicates){
	this.setWebElement(sendQuizButton,predicates);
	return this;
	}

	public MAPerfomCourseP getCourseProgress(Predicate<WebElement>... predicates){
	this.setWebElement(CourseProgress,predicates);
	return this;
	}

	public MAPerfomCourseP getBackQuizImg(Predicate<WebElement>... predicates){
	this.setWebElement(backQuizImg,predicates);
	return this;
	}

	public MAPerfomCourseP getLeccionTitle(Predicate<WebElement>... predicates){
	this.setWebElement(leccionTitle,predicates);
	return this;
	}

	public MAPerfomCourseP getSeeVideoButton(Predicate<WebElement>... predicates){
	this.setWebElement(seeVideoButton,predicates);
	return this;
	}

	public MAPerfomCourseP getTestButton(Predicate<WebElement>... predicates){
	this.setWebElement(testButton,predicates);
	return this;
	}

	public MAPerfomCourseP getLessonsButton(Predicate<WebElement>... predicates){
	this.setWebElement(lessonsButton,predicates);
	return this;
	}

	public MAPerfomCourseP getLessonsList(Predicate<WebElement>... predicates){
	this.setWebElement(lessonsList,predicates);
	return this;
	}

	public MAPerfomCourseP getModalMessage(Predicate<WebElement>... predicates){
	this.setWebElement(modalMessage,predicates);
	return this;
	}

	public MAPerfomCourseP getModalCloseButton(Predicate<WebElement>... predicates){
	this.setWebElement(modalCloseButton,predicates);
	return this;
	}

	public MAPerfomCourseP getEvidenceButton(Predicate<WebElement>... predicates){
	this.setWebElement(evidenceButton,predicates);
	return this;
	}

	public MAPerfomCourseP getEvidencesList(Predicate<WebElement>... predicates){
	this.setWebElement(evidencesList,predicates);
	return this;
	}
	
	public MAPerfomCourseP closeModal() {
		this.getModalCloseButton().click();
		return this;
	}

	@SuppressWarnings("unchecked")
	public MAPerfomCourseP uploadEvidence() {
				getEvidenceButton().type(resourcesPath + "media" + File.separator + "image" + File.separator + "Test-miniImage1.jpeg",1000)
				.getEvidenceButton().type(resourcesPath + "media" + File.separator + "pdf" + File.separator + "certs.pdf",1000)	
				.getEvidenceButton().type(resourcesPath + "uploadFiles" + File.separator + "upload.xlsx",1000);
			return this;
	}
	
	@Override
	public String getPageUrl() {
		return pageUrl;
	}

}
