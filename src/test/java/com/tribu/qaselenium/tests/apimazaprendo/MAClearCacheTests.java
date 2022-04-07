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

	@SuppressWarnings("unchecked")
	@Test(groups = { "smoke" })
	public void clearCacheDrupal(Method method, ITestContext testContext) {
		SoftAssert softAssert = new SoftAssert();
		
		// page variables
		MALandingP maLandingP;
		MAHomeP maHomeP;
		MAConfigurationP maConfigurationP;

		/* login */
		maLandingP = openUrl(MALandingP::new, 3000).get();
		maHomeP = maLandingP.login(readCredentials("admin")).getAppLogo().assertExist(softAssert::assertTrue);

		// remove from api drupal
		maConfigurationP = maHomeP.getMenuConfigurationButton().click(MAConfigurationP::new).get();
		maConfigurationP.getPerformance().click()
						.getClearCache().click()
						.getEmptyCacheAlert(e->e.getText().contains("vaciadas")).assertExist(softAssert::assertTrue)
						.exec(softAssert::assertAll);
	}
}
