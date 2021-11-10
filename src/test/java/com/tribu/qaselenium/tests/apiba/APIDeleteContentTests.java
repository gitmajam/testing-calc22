package com.tribu.qaselenium.tests.apiba;

import java.lang.reflect.Method;
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
	
	String title;
	String sharpId1;
	String password1;
	String expectedMessage1;
	String expectedMessage2;
	String testDescription;


	BiFunction<String, String, APIHomeP> apiLogin = (s, p) -> {
		apiLandingP = openUrl(APILandingP::new).get();
		apiLoginP = apiLandingP.getLoginButton().click(APILoginP::new).get();
		return apiLoginP.getSharpIdField().type(s).getPasswordField().type(p).getLoginButton().click(APIHomeP::new)
				.get();
	};


	@Test(dataProvider = "csvReaderMapList", dataProviderClass = CsvDataProviders.class, dependsOnGroups = {
			"loadContent" }, groups = { "smoke", "deleteContent" })
	public void deleteContent(Method method, List<Map<String, String>> dataList) {
		log.info("deleteMethod");
		SoftAssert softAssert = new SoftAssert();
		String lastSharpId1 = "";
		String lastPassword1 = "";

		for (Map<String, String> testData : dataList) {
			title = testData.get("title");
			sharpId1 = testData.get("sharpId1");
			password1 = testData.get("password1");
			expectedMessage1 = testData.get("expectedMessage1");
			expectedMessage2 = testData.get("expectedMessage2");
			
			if (!sharpId1.equals(lastSharpId1) || !password1.equals(lastPassword1) ) {
				
				/* login */
				apiHomeP = apiLogin.apply(sharpId1, password1);
				lastSharpId1 = sharpId1;
				lastPassword1 = password1;
				softAssert.assertTrue(apiHomeP.getMenuContentButton().isDisplayed(),
						"[Falla Assert - no encuentra boton de contenido");
			}
			
			log.info("Deleting content = * " + testData.get("contentType") + " *");
			softAssert.assertTrue(apiHomeP.getMenuContentButton().isDisplayed(),
					"[Falla Assert - no encuentra boton de contenido");

			apiContentListP = apiHomeP.getMenuContentButton().click(APIContentListP::new).get();

			apiContentListP.getTitlefilterField().type(title + this.getTodaysDate())
			.getActionSelect().click()
			.getActionDeleteItem().click()
			.getActionSelect().click()
			.getfilterButton().click()
			.getSelectItemCheck().click()
			.getApplyAction().click()
			.getDeleteButton().click();

			// Assertions
			softAssert.assertTrue(apiContentListP.getActionMessage().contains(expectedMessage2),
					"doesn't contain the expected message: \"" + expectedMessage2 + "\"");
			softAssert.assertAll();
		}
	}

}
