package com.tribu.qaselenium.tests.apimazaprendo;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.pages.mazaprendo.MAConfigurationP;
import com.tribu.qaselenium.pages.mazaprendo.MAHomeP;
import com.tribu.qaselenium.pages.mazaprendo.MALandingP;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

@Listeners(TestsListenerManager.class)
public class MAClearCacheTests extends TestBase {

	@Test(groups = { "smoke" })
	public void clearCacheDrupal(Method method, ITestContext testContext) {
		SoftAssert softAssert = new SoftAssert();
		
		// page variables
		MALandingP maLandingP;
		MAHomeP maHomeP;
		MAConfigurationP maConfigurationP;

		// read csv credentials file depends on environment
		Map<String, String> dataMap = readCredentials();

		/* login */
		maLandingP = openUrl(MALandingP::new, 2000).get();
		maHomeP = maLandingP.login(dataMap.get("sharpId1"), dataMap.get("password1"));

		softAssert.assertTrue(maHomeP.getMenuContentButton().isDisplayed(),
				"Falla Assert login - no encuentra boton de contenido");

		// remove from api drupal
		maConfigurationP = maHomeP.getMenuConfigurationButton().click(MAConfigurationP::new).get();
		maConfigurationP.getPerformance().click()
						.getClearCache().click();

		softAssert.assertTrue(maConfigurationP.getEmptyCacheAlert().getText().contains("vaciadas"));

		softAssert.assertAll();
	}
}
