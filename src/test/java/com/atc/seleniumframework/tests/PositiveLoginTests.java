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

public class PositiveLoginTests extends TestBase {

	SSOLandingPage ssoLandingPage;
	LoginSharpIdPage loginSharpIdPage;
	SimplificaHomePage simplificaHomePage;

	/*
	 * this method runs according the dataprovider parameter set, either in parallel
	 * or sequentially
	 */

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void logInTest(Map<String, String> testData) {

		/*
		 * this kind of assert does not stop the execution but lets execute the whole
		 * assertions
		 */
		SoftAssert softAssert = new SoftAssert();
		log.info("Starting Login Test");

		// Data from dataprovider
		String no = testData.get("no");
		String sharpID = testData.get("sharpID");
		String password = testData.get("password");
		String expectedSuccessMessage = testData.get("expectedMessage");
		String description = testData.get("description");

		// open main page
		ssoLandingPage = new SSOLandingPage(log);
		ssoLandingPage.openPage(factory.getDriver());
		
		/** takeScreenshot("SSOLandingPage opened", factory.getDriver()); **/

		// click on sharId button
		loginSharpIdPage = ssoLandingPage.loginBySharId(factory.getDriver());
		
		
		// enter credentials
		simplificaHomePage = loginSharpIdPage.login(factory.getDriver(),sharpID, password);

		// verification // new page URL is expected
		softAssert.assertEquals(simplificaHomePage.getCurrentUrl(factory.getDriver()), simplificaHomePage.getPageUrl(),
				"[Page url is not equal]");

		// profile button is visible
		softAssert.assertTrue(simplificaHomePage.profileMenuButtonVisible(factory.getDriver()), "Profile button is not visible");

		// Successful log in message
		String actualSuccessMessage = simplificaHomePage.getTitleText(factory.getDriver());
		softAssert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualMessage does not contain expectedMessage\nexpectedMessage: " + expectedSuccessMessage
						+ "\nactualMessage: " + actualSuccessMessage + "\n");

		softAssert.assertAll(); 
	}
}
