package com.tribu.qaselenium.tests.apiba;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.pages.apiba.APIContentListP;
import com.tribu.qaselenium.pages.apiba.APIHomeP;
import com.tribu.qaselenium.pages.apiba.APILandingP;
import com.tribu.qaselenium.pages.apiba.APILoginP;
import com.tribu.qaselenium.pages.sso.SSOLandingP;
import com.tribu.qaselenium.pages.sso.SSOLoginP;
import com.tribu.qaselenium.testframework.testbase.CsvDataProviders;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

@Listeners(TestsListenerManager.class)
public class APIDeleteContentTests extends TestBase {

	// page variables
	APILandingP apiLandingP;
	APILoginP apiLoginP;
	APIHomeP apiHomeP;
	APIContentListP apiContentListP;

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

	BiFunction<String, String, APIHomeP> apiLogin = (s, p) -> {
		apiLandingP = openUrl(APILandingP::new).get();
		apiLoginP = apiLandingP.getLoginButton().click(APILoginP::new).get();
		return apiLoginP.getSharpIdField().type(s).getPasswordField().type(p).getLoginButton().click(APIHomeP::new)
				.get();
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
		apiHomeP = apiLogin.apply(sharpId1, password1);

		softAssert.assertTrue(apiHomeP.getMenuContentButton().isDisplayed(),
				"[Falla Assert - no encuentra boton de contenido");

			apiContentListP = apiHomeP.getMenuContentButton().click(APIContentListP::new).get();

			apiContentListP.getTitlefilterField().type(this.getTodaysDate() + "-")
			.getActionSelect().click()
			.getActionDeleteItem().click()
			.getActionSelect().click()
			.getfilterButton().click()
			.getSelectAllCheck().click()
			.getApplyAction().click()
			.getDeleteButton().click();

			// Assertions
			softAssert.assertTrue(apiContentListP.getActionMessage().contains(expectedMessage2),
					"doesn't contain the expected message: \"" + expectedMessage2 + "\"");

			softAssert.assertAll();
		}
	}
