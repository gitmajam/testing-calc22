package com.tribu.qaselenium.pages.apiba;

import org.openqa.selenium.By;

import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class APIHomeP extends BasePO<APIHomeP> {

	private String pageUrl = "https://api-beerambassador-stage.somosmaz.com/user/36";

	private By title = By.xpath("//div/a[contains(text(),'Beer ambassador API')]");
	private By profileMenuButton = By.xpath("//li/a[contains(text(),'Mi cuenta')]");
	private By menuContentButton = By.xpath("//li/a[@href='/admin/content']");
	private By addContentButton = By.xpath("//li/a[@href='/node/add']");
	private By addBanner = By.xpath("//ul[@class='toolbar-menu']//a[@href='/node/add/content_banner']");
	private By addwellnessEvent = By.xpath("//div/ul[@class='toolbar-menu']//a[@href='/node/add/bienestar_eventos']");
	private By addwellnessPillar = By.xpath("//div/ul[@class='toolbar-menu']//a[@href='/node/add/bienestar_pilares']");
	private By addWellnessProgram = By
			.xpath("//div/ul[@class='toolbar-menu']//a[@href='/node/add/bienestar_programas']");
	private By addDiversityArticle = By
			.xpath("//div/ul[@class='toolbar-menu']//a[@href='/node/add/diversidad_articulos']");
	private By addHubApp = By.xpath("//div/ul[@class='toolbar-menu']//a[@href='/node/add/hub']");
	private By addInfographics = By.xpath("//div/ul[@class='toolbar-menu']//a[@href='/node/add/infografia']");
	private By addLinkList = By.xpath("//div/ul[@class='toolbar-menu']//a[@href='/node/add/content']");
	private By addBrandRef = By.xpath("//div/ul[@class='toolbar-menu']//a[@href='/node/add/referencia_marca']");
	private By addVideo = By.xpath("//div/ul[@class='toolbar-menu']//a[@href='/node/add/video']");

	public APIHomeP getTitle() {
		this.locator = title;
		return this;
	}

	public APIHomeP getProfileMenuButton() {
		this.locator = profileMenuButton;
		return this;
	}

	public APIHomeP getMenuContentButton() {
		this.locator = menuContentButton;
		return this;
	}

	public APIHomeP getAddContentButton() {
		this.locator = addContentButton;
		return this;
	}

	public APIHomeP getAddBanner() {
		this.locator = addBanner;
		return this;
	}

	public APIHomeP getAddwellnessEvent() {
		this.locator = addwellnessEvent;
		return this;
	}

	public APIHomeP getAddwellnessPillar() {
		this.locator = addwellnessPillar;
		return this;
	}

	public APIHomeP getAddWellnessProgram() {
		this.locator = addWellnessProgram;
		return this;
	}

	public APIHomeP getAddDiversityArticle() {
		this.locator = addDiversityArticle;
		return this;
	}

	public APIHomeP getAddHubApp() {
		this.locator = addHubApp;
		return this;
	}

	public APIHomeP getAddInfographics() {
		this.locator = addInfographics;
		return this;
	}

	public APIHomeP getAddLinkList() {
		this.locator = addLinkList;
		return this;
	}

	public APIHomeP getAddBrandRef() {
		this.locator = addBrandRef;
		return this;
	}

	public APIHomeP getAddVideo() {
		this.locator = addVideo;
		return this;
	}

	@Override
	public String getPageUrl() {
		return pageUrl;
	}

}
