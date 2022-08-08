package com.tribu.qaselenium.tests.b22;

import java.lang.reflect.Method;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tribu.qaselenium.pages.b22.B22HomeP;
import com.tribu.qaselenium.pages.b22.B22LandingP;
import com.tribu.qaselenium.pages.b22.B22TargetsP;
import com.tribu.qaselenium.pages.b22.B22UnmappedP;
import com.tribu.qaselenium.testframework.testbase.TestBase;
import com.tribu.qaselenium.testframework.testbase.TestsListenerManager;

@Listeners(TestsListenerManager.class)
public class B22UnmappedTests extends TestBase {

	@SuppressWarnings("unchecked")
	@Test(groups = { "smoke" })
	public void unmapped(Method method) {
		// page variables
		B22LandingP b22LandingP;
		B22HomeP b22HomeP;
		B22TargetsP b22TargetsP;
		B22UnmappedP b22UnmappedP;

		/* login */
		b22LandingP = openUrl(B22LandingP::new).get();
		b22HomeP = b22LandingP.login(readCredentials("admin"))
					.getLogo().assess(WebElement::isDisplayed,"main logo is not displayed");
		b22UnmappedP = b22HomeP.getAppBusy().waitForNotPresence()
								.getUnmapped().click(B22UnmappedP::new).get();
		
		b22UnmappedP.getAppBusy().waitForNotPresence()
					.getUnmappedTable()
					.fillUnmapped()
					.getSaveButton().assess(WebElement::isEnabled,"save button is not enabled").click()
					.getAppBusy().waitForNotPresence()
					.getRespModal().assess(WebElement::isDisplayed,"success modal is not displayed")
					.getCloseButton().printWebElement().click()
					.assertAll();
		
	}
}
