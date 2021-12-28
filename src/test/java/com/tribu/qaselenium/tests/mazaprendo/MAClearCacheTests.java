package com.tribu.qaselenium.tests.mazaprendo;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.function.BiFunction;

import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.pages.mazaprendo.MAConfigurationP;
import com.tribu.qaselenium.pages.mazaprendo.MAHomeP;
import com.tribu.qaselenium.pages.mazaprendo.MALandingP;
import com.tribu.qaselenium.pages.sso.SSOLandingP;
import com.tribu.qaselenium.pages.sso.SSOLoginP;
import com.tribu.qaselenium.testframework.testbase.CsvDataProviders;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

@Listeners(TestsListenerManager.class)
public class MAClearCacheTests extends TestBase {

	// page variables
	MALandingP maLandingP;
	MAHomeP maHomeP;
	MAConfigurationP maConfigurationP;

	SSOLandingP ssoLandingP;
	SSOLoginP ssoLoginP;

	// assert variables
	String actualSuccessMessage;

	BiFunction<String, String, MAHomeP> maLogin = (s, p) -> {
		// open an url with a delay
		maLandingP = openUrl(MALandingP::new, 2000).get();
		ssoLandingP = maLandingP.getLoginButton().click(SSOLandingP::new).get();
		ssoLoginP = ssoLandingP.getSharpIdButton().click(SSOLoginP::new).get();
		maHomeP = ssoLoginP.getSharpIdField().type(s).getPasswordField().type(p).getLoginButton().click(MAHomeP::new)
				.get();
		return maHomeP;
	};

	@Test(dataProvider = "csvReaderCredentials", dataProviderClass = CsvDataProviders.class, groups = { "smoke" })
	public void clearCacheDrupal(Method method, Map<String, String> testData, ITestContext testContext) {

		log.info("preRegisterMethod");
		SoftAssert softAssert = new SoftAssert();

		// content variables
		String sharpId1 = testData.get("sharpId1");
		String password1 = testData.get("password1");

		/* login */
		maHomeP = maLogin.apply(sharpId1, password1);

		// remove from api drupal
		maConfigurationP = maHomeP.getMenuConfigurationButton().click(MAConfigurationP::new).get();
		maConfigurationP.getPerformance().click()
						.getClearCache().click();

		softAssert.assertTrue(maConfigurationP.getEmptyCacheAlert().getText().contains("vaciadas"));

		softAssert.assertAll();
	}
}
