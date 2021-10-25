package com.tribu.qaselenium.tests;

import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.pages.LoginSharpIdPage;
import com.tribu.qaselenium.pages.SSOLandingPage;
import com.tribu.qaselenium.pages.SimplificaHomePage;
import com.tribu.qaselenium.testframework.testbase.CsvDataProviders;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

@Listeners(TestsListenerManager.class)
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
		ssoLandingPage = new SSOLandingPage();
		openUrl(ssoLandingPage,driverFactory.getDriver());

		// click on sharId button
		loginSharpIdPage = ssoLandingPage.loginBySharId(driverFactory.getDriver());

		// enter credentials
		simplificaHomePage = loginSharpIdPage.login(driverFactory.getDriver(),sharpID, password);

		// verification // new page URL is expected
		softAssert.assertEquals(simplificaHomePage.getCurrentUrl(driverFactory.getDriver()), simplificaHomePage.getPageUrl(),
				"[Page url is not equal]");

		// profile button is visible
		softAssert.assertTrue(simplificaHomePage.profileMenuButtonVisible(driverFactory.getDriver()),
				"Profile button is not visible");

		// Successful log in message
		String actualSuccessMessage = simplificaHomePage.getTitleText(driverFactory.getDriver());
		softAssert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualMessage does not contain expectedMessage\nexpectedMessage: " + expectedSuccessMessage
						+ "\nactualMessage: " + actualSuccessMessage + "\n");

		softAssert.assertAll();
	}
}
