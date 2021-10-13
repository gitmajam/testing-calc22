package com.atc.seleniumframework.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SimplificaHomePage extends BasePageObject {

	private String pageUrl = "https://auth-stage.somosmaz.com/es/user";
	private By profileMenuButton = By.xpath("//button[@id = 'dropdownMenuButton']");
	private By title = By.xpath("//div[contains(text(),'Simplifica Hub')]");

	public SimplificaHomePage(WebDriver driver, Logger log) {
		super(log);
	}

	/** Return text from title **/
	public String getTitleText(WebDriver driver) {
		return driver.findElement(title).getText().trim();
	}

	/** Get URL variable from PageObject **/
	public String getPageUrl() {
		return pageUrl;
	}

	/** Verification if profile button is visible on the page **/
	public boolean profileMenuButtonVisible(WebDriver driver) {
		return driver.findElement(profileMenuButton).isDisplayed();
	}

	public void clickProfileMenuButton(WebDriver driver) {
		click(driver, profileMenuButton);
	}
}
