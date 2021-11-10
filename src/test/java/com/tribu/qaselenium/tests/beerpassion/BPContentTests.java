package com.tribu.qaselenium.tests.beerpassion;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.function.BiFunction;

import org.testng.Assert;
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

@Listeners(TestsListenerManager.class)
public class BPContentTests extends TestBase {

	// page variables
	SSOLandingP ssoLandingP;
	SSOLoginP ssoLoginP;
	BPLandingP bpLandingP;
	BPHomeP bpHomeP;
	
	String title;
	String sharpId1;
	String password1;
	String sharpId2;
	String password2;
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

	@Test(dataProvider = "csvReaderMethod", dataProviderClass = CsvDataProviders.class, dependsOnGroups = {
			"loadContent" }, groups = { "smoke", "checkContent" })
	public void checkContent(Method method, Map<String, String> testData) {
		log.info("checkMethod");
		SoftAssert softAssert = new SoftAssert();

		sharpId2 = testData.get("sharpId2");
		password2 = testData.get("password2");
		expectedMessage1 = testData.get("expectedMessage1");
		expectedMessage2 = testData.get("expectedMessage2");
		testDescription = testData.get("testDescription");
		title = testData.get("title");

// login
// bpHomeP = bplogin.apply(sharpId2, password2);

		bpLandingP = openUrlWait(BPLandingP::new).get();
		ssoLandingP = bpLandingP.getLoginButton().click(SSOLandingP::new).get();
		Assert.assertTrue(ssoLandingP.getAbLogo().waitForImage().verifyImage(), "[Falla Assert - no encuentra banner");
		ssoLoginP = ssoLandingP.getSharpIdButton().click(SSOLoginP::new).get();

		/*
		 * bpHomeP = ssoLoginP.getSharpIdField().type(sharpId2)
		 * .getPasswordField().type(password2)
		 * .getLoginButton().click(BPHomeP::new).get();
		 * 
		 * bpHomeP.getBPLogo().waitForImage();;
		 * 
		 * softAssert.assertTrue(bpHomeP.getXpathPartBanner().waitForImage(title).
		 * verifyImage(), "[Falla Assert - no encuentra banner");
		 * 
		 * bpHomeP.getExitButton().click();
		 */
	}

}
