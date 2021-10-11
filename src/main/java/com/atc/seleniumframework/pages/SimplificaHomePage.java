package com.atc.seleniumframework.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SimplificaHomePage extends BasePageObject {

	private By profileMenuButton = By.xpath("//button[@id = 'dropdownMenuButton']");
	private By title = By.xpath("//div[contains(text(),'Simplifica Hub')]");
	private String pageUrl = "https://auth-dev.somosmaz.com/es/user";

	public SimplificaHomePage(WebDriver driver, Logger log) {
		super(driver, log);
		log.info("Executing landing page: "+ driver.hashCode());
	}

	/** Return text from success message **/
	public String getTitleText() {
		return find(title).getText().trim();
	}
	/**Get URL variable from PageObject**/
	public String getPageUrl() {
		return this.pageUrl;
	}

	/** Verification if profile button is visible on the page **/
	public boolean profileMenuButtonVisible() {
		return find(profileMenuButton).isDisplayed();
	}
	
	public void clickProfileMenuButton() {
		click(profileMenuButton);
	}
}
