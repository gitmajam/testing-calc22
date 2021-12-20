package com.tribu.qaselenium.tests.mazaprendo;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.function.BiFunction;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.pages.mazaprendo.MAContentListP;
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
	MAContentListP maContentListP;

	SSOLandingP ssoLandingP;
	SSOLoginP ssoLoginP;

	// assert variables
	String actualSuccessMessage;

	// content variables

	String sharpId1;
	String password1;
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
	public void deleteContent(Method method, Map<String, String> dataList) {
		log.info("deleteMethod");
		SoftAssert softAssert = new SoftAssert();
		sharpId1 = dataList.get("sharpId1");
		password1 = dataList.get("password1");
		expectedMessage2 = "Eliminado";

		/* login */
		maHomeP = maLogin.apply(sharpId1, password1);

		softAssert.assertTrue(maHomeP.getMenuContentButton().isDisplayed(),
				"[Falla Assert - no encuentra boton de contenido");

			maContentListP = maHomeP.getMenuContentButton().click(MAContentListP::new).get();

			maContentListP.getTitlefilterField().type(this.getTodaysDate() + "-")
			.getActionSelect().click()
			.getActionDeleteItem().click()
			.getActionSelect().click()
			.getfilterButton().click()
			.getSelectAllCheck().click()
			.getApplyAction().click()
			.getDeleteButton().click();

			// Assertions
			softAssert.assertTrue(maContentListP.getActionMessage().contains(expectedMessage2),
					"doesn't contain the expected message: \"" + expectedMessage2 + "\"");

			softAssert.assertAll();
		}
	}
