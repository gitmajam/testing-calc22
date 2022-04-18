package com.tribu.qaselenium.tests.b22;

import java.lang.reflect.Method;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tribu.qaselenium.pages.b22.B22HomeP;
import com.tribu.qaselenium.pages.b22.B22LandingP;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;


@Listeners(TestsListenerManager.class)
public class B22PreconditionTests extends TestBase {

	@SuppressWarnings("unchecked")
	@Test(groups = { "smoke", "deleteContent" })
	public void preconditions(Method method) {
		SoftAssert softAssert = new SoftAssert();
		// page variables
		B22LandingP b22LandingP;
		B22HomeP b22HomeP;
		
		/* login */
		b22LandingP = openUrl(B22LandingP::new).get();
		b22HomeP = b22LandingP.login(readCredentials("admin"),softAssert).getLogo()
								.assess(softAssert::assertTrue, "main logo is not displayed");

		softAssert.assertAll();
	}
}
