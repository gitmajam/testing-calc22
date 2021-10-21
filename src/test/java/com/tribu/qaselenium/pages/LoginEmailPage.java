package com.tribu.qaselenium.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.tribu.qaselenium.testframework.pagebase.BasePageObject;

public class LoginEmailPage extends BasePageObject {

	private String pageUrl = "https://auth-stage.somosmaz.com";

	public LoginEmailPage(WebDriver driver, Logger log) {
		super(log);
	}

}
