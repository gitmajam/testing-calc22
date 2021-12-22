package com.tribu.qaselenium.tests.mazaprendo;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.function.BiFunction;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.pages.mazaprendo.MAContentListP;
import com.tribu.qaselenium.pages.mazaprendo.MACourseP;
import com.tribu.qaselenium.pages.mazaprendo.MAHomeP;
import com.tribu.qaselenium.pages.mazaprendo.MALandingP;
import com.tribu.qaselenium.pages.sso.SSOLandingP;
import com.tribu.qaselenium.pages.sso.SSOLoginP;
import com.tribu.qaselenium.testframework.testbase.CsvDataProviders;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

@Listeners(TestsListenerManager.class)
public class MAPerformCourseTests extends TestBase {

	// page variables
	MALandingP maLandingP;
	MAHomeP maHomeP;
	MACourseP maCourseP;

	SSOLandingP ssoLandingP;
	SSOLoginP ssoLoginP;

	// assert variables
	String actualSuccessMessage;

	// content variables

	String sharpId2;
	String password2;
	String expectedMessage1;
	String expectedMessage2;
	String testDescription;
	String userId;
	String email;

	BiFunction<String, String, MAHomeP> maLogin = (s, p) -> {
		//open an url with a delay
		maLandingP = openUrl(MALandingP::new, 2000).get();
		ssoLandingP = maLandingP.getLoginButton().click(SSOLandingP::new).get();
		ssoLoginP = ssoLandingP.getSharpIdButton().click(SSOLoginP::new).get();
		maHomeP = ssoLoginP.getSharpIdField().type(s)
				.getPasswordField().type(p)
				.getLoginButton().click(MAHomeP::new).get();
		return maHomeP;
	};

	@Test(dataProvider = "csvReaderCredentials", dataProviderClass = CsvDataProviders.class, groups = { "smoke",
			"deleteContent" })
	public void performCourse(Method method, Map<String, String> dataList) {
		log.info("deleteMethod");
		SoftAssert softAssert = new SoftAssert();
		sharpId2 = dataList.get("sharpId2");
		password2 = dataList.get("password2");
		expectedMessage2 = "Eliminado";

		/* login */
		maHomeP = maLogin.apply(sharpId2, password2);

		softAssert.assertTrue(maHomeP.getAppLogo().isDisplayed(),
				"[Falla Assert - no encuentra logo");

		maCourseP = maHomeP.getPlayCourseButton().click(MACourseP::new).get();

		/*
		 * // Assertions
		 * softAssert.assertTrue(maContentListP.getActionMessage().contains(
		 * expectedMessage2), "doesn't contain the expected message: \"" +
		 * expectedMessage2 + "\"");
		 */

			softAssert.assertAll();
		}
	}
