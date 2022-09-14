package com.tribu.qaselenium.tests.app;

import java.lang.reflect.Method;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tribu.qaselenium.pages.app.HomeP;
import com.tribu.qaselenium.pages.app.LandingP;
import com.tribu.qaselenium.pages.app.TargetsP;
import com.tribu.qaselenium.pages.app.UnmappedP;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

@Listeners(TestsListenerManager.class)
public class UnmappedTests extends TestBase {

	@SuppressWarnings("unchecked")
	@Test(groups = { "smoke" })
	public void unmapped(Method method) {
		// page variables
		LandingP b22LandingP;
		HomeP b22HomeP;
		TargetsP b22TargetsP;
		UnmappedP b22UnmappedP;

		/* login */
		b22LandingP = openUrl(LandingP::new).get();
		b22HomeP = b22LandingP.login(readCredentials("admin"))
					.getLogo().assess(WebElement::isDisplayed,"main logo is not displayed");
		b22UnmappedP = b22HomeP.getAppBusy().waitForNotPresence()
								.getUnmapped().click(UnmappedP::new).get();
		
		b22UnmappedP.getAppBusy().waitForNotPresence()
					.getUnmappedTable()
//					.resetUnmapped()
					.fillUnmapped()
					.getSaveButton().assess(WebElement::isEnabled,"save button is not enabled").click()
					.getAppBusy().waitForNotPresence()
					.getRespModal().assess(WebElement::isDisplayed,"success modal is not displayed")
					.getCloseButton().printWebElement().click()
					.assertAll();
		
	}
}
