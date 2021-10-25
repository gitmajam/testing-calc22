package com.tribu.qaselenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tribu.qaselenium.testframework.pagebase.BasePageObject;

public class SimplificaHomePage extends BasePageObject {

	private String pageUrl = "https://auth-stage.somosmaz.com/es/user";
	private By profileMenuButton = By.xpath("//button[@id = 'dropdownMenuButton']");
	private By title = By.xpath("//div[contains(text(),'Simplifica Hub')]");

	/** Return text from title **/
	public String getTitleText(WebDriver driver) {
		return driver.findElement(title).getText().trim();
	}

	public String getPageUrl() {
		return pageUrl;
	}

	/** Verification if profile button is visible on the page **/
	public boolean profileMenuButtonVisible(WebDriver driver) {
		return driver.findElement(profileMenuButton).isDisplayed();
	}

	public void clickProfileMenuButton(WebDriver driver) {
		click(driver,profileMenuButton);
	}
}
