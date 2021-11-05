package com.tribu.qaselenium.pages.beerpassion;

import org.openqa.selenium.By;

import com.tribu.qaselenium.testframework.pagebase.BasePO;

public class BPHomeP extends BasePO<BPHomeP> {
	private final String pageUrl = "https://beerpassionperu-stage.somosmaz.com/landing";
	protected String xpathPartBanner = "//div[@class='carousel slide']//a/img[contains(@alt,'";

	private By title = By
			.xpath("/html//div[@class='main-pe']//div[.='¡Te damos la bienvenida a nuestra Intranet BU Perú,']");
	private By menuButton = By
			.xpath("//div[@id='offcanvasExample']//a[@role='button']/i[@class='bi bi-list nav_icon']");
	private By homeButton = By
			.xpath("//div[@id='offcanvasExample']/ul[@class='navbar-nav']//i[@class='bi bi-house-door-fill nav_icon']");
	private By supportButton = By
			.xpath("//div[@id='offcanvasExample']/ul[@class='navbar-nav']//i[@class='bi bi-headset nav_icon']");
	private By exitButton = By
			.xpath("//div[@id='offcanvasExample']/ul[@class='navbar-nav']//a[@class='logout nav-link']/i");
	private By profileButton = By.xpath("/html//header[@id='header']//a[@href='/profile']/img");
	private By notificationButton = By
			.xpath("/html//header[@id='header']/div[@class='container-fluid']//i[@class='bi bi-bell-fill']");
	private By BPLogo = By.xpath("/html//header[@id='header']//a[@href='/landing']/img[contains(@src,'/logo_h.png')]");
	private By privacyPolicy = By.xpath("/html//div[@id='root']//a[contains(@href,'PROTECCION')]");
	private By termsConditions = By.xpath("/html//div[@id='root']//a[contains(@href,'CONDICIONES%')]");

	
	public BPHomeP getTitle() {
		this.locator = title;
		return this;
	}

	public BPHomeP getMenuButton() {
		this.locator = menuButton;
		return this;
	}

	public BPHomeP getHomeButton() {
		this.locator = homeButton;
		return this;
	}

	public BPHomeP getSupportButton() {
		this.locator = supportButton;
		return this;
	}

	public BPHomeP getExitButton() {
		this.locator = exitButton;
		return this;
	}

	public BPHomeP getProfileButton() {
		this.locator = profileButton;
		return this;
	}

	public BPHomeP getNotificationButton() {
		this.locator = notificationButton;
		return this;
	}

	public BPHomeP getBPLogo() {
		this.locator = BPLogo;
		return this;
	}

	public BPHomeP getPrivacyPolicy() {
		this.locator = privacyPolicy;
		return this;
	}

	public BPHomeP getTermsConditions() {
		this.locator = termsConditions;
		return this;
	}

	// charge in xpathPart the xpart part of the locator
	public BPHomeP getXpathPartBanner() {
		this.xpathPart = xpathPartBanner;
		return this;
	}
	
	// div[@class="carousel
	// slide"]//a/img[@alt='test-load-banner-20211103-212922605']

	@Override
	public String getPageUrl() {
		return pageUrl;
	}

}
