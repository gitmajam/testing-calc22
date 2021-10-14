
package com.tribu.seleniumframework.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.tribu.seleniumframework.pages.SSOLandingPage;
import com.tribu.seleniumframework.testbase.CsvDataProviders;
import com.tribu.seleniumframework.testbase.TestBase;
import com.tribu.seleniumframework.testbase.TestUtilities;

public class ThreadsTest extends TestBase {

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void threadsTest(Map<String, String> testData) {

		// Data
		String no = testData.get("no");
		String sharpID = testData.get("sharpID");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("expectedMessage");
		String description = testData.get("description");
		
		//driver = factory.createDriver();
		
		log.info("@Test recibe el driver#: " + factory.getDriver().hashCode());

		/// open main page
		SSOLandingPage welcomePage = new SSOLandingPage(log);
		welcomePage.openPage(factory.getDriver());

	}

}