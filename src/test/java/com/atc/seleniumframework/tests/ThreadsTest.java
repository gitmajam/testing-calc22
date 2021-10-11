
package com.atc.seleniumframework.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.atc.seleniumframework.pages.SSOLandingPage;
import com.atc.seleniumframework.testbase.CsvDataProviders;
import com.atc.seleniumframework.testbase.TestBase;
import com.atc.seleniumframework.testbase.TestUtilities;

public class ThreadsTest extends TestUtilities {

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void threadsTest(Map<String, String> testData) {

		// Data
		String no = testData.get("no");
		String sharpID = testData.get("sharpID");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedMessage");
		String description = testData.get("description");
		
		//driver = factory.createDriver();
		
		log.info("@Test recibe el driver#: " + driver.hashCode());

		/// open main page
		SSOLandingPage welcomePage = new SSOLandingPage(factory.getDriver(), log);
		welcomePage.openPage();

	}

}