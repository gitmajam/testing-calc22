package com.atc.seleniumframework.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.atc.seleniumframework.pages.LoginSharpIdPage;
import com.atc.seleniumframework.pages.SSOLandingPage;
import com.atc.seleniumframework.testbase.CsvDataProviders;
import com.atc.seleniumframework.testbase.TestBase;
import com.atc.seleniumframework.testbase.TestUtilities;

public class NegativeLoginTests extends TestUtilities {

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

		/// open main page
		SSOLandingPage welcomePage = new SSOLandingPage(factory.getDriver(), log);
		welcomePage.openPage();

		LoginSharpIdPage loginPage = welcomePage.loginBySharId();

		// enter credentials
		loginPage.negativelogin(sharpID, password);

		// wait for error message
		loginPage.waitForErrorMessage();
		String actualErrorMessage = loginPage.getErrorMessageText();

		// Verification
		// error message
		softAssert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"actualMessage does not contain expectedMessage\nexpectedMessage: " + expectedErrorMessage
						+ "\nactualMessage: " + actualErrorMessage + "\n");

		softAssert.assertAll();
	}
}
