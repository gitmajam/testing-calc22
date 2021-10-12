package com.atc.seleniumframework.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SimplificaHomePage extends BasePageObject {
	
	private String pageUrl = "https://auth-stage.somosmaz.com/es/user";
	
	@FindBy(xpath = "//button[@id = 'dropdownMenuButton']")
	private WebElement profileMenuButton;
	
	@FindBy(xpath = "//div[contains(text(),'Simplifica Hub')]")
	private WebElement title;
	
	public SimplificaHomePage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Return text from title **/
	public String getTitleText() {
		return title.getText().trim();
	}
	/**Get URL variable from PageObject**/
	public String getPageUrl() {
		return pageUrl;
	}

	/** Verification if profile button is visible on the page **/
	public boolean profileMenuButtonVisible() {
		return profileMenuButton.isDisplayed();
	}
	
	public void clickProfileMenuButton() {
		click(profileMenuButton);
	}
}
