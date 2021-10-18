package com.tribu.seleniumframework.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.seleniumframework.pages.LoginSharpIdPage;
import com.tribu.seleniumframework.pages.SSOLandingPage;
import com.tribu.seleniumframework.pages.SimplificaHomePage;
import com.tribu.seleniumframework.testbase.CsvDataProviders;
import com.tribu.seleniumframework.testbase.TestBase;
import com.tribu.seleniumframework.testbase.TestsListenerManager;
import com.tribu.seleniumframework.testbase.TestUtilities;

@Listeners(TestsListenerManager.class)
public class NegativeLoginTests extends TestBase {

	SSOLandingPage ssoLandingPage;
	LoginSharpIdPage loginSharpIdPage;
	SimplificaHomePage simplificaHomePage;

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void negativeLoginTest(Map<String, String> testData) {
		SoftAssert softAssert = new SoftAssert();

		// Data
		String no = testData.get("no");
		String sharpID = testData.get("sharpID");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedMessage");
		String description = testData.get("description");

		log.info("Starting negativeLoginTest #" + no + "for" + description);

		/// open main page SSOLandingPage
		ssoLandingPage = new SSOLandingPage(log);
		ssoLandingPage.openPage(factory.getDriver());

		// click on sharId button
		loginSharpIdPage = ssoLandingPage.loginBySharId(factory.getDriver());

		// enter credentials
		loginSharpIdPage.negativelogin(factory.getDriver(), sharpID, password);

		// wait for error message
		loginSharpIdPage.waitForErrorMessage(factory.getDriver());
		String actualErrorMessage = loginSharpIdPage.getErrorMessageText(factory.getDriver());

		// Verification // error message
		softAssert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"actualMessage does not contain expectedMessage\nexpectedMessage: " + expectedErrorMessage
						+ "\nactualMessage: " + actualErrorMessage + "\n");

		softAssert.assertAll();

	}
}
