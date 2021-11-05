package com.tribu.qaselenium.tests.beerpassion;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.function.BiFunction;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.pages.beerpassion.BPHomeP;
import com.tribu.qaselenium.pages.beerpassion.BPLandingP;
import com.tribu.qaselenium.pages.sso.SSOLandingP;
import com.tribu.qaselenium.pages.sso.SSOLoginP;
import com.tribu.qaselenium.testframework.testbase.CsvDataProviders;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

import jdk.internal.org.jline.utils.Log;

@Listeners(TestsListenerManager.class)
public class BPSessionTests extends TestBase {

	// page variables
	SSOLandingP ssoLandingP;
	SSOLoginP ssoLoginP;
	BPLandingP bpLandingP;
	BPHomeP bpHomeP;

	String sharpID;
	String password;
	String expectedMessage1;
	String expectedMessage2;
	String testDescription;
	String imgName;

	BiFunction<String, String, BPHomeP> bplogin = (s, p) -> {
		bpLandingP = openUrl(BPLandingP::new).get();
		ssoLandingP = bpLandingP.getLoginButton().click(SSOLandingP::new).get();
		ssoLoginP = ssoLandingP.getSharpIdButton().click(SSOLoginP::new).get();

		return ssoLoginP.getSharpIdField().type(s).getPasswordField().type(p).getLoginButton().click(BPHomeP::new)
				.get();
	};

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void checkBanner(Method method, Map<String, String> testData) {
		SoftAssert softAssert = new SoftAssert();

		sharpID = testData.get("sharpID");
		password = testData.get("password");
		expectedMessage1 = testData.get("expectedMessage1");
		expectedMessage2 = testData.get("expectedMessage2");
		testDescription = testData.get("testDescription");
		imgName = testData.get("imgName");

		// login
		bpHomeP = bplogin.apply(sharpID, password);
		bpHomeP.getBPLogo().waitForImage();

		softAssert.assertTrue(bpHomeP.getHomeButton().isDisplayed(), "[Falla Assert - no encuentra boton de home");
		softAssert.assertTrue(bpHomeP.getExitButton().isDisplayed(), "[Falla Assert - no encuentra boton de exit");
		softAssert.assertTrue(bpHomeP.getMenuButton().isDisplayed(), "[Falla Assert - no encuentra boton de menu");
		softAssert.assertTrue(bpHomeP.getNotificationButton().isDisplayed(),
				"[Falla Assert - no encuentra boton de notificacion");
		softAssert.assertTrue(bpHomeP.getSupportButton().isDisplayed(),
				"[Falla Assert - no encuentra boton de soporte");
		softAssert.assertTrue(bpHomeP.getProfileButton().waitForImage().isDisplayed(), "[Falla Assert - no encuentra boton de perfil");
		softAssert.assertTrue(bpHomeP.getTermsConditions().isDisplayed(),
				"[Falla Assert - no encuentra boton de terminos y condiciones");
		softAssert.assertTrue(bpHomeP.getBPLogo().isDisplayed(), "[Falla Assert - no encuentra logo");
		softAssert.assertTrue(bpHomeP.getXpathPartBanner().waitForImage(imgName).isDisplayed(), "[Falla Assert - no encuentra banner");
		softAssert.assertAll();
		
		bpHomeP.getExitButton().click();
		
	}
}