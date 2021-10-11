package com.atc.seleniumframework.tests;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atc.seleniumframework.pages.SimplificaHomePage;
import com.atc.seleniumframework.pages.LoginSharpIdPage;
import com.atc.seleniumframework.pages.SSOLandingPage;
import com.atc.seleniumframework.testbase.CsvDataProviders;
import com.atc.seleniumframework.testbase.TestBase;
import com.atc.seleniumframework.testbase.TestUtilities;

public class PositiveLoginTests extends TestUtilities {

	SSOLandingPage ssoLandingPage;
	LoginSharpIdPage loginSharpIdPage;
	SimplificaHomePage simplificaLandingPage;

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void logInTest(Map<String, String> testData) {
		SoftAssert softAssert = new SoftAssert();
		log.info("Starting Login Test");

		// Data
		String no = testData.get("no");
		String sharpID = testData.get("sharpID");
		String password = testData.get("password");
		String expectedSuccessMessage = testData.get("expectedMessage");
		String description = testData.get("description");

		// open main page
		ssoLandingPage = new SSOLandingPage(factory.getDriver(), log);
		ssoLandingPage.openPage();

		/** takeScreenshot("SSOLandingPage opened", factory.getDriver()); **/

		// click on sharId button
		loginSharpIdPage = ssoLandingPage.loginBySharId();

		// enter credentials
		simplificaLandingPage = loginSharpIdPage.login(sharpID, password);

		// verification // new page URL is expected
		softAssert.assertEquals(landingPage.getCurrentUrl(), landingPage.getPageUrl(), "[Page url is not equal]");

		// profile button is visible
		softAssert.assertTrue(landingPage.profileMenuButtonVisible(), "Profile button is not visible");

		// Successful log in message
		String actualSuccessMessage = landingPage.getTitleText();
		softAssert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualMessage does not contain expectedMessage\nexpectedMessage: " + expectedSuccessMessage
						+ "\nactualMessage: " + actualSuccessMessage + "\n");

		softAssert.assertAll();

	}
}
