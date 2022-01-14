package com.tribu.qaselenium.pages.mazaprendo;

import org.openqa.selenium.By;

import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class MAPerfomCourseP extends BasePO<MAPerfomCourseP> {

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
	private By startCourseButton = By.xpath("//div//div//section//div[2]/a[contains(text(),'ar')]");
	private By continuarPopupButton = By.xpath("/html//div[@id='mainModal']/div/div/div[3]/button[2]");
	private By iframe = By.tagName("iframe");
	private By frame = By.xpath("//frameset[@id='trivTitleMgrFrameset']/frame[@name='contentframe']");
	private By playVideoButton = By.xpath("//body//button[@title = 'Play']");
	private By pauseVideoButton = By.xpath("//body//button[@title = 'Pause']");
	private By contentCourseList = By.xpath("//div[@id='collapseMenu']/ul[@class='list-unstyled ps-0']//i[@class='bi bi-caret-down-fill']");
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
	private By nps10 = By.xpath("/html//div[@id='lesson_nps_container']/section/div/div[3]/div[@class='course-rating--scale']/div[2]/button[11]");
	private By npsComents = By.xpath("/html//div[@id='lesson_nps_container']/section/div/div[3]/div/div/textarea[@name='comments']");
	private By sendQuizButton = By.xpath("/html//button[@id='course_nps_button_send']");
	private By CourseProgress = By.xpath("//div/section/div/div[2]/*[name()='svg']/*[name()='text']");
	private By backQuizImg = By.xpath("//body/div/div/img");
	private By leccionTitle = By.xpath("/html//div[@id='block-mazaprendotheme-content']/div/div[2]/section//h2");
	private By seeVideoButton = By.xpath("//body/div/div[3]");
	private By testButton = By.xpath("//body/div/div[4]");
	
	public MAPerfomCourseP getLesson1Item() {
		this.locator = lesson1Item;
		return this;
	}

	public MAPerfomCourseP getLesson2Item() {
		this.locator = lesson2Item;
		return this;
	}

	public MAPerfomCourseP getLesson3Item() {
		this.locator = lesson3Item;
		return this;
	}
	
	public MAPerfomCourseP getSeeVideoButton() {
		this.locator = seeVideoButton;
		return this;
	}

	public MAPerfomCourseP getTestButton() {
		this.locator = testButton;
		return this;
	}

	public MAPerfomCourseP getLeccionTitle() {
		this.locator = leccionTitle;
		return this;
	}

	public MAPerfomCourseP getNps10() {
		this.locator = nps10;
		return this;
	}

	public MAPerfomCourseP getBackQuizImg() {
		this.locator = backQuizImg;
		return this;
	}

	public MAPerfomCourseP getNpsComents() {
		this.locator = npsComents;
		return this;
	}

	public MAPerfomCourseP getSendQuizButton() {
		this.locator = sendQuizButton;
		return this;
	}

	public MAPerfomCourseP getCourseProgress() {
		this.locator = CourseProgress;
		return this;
	}

	public MAPerfomCourseP getQuizAnswerC() {
		this.locator = quizAnswerC;
		return this;
	}

	public MAPerfomCourseP getQuizAnswerB() {
		this.locator = quizAnswerB;
		return this;
	}

	public MAPerfomCourseP getQuizAnswerA() {
		this.locator = quizAnswerA;
		return this;
	}

	public MAPerfomCourseP getNextQuizQuestion() {
		this.locator = nextQuizQuestion;
		return this;
	}

	public MAPerfomCourseP getQuizAttemps() {
		this.locator = quizAttemps;
		return this;
	}

	public MAPerfomCourseP getVideo() {
		this.locator = video;
		return this;
	}

	public MAPerfomCourseP getAceptarQuizButton() {
		this.locator = aceptarQuizButton;
		return this;
	}

	public MAPerfomCourseP getContentCourseList() {
		this.locator = contentCourseList;
		return this;
	}

	public MAPerfomCourseP getPauseVideoButton() {
		this.locator = pauseVideoButton;
		return this;
	}

	public MAPerfomCourseP getFrame() {
		this.locator = frame;
		return this;
	}
	
	public MAPerfomCourseP getIFrame() {
		this.locator = iframe;
		return this;
	}

	public MAPerfomCourseP getPlayVideoButton() {
		this.locator = playVideoButton;
		return this;
	}

	public MAPerfomCourseP getContinuarPopupButton() {
		this.locator = continuarPopupButton;
		return this;
	}

	public MAPerfomCourseP getStartCourseButton() {
		this.locator = startCourseButton;
		return this;
	}

	public MAPerfomCourseP getMenuContentButton() {
		this.locator = menuContentButton;
		return this;
	}

	public MAPerfomCourseP getMenuStructureButton() {
		this.locator = menuStructureButton;
		return this;
	}

	public MAPerfomCourseP getMenuAparienciaButton() {
		this.locator = menuAparienciaButton;
		return this;
	}

	public MAPerfomCourseP getMenuAmpliarButton() {
		this.locator = menuAmpliarButton;
		return this;
	}

	public MAPerfomCourseP getMenuConfigurationButton() {
		this.locator = menuConfigurationButton;
		return this;
	}

	public MAPerfomCourseP getMenuUsersButton() {
		this.locator = menuUsersButton;
		return this;
	}

	public MAPerfomCourseP getMenuReportButton() {
		this.locator = menuReportButton;
		return this;
	}

	public MAPerfomCourseP getMenuHelpButton() {
		this.locator = menuHelpButton;
		return this;
	}

	public MAPerfomCourseP getProfileButton() {
		this.locator = profileButton;
		return this;
	}

	public MAPerfomCourseP getLearningButton() {
		this.locator = learningButton;
		return this;
	}

	public MAPerfomCourseP getAppLogo() {
		this.locator = appLogo;
		return this;
	}

	public MAPerfomCourseP getTermsConditionsButton() {
		this.locator = termsConditionsButton;
		return this;
	}

	public MAPerfomCourseP getSearchButton() {
		this.locator = searchButton;
		return this;
	}

	public MAPerfomCourseP getSearchField() {
		this.locator = searchField;
		return this;
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}

}
